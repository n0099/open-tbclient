package d.a.o0.f1.l.c;

import com.baidu.tieba.im.message.chat.ChatMessage;
import d.a.o0.f1.l.c.a;
/* loaded from: classes4.dex */
public class b implements d.a.n0.g0.b.a {

    /* renamed from: e  reason: collision with root package name */
    public boolean f58430e;

    /* renamed from: f  reason: collision with root package name */
    public a.C1378a f58431f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.f1.h.o.a f58432g;

    /* renamed from: h  reason: collision with root package name */
    public long f58433h;

    /* renamed from: i  reason: collision with root package name */
    public int f58434i;

    public static b a(ChatMessage chatMessage, a.C1378a c1378a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c1378a.f58428h /= 100;
        bVar.o(chatMessage.getReadCountPv());
        bVar.m(c1378a);
        bVar.i(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof d.a.o0.f1.h.o.a) {
            bVar.k((d.a.o0.f1.h.o.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public long b() {
        return this.f58433h;
    }

    public d.a.o0.f1.h.o.a c() {
        return this.f58432g;
    }

    public a.C1378a d() {
        return this.f58431f;
    }

    public int f() {
        return this.f58434i;
    }

    public boolean g() {
        return this.f58430e;
    }

    public void i(long j) {
        this.f58433h = j;
    }

    public void j(boolean z) {
        this.f58430e = z;
    }

    public void k(d.a.o0.f1.h.o.a aVar) {
        this.f58432g = aVar;
    }

    public void m(a.C1378a c1378a) {
        this.f58431f = c1378a;
    }

    public void o(int i2) {
        this.f58434i = i2;
    }
}
