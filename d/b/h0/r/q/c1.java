package d.b.h0.r.q;

import tbclient.PbPage.NewsInfo;
/* loaded from: classes3.dex */
public class c1 {

    /* renamed from: a  reason: collision with root package name */
    public String f51142a;

    /* renamed from: b  reason: collision with root package name */
    public String f51143b;

    /* renamed from: c  reason: collision with root package name */
    public int f51144c;

    /* renamed from: d  reason: collision with root package name */
    public String f51145d;

    /* renamed from: e  reason: collision with root package name */
    public String f51146e;

    /* renamed from: f  reason: collision with root package name */
    public String f51147f;

    public void a(NewsInfo newsInfo) {
        if (newsInfo == null) {
            return;
        }
        this.f51142a = newsInfo.news_link;
        this.f51143b = newsInfo.summary;
        newsInfo.position.intValue();
        this.f51144c = newsInfo.news_type.intValue();
        this.f51145d = newsInfo.news_icon;
        this.f51146e = newsInfo.subtitle;
        this.f51147f = newsInfo.button_text;
    }
}
