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
/* loaded from: classes7.dex */
public abstract class f<P extends a> {

    /* renamed from: a  reason: collision with root package name */
    public String f37897a;

    /* renamed from: e  reason: collision with root package name */
    public String f37901e;

    /* renamed from: f  reason: collision with root package name */
    public String f37902f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37903g;

    /* renamed from: h  reason: collision with root package name */
    public P f37904h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwai.sodler.lib.ext.b f37905i;
    public e j;
    public Throwable k;
    public long l;
    public String m;
    public String n;
    public List<com.kwai.sodler.lib.b.a> o;
    public com.kwai.sodler.lib.b.b p;
    public String r;

    /* renamed from: c  reason: collision with root package name */
    public int f37899c = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f37898b = -2233;
    public final byte[] q = new byte[0];

    /* renamed from: d  reason: collision with root package name */
    public StringBuffer f37900d = new StringBuffer(String.valueOf(-1));

    public abstract a a(String str);

    public f a(int i2) {
        synchronized (this.q) {
            this.f37899c = i2;
        }
        return c(String.valueOf(i2));
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
        this.f37904h = p;
    }

    public void a(com.kwai.sodler.lib.b.b bVar) {
        this.p = bVar;
    }

    @Deprecated
    public void a(PluginError.UpdateError updateError) {
    }

    public void a(com.kwai.sodler.lib.ext.b bVar) {
        this.f37905i = bVar;
    }

    public e b() {
        return this.j;
    }

    public void b(int i2) {
        if (i2 > 0) {
            this.f37898b = i2;
        }
    }

    public void b(PluginError.UpdateError updateError) {
        a(-3);
    }

    public void b(String str) {
        this.r = str;
    }

    public int c() {
        int i2;
        synchronized (this.q) {
            i2 = this.f37899c;
        }
        return i2;
    }

    public f c(String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuffer stringBuffer = this.f37900d;
            stringBuffer.append(" --> ");
            stringBuffer.append(str);
        }
        return this;
    }

    public String d() {
        return this.f37900d.toString();
    }

    public void d(String str) {
        this.f37901e = str;
    }

    public void e() {
        synchronized (this.q) {
            a(-7);
        }
    }

    public void e(String str) {
        this.f37902f = str;
    }

    public void f(String str) {
        this.m = str;
    }

    public boolean f() {
        return this.f37899c == -7;
    }

    @Nullable
    public Throwable g() {
        return this.k;
    }

    public void g(String str) {
        this.n = str;
    }

    public List<com.kwai.sodler.lib.b.a> h(@NonNull String str) {
        String[] list;
        ArrayList arrayList = new ArrayList();
        File file = new File(this.j.e().e(str));
        if (!file.exists()) {
            Log.d("plugin.request", "No local plugin, path = " + file.getAbsolutePath());
            return arrayList;
        }
        for (String str2 : file.list()) {
            if (this.j.e().c(str, str2)) {
                com.kwai.sodler.lib.b.a aVar = new com.kwai.sodler.lib.b.a();
                aVar.f37907a = str;
                aVar.f37908b = str2;
                aVar.f37909c = true;
                arrayList.add(aVar);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public void h() {
        int i2 = this.f37898b - 1;
        this.f37898b = i2;
        if (i2 < 0) {
            throw new PluginError.RetryError();
        }
    }

    @Nullable
    public String i() {
        return this.f37897a;
    }

    public boolean j() {
        return this.f37903g;
    }

    @Nullable
    public String k() {
        return !TextUtils.isEmpty(this.f37901e) ? this.f37901e : this.f37902f;
    }

    @Nullable
    public P l() {
        return this.f37904h;
    }

    @Nullable
    public com.kwai.sodler.lib.ext.b m() {
        return this.f37905i;
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
        String i2 = i();
        if (TextUtils.isEmpty(i2) || this.o != null) {
            return;
        }
        this.o = h(i2);
    }

    public String toString() {
        return "PluginRequest{mId='" + this.f37897a + "'}";
    }
}
