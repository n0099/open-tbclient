package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ms6 extends rz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ud7 c;

    public ms6() {
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

    private void update() {
        ud7 ud7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && (ud7Var = this.c) != null && ud7Var.c()) {
            List<ICardInfo> e = this.c.e();
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            arrayList.addAll(e);
            this.c.a();
            this.c.b();
        }
    }

    public final void a() {
        List<Object> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (list = this.a) == null) {
            return;
        }
        nh8.e(list, 2);
    }

    public void b(ud7 ud7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ud7Var) == null) {
            this.c = ud7Var;
            update();
            a();
        }
    }
}
