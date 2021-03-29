package d.b.i0.b1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.TopicList.TabList;
/* loaded from: classes3.dex */
public class p implements d.b.b.j.e.n {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f52145e;

    /* renamed from: f  reason: collision with root package name */
    public String f52146f;

    /* renamed from: g  reason: collision with root package name */
    public String f52147g;

    /* renamed from: h  reason: collision with root package name */
    public String f52148h;
    public String i;
    public String j;

    public void a(TabList tabList) {
        if (tabList == null) {
            return;
        }
        this.f52145e = tabList.tab_name;
        this.f52146f = tabList.tab_type;
        this.f52147g = tabList.share_pic;
        this.f52148h = tabList.share_title;
        this.i = tabList.share_desc;
        this.j = tabList.share_url;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return k;
    }
}
