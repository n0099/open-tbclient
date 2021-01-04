package com.kwai.sodler.lib.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwai.sodler.lib.a.a;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class f<P extends a> {

    /* renamed from: a  reason: collision with root package name */
    protected String f11297a;
    protected String e;
    protected String f;
    protected boolean g;
    protected P h;
    protected com.kwai.sodler.lib.ext.b i;
    protected e j;
    protected Throwable k;
    protected long l;
    protected String m;
    protected String n;
    protected List<com.kwai.sodler.lib.b.a> o;
    protected com.kwai.sodler.lib.b.b p;
    private String r;
    protected int c = -1;

    /* renamed from: b  reason: collision with root package name */
    protected int f11298b = -2233;
    private final byte[] q = new byte[0];
    protected StringBuffer d = new StringBuffer(String.valueOf(this.c));

    public abstract a a(String str);

    public f a(int i) {
        synchronized (this.q) {
            this.c = i;
        }
        return c(String.valueOf(i));
    }

    public f a(e eVar) {
        this.j = eVar;
        return this;
    }

    public f a(@NonNull Throwable th) {
        this.k = th;
        return c(th.getLocalizedMessage());
    }

    public String a() {
        return this.r;
    }

    @Deprecated
    public void a(long j) {
        this.l = j;
    }

    public void a(P p) {
        this.h = p;
    }

    public void a(com.kwai.sodler.lib.b.b bVar) {
        this.p = bVar;
    }

    @Deprecated
    public void a(PluginError.UpdateError updateError) {
    }

    public void a(com.kwai.sodler.lib.ext.b bVar) {
        this.i = bVar;
    }

    public e b() {
        return this.j;
    }

    public void b(int i) {
        if (i > 0) {
            this.f11298b = i;
        }
    }

    public void b(PluginError.UpdateError updateError) {
        a(-3);
    }

    public void b(String str) {
        this.r = str;
    }

    public int c() {
        int i;
        synchronized (this.q) {
            i = this.c;
        }
        return i;
    }

    public f c(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.d.append(" --> ").append(str);
        }
        return this;
    }

    public String d() {
        return this.d.toString();
    }

    public void d(String str) {
        this.e = str;
    }

    public void e() {
        synchronized (this.q) {
            a(-7);
        }
    }

    public void e(String str) {
        this.f = str;
    }

    public void f(String str) {
        this.m = str;
    }

    public boolean f() {
        return this.c == -7;
    }

    @Nullable
    public Throwable g() {
        return this.k;
    }

    public void g(String str) {
        this.n = str;
    }

    protected List<com.kwai.sodler.lib.b.a> h(@NonNull String str) {
        String[] list;
        ArrayList arrayList = new ArrayList();
        File file = new File(this.j.e().e(str));
        if (file.exists()) {
            for (String str2 : file.list()) {
                if (this.j.e().c(str, str2)) {
                    com.kwai.sodler.lib.b.a aVar = new com.kwai.sodler.lib.b.a();
                    aVar.f11300a = str;
                    aVar.f11301b = str2;
                    aVar.c = true;
                    arrayList.add(aVar);
                }
            }
            Collections.sort(arrayList);
        } else {
            Log.d("plugin.request", "No local plugin, path = " + file.getAbsolutePath());
        }
        return arrayList;
    }

    public void h() {
        int i = this.f11298b - 1;
        this.f11298b = i;
        if (i < 0) {
            throw new PluginError.RetryError();
        }
    }

    @Nullable
    public String i() {
        return this.f11297a;
    }

    public boolean j() {
        return this.g;
    }

    @Nullable
    public String k() {
        return !TextUtils.isEmpty(this.e) ? this.e : this.f;
    }

    @Nullable
    public P l() {
        return this.h;
    }

    @Nullable
    public com.kwai.sodler.lib.ext.b m() {
        return this.i;
    }

    public boolean n() {
        return false;
    }

    public String o() {
        return null;
    }

    public String p() {
        return this.m;
    }

    @Nullable
    public String q() {
        return this.n;
    }

    @Nullable
    public List<com.kwai.sodler.lib.b.a> r() {
        return this.o;
    }

    @Nullable
    public com.kwai.sodler.lib.b.b s() {
        return this.p;
    }

    public void t() {
        String i = i();
        if (TextUtils.isEmpty(i) || this.o != null) {
            return;
        }
        this.o = h(i);
    }

    public String toString() {
        return "PluginRequest{mId='" + this.f11297a + "'}";
    }
}
