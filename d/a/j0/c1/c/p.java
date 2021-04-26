package d.a.j0.c1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.TopicList.TabList;
/* loaded from: classes4.dex */
public class p implements d.a.c.j.e.n {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f51732e;

    /* renamed from: f  reason: collision with root package name */
    public String f51733f;

    /* renamed from: g  reason: collision with root package name */
    public String f51734g;

    /* renamed from: h  reason: collision with root package name */
    public String f51735h;

    /* renamed from: i  reason: collision with root package name */
    public String f51736i;
    public String j;

    public void c(TabList tabList) {
        if (tabList == null) {
            return;
        }
        this.f51732e = tabList.tab_name;
        this.f51733f = tabList.tab_type;
        this.f51734g = tabList.share_pic;
        this.f51735h = tabList.share_title;
        this.f51736i = tabList.share_desc;
        this.j = tabList.share_url;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return k;
    }
}
