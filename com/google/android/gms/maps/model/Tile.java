package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.internal.ae;
import com.google.android.gms.internal.cx;
import com.google.android.gms.internal.dg;
/* loaded from: classes.dex */
public final class Tile implements ae {
    public static final TileCreator a = new TileCreator();
    public final int b;
    public final int c;
    public final byte[] d;
    private final int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tile(int i, int i2, int i3, byte[] bArr) {
        this.e = i;
        this.b = i2;
        this.c = i3;
        this.d = bArr;
    }

    public Tile(int i, int i2, byte[] bArr) {
        this(1, i, i2, bArr);
    }

    public int a() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (cx.a()) {
            dg.a(this, parcel, i);
        } else {
            TileCreator.a(this, parcel, i);
        }
    }
}
