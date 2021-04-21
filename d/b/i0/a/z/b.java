package d.b.i0.a.z;

import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import d.b.i0.a.p;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public DataRes f50389a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f50390b = false;

    /* renamed from: c  reason: collision with root package name */
    public String f50391c = "";

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<d.b.i0.a.b> f50392d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<FloatStrategy> f50393e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public NewUserRedPackageData f50394f;

    /* renamed from: g  reason: collision with root package name */
    public ActiveCenterData f50395g;

    public ArrayList<FloatStrategy> a() {
        return this.f50393e;
    }

    public ArrayList<d.b.i0.a.b> b() {
        return this.f50392d;
    }

    public void c(DataRes dataRes) {
        this.f50389a = dataRes;
        this.f50392d.clear();
        this.f50393e.clear();
        if (dataRes == null) {
            return;
        }
        this.f50390b = dataRes.is_new_user.intValue() == 1;
        this.f50391c = dataRes.active_url;
        this.f50393e.addAll(dataRes.float_list);
        for (MissionInfo missionInfo : this.f50389a.mission_list) {
            if (missionInfo != null) {
                d.b.i0.a.b bVar = new d.b.i0.a.b(missionInfo);
                if (missionInfo.tasktype.intValue() == 5) {
                    d.b.i0.r.c0.a.e().g(missionInfo);
                } else if (missionInfo.tasktype.intValue() == 9) {
                    p.c().f(bVar);
                } else if (bVar.K()) {
                    this.f50392d.add(bVar);
                }
            }
        }
        NewUserRedPackageData newUserRedPackageData = new NewUserRedPackageData();
        this.f50394f = newUserRedPackageData;
        newUserRedPackageData.parseProto(dataRes);
        if (dataRes.active_center != null) {
            ActiveCenterData activeCenterData = new ActiveCenterData();
            this.f50395g = activeCenterData;
            activeCenterData.parseProto(dataRes);
        }
    }
}
