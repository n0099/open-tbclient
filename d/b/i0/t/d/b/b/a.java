package d.b.i0.t.d.b.b;

import java.util.ArrayList;
import java.util.List;
import tbclient.LiveSquare.HotLiveWithCategory;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f60250a;

    /* renamed from: b  reason: collision with root package name */
    public String f60251b;

    /* renamed from: c  reason: collision with root package name */
    public String f60252c;

    /* renamed from: d  reason: collision with root package name */
    public String f60253d;

    /* renamed from: e  reason: collision with root package name */
    public List<ThreadInfo> f60254e;

    /* renamed from: f  reason: collision with root package name */
    public int f60255f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f60256g;

    public a(HotLiveWithCategory hotLiveWithCategory) {
        this.f60250a = hotLiveWithCategory.tab_id.intValue();
        this.f60251b = hotLiveWithCategory.entry_name;
        this.f60252c = hotLiveWithCategory.label_name;
        this.f60253d = hotLiveWithCategory.bitmap_wh_ratio;
        this.f60254e = new ArrayList(hotLiveWithCategory.live);
        this.f60255f = hotLiveWithCategory.live_tab_type.intValue();
        this.f60256g = hotLiveWithCategory.sub_type_list;
    }
}
