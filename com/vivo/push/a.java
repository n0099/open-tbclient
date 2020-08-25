package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public final class a {
    private Bundle a;
    private String b;
    private String c;

    public a(String str, String str2, Bundle bundle) {
        this.b = str;
        this.c = str2;
        this.a = bundle;
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
        if (this.a == null) {
            this.a = new Bundle();
        }
        this.a.putInt(str, i);
    }

    public final void a(String str, long j) {
        if (this.a == null) {
            this.a = new Bundle();
        }
        this.a.putLong(str, j);
    }

    public final void a(String str, String str2) {
        if (this.a == null) {
            this.a = new Bundle();
        }
        this.a.putString(str, str2);
    }

    public final void a(String str, Serializable serializable) {
        if (this.a == null) {
            this.a = new Bundle();
        }
        this.a.putSerializable(str, serializable);
    }

    public final void a(String str, boolean z) {
        if (this.a == null) {
            this.a = new Bundle();
        }
        this.a.putBoolean(str, z);
    }

    public final void a(String str, ArrayList<String> arrayList) {
        if (this.a == null) {
            this.a = new Bundle();
        }
        this.a.putStringArrayList(str, arrayList);
    }

    public final String a(String str) {
        if (this.a == null) {
            return null;
        }
        return this.a.getString(str);
    }

    public final int b(String str, int i) {
        return this.a == null ? i : this.a.getInt(str, i);
    }

    public final ArrayList<String> b(String str) {
        if (this.a == null) {
            return null;
        }
        return this.a.getStringArrayList(str);
    }

    public final long b(String str, long j) {
        return this.a == null ? j : this.a.getLong(str, j);
    }

    public final Serializable c(String str) {
        if (this.a == null) {
            return null;
        }
        return this.a.getSerializable(str);
    }

    public final boolean d(String str) {
        if (this.a == null) {
            return false;
        }
        return this.a.getBoolean(str, false);
    }

    public final String a() {
        return this.b;
    }

    public final Bundle b() {
        return this.a;
    }
}
