package d.b.i0.t2;

import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f61117a;

    /* renamed from: b  reason: collision with root package name */
    public String f61118b;

    /* renamed from: c  reason: collision with root package name */
    public String f61119c;

    /* renamed from: d  reason: collision with root package name */
    public String f61120d;

    /* renamed from: e  reason: collision with root package name */
    public String f61121e;

    /* renamed from: f  reason: collision with root package name */
    public String f61122f;

    /* renamed from: g  reason: collision with root package name */
    public int f61123g;

    /* renamed from: h  reason: collision with root package name */
    public int f61124h;
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
        dVar.f61123g = 4;
        dVar.f61124h = 4;
        dVar.l = System.currentTimeMillis();
        dVar.n = true;
    }

    public d(MsgContent msgContent) {
        this.f61120d = msgContent.title;
        this.q = msgContent.url;
        this.f61122f = msgContent.src;
        this.f61121e = msgContent.text;
        a(this);
    }
}
