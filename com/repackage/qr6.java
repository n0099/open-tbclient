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
/* loaded from: classes7.dex */
public class qr6 extends eo<ro, FunAdNativeViewHolder> implements fa8, aa8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity i;
    public String j;
    public Set<String> k;
    public String l;
    public String m;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yj8 a;
        public final /* synthetic */ FunAdNativeViewHolder b;
        public final /* synthetic */ qr6 c;

        public a(qr6 qr6Var, yj8 yj8Var, FunAdNativeViewHolder funAdNativeViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qr6Var, yj8Var, funAdNativeViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qr6Var;
            this.a = yj8Var;
            this.b = funAdNativeViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.m(true);
                this.c.H();
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", this.b.g()).param(TiebaStatic.Params.RESOURCE_ID, this.c.Z()).param("obj_locate", 0);
                if ("a006".equals(this.b.g())) {
                    param.param(TiebaStatic.Params.OBJ_TO, this.b.e());
                    param.param(TiebaStatic.Params.OBJ_PARAM2, this.b.d());
                }
                TiebaStatic.log(param);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qr6(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
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
    @Override // com.repackage.eo
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
            funAdNativeViewHolder.n(this.j);
            funAdNativeViewHolder.m(this.m);
            return funAdNativeViewHolder;
        }
        return (FunAdNativeViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: b0 */
    public View S(int i, View view2, ViewGroup viewGroup, ro roVar, FunAdNativeViewHolder funAdNativeViewHolder) {
        InterceptResult invokeCommon;
        long j;
        yj8 yj8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, roVar, funAdNativeViewHolder})) == null) {
            if (roVar instanceof br4) {
                ThreadData threadData = ((br4) roVar).s;
                yj8Var = threadData.funAdData;
                j = threadData.getFid();
            } else if (roVar instanceof ThreadData) {
                ThreadData threadData2 = (ThreadData) roVar;
                yj8Var = threadData2.funAdData;
                j = threadData2.getFid();
            } else {
                j = 0;
                yj8Var = roVar instanceof PostData ? ((PostData) roVar).s0 : null;
            }
            if (yj8Var == null) {
                funAdNativeViewHolder.f().d(8);
                return funAdNativeViewHolder.b();
            }
            if (!"personalize".equals(this.l) && !AdvertAppInfo.F.equals(this.d)) {
                this.j = kr6.e().d(this.m);
            }
            BdUniqueId bdUniqueId = this.d;
            if (bdUniqueId == AdvertAppInfo.E) {
                if ("frs".equals(this.l)) {
                    er6.j().E(this.i, this.j, er6.b(this.l, UbsABTestHelper.isFrsFunAdSdkTest() ? "1" : "0"), String.valueOf(j), lc5.f());
                } else if ("personalize".equals(this.l)) {
                    er6.j().D(this.i, this.j, er6.b(this.l, UbsABTestHelper.isPersonalizeFunAdABTest() ? "1" : "0"));
                }
            } else if (bdUniqueId == AdvertAppInfo.F) {
                er6.j().F(this.i, this.j, er6.b(this.l, UbsABTestHelper.isPbCommentFunAdABTest() ? "1" : "0"), yj8Var.e(), yj8Var.c());
            }
            funAdNativeViewHolder.k(new a(this, yj8Var, funAdNativeViewHolder));
            funAdNativeViewHolder.f().h();
            funAdNativeViewHolder.l(this.l);
            funAdNativeViewHolder.f().setCurpage(this.l);
            funAdNativeViewHolder.n(this.j);
            this.k.add(this.j);
            funAdNativeViewHolder.o(yj8Var, roVar instanceof zn4 ? ((zn4) roVar).position + 1 : -1);
            return funAdNativeViewHolder.b();
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

    @Override // com.repackage.fa8
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // com.repackage.aa8
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            V v = this.g;
            if (v != 0 && ((FunAdNativeViewHolder) v).f() != null) {
                ((FunAdNativeViewHolder) this.g).f().b();
            }
            for (String str : this.k) {
                er6.j().c(str);
            }
        }
    }

    @Override // com.repackage.aa8
    public void onPause() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (v = this.g) == 0 || ((FunAdNativeViewHolder) v).f() == null) {
            return;
        }
        ((FunAdNativeViewHolder) this.g).f().b();
    }

    @Override // com.repackage.aa8
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }
}
