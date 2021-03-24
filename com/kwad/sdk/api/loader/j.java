package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.io.File;
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final String f31802a;

    /* renamed from: b  reason: collision with root package name */
    public final String f31803b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31804c;

    /* renamed from: d  reason: collision with root package name */
    public Resources f31805d;

    /* renamed from: e  reason: collision with root package name */
    public ClassLoader f31806e;

    /* renamed from: f  reason: collision with root package name */
    public IKsAdSDK f31807f;

    public j(String str, String str2, String str3) {
        this.f31802a = str;
        this.f31803b = str2;
        this.f31804c = str3;
    }

    public static synchronized j a(Context context, String str) {
        j a2;
        synchronized (j.class) {
            try {
                a2 = a(context, g.d(context, str), g.e(context, str), g.f(context, str));
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return a2;
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
        Resources a2 = o.a(context, context.getResources(), this.f31802a);
        ClassLoader a3 = d.a(context, this.f31802a, this.f31803b, this.f31804c);
        IKsAdSDK a4 = Loader.a(a3);
        this.f31805d = a2;
        this.f31806e = a3;
        this.f31807f = a4;
        int sDKType = a4.getSDKType();
        int i = com.kwad.sdk.api.a.f31745a;
        if (sDKType == i) {
            return;
        }
        throw new RuntimeException("sdkType error apiType: " + i + " , sdkType:" + sDKType);
    }

    private void d() {
        if (TextUtils.isEmpty(this.f31802a)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(this.f31802a);
        if (!file.isFile() || !file.exists()) {
            throw new RuntimeException("mApk not a file");
        }
    }

    public Resources a() {
        return this.f31805d;
    }

    public ClassLoader b() {
        return this.f31806e;
    }

    public IKsAdSDK c() {
        return this.f31807f;
    }

    public String toString() {
        return "ExternalPackage{mApk='" + this.f31802a + "', mDexDir='" + this.f31803b + "', mNativeLibDir='" + this.f31804c + "', mResource=" + this.f31805d + ", mClassLoader=" + this.f31806e + ", mKsSdk=" + this.f31807f + '}';
    }
}
