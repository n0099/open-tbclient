package d.b.i0.c1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.TopicList.TabList;
/* loaded from: classes4.dex */
public class p implements d.b.c.j.e.n {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f53546e;

    /* renamed from: f  reason: collision with root package name */
    public String f53547f;

    /* renamed from: g  reason: collision with root package name */
    public String f53548g;

    /* renamed from: h  reason: collision with root package name */
    public String f53549h;
    public String i;
    public String j;

    public void a(TabList tabList) {
        if (tabList == null) {
            return;
        }
        this.f53546e = tabList.tab_name;
        this.f53547f = tabList.tab_type;
        this.f53548g = tabList.share_pic;
        this.f53549h = tabList.share_title;
        this.i = tabList.share_desc;
        this.j = tabList.share_url;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return k;
    }
}
