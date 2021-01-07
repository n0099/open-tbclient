package com.qq.e.comm.plugin.ab;

import android.content.Context;
import com.qq.e.comm.plugin.ab.h;
import com.qq.e.comm.plugin.util.bi;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class e {
    private static boolean k;

    /* renamed from: a  reason: collision with root package name */
    private Context f12065a;

    /* renamed from: b  reason: collision with root package name */
    private c f12066b;
    private com.qq.e.comm.plugin.ab.a.b c;
    private h.a d;
    private boolean e = true;
    private boolean f = false;
    private boolean g = false;
    private boolean h = true;
    private boolean i = true;
    private boolean j = true;

    public e(Context context, c cVar) {
        this.f12065a = context;
        this.f12066b = cVar;
    }

    public static boolean b() {
        return k;
    }

    public static boolean c() {
        return bi.b();
    }

    public e a(com.qq.e.comm.plugin.ab.a.b bVar) {
        this.c = bVar;
        return this;
    }

    public e a(h.a aVar) {
        this.d = aVar;
        return this;
    }

    public e a(boolean z) {
        this.e = z;
        return this;
    }

    public h a() {
        h hVar = null;
        if (this.f12065a != null && this.f12066b != null) {
            try {
                hVar = bi.a() ? new n(this.f12065a, this.f12066b) : new g(this.f12065a, this.f12066b);
            } catch (Exception e) {
                GDTLogger.d("WebViewBuilder Exception:" + e.getMessage());
            }
            if (hVar == null) {
                hVar = new g(this.f12065a, this.f12066b);
            }
            k = hVar instanceof n;
            if (this.c != null) {
                hVar.a(this.c);
            }
            hVar.a(this.f);
            hVar.b(this.g);
            hVar.c(this.h);
            hVar.d(this.i);
            hVar.e(this.j);
            if (this.d != null) {
                hVar.a(this.d);
            }
            if (this.e) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(com.qq.e.comm.plugin.ab.c.h.a());
                arrayList.add(com.qq.e.comm.plugin.ab.c.d.a());
                arrayList.add(com.qq.e.comm.plugin.ab.c.a.a());
                arrayList.add(com.qq.e.comm.plugin.ab.c.k.a());
                arrayList.add(com.qq.e.comm.plugin.ab.c.n.a());
                arrayList.add(com.qq.e.comm.plugin.ab.c.b.a());
                arrayList.add(com.qq.e.comm.plugin.ab.c.c.a());
                hVar.a(arrayList);
            }
        }
        return hVar;
    }

    public e b(boolean z) {
        this.h = z;
        return this;
    }

    public e c(boolean z) {
        this.i = z;
        return this;
    }

    public e d(boolean z) {
        this.j = z;
        return this;
    }
}
