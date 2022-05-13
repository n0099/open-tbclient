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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class pa8 extends pc6<AdvertAppInfo, FrsAppLegoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdvertAppInfo.ILegoAdvert t;
    public ga8 u;

    /* loaded from: classes6.dex */
    public class a implements cd7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public a(pa8 pa8Var, AdvertAppInfo advertAppInfo, int i, String str) {
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

        @Override // com.repackage.cd7
        public void a(int i, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, hashMap) == null) {
                if (ka8.h(i)) {
                    vb8.g(this.a, this.b, hashMap, i);
                } else {
                    vb8.n(this.a, this.b, this.c, null, hashMap);
                }
                kd7.c(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pa8(ga8 ga8Var, BdUniqueId bdUniqueId) {
        super(ga8Var.i(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ga8Var, bdUniqueId};
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
        this.u = ga8Var;
    }

    @Override // com.repackage.pc6
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: l0 */
    public View E(int i, View view2, ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        InterceptResult invokeCommon;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, advertAppInfo})) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.h) == null) {
                return null;
            }
            this.t = iLegoAdvert;
            if (m0(view2)) {
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

    public final boolean m0(View view2) {
        InterceptResult invokeL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            if (view2 == null || view2.getTag() == null || (v = this.g) == 0 || this.t == null || !((FrsAppLegoViewHolder) v).getClass().isAssignableFrom(view2.getTag().getClass()) || !view2.getTag().getClass().isAssignableFrom(((FrsAppLegoViewHolder) this.g).getClass()) || !(view2.getTag(R.id.obfuscated_res_0x7f091eb8) instanceof AdvertAppInfo.ILegoAdvert)) {
                return true;
            }
            return !this.t.isReusable((AdvertAppInfo.ILegoAdvert) view2.getTag(R.id.obfuscated_res_0x7f091eb8));
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: n0 */
    public FrsAppLegoViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            if (this.t == null || (view2 = (View) dd7.h().a(this.k, this.t, 1)) == null) {
                return null;
            }
            view2.setTag(R.id.obfuscated_res_0x7f091eb8, this.t);
            return new FrsAppLegoViewHolder((yd7) view2);
        }
        return (FrsAppLegoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: o0 */
    public FrsAppLegoViewHolder N(ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        InterceptResult invokeLL;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, advertAppInfo)) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.h) == null) {
                return null;
            }
            this.t = iLegoAdvert;
            return M(viewGroup);
        }
        return (FrsAppLegoViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.pc6, com.repackage.eo
    /* renamed from: p0 */
    public View S(int i, View view2, ViewGroup viewGroup, AdvertAppInfo advertAppInfo, FrsAppLegoViewHolder frsAppLegoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, advertAppInfo, frsAppLegoViewHolder})) == null) {
            super.S(i, view2, viewGroup, advertAppInfo, frsAppLegoViewHolder);
            if (this.u == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.h;
            this.t = iLegoAdvert;
            if (iLegoAdvert == null || view2 == null) {
                return null;
            }
            if (this.k.getPageActivity() instanceof oh0) {
                advertAppInfo.r = qh0.b(advertAppInfo.r, (oh0) this.k.getPageActivity(), frsAppLegoViewHolder.itemView);
            }
            this.k.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.k.getLayoutMode().j(view2);
            eo4.b(advertAppInfo);
            yd7 yd7Var = (yd7) view2;
            yd7Var.setFromCDN(this.i);
            yd7Var.update(this.t);
            String y = this.u.y();
            int q0 = this.u.q0();
            this.u.L();
            yd7Var.setAfterClickSchemeListener(new a(this, advertAppInfo, q0, y));
            if (da8.class.isAssignableFrom(view2.getClass())) {
                frsAppLegoViewHolder.d(((da8) view2).getVideoOrVrView());
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
