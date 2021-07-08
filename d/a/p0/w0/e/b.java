package d.a.p0.w0.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.funad.adapter.FunAdNativeViewHolder;
import com.baidu.tieba.funad.view.FunAdNativeFrsView;
import com.baidu.tieba.funad.view.FunAdNativePbView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.b.d;
import d.a.o0.r.q.a2;
import d.a.o0.r.q.b2;
import d.a.p0.h3.h0.n;
import d.a.p0.v0.d.c;
import d.a.p0.w2.o;
import d.a.p0.w2.s;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public class b extends d.a.c.k.e.a<d.a.o0.r.q.a, FunAdNativeViewHolder> implements s, o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity m;
    public String n;
    public Set<String> o;
    public String p;
    public String q;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f65737e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FunAdNativeViewHolder f65738f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f65739g;

        public a(b bVar, n nVar, FunAdNativeViewHolder funAdNativeViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, nVar, funAdNativeViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65739g = bVar;
            this.f65737e = nVar;
            this.f65738f = funAdNativeViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f65737e.m(true);
                this.f65739g.L();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", this.f65738f.c().getPageType()).param("obj_locate", 0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new HashSet();
        this.m = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: f0 */
    public FunAdNativeViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            FunAdNativeViewHolder funAdNativeViewHolder = new FunAdNativeViewHolder(this.f41840h == AdvertAppInfo.q4 ? new FunAdNativeFrsView(this.m) : new FunAdNativePbView(this.m), this.m, this.f41840h);
            funAdNativeViewHolder.h(this.n);
            funAdNativeViewHolder.g(this.q);
            return funAdNativeViewHolder;
        }
        return (FunAdNativeViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.r.q.a aVar, FunAdNativeViewHolder funAdNativeViewHolder) {
        InterceptResult invokeCommon;
        n nVar;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, funAdNativeViewHolder})) == null) {
            if (aVar instanceof a2) {
                b2 b2Var = ((a2) aVar).w;
                nVar = b2Var.G2;
                j = b2Var.Q();
            } else if (aVar instanceof b2) {
                b2 b2Var2 = (b2) aVar;
                nVar = b2Var2.G2;
                j = b2Var2.Q();
            } else {
                nVar = null;
                j = 0;
            }
            if (nVar == null) {
                funAdNativeViewHolder.c().d(8);
                return funAdNativeViewHolder.a();
            }
            if (!"personalize".equals(this.p)) {
                this.n = c.e().d(this.q);
            }
            if (this.f41840h == AdvertAppInfo.q4) {
                if ("frs".equals(this.p)) {
                    d.a.p0.v0.a.h().r(this.m, this.n, d.a.p0.v0.a.a(this.p, d.w() ? "1" : "0"), String.valueOf(j));
                } else if ("personalize".equals(this.p)) {
                    d.a.p0.v0.a.h().q(this.m, this.n, d.a.p0.v0.a.a(this.p, d.M() ? "1" : "0"));
                }
            }
            funAdNativeViewHolder.e(new a(this, nVar, funAdNativeViewHolder));
            funAdNativeViewHolder.c().h();
            funAdNativeViewHolder.f(this.p);
            funAdNativeViewHolder.h(this.n);
            this.o.add(this.n);
            funAdNativeViewHolder.i(nVar);
            return funAdNativeViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void h0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.p = str;
        }
    }

    public void i0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.q = str;
        }
    }

    public void j0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.n = str;
        }
    }

    @Override // d.a.p0.w2.s
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
        }
    }

    @Override // d.a.p0.w2.o
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            V v = this.k;
            if (v != 0 && ((FunAdNativeViewHolder) v).c() != null) {
                ((FunAdNativeViewHolder) this.k).c().b();
            }
            for (String str : this.o) {
                d.a.p0.v0.a.h().b(str);
            }
        }
    }

    @Override // d.a.p0.w2.o
    public void onPause() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (v = this.k) == 0 || ((FunAdNativeViewHolder) v).c() == null) {
            return;
        }
        ((FunAdNativeViewHolder) this.k).c().b();
    }

    @Override // d.a.p0.w2.o
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }
}
