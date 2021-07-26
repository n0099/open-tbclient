package d.a.q0.s1.h.d;

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
import d.a.d.a.j;
import d.a.d.e.p.l;
import d.a.d.k.e.n;
import d.a.d.k.e.w;
/* loaded from: classes8.dex */
public class d extends d.a.d.k.e.a<d.a.q0.s1.h.e.d, SearchSuggestLiveViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context m;

    /* loaded from: classes8.dex */
    public class a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f62761e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f62762f;

        public a(d dVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62762f = dVar;
            this.f62761e = context;
        }

        @Override // d.a.d.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof d.a.q0.s1.h.e.d)) {
                d.a.q0.s1.h.e.d dVar = (d.a.q0.s1.h.e.d) nVar;
                this.f62762f.g0(dVar);
                TbPageContext tbPageContext = (TbPageContext) j.a(this.f62761e);
                String d2 = dVar.d();
                String e2 = dVar.e();
                String i3 = dVar.i();
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, d2, e2, i3, "" + dVar.c(), "search_sug_live");
                l.x(this.f62761e, view);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TBLottieAnimationView f62763e;

        public b(d dVar, TBLottieAnimationView tBLottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, tBLottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62763e = tBLottieAnimationView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f62763e.playAnimation();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = context;
        this.f42344h = bdUniqueId;
        a0(new a(this, context));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.d.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, d.a.q0.s1.h.e.d dVar, SearchSuggestLiveViewHolder searchSuggestLiveViewHolder) {
        k0(i2, view, viewGroup, dVar, searchSuggestLiveViewHolder);
        return view;
    }

    public final void f0(StatisticItem statisticItem, d.a.q0.s1.h.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, statisticItem, dVar) == null) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
            statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
            statisticItem.param(TiebaStatic.Params.FRIEND_UID, dVar.j());
            statisticItem.param(TiebaStatic.Params.ZHIBO_TYPE, dVar.n());
            statisticItem.param(TiebaStatic.YYParams.YYSID, dVar.d());
            statisticItem.param(TiebaStatic.YYParams.YYSSID, dVar.e());
            statisticItem.param(TiebaStatic.YYParams.YYUID, dVar.l());
            statisticItem.param(TiebaStatic.Params.TEMPLATE_ID, dVar.i());
        }
    }

    public final void g0(d.a.q0.s1.h.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_LIVE_CLICK);
            f0(statisticItem, dVar);
            statisticItem.param("source", "search_sug_live");
            TiebaStatic.log(statisticItem);
        }
    }

    public final void i0(TextView textView) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, textView) == null) || (context = this.m) == null || textView == null) {
            return;
        }
        textView.setMaxWidth(l.k(context) - l.g(this.m, R.dimen.tbds297));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: j0 */
    public SearchSuggestLiveViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) ? new SearchSuggestLiveViewHolder(LayoutInflater.from(this.m).inflate(R.layout.search_suggest_live_item, viewGroup, false)) : (SearchSuggestLiveViewHolder) invokeL.objValue;
    }

    public View k0(int i2, View view, ViewGroup viewGroup, d.a.q0.s1.h.e.d dVar, SearchSuggestLiveViewHolder searchSuggestLiveViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view, viewGroup, dVar, searchSuggestLiveViewHolder})) == null) {
            if (dVar == null) {
                return view;
            }
            l0(searchSuggestLiveViewHolder);
            WebPManager.setPureDrawable(searchSuggestLiveViewHolder.f18520c, R.drawable.icon_search_scan, R.color.CAM_X0109, null);
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(searchSuggestLiveViewHolder.f18522e);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0308);
            d.a.q0.s1.h.c.a(searchSuggestLiveViewHolder.f18519b, dVar.h(), dVar.b());
            i0(searchSuggestLiveViewHolder.f18519b);
            n0(searchSuggestLiveViewHolder.f18521d);
            m0(dVar);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void l0(SearchSuggestLiveViewHolder searchSuggestLiveViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, searchSuggestLiveViewHolder) == null) {
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(searchSuggestLiveViewHolder.f18519b);
            d2.t(R.color.CAM_X0105);
            d2.x(R.dimen.T_X06);
            d.a.p0.s.u.c d3 = d.a.p0.s.u.c.d(searchSuggestLiveViewHolder.f18523f);
            d3.t(R.color.CAM_X0101);
            d3.x(R.dimen.T_X10);
            SkinManager.setBackgroundResource(searchSuggestLiveViewHolder.f18518a, R.drawable.addresslist_item_bg);
            d.a.p0.s.u.c.d(searchSuggestLiveViewHolder.f18524g).f(R.color.CAM_X0203);
        }
    }

    public final void m0(d.a.q0.s1.h.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_LIVE_SHOW);
            f0(statisticItem, dVar);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void n0(TBLottieAnimationView tBLottieAnimationView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tBLottieAnimationView) == null) {
            tBLottieAnimationView.cancelAnimation();
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.lottie_sug_live);
            tBLottieAnimationView.setRepeatCount(-1);
            tBLottieAnimationView.post(new b(this, tBLottieAnimationView));
        }
    }
}
