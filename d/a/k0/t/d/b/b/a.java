package d.a.k0.t.d.b.b;

import java.util.ArrayList;
import java.util.List;
import tbclient.LiveSquare.HotLiveWithCategory;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f61139a;

    /* renamed from: b  reason: collision with root package name */
    public String f61140b;

    /* renamed from: c  reason: collision with root package name */
    public String f61141c;

    /* renamed from: d  reason: collision with root package name */
    public String f61142d;

    /* renamed from: e  reason: collision with root package name */
    public List<ThreadInfo> f61143e;

    /* renamed from: f  reason: collision with root package name */
    public int f61144f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f61145g;

    public a(HotLiveWithCategory hotLiveWithCategory) {
        this.f61139a = hotLiveWithCategory.tab_id.intValue();
        this.f61140b = hotLiveWithCategory.entry_name;
        this.f61141c = hotLiveWithCategory.label_name;
        this.f61142d = hotLiveWithCategory.bitmap_wh_ratio;
        this.f61143e = new ArrayList(hotLiveWithCategory.live);
        this.f61144f = hotLiveWithCategory.live_tab_type.intValue();
        this.f61145g = hotLiveWithCategory.sub_type_list;
    }
}
