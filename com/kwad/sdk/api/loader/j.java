package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.io.File;
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final String f32598a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32599b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32600c;

    /* renamed from: d  reason: collision with root package name */
    public Resources f32601d;

    /* renamed from: e  reason: collision with root package name */
    public ClassLoader f32602e;

    /* renamed from: f  reason: collision with root package name */
    public IKsAdSDK f32603f;

    public j(String str, String str2, String str3) {
        this.f32598a = str;
        this.f32599b = str2;
        this.f32600c = str3;
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
        Resources a2 = o.a(context, context.getResources(), this.f32598a);
        ClassLoader a3 = d.a(context, this.f32598a, this.f32599b, this.f32600c);
        IKsAdSDK a4 = Loader.a(a3);
        this.f32601d = a2;
        this.f32602e = a3;
        this.f32603f = a4;
        int sDKType = a4.getSDKType();
        int i2 = com.kwad.sdk.api.a.f32540a;
        if (sDKType == i2) {
            return;
        }
        throw new RuntimeException("sdkType error apiType: " + i2 + " , sdkType:" + sDKType);
    }

    private void d() {
        if (TextUtils.isEmpty(this.f32598a)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(this.f32598a);
        if (!file.isFile() || !file.exists()) {
            throw new RuntimeException("mApk not a file");
        }
    }

    public Resources a() {
        return this.f32601d;
    }

    public ClassLoader b() {
        return this.f32602e;
    }

    public IKsAdSDK c() {
        return this.f32603f;
    }

    public String toString() {
        return "ExternalPackage{mApk='" + this.f32598a + "', mDexDir='" + this.f32599b + "', mNativeLibDir='" + this.f32600c + "', mResource=" + this.f32601d + ", mClassLoader=" + this.f32602e + ", mKsSdk=" + this.f32603f + '}';
    }
}
