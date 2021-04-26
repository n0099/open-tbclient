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
    public int f36051a;

    /* renamed from: b  reason: collision with root package name */
    public int f36052b;

    /* renamed from: c  reason: collision with root package name */
    public int f36053c;

    /* renamed from: d  reason: collision with root package name */
    public int f36054d;

    /* renamed from: e  reason: collision with root package name */
    public int f36055e;

    /* renamed from: f  reason: collision with root package name */
    public String f36056f;

    /* renamed from: g  reason: collision with root package name */
    public String f36057g;

    /* renamed from: h  reason: collision with root package name */
    public String f36058h;

    /* renamed from: i  reason: collision with root package name */
    public int f36059i;
    public int j;

    public HybridADSetting() {
        this.f36051a = 1;
        this.f36052b = 44;
        this.f36053c = -1;
        this.f36054d = -14013133;
        this.f36055e = 16;
        this.f36059i = -1776153;
        this.j = 16;
    }

    public HybridADSetting(Parcel parcel) {
        this.f36051a = 1;
        this.f36052b = 44;
        this.f36053c = -1;
        this.f36054d = -14013133;
        this.f36055e = 16;
        this.f36059i = -1776153;
        this.j = 16;
        this.f36051a = parcel.readInt();
        this.f36052b = parcel.readInt();
        this.f36053c = parcel.readInt();
        this.f36054d = parcel.readInt();
        this.f36055e = parcel.readInt();
        this.f36056f = parcel.readString();
        this.f36057g = parcel.readString();
        this.f36058h = parcel.readString();
        this.f36059i = parcel.readInt();
        this.j = parcel.readInt();
    }

    public HybridADSetting backButtonImage(String str) {
        this.f36057g = str;
        return this;
    }

    public HybridADSetting backSeparatorLength(int i2) {
        this.j = i2;
        return this;
    }

    public HybridADSetting closeButtonImage(String str) {
        this.f36058h = str;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBackButtonImage() {
        return this.f36057g;
    }

    public int getBackSeparatorLength() {
        return this.j;
    }

    public String getCloseButtonImage() {
        return this.f36058h;
    }

    public int getSeparatorColor() {
        return this.f36059i;
    }

    public String getTitle() {
        return this.f36056f;
    }

    public int getTitleBarColor() {
        return this.f36053c;
    }

    public int getTitleBarHeight() {
        return this.f36052b;
    }

    public int getTitleColor() {
        return this.f36054d;
    }

    public int getTitleSize() {
        return this.f36055e;
    }

    public int getType() {
        return this.f36051a;
    }

    public HybridADSetting separatorColor(int i2) {
        this.f36059i = i2;
        return this;
    }

    public HybridADSetting title(String str) {
        this.f36056f = str;
        return this;
    }

    public HybridADSetting titleBarColor(int i2) {
        this.f36053c = i2;
        return this;
    }

    public HybridADSetting titleBarHeight(int i2) {
        this.f36052b = i2;
        return this;
    }

    public HybridADSetting titleColor(int i2) {
        this.f36054d = i2;
        return this;
    }

    public HybridADSetting titleSize(int i2) {
        this.f36055e = i2;
        return this;
    }

    public HybridADSetting type(int i2) {
        this.f36051a = i2;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f36051a);
        parcel.writeInt(this.f36052b);
        parcel.writeInt(this.f36053c);
        parcel.writeInt(this.f36054d);
        parcel.writeInt(this.f36055e);
        parcel.writeString(this.f36056f);
        parcel.writeString(this.f36057g);
        parcel.writeString(this.f36058h);
        parcel.writeInt(this.f36059i);
        parcel.writeInt(this.j);
    }
}
