package d.a.r0.r.q;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes9.dex */
public class w1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public u0 f56088a;

    /* renamed from: b  reason: collision with root package name */
    public List<j> f56089b;

    /* renamed from: c  reason: collision with root package name */
    public List<k> f56090c;

    /* renamed from: d  reason: collision with root package name */
    public List<t0> f56091d;

    public w1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(SeniorLottery seniorLottery) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, seniorLottery) == null) || seniorLottery == null) {
            return;
        }
        u0 u0Var = new u0();
        this.f56088a = u0Var;
        u0Var.a(seniorLottery.theme);
        this.f56089b = new ArrayList();
        int size = seniorLottery.award_info.size();
        for (int i2 = 0; i2 < size; i2++) {
            j jVar = new j();
            jVar.a(seniorLottery.award_info.get(i2));
            this.f56089b.add(jVar);
        }
        String str = seniorLottery.myaward;
        this.f56090c = new ArrayList();
        int size2 = seniorLottery.luck_users.size();
        for (int i3 = 0; i3 < size2; i3++) {
            k kVar = new k();
            kVar.a(seniorLottery.luck_users.get(i3));
            this.f56090c.add(kVar);
        }
        String str2 = seniorLottery.act_desc;
        this.f56091d = new ArrayList();
        int size3 = seniorLottery.act_regular.size();
        for (int i4 = 0; i4 < size3; i4++) {
            t0 t0Var = new t0();
            t0Var.a(seniorLottery.act_regular.get(i4));
            this.f56091d.add(t0Var);
        }
    }
}
