package d.b.j0.u2;

import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f63228a;

    /* renamed from: b  reason: collision with root package name */
    public String f63229b;

    /* renamed from: c  reason: collision with root package name */
    public String f63230c;

    /* renamed from: d  reason: collision with root package name */
    public String f63231d;

    /* renamed from: e  reason: collision with root package name */
    public String f63232e;

    /* renamed from: f  reason: collision with root package name */
    public String f63233f;

    /* renamed from: g  reason: collision with root package name */
    public int f63234g;

    /* renamed from: h  reason: collision with root package name */
    public int f63235h;
    public int i;
    public String j;
    public String k = "";
    public long l;
    public long m;
    public boolean n;
    public boolean o;
    public int p;
    public String q;
    public String r;
    public long s;
    public long t;

    public d() {
    }

    public static void a(d dVar) {
        dVar.i = 0;
        dVar.f63234g = 4;
        dVar.f63235h = 4;
        dVar.l = System.currentTimeMillis();
        dVar.n = true;
    }

    public d(MsgContent msgContent) {
        this.f63231d = msgContent.title;
        this.q = msgContent.url;
        this.f63233f = msgContent.src;
        this.f63232e = msgContent.text;
        a(this);
    }
}
