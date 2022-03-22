package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.io.File;
/* loaded from: classes7.dex */
public class j {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f39117b;

    /* renamed from: c  reason: collision with root package name */
    public final String f39118c;

    /* renamed from: d  reason: collision with root package name */
    public Resources f39119d;

    /* renamed from: e  reason: collision with root package name */
    public ClassLoader f39120e;

    /* renamed from: f  reason: collision with root package name */
    public IKsAdSDK f39121f;

    public j(String str, String str2, String str3) {
        this.a = str;
        this.f39117b = str2;
        this.f39118c = str3;
    }

    public static synchronized j a(Context context, String str) {
        j a;
        synchronized (j.class) {
            try {
                a = a(context, g.d(context, str), g.e(context, str), g.f(context, str));
            } catch (Exception e2) {
                e2.printStackTrace();
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
        ClassLoader a2 = d.a(context, this.a, this.f39117b, this.f39118c);
        IKsAdSDK a3 = Loader.a(a2);
        this.f39119d = a;
        this.f39120e = a2;
        this.f39121f = a3;
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
        return this.f39119d;
    }

    public ClassLoader b() {
        return this.f39120e;
    }

    public IKsAdSDK c() {
        return this.f39121f;
    }

    public String toString() {
        return "ExternalPackage{mApk='" + this.a + "', mDexDir='" + this.f39117b + "', mNativeLibDir='" + this.f39118c + "', mResource=" + this.f39119d + ", mClassLoader=" + this.f39120e + ", mKsSdk=" + this.f39121f + '}';
    }
}
