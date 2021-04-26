package d.a.j0.t.d.b.b;

import java.util.ArrayList;
import java.util.List;
import tbclient.LiveSquare.HotLiveWithCategory;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f60415a;

    /* renamed from: b  reason: collision with root package name */
    public String f60416b;

    /* renamed from: c  reason: collision with root package name */
    public String f60417c;

    /* renamed from: d  reason: collision with root package name */
    public String f60418d;

    /* renamed from: e  reason: collision with root package name */
    public List<ThreadInfo> f60419e;

    /* renamed from: f  reason: collision with root package name */
    public int f60420f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f60421g;

    public a(HotLiveWithCategory hotLiveWithCategory) {
        this.f60415a = hotLiveWithCategory.tab_id.intValue();
        this.f60416b = hotLiveWithCategory.entry_name;
        this.f60417c = hotLiveWithCategory.label_name;
        this.f60418d = hotLiveWithCategory.bitmap_wh_ratio;
        this.f60419e = new ArrayList(hotLiveWithCategory.live);
        this.f60420f = hotLiveWithCategory.live_tab_type.intValue();
        this.f60421g = hotLiveWithCategory.sub_type_list;
    }
}
