package d.a.j0.r.q;

import tbclient.PbPage.NewsInfo;
/* loaded from: classes3.dex */
public class c1 {

    /* renamed from: a  reason: collision with root package name */
    public String f49921a;

    /* renamed from: b  reason: collision with root package name */
    public String f49922b;

    /* renamed from: c  reason: collision with root package name */
    public int f49923c;

    /* renamed from: d  reason: collision with root package name */
    public String f49924d;

    /* renamed from: e  reason: collision with root package name */
    public String f49925e;

    /* renamed from: f  reason: collision with root package name */
    public String f49926f;

    public void a(NewsInfo newsInfo) {
        if (newsInfo == null) {
            return;
        }
        this.f49921a = newsInfo.news_link;
        this.f49922b = newsInfo.summary;
        newsInfo.position.intValue();
        this.f49923c = newsInfo.news_type.intValue();
        this.f49924d = newsInfo.news_icon;
        this.f49925e = newsInfo.subtitle;
        this.f49926f = newsInfo.button_text;
    }
}
