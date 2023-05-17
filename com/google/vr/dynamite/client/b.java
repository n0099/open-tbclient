package com.google.vr.dynamite.client;

import android.os.IBinder;
import android.os.Parcel;
/* loaded from: classes9.dex */
public final class b extends com.google.a.a.a implements INativeLibraryLoader {
    public b(IBinder iBinder) {
        super(iBinder, "com.google.vr.dynamite.client.INativeLibraryLoader");
    }

    @Override // com.google.vr.dynamite.client.INativeLibraryLoader
    public final int checkVersion(String str) {
        Parcel a = a();
        a.writeString(str);
        Parcel a2 = a(2, a);
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }

    @Override // com.google.vr.dynamite.client.INativeLibraryLoader
    public final long initializeAndLoadNativeLibrary(String str) {
        Parcel a = a();
        a.writeString(str);
        Parcel a2 = a(1, a);
        long readLong = a2.readLong();
        a2.recycle();
        return readLong;
    }
}
