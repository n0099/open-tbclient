package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes7.dex */
public class wq4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public up4 a;
    public List<jo4> b;
    public List<ko4> c;
    public List<tp4> d;

    public wq4() {
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
        up4 up4Var = new up4();
        this.a = up4Var;
        up4Var.a(seniorLottery.theme);
        this.b = new ArrayList();
        int size = seniorLottery.award_info.size();
        for (int i = 0; i < size; i++) {
            jo4 jo4Var = new jo4();
            jo4Var.a(seniorLottery.award_info.get(i));
            this.b.add(jo4Var);
        }
        String str = seniorLottery.myaward;
        this.c = new ArrayList();
        int size2 = seniorLottery.luck_users.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ko4 ko4Var = new ko4();
            ko4Var.a(seniorLottery.luck_users.get(i2));
            this.c.add(ko4Var);
        }
        String str2 = seniorLottery.act_desc;
        this.d = new ArrayList();
        int size3 = seniorLottery.act_regular.size();
        for (int i3 = 0; i3 < size3; i3++) {
            tp4 tp4Var = new tp4();
            tp4Var.a(seniorLottery.act_regular.get(i3));
            this.d.add(tp4Var);
        }
    }
}
