package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.io.File;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes3.dex */
public class j {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f55448b;

    /* renamed from: c  reason: collision with root package name */
    public final String f55449c;

    /* renamed from: d  reason: collision with root package name */
    public Resources f55450d;

    /* renamed from: e  reason: collision with root package name */
    public ClassLoader f55451e;

    /* renamed from: f  reason: collision with root package name */
    public IKsAdSDK f55452f;

    public j(String str, String str2, String str3) {
        this.a = str;
        this.f55448b = str2;
        this.f55449c = str3;
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
        ClassLoader a2 = d.a(context, this.a, this.f55448b, this.f55449c);
        IKsAdSDK a3 = Loader.a(a2);
        this.f55450d = a;
        this.f55451e = a2;
        this.f55452f = a3;
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
        return this.f55450d;
    }

    public ClassLoader b() {
        return this.f55451e;
    }

    public IKsAdSDK c() {
        return this.f55452f;
    }

    public String toString() {
        return "ExternalPackage{mApk='" + this.a + ExtendedMessageFormat.QUOTE + ", mDexDir='" + this.f55448b + ExtendedMessageFormat.QUOTE + ", mNativeLibDir='" + this.f55449c + ExtendedMessageFormat.QUOTE + ", mResource=" + this.f55450d + ", mClassLoader=" + this.f55451e + ", mKsSdk=" + this.f55452f + ExtendedMessageFormat.END_FE;
    }
}
