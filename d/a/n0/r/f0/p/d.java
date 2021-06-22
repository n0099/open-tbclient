package d.a.n0.r.f0.p;

import tbclient.UrlParser.DataRes;
import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f53560a;

    /* renamed from: b  reason: collision with root package name */
    public int f53561b;

    /* renamed from: c  reason: collision with root package name */
    public String f53562c;

    /* renamed from: d  reason: collision with root package name */
    public String f53563d;

    /* renamed from: e  reason: collision with root package name */
    public String f53564e;

    /* renamed from: f  reason: collision with root package name */
    public String f53565f;

    /* renamed from: g  reason: collision with root package name */
    public String f53566g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53567h;

    /* renamed from: i  reason: collision with root package name */
    public String f53568i;

    public void a(UrlParserResIdl urlParserResIdl) {
        DataRes dataRes;
        if (urlParserResIdl == null || (dataRes = urlParserResIdl.data) == null) {
            return;
        }
        this.f53560a = dataRes.status.intValue();
        this.f53561b = urlParserResIdl.data.url_type.intValue();
        DataRes dataRes2 = urlParserResIdl.data;
        this.f53563d = dataRes2.image;
        this.f53564e = dataRes2.title;
        this.f53565f = dataRes2.link_from;
        this.f53566g = dataRes2.price_txt;
        this.f53567h = dataRes2.is_recognize.intValue() == 1;
        this.f53568i = urlParserResIdl.data.description;
    }
}
