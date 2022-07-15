package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes6.dex */
public class kq4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ip4 a;
    public List<xn4> b;
    public List<yn4> c;
    public List<hp4> d;

    public kq4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        ip4 ip4Var = new ip4();
        this.a = ip4Var;
        ip4Var.a(seniorLottery.theme);
        this.b = new ArrayList();
        int size = seniorLottery.award_info.size();
        for (int i = 0; i < size; i++) {
            xn4 xn4Var = new xn4();
            xn4Var.a(seniorLottery.award_info.get(i));
            this.b.add(xn4Var);
        }
        String str = seniorLottery.myaward;
        this.c = new ArrayList();
        int size2 = seniorLottery.luck_users.size();
        for (int i2 = 0; i2 < size2; i2++) {
            yn4 yn4Var = new yn4();
            yn4Var.a(seniorLottery.luck_users.get(i2));
            this.c.add(yn4Var);
        }
        String str2 = seniorLottery.act_desc;
        this.d = new ArrayList();
        int size3 = seniorLottery.act_regular.size();
        for (int i3 = 0; i3 < size3; i3++) {
            hp4 hp4Var = new hp4();
            hp4Var.a(seniorLottery.act_regular.get(i3));
            this.d.add(hp4Var);
        }
    }
}
