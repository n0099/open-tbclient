package d.a.j0.e1.l.c;

import com.baidu.tieba.im.message.chat.ChatMessage;
import d.a.j0.e1.l.c.a;
/* loaded from: classes4.dex */
public class b implements d.a.i0.g0.b.a {

    /* renamed from: e  reason: collision with root package name */
    public boolean f53719e;

    /* renamed from: f  reason: collision with root package name */
    public a.C1228a f53720f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.e1.h.o.a f53721g;

    /* renamed from: h  reason: collision with root package name */
    public long f53722h;

    /* renamed from: i  reason: collision with root package name */
    public int f53723i;

    public static b a(ChatMessage chatMessage, a.C1228a c1228a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c1228a.f53717h /= 100;
        bVar.p(chatMessage.getReadCountPv());
        bVar.n(c1228a);
        bVar.j(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof d.a.j0.e1.h.o.a) {
            bVar.m((d.a.j0.e1.h.o.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public long b() {
        return this.f53722h;
    }

    public d.a.j0.e1.h.o.a d() {
        return this.f53721g;
    }

    public a.C1228a e() {
        return this.f53720f;
    }

    public int g() {
        return this.f53723i;
    }

    public boolean h() {
        return this.f53719e;
    }

    public void j(long j) {
        this.f53722h = j;
    }

    public void l(boolean z) {
        this.f53719e = z;
    }

    public void m(d.a.j0.e1.h.o.a aVar) {
        this.f53721g = aVar;
    }

    public void n(a.C1228a c1228a) {
        this.f53720f = c1228a;
    }

    public void p(int i2) {
        this.f53723i = i2;
    }
}
