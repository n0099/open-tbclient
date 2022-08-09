package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
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
public class hc8 extends bn<bl8, PbAppLegoViewHolder> implements vb8, qb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;
    public boolean b;
    public boolean c;
    public boolean d;
    public CustomMessageListener e;
    public CustomMessageListener f;
    public CustomMessageListener g;
    public WeakReference<PbAppLegoViewHolder> h;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hc8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(hc8 hc8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc8Var, Integer.valueOf(i)};
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
            this.a = hc8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.viewholder != null && this.a.c) {
                int c = ((PbAppLegoViewHolder) this.a.viewholder).c();
                if (((PbAppLegoViewHolder) this.a.viewholder).b()) {
                    if (c == -1) {
                        ((PbAppLegoViewHolder) this.a.viewholder).a((int) TimeUnit.SECONDS.toSeconds(1L));
                    }
                } else if (c != -1) {
                    ((PbAppLegoViewHolder) this.a.viewholder).stopPlay();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hc8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(hc8 hc8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc8Var, Integer.valueOf(i)};
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
            this.a = hc8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.updateFontSize();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hc8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(hc8 hc8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc8Var, Integer.valueOf(i)};
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
            this.a = hc8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.viewholder != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                ((PbAppLegoViewHolder) this.a.viewholder).stopPlay();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements oe7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public d(hc8 hc8Var, AdvertAppInfo advertAppInfo, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc8Var, advertAppInfo, Integer.valueOf(i), str};
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

        @Override // com.repackage.oe7
        public void a(int i, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, hashMap) == null) || i == 0) {
                return;
            }
            if (ac8.h(i)) {
                md8.g(this.a, this.b, hashMap, i);
            } else {
                md8.n(this.a, this.b, this.c, null, hashMap);
            }
            we7.c(this.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hc8(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
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
        this.c = true;
        this.e = new a(this, 2004013);
        this.f = new b(this, 2004018);
        this.g = new c(this, 2004020);
        this.h = null;
        this.a = baseFragmentActivity;
        baseFragmentActivity.registerListener(this.e);
        this.a.registerListener(this.g);
        this.a.registerListener(this.f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: A */
    public View getView(int i, View view2, ViewGroup viewGroup, bl8 bl8Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bl8Var})) == null) {
            if (bl8Var == null || bl8Var.l1() == null) {
                return null;
            }
            if (B(view2, bl8Var)) {
                PbAppLegoViewHolder onCreateViewHolder = onCreateViewHolder(viewGroup, bl8Var);
                this.viewholder = onCreateViewHolder;
                if (onCreateViewHolder != null) {
                    view2 = onCreateViewHolder.getView();
                }
            }
            View view3 = view2;
            if (view3 != null) {
                view3 = onFillViewHolder(i, view3, viewGroup, bl8Var, (PbAppLegoViewHolder) view3.getTag());
                if (tb8.class.isAssignableFrom(view3.getClass())) {
                    ((PbAppLegoViewHolder) this.viewholder).e(((tb8) view3).getVideoOrVrView());
                }
            }
            return view3;
        }
        return (View) invokeCommon.objValue;
    }

    public final boolean B(View view2, bl8 bl8Var) {
        InterceptResult invokeLL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, bl8Var)) == null) {
            if (view2 == null || view2.getTag() == null || (v = this.viewholder) == 0 || !((PbAppLegoViewHolder) v).getClass().isAssignableFrom(view2.getTag().getClass()) || !view2.getTag().getClass().isAssignableFrom(((PbAppLegoViewHolder) this.viewholder).getClass())) {
                return true;
            }
            AdvertAppInfo.ILegoAdvert l1 = bl8Var.l1();
            Object tag = view2.getTag(R.id.obfuscated_res_0x7f091ff2);
            if (tag instanceof AdvertAppInfo.ILegoAdvert) {
                return !l1.isReusable((AdvertAppInfo.ILegoAdvert) tag);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public PbAppLegoViewHolder C(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            throw new IllegalStateException("onCreateViewHolder(ViewGroup parent) unavailable.");
        }
        return (PbAppLegoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: D */
    public PbAppLegoViewHolder onCreateViewHolder(ViewGroup viewGroup, bl8 bl8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewGroup, bl8Var)) == null) {
            View view2 = (View) pe7.h().a(this.a.getPageContext(), bl8Var.l1(), 4);
            if (view2 != null) {
                PbAppLegoViewHolder pbAppLegoViewHolder = new PbAppLegoViewHolder((kf7) view2);
                pbAppLegoViewHolder.setIsRecyclable(false);
                return pbAppLegoViewHolder;
            }
            return null;
        }
        return (PbAppLegoViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: E */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bl8 bl8Var, PbAppLegoViewHolder pbAppLegoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bl8Var, pbAppLegoViewHolder})) == null) {
            if (this.a == null) {
                return null;
            }
            if (bl8Var.l1() instanceof AdCard) {
                ((AdCard) bl8Var.l1()).isPBBanner = bl8Var.U0;
            }
            pbAppLegoViewHolder.setIsRecyclable(false);
            AdvertAppInfo.ILegoAdvert l1 = bl8Var.l1();
            view2.setTag(R.id.obfuscated_res_0x7f091ff2, l1);
            this.a.getLayoutMode().l(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.a.getLayoutMode().k(view2);
            ko4.f(bl8Var);
            AdvertAppInfo advertAppInfo = bl8Var.getAdvertAppInfo();
            if (advertAppInfo.i == null) {
                advertAppInfo.i = new ko4();
            }
            ko4 ko4Var = advertAppInfo.i;
            ko4Var.b = bl8Var.Z0;
            ko4Var.a = bl8Var.k1();
            advertAppInfo.position = bl8Var.b1;
            advertAppInfo.u = 3;
            int i2 = bl8Var.Z0;
            String str = bl8Var.V0;
            advertAppInfo.t = str;
            kf7<?> kf7Var = (kf7) view2;
            kf7Var.setMulDel(this.d);
            l1.setAdvertAppInfo(advertAppInfo);
            kf7Var.setFromCDN(this.b);
            kf7Var.update(l1);
            F(bl8Var, kf7Var, str);
            Context context = this.mContext;
            if (context instanceof hg0) {
                advertAppInfo.r = jg0.b(advertAppInfo.r, (hg0) context, view2);
            }
            kf7Var.setAfterClickSchemeListener(new d(this, advertAppInfo, i2, str));
            WeakReference<PbAppLegoViewHolder> weakReference = this.h;
            if (weakReference == null || weakReference.get() != pbAppLegoViewHolder) {
                this.h = new WeakReference<>(pbAppLegoViewHolder);
            }
            updateFontSize();
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void F(bl8 bl8Var, kf7<?> kf7Var, String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, bl8Var, kf7Var, str) == null) {
            if (bl8Var.U0) {
                i = bl8Var.c1;
            } else {
                i = bl8Var.c1;
                if (xl5.k().m()) {
                    i++;
                }
            }
            ed8.e(bl8Var.getAdvertAppInfo(), kf7Var, str, null, 3, i);
        }
    }

    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder' to match base method */
    @Override // com.repackage.bn
    public /* bridge */ /* synthetic */ PbAppLegoViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        C(viewGroup);
        throw null;
    }

    @Override // com.repackage.qb8
    public void onDestroy() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (v = this.viewholder) == 0) {
            return;
        }
        ((PbAppLegoViewHolder) v).d();
    }

    @Override // com.repackage.qb8
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            V v = this.viewholder;
            if (v != 0) {
                ((PbAppLegoViewHolder) v).stopPlay();
            }
            this.c = false;
        }
    }

    @Override // com.repackage.qb8
    public void onResume() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (v = this.viewholder) != 0 && ((PbAppLegoViewHolder) v).b()) {
            if (((PbAppLegoViewHolder) this.viewholder).c() == -1) {
                ((PbAppLegoViewHolder) this.viewholder).a((int) TimeUnit.SECONDS.toSeconds(1L));
            }
            this.c = true;
        }
    }

    @Override // com.repackage.vb8
    public void setIsFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.b = z;
        }
    }

    @Override // com.repackage.bn
    public void setMulDel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.d = z;
        }
    }

    public void updateFontSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            WeakReference<PbAppLegoViewHolder> weakReference = this.h;
            PbAppLegoViewHolder pbAppLegoViewHolder = weakReference != null ? weakReference.get() : null;
            if (pbAppLegoViewHolder != null) {
                pbAppLegoViewHolder.f();
            }
        }
    }
}
