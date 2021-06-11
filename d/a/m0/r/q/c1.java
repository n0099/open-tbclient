package d.a.m0.r.q;

import tbclient.PbPage.NewsInfo;
/* loaded from: classes3.dex */
public class c1 {

    /* renamed from: a  reason: collision with root package name */
    public String f53641a;

    /* renamed from: b  reason: collision with root package name */
    public String f53642b;

    /* renamed from: c  reason: collision with root package name */
    public int f53643c;

    /* renamed from: d  reason: collision with root package name */
    public String f53644d;

    /* renamed from: e  reason: collision with root package name */
    public String f53645e;

    /* renamed from: f  reason: collision with root package name */
    public String f53646f;

    public void a(NewsInfo newsInfo) {
        if (newsInfo == null) {
            return;
        }
        this.f53641a = newsInfo.news_link;
        this.f53642b = newsInfo.summary;
        newsInfo.position.intValue();
        this.f53643c = newsInfo.news_type.intValue();
        this.f53644d = newsInfo.news_icon;
        this.f53645e = newsInfo.subtitle;
        this.f53646f = newsInfo.button_text;
    }
}
