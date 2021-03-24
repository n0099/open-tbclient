package com.kwai.sodler.lib.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwai.sodler.lib.j;
import java.io.File;
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public File f37123a;

    /* renamed from: b  reason: collision with root package name */
    public String f37124b;

    /* renamed from: d  reason: collision with root package name */
    public String f37126d;

    /* renamed from: e  reason: collision with root package name */
    public String f37127e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwai.sodler.lib.b.b f37128f;
    public final String i;

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f37130h = new byte[0];

    /* renamed from: g  reason: collision with root package name */
    public boolean f37129g = false;

    /* renamed from: c  reason: collision with root package name */
    public com.kwai.sodler.lib.ext.c f37125c = j.a().b();

    public a(String str) {
        this.i = str;
        this.f37124b = str;
    }

    public a a(@NonNull com.kwai.sodler.lib.b.b bVar) {
        this.f37128f = bVar;
        return this;
    }

    public String a() {
        return this.f37127e;
    }

    public abstract void a(Context context, String str);

    public void a(String str) {
        this.f37127e = str;
    }

    public final void b(String str) {
        this.f37126d = str;
    }

    public final boolean b() {
        boolean z;
        if (this.f37129g) {
            return true;
        }
        synchronized (this.f37130h) {
            z = this.f37129g;
        }
        return z;
    }

    public final String c() {
        return this.f37126d;
    }

    public void c(String str) {
        this.f37124b = str;
    }

    public final void d() {
        if (this.f37129g) {
            return;
        }
        synchronized (this.f37130h) {
            this.f37129g = true;
        }
    }

    public String e() {
        return this.i;
    }

    public String toString() {
        return "Plugin{, ApkPath = '" + this.i + "'}";
    }
}
