package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.adapter.CardAppLegoViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class na8 extends eo<ay5, CardAppLegoViewHolder> implements aa8, fa8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> i;
    public int j;
    public boolean k;
    public AdvertAppInfo.ILegoAdvert l;
    public Runnable m;
    public CustomMessageListener n;

    /* loaded from: classes6.dex */
    public class a implements cd7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public a(na8 na8Var, AdvertAppInfo advertAppInfo, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {na8Var, advertAppInfo, Integer.valueOf(i), str};
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

        @Override // com.repackage.cd7
        public void a(int i, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, hashMap) == null) || i == 0) {
                return;
            }
            if (ka8.h(i)) {
                vb8.g(this.a, this.b, hashMap, i);
            } else {
                vb8.n(this.a, this.b, this.c, null, hashMap);
            }
            kd7.c(this.a);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ na8 a;

        public b(na8 na8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {na8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = na8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((CardAppLegoViewHolder) this.a.g).c((int) TimeUnit.SECONDS.toSeconds(1L));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ na8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(na8 na8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {na8Var, Integer.valueOf(i)};
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
            this.a = na8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.g == null) {
                return;
            }
            if (!(customResponsedMessage.getData() instanceof Boolean)) {
                ((CardAppLegoViewHolder) this.a.g).stopPlay();
            } else if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                ((CardAppLegoViewHolder) this.a.g).stopPlay();
            } else {
                int e = ((CardAppLegoViewHolder) this.a.g).e();
                if (!((CardAppLegoViewHolder) this.a.g).d()) {
                    if (e != -1) {
                        ((CardAppLegoViewHolder) this.a.g).stopPlay();
                    }
                } else if (e == -1) {
                    ng.a().removeCallbacks(this.a.m);
                    ng.a().postDelayed(this.a.m, 500L);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public na8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, str};
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
        this.j = 3;
        this.k = false;
        this.l = null;
        this.m = new b(this);
        this.n = new c(this, 2921517);
        this.i = tbPageContext;
        if ((tbPageContext.getPageActivity() instanceof BaseFragmentActivity) && TextUtils.equals(str, "CONCERN")) {
            if (bdUniqueId == AdvertAppInfo.z || bdUniqueId == AdvertAppInfo.B) {
                MessageManager.getInstance().registerListener(this.n);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: g0 */
    public View E(int i, View view2, ViewGroup viewGroup, ay5 ay5Var) {
        InterceptResult invokeCommon;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ay5Var})) == null) {
            if (ay5Var == null || (advertAppInfo = ay5Var.a) == null || (iLegoAdvert = advertAppInfo.h) == null) {
                return null;
            }
            this.l = iLegoAdvert;
            if (h0(view2)) {
                CardAppLegoViewHolder M = M(viewGroup);
                this.g = M;
                if (M != null) {
                    view2 = M.b();
                }
            }
            View view3 = view2;
            if (view3 != null) {
                view3 = S(i, view3, viewGroup, ay5Var, (CardAppLegoViewHolder) view3.getTag());
                if (da8.class.isAssignableFrom(view3.getClass())) {
                    ((CardAppLegoViewHolder) this.g).f(((da8) view3).getVideoOrVrView());
                }
            }
            return view3;
        }
        return (View) invokeCommon.objValue;
    }

    public final boolean h0(View view2) {
        InterceptResult invokeL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) {
            if (view2 == null || view2.getTag() == null || (v = this.g) == 0 || this.l == null || !((CardAppLegoViewHolder) v).getClass().isAssignableFrom(view2.getTag().getClass()) || !view2.getTag().getClass().isAssignableFrom(((CardAppLegoViewHolder) this.g).getClass()) || !(view2.getTag(R.id.obfuscated_res_0x7f091eb8) instanceof AdvertAppInfo.ILegoAdvert)) {
                return true;
            }
            return !this.l.isReusable((AdvertAppInfo.ILegoAdvert) view2.getTag(R.id.obfuscated_res_0x7f091eb8));
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: i0 */
    public CardAppLegoViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            if (this.l == null || (view2 = (View) dd7.h().a(this.i, this.l, 2)) == null) {
                return null;
            }
            view2.setTag(R.id.obfuscated_res_0x7f091eb8, this.l);
            return new CardAppLegoViewHolder((yd7) view2);
        }
        return (CardAppLegoViewHolder) invokeL.objValue;
    }

    @Override // com.repackage.fa8
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.k = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: j0 */
    public CardAppLegoViewHolder N(ViewGroup viewGroup, ay5 ay5Var) {
        InterceptResult invokeLL;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, ay5Var)) == null) {
            if (ay5Var == null || (advertAppInfo = ay5Var.a) == null || (iLegoAdvert = advertAppInfo.h) == null) {
                return null;
            }
            this.l = iLegoAdvert;
            return M(viewGroup);
        }
        return (CardAppLegoViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: k0 */
    public View S(int i, View view2, ViewGroup viewGroup, ay5 ay5Var, CardAppLegoViewHolder cardAppLegoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ay5Var, cardAppLegoViewHolder})) == null) {
            TbPageContext<?> tbPageContext = this.i;
            if (tbPageContext != null && ay5Var != null && ay5Var.a != null) {
                if (tbPageContext.getPageActivity() instanceof oh0) {
                    AdvertAppInfo advertAppInfo = ay5Var.a;
                    advertAppInfo.r = qh0.b(advertAppInfo.r, (oh0) this.i.getPageActivity(), cardAppLegoViewHolder.itemView);
                }
                AdvertAppInfo.ILegoAdvert iLegoAdvert = ay5Var.a.h;
                this.l = iLegoAdvert;
                if (iLegoAdvert != null && view2 != null) {
                    if (this.g == 0) {
                        this.g = cardAppLegoViewHolder;
                    }
                    eo4.d(ay5Var);
                    this.i.getLayoutMode().k(this.j == 1);
                    this.i.getLayoutMode().j(view2);
                    AdvertAppInfo e = ay5Var.e();
                    yd7 yd7Var = (yd7) view2;
                    this.l.setAdvertAppInfo(e);
                    yd7Var.setFromCDN(this.k);
                    yd7Var.update(this.l);
                    yd7Var.setAfterClickSchemeListener(new a(this, e, ay5Var.c, ay5Var.b));
                    if (da8.class.isAssignableFrom(view2.getClass())) {
                        cardAppLegoViewHolder.f(((da8) view2).getVideoOrVrView());
                    }
                    return view2;
                }
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.aa8
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.n);
        }
    }

    @Override // com.repackage.aa8
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // com.repackage.aa8
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }
}
