package d.a.s0.h2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbPageNewsInfoHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class k0 extends o<i0, PbPageNewsInfoHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.s0.h2.h.e s;
    public PbPageNewsInfoHolder.b t;

    /* loaded from: classes9.dex */
    public class a implements PbPageNewsInfoHolder.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k0 f60595a;

        public a(k0 k0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60595a = k0Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbPageNewsInfoHolder.b
        public void a(i0 i0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, i0Var) == null) || i0Var == null) {
                return;
            }
            d.a.s0.h2.m.a.a(this.f60595a.s, i0Var, i0Var.i0, 5);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d.a.s0.h2.o.b) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = new a(this);
    }

    @Override // d.a.s0.h2.k.e.o, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        j0(i2, view, viewGroup, (i0) obj, (PbPageNewsInfoHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public PbPageNewsInfoHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbPageNewsInfoHolder(this.n.getPageContext(), LayoutInflater.from(this.f44821e).inflate(R.layout.pb_page_news, viewGroup, false), this.t) : (PbPageNewsInfoHolder) invokeL.objValue;
    }

    public View j0(int i2, View view, ViewGroup viewGroup, i0 i0Var, PbPageNewsInfoHolder pbPageNewsInfoHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, i0Var, pbPageNewsInfoHolder})) == null) {
            super.X(i2, view, viewGroup, i0Var, pbPageNewsInfoHolder);
            if (i0Var == null) {
                return view;
            }
            i0Var.i0 = i2 + 1;
            d.a.s0.h2.m.a.d(this.n.getUniqueId(), this.s, i0Var, i0Var.i0, 5);
            pbPageNewsInfoHolder.h(i0Var);
            pbPageNewsInfoHolder.i(TbadkCoreApplication.getInst().getSkinType());
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void t(d.a.s0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.s = eVar;
        }
    }
}
