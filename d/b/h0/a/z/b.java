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
    public DataRes f49660a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f49661b = false;

    /* renamed from: c  reason: collision with root package name */
    public String f49662c = "";

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<d.b.h0.a.b> f49663d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<FloatStrategy> f49664e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public NewUserRedPackageData f49665f;

    /* renamed from: g  reason: collision with root package name */
    public ActiveCenterData f49666g;

    public ArrayList<FloatStrategy> a() {
        return this.f49664e;
    }

    public ArrayList<d.b.h0.a.b> b() {
        return this.f49663d;
    }

    public void c(DataRes dataRes) {
        this.f49660a = dataRes;
        this.f49663d.clear();
        this.f49664e.clear();
        if (dataRes == null) {
            return;
        }
        this.f49661b = dataRes.is_new_user.intValue() == 1;
        this.f49662c = dataRes.active_url;
        this.f49664e.addAll(dataRes.float_list);
        for (MissionInfo missionInfo : this.f49660a.mission_list) {
            if (missionInfo != null) {
                d.b.h0.a.b bVar = new d.b.h0.a.b(missionInfo);
                if (missionInfo.tasktype.intValue() == 5) {
                    d.b.h0.r.c0.a.e().g(missionInfo);
                } else if (missionInfo.tasktype.intValue() == 9) {
                    p.c().f(bVar);
                } else if (bVar.K()) {
                    this.f49663d.add(bVar);
                }
            }
        }
        NewUserRedPackageData newUserRedPackageData = new NewUserRedPackageData();
        this.f49665f = newUserRedPackageData;
        newUserRedPackageData.parseProto(dataRes);
        if (dataRes.active_center != null) {
            ActiveCenterData activeCenterData = new ActiveCenterData();
            this.f49666g = activeCenterData;
            activeCenterData.parseProto(dataRes);
        }
    }
}
