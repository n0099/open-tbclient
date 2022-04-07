package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.InterviewLiveLayout;
import com.baidu.card.view.RoundCornerFrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hz extends j00 {
    public static /* synthetic */ Interceptable $ic;
    public static final int B;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public InterviewLiveLayout y;
    public int z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964037837, "Lcom/repackage/hz;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964037837, "Lcom/repackage/hz;");
                return;
            }
        }
        B = oi.k(TbadkCoreApplication.getInst()) - ((oi.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + oi.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hz(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.z = 3;
        z();
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.y.setFromCDN(z);
        }
    }

    @Override // com.repackage.j00, com.repackage.qy
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    @Override // com.repackage.qy
    public void l(rx5<qn4> rx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rx5Var) == null) {
            this.y.setSubClickListener(rx5Var);
        }
    }

    @Override // com.repackage.j00, com.repackage.gz
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            if (this.z != i) {
                SkinManager.setBackgroundResource(this.y, R.drawable.addresslist_item_bg);
                this.y.l(this.z);
            }
            this.z = i;
        }
    }

    @Override // com.repackage.j00
    public k78 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            l78 l78Var = new l78(this.b, this.i);
            l78Var.setStageType("2003");
            return l78Var;
        }
        return (k78) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.j00, com.repackage.fz
    /* renamed from: q */
    public void a(qn4 qn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, qn4Var) == null) {
            this.h = qn4Var;
            if (qn4Var == null || qn4Var.getThreadData() == null) {
                return;
            }
            ThreadData threadData = qn4Var.getThreadData();
            if (threadData.getThreadVideoInfo() != null) {
                this.y.setVisibility(8);
                this.i.setVisibility(0);
                this.A.setVisibility(8);
                super.a(qn4Var);
                return;
            }
            this.i.setVisibility(8);
            this.y.setVisibility(0);
            this.A.setVisibility(0);
            this.y.a(qn4Var);
            ThreadCardUtils.setTitle(this.g, threadData);
            ThreadCardUtils.setAbstract(this.A, this.g, threadData, B);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d01a6, (ViewGroup) null, true);
            this.f = inflate;
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092352);
            this.A = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f092351);
            this.i = (RoundCornerFrameLayout) this.f.findViewById(R.id.obfuscated_res_0x7f090ab1);
            this.y = (InterviewLiveLayout) this.f.findViewById(R.id.obfuscated_res_0x7f090aad);
            k78 p = p();
            this.j = p;
            p.getMainView().setBackgroundResource(R.color.transparent);
        }
    }
}
