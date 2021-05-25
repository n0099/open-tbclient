package d.a.n0.v.d.b.b;

import java.util.ArrayList;
import java.util.List;
import tbclient.LiveSquare.HotLiveWithCategory;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f61427a;

    /* renamed from: b  reason: collision with root package name */
    public String f61428b;

    /* renamed from: c  reason: collision with root package name */
    public String f61429c;

    /* renamed from: d  reason: collision with root package name */
    public String f61430d;

    /* renamed from: e  reason: collision with root package name */
    public List<ThreadInfo> f61431e;

    /* renamed from: f  reason: collision with root package name */
    public int f61432f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f61433g;

    public a(HotLiveWithCategory hotLiveWithCategory) {
        this.f61427a = hotLiveWithCategory.tab_id.intValue();
        this.f61428b = hotLiveWithCategory.entry_name;
        this.f61429c = hotLiveWithCategory.label_name;
        this.f61430d = hotLiveWithCategory.bitmap_wh_ratio;
        this.f61431e = new ArrayList(hotLiveWithCategory.live);
        this.f61432f = hotLiveWithCategory.live_tab_type.intValue();
        this.f61433g = hotLiveWithCategory.sub_type_list;
    }
}
