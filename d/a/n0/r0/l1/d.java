package d.a.n0.r0.l1;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.squareup.wire.Message;
import d.a.c.j.e.n;
import d.a.m0.g0.b.h;
import d.a.m0.r.q.a2;
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
    public boolean f58881e;

    /* renamed from: h  reason: collision with root package name */
    public int f58884h;

    /* renamed from: i  reason: collision with root package name */
    public String f58885i;
    public String j;
    public boolean k;
    public SportScheduleInfo l;
    public ItemInfo n;
    public List<App> o;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, MetaData> f58882f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f58883g = new ArrayList<>();
    public int m = 1;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f58881e = dataRes.has_more.intValue() == 1;
        if (!ListUtils.isEmpty(dataRes.user_list)) {
            for (User user : dataRes.user_list) {
                if (user != null) {
                    MetaData metaData = new MetaData();
                    metaData.parserProtobuf(user);
                    String userId = metaData.getUserId();
                    if (userId != null && !"0".equals(userId)) {
                        this.f58882f.put(userId, metaData);
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(dataRes.general_list)) {
            for (ThreadInfo threadInfo : dataRes.general_list) {
                if (threadInfo != null) {
                    a2 a2Var = new a2();
                    a2Var.t4(this.f58882f);
                    a2Var.B2 = true;
                    a2Var.U2(threadInfo);
                    a2Var.Y2();
                    a2Var.L1();
                    this.f58883g.add(a2Var);
                }
            }
        }
        this.o = dataRes.app_list;
        d.a.m0.b.f.a.d(this.f58883g);
        this.f58884h = dataRes.new_thread_num.intValue();
        SportPageHeadInfo sportPageHeadInfo = dataRes.sport_head_info;
        if (sportPageHeadInfo != null) {
            this.f58885i = sportPageHeadInfo.head_url;
            this.j = sportPageHeadInfo.jump_url;
            this.k = sportPageHeadInfo.is_ad.intValue() == 1;
        }
        this.l = dataRes.sport_schedule_info;
        this.m = dataRes.sort_type.intValue();
        this.n = dataRes.item_info;
    }

    @Override // d.a.m0.g0.b.h
    public void initByJson(JSONObject jSONObject) {
    }

    @Override // d.a.m0.g0.b.h
    public void initByProtobuf(Message message) {
    }
}
