package d.a.n0.d1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.TopicList.TabList;
/* loaded from: classes4.dex */
public class p implements d.a.c.j.e.n {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f52611e;

    /* renamed from: f  reason: collision with root package name */
    public String f52612f;

    /* renamed from: g  reason: collision with root package name */
    public String f52613g;

    /* renamed from: h  reason: collision with root package name */
    public String f52614h;

    /* renamed from: i  reason: collision with root package name */
    public String f52615i;
    public String j;

    public void c(TabList tabList) {
        if (tabList == null) {
            return;
        }
        this.f52611e = tabList.tab_name;
        this.f52612f = tabList.tab_type;
        this.f52613g = tabList.share_pic;
        this.f52614h = tabList.share_title;
        this.f52615i = tabList.share_desc;
        this.j = tabList.share_url;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return k;
    }
}
