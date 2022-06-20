package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.adapter.PbAppLegoViewHolder;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class f98 extends an<sh8, PbAppLegoViewHolder> implements t88, o88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity i;
    public boolean j;
    public boolean k;
    public CustomMessageListener l;
    public CustomMessageListener m;
    public CustomMessageListener n;
    public WeakReference<PbAppLegoViewHolder> o;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f98 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f98 f98Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f98Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f98Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.g != null && this.a.k) {
                int e = ((PbAppLegoViewHolder) this.a.g).e();
                if (((PbAppLegoViewHolder) this.a.g).d()) {
                    if (e == -1) {
                        ((PbAppLegoViewHolder) this.a.g).c((int) TimeUnit.SECONDS.toSeconds(1L));
                    }
                } else if (e != -1) {
                    ((PbAppLegoViewHolder) this.a.g).stopPlay();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f98 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f98 f98Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f98Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f98Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.m0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f98 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(f98 f98Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f98Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f98Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.g != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                ((PbAppLegoViewHolder) this.a.g).stopPlay();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements bc7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public d(f98 f98Var, AdvertAppInfo advertAppInfo, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f98Var, advertAppInfo, Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = advertAppInfo;
            this.b = i;
            this.c = str;
        }

        @Override // com.repackage.bc7
        public void a(int i, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, hashMap) == null) || i == 0) {
                return;
            }
            if (y88.h(i)) {
                ja8.g(this.a, this.b, hashMap, i);
            } else {
                ja8.n(this.a, this.b, this.c, null, hashMap);
            }
            jc7.c(this.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f98(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = true;
        this.l = new a(this, 2004013);
        this.m = new b(this, 2004018);
        this.n = new c(this, 2004020);
        this.o = null;
        this.i = baseFragmentActivity;
        baseFragmentActivity.registerListener(this.l);
        this.i.registerListener(this.n);
        this.i.registerListener(this.m);
    }

    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder' to match base method */
    @Override // com.repackage.an
    public /* bridge */ /* synthetic */ PbAppLegoViewHolder M(ViewGroup viewGroup) {
        j0(viewGroup);
        throw null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: h0 */
    public View D(int i, View view2, ViewGroup viewGroup, sh8 sh8Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, sh8Var})) == null) {
            if (sh8Var == null || sh8Var.Q0() == null) {
                return null;
            }
            if (i0(view2, sh8Var)) {
                PbAppLegoViewHolder N = N(viewGroup, sh8Var);
                this.g = N;
                if (N != null) {
                    view2 = N.b();
                }
            }
            View view3 = view2;
            if (view3 != null) {
                view3 = S(i, view3, viewGroup, sh8Var, (PbAppLegoViewHolder) view3.getTag());
                if (r88.class.isAssignableFrom(view3.getClass())) {
                    ((PbAppLegoViewHolder) this.g).g(((r88) view3).getVideoOrVrView());
                }
            }
            return view3;
        }
        return (View) invokeCommon.objValue;
    }

    public final boolean i0(View view2, sh8 sh8Var) {
        InterceptResult invokeLL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, sh8Var)) == null) {
            if (view2 == null || view2.getTag() == null || (v = this.g) == 0 || !((PbAppLegoViewHolder) v).getClass().isAssignableFrom(view2.getTag().getClass()) || !view2.getTag().getClass().isAssignableFrom(((PbAppLegoViewHolder) this.g).getClass())) {
                return true;
            }
            AdvertAppInfo.ILegoAdvert Q0 = sh8Var.Q0();
            Object tag = view2.getTag(R.id.obfuscated_res_0x7f091e53);
            if (tag instanceof AdvertAppInfo.ILegoAdvert) {
                return !Q0.isReusable((AdvertAppInfo.ILegoAdvert) tag);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.t88
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.j = z;
        }
    }

    public PbAppLegoViewHolder j0(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            throw new IllegalStateException("onCreateViewHolder(ViewGroup parent) unavailable.");
        }
        return (PbAppLegoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: k0 */
    public PbAppLegoViewHolder N(ViewGroup viewGroup, sh8 sh8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, sh8Var)) == null) {
            View view2 = (View) cc7.h().a(this.i.getPageContext(), sh8Var.Q0(), 4);
            if (view2 != null) {
                PbAppLegoViewHolder pbAppLegoViewHolder = new PbAppLegoViewHolder((xc7) view2);
                pbAppLegoViewHolder.setIsRecyclable(false);
                return pbAppLegoViewHolder;
            }
            return null;
        }
        return (PbAppLegoViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: l0 */
    public View S(int i, View view2, ViewGroup viewGroup, sh8 sh8Var, PbAppLegoViewHolder pbAppLegoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, sh8Var, pbAppLegoViewHolder})) == null) {
            if (this.i == null) {
                return null;
            }
            if (sh8Var.Q0() instanceof AdCard) {
                ((AdCard) sh8Var.Q0()).isPBBanner = sh8Var.H0;
            }
            pbAppLegoViewHolder.setIsRecyclable(false);
            AdvertAppInfo.ILegoAdvert Q0 = sh8Var.Q0();
            view2.setTag(R.id.obfuscated_res_0x7f091e53, Q0);
            this.i.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.i.getLayoutMode().j(view2);
            dn4.f(sh8Var);
            AdvertAppInfo advertAppInfo = sh8Var.getAdvertAppInfo();
            if (advertAppInfo.i == null) {
                advertAppInfo.i = new dn4();
            }
            dn4 dn4Var = advertAppInfo.i;
            dn4Var.b = sh8Var.M0;
            dn4Var.a = sh8Var.P0();
            advertAppInfo.position = sh8Var.O0;
            xc7 xc7Var = (xc7) view2;
            Q0.setAdvertAppInfo(advertAppInfo);
            xc7Var.setFromCDN(this.j);
            xc7Var.update(Q0);
            int i2 = sh8Var.M0;
            String str = sh8Var.I0;
            Context context = this.a;
            if (context instanceof fg0) {
                advertAppInfo.r = hg0.b(advertAppInfo.r, (fg0) context, view2);
            }
            xc7Var.setAfterClickSchemeListener(new d(this, advertAppInfo, i2, str));
            WeakReference<PbAppLegoViewHolder> weakReference = this.o;
            if (weakReference == null || weakReference.get() != pbAppLegoViewHolder) {
                this.o = new WeakReference<>(pbAppLegoViewHolder);
            }
            m0();
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            WeakReference<PbAppLegoViewHolder> weakReference = this.o;
            PbAppLegoViewHolder pbAppLegoViewHolder = weakReference != null ? weakReference.get() : null;
            if (pbAppLegoViewHolder != null) {
                pbAppLegoViewHolder.h();
            }
        }
    }

    @Override // com.repackage.o88
    public void onDestroy() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (v = this.g) == 0) {
            return;
        }
        ((PbAppLegoViewHolder) v).f();
    }

    @Override // com.repackage.o88
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            V v = this.g;
            if (v != 0) {
                ((PbAppLegoViewHolder) v).stopPlay();
            }
            this.k = false;
        }
    }

    @Override // com.repackage.o88
    public void onResume() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (v = this.g) != 0 && ((PbAppLegoViewHolder) v).d()) {
            if (((PbAppLegoViewHolder) this.g).e() == -1) {
                ((PbAppLegoViewHolder) this.g).c((int) TimeUnit.SECONDS.toSeconds(1L));
            }
            this.k = true;
        }
    }
}
