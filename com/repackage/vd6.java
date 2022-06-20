package com.repackage;

import androidx.core.app.NotificationManagerCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class vd6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ny4 a;
    public FrsActivity b;

    public vd6(FrsActivity frsActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = frsActivity;
    }

    public void a() {
        ny4 ny4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (ny4Var = this.a) == null) {
            return;
        }
        ny4Var.q();
    }

    public void b() {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (frsActivity = this.b) == null || frsActivity.getPageContext() == null) {
            return;
        }
        boolean z = false;
        if (UbsABTestHelper.isPushOpenNewStyle()) {
            if (NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() || !oy4.g(TbadkCoreApplication.getInst(), 0)) {
                return;
            }
            FrsActivity frsActivity2 = this.b;
            if (frsActivity2 != null && frsActivity2.w0() != null) {
                z = this.b.w0().G;
            }
            HashMap hashMap = new HashMap();
            if (z) {
                hashMap.put("view_params_key_style", "short");
            }
            ny4 ny4Var = this.a;
            if (ny4Var != null) {
                ny4Var.q();
            }
            this.a = oy4.j(this.b.getPageContext(), "forum_follow", 2000L, hashMap);
        } else if (my4.g(this.b, 0)) {
            my4.i(this.b.getPageContext(), 4, 2000L);
        }
    }
}
