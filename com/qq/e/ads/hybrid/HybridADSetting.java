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
    public int f38388a;

    /* renamed from: b  reason: collision with root package name */
    public int f38389b;

    /* renamed from: c  reason: collision with root package name */
    public int f38390c;

    /* renamed from: d  reason: collision with root package name */
    public int f38391d;

    /* renamed from: e  reason: collision with root package name */
    public int f38392e;

    /* renamed from: f  reason: collision with root package name */
    public String f38393f;

    /* renamed from: g  reason: collision with root package name */
    public String f38394g;

    /* renamed from: h  reason: collision with root package name */
    public String f38395h;
    public int i;
    public int j;

    public HybridADSetting() {
        this.f38388a = 1;
        this.f38389b = 44;
        this.f38390c = -1;
        this.f38391d = -14013133;
        this.f38392e = 16;
        this.i = -1776153;
        this.j = 16;
    }

    public HybridADSetting(Parcel parcel) {
        this.f38388a = 1;
        this.f38389b = 44;
        this.f38390c = -1;
        this.f38391d = -14013133;
        this.f38392e = 16;
        this.i = -1776153;
        this.j = 16;
        this.f38388a = parcel.readInt();
        this.f38389b = parcel.readInt();
        this.f38390c = parcel.readInt();
        this.f38391d = parcel.readInt();
        this.f38392e = parcel.readInt();
        this.f38393f = parcel.readString();
        this.f38394g = parcel.readString();
        this.f38395h = parcel.readString();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
    }

    public HybridADSetting backButtonImage(String str) {
        this.f38394g = str;
        return this;
    }

    public HybridADSetting backSeparatorLength(int i) {
        this.j = i;
        return this;
    }

    public HybridADSetting closeButtonImage(String str) {
        this.f38395h = str;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBackButtonImage() {
        return this.f38394g;
    }

    public int getBackSeparatorLength() {
        return this.j;
    }

    public String getCloseButtonImage() {
        return this.f38395h;
    }

    public int getSeparatorColor() {
        return this.i;
    }

    public String getTitle() {
        return this.f38393f;
    }

    public int getTitleBarColor() {
        return this.f38390c;
    }

    public int getTitleBarHeight() {
        return this.f38389b;
    }

    public int getTitleColor() {
        return this.f38391d;
    }

    public int getTitleSize() {
        return this.f38392e;
    }

    public int getType() {
        return this.f38388a;
    }

    public HybridADSetting separatorColor(int i) {
        this.i = i;
        return this;
    }

    public HybridADSetting title(String str) {
        this.f38393f = str;
        return this;
    }

    public HybridADSetting titleBarColor(int i) {
        this.f38390c = i;
        return this;
    }

    public HybridADSetting titleBarHeight(int i) {
        this.f38389b = i;
        return this;
    }

    public HybridADSetting titleColor(int i) {
        this.f38391d = i;
        return this;
    }

    public HybridADSetting titleSize(int i) {
        this.f38392e = i;
        return this;
    }

    public HybridADSetting type(int i) {
        this.f38388a = i;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f38388a);
        parcel.writeInt(this.f38389b);
        parcel.writeInt(this.f38390c);
        parcel.writeInt(this.f38391d);
        parcel.writeInt(this.f38392e);
        parcel.writeString(this.f38393f);
        parcel.writeString(this.f38394g);
        parcel.writeString(this.f38395h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
    }
}
