package depromeet.dongjune.com.movierecommand.controller;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.Profile;
import com.squareup.picasso.Picasso;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
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

    public void completeOnClick(View v) {
        ArrayList<String> selectedGenreArray = new ArrayList<>();
        ArrayList<Integer> selectedGenreIntArray = new ArrayList<>();
        Set<Integer> selectedGenreSet = new HashSet<>();
        selectedGenreSet = binding.flowLayout.getSelectedList();
        Integer num = 0;
        for (Iterator i = selectedGenreSet.iterator(); i.hasNext(); ) {
            num = (Integer) i.next();
            selectedGenreIntArray.add(num);
            selectedGenreArray.add(genreStr[num]);
        }
        Log.d("CheckingData", selectedGenreArray + "");
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        i.putExtra("genreSelected", selectedGenreArray);
        i.putExtra("genreSelectedInt", selectedGenreIntArray);

        startActivity(i);
        finish();
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

        binding.nameText.setText(Profile.getCurrentProfile().getName());
        binding.genderText.setText("남성");
    }

    private void setHashTag() {
        final LayoutInflater mInflater = LayoutInflater.from(getApplicationContext());

        binding.flowLayout.setAdapter(new TagAdapter<String>(genreStr) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                Button genre = (Button) mInflater.inflate(R.layout.flowlayout_item, binding.flowLayout, false);
                genre.setText(s);
                genre.setBackground(getResources().getDrawable(R.drawable.box_non_2));

                return genre;
            }

            @Override
            public void onSelected(int position, View view) {
                super.onSelected(position, view);
                Button btn = (Button) view.findViewById(R.id.genre_btn);
                btn.setBackground(getResources().getDrawable(R.drawable.box_full_non_2));
                btn.setTextColor(Color.WHITE);
            }

            @Override
            public void unSelected(int position, View view) {
                super.unSelected(position, view);/*
                Button btn = (Button) view.findViewById(R.id.genre_btn);
                btn.setBackground(getResources().getDrawable(R.drawable.box_non_2));
                btn.setTextColor(Color.BLUE);*/

            }
        });


    }

}
