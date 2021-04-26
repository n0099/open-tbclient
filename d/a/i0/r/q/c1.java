package d.a.i0.r.q;

import tbclient.PbPage.NewsInfo;
/* loaded from: classes3.dex */
public class c1 {

    /* renamed from: a  reason: collision with root package name */
    public String f49102a;

    /* renamed from: b  reason: collision with root package name */
    public String f49103b;

    /* renamed from: c  reason: collision with root package name */
    public int f49104c;

    /* renamed from: d  reason: collision with root package name */
    public String f49105d;

    /* renamed from: e  reason: collision with root package name */
    public String f49106e;

    /* renamed from: f  reason: collision with root package name */
    public String f49107f;

    public void a(NewsInfo newsInfo) {
        if (newsInfo == null) {
            return;
        }
        this.f49102a = newsInfo.news_link;
        this.f49103b = newsInfo.summary;
        newsInfo.position.intValue();
        this.f49104c = newsInfo.news_type.intValue();
        this.f49105d = newsInfo.news_icon;
        this.f49106e = newsInfo.subtitle;
        this.f49107f = newsInfo.button_text;
    }
}
