package d.a.j0.d2.k.e;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.HashMap;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.DislikeInfo;
/* loaded from: classes3.dex */
public class y implements d.a.c.j.e.n {
    public static final BdUniqueId t = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f52583e;

    /* renamed from: f  reason: collision with root package name */
    public int f52584f;

    /* renamed from: g  reason: collision with root package name */
    public String f52585g;

    /* renamed from: h  reason: collision with root package name */
    public String f52586h;

    /* renamed from: i  reason: collision with root package name */
    public int f52587i;
    public long j;
    public MetaData k;
    public HashMap<String, MetaData> l;
    public boolean m;
    public String n;
    public String o;
    public boolean p = false;
    public boolean q = false;
    public boolean r = false;
    public d.a.i0.r.q.v0 s;

    public void c(AlaLiveInfo alaLiveInfo) {
        HashMap<String, MetaData> hashMap;
        MetaData metaData;
        if (alaLiveInfo == null || alaLiveInfo.user_info == null || alaLiveInfo.live_status.intValue() != 1 || alaLiveInfo.pb_display_type.intValue() != 1) {
            return;
        }
        this.f52583e = alaLiveInfo.user_info.user_name;
        this.f52585g = alaLiveInfo.description;
        this.f52586h = alaLiveInfo.cover;
        this.f52584f = alaLiveInfo.audience_count.intValue();
        this.f52587i = alaLiveInfo.live_status.intValue();
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
            d.a.i0.r.q.v0 v0Var = new d.a.i0.r.q.v0();
            this.s = v0Var;
            v0Var.j(sparseArray);
            this.s.f49284g = sparseArray2;
        } else {
            this.s = null;
        }
        this.p = true;
    }

    public void e() {
        this.f52583e = null;
        this.f52584f = 0;
        this.f52585g = null;
        this.f52586h = null;
        this.f52587i = 0;
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

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return t;
    }

    public boolean isValid() {
        return this.p;
    }
}
