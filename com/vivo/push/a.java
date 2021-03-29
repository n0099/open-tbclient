package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Bundle f39348a;

    /* renamed from: b  reason: collision with root package name */
    public String f39349b;

    /* renamed from: c  reason: collision with root package name */
    public String f39350c;

    public a(String str, String str2, Bundle bundle) {
        this.f39349b = str;
        this.f39350c = str2;
        this.f39348a = bundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a a(Intent intent) {
        String str;
        if (intent == null) {
            com.vivo.push.util.p.a("BundleWapper", "create error : intent is null");
            return null;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            str = extras.getString("client_pkgname");
        }
        str = null;
        if (TextUtils.isEmpty(str)) {
            com.vivo.push.util.p.b("BundleWapper", "create warning: pkgName is null");
        }
        String str2 = intent.getPackage();
        if (TextUtils.isEmpty(str2)) {
            String packageName = intent.getComponent() != null ? intent.getComponent().getPackageName() : null;
            if (TextUtils.isEmpty(packageName)) {
                com.vivo.push.util.p.b("BundleWapper", "create warning: targetPkgName is null");
            }
            str2 = packageName;
        }
        return new a(str, str2, extras);
    }

    public final int b(String str, int i) {
        Bundle bundle = this.f39348a;
        return bundle == null ? i : bundle.getInt(str, i);
    }

    public final Serializable c(String str) {
        Bundle bundle = this.f39348a;
        if (bundle == null) {
            return null;
        }
        return bundle.getSerializable(str);
    }

    public final boolean d(String str) {
        Bundle bundle = this.f39348a;
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean(str, false);
    }

    public final ArrayList<String> b(String str) {
        Bundle bundle = this.f39348a;
        if (bundle == null) {
            return null;
        }
        return bundle.getStringArrayList(str);
    }

    public final long b(String str, long j) {
        Bundle bundle = this.f39348a;
        return bundle == null ? j : bundle.getLong(str, j);
    }

    public final Bundle b() {
        return this.f39348a;
    }

    public final void a(String str, int i) {
        if (this.f39348a == null) {
            this.f39348a = new Bundle();
        }
        this.f39348a.putInt(str, i);
    }

    public final void a(String str, long j) {
        if (this.f39348a == null) {
            this.f39348a = new Bundle();
        }
        this.f39348a.putLong(str, j);
    }

    public final void a(String str, String str2) {
        if (this.f39348a == null) {
            this.f39348a = new Bundle();
        }
        this.f39348a.putString(str, str2);
    }

    public final void a(String str, Serializable serializable) {
        if (this.f39348a == null) {
            this.f39348a = new Bundle();
        }
        this.f39348a.putSerializable(str, serializable);
    }

    public final void a(String str, boolean z) {
        if (this.f39348a == null) {
            this.f39348a = new Bundle();
        }
        this.f39348a.putBoolean(str, z);
    }

    public final void a(String str, ArrayList<String> arrayList) {
        if (this.f39348a == null) {
            this.f39348a = new Bundle();
        }
        this.f39348a.putStringArrayList(str, arrayList);
    }

    public final String a(String str) {
        Bundle bundle = this.f39348a;
        if (bundle == null) {
            return null;
        }
        return bundle.getString(str);
    }

    public final String a() {
        return this.f39349b;
    }
}
