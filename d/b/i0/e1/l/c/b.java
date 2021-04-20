package d.b.i0.e1.l.c;

import com.baidu.tieba.im.message.chat.ChatMessage;
import d.b.i0.e1.l.c.a;
/* loaded from: classes4.dex */
public class b implements d.b.h0.g0.b.a {

    /* renamed from: e  reason: collision with root package name */
    public boolean f55437e;

    /* renamed from: f  reason: collision with root package name */
    public a.C1266a f55438f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.e1.h.o.a f55439g;

    /* renamed from: h  reason: collision with root package name */
    public long f55440h;
    public int i;

    public static b b(ChatMessage chatMessage, a.C1266a c1266a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c1266a.f55436h /= 100;
        bVar.o(chatMessage.getReadCountPv());
        bVar.n(c1266a);
        bVar.i(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof d.b.i0.e1.h.o.a) {
            bVar.m((d.b.i0.e1.h.o.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public long c() {
        return this.f55440h;
    }

    public d.b.i0.e1.h.o.a d() {
        return this.f55439g;
    }

    public a.C1266a f() {
        return this.f55438f;
    }

    public int g() {
        return this.i;
    }

    public boolean h() {
        return this.f55437e;
    }

    public void i(long j) {
        this.f55440h = j;
    }

    public void j(boolean z) {
        this.f55437e = z;
    }

    public void m(d.b.i0.e1.h.o.a aVar) {
        this.f55439g = aVar;
    }

    public void n(a.C1266a c1266a) {
        this.f55438f = c1266a;
    }

    public void o(int i) {
        this.i = i;
    }
}
