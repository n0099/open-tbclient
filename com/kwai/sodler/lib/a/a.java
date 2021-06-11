package com.kwai.sodler.lib.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwai.sodler.lib.j;
import java.io.File;
/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public File f37888a;

    /* renamed from: b  reason: collision with root package name */
    public String f37889b;

    /* renamed from: d  reason: collision with root package name */
    public String f37891d;

    /* renamed from: e  reason: collision with root package name */
    public String f37892e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwai.sodler.lib.b.b f37893f;

    /* renamed from: i  reason: collision with root package name */
    public final String f37896i;

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f37895h = new byte[0];

    /* renamed from: g  reason: collision with root package name */
    public boolean f37894g = false;

    /* renamed from: c  reason: collision with root package name */
    public com.kwai.sodler.lib.ext.c f37890c = j.a().b();

    public a(String str) {
        this.f37896i = str;
        this.f37889b = str;
    }

    public a a(@NonNull com.kwai.sodler.lib.b.b bVar) {
        this.f37893f = bVar;
        return this;
    }

    public String a() {
        return this.f37892e;
    }

    public abstract void a(Context context, String str);

    public void a(String str) {
        this.f37892e = str;
    }

    public final void b(String str) {
        this.f37891d = str;
    }

    public final boolean b() {
        boolean z;
        if (this.f37894g) {
            return true;
        }
        synchronized (this.f37895h) {
            z = this.f37894g;
        }
        return z;
    }

    public final String c() {
        return this.f37891d;
    }

    public void c(String str) {
        this.f37889b = str;
    }

    public final void d() {
        if (this.f37894g) {
            return;
        }
        synchronized (this.f37895h) {
            this.f37894g = true;
        }
    }

    public String e() {
        return this.f37896i;
    }

    public String toString() {
        return "Plugin{, ApkPath = '" + this.f37896i + "'}";
    }
}
