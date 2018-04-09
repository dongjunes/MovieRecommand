package depromeet.dongjune.com.movierecommand.controller;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.facebook.Profile;
import com.squareup.picasso.Picasso;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;

import java.util.zip.Inflater;

import depromeet.dongjune.com.movierecommand.R;
import depromeet.dongjune.com.movierecommand.databinding.ActivityCompleteUserBinding;

public class CompleteUserActivity extends AppCompatActivity {

    ActivityCompleteUserBinding binding;
    private Profile profile = Profile.getCurrentProfile();
    private String[] genreStr = {"드라마", "판타지", "서부", "공부", "로맨스", "모험", "스릴러", "느와르", "컬트", "다큐멘터리", "코미디", "가족",
            "미스터리", "전쟁", "애니메이션", "범죄", "뮤지컬", "SF", "액션", "무협", "에로", "서스펜스", "서사", "블랙코미디", "실험"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_complete_user);
        setProfileImage();
        setProfileEmail();
    }

    private void setProfileImage() {
        binding.profilePic.setBackground(new ShapeDrawable(new OvalShape()));
        if (Build.VERSION.SDK_INT >= 21) {
            binding.profilePic.setClipToOutline(true);
        }
        String imgLink = profile.getProfilePictureUri(200, 200).toString();
        Picasso.get().load(imgLink).transform(new CircleTransform()).into(binding.profilePic);
        setHashTag();
    }

    private void setProfileEmail() {
        binding.userEmail.setText(
                getIntent().getBundleExtra("email_bundle").getString("email"));

    }

    private void setHashTag() {
        final LayoutInflater mInflater = LayoutInflater.from(getApplicationContext());

        binding.flowLayout.setAdapter(new TagAdapter<String>(genreStr) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView genre = (TextView) mInflater.inflate(R.layout.flowlayout_item, binding.flowLayout, false);
                genre.setText(s);
                Log.d("s", s);
                return genre;
            }

            @Override
            public void onSelected(int position, View view) {
                super.onSelected(position, view);
            }

            @Override
            public void unSelected(int position, View view) {
                super.unSelected(position, view);
            }
        });


    }

}
