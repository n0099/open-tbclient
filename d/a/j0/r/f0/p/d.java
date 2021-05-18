package d.a.j0.r.f0.p;

import tbclient.UrlParser.DataRes;
import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f49734a;

    /* renamed from: b  reason: collision with root package name */
    public int f49735b;

    /* renamed from: c  reason: collision with root package name */
    public String f49736c;

    /* renamed from: d  reason: collision with root package name */
    public String f49737d;

    /* renamed from: e  reason: collision with root package name */
    public String f49738e;

    /* renamed from: f  reason: collision with root package name */
    public String f49739f;

    /* renamed from: g  reason: collision with root package name */
    public String f49740g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f49741h;

    /* renamed from: i  reason: collision with root package name */
    public String f49742i;

    public void a(UrlParserResIdl urlParserResIdl) {
        DataRes dataRes;
        if (urlParserResIdl == null || (dataRes = urlParserResIdl.data) == null) {
            return;
        }
        this.f49734a = dataRes.status.intValue();
        this.f49735b = urlParserResIdl.data.url_type.intValue();
        DataRes dataRes2 = urlParserResIdl.data;
        this.f49737d = dataRes2.image;
        this.f49738e = dataRes2.title;
        this.f49739f = dataRes2.link_from;
        this.f49740g = dataRes2.price_txt;
        this.f49741h = dataRes2.is_recognize.intValue() == 1;
        this.f49742i = urlParserResIdl.data.description;
    }
}
