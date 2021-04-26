package d.a.i0.r.f0.p;

import tbclient.UrlParser.DataRes;
import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f48905a;

    /* renamed from: b  reason: collision with root package name */
    public int f48906b;

    /* renamed from: c  reason: collision with root package name */
    public String f48907c;

    /* renamed from: d  reason: collision with root package name */
    public String f48908d;

    /* renamed from: e  reason: collision with root package name */
    public String f48909e;

    /* renamed from: f  reason: collision with root package name */
    public String f48910f;

    /* renamed from: g  reason: collision with root package name */
    public String f48911g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f48912h;

    /* renamed from: i  reason: collision with root package name */
    public String f48913i;

    public void a(UrlParserResIdl urlParserResIdl) {
        DataRes dataRes;
        if (urlParserResIdl == null || (dataRes = urlParserResIdl.data) == null) {
            return;
        }
        this.f48905a = dataRes.status.intValue();
        this.f48906b = urlParserResIdl.data.url_type.intValue();
        DataRes dataRes2 = urlParserResIdl.data;
        this.f48908d = dataRes2.image;
        this.f48909e = dataRes2.title;
        this.f48910f = dataRes2.link_from;
        this.f48911g = dataRes2.price_txt;
        this.f48912h = dataRes2.is_recognize.intValue() == 1;
        this.f48913i = urlParserResIdl.data.description;
    }
}
