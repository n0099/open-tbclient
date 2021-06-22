package d.a.n0.a.c0;

import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import d.a.n0.a.r;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public DataRes f52403a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f52404b = false;

    /* renamed from: c  reason: collision with root package name */
    public String f52405c = "";

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<d.a.n0.a.c> f52406d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<FloatStrategy> f52407e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public NewUserRedPackageData f52408f;

    /* renamed from: g  reason: collision with root package name */
    public ActiveCenterData f52409g;

    public ArrayList<FloatStrategy> a() {
        return this.f52407e;
    }

    public ArrayList<d.a.n0.a.c> b() {
        return this.f52406d;
    }

    public void c(DataRes dataRes) {
        this.f52403a = dataRes;
        this.f52406d.clear();
        this.f52407e.clear();
        if (dataRes == null) {
            return;
        }
        this.f52404b = dataRes.is_new_user.intValue() == 1;
        this.f52405c = dataRes.active_url;
        this.f52407e.addAll(dataRes.float_list);
        for (MissionInfo missionInfo : this.f52403a.mission_list) {
            if (missionInfo != null) {
                d.a.n0.a.c cVar = new d.a.n0.a.c(missionInfo);
                if (missionInfo.tasktype.intValue() == 5) {
                    d.a.n0.r.c0.a.e().g(missionInfo);
                } else if (missionInfo.tasktype.intValue() == 9) {
                    r.c().f(cVar);
                } else if (cVar.K()) {
                    this.f52406d.add(cVar);
                }
            }
        }
        NewUserRedPackageData newUserRedPackageData = new NewUserRedPackageData();
        this.f52408f = newUserRedPackageData;
        newUserRedPackageData.parseProto(dataRes);
        if (dataRes.active_center != null) {
            ActiveCenterData activeCenterData = new ActiveCenterData();
            this.f52409g = activeCenterData;
            activeCenterData.parseProto(dataRes);
        }
    }
}
