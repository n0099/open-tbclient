package d.a.n0.f1.l.c;

import com.baidu.tieba.im.message.chat.ChatMessage;
import d.a.n0.f1.l.c.a;
/* loaded from: classes4.dex */
public class b implements d.a.m0.g0.b.a {

    /* renamed from: e  reason: collision with root package name */
    public boolean f58305e;

    /* renamed from: f  reason: collision with root package name */
    public a.C1374a f58306f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.f1.h.o.a f58307g;

    /* renamed from: h  reason: collision with root package name */
    public long f58308h;

    /* renamed from: i  reason: collision with root package name */
    public int f58309i;

    public static b a(ChatMessage chatMessage, a.C1374a c1374a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c1374a.f58303h /= 100;
        bVar.o(chatMessage.getReadCountPv());
        bVar.m(c1374a);
        bVar.i(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof d.a.n0.f1.h.o.a) {
            bVar.k((d.a.n0.f1.h.o.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public long b() {
        return this.f58308h;
    }

    public d.a.n0.f1.h.o.a c() {
        return this.f58307g;
    }

    public a.C1374a d() {
        return this.f58306f;
    }

    public int f() {
        return this.f58309i;
    }

    public boolean g() {
        return this.f58305e;
    }

    public void i(long j) {
        this.f58308h = j;
    }

    public void j(boolean z) {
        this.f58305e = z;
    }

    public void k(d.a.n0.f1.h.o.a aVar) {
        this.f58307g = aVar;
    }

    public void m(a.C1374a c1374a) {
        this.f58306f = c1374a;
    }

    public void o(int i2) {
        this.f58309i = i2;
    }
}
