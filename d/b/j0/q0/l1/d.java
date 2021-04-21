package d.b.j0.q0.l1;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.squareup.wire.Message;
import d.b.c.j.e.n;
import d.b.i0.g0.b.h;
import d.b.i0.r.q.a2;
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
    public boolean f59923e;

    /* renamed from: h  reason: collision with root package name */
    public int f59926h;
    public String i;
    public String j;
    public boolean k;
    public SportScheduleInfo l;
    public ItemInfo n;
    public List<App> o;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, MetaData> f59924f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f59925g = new ArrayList<>();
    public int m = 1;

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f59923e = dataRes.has_more.intValue() == 1;
        if (!ListUtils.isEmpty(dataRes.user_list)) {
            for (User user : dataRes.user_list) {
                if (user != null) {
                    MetaData metaData = new MetaData();
                    metaData.parserProtobuf(user);
                    String userId = metaData.getUserId();
                    if (userId != null && !"0".equals(userId)) {
                        this.f59924f.put(userId, metaData);
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(dataRes.general_list)) {
            for (ThreadInfo threadInfo : dataRes.general_list) {
                if (threadInfo != null) {
                    a2 a2Var = new a2();
                    a2Var.q4(this.f59924f);
                    a2Var.A2 = true;
                    a2Var.R2(threadInfo);
                    a2Var.V2();
                    a2Var.J1();
                    this.f59925g.add(a2Var);
                }
            }
        }
        this.o = dataRes.app_list;
        d.b.i0.b.f.a.d(this.f59925g);
        this.f59926h = dataRes.new_thread_num.intValue();
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

    @Override // d.b.i0.g0.b.h
    public void initByJson(JSONObject jSONObject) {
    }

    @Override // d.b.i0.g0.b.h
    public void initByProtobuf(Message message) {
    }
}
