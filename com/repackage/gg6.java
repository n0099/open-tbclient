package com.repackage;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class gg6 extends an<ig6, CardViewHolder<dg6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public dg6 j;
    public boolean k;
    public List<dg6> l;
    public Handler m;
    public cg6 n;
    public boolean o;
    public jy5<ig6> p;

    /* loaded from: classes6.dex */
    public class a extends jy5<ig6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gg6 b;

        public a(gg6 gg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gg6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, ig6 ig6Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ig6Var) == null) || view2 == null || ig6Var == null) {
                return;
            }
            if ((view2.getId() == R.id.obfuscated_res_0x7f09238b || view2.getId() == R.id.obfuscated_res_0x7f09237f || view2.getId() == R.id.obfuscated_res_0x7f091495) && view2.getTag() != null && (view2.getTag() instanceof dg6)) {
                dg6 dg6Var = (dg6) view2.getTag();
                if (this.b.j != null && this.b.j != dg6Var && (view2.getId() == R.id.obfuscated_res_0x7f09238b || view2.getId() == R.id.obfuscated_res_0x7f091495)) {
                    this.b.j.P();
                }
                if (this.b.j != dg6Var) {
                    this.b.j = dg6Var;
                }
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0920bc) {
                StatisticItem statisticItem = new StatisticItem("c12411");
                statisticItem.param("fid", ig6Var.a);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09015a) {
                StatisticItem statisticItem2 = new StatisticItem("c12414");
                statisticItem2.param("fid", ig6Var.a);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem2);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f09203e && view2.getId() != R.id.obfuscated_res_0x7f090553) {
                if (view2.getId() != R.id.obfuscated_res_0x7f09231d && view2.getId() != R.id.obfuscated_res_0x7f09232d) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f0902b9) {
                        StatisticItem statisticItem3 = new StatisticItem("c12413");
                        statisticItem3.param("fid", ig6Var.a);
                        if (TbadkCoreApplication.isLogin()) {
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(statisticItem3);
                        return;
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091495) {
                        StatisticItem statisticItem4 = new StatisticItem("c12416");
                        statisticItem4.param("fid", ig6Var.a);
                        if (TbadkCoreApplication.isLogin()) {
                            statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(statisticItem4);
                        return;
                    } else {
                        return;
                    }
                }
                StatisticItem statisticItem5 = new StatisticItem("c12412");
                statisticItem5.param("fid", ig6Var.a);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem5);
            } else {
                StatisticItem statisticItem6 = new StatisticItem("c12415");
                statisticItem6.param("fid", ig6Var.a);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem6);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gg6 a;

        public b(gg6 gg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gg6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.k) {
                this.a.k = false;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gg6(TbPageContext<?> tbPageContext, cg6 cg6Var, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), ig6.u);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cg6Var, Boolean.valueOf(z)};
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
        this.l = new ArrayList();
        this.m = new Handler();
        this.p = new a(this);
        this.i = tbPageContext;
        this.n = cg6Var;
        this.o = z;
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            dg6 dg6Var = this.j;
            if (dg6Var != null) {
                return dg6Var.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e0(Configuration configuration) {
        dg6 dg6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, configuration) == null) || (dg6Var = this.j) == null) {
            return;
        }
        this.k = true;
        dg6Var.E(configuration);
        if (configuration.orientation == 1) {
            this.m.postDelayed(new b(this), 500L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: f0 */
    public CardViewHolder<dg6> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            dg6 dg6Var = new dg6(this.i, this.o);
            dg6Var.n(this.p);
            this.l.add(dg6Var);
            return new CardViewHolder<>(dg6Var);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: g0 */
    public View S(int i, View view2, ViewGroup viewGroup, ig6 ig6Var, CardViewHolder<dg6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ig6Var, cardViewHolder})) == null) {
            if (ig6Var == null || cardViewHolder == null) {
                return null;
            }
            if (!this.k) {
                cardViewHolder.c().D(ig6Var, i, this.n);
                cardViewHolder.c().F = i;
            }
            return cardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public boolean h0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            dg6 dg6Var = this.j;
            if (dg6Var == null) {
                return false;
            }
            return dg6Var.G(i);
        }
        return invokeI.booleanValue;
    }

    public void i0() {
        dg6 dg6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (dg6Var = this.j) == null) {
            return;
        }
        dg6Var.H();
    }

    public void j0() {
        dg6 dg6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (dg6Var = this.j) == null) {
            return;
        }
        dg6Var.P();
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            for (dg6 dg6Var : this.l) {
                if (dg6Var != null) {
                    dg6Var.F();
                }
            }
        }
    }
}
