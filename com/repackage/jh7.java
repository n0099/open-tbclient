package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
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
/* loaded from: classes6.dex */
public class jh7 extends bn<oh7, SearchSuggestLiveViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* loaded from: classes6.dex */
    public class a implements yn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ jh7 b;

        public a(jh7 jh7Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jh7Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jh7Var;
            this.a = context;
        }

        @Override // com.repackage.yn
        public void b(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, onVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (onVar instanceof oh7)) {
                oh7 oh7Var = (oh7) onVar;
                this.b.u(oh7Var);
                TbPageContext tbPageContext = (TbPageContext) h9.a(this.a);
                String c = oh7Var.c();
                String f = oh7Var.f();
                String h = oh7Var.h();
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, c, f, h, "" + oh7Var.b(), "search_sug_live");
                qi.x(this.a, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBLottieAnimationView a;

        public b(jh7 jh7Var, TBLottieAnimationView tBLottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jh7Var, tBLottieAnimationView};
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
    public jh7(Context context, BdUniqueId bdUniqueId) {
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
        this.a = context;
        this.mType = bdUniqueId;
        setOnAdapterItemClickListener(new a(this, context));
    }

    public final void A(TBLottieAnimationView tBLottieAnimationView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tBLottieAnimationView) == null) {
            tBLottieAnimationView.cancelAnimation();
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.obfuscated_res_0x7f11004e);
            tBLottieAnimationView.setRepeatCount(-1);
            tBLottieAnimationView.post(new b(this, tBLottieAnimationView));
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.repackage.bn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, oh7 oh7Var, SearchSuggestLiveViewHolder searchSuggestLiveViewHolder) {
        x(i, view2, viewGroup, oh7Var, searchSuggestLiveViewHolder);
        return view2;
    }

    public final void t(StatisticItem statisticItem, oh7 oh7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, statisticItem, oh7Var) == null) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
            statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
            statisticItem.param(TiebaStatic.Params.FRIEND_UID, oh7Var.j());
            statisticItem.param(TiebaStatic.Params.ZHIBO_TYPE, oh7Var.l());
            statisticItem.param(TiebaStatic.YYParams.YYSID, oh7Var.c());
            statisticItem.param(TiebaStatic.YYParams.YYSSID, oh7Var.f());
            statisticItem.param(TiebaStatic.YYParams.YYUID, oh7Var.k());
            statisticItem.param("template_id", oh7Var.h());
        }
    }

    public final void u(oh7 oh7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, oh7Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_LIVE_CLICK);
            t(statisticItem, oh7Var);
            statisticItem.param("source", "search_sug_live");
            TiebaStatic.log(statisticItem);
        }
    }

    public final void v(TextView textView) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, textView) == null) || (context = this.a) == null || textView == null) {
            return;
        }
        textView.setMaxWidth(qi.k(context) - qi.f(this.a, R.dimen.tbds297));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: w */
    public SearchSuggestLiveViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) ? new SearchSuggestLiveViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0787, viewGroup, false)) : (SearchSuggestLiveViewHolder) invokeL.objValue;
    }

    public View x(int i, View view2, ViewGroup viewGroup, oh7 oh7Var, SearchSuggestLiveViewHolder searchSuggestLiveViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, oh7Var, searchSuggestLiveViewHolder})) == null) {
            if (oh7Var == null) {
                return view2;
            }
            y(searchSuggestLiveViewHolder);
            WebPManager.setPureDrawable(searchSuggestLiveViewHolder.c, R.drawable.obfuscated_res_0x7f080a4f, R.color.CAM_X0109, null);
            ms4 d = ms4.d(searchSuggestLiveViewHolder.e);
            d.n(R.string.J_X01);
            d.f(R.color.CAM_X0308);
            fh7.a(searchSuggestLiveViewHolder.b, oh7Var.g(), oh7Var.a());
            v(searchSuggestLiveViewHolder.b);
            A(searchSuggestLiveViewHolder.d);
            z(oh7Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void y(SearchSuggestLiveViewHolder searchSuggestLiveViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, searchSuggestLiveViewHolder) == null) {
            ms4 d = ms4.d(searchSuggestLiveViewHolder.b);
            d.v(R.color.CAM_X0105);
            d.z(R.dimen.T_X06);
            ms4 d2 = ms4.d(searchSuggestLiveViewHolder.f);
            d2.v(R.color.CAM_X0101);
            d2.z(R.dimen.T_X10);
            SkinManager.setBackgroundResource(searchSuggestLiveViewHolder.a, R.drawable.addresslist_item_bg);
            ms4.d(searchSuggestLiveViewHolder.g).f(R.color.CAM_X0203);
        }
    }

    public final void z(oh7 oh7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, oh7Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_LIVE_SHOW);
            t(statisticItem, oh7Var);
            TiebaStatic.log(statisticItem);
        }
    }
}
