package d.b.h0.r.f0.p;

import tbclient.UrlParser.DataRes;
import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f50548a;

    /* renamed from: b  reason: collision with root package name */
    public int f50549b;

    /* renamed from: c  reason: collision with root package name */
    public String f50550c;

    /* renamed from: d  reason: collision with root package name */
    public String f50551d;

    /* renamed from: e  reason: collision with root package name */
    public String f50552e;

    /* renamed from: f  reason: collision with root package name */
    public String f50553f;

    /* renamed from: g  reason: collision with root package name */
    public String f50554g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f50555h;
    public String i;

    public void a(UrlParserResIdl urlParserResIdl) {
        DataRes dataRes;
        if (urlParserResIdl == null || (dataRes = urlParserResIdl.data) == null) {
            return;
        }
        this.f50548a = dataRes.status.intValue();
        this.f50549b = urlParserResIdl.data.url_type.intValue();
        DataRes dataRes2 = urlParserResIdl.data;
        this.f50551d = dataRes2.image;
        this.f50552e = dataRes2.title;
        this.f50553f = dataRes2.link_from;
        this.f50554g = dataRes2.price_txt;
        this.f50555h = dataRes2.is_recognize.intValue() == 1;
        this.i = urlParserResIdl.data.description;
    }
}
