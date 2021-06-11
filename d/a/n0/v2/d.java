package d.a.n0.v2;

import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f66043a;

    /* renamed from: b  reason: collision with root package name */
    public String f66044b;

    /* renamed from: c  reason: collision with root package name */
    public String f66045c;

    /* renamed from: d  reason: collision with root package name */
    public String f66046d;

    /* renamed from: e  reason: collision with root package name */
    public String f66047e;

    /* renamed from: f  reason: collision with root package name */
    public String f66048f;

    /* renamed from: g  reason: collision with root package name */
    public int f66049g;

    /* renamed from: h  reason: collision with root package name */
    public int f66050h;

    /* renamed from: i  reason: collision with root package name */
    public int f66051i;
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
        dVar.f66051i = 0;
        dVar.f66049g = 4;
        dVar.f66050h = 4;
        dVar.l = System.currentTimeMillis();
        dVar.n = true;
    }

    public d(MsgContent msgContent) {
        this.f66046d = msgContent.title;
        this.q = msgContent.url;
        this.f66048f = msgContent.src;
        this.f66047e = msgContent.text;
        a(this);
    }
}
