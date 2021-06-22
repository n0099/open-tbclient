package com.fun.openid.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import com.fun.openid.sdk.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public com.fun.openid.sdk.a f30881a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f30882b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f30883c = null;

    /* renamed from: d  reason: collision with root package name */
    public final Object f30884d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f30885e = new a();

    /* loaded from: classes6.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.fun.openid.sdk.a c0335a;
            c cVar = c.this;
            int i2 = a.AbstractBinderC0334a.f30877a;
            if (iBinder == null) {
                c0335a = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
                c0335a = (queryLocalInterface == null || !(queryLocalInterface instanceof com.fun.openid.sdk.a)) ? new a.AbstractBinderC0334a.C0335a(iBinder) : (com.fun.openid.sdk.a) queryLocalInterface;
            }
            cVar.f30881a = c0335a;
            synchronized (c.this.f30884d) {
                c.this.f30884d.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.f30881a = null;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final c f30887a = new c();
    }

    public final String a(Context context, String str) {
        Signature[] signatureArr;
        if (TextUtils.isEmpty(this.f30882b)) {
            this.f30882b = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.f30883c)) {
            String str2 = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(this.f30882b, 64).signatures;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
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
                        str2 = sb.toString();
                    }
                } catch (NoSuchAlgorithmException e3) {
                    e3.printStackTrace();
                }
            }
            this.f30883c = str2;
        }
        com.fun.openid.sdk.a aVar = this.f30881a;
        String str3 = this.f30882b;
        String str4 = this.f30883c;
        a.AbstractBinderC0334a.C0335a c0335a = (a.AbstractBinderC0334a.C0335a) aVar;
        c0335a.getClass();
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
            obtain.writeString(str3);
            obtain.writeString(str4);
            obtain.writeString(str);
            c0335a.f30878a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            obtain2.recycle();
            obtain.recycle();
            return TextUtils.isEmpty(readString) ? "" : readString;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }
}
