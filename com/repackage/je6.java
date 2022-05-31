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
public class je6 extends wm<le6, CardViewHolder<ge6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public ge6 j;
    public boolean k;
    public List<ge6> l;
    public Handler m;
    public fe6 n;
    public boolean o;
    public nw5<le6> p;

    /* loaded from: classes6.dex */
    public class a extends nw5<le6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ je6 b;

        public a(je6 je6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {je6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = je6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void a(View view2, le6 le6Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, le6Var) == null) || view2 == null || le6Var == null) {
                return;
            }
            if ((view2.getId() == R.id.obfuscated_res_0x7f0922f6 || view2.getId() == R.id.obfuscated_res_0x7f0922ea || view2.getId() == R.id.obfuscated_res_0x7f0913fb) && view2.getTag() != null && (view2.getTag() instanceof ge6)) {
                ge6 ge6Var = (ge6) view2.getTag();
                if (this.b.j != null && this.b.j != ge6Var && (view2.getId() == R.id.obfuscated_res_0x7f0922f6 || view2.getId() == R.id.obfuscated_res_0x7f0913fb)) {
                    this.b.j.P();
                }
                if (this.b.j != ge6Var) {
                    this.b.j = ge6Var;
                }
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092017) {
                StatisticItem statisticItem = new StatisticItem("c12411");
                statisticItem.param("fid", le6Var.a);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090159) {
                StatisticItem statisticItem2 = new StatisticItem("c12414");
                statisticItem2.param("fid", le6Var.a);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem2);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f091f99 && view2.getId() != R.id.obfuscated_res_0x7f090571) {
                if (view2.getId() != R.id.obfuscated_res_0x7f092288 && view2.getId() != R.id.obfuscated_res_0x7f092298) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f0902b7) {
                        StatisticItem statisticItem3 = new StatisticItem("c12413");
                        statisticItem3.param("fid", le6Var.a);
                        if (TbadkCoreApplication.isLogin()) {
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(statisticItem3);
                        return;
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0913fb) {
                        StatisticItem statisticItem4 = new StatisticItem("c12416");
                        statisticItem4.param("fid", le6Var.a);
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
                statisticItem5.param("fid", le6Var.a);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem5);
            } else {
                StatisticItem statisticItem6 = new StatisticItem("c12415");
                statisticItem6.param("fid", le6Var.a);
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
        public final /* synthetic */ je6 a;

        public b(je6 je6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {je6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = je6Var;
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
    public je6(TbPageContext<?> tbPageContext, fe6 fe6Var, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), le6.u);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, fe6Var, Boolean.valueOf(z)};
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
        this.n = fe6Var;
        this.o = z;
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ge6 ge6Var = this.j;
            if (ge6Var != null) {
                return ge6Var.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e0(Configuration configuration) {
        ge6 ge6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, configuration) == null) || (ge6Var = this.j) == null) {
            return;
        }
        this.k = true;
        ge6Var.F(configuration);
        if (configuration.orientation == 1) {
            this.m.postDelayed(new b(this), 500L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: f0 */
    public CardViewHolder<ge6> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            ge6 ge6Var = new ge6(this.i, this.o);
            ge6Var.n(this.p);
            this.l.add(ge6Var);
            return new CardViewHolder<>(ge6Var);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: g0 */
    public View S(int i, View view2, ViewGroup viewGroup, le6 le6Var, CardViewHolder<ge6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, le6Var, cardViewHolder})) == null) {
            if (le6Var == null || cardViewHolder == null) {
                return null;
            }
            if (!this.k) {
                cardViewHolder.c().E(le6Var, i, this.n);
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
            ge6 ge6Var = this.j;
            if (ge6Var == null) {
                return false;
            }
            return ge6Var.H(i);
        }
        return invokeI.booleanValue;
    }

    public void i0() {
        ge6 ge6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (ge6Var = this.j) == null) {
            return;
        }
        ge6Var.I();
    }

    public void j0() {
        ge6 ge6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (ge6Var = this.j) == null) {
            return;
        }
        ge6Var.P();
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            for (ge6 ge6Var : this.l) {
                if (ge6Var != null) {
                    ge6Var.G();
                }
            }
        }
    }
}
