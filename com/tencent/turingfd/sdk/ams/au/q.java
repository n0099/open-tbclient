package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Parcel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public class q extends o {

    /* renamed from: b  reason: collision with root package name */
    public static final String f13844b = y.a(y.i);

    @Override // com.tencent.turingfd.sdk.ams.au.o
    public String a(IBinder iBinder) throws Exception {
        Signature[] signatureArr;
        String str = null;
        Context a2 = aj.a();
        String packageName = a2.getPackageName();
        try {
            signatureArr = a2.getPackageManager().getPackageInfo(packageName, 64).signatures;
        } catch (Throwable th) {
            signatureArr = null;
        }
        if (signatureArr != null && signatureArr.length > 0) {
            byte[] byteArray = signatureArr[0].toByteArray();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                if (messageDigest != null) {
                    byte[] digest = messageDigest.digest(byteArray);
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : digest) {
                        sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                    }
                    str = sb.toString();
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        String a3 = y.a(y.j);
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f13844b);
            obtain.writeString(packageName);
            obtain.writeString(str);
            obtain.writeString(a3);
            iBinder.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
