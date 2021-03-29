package d.b.h0.r.q;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes3.dex */
public class v1 {

    /* renamed from: a  reason: collision with root package name */
    public t0 f50909a;

    /* renamed from: b  reason: collision with root package name */
    public List<i> f50910b;

    /* renamed from: c  reason: collision with root package name */
    public List<j> f50911c;

    /* renamed from: d  reason: collision with root package name */
    public List<s0> f50912d;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery == null) {
            return;
        }
        t0 t0Var = new t0();
        this.f50909a = t0Var;
        t0Var.a(seniorLottery.theme);
        this.f50910b = new ArrayList();
        int size = seniorLottery.award_info.size();
        for (int i = 0; i < size; i++) {
            i iVar = new i();
            iVar.a(seniorLottery.award_info.get(i));
            this.f50910b.add(iVar);
        }
        String str = seniorLottery.myaward;
        this.f50911c = new ArrayList();
        int size2 = seniorLottery.luck_users.size();
        for (int i2 = 0; i2 < size2; i2++) {
            j jVar = new j();
            jVar.a(seniorLottery.luck_users.get(i2));
            this.f50911c.add(jVar);
        }
        String str2 = seniorLottery.act_desc;
        this.f50912d = new ArrayList();
        int size3 = seniorLottery.act_regular.size();
        for (int i3 = 0; i3 < size3; i3++) {
            s0 s0Var = new s0();
            s0Var.a(seniorLottery.act_regular.get(i3));
            this.f50912d.add(s0Var);
        }
    }
}
