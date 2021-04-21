package d.b.i0.r.f0.p;

import tbclient.UrlParser.DataRes;
import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f51292a;

    /* renamed from: b  reason: collision with root package name */
    public int f51293b;

    /* renamed from: c  reason: collision with root package name */
    public String f51294c;

    /* renamed from: d  reason: collision with root package name */
    public String f51295d;

    /* renamed from: e  reason: collision with root package name */
    public String f51296e;

    /* renamed from: f  reason: collision with root package name */
    public String f51297f;

    /* renamed from: g  reason: collision with root package name */
    public String f51298g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51299h;
    public String i;

    public void a(UrlParserResIdl urlParserResIdl) {
        DataRes dataRes;
        if (urlParserResIdl == null || (dataRes = urlParserResIdl.data) == null) {
            return;
        }
        this.f51292a = dataRes.status.intValue();
        this.f51293b = urlParserResIdl.data.url_type.intValue();
        DataRes dataRes2 = urlParserResIdl.data;
        this.f51295d = dataRes2.image;
        this.f51296e = dataRes2.title;
        this.f51297f = dataRes2.link_from;
        this.f51298g = dataRes2.price_txt;
        this.f51299h = dataRes2.is_recognize.intValue() == 1;
        this.i = urlParserResIdl.data.description;
    }
}
