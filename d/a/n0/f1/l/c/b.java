package d.a.n0.f1.l.c;

import com.baidu.tieba.im.message.chat.ChatMessage;
import d.a.n0.f1.l.c.a;
/* loaded from: classes4.dex */
public class b implements d.a.m0.g0.b.a {

    /* renamed from: e  reason: collision with root package name */
    public boolean f54616e;

    /* renamed from: f  reason: collision with root package name */
    public a.C1318a f54617f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.f1.h.o.a f54618g;

    /* renamed from: h  reason: collision with root package name */
    public long f54619h;

    /* renamed from: i  reason: collision with root package name */
    public int f54620i;

    public static b a(ChatMessage chatMessage, a.C1318a c1318a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c1318a.f54614h /= 100;
        bVar.p(chatMessage.getReadCountPv());
        bVar.n(c1318a);
        bVar.j(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof d.a.n0.f1.h.o.a) {
            bVar.m((d.a.n0.f1.h.o.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public long b() {
        return this.f54619h;
    }

    public d.a.n0.f1.h.o.a d() {
        return this.f54618g;
    }

    public a.C1318a e() {
        return this.f54617f;
    }

    public int g() {
        return this.f54620i;
    }

    public boolean h() {
        return this.f54616e;
    }

    public void j(long j) {
        this.f54619h = j;
    }

    public void l(boolean z) {
        this.f54616e = z;
    }

    public void m(d.a.n0.f1.h.o.a aVar) {
        this.f54618g = aVar;
    }

    public void n(a.C1318a c1318a) {
        this.f54617f = c1318a;
    }

    public void p(int i2) {
        this.f54620i = i2;
    }
}
