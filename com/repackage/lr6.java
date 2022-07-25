package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.funad.adapter.FunAdNativeViewHolder;
import com.baidu.tieba.funad.view.FunAbsAdView;
import com.baidu.tieba.funad.view.FunAdNativeCommentView;
import com.baidu.tieba.funad.view.FunAdNativeFrsView;
import com.baidu.tieba.funad.view.FunAdNativePbView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class lr6 extends an<nn, FunAdNativeViewHolder> implements o98, j98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity i;
    public String j;
    public Set<String> k;
    public String l;
    public String m;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mi8 a;
        public final /* synthetic */ FunAdNativeViewHolder b;
        public final /* synthetic */ lr6 c;

        public a(lr6 lr6Var, mi8 mi8Var, FunAdNativeViewHolder funAdNativeViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lr6Var, mi8Var, funAdNativeViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = lr6Var;
            this.a = mi8Var;
            this.b = funAdNativeViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.m(true);
                this.c.G();
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", this.b.f()).param(TiebaStatic.Params.RESOURCE_ID, this.c.Z()).param("obj_locate", 0);
                if ("a006".equals(this.b.f())) {
                    param.param(TiebaStatic.Params.OBJ_TO, this.b.d());
                    param.param(TiebaStatic.Params.OBJ_PARAM2, this.b.c());
                }
                TiebaStatic.log(param);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lr6(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity, bdUniqueId);
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
        this.k = new HashSet();
        this.i = baseFragmentActivity;
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "pb".equals(this.l) ? this.d == AdvertAppInfo.F ? "2" : "1" : "" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: a0 */
    public FunAdNativeViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        FunAbsAdView funAdNativePbView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            BdUniqueId bdUniqueId = this.d;
            if (bdUniqueId == AdvertAppInfo.F) {
                funAdNativePbView = new FunAdNativeCommentView(this.i);
            } else if (bdUniqueId == AdvertAppInfo.E) {
                funAdNativePbView = new FunAdNativeFrsView(this.i);
            } else {
                funAdNativePbView = new FunAdNativePbView(this.i);
            }
            FunAdNativeViewHolder funAdNativeViewHolder = new FunAdNativeViewHolder(funAdNativePbView, this.i, this.d);
            funAdNativeViewHolder.m(this.j);
            funAdNativeViewHolder.l(this.m);
            return funAdNativeViewHolder;
        }
        return (FunAdNativeViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: b0 */
    public View S(int i, View view2, ViewGroup viewGroup, nn nnVar, FunAdNativeViewHolder funAdNativeViewHolder) {
        InterceptResult invokeCommon;
        long j;
        mi8 mi8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, nnVar, funAdNativeViewHolder})) == null) {
            if (nnVar instanceof rq4) {
                ThreadData threadData = ((rq4) nnVar).s;
                mi8Var = threadData.funAdData;
                j = threadData.getFid();
            } else if (nnVar instanceof ThreadData) {
                ThreadData threadData2 = (ThreadData) nnVar;
                mi8Var = threadData2.funAdData;
                j = threadData2.getFid();
            } else {
                j = 0;
                mi8Var = nnVar instanceof PostData ? ((PostData) nnVar).t0 : null;
            }
            if (mi8Var == null) {
                funAdNativeViewHolder.e().d(8);
                return funAdNativeViewHolder.a();
            }
            if (!"personalize".equals(this.l) && !AdvertAppInfo.F.equals(this.d)) {
                this.j = fr6.e().d(this.m);
            }
            BdUniqueId bdUniqueId = this.d;
            if (bdUniqueId == AdvertAppInfo.E) {
                if ("frs".equals(this.l)) {
                    zq6.m().L(this.i, this.j, zq6.b(this.l, UbsABTestHelper.isFrsFunAdSdkTest() ? "1" : "0"), String.valueOf(j), wc5.f());
                } else if ("personalize".equals(this.l)) {
                    zq6.m().K(this.i, this.j, zq6.b(this.l, UbsABTestHelper.isPersonalizeFunAdABTest() ? "1" : "0"));
                }
            } else if (bdUniqueId == AdvertAppInfo.F) {
                zq6.m().M(this.i, this.j, zq6.b(this.l, UbsABTestHelper.isPbCommentFunAdABTest() ? "1" : "0"), mi8Var.e(), mi8Var.c());
            }
            funAdNativeViewHolder.j(new a(this, mi8Var, funAdNativeViewHolder));
            funAdNativeViewHolder.e().h();
            funAdNativeViewHolder.k(this.l);
            funAdNativeViewHolder.e().setCurpage(this.l);
            funAdNativeViewHolder.m(this.j);
            this.k.add(this.j);
            funAdNativeViewHolder.n(mi8Var, nnVar instanceof on4 ? ((on4) nnVar).position + 1 : -1);
            return funAdNativeViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void c0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.l = str;
        }
    }

    public void d0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.m = str;
        }
    }

    public void e0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.j = str;
        }
    }

    @Override // com.repackage.o98
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // com.repackage.j98
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            V v = this.g;
            if (v != 0 && ((FunAdNativeViewHolder) v).e() != null) {
                ((FunAdNativeViewHolder) this.g).e().b();
            }
            for (String str : this.k) {
                zq6.m().c(str);
            }
        }
    }

    @Override // com.repackage.j98
    public void onPause() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (v = this.g) == 0 || ((FunAdNativeViewHolder) v).e() == null) {
            return;
        }
        ((FunAdNativeViewHolder) this.g).e().b();
    }

    @Override // com.repackage.j98
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }
}
