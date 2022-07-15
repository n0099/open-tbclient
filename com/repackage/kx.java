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
/* loaded from: classes6.dex */
public class kx extends qw<nn4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public ThreadLinkView g;
    public TextView h;
    public nn4 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kx(Context context) {
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
            this.f = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01a0, (ViewGroup) null, true);
        }
        this.g = (ThreadLinkView) this.f.findViewById(R.id.obfuscated_res_0x7f0912cc);
        this.h = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0912c7);
    }

    @Override // com.repackage.qw
    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    @Override // com.repackage.hx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            this.g.b();
            nn4 nn4Var = this.i;
            if (nn4Var == null || nn4Var.getThreadData() == null) {
                return;
            }
            ux5.l(this.h, this.i.getThreadData().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.gx
    /* renamed from: p */
    public void a(nn4 nn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nn4Var) == null) {
            if (nn4Var != null && nn4Var.getThreadData() != null) {
                this.i = nn4Var;
                ThreadData threadData = nn4Var.getThreadData();
                ux5.j(threadData, this.h);
                this.g.setData(threadData);
                return;
            }
            h().setVisibility(8);
        }
    }
}
