package d.b.i0.t.d.b.b;

import java.util.ArrayList;
import java.util.List;
import tbclient.LiveSquare.HotLiveWithCategory;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f60251a;

    /* renamed from: b  reason: collision with root package name */
    public String f60252b;

    /* renamed from: c  reason: collision with root package name */
    public String f60253c;

    /* renamed from: d  reason: collision with root package name */
    public String f60254d;

    /* renamed from: e  reason: collision with root package name */
    public List<ThreadInfo> f60255e;

    /* renamed from: f  reason: collision with root package name */
    public int f60256f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f60257g;

    public a(HotLiveWithCategory hotLiveWithCategory) {
        this.f60251a = hotLiveWithCategory.tab_id.intValue();
        this.f60252b = hotLiveWithCategory.entry_name;
        this.f60253c = hotLiveWithCategory.label_name;
        this.f60254d = hotLiveWithCategory.bitmap_wh_ratio;
        this.f60255e = new ArrayList(hotLiveWithCategory.live);
        this.f60256f = hotLiveWithCategory.live_tab_type.intValue();
        this.f60257g = hotLiveWithCategory.sub_type_list;
    }
}
