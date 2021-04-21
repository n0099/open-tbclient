package com.kwai.sodler.lib.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwai.sodler.lib.j;
import java.io.File;
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public File f37508a;

    /* renamed from: b  reason: collision with root package name */
    public String f37509b;

    /* renamed from: d  reason: collision with root package name */
    public String f37511d;

    /* renamed from: e  reason: collision with root package name */
    public String f37512e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwai.sodler.lib.b.b f37513f;
    public final String i;

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f37515h = new byte[0];

    /* renamed from: g  reason: collision with root package name */
    public boolean f37514g = false;

    /* renamed from: c  reason: collision with root package name */
    public com.kwai.sodler.lib.ext.c f37510c = j.a().b();

    public a(String str) {
        this.i = str;
        this.f37509b = str;
    }

    public a a(@NonNull com.kwai.sodler.lib.b.b bVar) {
        this.f37513f = bVar;
        return this;
    }

    public String a() {
        return this.f37512e;
    }

    public abstract void a(Context context, String str);

    public void a(String str) {
        this.f37512e = str;
    }

    public final void b(String str) {
        this.f37511d = str;
    }

    public final boolean b() {
        boolean z;
        if (this.f37514g) {
            return true;
        }
        synchronized (this.f37515h) {
            z = this.f37514g;
        }
        return z;
    }

    public final String c() {
        return this.f37511d;
    }

    public void c(String str) {
        this.f37509b = str;
    }

    public final void d() {
        if (this.f37514g) {
            return;
        }
        synchronized (this.f37515h) {
            this.f37514g = true;
        }
    }

    public String e() {
        return this.i;
    }

    public String toString() {
        return "Plugin{, ApkPath = '" + this.i + "'}";
    }
}
