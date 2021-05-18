package com.kwai.sodler.lib.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwai.sodler.lib.j;
import java.io.File;
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public File f34475a;

    /* renamed from: b  reason: collision with root package name */
    public String f34476b;

    /* renamed from: d  reason: collision with root package name */
    public String f34478d;

    /* renamed from: e  reason: collision with root package name */
    public String f34479e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwai.sodler.lib.b.b f34480f;

    /* renamed from: i  reason: collision with root package name */
    public final String f34483i;

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f34482h = new byte[0];

    /* renamed from: g  reason: collision with root package name */
    public boolean f34481g = false;

    /* renamed from: c  reason: collision with root package name */
    public com.kwai.sodler.lib.ext.c f34477c = j.a().b();

    public a(String str) {
        this.f34483i = str;
        this.f34476b = str;
    }

    public a a(@NonNull com.kwai.sodler.lib.b.b bVar) {
        this.f34480f = bVar;
        return this;
    }

    public String a() {
        return this.f34479e;
    }

    public abstract void a(Context context, String str);

    public void a(String str) {
        this.f34479e = str;
    }

    public final void b(String str) {
        this.f34478d = str;
    }

    public final boolean b() {
        boolean z;
        if (this.f34481g) {
            return true;
        }
        synchronized (this.f34482h) {
            z = this.f34481g;
        }
        return z;
    }

    public final String c() {
        return this.f34478d;
    }

    public void c(String str) {
        this.f34476b = str;
    }

    public final void d() {
        if (this.f34481g) {
            return;
        }
        synchronized (this.f34482h) {
            this.f34481g = true;
        }
    }

    public String e() {
        return this.f34483i;
    }

    public String toString() {
        return "Plugin{, ApkPath = '" + this.f34483i + "'}";
    }
}
