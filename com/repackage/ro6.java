package com.repackage;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class ro6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wo6 a;
    public Intent b;
    public int c;
    public a d;

    /* loaded from: classes7.dex */
    public interface a {
        void onStateChanged(int i);
    }

    public ro6(wo6 wo6Var, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wo6Var, intent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.a = wo6Var;
        this.b = intent;
        uo6 c = to6.d().c(this.b.getStringExtra("info_forum_name_text"));
        c.b();
        c.a();
        if (c.c()) {
            ((RelativeLayout.LayoutParams) this.a.g.getLayoutParams()).topMargin = pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : invokeV.intValue;
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.d = aVar;
        }
    }

    public abstract void c();

    public abstract void d();
}
