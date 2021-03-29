package d.b.h0.r.q;

import tbclient.PbPage.NewsInfo;
/* loaded from: classes3.dex */
public class c1 {

    /* renamed from: a  reason: collision with root package name */
    public String f50735a;

    /* renamed from: b  reason: collision with root package name */
    public String f50736b;

    /* renamed from: c  reason: collision with root package name */
    public int f50737c;

    /* renamed from: d  reason: collision with root package name */
    public String f50738d;

    /* renamed from: e  reason: collision with root package name */
    public String f50739e;

    /* renamed from: f  reason: collision with root package name */
    public String f50740f;

    public void a(NewsInfo newsInfo) {
        if (newsInfo == null) {
            return;
        }
        this.f50735a = newsInfo.news_link;
        this.f50736b = newsInfo.summary;
        newsInfo.position.intValue();
        this.f50737c = newsInfo.news_type.intValue();
        this.f50738d = newsInfo.news_icon;
        this.f50739e = newsInfo.subtitle;
        this.f50740f = newsInfo.button_text;
    }
}
