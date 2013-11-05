package org.msgpack.template.builder.beans;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    static final /* synthetic */ boolean g;

    /* renamed from: a  reason: collision with root package name */
    boolean f2897a;
    boolean b;
    boolean c;
    String d;
    String e;
    String f;
    private Map<String, Object> h = new HashMap();

    static {
        g = !b.class.desiredAssertionStatus();
    }

    public void a(String str) {
        this.e = str;
    }

    public String b() {
        return this.e;
    }

    public String c() {
        return this.f == null ? b() : this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        if (!g && !this.e.equals(bVar.e)) {
            throw new AssertionError();
        }
        this.c |= bVar.c;
        this.b |= bVar.b;
        this.f2897a |= bVar.f2897a;
        if (this.d == null) {
            this.d = bVar.d;
        }
        if (this.e == null) {
            this.e = bVar.e;
        }
        if (this.f == null) {
            this.f = bVar.f;
        }
    }
}
