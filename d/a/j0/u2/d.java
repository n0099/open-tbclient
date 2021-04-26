package d.a.j0.u2;

import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f61447a;

    /* renamed from: b  reason: collision with root package name */
    public String f61448b;

    /* renamed from: c  reason: collision with root package name */
    public String f61449c;

    /* renamed from: d  reason: collision with root package name */
    public String f61450d;

    /* renamed from: e  reason: collision with root package name */
    public String f61451e;

    /* renamed from: f  reason: collision with root package name */
    public String f61452f;

    /* renamed from: g  reason: collision with root package name */
    public int f61453g;

    /* renamed from: h  reason: collision with root package name */
    public int f61454h;

    /* renamed from: i  reason: collision with root package name */
    public int f61455i;
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
        dVar.f61455i = 0;
        dVar.f61453g = 4;
        dVar.f61454h = 4;
        dVar.l = System.currentTimeMillis();
        dVar.n = true;
    }

    public d(MsgContent msgContent) {
        this.f61450d = msgContent.title;
        this.q = msgContent.url;
        this.f61452f = msgContent.src;
        this.f61451e = msgContent.text;
        a(this);
    }
}
