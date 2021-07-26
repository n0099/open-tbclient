package d.a.q0.l0.m;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.s.h;
import d.a.p0.s.s.j;
import d.a.p0.s.s.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext o;
    public Context p;
    public ViewEventCenter q;
    public final l r;
    public d.a.q0.l0.d.f s;
    public final List<h> t;
    public final l.e u;

    /* loaded from: classes8.dex */
    public class a implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f60491e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60491e = dVar;
        }

        @Override // d.a.p0.s.s.l.e
        public void onItemClick(l lVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                this.f60491e.dismiss();
                if (!d.a.d.e.p.j.z()) {
                    d.a.d.e.p.l.L(this.f60491e.p, R.string.network_not_available);
                } else if (i2 == 2) {
                    this.f60491e.q.dispatchMvcEvent(new d.a.p0.i0.c.b(4, this.f60491e.s, null, null));
                } else if (i2 == 1) {
                    this.f60491e.q.dispatchMvcEvent(new d.a.p0.i0.c.b(13, this.f60491e.s, null, null));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = new a(this);
        this.o = tbPageContext;
        this.p = tbPageContext.getPageActivity();
        this.q = viewEventCenter;
        this.t = new ArrayList();
        l lVar = new l(this.p);
        this.r = lVar;
        lVar.n(this.u);
        h(this.r);
    }

    public final void p() {
        List<h> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.s == null || (list = this.t) == null || this.r == null) {
            return;
        }
        list.clear();
        this.t.add(new h(1, q(this.s.o() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.r));
        this.t.add(new h(2, q(R.string.delete, new Object[0]), this.r));
        this.r.k(this.t);
    }

    public final String q(int i2, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, objArr)) == null) {
            Context context = this.p;
            if (context == null) {
                return null;
            }
            return context.getString(i2, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public void r() {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (lVar = this.r) == null) {
            return;
        }
        lVar.j();
    }

    public void s(d.a.q0.l0.d.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.s = fVar;
            p();
        }
    }
}
