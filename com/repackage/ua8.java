package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.adapter.FrsAppLegoViewHolder;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class ua8 extends kd6<AdvertAppInfo, FrsAppLegoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdvertAppInfo.ILegoAdvert t;
    public ia8 u;

    /* loaded from: classes7.dex */
    public class a implements vc7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public a(ua8 ua8Var, AdvertAppInfo advertAppInfo, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua8Var, advertAppInfo, Integer.valueOf(i), str};
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

        @Override // com.repackage.vc7
        public void a(int i, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, hashMap) == null) {
                if (na8.q(i)) {
                    ad8.h(this.a, this.b, hashMap, i);
                } else {
                    ad8.p(this.a, this.b, this.c, null, hashMap);
                }
                ed7.h(ed7.e(this.a));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements xc7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ua8 b;

        public b(ua8 ua8Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua8Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ua8Var;
            this.a = str;
        }

        @Override // com.repackage.xc7
        public void a(AdvertAppInfo advertAppInfo, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, advertAppInfo, i) == null) {
                nb8.b(TbadkCoreApplication.getInst().getContext(), advertAppInfo, i, this.b.m0(advertAppInfo, this.a));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ua8(ia8 ia8Var, BdUniqueId bdUniqueId) {
        super(ia8Var.i(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ia8Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = null;
        this.u = ia8Var;
    }

    @Override // com.repackage.kd6
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            V v = this.g;
            if (v != 0) {
                ((FrsAppLegoViewHolder) v).c();
            }
            super.c0();
        }
    }

    public final DownloadStaticsData m0(AdvertAppInfo advertAppInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, advertAppInfo, str)) == null) {
            DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
            downloadStaticsData.setDa_page(advertAppInfo.k);
            downloadStaticsData.setFid(str);
            downloadStaticsData.setApk_name(advertAppInfo.s);
            downloadStaticsData.setAdPosition(String.valueOf(advertAppInfo.position));
            downloadStaticsData.setExtensionInfo(advertAppInfo.h);
            return downloadStaticsData;
        }
        return (DownloadStaticsData) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: n0 */
    public View E(int i, View view2, ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        InterceptResult invokeCommon;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, advertAppInfo})) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.i) == null) {
                return null;
            }
            this.t = iLegoAdvert;
            if (o0(view2)) {
                FrsAppLegoViewHolder M = M(viewGroup);
                this.g = M;
                if (M == null) {
                    return null;
                }
                view2 = M.b();
            }
            View view3 = view2;
            return S(i, view3, viewGroup, advertAppInfo, (FrsAppLegoViewHolder) view3.getTag());
        }
        return (View) invokeCommon.objValue;
    }

    public final boolean o0(View view2) {
        InterceptResult invokeL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) {
            if (view2 == null || view2.getTag() == null || (v = this.g) == 0 || this.t == null || !((FrsAppLegoViewHolder) v).getClass().isAssignableFrom(view2.getTag().getClass()) || !view2.getTag().getClass().isAssignableFrom(((FrsAppLegoViewHolder) this.g).getClass()) || !(view2.getTag(R.id.obfuscated_res_0x7f091e60) instanceof AdvertAppInfo.ILegoAdvert)) {
                return true;
            }
            return !this.t.isReusable((AdvertAppInfo.ILegoAdvert) view2.getTag(R.id.obfuscated_res_0x7f091e60));
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: p0 */
    public FrsAppLegoViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            if (this.t == null || (view2 = (View) wc7.h().a(this.k, this.t, 1)) == null) {
                return null;
            }
            view2.setTag(R.id.obfuscated_res_0x7f091e60, this.t);
            return new FrsAppLegoViewHolder((sd7) view2);
        }
        return (FrsAppLegoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: q0 */
    public FrsAppLegoViewHolder N(ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        InterceptResult invokeLL;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, viewGroup, advertAppInfo)) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.i) == null) {
                return null;
            }
            this.t = iLegoAdvert;
            return M(viewGroup);
        }
        return (FrsAppLegoViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.kd6, com.repackage.ho
    /* renamed from: r0 */
    public View S(int i, View view2, ViewGroup viewGroup, AdvertAppInfo advertAppInfo, FrsAppLegoViewHolder frsAppLegoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), view2, viewGroup, advertAppInfo, frsAppLegoViewHolder})) == null) {
            super.S(i, view2, viewGroup, advertAppInfo, frsAppLegoViewHolder);
            if (this.u == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.i;
            this.t = iLegoAdvert;
            if (iLegoAdvert == null || view2 == null) {
                return null;
            }
            if (this.k.getPageActivity() instanceof lh0) {
                advertAppInfo.u = nh0.b(advertAppInfo.u, (lh0) this.k.getPageActivity(), frsAppLegoViewHolder.itemView);
            }
            this.k.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.k.getLayoutMode().j(view2);
            un4.b(advertAppInfo);
            sd7 sd7Var = (sd7) view2;
            sd7Var.setFromCDN(this.i);
            sd7Var.update(this.t);
            String z = this.u.z();
            int q0 = this.u.q0();
            this.u.L();
            sd7Var.setAfterClickSchemeListener(new a(this, advertAppInfo, q0, z));
            sd7Var.setDownloadAppCallback(new b(this, z));
            if (fa8.class.isAssignableFrom(view2.getClass())) {
                frsAppLegoViewHolder.d(((fa8) view2).getVideoOrVrView());
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
