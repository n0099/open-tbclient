package d.a.k0.e1.l.c;

import com.baidu.tieba.im.message.chat.ChatMessage;
import d.a.k0.e1.l.c.a;
/* loaded from: classes4.dex */
public class b implements d.a.j0.g0.b.a {

    /* renamed from: e  reason: collision with root package name */
    public boolean f54426e;

    /* renamed from: f  reason: collision with root package name */
    public a.C1300a f54427f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.k0.e1.h.o.a f54428g;

    /* renamed from: h  reason: collision with root package name */
    public long f54429h;

    /* renamed from: i  reason: collision with root package name */
    public int f54430i;

    public static b a(ChatMessage chatMessage, a.C1300a c1300a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c1300a.f54424h /= 100;
        bVar.p(chatMessage.getReadCountPv());
        bVar.n(c1300a);
        bVar.j(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof d.a.k0.e1.h.o.a) {
            bVar.m((d.a.k0.e1.h.o.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public long b() {
        return this.f54429h;
    }

    public d.a.k0.e1.h.o.a d() {
        return this.f54428g;
    }

    public a.C1300a e() {
        return this.f54427f;
    }

    public int g() {
        return this.f54430i;
    }

    public boolean h() {
        return this.f54426e;
    }

    public void j(long j) {
        this.f54429h = j;
    }

    public void l(boolean z) {
        this.f54426e = z;
    }

    public void m(d.a.k0.e1.h.o.a aVar) {
        this.f54428g = aVar;
    }

    public void n(a.C1300a c1300a) {
        this.f54427f = c1300a;
    }

    public void p(int i2) {
        this.f54430i = i2;
    }
}
