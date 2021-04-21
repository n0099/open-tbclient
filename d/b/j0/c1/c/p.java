package d.b.j0.c1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.TopicList.TabList;
/* loaded from: classes4.dex */
public class p implements d.b.c.j.e.n {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f53967e;

    /* renamed from: f  reason: collision with root package name */
    public String f53968f;

    /* renamed from: g  reason: collision with root package name */
    public String f53969g;

    /* renamed from: h  reason: collision with root package name */
    public String f53970h;
    public String i;
    public String j;

    public void a(TabList tabList) {
        if (tabList == null) {
            return;
        }
        this.f53967e = tabList.tab_name;
        this.f53968f = tabList.tab_type;
        this.f53969g = tabList.share_pic;
        this.f53970h = tabList.share_title;
        this.i = tabList.share_desc;
        this.j = tabList.share_url;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return k;
    }
}
