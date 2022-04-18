package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m00;
import java.util.List;
/* loaded from: classes5.dex */
public class d00 extends qy<pn4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int f;
    public int g;
    public ThreadCommentAndPraiseInfoLayout h;
    public pn4 i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d00 a;

        public a(d00 d00Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d00Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d00Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.d() == null) {
                return;
            }
            this.a.d().a(view2, this.a.i);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements m00.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d00 a;

        public b(d00 d00Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d00Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d00Var;
        }

        @Override // com.repackage.m00.b
        public boolean a(m00.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (aVar.c() instanceof Boolean) {
                    if (!((Boolean) aVar.c()).booleanValue()) {
                        if ((this.a.f & 128) <= 0) {
                            this.a.f &= -5;
                            this.a.f |= 64;
                        }
                    } else {
                        d00 d00Var = this.a;
                        d00Var.f = d00Var.g;
                    }
                    this.a.h.setShowFlag(this.a.f);
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d00(Context context) {
        this(context, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void A(boolean z) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (threadCommentAndPraiseInfoLayout = this.h) == null) {
            return;
        }
        threadCommentAndPraiseInfoLayout.setNeedMatchStrategy(z);
    }

    public void B(ThreadCommentAndPraiseInfoLayout.i iVar) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar) == null) || (threadCommentAndPraiseInfoLayout = this.h) == null) {
            return;
        }
        threadCommentAndPraiseInfoLayout.setOnCommentClickCallback(iVar);
    }

    public void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.h.setShareReportFrom(i);
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.h.setStType(str);
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.h.setTabName(str);
        }
    }

    public void F() {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (threadCommentAndPraiseInfoLayout = this.h) == null) {
            return;
        }
        threadCommentAndPraiseInfoLayout.setUseDynamicLikeRes();
    }

    @Override // com.repackage.qy
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            int i2 = i | this.f;
            this.f = i2;
            this.h.setShowFlag(i2);
            this.g = this.f;
        }
    }

    @Override // com.repackage.qy
    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            int i2 = (~i) & this.f;
            this.f = i2;
            this.h.setShowFlag(i2);
            this.g = this.f;
        }
    }

    @Override // com.repackage.qy
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.h : (View) invokeV.objValue;
    }

    @Override // com.repackage.qy
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.a.m(4, new b(this));
        }
    }

    @Override // com.repackage.gz
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, tbPageContext, i) == null) {
            this.h.onChangeSkinType();
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            boolean z = false;
            k(this.h, 0);
            qy g = this.a.g();
            if (g == null) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) g.g();
            int childCount = viewGroup.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    z = true;
                    break;
                } else if (!(viewGroup.getChildAt(i) instanceof TextView) && viewGroup.getChildAt(i).getVisibility() == 0) {
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                List<xy> h = this.a.h();
                if (ListUtils.isEmpty(h)) {
                    return;
                }
                for (xy xyVar : h) {
                    if (xyVar != null && xyVar.g() != null && xyVar.g().getVisibility() == 0) {
                        return;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fz
    /* renamed from: u */
    public void a(pn4 pn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pn4Var) == null) {
            this.i = pn4Var;
            this.h.setData(pn4Var.getThreadData());
            t();
        }
    }

    public void v(vn4 vn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, vn4Var) == null) {
            this.h.setAgreeStatisticData(vn4Var);
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && UbsABTestHelper.isLikeModifyTestA()) {
            A(false);
            F();
        }
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.h.setFrom(i);
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.h.Q = i;
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.h.setGameId(i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d00(Context context, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
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
        this.f = 11;
        this.g = 11;
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().r instanceof ThreadCardBottomOpSegmentLayout) && TbadkCoreApplication.getInst().getPersonalizeViewData().r.getParent() == null) {
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) TbadkCoreApplication.getInst().getPersonalizeViewData().r;
            this.h = threadCommentAndPraiseInfoLayout;
            threadCommentAndPraiseInfoLayout.setContext(context);
        } else {
            this.h = new ThreadCardBottomOpSegmentLayout(context, z);
        }
        this.h.setReplyTimeVisible(false);
        this.h.setShowPraiseNum(true);
        this.h.setNeedAddPraiseIcon(true);
        this.h.setNeedAddReplyIcon(true);
        this.h.setShareVisible(true);
        this.h.setForumAfterClickListener(new a(this));
    }
}
