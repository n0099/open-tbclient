package d.a.n0.v2;

import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f62328a;

    /* renamed from: b  reason: collision with root package name */
    public String f62329b;

    /* renamed from: c  reason: collision with root package name */
    public String f62330c;

    /* renamed from: d  reason: collision with root package name */
    public String f62331d;

    /* renamed from: e  reason: collision with root package name */
    public String f62332e;

    /* renamed from: f  reason: collision with root package name */
    public String f62333f;

    /* renamed from: g  reason: collision with root package name */
    public int f62334g;

    /* renamed from: h  reason: collision with root package name */
    public int f62335h;

    /* renamed from: i  reason: collision with root package name */
    public int f62336i;
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
        dVar.f62336i = 0;
        dVar.f62334g = 4;
        dVar.f62335h = 4;
        dVar.l = System.currentTimeMillis();
        dVar.n = true;
    }

    public d(MsgContent msgContent) {
        this.f62331d = msgContent.title;
        this.q = msgContent.url;
        this.f62333f = msgContent.src;
        this.f62332e = msgContent.text;
        a(this);
    }
}
