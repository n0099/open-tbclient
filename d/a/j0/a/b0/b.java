package d.a.j0.a.b0;

import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import d.a.j0.a.q;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public DataRes f48598a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f48599b = false;

    /* renamed from: c  reason: collision with root package name */
    public String f48600c = "";

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<d.a.j0.a.b> f48601d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<FloatStrategy> f48602e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public NewUserRedPackageData f48603f;

    /* renamed from: g  reason: collision with root package name */
    public ActiveCenterData f48604g;

    public ArrayList<FloatStrategy> a() {
        return this.f48602e;
    }

    public ArrayList<d.a.j0.a.b> b() {
        return this.f48601d;
    }

    public void c(DataRes dataRes) {
        this.f48598a = dataRes;
        this.f48601d.clear();
        this.f48602e.clear();
        if (dataRes == null) {
            return;
        }
        this.f48599b = dataRes.is_new_user.intValue() == 1;
        this.f48600c = dataRes.active_url;
        this.f48602e.addAll(dataRes.float_list);
        for (MissionInfo missionInfo : this.f48598a.mission_list) {
            if (missionInfo != null) {
                d.a.j0.a.b bVar = new d.a.j0.a.b(missionInfo);
                if (missionInfo.tasktype.intValue() == 5) {
                    d.a.j0.r.c0.a.e().g(missionInfo);
                } else if (missionInfo.tasktype.intValue() == 9) {
                    q.c().f(bVar);
                } else if (bVar.K()) {
                    this.f48601d.add(bVar);
                }
            }
        }
        NewUserRedPackageData newUserRedPackageData = new NewUserRedPackageData();
        this.f48603f = newUserRedPackageData;
        newUserRedPackageData.parseProto(dataRes);
        if (dataRes.active_center != null) {
            ActiveCenterData activeCenterData = new ActiveCenterData();
            this.f48604g = activeCenterData;
            activeCenterData.parseProto(dataRes);
        }
    }
}
