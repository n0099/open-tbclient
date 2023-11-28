package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.io.File;
/* loaded from: classes10.dex */
public final class k {
    public final String alY;
    public final String alZ;
    public final String ama;
    public Resources amb;
    public ClassLoader amc;
    public IKsAdSDK amd;

    public k(String str, String str2, String str3) {
        this.alY = str;
        this.alZ = str2;
        this.ama = str3;
    }

    public static synchronized k a(Context context, ClassLoader classLoader, String str) {
        k b;
        synchronized (k.class) {
            try {
                b = b(context, classLoader, h.s(context, str), h.t(context, str), h.u(context, str));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return b;
    }

    private void a(Context context, ClassLoader classLoader) {
        zl();
        Resources a = q.a(context, context.getResources(), this.alY);
        ClassLoader a2 = e.a(context, classLoader, this.alY, this.alZ, this.ama);
        IKsAdSDK a3 = Loader.a(a2);
        this.amb = a;
        this.amc = a2;
        this.amd = a3;
        int sDKType = a3.getSDKType();
        if (sDKType == 1) {
            return;
        }
        throw new RuntimeException("sdkType error apiType: 1 , sdkType:" + sDKType);
    }

    public static k b(Context context, ClassLoader classLoader, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                k kVar = new k(str, str2, str3);
                kVar.a(context, classLoader);
                return kVar;
            }
            throw new RuntimeException("mApk not a file");
        }
        throw new RuntimeException("mApk is null");
    }

    private void zl() {
        if (!TextUtils.isEmpty(this.alY)) {
            File file = new File(this.alY);
            if (file.isFile() && file.exists()) {
                return;
            }
            throw new RuntimeException("mApk not a file");
        }
        throw new RuntimeException("mApk is null");
    }

    public final ClassLoader getClassLoader() {
        return this.amc;
    }

    public final Resources zj() {
        return this.amb;
    }

    public final IKsAdSDK zk() {
        return this.amd;
    }

    public final String toString() {
        return "ExternalPackage{mApk='" + this.alY + "', mDexDir='" + this.alZ + "', mNativeLibDir='" + this.ama + "', mResource=" + this.amb + ", mClassLoader=" + this.amc + ", mKsSdk=" + this.amd + '}';
    }
}
