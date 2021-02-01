package com.qq.e.ads.hybrid;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes15.dex */
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
    private int f11463a;

    /* renamed from: b  reason: collision with root package name */
    private int f11464b;
    private int c;
    private int d;
    private int e;
    private String f;
    private String g;
    private String h;
    private int i;
    private int j;

    public HybridADSetting() {
        this.f11463a = 1;
        this.f11464b = 44;
        this.c = -1;
        this.d = -14013133;
        this.e = 16;
        this.i = -1776153;
        this.j = 16;
    }

    protected HybridADSetting(Parcel parcel) {
        this.f11463a = 1;
        this.f11464b = 44;
        this.c = -1;
        this.d = -14013133;
        this.e = 16;
        this.i = -1776153;
        this.j = 16;
        this.f11463a = parcel.readInt();
        this.f11464b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
    }

    public HybridADSetting backButtonImage(String str) {
        this.g = str;
        return this;
    }

    public HybridADSetting backSeparatorLength(int i) {
        this.j = i;
        return this;
    }

    public HybridADSetting closeButtonImage(String str) {
        this.h = str;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBackButtonImage() {
        return this.g;
    }

    public int getBackSeparatorLength() {
        return this.j;
    }

    public String getCloseButtonImage() {
        return this.h;
    }

    public int getSeparatorColor() {
        return this.i;
    }

    public String getTitle() {
        return this.f;
    }

    public int getTitleBarColor() {
        return this.c;
    }

    public int getTitleBarHeight() {
        return this.f11464b;
    }

    public int getTitleColor() {
        return this.d;
    }

    public int getTitleSize() {
        return this.e;
    }

    public int getType() {
        return this.f11463a;
    }

    public HybridADSetting separatorColor(int i) {
        this.i = i;
        return this;
    }

    public HybridADSetting title(String str) {
        this.f = str;
        return this;
    }

    public HybridADSetting titleBarColor(int i) {
        this.c = i;
        return this;
    }

    public HybridADSetting titleBarHeight(int i) {
        this.f11464b = i;
        return this;
    }

    public HybridADSetting titleColor(int i) {
        this.d = i;
        return this;
    }

    public HybridADSetting titleSize(int i) {
        this.e = i;
        return this;
    }

    public HybridADSetting type(int i) {
        this.f11463a = i;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f11463a);
        parcel.writeInt(this.f11464b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
    }
}
