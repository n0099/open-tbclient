package d.a.n0.v.d.b.b;

import java.util.ArrayList;
import java.util.List;
import tbclient.LiveSquare.HotLiveWithCategory;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f65140a;

    /* renamed from: b  reason: collision with root package name */
    public String f65141b;

    /* renamed from: c  reason: collision with root package name */
    public String f65142c;

    /* renamed from: d  reason: collision with root package name */
    public String f65143d;

    /* renamed from: e  reason: collision with root package name */
    public List<ThreadInfo> f65144e;

    /* renamed from: f  reason: collision with root package name */
    public int f65145f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f65146g;

    public a(HotLiveWithCategory hotLiveWithCategory) {
        this.f65140a = hotLiveWithCategory.tab_id.intValue();
        this.f65141b = hotLiveWithCategory.entry_name;
        this.f65142c = hotLiveWithCategory.label_name;
        this.f65143d = hotLiveWithCategory.bitmap_wh_ratio;
        this.f65144e = new ArrayList(hotLiveWithCategory.live);
        this.f65145f = hotLiveWithCategory.live_tab_type.intValue();
        this.f65146g = hotLiveWithCategory.sub_type_list;
    }
}
