package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private final String f8509a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8510b;
    private final String c;
    private Resources d;
    private ClassLoader e;
    private IKsAdSDK f;

    private j(String str, String str2, String str3) {
        this.f8509a = str;
        this.f8510b = str2;
        this.c = str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized j a(Context context, String str) {
        j jVar;
        synchronized (j.class) {
            try {
                jVar = a(context, g.d(context, str), g.e(context, str), g.f(context, str));
            } catch (Exception e) {
                e.printStackTrace();
                jVar = null;
            }
        }
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
        Resources a2 = o.a(context, context.getResources(), this.f8509a);
        ClassLoader a3 = d.a(context, this.f8509a, this.f8510b, this.c);
        IKsAdSDK a4 = Loader.a(a3);
        this.d = a2;
        this.e = a3;
        this.f = a4;
        int sDKType = a4.getSDKType();
        int i = com.kwad.sdk.api.a.f8473a;
        if (sDKType != i) {
            throw new RuntimeException("sdkType error apiType: " + i + " , sdkType:" + sDKType);
        }
    }

    private void d() {
        if (TextUtils.isEmpty(this.f8509a)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(this.f8509a);
        if (!file.isFile() || !file.exists()) {
            throw new RuntimeException("mApk not a file");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Resources a() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClassLoader b() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IKsAdSDK c() {
        return this.f;
    }

    public String toString() {
        return "ExternalPackage{mApk='" + this.f8509a + "', mDexDir='" + this.f8510b + "', mNativeLibDir='" + this.c + "', mResource=" + this.d + ", mClassLoader=" + this.e + ", mKsSdk=" + this.f + '}';
    }
}
