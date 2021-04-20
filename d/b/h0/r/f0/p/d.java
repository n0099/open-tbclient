package d.b.h0.r.f0.p;

import tbclient.UrlParser.DataRes;
import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f50956a;

    /* renamed from: b  reason: collision with root package name */
    public int f50957b;

    /* renamed from: c  reason: collision with root package name */
    public String f50958c;

    /* renamed from: d  reason: collision with root package name */
    public String f50959d;

    /* renamed from: e  reason: collision with root package name */
    public String f50960e;

    /* renamed from: f  reason: collision with root package name */
    public String f50961f;

    /* renamed from: g  reason: collision with root package name */
    public String f50962g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f50963h;
    public String i;

    public void a(UrlParserResIdl urlParserResIdl) {
        DataRes dataRes;
        if (urlParserResIdl == null || (dataRes = urlParserResIdl.data) == null) {
            return;
        }
        this.f50956a = dataRes.status.intValue();
        this.f50957b = urlParserResIdl.data.url_type.intValue();
        DataRes dataRes2 = urlParserResIdl.data;
        this.f50959d = dataRes2.image;
        this.f50960e = dataRes2.title;
        this.f50961f = dataRes2.link_from;
        this.f50962g = dataRes2.price_txt;
        this.f50963h = dataRes2.is_recognize.intValue() == 1;
        this.i = urlParserResIdl.data.description;
    }
}
