package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.internal.ae;
import com.google.android.gms.internal.cx;
import com.google.android.gms.internal.cy;
import com.google.android.gms.internal.w;
import com.google.android.gms.internal.x;
/* loaded from: classes.dex */
public final class CameraPosition implements ae {
    public static final CameraPositionCreator a = new CameraPositionCreator();
    public final LatLng b;
    public final float c;
    public final float d;
    public final float e;
    private final int f;

    /* loaded from: classes.dex */
    public final class Builder {
        private LatLng a;
        private float b;
        private float c;
        private float d;

        public Builder a(float f) {
            this.b = f;
            return this;
        }

        public Builder a(LatLng latLng) {
            this.a = latLng;
            return this;
        }

        public CameraPosition a() {
            return new CameraPosition(this.a, this.b, this.c, this.d);
        }

        public Builder b(float f) {
            this.c = f;
            return this;
        }

        public Builder c(float f) {
            this.d = f;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraPosition(int i, LatLng latLng, float f, float f2, float f3) {
        x.a(latLng, "null camera target");
        x.b(0.0f <= f2 && f2 <= 90.0f, "Tilt needs to be between 0 and 90 inclusive");
        this.f = i;
        this.b = latLng;
        this.c = f;
        this.d = f2 + 0.0f;
        this.e = (((double) f3) <= 0.0d ? (f3 % 360.0f) + 360.0f : f3) % 360.0f;
    }

    public CameraPosition(LatLng latLng, float f, float f2, float f3) {
        this(1, latLng, f, f2, f3);
    }

    public static CameraPosition a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        LatLng latLng = new LatLng(obtainAttributes.hasValue(2) ? obtainAttributes.getFloat(2, 0.0f) : 0.0f, obtainAttributes.hasValue(3) ? obtainAttributes.getFloat(3, 0.0f) : 0.0f);
        Builder b = b();
        b.a(latLng);
        if (obtainAttributes.hasValue(5)) {
            b.a(obtainAttributes.getFloat(5, 0.0f));
        }
        if (obtainAttributes.hasValue(1)) {
            b.c(obtainAttributes.getFloat(1, 0.0f));
        }
        if (obtainAttributes.hasValue(4)) {
            b.b(obtainAttributes.getFloat(4, 0.0f));
        }
        return b.a();
    }

    public static Builder b() {
        return new Builder();
    }

    public int a() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CameraPosition) {
            CameraPosition cameraPosition = (CameraPosition) obj;
            return this.b.equals(cameraPosition.b) && Float.floatToIntBits(this.c) == Float.floatToIntBits(cameraPosition.c) && Float.floatToIntBits(this.d) == Float.floatToIntBits(cameraPosition.d) && Float.floatToIntBits(this.e) == Float.floatToIntBits(cameraPosition.e);
        }
        return false;
    }

    public int hashCode() {
        return w.a(this.b, Float.valueOf(this.c), Float.valueOf(this.d), Float.valueOf(this.e));
    }

    public String toString() {
        return w.a(this).a("target", this.b).a("zoom", Float.valueOf(this.c)).a("tilt", Float.valueOf(this.d)).a("bearing", Float.valueOf(this.e)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (cx.a()) {
            cy.a(this, parcel, i);
        } else {
            CameraPositionCreator.a(this, parcel, i);
        }
    }
}
