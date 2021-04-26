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
    public com.fun.openid.sdk.a f31534a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f31535b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f31536c = null;

    /* renamed from: d  reason: collision with root package name */
    public final Object f31537d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f31538e = new a();

    /* loaded from: classes6.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.fun.openid.sdk.a c0343a;
            c cVar = c.this;
            int i2 = a.AbstractBinderC0342a.f31530a;
            if (iBinder == null) {
                c0343a = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
                c0343a = (queryLocalInterface == null || !(queryLocalInterface instanceof com.fun.openid.sdk.a)) ? new a.AbstractBinderC0342a.C0343a(iBinder) : (com.fun.openid.sdk.a) queryLocalInterface;
            }
            cVar.f31534a = c0343a;
            synchronized (c.this.f31537d) {
                c.this.f31537d.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.f31534a = null;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final c f31540a = new c();
    }

    public final String a(Context context, String str) {
        Signature[] signatureArr;
        if (TextUtils.isEmpty(this.f31535b)) {
            this.f31535b = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.f31536c)) {
            String str2 = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(this.f31535b, 64).signatures;
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
            this.f31536c = str2;
        }
        com.fun.openid.sdk.a aVar = this.f31534a;
        String str3 = this.f31535b;
        String str4 = this.f31536c;
        a.AbstractBinderC0342a.C0343a c0343a = (a.AbstractBinderC0342a.C0343a) aVar;
        c0343a.getClass();
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
            obtain.writeString(str3);
            obtain.writeString(str4);
            obtain.writeString(str);
            c0343a.f31531a.transact(1, obtain, obtain2, 0);
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
