package d.b.i0.p0.l1;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.squareup.wire.Message;
import d.b.b.j.e.n;
import d.b.h0.g0.b.h;
import d.b.h0.r.q.a2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.App;
import tbclient.GeneralTabList.DataRes;
import tbclient.ItemInfo;
import tbclient.SportPageHeadInfo;
import tbclient.SportScheduleInfo;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes4.dex */
public class d implements h {

    /* renamed from: e  reason: collision with root package name */
    public boolean f57802e;

    /* renamed from: h  reason: collision with root package name */
    public int f57805h;
    public String i;
    public String j;
    public boolean k;
    public SportScheduleInfo l;
    public ItemInfo n;
    public List<App> o;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, MetaData> f57803f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f57804g = new ArrayList<>();
    public int m = 1;

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f57802e = dataRes.has_more.intValue() == 1;
        if (!ListUtils.isEmpty(dataRes.user_list)) {
            for (User user : dataRes.user_list) {
                if (user != null) {
                    MetaData metaData = new MetaData();
                    metaData.parserProtobuf(user);
                    String userId = metaData.getUserId();
                    if (userId != null && !"0".equals(userId)) {
                        this.f57803f.put(userId, metaData);
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(dataRes.general_list)) {
            for (ThreadInfo threadInfo : dataRes.general_list) {
                if (threadInfo != null) {
                    a2 a2Var = new a2();
                    a2Var.p4(this.f57803f);
                    a2Var.A2 = true;
                    a2Var.Q2(threadInfo);
                    a2Var.U2();
                    a2Var.J1();
                    this.f57804g.add(a2Var);
                }
            }
        }
        this.o = dataRes.app_list;
        d.b.h0.b.f.a.d(this.f57804g);
        this.f57805h = dataRes.new_thread_num.intValue();
        SportPageHeadInfo sportPageHeadInfo = dataRes.sport_head_info;
        if (sportPageHeadInfo != null) {
            this.i = sportPageHeadInfo.head_url;
            this.j = sportPageHeadInfo.jump_url;
            this.k = sportPageHeadInfo.is_ad.intValue() == 1;
        }
        this.l = dataRes.sport_schedule_info;
        this.m = dataRes.sort_type.intValue();
        this.n = dataRes.item_info;
    }

    @Override // d.b.h0.g0.b.h
    public void initByJson(JSONObject jSONObject) {
    }

    @Override // d.b.h0.g0.b.h
    public void initByProtobuf(Message message) {
    }
}
