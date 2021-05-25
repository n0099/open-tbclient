package d.a.n0.e2.k.e;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.HashMap;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.DislikeInfo;
/* loaded from: classes5.dex */
public class a0 implements d.a.c.j.e.n {
    public static final BdUniqueId s = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f53076e;

    /* renamed from: f  reason: collision with root package name */
    public int f53077f;

    /* renamed from: g  reason: collision with root package name */
    public int f53078g;

    /* renamed from: h  reason: collision with root package name */
    public String f53079h;

    /* renamed from: i  reason: collision with root package name */
    public String f53080i;
    public long j;
    public MetaData k;
    public HashMap<String, MetaData> l;
    public boolean m;
    public String n;
    public String o;
    public boolean p;
    public boolean q = false;
    public d.a.m0.r.q.v0 r;

    public void c(AlaLiveInfo alaLiveInfo) {
        HashMap<String, MetaData> hashMap;
        MetaData metaData;
        if (alaLiveInfo != null && alaLiveInfo.user_info != null && alaLiveInfo.pb_display_type.intValue() == 3 && alaLiveInfo.live_status.intValue() == 1) {
            this.f53076e = alaLiveInfo.user_info.user_name;
            this.f53077f = alaLiveInfo.live_status.intValue();
            this.f53078g = alaLiveInfo.audience_count.intValue();
            this.f53079h = alaLiveInfo.description;
            this.f53080i = alaLiveInfo.cover;
            this.j = alaLiveInfo.live_id.longValue();
            this.m = alaLiveInfo.live_from.intValue() == 1;
            this.n = alaLiveInfo.third_live_type;
            this.o = alaLiveInfo.third_room_id;
            String str = alaLiveInfo.router_type;
            Long l = alaLiveInfo.user_info.user_id;
            if (l != null && l.longValue() > 0 && (hashMap = this.l) != null && (metaData = hashMap.get(alaLiveInfo.user_info.user_id.toString())) != null) {
                this.k = metaData;
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
                d.a.m0.r.q.v0 v0Var = new d.a.m0.r.q.v0();
                this.r = v0Var;
                v0Var.j(sparseArray);
                this.r.f50147g = sparseArray2;
            } else {
                this.r = null;
            }
            this.p = true;
            return;
        }
        this.p = false;
    }

    public void e(HashMap<String, MetaData> hashMap) {
        this.l = hashMap;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return s;
    }

    public boolean isValid() {
        return this.p;
    }
}
