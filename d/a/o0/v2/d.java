package d.a.o0.v2;

import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f66168a;

    /* renamed from: b  reason: collision with root package name */
    public String f66169b;

    /* renamed from: c  reason: collision with root package name */
    public String f66170c;

    /* renamed from: d  reason: collision with root package name */
    public String f66171d;

    /* renamed from: e  reason: collision with root package name */
    public String f66172e;

    /* renamed from: f  reason: collision with root package name */
    public String f66173f;

    /* renamed from: g  reason: collision with root package name */
    public int f66174g;

    /* renamed from: h  reason: collision with root package name */
    public int f66175h;

    /* renamed from: i  reason: collision with root package name */
    public int f66176i;
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
        dVar.f66176i = 0;
        dVar.f66174g = 4;
        dVar.f66175h = 4;
        dVar.l = System.currentTimeMillis();
        dVar.n = true;
    }

    public d(MsgContent msgContent) {
        this.f66171d = msgContent.title;
        this.q = msgContent.url;
        this.f66173f = msgContent.src;
        this.f66172e = msgContent.text;
        a(this);
    }
}
