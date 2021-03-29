package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.io.File;
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final String f31803a;

    /* renamed from: b  reason: collision with root package name */
    public final String f31804b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31805c;

    /* renamed from: d  reason: collision with root package name */
    public Resources f31806d;

    /* renamed from: e  reason: collision with root package name */
    public ClassLoader f31807e;

    /* renamed from: f  reason: collision with root package name */
    public IKsAdSDK f31808f;

    public j(String str, String str2, String str3) {
        this.f31803a = str;
        this.f31804b = str2;
        this.f31805c = str3;
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
        Resources a2 = o.a(context, context.getResources(), this.f31803a);
        ClassLoader a3 = d.a(context, this.f31803a, this.f31804b, this.f31805c);
        IKsAdSDK a4 = Loader.a(a3);
        this.f31806d = a2;
        this.f31807e = a3;
        this.f31808f = a4;
        int sDKType = a4.getSDKType();
        int i = com.kwad.sdk.api.a.f31746a;
        if (sDKType == i) {
            return;
        }
        throw new RuntimeException("sdkType error apiType: " + i + " , sdkType:" + sDKType);
    }

    private void d() {
        if (TextUtils.isEmpty(this.f31803a)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(this.f31803a);
        if (!file.isFile() || !file.exists()) {
            throw new RuntimeException("mApk not a file");
        }
    }

    public Resources a() {
        return this.f31806d;
    }

    public ClassLoader b() {
        return this.f31807e;
    }

    public IKsAdSDK c() {
        return this.f31808f;
    }

    public String toString() {
        return "ExternalPackage{mApk='" + this.f31803a + "', mDexDir='" + this.f31804b + "', mNativeLibDir='" + this.f31805c + "', mResource=" + this.f31806d + ", mClassLoader=" + this.f31807e + ", mKsSdk=" + this.f31808f + '}';
    }
}
