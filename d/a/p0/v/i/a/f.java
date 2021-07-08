package d.a.p0.v.i.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaVideoHolder;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.s;
import d.a.o0.r.q.a2;
import d.a.o0.r.q.b2;
import d.a.p0.a0.b0;
import d.a.p0.a0.z;
import d.a.p0.u0.k;
/* loaded from: classes8.dex */
public class f extends k<a2, FrsPageAlaVideoHolder> implements z, d.a.p0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b0<b2> A;
    public d.a.p0.v.i.e.e x;
    public String y;
    public String z;

    /* loaded from: classes8.dex */
    public class a extends b0<b2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f64776b;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64776b = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.a0.b0
        /* renamed from: d */
        public void a(View view, b2 b2Var) {
            CustomMessage customMessage;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, b2Var) == null) {
                if (view.getId() == R.id.layout_root) {
                    customMessage = new CustomMessage(2921018);
                } else if (view.getId() != R.id.card_home_page_normal_thread_user_name && view.getId() != R.id.card_home_page_normal_thread_user_header && view.getId() != R.id.user_avatar) {
                    customMessage = view.getId() == R.id.video_container ? new CustomMessage(2921019) : null;
                } else {
                    customMessage = new CustomMessage(2921016);
                }
                if (customMessage == null || this.f64776b.o == null) {
                    return;
                }
                customMessage.setData(b2Var);
                this.f64776b.o.sendMessage(customMessage);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.A = new a(this);
    }

    @Override // d.a.p0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.y = str;
        }
    }

    @Override // d.a.p0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.z = str;
        }
    }

    @Override // d.a.p0.u0.k, d.a.p0.a0.y
    public void o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, tbPageContext, bdUniqueId) == null) {
            super.o(tbPageContext, bdUniqueId);
        }
    }

    @Override // d.a.p0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: x0 */
    public FrsPageAlaVideoHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            TbPageContext<?> tbPageContext = this.o;
            if (tbPageContext == null) {
                return null;
            }
            d.a.p0.v.i.e.e eVar = new d.a.p0.v.i.e.e(tbPageContext, this.f41841i);
            this.x = eVar;
            eVar.T(this.f41841i);
            this.x.a(this.y);
            this.x.n(this.A);
            return new FrsPageAlaVideoHolder(this.x);
        }
        return (FrsPageAlaVideoHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.p0.u0.k, d.a.c.k.e.a
    /* renamed from: y0 */
    public View X(int i2, View view, ViewGroup viewGroup, a2 a2Var, FrsPageAlaVideoHolder frsPageAlaVideoHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), view, viewGroup, a2Var, frsPageAlaVideoHolder})) == null) {
            TiebaStatic.log("c11842");
            CustomMessage customMessage = new CustomMessage(2921017);
            FrsViewData frsViewData = this.n;
            int topThreadSize = frsViewData != null ? frsViewData.getTopThreadSize() : 0;
            b2 b2Var = a2Var.w;
            b2Var.P1 = (i2 + 1) - topThreadSize;
            customMessage.setData(b2Var);
            this.o.sendMessage(customMessage);
            if (a2Var != null) {
                d.a.p0.v.i.e.e eVar = frsPageAlaVideoHolder.f14269a;
                if (eVar instanceof d.a.p0.o.e) {
                    eVar.setPage(this.z);
                }
                frsPageAlaVideoHolder.f14269a.a(this.y);
                frsPageAlaVideoHolder.f14269a.U(h0());
                frsPageAlaVideoHolder.f14269a.l(a2Var.w);
                a2Var.w.q4();
            }
            this.q = (s) viewGroup;
            return frsPageAlaVideoHolder.a();
        }
        return (View) invokeCommon.objValue;
    }
}
