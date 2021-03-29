package d.b.h0.r.f0.p;

import tbclient.UrlParser.DataRes;
import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f50549a;

    /* renamed from: b  reason: collision with root package name */
    public int f50550b;

    /* renamed from: c  reason: collision with root package name */
    public String f50551c;

    /* renamed from: d  reason: collision with root package name */
    public String f50552d;

    /* renamed from: e  reason: collision with root package name */
    public String f50553e;

    /* renamed from: f  reason: collision with root package name */
    public String f50554f;

    /* renamed from: g  reason: collision with root package name */
    public String f50555g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f50556h;
    public String i;

    public void a(UrlParserResIdl urlParserResIdl) {
        DataRes dataRes;
        if (urlParserResIdl == null || (dataRes = urlParserResIdl.data) == null) {
            return;
        }
        this.f50549a = dataRes.status.intValue();
        this.f50550b = urlParserResIdl.data.url_type.intValue();
        DataRes dataRes2 = urlParserResIdl.data;
        this.f50552d = dataRes2.image;
        this.f50553e = dataRes2.title;
        this.f50554f = dataRes2.link_from;
        this.f50555g = dataRes2.price_txt;
        this.f50556h = dataRes2.is_recognize.intValue() == 1;
        this.i = urlParserResIdl.data.description;
    }
}
