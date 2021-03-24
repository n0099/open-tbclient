package d.b.i0.d1.l.c;

import com.baidu.tieba.im.message.chat.ChatMessage;
import d.b.i0.d1.l.c.a;
/* loaded from: classes4.dex */
public class b implements d.b.h0.g0.b.a {

    /* renamed from: e  reason: collision with root package name */
    public boolean f53914e;

    /* renamed from: f  reason: collision with root package name */
    public a.C1202a f53915f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.d1.h.o.a f53916g;

    /* renamed from: h  reason: collision with root package name */
    public long f53917h;
    public int i;

    public static b b(ChatMessage chatMessage, a.C1202a c1202a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c1202a.f53913h /= 100;
        bVar.o(chatMessage.getReadCountPv());
        bVar.n(c1202a);
        bVar.i(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof d.b.i0.d1.h.o.a) {
            bVar.m((d.b.i0.d1.h.o.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public long c() {
        return this.f53917h;
    }

    public d.b.i0.d1.h.o.a d() {
        return this.f53916g;
    }

    public a.C1202a f() {
        return this.f53915f;
    }

    public int g() {
        return this.i;
    }

    public boolean h() {
        return this.f53914e;
    }

    public void i(long j) {
        this.f53917h = j;
    }

    public void j(boolean z) {
        this.f53914e = z;
    }

    public void m(d.b.i0.d1.h.o.a aVar) {
        this.f53916g = aVar;
    }

    public void n(a.C1202a c1202a) {
        this.f53915f = c1202a;
    }

    public void o(int i) {
        this.i = i;
    }
}
