package d.b.i0.d1.l.c;

import com.baidu.tieba.im.message.chat.ChatMessage;
import d.b.i0.d1.l.c.a;
/* loaded from: classes3.dex */
public class b implements d.b.h0.g0.b.a {

    /* renamed from: e  reason: collision with root package name */
    public boolean f53915e;

    /* renamed from: f  reason: collision with root package name */
    public a.C1203a f53916f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.d1.h.o.a f53917g;

    /* renamed from: h  reason: collision with root package name */
    public long f53918h;
    public int i;

    public static b b(ChatMessage chatMessage, a.C1203a c1203a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c1203a.f53914h /= 100;
        bVar.o(chatMessage.getReadCountPv());
        bVar.n(c1203a);
        bVar.i(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof d.b.i0.d1.h.o.a) {
            bVar.m((d.b.i0.d1.h.o.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public long c() {
        return this.f53918h;
    }

    public d.b.i0.d1.h.o.a d() {
        return this.f53917g;
    }

    public a.C1203a f() {
        return this.f53916f;
    }

    public int g() {
        return this.i;
    }

    public boolean h() {
        return this.f53915e;
    }

    public void i(long j) {
        this.f53918h = j;
    }

    public void j(boolean z) {
        this.f53915e = z;
    }

    public void m(d.b.i0.d1.h.o.a aVar) {
        this.f53917g = aVar;
    }

    public void n(a.C1203a c1203a) {
        this.f53916f = c1203a;
    }

    public void o(int i) {
        this.i = i;
    }
}
