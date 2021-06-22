package d.a.n0.r.q;

import tbclient.PbPage.NewsInfo;
/* loaded from: classes3.dex */
public class c1 {

    /* renamed from: a  reason: collision with root package name */
    public String f53748a;

    /* renamed from: b  reason: collision with root package name */
    public String f53749b;

    /* renamed from: c  reason: collision with root package name */
    public int f53750c;

    /* renamed from: d  reason: collision with root package name */
    public String f53751d;

    /* renamed from: e  reason: collision with root package name */
    public String f53752e;

    /* renamed from: f  reason: collision with root package name */
    public String f53753f;

    public void a(NewsInfo newsInfo) {
        if (newsInfo == null) {
            return;
        }
        this.f53748a = newsInfo.news_link;
        this.f53749b = newsInfo.summary;
        newsInfo.position.intValue();
        this.f53750c = newsInfo.news_type.intValue();
        this.f53751d = newsInfo.news_icon;
        this.f53752e = newsInfo.subtitle;
        this.f53753f = newsInfo.button_text;
    }
}
