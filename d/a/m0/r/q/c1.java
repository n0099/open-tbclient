package d.a.m0.r.q;

import tbclient.PbPage.NewsInfo;
/* loaded from: classes3.dex */
public class c1 {

    /* renamed from: a  reason: collision with root package name */
    public String f49965a;

    /* renamed from: b  reason: collision with root package name */
    public String f49966b;

    /* renamed from: c  reason: collision with root package name */
    public int f49967c;

    /* renamed from: d  reason: collision with root package name */
    public String f49968d;

    /* renamed from: e  reason: collision with root package name */
    public String f49969e;

    /* renamed from: f  reason: collision with root package name */
    public String f49970f;

    public void a(NewsInfo newsInfo) {
        if (newsInfo == null) {
            return;
        }
        this.f49965a = newsInfo.news_link;
        this.f49966b = newsInfo.summary;
        newsInfo.position.intValue();
        this.f49967c = newsInfo.news_type.intValue();
        this.f49968d = newsInfo.news_icon;
        this.f49969e = newsInfo.subtitle;
        this.f49970f = newsInfo.button_text;
    }
}
