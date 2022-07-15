package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ny;
/* loaded from: classes6.dex */
public class hy extends qw<nn4> {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public TextView g;
    public TextView h;
    public OriginalThreadCardView i;
    public nn4 j;
    public boolean k;
    public OriginalThreadCardView.b l;

    /* loaded from: classes6.dex */
    public class a implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hy a;

        public a(hy hyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hyVar;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) || this.a.j == null || this.a.j.getThreadData() == null) {
                return;
            }
            if (this.a.e() != null) {
                this.a.e().a(this.a.i, this.a.j);
            }
            String id = this.a.j.getThreadData().getId();
            ux5.a(id);
            this.a.t(id);
            this.a.a.o(new ny.a(1));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964037868, "Lcom/repackage/hy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964037868, "Lcom/repackage/hy;");
                return;
            }
        }
        m = pi.k(TbadkCoreApplication.getInst()) - ((pi.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + pi.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hy(Context context) {
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
        this.k = false;
        this.l = new a(this);
        if (TbadkCoreApplication.getInst().getPersonalizeViewData().p != null && TbadkCoreApplication.getInst().getPersonalizeViewData().p.getParent() == null) {
            this.f = TbadkCoreApplication.getInst().getPersonalizeViewData().p;
        } else {
            this.f = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01ba, (ViewGroup) null, false);
        }
        this.g = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f09202b);
        this.h = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f09201d);
        OriginalThreadCardView originalThreadCardView = (OriginalThreadCardView) this.f.findViewById(R.id.obfuscated_res_0x7f09168e);
        this.i = originalThreadCardView;
        originalThreadCardView.setSubClickListener(this.l);
    }

    @Override // com.repackage.qw
    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    @Override // com.repackage.qw
    public void m(jy5<nn4> jy5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jy5Var) == null) {
            super.m(jy5Var);
        }
    }

    @Override // com.repackage.hx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            this.i.s();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.gx
    /* renamed from: s */
    public void a(nn4 nn4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, nn4Var) == null) || nn4Var == null || nn4Var.getThreadData() == null) {
            return;
        }
        this.j = nn4Var;
        ThreadCardUtils.setTitle(this.g, nn4Var.getThreadData(), this.k);
        ThreadCardUtils.setAbstract(this.h, this.g, nn4Var.getThreadData(), m, this.k);
        this.i.i(nn4Var.getThreadData().originalThreadData);
    }

    public final void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            ux5.l(this.g, str, R.color.CAM_X0105, R.color.CAM_X0109);
            ux5.l(this.h, str, R.color.CAM_X0105, R.color.CAM_X0109);
            this.i.setReadState(ux5.k(str));
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.k = z;
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.i.m = i;
        }
    }
}
