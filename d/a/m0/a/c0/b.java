package d.a.m0.a.c0;

import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import d.a.m0.a.r;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public DataRes f52296a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f52297b = false;

    /* renamed from: c  reason: collision with root package name */
    public String f52298c = "";

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<d.a.m0.a.c> f52299d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<FloatStrategy> f52300e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public NewUserRedPackageData f52301f;

    /* renamed from: g  reason: collision with root package name */
    public ActiveCenterData f52302g;

    public ArrayList<FloatStrategy> a() {
        return this.f52300e;
    }

    public ArrayList<d.a.m0.a.c> b() {
        return this.f52299d;
    }

    public void c(DataRes dataRes) {
        this.f52296a = dataRes;
        this.f52299d.clear();
        this.f52300e.clear();
        if (dataRes == null) {
            return;
        }
        this.f52297b = dataRes.is_new_user.intValue() == 1;
        this.f52298c = dataRes.active_url;
        this.f52300e.addAll(dataRes.float_list);
        for (MissionInfo missionInfo : this.f52296a.mission_list) {
            if (missionInfo != null) {
                d.a.m0.a.c cVar = new d.a.m0.a.c(missionInfo);
                if (missionInfo.tasktype.intValue() == 5) {
                    d.a.m0.r.c0.a.e().g(missionInfo);
                } else if (missionInfo.tasktype.intValue() == 9) {
                    r.c().f(cVar);
                } else if (cVar.K()) {
                    this.f52299d.add(cVar);
                }
            }
        }
        NewUserRedPackageData newUserRedPackageData = new NewUserRedPackageData();
        this.f52301f = newUserRedPackageData;
        newUserRedPackageData.parseProto(dataRes);
        if (dataRes.active_center != null) {
            ActiveCenterData activeCenterData = new ActiveCenterData();
            this.f52302g = activeCenterData;
            activeCenterData.parseProto(dataRes);
        }
    }
}
