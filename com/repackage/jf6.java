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
public class jf6 extends an<lf6, CardViewHolder<gf6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public gf6 j;
    public boolean k;
    public List<gf6> l;
    public Handler m;
    public ff6 n;
    public boolean o;
    public mx5<lf6> p;

    /* loaded from: classes6.dex */
    public class a extends mx5<lf6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jf6 b;

        public a(jf6 jf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jf6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.mx5
        /* renamed from: d */
        public void a(View view2, lf6 lf6Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, lf6Var) == null) || view2 == null || lf6Var == null) {
                return;
            }
            if ((view2.getId() == R.id.obfuscated_res_0x7f0922e3 || view2.getId() == R.id.obfuscated_res_0x7f0922d7 || view2.getId() == R.id.obfuscated_res_0x7f0913ed) && view2.getTag() != null && (view2.getTag() instanceof gf6)) {
                gf6 gf6Var = (gf6) view2.getTag();
                if (this.b.j != null && this.b.j != gf6Var && (view2.getId() == R.id.obfuscated_res_0x7f0922e3 || view2.getId() == R.id.obfuscated_res_0x7f0913ed)) {
                    this.b.j.P();
                }
                if (this.b.j != gf6Var) {
                    this.b.j = gf6Var;
                }
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092017) {
                StatisticItem statisticItem = new StatisticItem("c12411");
                statisticItem.param("fid", lf6Var.a);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090159) {
                StatisticItem statisticItem2 = new StatisticItem("c12414");
                statisticItem2.param("fid", lf6Var.a);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem2);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f091f99 && view2.getId() != R.id.obfuscated_res_0x7f090551) {
                if (view2.getId() != R.id.obfuscated_res_0x7f092275 && view2.getId() != R.id.obfuscated_res_0x7f092285) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f0902b7) {
                        StatisticItem statisticItem3 = new StatisticItem("c12413");
                        statisticItem3.param("fid", lf6Var.a);
                        if (TbadkCoreApplication.isLogin()) {
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(statisticItem3);
                        return;
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0913ed) {
                        StatisticItem statisticItem4 = new StatisticItem("c12416");
                        statisticItem4.param("fid", lf6Var.a);
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
                statisticItem5.param("fid", lf6Var.a);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem5);
            } else {
                StatisticItem statisticItem6 = new StatisticItem("c12415");
                statisticItem6.param("fid", lf6Var.a);
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
        public final /* synthetic */ jf6 a;

        public b(jf6 jf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jf6Var;
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
    public jf6(TbPageContext<?> tbPageContext, ff6 ff6Var, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), lf6.u);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, ff6Var, Boolean.valueOf(z)};
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
        this.n = ff6Var;
        this.o = z;
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            gf6 gf6Var = this.j;
            if (gf6Var != null) {
                return gf6Var.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e0(Configuration configuration) {
        gf6 gf6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, configuration) == null) || (gf6Var = this.j) == null) {
            return;
        }
        this.k = true;
        gf6Var.E(configuration);
        if (configuration.orientation == 1) {
            this.m.postDelayed(new b(this), 500L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: f0 */
    public CardViewHolder<gf6> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            gf6 gf6Var = new gf6(this.i, this.o);
            gf6Var.n(this.p);
            this.l.add(gf6Var);
            return new CardViewHolder<>(gf6Var);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: g0 */
    public View S(int i, View view2, ViewGroup viewGroup, lf6 lf6Var, CardViewHolder<gf6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, lf6Var, cardViewHolder})) == null) {
            if (lf6Var == null || cardViewHolder == null) {
                return null;
            }
            if (!this.k) {
                cardViewHolder.c().D(lf6Var, i, this.n);
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
            gf6 gf6Var = this.j;
            if (gf6Var == null) {
                return false;
            }
            return gf6Var.G(i);
        }
        return invokeI.booleanValue;
    }

    public void i0() {
        gf6 gf6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (gf6Var = this.j) == null) {
            return;
        }
        gf6Var.H();
    }

    public void j0() {
        gf6 gf6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (gf6Var = this.j) == null) {
            return;
        }
        gf6Var.P();
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            for (gf6 gf6Var : this.l) {
                if (gf6Var != null) {
                    gf6Var.F();
                }
            }
        }
    }
}
