package com.repackage;

import android.content.Context;
import android.text.TextUtils;
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
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class pa8 extends ho<vk8, PbAppLegoViewHolder> implements aa8, v98 {
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
        public final /* synthetic */ pa8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(pa8 pa8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa8Var, Integer.valueOf(i)};
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
            this.a = pa8Var;
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
        public final /* synthetic */ pa8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(pa8 pa8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa8Var, Integer.valueOf(i)};
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
            this.a = pa8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.p0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pa8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(pa8 pa8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa8Var, Integer.valueOf(i)};
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
            this.a = pa8Var;
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
    public class d implements sc7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public d(pa8 pa8Var, AdvertAppInfo advertAppInfo, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa8Var, advertAppInfo, Integer.valueOf(i), str};
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

        @Override // com.repackage.sc7
        public void a(int i, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, hashMap) == null) || i == 0) {
                return;
            }
            if (ga8.q(i)) {
                tc8.h(this.a, this.b, hashMap, i);
            } else {
                tc8.p(this.a, this.b, this.c, null, hashMap);
            }
            AdvertAppInfo advertAppInfo = this.a;
            if (advertAppInfo.f) {
                return;
            }
            bd7.h(bd7.e(advertAppInfo));
        }
    }

    /* loaded from: classes6.dex */
    public class e implements uc7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ pa8 b;

        public e(pa8 pa8Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa8Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pa8Var;
            this.a = str;
        }

        @Override // com.repackage.uc7
        public void a(AdvertAppInfo advertAppInfo, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, advertAppInfo, i) == null) {
                gb8.b(this.b.i.getPageContext().getPageActivity(), advertAppInfo, i, this.b.i0(advertAppInfo, this.a));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pa8(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
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
    @Override // com.repackage.ho
    public /* bridge */ /* synthetic */ PbAppLegoViewHolder M(ViewGroup viewGroup) {
        m0(viewGroup);
        throw null;
    }

    public final DownloadStaticsData i0(AdvertAppInfo advertAppInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, advertAppInfo, str)) == null) {
            DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
            downloadStaticsData.setDa_page(j0(advertAppInfo));
            downloadStaticsData.setFid(str);
            downloadStaticsData.setApk_name(advertAppInfo.s);
            downloadStaticsData.setAdPosition(advertAppInfo.g);
            downloadStaticsData.setExtensionInfo(advertAppInfo.h);
            return downloadStaticsData;
        }
        return (DownloadStaticsData) invokeLL.objValue;
    }

    @Override // com.repackage.aa8
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.j = z;
        }
    }

    public final String j0(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, advertAppInfo)) == null) ? TextUtils.isEmpty(advertAppInfo.k) ? "PB" : advertAppInfo.k : (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: k0 */
    public View E(int i, View view2, ViewGroup viewGroup, vk8 vk8Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, vk8Var})) == null) {
            if (vk8Var == null || vk8Var.P0() == null) {
                return null;
            }
            if (l0(view2, vk8Var)) {
                PbAppLegoViewHolder N = N(viewGroup, vk8Var);
                this.g = N;
                if (N != null) {
                    view2 = N.b();
                }
            }
            View view3 = view2;
            if (view3 != null) {
                view3 = S(i, view3, viewGroup, vk8Var, (PbAppLegoViewHolder) view3.getTag());
                if (y98.class.isAssignableFrom(view3.getClass())) {
                    ((PbAppLegoViewHolder) this.g).g(((y98) view3).getVideoOrVrView());
                }
            }
            return view3;
        }
        return (View) invokeCommon.objValue;
    }

    public final boolean l0(View view2, vk8 vk8Var) {
        InterceptResult invokeLL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, vk8Var)) == null) {
            if (view2 == null || view2.getTag() == null || (v = this.g) == 0 || !((PbAppLegoViewHolder) v).getClass().isAssignableFrom(view2.getTag().getClass()) || !view2.getTag().getClass().isAssignableFrom(((PbAppLegoViewHolder) this.g).getClass())) {
                return true;
            }
            AdvertAppInfo.ILegoAdvert P0 = vk8Var.P0();
            Object tag = view2.getTag(R.id.obfuscated_res_0x7f091e5f);
            if (tag instanceof AdvertAppInfo.ILegoAdvert) {
                return !P0.isReusable((AdvertAppInfo.ILegoAdvert) tag);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public PbAppLegoViewHolder m0(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            throw new IllegalStateException("onCreateViewHolder(ViewGroup parent) unavailable.");
        }
        return (PbAppLegoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: n0 */
    public PbAppLegoViewHolder N(ViewGroup viewGroup, vk8 vk8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, viewGroup, vk8Var)) == null) {
            View view2 = (View) tc7.h().a(this.i.getPageContext(), vk8Var.P0(), 4);
            if (view2 != null) {
                PbAppLegoViewHolder pbAppLegoViewHolder = new PbAppLegoViewHolder((pd7) view2);
                pbAppLegoViewHolder.setIsRecyclable(false);
                return pbAppLegoViewHolder;
            }
            return null;
        }
        return (PbAppLegoViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: o0 */
    public View S(int i, View view2, ViewGroup viewGroup, vk8 vk8Var, PbAppLegoViewHolder pbAppLegoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), view2, viewGroup, vk8Var, pbAppLegoViewHolder})) == null) {
            if (this.i == null) {
                return null;
            }
            if (vk8Var.P0() instanceof AdCard) {
                ((AdCard) vk8Var.P0()).isPBBanner = vk8Var.G0;
            }
            pbAppLegoViewHolder.setIsRecyclable(false);
            AdvertAppInfo.ILegoAdvert P0 = vk8Var.P0();
            view2.setTag(R.id.obfuscated_res_0x7f091e5f, P0);
            this.i.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.i.getLayoutMode().j(view2);
            vn4.f(vk8Var);
            if (vk8Var.O0) {
                yj5.i().k(yj5.g(vk8Var.getAdvertAppInfo()));
            }
            AdvertAppInfo advertAppInfo = vk8Var.getAdvertAppInfo();
            if (advertAppInfo.j == null) {
                advertAppInfo.j = new vn4();
            }
            vn4 vn4Var = advertAppInfo.j;
            vn4Var.b = vk8Var.L0;
            vn4Var.a = vk8Var.O0();
            advertAppInfo.position = vk8Var.N0;
            advertAppInfo.f = vk8Var.O0;
            pd7 pd7Var = (pd7) view2;
            P0.setAdvertAppInfo(advertAppInfo);
            pd7Var.setFromCDN(this.j);
            pd7Var.update(P0);
            int i2 = vk8Var.L0;
            String str = vk8Var.H0;
            Context context = this.a;
            if (context instanceof lh0) {
                advertAppInfo.u = nh0.b(advertAppInfo.u, (lh0) context, view2);
            }
            pd7Var.setAfterClickSchemeListener(new d(this, advertAppInfo, i2, str));
            pd7Var.setDownloadAppCallback(new e(this, str));
            WeakReference<PbAppLegoViewHolder> weakReference = this.o;
            if (weakReference == null || weakReference.get() != pbAppLegoViewHolder) {
                this.o = new WeakReference<>(pbAppLegoViewHolder);
            }
            p0();
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.v98
    public void onDestroy() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (v = this.g) == 0) {
            return;
        }
        ((PbAppLegoViewHolder) v).f();
    }

    @Override // com.repackage.v98
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            V v = this.g;
            if (v != 0) {
                ((PbAppLegoViewHolder) v).stopPlay();
            }
            this.k = false;
        }
    }

    @Override // com.repackage.v98
    public void onResume() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (v = this.g) != 0 && ((PbAppLegoViewHolder) v).d()) {
            if (((PbAppLegoViewHolder) this.g).e() == -1) {
                ((PbAppLegoViewHolder) this.g).c((int) TimeUnit.SECONDS.toSeconds(1L));
            }
            this.k = true;
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            WeakReference<PbAppLegoViewHolder> weakReference = this.o;
            PbAppLegoViewHolder pbAppLegoViewHolder = weakReference != null ? weakReference.get() : null;
            if (pbAppLegoViewHolder != null) {
                pbAppLegoViewHolder.h();
            }
        }
    }
}
