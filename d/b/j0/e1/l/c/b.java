package d.b.j0.e1.l.c;

import com.baidu.tieba.im.message.chat.ChatMessage;
import d.b.j0.e1.l.c.a;
/* loaded from: classes4.dex */
public class b implements d.b.i0.g0.b.a {

    /* renamed from: e  reason: collision with root package name */
    public boolean f55858e;

    /* renamed from: f  reason: collision with root package name */
    public a.C1289a f55859f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.e1.h.o.a f55860g;

    /* renamed from: h  reason: collision with root package name */
    public long f55861h;
    public int i;

    public static b b(ChatMessage chatMessage, a.C1289a c1289a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c1289a.f55857h /= 100;
        bVar.o(chatMessage.getReadCountPv());
        bVar.n(c1289a);
        bVar.i(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof d.b.j0.e1.h.o.a) {
            bVar.m((d.b.j0.e1.h.o.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public long c() {
        return this.f55861h;
    }

    public d.b.j0.e1.h.o.a d() {
        return this.f55860g;
    }

    public a.C1289a f() {
        return this.f55859f;
    }

    public int g() {
        return this.i;
    }

    public boolean h() {
        return this.f55858e;
    }

    public void i(long j) {
        this.f55861h = j;
    }

    public void j(boolean z) {
        this.f55858e = z;
    }

    public void m(d.b.j0.e1.h.o.a aVar) {
        this.f55860g = aVar;
    }

    public void n(a.C1289a c1289a) {
        this.f55859f = c1289a;
    }

    public void o(int i) {
        this.i = i;
    }
}
