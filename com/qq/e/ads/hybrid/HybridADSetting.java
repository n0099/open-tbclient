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
    public int f38483a;

    /* renamed from: b  reason: collision with root package name */
    public int f38484b;

    /* renamed from: c  reason: collision with root package name */
    public int f38485c;

    /* renamed from: d  reason: collision with root package name */
    public int f38486d;

    /* renamed from: e  reason: collision with root package name */
    public int f38487e;

    /* renamed from: f  reason: collision with root package name */
    public String f38488f;

    /* renamed from: g  reason: collision with root package name */
    public String f38489g;

    /* renamed from: h  reason: collision with root package name */
    public String f38490h;
    public int i;
    public int j;

    public HybridADSetting() {
        this.f38483a = 1;
        this.f38484b = 44;
        this.f38485c = -1;
        this.f38486d = -14013133;
        this.f38487e = 16;
        this.i = -1776153;
        this.j = 16;
    }

    public HybridADSetting(Parcel parcel) {
        this.f38483a = 1;
        this.f38484b = 44;
        this.f38485c = -1;
        this.f38486d = -14013133;
        this.f38487e = 16;
        this.i = -1776153;
        this.j = 16;
        this.f38483a = parcel.readInt();
        this.f38484b = parcel.readInt();
        this.f38485c = parcel.readInt();
        this.f38486d = parcel.readInt();
        this.f38487e = parcel.readInt();
        this.f38488f = parcel.readString();
        this.f38489g = parcel.readString();
        this.f38490h = parcel.readString();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
    }

    public HybridADSetting backButtonImage(String str) {
        this.f38489g = str;
        return this;
    }

    public HybridADSetting backSeparatorLength(int i) {
        this.j = i;
        return this;
    }

    public HybridADSetting closeButtonImage(String str) {
        this.f38490h = str;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBackButtonImage() {
        return this.f38489g;
    }

    public int getBackSeparatorLength() {
        return this.j;
    }

    public String getCloseButtonImage() {
        return this.f38490h;
    }

    public int getSeparatorColor() {
        return this.i;
    }

    public String getTitle() {
        return this.f38488f;
    }

    public int getTitleBarColor() {
        return this.f38485c;
    }

    public int getTitleBarHeight() {
        return this.f38484b;
    }

    public int getTitleColor() {
        return this.f38486d;
    }

    public int getTitleSize() {
        return this.f38487e;
    }

    public int getType() {
        return this.f38483a;
    }

    public HybridADSetting separatorColor(int i) {
        this.i = i;
        return this;
    }

    public HybridADSetting title(String str) {
        this.f38488f = str;
        return this;
    }

    public HybridADSetting titleBarColor(int i) {
        this.f38485c = i;
        return this;
    }

    public HybridADSetting titleBarHeight(int i) {
        this.f38484b = i;
        return this;
    }

    public HybridADSetting titleColor(int i) {
        this.f38486d = i;
        return this;
    }

    public HybridADSetting titleSize(int i) {
        this.f38487e = i;
        return this;
    }

    public HybridADSetting type(int i) {
        this.f38483a = i;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f38483a);
        parcel.writeInt(this.f38484b);
        parcel.writeInt(this.f38485c);
        parcel.writeInt(this.f38486d);
        parcel.writeInt(this.f38487e);
        parcel.writeString(this.f38488f);
        parcel.writeString(this.f38489g);
        parcel.writeString(this.f38490h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
    }
}
