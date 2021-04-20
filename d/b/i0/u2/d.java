package d.b.i0.u2;

import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f62807a;

    /* renamed from: b  reason: collision with root package name */
    public String f62808b;

    /* renamed from: c  reason: collision with root package name */
    public String f62809c;

    /* renamed from: d  reason: collision with root package name */
    public String f62810d;

    /* renamed from: e  reason: collision with root package name */
    public String f62811e;

    /* renamed from: f  reason: collision with root package name */
    public String f62812f;

    /* renamed from: g  reason: collision with root package name */
    public int f62813g;

    /* renamed from: h  reason: collision with root package name */
    public int f62814h;
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
        dVar.f62813g = 4;
        dVar.f62814h = 4;
        dVar.l = System.currentTimeMillis();
        dVar.n = true;
    }

    public d(MsgContent msgContent) {
        this.f62810d = msgContent.title;
        this.q = msgContent.url;
        this.f62812f = msgContent.src;
        this.f62811e = msgContent.text;
        a(this);
    }
}
