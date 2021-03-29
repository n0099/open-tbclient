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
    public DataRes f49661a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f49662b = false;

    /* renamed from: c  reason: collision with root package name */
    public String f49663c = "";

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<d.b.h0.a.b> f49664d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<FloatStrategy> f49665e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public NewUserRedPackageData f49666f;

    /* renamed from: g  reason: collision with root package name */
    public ActiveCenterData f49667g;

    public ArrayList<FloatStrategy> a() {
        return this.f49665e;
    }

    public ArrayList<d.b.h0.a.b> b() {
        return this.f49664d;
    }

    public void c(DataRes dataRes) {
        this.f49661a = dataRes;
        this.f49664d.clear();
        this.f49665e.clear();
        if (dataRes == null) {
            return;
        }
        this.f49662b = dataRes.is_new_user.intValue() == 1;
        this.f49663c = dataRes.active_url;
        this.f49665e.addAll(dataRes.float_list);
        for (MissionInfo missionInfo : this.f49661a.mission_list) {
            if (missionInfo != null) {
                d.b.h0.a.b bVar = new d.b.h0.a.b(missionInfo);
                if (missionInfo.tasktype.intValue() == 5) {
                    d.b.h0.r.c0.a.e().g(missionInfo);
                } else if (missionInfo.tasktype.intValue() == 9) {
                    p.c().f(bVar);
                } else if (bVar.K()) {
                    this.f49664d.add(bVar);
                }
            }
        }
        NewUserRedPackageData newUserRedPackageData = new NewUserRedPackageData();
        this.f49666f = newUserRedPackageData;
        newUserRedPackageData.parseProto(dataRes);
        if (dataRes.active_center != null) {
            ActiveCenterData activeCenterData = new ActiveCenterData();
            this.f49667g = activeCenterData;
            activeCenterData.parseProto(dataRes);
        }
    }
}
