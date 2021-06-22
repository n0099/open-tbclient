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
    public int f39002a;

    /* renamed from: b  reason: collision with root package name */
    public int f39003b;

    /* renamed from: c  reason: collision with root package name */
    public int f39004c;

    /* renamed from: d  reason: collision with root package name */
    public int f39005d;

    /* renamed from: e  reason: collision with root package name */
    public int f39006e;

    /* renamed from: f  reason: collision with root package name */
    public String f39007f;

    /* renamed from: g  reason: collision with root package name */
    public String f39008g;

    /* renamed from: h  reason: collision with root package name */
    public String f39009h;

    /* renamed from: i  reason: collision with root package name */
    public int f39010i;
    public int j;

    public HybridADSetting() {
        this.f39002a = 1;
        this.f39003b = 44;
        this.f39004c = -1;
        this.f39005d = -14013133;
        this.f39006e = 16;
        this.f39010i = -1776153;
        this.j = 16;
    }

    public HybridADSetting(Parcel parcel) {
        this.f39002a = 1;
        this.f39003b = 44;
        this.f39004c = -1;
        this.f39005d = -14013133;
        this.f39006e = 16;
        this.f39010i = -1776153;
        this.j = 16;
        this.f39002a = parcel.readInt();
        this.f39003b = parcel.readInt();
        this.f39004c = parcel.readInt();
        this.f39005d = parcel.readInt();
        this.f39006e = parcel.readInt();
        this.f39007f = parcel.readString();
        this.f39008g = parcel.readString();
        this.f39009h = parcel.readString();
        this.f39010i = parcel.readInt();
        this.j = parcel.readInt();
    }

    public HybridADSetting backButtonImage(String str) {
        this.f39008g = str;
        return this;
    }

    public HybridADSetting backSeparatorLength(int i2) {
        this.j = i2;
        return this;
    }

    public HybridADSetting closeButtonImage(String str) {
        this.f39009h = str;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBackButtonImage() {
        return this.f39008g;
    }

    public int getBackSeparatorLength() {
        return this.j;
    }

    public String getCloseButtonImage() {
        return this.f39009h;
    }

    public int getSeparatorColor() {
        return this.f39010i;
    }

    public String getTitle() {
        return this.f39007f;
    }

    public int getTitleBarColor() {
        return this.f39004c;
    }

    public int getTitleBarHeight() {
        return this.f39003b;
    }

    public int getTitleColor() {
        return this.f39005d;
    }

    public int getTitleSize() {
        return this.f39006e;
    }

    public int getType() {
        return this.f39002a;
    }

    public HybridADSetting separatorColor(int i2) {
        this.f39010i = i2;
        return this;
    }

    public HybridADSetting title(String str) {
        this.f39007f = str;
        return this;
    }

    public HybridADSetting titleBarColor(int i2) {
        this.f39004c = i2;
        return this;
    }

    public HybridADSetting titleBarHeight(int i2) {
        this.f39003b = i2;
        return this;
    }

    public HybridADSetting titleColor(int i2) {
        this.f39005d = i2;
        return this;
    }

    public HybridADSetting titleSize(int i2) {
        this.f39006e = i2;
        return this;
    }

    public HybridADSetting type(int i2) {
        this.f39002a = i2;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f39002a);
        parcel.writeInt(this.f39003b);
        parcel.writeInt(this.f39004c);
        parcel.writeInt(this.f39005d);
        parcel.writeInt(this.f39006e);
        parcel.writeString(this.f39007f);
        parcel.writeString(this.f39008g);
        parcel.writeString(this.f39009h);
        parcel.writeInt(this.f39010i);
        parcel.writeInt(this.j);
    }
}
