package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private Bundle f13858a;

    /* renamed from: b  reason: collision with root package name */
    private String f13859b;
    private String c;

    public a(String str, String str2, Bundle bundle) {
        this.f13859b = str;
        this.c = str2;
        this.f13858a = bundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a a(Intent intent) {
        String str;
        String str2;
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
        String str3 = intent.getPackage();
        if (TextUtils.isEmpty(str3)) {
            str2 = intent.getComponent() != null ? intent.getComponent().getPackageName() : null;
            if (TextUtils.isEmpty(str2)) {
                com.vivo.push.util.p.b("BundleWapper", "create warning: targetPkgName is null");
            }
        } else {
            str2 = str3;
        }
        return new a(str, str2, extras);
    }

    public final void a(String str, int i) {
        if (this.f13858a == null) {
            this.f13858a = new Bundle();
        }
        this.f13858a.putInt(str, i);
    }

    public final void a(String str, long j) {
        if (this.f13858a == null) {
            this.f13858a = new Bundle();
        }
        this.f13858a.putLong(str, j);
    }

    public final void a(String str, String str2) {
        if (this.f13858a == null) {
            this.f13858a = new Bundle();
        }
        this.f13858a.putString(str, str2);
    }

    public final void a(String str, Serializable serializable) {
        if (this.f13858a == null) {
            this.f13858a = new Bundle();
        }
        this.f13858a.putSerializable(str, serializable);
    }

    public final void a(String str, boolean z) {
        if (this.f13858a == null) {
            this.f13858a = new Bundle();
        }
        this.f13858a.putBoolean(str, z);
    }

    public final void a(String str, ArrayList<String> arrayList) {
        if (this.f13858a == null) {
            this.f13858a = new Bundle();
        }
        this.f13858a.putStringArrayList(str, arrayList);
    }

    public final String a(String str) {
        if (this.f13858a == null) {
            return null;
        }
        return this.f13858a.getString(str);
    }

    public final int b(String str, int i) {
        return this.f13858a == null ? i : this.f13858a.getInt(str, i);
    }

    public final ArrayList<String> b(String str) {
        if (this.f13858a == null) {
            return null;
        }
        return this.f13858a.getStringArrayList(str);
    }

    public final long b(String str, long j) {
        return this.f13858a == null ? j : this.f13858a.getLong(str, j);
    }

    public final Serializable c(String str) {
        if (this.f13858a == null) {
            return null;
        }
        return this.f13858a.getSerializable(str);
    }

    public final boolean d(String str) {
        if (this.f13858a == null) {
            return false;
        }
        return this.f13858a.getBoolean(str, false);
    }

    public final String a() {
        return this.f13859b;
    }

    public final Bundle b() {
        return this.f13858a;
    }
}
