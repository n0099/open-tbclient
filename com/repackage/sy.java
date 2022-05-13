package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class sy extends zx<zn4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public ThreadLinkView g;
    public TextView h;
    public zn4 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sy(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (TbadkCoreApplication.getInst().getPersonalizeViewData().o != null && TbadkCoreApplication.getInst().getPersonalizeViewData().o.getParent() == null) {
            this.f = TbadkCoreApplication.getInst().getPersonalizeViewData().o;
        } else {
            this.f = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01a6, (ViewGroup) null, true);
        }
        this.g = (ThreadLinkView) this.f.findViewById(R.id.obfuscated_res_0x7f091274);
        this.h = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f09126f);
    }

    @Override // com.repackage.zx
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.oy
    /* renamed from: o */
    public void a(zn4 zn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zn4Var) == null) {
            if (zn4Var != null && zn4Var.getThreadData() != null) {
                this.i = zn4Var;
                ThreadData threadData = zn4Var.getThreadData();
                fx5.j(threadData, this.h);
                this.g.setData(threadData);
                return;
            }
            g().setVisibility(8);
        }
    }

    @Override // com.repackage.py
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            this.g.b();
            zn4 zn4Var = this.i;
            if (zn4Var == null || zn4Var.getThreadData() == null) {
                return;
            }
            fx5.l(this.h, this.i.getThreadData().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }
}
