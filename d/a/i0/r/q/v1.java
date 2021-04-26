package d.a.i0.r.q;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes3.dex */
public class v1 {

    /* renamed from: a  reason: collision with root package name */
    public t0 f49287a;

    /* renamed from: b  reason: collision with root package name */
    public List<i> f49288b;

    /* renamed from: c  reason: collision with root package name */
    public List<j> f49289c;

    /* renamed from: d  reason: collision with root package name */
    public List<s0> f49290d;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery == null) {
            return;
        }
        t0 t0Var = new t0();
        this.f49287a = t0Var;
        t0Var.a(seniorLottery.theme);
        this.f49288b = new ArrayList();
        int size = seniorLottery.award_info.size();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = new i();
            iVar.a(seniorLottery.award_info.get(i2));
            this.f49288b.add(iVar);
        }
        String str = seniorLottery.myaward;
        this.f49289c = new ArrayList();
        int size2 = seniorLottery.luck_users.size();
        for (int i3 = 0; i3 < size2; i3++) {
            j jVar = new j();
            jVar.a(seniorLottery.luck_users.get(i3));
            this.f49289c.add(jVar);
        }
        String str2 = seniorLottery.act_desc;
        this.f49290d = new ArrayList();
        int size3 = seniorLottery.act_regular.size();
        for (int i4 = 0; i4 < size3; i4++) {
            s0 s0Var = new s0();
            s0Var.a(seniorLottery.act_regular.get(i4));
            this.f49290d.add(s0Var);
        }
    }
}
