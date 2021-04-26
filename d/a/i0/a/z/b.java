package d.a.i0.a.z;

import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import d.a.i0.a.p;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public DataRes f47943a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f47944b = false;

    /* renamed from: c  reason: collision with root package name */
    public String f47945c = "";

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<d.a.i0.a.b> f47946d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<FloatStrategy> f47947e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public NewUserRedPackageData f47948f;

    /* renamed from: g  reason: collision with root package name */
    public ActiveCenterData f47949g;

    public ArrayList<FloatStrategy> a() {
        return this.f47947e;
    }

    public ArrayList<d.a.i0.a.b> b() {
        return this.f47946d;
    }

    public void c(DataRes dataRes) {
        this.f47943a = dataRes;
        this.f47946d.clear();
        this.f47947e.clear();
        if (dataRes == null) {
            return;
        }
        this.f47944b = dataRes.is_new_user.intValue() == 1;
        this.f47945c = dataRes.active_url;
        this.f47947e.addAll(dataRes.float_list);
        for (MissionInfo missionInfo : this.f47943a.mission_list) {
            if (missionInfo != null) {
                d.a.i0.a.b bVar = new d.a.i0.a.b(missionInfo);
                if (missionInfo.tasktype.intValue() == 5) {
                    d.a.i0.r.c0.a.e().g(missionInfo);
                } else if (missionInfo.tasktype.intValue() == 9) {
                    p.c().f(bVar);
                } else if (bVar.K()) {
                    this.f47946d.add(bVar);
                }
            }
        }
        NewUserRedPackageData newUserRedPackageData = new NewUserRedPackageData();
        this.f47948f = newUserRedPackageData;
        newUserRedPackageData.parseProto(dataRes);
        if (dataRes.active_center != null) {
            ActiveCenterData activeCenterData = new ActiveCenterData();
            this.f47949g = activeCenterData;
            activeCenterData.parseProto(dataRes);
        }
    }
}
