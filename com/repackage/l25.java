package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class l25 extends y05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final d25 a;

    public l25(d25 d25Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d25Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = d25Var;
    }

    @Override // com.repackage.y05
    public a15 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setBarLauncherType(6);
            editorTools.setBackgroundColorId(R.color.CAM_X0602);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.setMoreDeskBgColorId(R.color.CAM_X0206);
            editorTools.D(false);
            return new k25(editorTools);
        }
        return (a15) invokeL.objValue;
    }

    @Override // com.repackage.y05
    public void c(a15 a15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a15Var) == null) {
        }
    }

    @Override // com.repackage.y05
    public void d(a15 a15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a15Var) == null) {
            EditorTools a = a15Var.a();
            a.setHideBigEmotion(true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            a.h(arrayList);
            a.d(new m25(a.getContext(), this.a));
            i15 n = a.n(5);
            n.d = 0;
            n.e(false);
            a.setClearEbPadding(true);
            a.f();
        }
    }
}
