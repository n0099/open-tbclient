package d.a.k0.u2;

import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f62171a;

    /* renamed from: b  reason: collision with root package name */
    public String f62172b;

    /* renamed from: c  reason: collision with root package name */
    public String f62173c;

    /* renamed from: d  reason: collision with root package name */
    public String f62174d;

    /* renamed from: e  reason: collision with root package name */
    public String f62175e;

    /* renamed from: f  reason: collision with root package name */
    public String f62176f;

    /* renamed from: g  reason: collision with root package name */
    public int f62177g;

    /* renamed from: h  reason: collision with root package name */
    public int f62178h;

    /* renamed from: i  reason: collision with root package name */
    public int f62179i;
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
        dVar.f62179i = 0;
        dVar.f62177g = 4;
        dVar.f62178h = 4;
        dVar.l = System.currentTimeMillis();
        dVar.n = true;
    }

    public d(MsgContent msgContent) {
        this.f62174d = msgContent.title;
        this.q = msgContent.url;
        this.f62176f = msgContent.src;
        this.f62175e = msgContent.text;
        a(this);
    }
}
