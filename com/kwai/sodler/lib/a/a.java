package com.kwai.sodler.lib.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwai.sodler.lib.j;
import java.io.File;
/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public File f37986a;

    /* renamed from: b  reason: collision with root package name */
    public String f37987b;

    /* renamed from: d  reason: collision with root package name */
    public String f37989d;

    /* renamed from: e  reason: collision with root package name */
    public String f37990e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwai.sodler.lib.b.b f37991f;

    /* renamed from: i  reason: collision with root package name */
    public final String f37994i;

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f37993h = new byte[0];

    /* renamed from: g  reason: collision with root package name */
    public boolean f37992g = false;

    /* renamed from: c  reason: collision with root package name */
    public com.kwai.sodler.lib.ext.c f37988c = j.a().b();

    public a(String str) {
        this.f37994i = str;
        this.f37987b = str;
    }

    public a a(@NonNull com.kwai.sodler.lib.b.b bVar) {
        this.f37991f = bVar;
        return this;
    }

    public String a() {
        return this.f37990e;
    }

    public abstract void a(Context context, String str);

    public void a(String str) {
        this.f37990e = str;
    }

    public final void b(String str) {
        this.f37989d = str;
    }

    public final boolean b() {
        boolean z;
        if (this.f37992g) {
            return true;
        }
        synchronized (this.f37993h) {
            z = this.f37992g;
        }
        return z;
    }

    public final String c() {
        return this.f37989d;
    }

    public void c(String str) {
        this.f37987b = str;
    }

    public final void d() {
        if (this.f37992g) {
            return;
        }
        synchronized (this.f37993h) {
            this.f37992g = true;
        }
    }

    public String e() {
        return this.f37994i;
    }

    public String toString() {
        return "Plugin{, ApkPath = '" + this.f37994i + "'}";
    }
}
