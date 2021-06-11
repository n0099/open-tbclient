package d.a.m0.r.f0.p;

import tbclient.UrlParser.DataRes;
import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f53453a;

    /* renamed from: b  reason: collision with root package name */
    public int f53454b;

    /* renamed from: c  reason: collision with root package name */
    public String f53455c;

    /* renamed from: d  reason: collision with root package name */
    public String f53456d;

    /* renamed from: e  reason: collision with root package name */
    public String f53457e;

    /* renamed from: f  reason: collision with root package name */
    public String f53458f;

    /* renamed from: g  reason: collision with root package name */
    public String f53459g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53460h;

    /* renamed from: i  reason: collision with root package name */
    public String f53461i;

    public void a(UrlParserResIdl urlParserResIdl) {
        DataRes dataRes;
        if (urlParserResIdl == null || (dataRes = urlParserResIdl.data) == null) {
            return;
        }
        this.f53453a = dataRes.status.intValue();
        this.f53454b = urlParserResIdl.data.url_type.intValue();
        DataRes dataRes2 = urlParserResIdl.data;
        this.f53456d = dataRes2.image;
        this.f53457e = dataRes2.title;
        this.f53458f = dataRes2.link_from;
        this.f53459g = dataRes2.price_txt;
        this.f53460h = dataRes2.is_recognize.intValue() == 1;
        this.f53461i = urlParserResIdl.data.description;
    }
}
