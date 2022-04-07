package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.io.File;
/* loaded from: classes5.dex */
public class j {
    public final String a;
    public final String b;
    public final String c;
    public Resources d;
    public ClassLoader e;
    public IKsAdSDK f;

    public j(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public static synchronized j a(Context context, String str) {
        j a;
        synchronized (j.class) {
            try {
                a = a(context, g.d(context, str), g.e(context, str), g.f(context, str));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return a;
    }

    public static j a(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            j jVar = new j(str, str2, str3);
            jVar.a(context);
            return jVar;
        }
        throw new RuntimeException("mApk not a file");
    }

    private void a(Context context) {
        d();
        Resources a = o.a(context, context.getResources(), this.a);
        ClassLoader a2 = d.a(context, this.a, this.b, this.c);
        IKsAdSDK a3 = Loader.a(a2);
        this.d = a;
        this.e = a2;
        this.f = a3;
        int sDKType = a3.getSDKType();
        if (sDKType == 1) {
            return;
        }
        throw new RuntimeException("sdkType error apiType: 1 , sdkType:" + sDKType);
    }

    private void d() {
        if (TextUtils.isEmpty(this.a)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(this.a);
        if (!file.isFile() || !file.exists()) {
            throw new RuntimeException("mApk not a file");
        }
    }

    public Resources a() {
        return this.d;
    }

    public ClassLoader b() {
        return this.e;
    }

    public IKsAdSDK c() {
        return this.f;
    }

    public String toString() {
        return "ExternalPackage{mApk='" + this.a + "', mDexDir='" + this.b + "', mNativeLibDir='" + this.c + "', mResource=" + this.d + ", mClassLoader=" + this.e + ", mKsSdk=" + this.f + '}';
    }
}
