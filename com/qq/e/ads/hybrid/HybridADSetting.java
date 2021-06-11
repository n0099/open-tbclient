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
    public int f38904a;

    /* renamed from: b  reason: collision with root package name */
    public int f38905b;

    /* renamed from: c  reason: collision with root package name */
    public int f38906c;

    /* renamed from: d  reason: collision with root package name */
    public int f38907d;

    /* renamed from: e  reason: collision with root package name */
    public int f38908e;

    /* renamed from: f  reason: collision with root package name */
    public String f38909f;

    /* renamed from: g  reason: collision with root package name */
    public String f38910g;

    /* renamed from: h  reason: collision with root package name */
    public String f38911h;

    /* renamed from: i  reason: collision with root package name */
    public int f38912i;
    public int j;

    public HybridADSetting() {
        this.f38904a = 1;
        this.f38905b = 44;
        this.f38906c = -1;
        this.f38907d = -14013133;
        this.f38908e = 16;
        this.f38912i = -1776153;
        this.j = 16;
    }

    public HybridADSetting(Parcel parcel) {
        this.f38904a = 1;
        this.f38905b = 44;
        this.f38906c = -1;
        this.f38907d = -14013133;
        this.f38908e = 16;
        this.f38912i = -1776153;
        this.j = 16;
        this.f38904a = parcel.readInt();
        this.f38905b = parcel.readInt();
        this.f38906c = parcel.readInt();
        this.f38907d = parcel.readInt();
        this.f38908e = parcel.readInt();
        this.f38909f = parcel.readString();
        this.f38910g = parcel.readString();
        this.f38911h = parcel.readString();
        this.f38912i = parcel.readInt();
        this.j = parcel.readInt();
    }

    public HybridADSetting backButtonImage(String str) {
        this.f38910g = str;
        return this;
    }

    public HybridADSetting backSeparatorLength(int i2) {
        this.j = i2;
        return this;
    }

    public HybridADSetting closeButtonImage(String str) {
        this.f38911h = str;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBackButtonImage() {
        return this.f38910g;
    }

    public int getBackSeparatorLength() {
        return this.j;
    }

    public String getCloseButtonImage() {
        return this.f38911h;
    }

    public int getSeparatorColor() {
        return this.f38912i;
    }

    public String getTitle() {
        return this.f38909f;
    }

    public int getTitleBarColor() {
        return this.f38906c;
    }

    public int getTitleBarHeight() {
        return this.f38905b;
    }

    public int getTitleColor() {
        return this.f38907d;
    }

    public int getTitleSize() {
        return this.f38908e;
    }

    public int getType() {
        return this.f38904a;
    }

    public HybridADSetting separatorColor(int i2) {
        this.f38912i = i2;
        return this;
    }

    public HybridADSetting title(String str) {
        this.f38909f = str;
        return this;
    }

    public HybridADSetting titleBarColor(int i2) {
        this.f38906c = i2;
        return this;
    }

    public HybridADSetting titleBarHeight(int i2) {
        this.f38905b = i2;
        return this;
    }

    public HybridADSetting titleColor(int i2) {
        this.f38907d = i2;
        return this;
    }

    public HybridADSetting titleSize(int i2) {
        this.f38908e = i2;
        return this;
    }

    public HybridADSetting type(int i2) {
        this.f38904a = i2;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f38904a);
        parcel.writeInt(this.f38905b);
        parcel.writeInt(this.f38906c);
        parcel.writeInt(this.f38907d);
        parcel.writeInt(this.f38908e);
        parcel.writeString(this.f38909f);
        parcel.writeString(this.f38910g);
        parcel.writeString(this.f38911h);
        parcel.writeInt(this.f38912i);
        parcel.writeInt(this.j);
    }
}
