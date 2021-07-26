package d.a.q0.s1.h.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.searchsuggestlist.viewholder.SearchSuggestForumViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.d.k.e.w;
/* loaded from: classes8.dex */
public class b extends d.a.d.k.e.a<d.a.q0.s1.h.e.b, SearchSuggestForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context m;

    /* loaded from: classes8.dex */
    public class a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f62757e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f62758f;

        public a(b bVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62758f = bVar;
            this.f62757e = context;
        }

        @Override // d.a.d.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof d.a.q0.s1.h.e.b)) {
                d.a.q0.s1.h.e.b bVar = (d.a.q0.s1.h.e.b) nVar;
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f62757e).createNormalCfg(bVar.d(), FrsActivityConfig.FRS_FROM_SEARCH_SUG);
                createNormalCfg.setCallFrom(16);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                this.f62758f.g0(bVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, BdUniqueId bdUniqueId) {
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
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, d.a.q0.s1.h.e.b bVar, SearchSuggestForumViewHolder searchSuggestForumViewHolder) {
        j0(i2, view, viewGroup, bVar, searchSuggestForumViewHolder);
        return view;
    }

    public final void f0(StatisticItem statisticItem, d.a.q0.s1.h.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, statisticItem, bVar) == null) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", bVar.c().longValue());
            statisticItem.param("fname", bVar.d());
        }
    }

    public final void g0(d.a.q0.s1.h.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_FORUM_CLICK);
            f0(statisticItem, bVar);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: i0 */
    public SearchSuggestForumViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new SearchSuggestForumViewHolder(LayoutInflater.from(this.m).inflate(R.layout.search_suggest_forum_item, viewGroup, false)) : (SearchSuggestForumViewHolder) invokeL.objValue;
    }

    public View j0(int i2, View view, ViewGroup viewGroup, d.a.q0.s1.h.e.b bVar, SearchSuggestForumViewHolder searchSuggestForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, searchSuggestForumViewHolder})) == null) {
            if (bVar == null) {
                return view;
            }
            k0(searchSuggestForumViewHolder);
            searchSuggestForumViewHolder.f18505b.setConrers(15);
            searchSuggestForumViewHolder.f18505b.setRadiusById(R.string.J_X06);
            searchSuggestForumViewHolder.f18505b.M(bVar.b(), 10, false);
            searchSuggestForumViewHolder.f18506c.setText(bVar.d() + this.m.getString(R.string.forum));
            if (!StringUtils.isNull(bVar.h())) {
                searchSuggestForumViewHolder.f18507d.setText(this.m.getString(R.string.search_forum_introduce, bVar.h()));
            } else {
                Context context = this.m;
                searchSuggestForumViewHolder.f18507d.setText(context.getString(R.string.search_forum_introduce, context.getString(R.string.search_forum_no_introduce)));
            }
            searchSuggestForumViewHolder.f18508e.setText(String.format(this.m.getString(R.string.concern), StringHelper.numberUniformFormatExtraWithRoundInt(bVar.e().intValue())));
            searchSuggestForumViewHolder.f18509f.setText(String.format(this.m.getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtraWithRoundInt(bVar.i().intValue())));
            l0(bVar);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void k0(SearchSuggestForumViewHolder searchSuggestForumViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, searchSuggestForumViewHolder) == null) {
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(searchSuggestForumViewHolder.f18506c);
            d2.y(R.string.F_X02);
            d2.x(R.dimen.T_X06);
            d2.t(R.color.CAM_X0105);
            d.a.p0.s.u.c d3 = d.a.p0.s.u.c.d(searchSuggestForumViewHolder.f18507d);
            d3.x(R.dimen.T_X09);
            d3.t(R.color.CAM_X0108);
            d.a.p0.s.u.c d4 = d.a.p0.s.u.c.d(searchSuggestForumViewHolder.f18508e);
            d4.x(R.dimen.T_X09);
            d4.t(R.color.CAM_X0108);
            d.a.p0.s.u.c d5 = d.a.p0.s.u.c.d(searchSuggestForumViewHolder.f18509f);
            d5.x(R.dimen.T_X09);
            d5.t(R.color.CAM_X0108);
            SkinManager.setBackgroundResource(searchSuggestForumViewHolder.f18504a, R.drawable.addresslist_item_bg);
            d.a.p0.s.u.c.d(searchSuggestForumViewHolder.f18510g).f(R.color.CAM_X0203);
        }
    }

    public final void l0(d.a.q0.s1.h.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_FORUM_SHOW);
            f0(statisticItem, bVar);
            TiebaStatic.log(statisticItem);
        }
    }
}
