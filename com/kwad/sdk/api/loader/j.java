package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.io.File;
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final String f32446a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32447b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32448c;

    /* renamed from: d  reason: collision with root package name */
    public Resources f32449d;

    /* renamed from: e  reason: collision with root package name */
    public ClassLoader f32450e;

    /* renamed from: f  reason: collision with root package name */
    public IKsAdSDK f32451f;

    public j(String str, String str2, String str3) {
        this.f32446a = str;
        this.f32447b = str2;
        this.f32448c = str3;
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
        Resources a2 = o.a(context, context.getResources(), this.f32446a);
        ClassLoader a3 = d.a(context, this.f32446a, this.f32447b, this.f32448c);
        IKsAdSDK a4 = Loader.a(a3);
        this.f32449d = a2;
        this.f32450e = a3;
        this.f32451f = a4;
        int sDKType = a4.getSDKType();
        int i2 = com.kwad.sdk.api.a.f32388a;
        if (sDKType == i2) {
            return;
        }
        throw new RuntimeException("sdkType error apiType: " + i2 + " , sdkType:" + sDKType);
    }

    private void d() {
        if (TextUtils.isEmpty(this.f32446a)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(this.f32446a);
        if (!file.isFile() || !file.exists()) {
            throw new RuntimeException("mApk not a file");
        }
    }

    public Resources a() {
        return this.f32449d;
    }

    public ClassLoader b() {
        return this.f32450e;
    }

    public IKsAdSDK c() {
        return this.f32451f;
    }

    public String toString() {
        return "ExternalPackage{mApk='" + this.f32446a + "', mDexDir='" + this.f32447b + "', mNativeLibDir='" + this.f32448c + "', mResource=" + this.f32449d + ", mClassLoader=" + this.f32450e + ", mKsSdk=" + this.f32451f + '}';
    }
}
