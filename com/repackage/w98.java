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
/* loaded from: classes7.dex */
public class w98 extends an<py5, CardAppLegoViewHolder> implements j98, o98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> i;
    public int j;
    public boolean k;
    public AdvertAppInfo.ILegoAdvert l;
    public Runnable m;
    public CustomMessageListener n;

    /* loaded from: classes7.dex */
    public class a implements tc7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public a(w98 w98Var, AdvertAppInfo advertAppInfo, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w98Var, advertAppInfo, Integer.valueOf(i), str};
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

        @Override // com.repackage.tc7
        public void a(int i, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, hashMap) == null) || i == 0) {
                return;
            }
            if (t98.h(i)) {
                eb8.g(this.a, this.b, hashMap, i);
            } else {
                eb8.n(this.a, this.b, this.c, null, hashMap);
            }
            bd7.c(this.a);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w98 a;

        public b(w98 w98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w98Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((CardAppLegoViewHolder) this.a.g).c((int) TimeUnit.SECONDS.toSeconds(1L));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w98 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(w98 w98Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w98Var, Integer.valueOf(i)};
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
            this.a = w98Var;
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
                    qg.a().removeCallbacks(this.a.m);
                    qg.a().postDelayed(this.a.m, 500L);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w98(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
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
    @Override // com.repackage.an
    /* renamed from: g0 */
    public View D(int i, View view2, ViewGroup viewGroup, py5 py5Var) {
        InterceptResult invokeCommon;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, py5Var})) == null) {
            if (py5Var == null || (advertAppInfo = py5Var.a) == null || (iLegoAdvert = advertAppInfo.h) == null) {
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
                view3 = S(i, view3, viewGroup, py5Var, (CardAppLegoViewHolder) view3.getTag());
                if (m98.class.isAssignableFrom(view3.getClass())) {
                    ((CardAppLegoViewHolder) this.g).f(((m98) view3).getVideoOrVrView());
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
            if (view2 == null || view2.getTag() == null || (v = this.g) == 0 || this.l == null || !((CardAppLegoViewHolder) v).getClass().isAssignableFrom(view2.getTag().getClass()) || !view2.getTag().getClass().isAssignableFrom(((CardAppLegoViewHolder) this.g).getClass()) || !(view2.getTag(R.id.obfuscated_res_0x7f091ef7) instanceof AdvertAppInfo.ILegoAdvert)) {
                return true;
            }
            return !this.l.isReusable((AdvertAppInfo.ILegoAdvert) view2.getTag(R.id.obfuscated_res_0x7f091ef7));
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: i0 */
    public CardAppLegoViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            if (this.l == null || (view2 = (View) uc7.h().a(this.i, this.l, 2)) == null) {
                return null;
            }
            view2.setTag(R.id.obfuscated_res_0x7f091ef7, this.l);
            return new CardAppLegoViewHolder((pd7) view2);
        }
        return (CardAppLegoViewHolder) invokeL.objValue;
    }

    @Override // com.repackage.o98
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.k = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: j0 */
    public CardAppLegoViewHolder N(ViewGroup viewGroup, py5 py5Var) {
        InterceptResult invokeLL;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, py5Var)) == null) {
            if (py5Var == null || (advertAppInfo = py5Var.a) == null || (iLegoAdvert = advertAppInfo.h) == null) {
                return null;
            }
            this.l = iLegoAdvert;
            return M(viewGroup);
        }
        return (CardAppLegoViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: k0 */
    public View S(int i, View view2, ViewGroup viewGroup, py5 py5Var, CardAppLegoViewHolder cardAppLegoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, py5Var, cardAppLegoViewHolder})) == null) {
            TbPageContext<?> tbPageContext = this.i;
            if (tbPageContext != null && py5Var != null && py5Var.a != null) {
                if (tbPageContext.getPageActivity() instanceof lg0) {
                    AdvertAppInfo advertAppInfo = py5Var.a;
                    advertAppInfo.r = ng0.b(advertAppInfo.r, (lg0) this.i.getPageActivity(), cardAppLegoViewHolder.itemView);
                }
                AdvertAppInfo.ILegoAdvert iLegoAdvert = py5Var.a.h;
                this.l = iLegoAdvert;
                if (iLegoAdvert != null && view2 != null) {
                    if (this.g == 0) {
                        this.g = cardAppLegoViewHolder;
                    }
                    sn4.d(py5Var);
                    this.i.getLayoutMode().k(this.j == 1);
                    this.i.getLayoutMode().j(view2);
                    AdvertAppInfo c2 = py5Var.c();
                    pd7 pd7Var = (pd7) view2;
                    this.l.setAdvertAppInfo(c2);
                    pd7Var.setFromCDN(this.k);
                    pd7Var.update(this.l);
                    pd7Var.setAfterClickSchemeListener(new a(this, c2, py5Var.c, py5Var.b));
                    if (m98.class.isAssignableFrom(view2.getClass())) {
                        cardAppLegoViewHolder.f(((m98) view2).getVideoOrVrView());
                    }
                    return view2;
                }
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.j98
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.n);
        }
    }

    @Override // com.repackage.j98
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // com.repackage.j98
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }
}
