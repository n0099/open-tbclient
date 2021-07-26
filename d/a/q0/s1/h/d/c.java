package d.a.q0.s1.h.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.searchsuggestlist.viewholder.SearchSuggestItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.d.k.e.n;
import d.a.d.k.e.w;
import d.a.q0.h3.h0.m;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class c extends d.a.d.k.e.a<d.a.q0.s1.h.e.c, SearchSuggestItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context m;

    /* loaded from: classes8.dex */
    public class a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f62759e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f62760f;

        public a(c cVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62760f = cVar;
            this.f62759e = context;
        }

        @Override // d.a.d.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof d.a.q0.s1.h.e.c)) {
                HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder();
                d.a.q0.s1.h.e.c cVar = (d.a.q0.s1.h.e.c) nVar;
                sb.append(cVar.c());
                sb.append("");
                hashMap.put("itemID", sb.toString());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(this.f62759e, "GameItemDetailsPage", hashMap)));
                this.f62760f.g0(cVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, BdUniqueId bdUniqueId) {
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
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, d.a.q0.s1.h.e.c cVar, SearchSuggestItemViewHolder searchSuggestItemViewHolder) {
        j0(i2, view, viewGroup, cVar, searchSuggestItemViewHolder);
        return view;
    }

    public final void f0(StatisticItem statisticItem, d.a.q0.s1.h.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, statisticItem, cVar) == null) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("item_id", cVar.c().longValue());
        }
    }

    public final void g0(d.a.q0.s1.h.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_ITEM_CLICK);
            f0(statisticItem, cVar);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: i0 */
    public SearchSuggestItemViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new SearchSuggestItemViewHolder(LayoutInflater.from(this.m).inflate(R.layout.search_suggest_itemcard_item, viewGroup, false)) : (SearchSuggestItemViewHolder) invokeL.objValue;
    }

    public View j0(int i2, View view, ViewGroup viewGroup, d.a.q0.s1.h.e.c cVar, SearchSuggestItemViewHolder searchSuggestItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, cVar, searchSuggestItemViewHolder})) == null) {
            if (cVar == null) {
                return view;
            }
            k0(searchSuggestItemViewHolder);
            searchSuggestItemViewHolder.f18512b.setConrers(15);
            searchSuggestItemViewHolder.f18512b.setRadiusById(R.string.J_X06);
            searchSuggestItemViewHolder.f18512b.M(cVar.b(), 10, false);
            searchSuggestItemViewHolder.f18513c.setText(cVar.d());
            searchSuggestItemViewHolder.f18516f.setStarSpacing(l.g(this.m, R.dimen.M_W_X002));
            searchSuggestItemViewHolder.f18516f.setStarCount(cVar.h().intValue());
            TextView textView = searchSuggestItemViewHolder.f18514d;
            StringBuilder sb = new StringBuilder();
            sb.append(cVar.e());
            String str = "";
            sb.append("");
            textView.setText(sb.toString());
            if (cVar.i() != null) {
                for (String str2 : cVar.i()) {
                    if (!StringUtils.isNull(str2)) {
                        if (!StringUtils.isNull(str)) {
                            str2 = str + " " + str2;
                        }
                        str = str2;
                    }
                }
            }
            searchSuggestItemViewHolder.f18515e.setText(str);
            l0(cVar);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void k0(SearchSuggestItemViewHolder searchSuggestItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, searchSuggestItemViewHolder) == null) {
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(searchSuggestItemViewHolder.f18513c);
            d2.y(R.string.F_X02);
            d2.t(R.color.CAM_X0105);
            d2.x(R.dimen.T_X06);
            d.a.p0.s.u.c d3 = d.a.p0.s.u.c.d(searchSuggestItemViewHolder.f18514d);
            d3.t(R.color.CAM_X0108);
            d3.x(R.dimen.T_X09);
            d.a.p0.s.u.c d4 = d.a.p0.s.u.c.d(searchSuggestItemViewHolder.f18515e);
            d4.t(R.color.CAM_X0108);
            d4.x(R.dimen.T_X09);
            SkinManager.setBackgroundResource(searchSuggestItemViewHolder.f18511a, R.drawable.addresslist_item_bg);
            d.a.p0.s.u.c.d(searchSuggestItemViewHolder.f18517g).f(R.color.CAM_X0203);
        }
    }

    public final void l0(d.a.q0.s1.h.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_ITEM_SHOW);
            f0(statisticItem, cVar);
            TiebaStatic.log(statisticItem);
        }
    }
}
