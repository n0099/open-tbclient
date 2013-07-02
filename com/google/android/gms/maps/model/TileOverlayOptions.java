package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ae;
import com.google.android.gms.internal.cx;
import com.google.android.gms.internal.dh;
import com.google.android.gms.internal.dp;
/* loaded from: classes.dex */
public final class TileOverlayOptions implements ae {
    public static final TileOverlayOptionsCreator a = new TileOverlayOptionsCreator();
    private final int b;
    private dp c;
    private TileProvider d;
    private boolean e;
    private float f;

    /* renamed from: com.google.android.gms.maps.model.TileOverlayOptions$2  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends dp.a {
        final /* synthetic */ TileProvider a;

        @Override // com.google.android.gms.internal.dp
        public Tile a(int i, int i2, int i3) {
            return this.a.a(i, i2, i3);
        }
    }

    public TileOverlayOptions() {
        this.e = true;
        this.b = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TileOverlayOptions(int i, IBinder iBinder, boolean z, float f) {
        this.e = true;
        this.b = i;
        this.c = dp.a.a(iBinder);
        this.d = this.c == null ? null : new TileProvider() { // from class: com.google.android.gms.maps.model.TileOverlayOptions.1
            private final dp c;

            {
                this.c = TileOverlayOptions.this.c;
            }

            @Override // com.google.android.gms.maps.model.TileProvider
            public Tile a(int i2, int i3, int i4) {
                try {
                    return this.c.a(i2, i3, i4);
                } catch (RemoteException e) {
                    return null;
                }
            }
        };
        this.e = z;
        this.f = f;
    }

    public int a() {
        return this.b;
    }

    public IBinder b() {
        return this.c.asBinder();
    }

    public float c() {
        return this.f;
    }

    public boolean d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (cx.a()) {
            dh.a(this, parcel, i);
        } else {
            TileOverlayOptionsCreator.a(this, parcel, i);
        }
    }
}
