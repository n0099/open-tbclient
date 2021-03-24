package d.b.i0.b1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.TopicList.TabList;
/* loaded from: classes4.dex */
public class p implements d.b.b.j.e.n {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f52144e;

    /* renamed from: f  reason: collision with root package name */
    public String f52145f;

    /* renamed from: g  reason: collision with root package name */
    public String f52146g;

    /* renamed from: h  reason: collision with root package name */
    public String f52147h;
    public String i;
    public String j;

    public void a(TabList tabList) {
        if (tabList == null) {
            return;
        }
        this.f52144e = tabList.tab_name;
        this.f52145f = tabList.tab_type;
        this.f52146g = tabList.share_pic;
        this.f52147h = tabList.share_title;
        this.i = tabList.share_desc;
        this.j = tabList.share_url;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return k;
    }
}
