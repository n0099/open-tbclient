package d.a.k0.c1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.TopicList.TabList;
/* loaded from: classes4.dex */
public class p implements d.a.c.j.e.n {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f52431e;

    /* renamed from: f  reason: collision with root package name */
    public String f52432f;

    /* renamed from: g  reason: collision with root package name */
    public String f52433g;

    /* renamed from: h  reason: collision with root package name */
    public String f52434h;

    /* renamed from: i  reason: collision with root package name */
    public String f52435i;
    public String j;

    public void c(TabList tabList) {
        if (tabList == null) {
            return;
        }
        this.f52431e = tabList.tab_name;
        this.f52432f = tabList.tab_type;
        this.f52433g = tabList.share_pic;
        this.f52434h = tabList.share_title;
        this.f52435i = tabList.share_desc;
        this.j = tabList.share_url;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return k;
    }
}
