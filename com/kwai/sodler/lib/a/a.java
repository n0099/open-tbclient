package com.kwai.sodler.lib.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwai.sodler.lib.j;
import java.io.File;
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public File f37124a;

    /* renamed from: b  reason: collision with root package name */
    public String f37125b;

    /* renamed from: d  reason: collision with root package name */
    public String f37127d;

    /* renamed from: e  reason: collision with root package name */
    public String f37128e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwai.sodler.lib.b.b f37129f;
    public final String i;

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f37131h = new byte[0];

    /* renamed from: g  reason: collision with root package name */
    public boolean f37130g = false;

    /* renamed from: c  reason: collision with root package name */
    public com.kwai.sodler.lib.ext.c f37126c = j.a().b();

    public a(String str) {
        this.i = str;
        this.f37125b = str;
    }

    public a a(@NonNull com.kwai.sodler.lib.b.b bVar) {
        this.f37129f = bVar;
        return this;
    }

    public String a() {
        return this.f37128e;
    }

    public abstract void a(Context context, String str);

    public void a(String str) {
        this.f37128e = str;
    }

    public final void b(String str) {
        this.f37127d = str;
    }

    public final boolean b() {
        boolean z;
        if (this.f37130g) {
            return true;
        }
        synchronized (this.f37131h) {
            z = this.f37130g;
        }
        return z;
    }

    public final String c() {
        return this.f37127d;
    }

    public void c(String str) {
        this.f37125b = str;
    }

    public final void d() {
        if (this.f37130g) {
            return;
        }
        synchronized (this.f37131h) {
            this.f37130g = true;
        }
    }

    public String e() {
        return this.i;
    }

    public String toString() {
        return "Plugin{, ApkPath = '" + this.i + "'}";
    }
}
