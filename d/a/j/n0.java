package d.a.j;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.j.v0.a;
import java.util.List;
/* loaded from: classes8.dex */
public class n0 extends d.a.j.a<d.a.r0.r.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int j;
    public int k;
    public ThreadCommentAndPraiseInfoLayout l;
    public d.a.r0.r.q.a m;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n0 f45789e;

        public a(n0 n0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45789e = n0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f45789e.d() == null) {
                return;
            }
            this.f45789e.d().a(view, this.f45789e.m);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n0 f45790a;

        public b(n0 n0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45790a = n0Var;
        }

        @Override // d.a.j.v0.a.b
        public boolean a(a.C0645a c0645a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c0645a)) == null) {
                if (c0645a.c() instanceof Boolean) {
                    if (!((Boolean) c0645a.c()).booleanValue()) {
                        if ((this.f45790a.j & 128) <= 0) {
                            this.f45790a.j &= -5;
                            this.f45790a.j |= 64;
                        }
                    } else {
                        n0 n0Var = this.f45790a;
                        n0Var.j = n0Var.k;
                    }
                    this.f45790a.l.setShowFlag(this.f45790a.j);
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = 11;
        this.k = 11;
        ThreadCardBottomOpSegmentLayout threadCardBottomOpSegmentLayout = new ThreadCardBottomOpSegmentLayout(context);
        this.l = threadCardBottomOpSegmentLayout;
        threadCardBottomOpSegmentLayout.setReplyTimeVisible(false);
        this.l.setShowPraiseNum(true);
        this.l.setNeedAddPraiseIcon(true);
        this.l.setNeedAddReplyIcon(true);
        this.l.setShareVisible(true);
        this.l.setForumAfterClickListener(new a(this));
    }

    public void A(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.l.setShareReportFrom(i2);
        }
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.l.setStType(str);
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.l.setTabName(str);
        }
    }

    @Override // d.a.j.a
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            int i3 = i2 | this.j;
            this.j = i3;
            this.l.setShowFlag(i3);
            this.k = this.j;
        }
    }

    @Override // d.a.j.a
    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            int i3 = (~i2) & this.j;
            this.j = i3;
            this.l.setShowFlag(i3);
            this.k = this.j;
        }
    }

    @Override // d.a.j.a
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    @Override // d.a.j.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f45734e.m(4, new b(this));
        }
    }

    @Override // d.a.j.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext, i2) == null) {
            this.l.onChangeSkinType();
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            boolean z = false;
            k(this.l, 0);
            d.a.j.a f2 = this.f45734e.f();
            if (f2 == null) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) f2.g();
            int childCount = viewGroup.getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    z = true;
                    break;
                } else if (!(viewGroup.getChildAt(i2) instanceof TextView) && viewGroup.getChildAt(i2).getVisibility() == 0) {
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                List<h> h2 = this.f45734e.h();
                if (ListUtils.isEmpty(h2)) {
                    return;
                }
                for (h hVar : h2) {
                    if (hVar != null && hVar.g() != null && hVar.g().getVisibility() == 0) {
                        return;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j.p
    /* renamed from: u */
    public void a(d.a.r0.r.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.m = aVar;
            this.l.setData(aVar.getThreadData());
            t();
        }
    }

    public void v(d.a.r0.r.q.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
            this.l.setAgreeStatisticData(fVar);
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.l.setFrom(i2);
        }
    }

    public void x(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.l.R = i2;
        }
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.l.setGameId(i2);
        }
    }

    public void z(ThreadCommentAndPraiseInfoLayout.i iVar) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, iVar) == null) || (threadCommentAndPraiseInfoLayout = this.l) == null) {
            return;
        }
        threadCommentAndPraiseInfoLayout.setOnCommentClickCallback(iVar);
    }
}
