package d.a.m0.r.f0.p;

import tbclient.UrlParser.DataRes;
import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f49778a;

    /* renamed from: b  reason: collision with root package name */
    public int f49779b;

    /* renamed from: c  reason: collision with root package name */
    public String f49780c;

    /* renamed from: d  reason: collision with root package name */
    public String f49781d;

    /* renamed from: e  reason: collision with root package name */
    public String f49782e;

    /* renamed from: f  reason: collision with root package name */
    public String f49783f;

    /* renamed from: g  reason: collision with root package name */
    public String f49784g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f49785h;

    /* renamed from: i  reason: collision with root package name */
    public String f49786i;

    public void a(UrlParserResIdl urlParserResIdl) {
        DataRes dataRes;
        if (urlParserResIdl == null || (dataRes = urlParserResIdl.data) == null) {
            return;
        }
        this.f49778a = dataRes.status.intValue();
        this.f49779b = urlParserResIdl.data.url_type.intValue();
        DataRes dataRes2 = urlParserResIdl.data;
        this.f49781d = dataRes2.image;
        this.f49782e = dataRes2.title;
        this.f49783f = dataRes2.link_from;
        this.f49784g = dataRes2.price_txt;
        this.f49785h = dataRes2.is_recognize.intValue() == 1;
        this.f49786i = urlParserResIdl.data.description;
    }
}
