package d.b.i0.t.d.b.b;

import java.util.ArrayList;
import java.util.List;
import tbclient.LiveSquare.HotLiveWithCategory;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f61815a;

    /* renamed from: b  reason: collision with root package name */
    public String f61816b;

    /* renamed from: c  reason: collision with root package name */
    public String f61817c;

    /* renamed from: d  reason: collision with root package name */
    public String f61818d;

    /* renamed from: e  reason: collision with root package name */
    public List<ThreadInfo> f61819e;

    /* renamed from: f  reason: collision with root package name */
    public int f61820f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f61821g;

    public a(HotLiveWithCategory hotLiveWithCategory) {
        this.f61815a = hotLiveWithCategory.tab_id.intValue();
        this.f61816b = hotLiveWithCategory.entry_name;
        this.f61817c = hotLiveWithCategory.label_name;
        this.f61818d = hotLiveWithCategory.bitmap_wh_ratio;
        this.f61819e = new ArrayList(hotLiveWithCategory.live);
        this.f61820f = hotLiveWithCategory.live_tab_type.intValue();
        this.f61821g = hotLiveWithCategory.sub_type_list;
    }
}
