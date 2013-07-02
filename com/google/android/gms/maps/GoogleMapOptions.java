package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.internal.ae;
import com.google.android.gms.internal.ci;
import com.google.android.gms.internal.cj;
import com.google.android.gms.internal.cx;
import com.google.android.gms.maps.model.CameraPosition;
/* loaded from: classes.dex */
public final class GoogleMapOptions implements ae {
    public static final GoogleMapOptionsCreator a = new GoogleMapOptionsCreator();
    private final int b;
    private Boolean c;
    private Boolean d;
    private int e;
    private CameraPosition f;
    private Boolean g;
    private Boolean h;
    private Boolean i;
    private Boolean j;
    private Boolean k;
    private Boolean l;

    public GoogleMapOptions() {
        this.e = -1;
        this.b = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleMapOptions(int i, byte b, byte b2, int i2, CameraPosition cameraPosition, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8) {
        this.e = -1;
        this.b = i;
        this.c = cj.a(b);
        this.d = cj.a(b2);
        this.e = i2;
        this.f = cameraPosition;
        this.g = cj.a(b3);
        this.h = cj.a(b4);
        this.i = cj.a(b5);
        this.j = cj.a(b6);
        this.k = cj.a(b7);
        this.l = cj.a(b8);
    }

    public static GoogleMapOptions a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(0)) {
            googleMapOptions.a(obtainAttributes.getInt(0, -1));
        }
        if (obtainAttributes.hasValue(13)) {
            googleMapOptions.a(obtainAttributes.getBoolean(13, false));
        }
        if (obtainAttributes.hasValue(12)) {
            googleMapOptions.b(obtainAttributes.getBoolean(12, false));
        }
        if (obtainAttributes.hasValue(6)) {
            googleMapOptions.d(obtainAttributes.getBoolean(6, true));
        }
        if (obtainAttributes.hasValue(7)) {
            googleMapOptions.h(obtainAttributes.getBoolean(7, true));
        }
        if (obtainAttributes.hasValue(8)) {
            googleMapOptions.e(obtainAttributes.getBoolean(8, true));
        }
        if (obtainAttributes.hasValue(9)) {
            googleMapOptions.g(obtainAttributes.getBoolean(9, true));
        }
        if (obtainAttributes.hasValue(11)) {
            googleMapOptions.f(obtainAttributes.getBoolean(11, true));
        }
        if (obtainAttributes.hasValue(10)) {
            googleMapOptions.c(obtainAttributes.getBoolean(10, true));
        }
        googleMapOptions.a(CameraPosition.a(context, attributeSet));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    public int a() {
        return this.b;
    }

    public GoogleMapOptions a(int i) {
        this.e = i;
        return this;
    }

    public GoogleMapOptions a(CameraPosition cameraPosition) {
        this.f = cameraPosition;
        return this;
    }

    public GoogleMapOptions a(boolean z) {
        this.c = Boolean.valueOf(z);
        return this;
    }

    public byte b() {
        return cj.a(this.c);
    }

    public GoogleMapOptions b(boolean z) {
        this.d = Boolean.valueOf(z);
        return this;
    }

    public byte c() {
        return cj.a(this.d);
    }

    public GoogleMapOptions c(boolean z) {
        this.g = Boolean.valueOf(z);
        return this;
    }

    public byte d() {
        return cj.a(this.g);
    }

    public GoogleMapOptions d(boolean z) {
        this.h = Boolean.valueOf(z);
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte e() {
        return cj.a(this.h);
    }

    public GoogleMapOptions e(boolean z) {
        this.i = Boolean.valueOf(z);
        return this;
    }

    public byte f() {
        return cj.a(this.i);
    }

    public GoogleMapOptions f(boolean z) {
        this.j = Boolean.valueOf(z);
        return this;
    }

    public byte g() {
        return cj.a(this.j);
    }

    public GoogleMapOptions g(boolean z) {
        this.k = Boolean.valueOf(z);
        return this;
    }

    public byte h() {
        return cj.a(this.k);
    }

    public GoogleMapOptions h(boolean z) {
        this.l = Boolean.valueOf(z);
        return this;
    }

    public byte i() {
        return cj.a(this.l);
    }

    public int j() {
        return this.e;
    }

    public CameraPosition k() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (cx.a()) {
            ci.a(this, parcel, i);
        } else {
            GoogleMapOptionsCreator.a(this, parcel, i);
        }
    }
}
