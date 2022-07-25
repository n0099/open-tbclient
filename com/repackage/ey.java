package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ny;
import java.util.List;
/* loaded from: classes6.dex */
public class ey extends qw<on4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int f;
    public int g;
    public ThreadCommentAndPraiseInfoLayout h;
    public on4 i;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ey a;

        public a(ey eyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eyVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.e() == null) {
                return;
            }
            this.a.e().a(view2, this.a.i);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ny.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ey a;

        public b(ey eyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eyVar;
        }

        @Override // com.repackage.ny.b
        public boolean a(ny.a aVar) {
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
                        ey eyVar = this.a;
                        eyVar.f = eyVar.g;
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
    public ey(Context context) {
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

    public void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.h.setGameId(i);
        }
    }

    public void B(boolean z) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (threadCommentAndPraiseInfoLayout = this.h) == null) {
            return;
        }
        threadCommentAndPraiseInfoLayout.setNeedMatchStrategy(z);
    }

    public void C(ThreadCommentAndPraiseInfoLayout.k kVar) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kVar) == null) || (threadCommentAndPraiseInfoLayout = this.h) == null) {
            return;
        }
        threadCommentAndPraiseInfoLayout.setOnCommentClickCallback(kVar);
    }

    public void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.h.setShareReportFrom(i);
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.h.setStType(str);
        }
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.h.setTabName(str);
        }
    }

    public void G() {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (threadCommentAndPraiseInfoLayout = this.h) == null) {
            return;
        }
        threadCommentAndPraiseInfoLayout.setUseDynamicLikeRes();
    }

    @Override // com.repackage.qw
    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            int i2 = i | this.f;
            this.f = i2;
            this.h.setShowFlag(i2);
            this.g = this.f;
        }
    }

    @Override // com.repackage.qw
    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            int i2 = (~i) & this.f;
            this.f = i2;
            this.h.setShowFlag(i2);
            this.g = this.f;
        }
    }

    @Override // com.repackage.qw
    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.h : (View) invokeV.objValue;
    }

    @Override // com.repackage.qw
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.a.m(4, new b(this));
        }
    }

    @Override // com.repackage.hx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, tbPageContext, i) == null) {
            this.h.onChangeSkinType();
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            boolean z = false;
            l(this.h, 0);
            qw g = this.a.g();
            if (g == null) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) g.h();
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
                List<xw> h = this.a.h();
                if (ListUtils.isEmpty(h)) {
                    return;
                }
                for (xw xwVar : h) {
                    if (xwVar != null && xwVar.h() != null && xwVar.h().getVisibility() == 0) {
                        return;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.gx
    /* renamed from: v */
    public void a(on4 on4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, on4Var) == null) {
            this.i = on4Var;
            this.h.setData(on4Var.getThreadData());
            u();
        }
    }

    public void w(un4 un4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, un4Var) == null) {
            this.h.setAgreeStatisticData(un4Var);
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            B(false);
            G();
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.h.setFrom(i);
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.h.Q = i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ey(Context context, boolean z) {
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
