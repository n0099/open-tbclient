package com.qq.e.ads.hybrid;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes7.dex */
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
    public int f35225a;

    /* renamed from: b  reason: collision with root package name */
    public int f35226b;

    /* renamed from: c  reason: collision with root package name */
    public int f35227c;

    /* renamed from: d  reason: collision with root package name */
    public int f35228d;

    /* renamed from: e  reason: collision with root package name */
    public int f35229e;

    /* renamed from: f  reason: collision with root package name */
    public String f35230f;

    /* renamed from: g  reason: collision with root package name */
    public String f35231g;

    /* renamed from: h  reason: collision with root package name */
    public String f35232h;

    /* renamed from: i  reason: collision with root package name */
    public int f35233i;
    public int j;

    public HybridADSetting() {
        this.f35225a = 1;
        this.f35226b = 44;
        this.f35227c = -1;
        this.f35228d = -14013133;
        this.f35229e = 16;
        this.f35233i = -1776153;
        this.j = 16;
    }

    public HybridADSetting(Parcel parcel) {
        this.f35225a = 1;
        this.f35226b = 44;
        this.f35227c = -1;
        this.f35228d = -14013133;
        this.f35229e = 16;
        this.f35233i = -1776153;
        this.j = 16;
        this.f35225a = parcel.readInt();
        this.f35226b = parcel.readInt();
        this.f35227c = parcel.readInt();
        this.f35228d = parcel.readInt();
        this.f35229e = parcel.readInt();
        this.f35230f = parcel.readString();
        this.f35231g = parcel.readString();
        this.f35232h = parcel.readString();
        this.f35233i = parcel.readInt();
        this.j = parcel.readInt();
    }

    public HybridADSetting backButtonImage(String str) {
        this.f35231g = str;
        return this;
    }

    public HybridADSetting backSeparatorLength(int i2) {
        this.j = i2;
        return this;
    }

    public HybridADSetting closeButtonImage(String str) {
        this.f35232h = str;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBackButtonImage() {
        return this.f35231g;
    }

    public int getBackSeparatorLength() {
        return this.j;
    }

    public String getCloseButtonImage() {
        return this.f35232h;
    }

    public int getSeparatorColor() {
        return this.f35233i;
    }

    public String getTitle() {
        return this.f35230f;
    }

    public int getTitleBarColor() {
        return this.f35227c;
    }

    public int getTitleBarHeight() {
        return this.f35226b;
    }

    public int getTitleColor() {
        return this.f35228d;
    }

    public int getTitleSize() {
        return this.f35229e;
    }

    public int getType() {
        return this.f35225a;
    }

    public HybridADSetting separatorColor(int i2) {
        this.f35233i = i2;
        return this;
    }

    public HybridADSetting title(String str) {
        this.f35230f = str;
        return this;
    }

    public HybridADSetting titleBarColor(int i2) {
        this.f35227c = i2;
        return this;
    }

    public HybridADSetting titleBarHeight(int i2) {
        this.f35226b = i2;
        return this;
    }

    public HybridADSetting titleColor(int i2) {
        this.f35228d = i2;
        return this;
    }

    public HybridADSetting titleSize(int i2) {
        this.f35229e = i2;
        return this;
    }

    public HybridADSetting type(int i2) {
        this.f35225a = i2;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f35225a);
        parcel.writeInt(this.f35226b);
        parcel.writeInt(this.f35227c);
        parcel.writeInt(this.f35228d);
        parcel.writeInt(this.f35229e);
        parcel.writeString(this.f35230f);
        parcel.writeString(this.f35231g);
        parcel.writeString(this.f35232h);
        parcel.writeInt(this.f35233i);
        parcel.writeInt(this.j);
    }
}
