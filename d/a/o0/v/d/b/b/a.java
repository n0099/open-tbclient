package d.a.o0.v.d.b.b;

import java.util.ArrayList;
import java.util.List;
import tbclient.LiveSquare.HotLiveWithCategory;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f65265a;

    /* renamed from: b  reason: collision with root package name */
    public String f65266b;

    /* renamed from: c  reason: collision with root package name */
    public String f65267c;

    /* renamed from: d  reason: collision with root package name */
    public String f65268d;

    /* renamed from: e  reason: collision with root package name */
    public List<ThreadInfo> f65269e;

    /* renamed from: f  reason: collision with root package name */
    public int f65270f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f65271g;

    public a(HotLiveWithCategory hotLiveWithCategory) {
        this.f65265a = hotLiveWithCategory.tab_id.intValue();
        this.f65266b = hotLiveWithCategory.entry_name;
        this.f65267c = hotLiveWithCategory.label_name;
        this.f65268d = hotLiveWithCategory.bitmap_wh_ratio;
        this.f65269e = new ArrayList(hotLiveWithCategory.live);
        this.f65270f = hotLiveWithCategory.live_tab_type.intValue();
        this.f65271g = hotLiveWithCategory.sub_type_list;
    }
}
