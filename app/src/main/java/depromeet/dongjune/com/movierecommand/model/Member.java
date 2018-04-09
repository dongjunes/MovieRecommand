package depromeet.dongjune.com.movierecommand.model;

import java.sql.Timestamp;

public class Member {
    // 고유 ID
    private String uid;

    // 닉네임
    private String nickname;

    // 성별
    private String gender;

    // 나이대
    private String ageRange;

    // 가입날짜
    private Timestamp joinDate;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public Timestamp getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Timestamp joinDate) {
        this.joinDate = joinDate;
    }

    // Member 모델 복사
    public void CopyData(Member param) {
        this.uid = param.getUid();
        this.nickname = param.getNickname();
        this.gender = param.getGender();
        this.ageRange = param.getAgeRange();
        this.joinDate = param.getJoinDate();
    }
}
