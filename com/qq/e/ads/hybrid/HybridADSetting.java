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
        public final HybridADSetting[] newArray(int i) {
            return new HybridADSetting[i];
        }
    };
    public static final int TYPE_REWARD_VIDEO = 1;

    /* renamed from: a  reason: collision with root package name */
    public int f38099a;

    /* renamed from: b  reason: collision with root package name */
    public int f38100b;

    /* renamed from: c  reason: collision with root package name */
    public int f38101c;

    /* renamed from: d  reason: collision with root package name */
    public int f38102d;

    /* renamed from: e  reason: collision with root package name */
    public int f38103e;

    /* renamed from: f  reason: collision with root package name */
    public String f38104f;

    /* renamed from: g  reason: collision with root package name */
    public String f38105g;

    /* renamed from: h  reason: collision with root package name */
    public String f38106h;
    public int i;
    public int j;

    public HybridADSetting() {
        this.f38099a = 1;
        this.f38100b = 44;
        this.f38101c = -1;
        this.f38102d = -14013133;
        this.f38103e = 16;
        this.i = -1776153;
        this.j = 16;
    }

    public HybridADSetting(Parcel parcel) {
        this.f38099a = 1;
        this.f38100b = 44;
        this.f38101c = -1;
        this.f38102d = -14013133;
        this.f38103e = 16;
        this.i = -1776153;
        this.j = 16;
        this.f38099a = parcel.readInt();
        this.f38100b = parcel.readInt();
        this.f38101c = parcel.readInt();
        this.f38102d = parcel.readInt();
        this.f38103e = parcel.readInt();
        this.f38104f = parcel.readString();
        this.f38105g = parcel.readString();
        this.f38106h = parcel.readString();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
    }

    public HybridADSetting backButtonImage(String str) {
        this.f38105g = str;
        return this;
    }

    public HybridADSetting backSeparatorLength(int i) {
        this.j = i;
        return this;
    }

    public HybridADSetting closeButtonImage(String str) {
        this.f38106h = str;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBackButtonImage() {
        return this.f38105g;
    }

    public int getBackSeparatorLength() {
        return this.j;
    }

    public String getCloseButtonImage() {
        return this.f38106h;
    }

    public int getSeparatorColor() {
        return this.i;
    }

    public String getTitle() {
        return this.f38104f;
    }

    public int getTitleBarColor() {
        return this.f38101c;
    }

    public int getTitleBarHeight() {
        return this.f38100b;
    }

    public int getTitleColor() {
        return this.f38102d;
    }

    public int getTitleSize() {
        return this.f38103e;
    }

    public int getType() {
        return this.f38099a;
    }

    public HybridADSetting separatorColor(int i) {
        this.i = i;
        return this;
    }

    public HybridADSetting title(String str) {
        this.f38104f = str;
        return this;
    }

    public HybridADSetting titleBarColor(int i) {
        this.f38101c = i;
        return this;
    }

    public HybridADSetting titleBarHeight(int i) {
        this.f38100b = i;
        return this;
    }

    public HybridADSetting titleColor(int i) {
        this.f38102d = i;
        return this;
    }

    public HybridADSetting titleSize(int i) {
        this.f38103e = i;
        return this;
    }

    public HybridADSetting type(int i) {
        this.f38099a = i;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f38099a);
        parcel.writeInt(this.f38100b);
        parcel.writeInt(this.f38101c);
        parcel.writeInt(this.f38102d);
        parcel.writeInt(this.f38103e);
        parcel.writeString(this.f38104f);
        parcel.writeString(this.f38105g);
        parcel.writeString(this.f38106h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
    }
}
