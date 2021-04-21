package d.b.j0.t.d.b.b;

import java.util.ArrayList;
import java.util.List;
import tbclient.LiveSquare.HotLiveWithCategory;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f62236a;

    /* renamed from: b  reason: collision with root package name */
    public String f62237b;

    /* renamed from: c  reason: collision with root package name */
    public String f62238c;

    /* renamed from: d  reason: collision with root package name */
    public String f62239d;

    /* renamed from: e  reason: collision with root package name */
    public List<ThreadInfo> f62240e;

    /* renamed from: f  reason: collision with root package name */
    public int f62241f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f62242g;

    public a(HotLiveWithCategory hotLiveWithCategory) {
        this.f62236a = hotLiveWithCategory.tab_id.intValue();
        this.f62237b = hotLiveWithCategory.entry_name;
        this.f62238c = hotLiveWithCategory.label_name;
        this.f62239d = hotLiveWithCategory.bitmap_wh_ratio;
        this.f62240e = new ArrayList(hotLiveWithCategory.live);
        this.f62241f = hotLiveWithCategory.live_tab_type.intValue();
        this.f62242g = hotLiveWithCategory.sub_type_list;
    }
}
