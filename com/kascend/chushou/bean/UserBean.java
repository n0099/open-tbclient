package com.kascend.chushou.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes5.dex */
public class UserBean implements Parcelable {
    public static final Parcelable.Creator<UserBean> CREATOR = new Parcelable.Creator<UserBean>() { // from class: com.kascend.chushou.bean.UserBean.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserBean createFromParcel(Parcel parcel) {
            return new UserBean(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserBean[] newArray(int i) {
            return new UserBean[i];
        }
    };
    public String avatar;
    public String gender;
    public String gloriouslyUid;
    public String gloriouslyUidColor;
    public String gloriouslyUidMedal;
    public int level;
    public String levelMedal;
    public MetaBean meta;
    public String nickname;
    public int professional;
    public String signature;
    public String uid;

    public UserBean() {
    }

    /* loaded from: classes5.dex */
    public static class MetaBean implements Parcelable {
        public static final Parcelable.Creator<MetaBean> CREATOR = new Parcelable.Creator<MetaBean>() { // from class: com.kascend.chushou.bean.UserBean.MetaBean.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MetaBean createFromParcel(Parcel parcel) {
                return new MetaBean(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MetaBean[] newArray(int i) {
                return new MetaBean[i];
            }
        };
        public List<String> avatarFrame;
        public String nobleMedal;

        protected MetaBean(Parcel parcel) {
            this.avatarFrame = parcel.createStringArrayList();
            this.nobleMedal = parcel.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeStringList(this.avatarFrame);
            parcel.writeString(this.nobleMedal);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }
    }

    protected UserBean(Parcel parcel) {
        this.uid = parcel.readString();
        this.nickname = parcel.readString();
        this.avatar = parcel.readString();
        this.gender = parcel.readString();
        this.signature = parcel.readString();
        this.professional = parcel.readInt();
        this.level = parcel.readInt();
        this.levelMedal = parcel.readString();
        this.meta = (MetaBean) parcel.readParcelable(MetaBean.class.getClassLoader());
        this.gloriouslyUid = parcel.readString();
        this.gloriouslyUidColor = parcel.readString();
        this.gloriouslyUidMedal = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.uid);
        parcel.writeString(this.nickname);
        parcel.writeString(this.avatar);
        parcel.writeString(this.gender);
        parcel.writeString(this.signature);
        parcel.writeInt(this.professional);
        parcel.writeInt(this.level);
        parcel.writeString(this.levelMedal);
        parcel.writeParcelable(this.meta, i);
        parcel.writeString(this.gloriouslyUid);
        parcel.writeString(this.gloriouslyUidColor);
        parcel.writeString(this.gloriouslyUidMedal);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
