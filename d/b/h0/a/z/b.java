package d.b.h0.a.z;

import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import d.b.h0.a.p;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public DataRes f50053a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f50054b = false;

    /* renamed from: c  reason: collision with root package name */
    public String f50055c = "";

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<d.b.h0.a.b> f50056d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<FloatStrategy> f50057e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public NewUserRedPackageData f50058f;

    /* renamed from: g  reason: collision with root package name */
    public ActiveCenterData f50059g;

    public ArrayList<FloatStrategy> a() {
        return this.f50057e;
    }

    public ArrayList<d.b.h0.a.b> b() {
        return this.f50056d;
    }

    public void c(DataRes dataRes) {
        this.f50053a = dataRes;
        this.f50056d.clear();
        this.f50057e.clear();
        if (dataRes == null) {
            return;
        }
        this.f50054b = dataRes.is_new_user.intValue() == 1;
        this.f50055c = dataRes.active_url;
        this.f50057e.addAll(dataRes.float_list);
        for (MissionInfo missionInfo : this.f50053a.mission_list) {
            if (missionInfo != null) {
                d.b.h0.a.b bVar = new d.b.h0.a.b(missionInfo);
                if (missionInfo.tasktype.intValue() == 5) {
                    d.b.h0.r.c0.a.e().g(missionInfo);
                } else if (missionInfo.tasktype.intValue() == 9) {
                    p.c().f(bVar);
                } else if (bVar.K()) {
                    this.f50056d.add(bVar);
                }
            }
        }
        NewUserRedPackageData newUserRedPackageData = new NewUserRedPackageData();
        this.f50058f = newUserRedPackageData;
        newUserRedPackageData.parseProto(dataRes);
        if (dataRes.active_center != null) {
            ActiveCenterData activeCenterData = new ActiveCenterData();
            this.f50059g = activeCenterData;
            activeCenterData.parseProto(dataRes);
        }
    }
}
