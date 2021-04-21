package d.b.i0.r.q;

import tbclient.PbPage.NewsInfo;
/* loaded from: classes3.dex */
public class c1 {

    /* renamed from: a  reason: collision with root package name */
    public String f51478a;

    /* renamed from: b  reason: collision with root package name */
    public String f51479b;

    /* renamed from: c  reason: collision with root package name */
    public int f51480c;

    /* renamed from: d  reason: collision with root package name */
    public String f51481d;

    /* renamed from: e  reason: collision with root package name */
    public String f51482e;

    /* renamed from: f  reason: collision with root package name */
    public String f51483f;

    public void a(NewsInfo newsInfo) {
        if (newsInfo == null) {
            return;
        }
        this.f51478a = newsInfo.news_link;
        this.f51479b = newsInfo.summary;
        newsInfo.position.intValue();
        this.f51480c = newsInfo.news_type.intValue();
        this.f51481d = newsInfo.news_icon;
        this.f51482e = newsInfo.subtitle;
        this.f51483f = newsInfo.button_text;
    }
}
