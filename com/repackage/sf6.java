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
/* loaded from: classes7.dex */
public class sf6 extends eo<uf6, CardViewHolder<pf6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public pf6 j;
    public boolean k;
    public List<pf6> l;
    public Handler m;
    public of6 n;
    public boolean o;
    public ux5<uf6> p;

    /* loaded from: classes7.dex */
    public class a extends ux5<uf6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sf6 b;

        public a(sf6 sf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sf6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
        /* renamed from: d */
        public void a(View view2, uf6 uf6Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, uf6Var) == null) || view2 == null || uf6Var == null) {
                return;
            }
            if ((view2.getId() == R.id.obfuscated_res_0x7f092351 || view2.getId() == R.id.obfuscated_res_0x7f092345 || view2.getId() == R.id.obfuscated_res_0x7f09143b) && view2.getTag() != null && (view2.getTag() instanceof pf6)) {
                pf6 pf6Var = (pf6) view2.getTag();
                if (this.b.j != null && this.b.j != pf6Var && (view2.getId() == R.id.obfuscated_res_0x7f092351 || view2.getId() == R.id.obfuscated_res_0x7f09143b)) {
                    this.b.j.P();
                }
                if (this.b.j != pf6Var) {
                    this.b.j = pf6Var;
                }
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092071) {
                StatisticItem statisticItem = new StatisticItem("c12411");
                statisticItem.param("fid", uf6Var.a);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09015c) {
                StatisticItem statisticItem2 = new StatisticItem("c12414");
                statisticItem2.param("fid", uf6Var.a);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem2);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f091ff4 && view2.getId() != R.id.obfuscated_res_0x7f090578) {
                if (view2.getId() != R.id.obfuscated_res_0x7f0922e3 && view2.getId() != R.id.obfuscated_res_0x7f0922f3) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f0902ba) {
                        StatisticItem statisticItem3 = new StatisticItem("c12413");
                        statisticItem3.param("fid", uf6Var.a);
                        if (TbadkCoreApplication.isLogin()) {
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(statisticItem3);
                        return;
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09143b) {
                        StatisticItem statisticItem4 = new StatisticItem("c12416");
                        statisticItem4.param("fid", uf6Var.a);
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
                statisticItem5.param("fid", uf6Var.a);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem5);
            } else {
                StatisticItem statisticItem6 = new StatisticItem("c12415");
                statisticItem6.param("fid", uf6Var.a);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem6);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sf6 a;

        public b(sf6 sf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sf6Var;
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
    public sf6(TbPageContext<?> tbPageContext, of6 of6Var, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), uf6.u);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, of6Var, Boolean.valueOf(z)};
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
        this.n = of6Var;
        this.o = z;
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            pf6 pf6Var = this.j;
            if (pf6Var != null) {
                return pf6Var.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e0(Configuration configuration) {
        pf6 pf6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, configuration) == null) || (pf6Var = this.j) == null) {
            return;
        }
        this.k = true;
        pf6Var.F(configuration);
        if (configuration.orientation == 1) {
            this.m.postDelayed(new b(this), 500L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: f0 */
    public CardViewHolder<pf6> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            pf6 pf6Var = new pf6(this.i, this.o);
            pf6Var.n(this.p);
            this.l.add(pf6Var);
            return new CardViewHolder<>(pf6Var);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: g0 */
    public View S(int i, View view2, ViewGroup viewGroup, uf6 uf6Var, CardViewHolder<pf6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, uf6Var, cardViewHolder})) == null) {
            if (uf6Var == null || cardViewHolder == null) {
                return null;
            }
            if (!this.k) {
                cardViewHolder.c().E(uf6Var, i, this.n);
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
            pf6 pf6Var = this.j;
            if (pf6Var == null) {
                return false;
            }
            return pf6Var.H(i);
        }
        return invokeI.booleanValue;
    }

    public void i0() {
        pf6 pf6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (pf6Var = this.j) == null) {
            return;
        }
        pf6Var.I();
    }

    public void j0() {
        pf6 pf6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (pf6Var = this.j) == null) {
            return;
        }
        pf6Var.P();
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            for (pf6 pf6Var : this.l) {
                if (pf6Var != null) {
                    pf6Var.G();
                }
            }
        }
    }
}
