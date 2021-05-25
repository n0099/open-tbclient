package d.a.m0.a.b0;

import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import d.a.m0.a.q;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public DataRes f48620a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f48621b = false;

    /* renamed from: c  reason: collision with root package name */
    public String f48622c = "";

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<d.a.m0.a.b> f48623d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<FloatStrategy> f48624e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public NewUserRedPackageData f48625f;

    /* renamed from: g  reason: collision with root package name */
    public ActiveCenterData f48626g;

    public ArrayList<FloatStrategy> a() {
        return this.f48624e;
    }

    public ArrayList<d.a.m0.a.b> b() {
        return this.f48623d;
    }

    public void c(DataRes dataRes) {
        this.f48620a = dataRes;
        this.f48623d.clear();
        this.f48624e.clear();
        if (dataRes == null) {
            return;
        }
        this.f48621b = dataRes.is_new_user.intValue() == 1;
        this.f48622c = dataRes.active_url;
        this.f48624e.addAll(dataRes.float_list);
        for (MissionInfo missionInfo : this.f48620a.mission_list) {
            if (missionInfo != null) {
                d.a.m0.a.b bVar = new d.a.m0.a.b(missionInfo);
                if (missionInfo.tasktype.intValue() == 5) {
                    d.a.m0.r.c0.a.e().g(missionInfo);
                } else if (missionInfo.tasktype.intValue() == 9) {
                    q.c().f(bVar);
                } else if (bVar.K()) {
                    this.f48623d.add(bVar);
                }
            }
        }
        NewUserRedPackageData newUserRedPackageData = new NewUserRedPackageData();
        this.f48625f = newUserRedPackageData;
        newUserRedPackageData.parseProto(dataRes);
        if (dataRes.active_center != null) {
            ActiveCenterData activeCenterData = new ActiveCenterData();
            this.f48626g = activeCenterData;
            activeCenterData.parseProto(dataRes);
        }
    }
}
