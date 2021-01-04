package com.kwai.sodler.lib.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwai.sodler.lib.j;
import java.io.File;
/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected File f11295a;

    /* renamed from: b  reason: collision with root package name */
    protected String f11296b;
    protected String d;
    protected String e;
    protected com.kwai.sodler.lib.b.b f;
    private final String i;
    private final byte[] h = new byte[0];
    private boolean g = false;
    protected com.kwai.sodler.lib.ext.c c = j.a().b();

    public a(String str) {
        this.i = str;
        this.f11296b = str;
    }

    public a a(@NonNull com.kwai.sodler.lib.b.b bVar) {
        this.f = bVar;
        return this;
    }

    public String a() {
        return this.e;
    }

    public abstract void a(Context context, String str);

    public void a(String str) {
        this.e = str;
    }

    public final void b(String str) {
        this.d = str;
    }

    public final boolean b() {
        boolean z;
        if (this.g) {
            return true;
        }
        synchronized (this.h) {
            z = this.g;
        }
        return z;
    }

    public final String c() {
        return this.d;
    }

    public void c(String str) {
        this.f11296b = str;
    }

    public final void d() {
        if (this.g) {
            return;
        }
        synchronized (this.h) {
            this.g = true;
        }
    }

    public String e() {
        return this.i;
    }

    public String toString() {
        return "Plugin{, ApkPath = '" + this.i + "'}";
    }
}
