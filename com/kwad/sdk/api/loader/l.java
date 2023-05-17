package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.io.File;
/* loaded from: classes9.dex */
public final class l {
    public IKsAdSDK RJ;
    public Resources St;
    public ClassLoader Su;
    public final String d;
    public final String e;
    public final String f;

    public l(String str, String str2, String str3) {
        this.d = str;
        this.e = str2;
        this.f = str3;
    }

    private void a() {
        if (TextUtils.isEmpty(this.d)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(this.d);
        if (!file.isFile() || !file.exists()) {
            throw new RuntimeException("mApk not a file");
        }
    }

    private void a(Context context) {
        a();
        Resources a = r.a(context, context.getResources(), this.d);
        ClassLoader a2 = e.a(context, this.d, this.e, this.f);
        IKsAdSDK a3 = Loader.a(a2);
        this.St = a;
        this.Su = a2;
        this.RJ = a3;
        int sDKType = a3.getSDKType();
        if (sDKType != 1) {
            throw new RuntimeException("sdkType error apiType: 1 , sdkType:".concat(String.valueOf(sDKType)));
        }
    }

    public static l b(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            l lVar = new l(str, str2, str3);
            lVar.a(context);
            return lVar;
        }
        throw new RuntimeException("mApk not a file");
    }

    public static synchronized l p(Context context, String str) {
        l b;
        synchronized (l.class) {
            try {
                b = b(context, h.m(context, str), h.n(context, str), h.o(context, str));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return b;
    }

    public final String toString() {
        return "ExternalPackage{mApk='" + this.d + "', mDexDir='" + this.e + "', mNativeLibDir='" + this.f + "', mResource=" + this.St + ", mClassLoader=" + this.Su + ", mKsSdk=" + this.RJ + '}';
    }
}
