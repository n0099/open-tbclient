package d.a.n0.d1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.TopicList.TabList;
/* loaded from: classes4.dex */
public class p implements d.a.c.k.e.n {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f56300e;

    /* renamed from: f  reason: collision with root package name */
    public String f56301f;

    /* renamed from: g  reason: collision with root package name */
    public String f56302g;

    /* renamed from: h  reason: collision with root package name */
    public String f56303h;

    /* renamed from: i  reason: collision with root package name */
    public String f56304i;
    public String j;

    public void b(TabList tabList) {
        if (tabList == null) {
            return;
        }
        this.f56300e = tabList.tab_name;
        this.f56301f = tabList.tab_type;
        this.f56302g = tabList.share_pic;
        this.f56303h = tabList.share_title;
        this.f56304i = tabList.share_desc;
        this.j = tabList.share_url;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return k;
    }
}
