package com.qq.e.ads.hybrid;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes6.dex */
public class HybridADSetting implements Parcelable {
    public static final Parcelable.Creator<HybridADSetting> CREATOR = new Parcelable.Creator<HybridADSetting>() { // from class: com.qq.e.ads.hybrid.HybridADSetting.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HybridADSetting createFromParcel(Parcel parcel) {
            return new HybridADSetting(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HybridADSetting[] newArray(int i2) {
            return new HybridADSetting[i2];
        }
    };
    public static final int TYPE_REWARD_VIDEO = 1;

    /* renamed from: a  reason: collision with root package name */
    public int f35296a;

    /* renamed from: b  reason: collision with root package name */
    public int f35297b;

    /* renamed from: c  reason: collision with root package name */
    public int f35298c;

    /* renamed from: d  reason: collision with root package name */
    public int f35299d;

    /* renamed from: e  reason: collision with root package name */
    public int f35300e;

    /* renamed from: f  reason: collision with root package name */
    public String f35301f;

    /* renamed from: g  reason: collision with root package name */
    public String f35302g;

    /* renamed from: h  reason: collision with root package name */
    public String f35303h;

    /* renamed from: i  reason: collision with root package name */
    public int f35304i;
    public int j;

    public HybridADSetting() {
        this.f35296a = 1;
        this.f35297b = 44;
        this.f35298c = -1;
        this.f35299d = -14013133;
        this.f35300e = 16;
        this.f35304i = -1776153;
        this.j = 16;
    }

    public HybridADSetting(Parcel parcel) {
        this.f35296a = 1;
        this.f35297b = 44;
        this.f35298c = -1;
        this.f35299d = -14013133;
        this.f35300e = 16;
        this.f35304i = -1776153;
        this.j = 16;
        this.f35296a = parcel.readInt();
        this.f35297b = parcel.readInt();
        this.f35298c = parcel.readInt();
        this.f35299d = parcel.readInt();
        this.f35300e = parcel.readInt();
        this.f35301f = parcel.readString();
        this.f35302g = parcel.readString();
        this.f35303h = parcel.readString();
        this.f35304i = parcel.readInt();
        this.j = parcel.readInt();
    }

    public HybridADSetting backButtonImage(String str) {
        this.f35302g = str;
        return this;
    }

    public HybridADSetting backSeparatorLength(int i2) {
        this.j = i2;
        return this;
    }

    public HybridADSetting closeButtonImage(String str) {
        this.f35303h = str;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBackButtonImage() {
        return this.f35302g;
    }

    public int getBackSeparatorLength() {
        return this.j;
    }

    public String getCloseButtonImage() {
        return this.f35303h;
    }

    public int getSeparatorColor() {
        return this.f35304i;
    }

    public String getTitle() {
        return this.f35301f;
    }

    public int getTitleBarColor() {
        return this.f35298c;
    }

    public int getTitleBarHeight() {
        return this.f35297b;
    }

    public int getTitleColor() {
        return this.f35299d;
    }

    public int getTitleSize() {
        return this.f35300e;
    }

    public int getType() {
        return this.f35296a;
    }

    public HybridADSetting separatorColor(int i2) {
        this.f35304i = i2;
        return this;
    }

    public HybridADSetting title(String str) {
        this.f35301f = str;
        return this;
    }

    public HybridADSetting titleBarColor(int i2) {
        this.f35298c = i2;
        return this;
    }

    public HybridADSetting titleBarHeight(int i2) {
        this.f35297b = i2;
        return this;
    }

    public HybridADSetting titleColor(int i2) {
        this.f35299d = i2;
        return this;
    }

    public HybridADSetting titleSize(int i2) {
        this.f35300e = i2;
        return this;
    }

    public HybridADSetting type(int i2) {
        this.f35296a = i2;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f35296a);
        parcel.writeInt(this.f35297b);
        parcel.writeInt(this.f35298c);
        parcel.writeInt(this.f35299d);
        parcel.writeInt(this.f35300e);
        parcel.writeString(this.f35301f);
        parcel.writeString(this.f35302g);
        parcel.writeString(this.f35303h);
        parcel.writeInt(this.f35304i);
        parcel.writeInt(this.j);
    }
}
