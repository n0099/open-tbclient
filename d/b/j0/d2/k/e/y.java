package d.b.j0.d2.k.e;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.HashMap;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.DislikeInfo;
/* loaded from: classes3.dex */
public class y implements d.b.c.j.e.n {
    public static final BdUniqueId t = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f54769e;

    /* renamed from: f  reason: collision with root package name */
    public int f54770f;

    /* renamed from: g  reason: collision with root package name */
    public String f54771g;

    /* renamed from: h  reason: collision with root package name */
    public String f54772h;
    public int i;
    public long j;
    public MetaData k;
    public HashMap<String, MetaData> l;
    public boolean m;
    public String n;
    public String o;
    public boolean p = false;
    public boolean q = false;
    public boolean r = false;
    public d.b.i0.r.q.v0 s;

    public void a(AlaLiveInfo alaLiveInfo) {
        HashMap<String, MetaData> hashMap;
        MetaData metaData;
        if (alaLiveInfo == null || alaLiveInfo.user_info == null || alaLiveInfo.live_status.intValue() != 1 || alaLiveInfo.pb_display_type.intValue() != 1) {
            return;
        }
        this.f54769e = alaLiveInfo.user_info.user_name;
        this.f54771g = alaLiveInfo.description;
        this.f54772h = alaLiveInfo.cover;
        this.f54770f = alaLiveInfo.audience_count.intValue();
        this.i = alaLiveInfo.live_status.intValue();
        this.j = alaLiveInfo.live_id.longValue();
        this.m = alaLiveInfo.live_from.intValue() == 1;
        this.n = alaLiveInfo.third_live_type;
        this.o = alaLiveInfo.third_room_id;
        String str = alaLiveInfo.router_type;
        Long l = alaLiveInfo.user_info.user_id;
        if (l != null && l.longValue() > 0 && (hashMap = this.l) != null && (metaData = hashMap.get(alaLiveInfo.user_info.user_id.toString())) != null) {
            this.k = metaData;
            metaData.setIsLike(metaData.hadConcerned());
        }
        List<DislikeInfo> list = alaLiveInfo.dislike_info;
        if (ListUtils.getCount(list) > 0) {
            SparseArray<String> sparseArray = new SparseArray<>();
            SparseArray<String> sparseArray2 = new SparseArray<>();
            for (DislikeInfo dislikeInfo : list) {
                if (dislikeInfo != null) {
                    sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                    sparseArray2.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.extra);
                }
            }
            d.b.i0.r.q.v0 v0Var = new d.b.i0.r.q.v0();
            this.s = v0Var;
            v0Var.j(sparseArray);
            this.s.f51650g = sparseArray2;
        } else {
            this.s = null;
        }
        this.p = true;
    }

    public void e() {
        this.f54769e = null;
        this.f54770f = 0;
        this.f54771g = null;
        this.f54772h = null;
        this.i = 0;
        this.j = 0L;
        this.k = null;
        this.l = null;
        this.m = false;
        this.n = null;
        this.o = null;
        this.r = false;
        this.p = false;
    }

    public void f(HashMap<String, MetaData> hashMap) {
        this.l = hashMap;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return t;
    }

    public boolean isValid() {
        return this.p;
    }
}
