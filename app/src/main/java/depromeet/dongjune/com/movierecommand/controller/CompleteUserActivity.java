package depromeet.dongjune.com.movierecommand.controller;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.Profile;
import com.squareup.picasso.Picasso;

import depromeet.dongjune.com.movierecommand.R;
import depromeet.dongjune.com.movierecommand.databinding.ActivityCompleteUserBinding;

public class CompleteUserActivity extends AppCompatActivity {

    ActivityCompleteUserBinding binding;
    private Profile profile = Profile.getCurrentProfile();

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
    }

    private void setProfileEmail() {
        binding.userEmail.setText(
                getIntent().getBundleExtra("email_bundle").getString("email"));
    }

}