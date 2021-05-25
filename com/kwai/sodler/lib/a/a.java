package com.kwai.sodler.lib.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwai.sodler.lib.j;
import java.io.File;
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public File f34404a;

    /* renamed from: b  reason: collision with root package name */
    public String f34405b;

    /* renamed from: d  reason: collision with root package name */
    public String f34407d;

    /* renamed from: e  reason: collision with root package name */
    public String f34408e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwai.sodler.lib.b.b f34409f;

    /* renamed from: i  reason: collision with root package name */
    public final String f34412i;

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f34411h = new byte[0];

    /* renamed from: g  reason: collision with root package name */
    public boolean f34410g = false;

    /* renamed from: c  reason: collision with root package name */
    public com.kwai.sodler.lib.ext.c f34406c = j.a().b();

    public a(String str) {
        this.f34412i = str;
        this.f34405b = str;
    }

    public a a(@NonNull com.kwai.sodler.lib.b.b bVar) {
        this.f34409f = bVar;
        return this;
    }

    public String a() {
        return this.f34408e;
    }

    public abstract void a(Context context, String str);

    public void a(String str) {
        this.f34408e = str;
    }

    public final void b(String str) {
        this.f34407d = str;
    }

    public final boolean b() {
        boolean z;
        if (this.f34410g) {
            return true;
        }
        synchronized (this.f34411h) {
            z = this.f34410g;
        }
        return z;
    }

    public final String c() {
        return this.f34407d;
    }

    public void c(String str) {
        this.f34405b = str;
    }

    public final void d() {
        if (this.f34410g) {
            return;
        }
        synchronized (this.f34411h) {
            this.f34410g = true;
        }
    }

    public String e() {
        return this.f34412i;
    }

    public String toString() {
        return "Plugin{, ApkPath = '" + this.f34412i + "'}";
    }
}
