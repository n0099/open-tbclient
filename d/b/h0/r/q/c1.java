package d.b.h0.r.q;

import tbclient.PbPage.NewsInfo;
/* loaded from: classes3.dex */
public class c1 {

    /* renamed from: a  reason: collision with root package name */
    public String f50734a;

    /* renamed from: b  reason: collision with root package name */
    public String f50735b;

    /* renamed from: c  reason: collision with root package name */
    public int f50736c;

    /* renamed from: d  reason: collision with root package name */
    public String f50737d;

    /* renamed from: e  reason: collision with root package name */
    public String f50738e;

    /* renamed from: f  reason: collision with root package name */
    public String f50739f;

    public void a(NewsInfo newsInfo) {
        if (newsInfo == null) {
            return;
        }
        this.f50734a = newsInfo.news_link;
        this.f50735b = newsInfo.summary;
        newsInfo.position.intValue();
        this.f50736c = newsInfo.news_type.intValue();
        this.f50737d = newsInfo.news_icon;
        this.f50738e = newsInfo.subtitle;
        this.f50739f = newsInfo.button_text;
    }
}
