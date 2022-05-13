package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.searchsuggestlist.viewholder.SearchSuggestLiveViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class yf7 extends eo<dg7, SearchSuggestLiveViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context i;

    /* loaded from: classes7.dex */
    public class a implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ yf7 b;

        public a(yf7 yf7Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf7Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yf7Var;
            this.a = context;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (roVar instanceof dg7)) {
                dg7 dg7Var = (dg7) roVar;
                this.b.b0(dg7Var);
                TbPageContext tbPageContext = (TbPageContext) f9.a(this.a);
                String e = dg7Var.e();
                String f = dg7Var.f();
                String i2 = dg7Var.i();
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, e, f, i2, "" + dg7Var.b(), "search_sug_live");
                mi.w(this.a, view2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBLottieAnimationView a;

        public b(yf7 yf7Var, TBLottieAnimationView tBLottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf7Var, tBLottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBLottieAnimationView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.playAnimation();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yf7(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
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
        this.i = context;
        this.d = bdUniqueId;
        V(new a(this, context));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.repackage.eo
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, dg7 dg7Var, SearchSuggestLiveViewHolder searchSuggestLiveViewHolder) {
        e0(i, view2, viewGroup, dg7Var, searchSuggestLiveViewHolder);
        return view2;
    }

    public final void a0(StatisticItem statisticItem, dg7 dg7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, statisticItem, dg7Var) == null) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
            statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
            statisticItem.param(TiebaStatic.Params.FRIEND_UID, dg7Var.j());
            statisticItem.param(TiebaStatic.Params.ZHIBO_TYPE, dg7Var.m());
            statisticItem.param(TiebaStatic.YYParams.YYSID, dg7Var.e());
            statisticItem.param(TiebaStatic.YYParams.YYSSID, dg7Var.f());
            statisticItem.param(TiebaStatic.YYParams.YYUID, dg7Var.k());
            statisticItem.param("template_id", dg7Var.i());
        }
    }

    public final void b0(dg7 dg7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dg7Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_LIVE_CLICK);
            a0(statisticItem, dg7Var);
            statisticItem.param("source", "search_sug_live");
            TiebaStatic.log(statisticItem);
        }
    }

    public final void c0(TextView textView) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, textView) == null) || (context = this.i) == null || textView == null) {
            return;
        }
        textView.setMaxWidth(mi.k(context) - mi.f(this.i, R.dimen.tbds297));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: d0 */
    public SearchSuggestLiveViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) ? new SearchSuggestLiveViewHolder(LayoutInflater.from(this.i).inflate(R.layout.obfuscated_res_0x7f0d0742, viewGroup, false)) : (SearchSuggestLiveViewHolder) invokeL.objValue;
    }

    public View e0(int i, View view2, ViewGroup viewGroup, dg7 dg7Var, SearchSuggestLiveViewHolder searchSuggestLiveViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, dg7Var, searchSuggestLiveViewHolder})) == null) {
            if (dg7Var == null) {
                return view2;
            }
            f0(searchSuggestLiveViewHolder);
            WebPManager.setPureDrawable(searchSuggestLiveViewHolder.c, R.drawable.obfuscated_res_0x7f080a29, R.color.CAM_X0109, null);
            gs4 d = gs4.d(searchSuggestLiveViewHolder.e);
            d.n(R.string.J_X01);
            d.f(R.color.CAM_X0308);
            uf7.a(searchSuggestLiveViewHolder.b, dg7Var.g(), dg7Var.a());
            c0(searchSuggestLiveViewHolder.b);
            h0(searchSuggestLiveViewHolder.d);
            g0(dg7Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void f0(SearchSuggestLiveViewHolder searchSuggestLiveViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, searchSuggestLiveViewHolder) == null) {
            gs4 d = gs4.d(searchSuggestLiveViewHolder.b);
            d.v(R.color.CAM_X0105);
            d.z(R.dimen.T_X06);
            gs4 d2 = gs4.d(searchSuggestLiveViewHolder.f);
            d2.v(R.color.CAM_X0101);
            d2.z(R.dimen.T_X10);
            SkinManager.setBackgroundResource(searchSuggestLiveViewHolder.a, R.drawable.addresslist_item_bg);
            gs4.d(searchSuggestLiveViewHolder.g).f(R.color.CAM_X0203);
        }
    }

    public final void g0(dg7 dg7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dg7Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_LIVE_SHOW);
            a0(statisticItem, dg7Var);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void h0(TBLottieAnimationView tBLottieAnimationView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tBLottieAnimationView) == null) {
            tBLottieAnimationView.cancelAnimation();
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.obfuscated_res_0x7f110049);
            tBLottieAnimationView.setRepeatCount(-1);
            tBLottieAnimationView.post(new b(this, tBLottieAnimationView));
        }
    }
}
