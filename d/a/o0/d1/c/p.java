package d.a.o0.d1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.TopicList.TabList;
/* loaded from: classes4.dex */
public class p implements d.a.c.k.e.n {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f56425e;

    /* renamed from: f  reason: collision with root package name */
    public String f56426f;

    /* renamed from: g  reason: collision with root package name */
    public String f56427g;

    /* renamed from: h  reason: collision with root package name */
    public String f56428h;

    /* renamed from: i  reason: collision with root package name */
    public String f56429i;
    public String j;

    public void b(TabList tabList) {
        if (tabList == null) {
            return;
        }
        this.f56425e = tabList.tab_name;
        this.f56426f = tabList.tab_type;
        this.f56427g = tabList.share_pic;
        this.f56428h = tabList.share_title;
        this.f56429i = tabList.share_desc;
        this.j = tabList.share_url;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return k;
    }
}
