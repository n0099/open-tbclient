package com.kwai.sodler.lib.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwai.sodler.lib.j;
import java.io.File;
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public File f35230a;

    /* renamed from: b  reason: collision with root package name */
    public String f35231b;

    /* renamed from: d  reason: collision with root package name */
    public String f35233d;

    /* renamed from: e  reason: collision with root package name */
    public String f35234e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwai.sodler.lib.b.b f35235f;

    /* renamed from: i  reason: collision with root package name */
    public final String f35238i;

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f35237h = new byte[0];

    /* renamed from: g  reason: collision with root package name */
    public boolean f35236g = false;

    /* renamed from: c  reason: collision with root package name */
    public com.kwai.sodler.lib.ext.c f35232c = j.a().b();

    public a(String str) {
        this.f35238i = str;
        this.f35231b = str;
    }

    public a a(@NonNull com.kwai.sodler.lib.b.b bVar) {
        this.f35235f = bVar;
        return this;
    }

    public String a() {
        return this.f35234e;
    }

    public abstract void a(Context context, String str);

    public void a(String str) {
        this.f35234e = str;
    }

    public final void b(String str) {
        this.f35233d = str;
    }

    public final boolean b() {
        boolean z;
        if (this.f35236g) {
            return true;
        }
        synchronized (this.f35237h) {
            z = this.f35236g;
        }
        return z;
    }

    public final String c() {
        return this.f35233d;
    }

    public void c(String str) {
        this.f35231b = str;
    }

    public final void d() {
        if (this.f35236g) {
            return;
        }
        synchronized (this.f35237h) {
            this.f35236g = true;
        }
    }

    public String e() {
        return this.f35238i;
    }

    public String toString() {
        return "Plugin{, ApkPath = '" + this.f35238i + "'}";
    }
}
