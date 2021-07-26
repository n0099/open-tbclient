package d.a.q0.s1.h.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.searchsuggestlist.viewholder.SearchSuggestCommonViewHolder;
import com.baidu.tieba.postsearch.PostSearchActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.d.k.e.w;
/* loaded from: classes8.dex */
public class a extends d.a.d.k.e.a<d.a.q0.s1.h.e.a, SearchSuggestCommonViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context m;

    /* renamed from: d.a.q0.s1.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1635a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f62756e;

        public C1635a(a aVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62756e = context;
        }

        @Override // d.a.d.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof d.a.q0.s1.h.e.a)) {
                d.a.q0.s1.h.e.a aVar = (d.a.q0.s1.h.e.a) nVar;
                String b2 = aVar.b();
                String c2 = aVar.c();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921595, c2));
                TiebaStatic.eventStat(this.f62756e, "search_bar_result_click", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", b2).param("obj_source", "2").param("obj_type", "1").param("obj_locate", i2 + 1).param("obj_param1", c2));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, BdUniqueId bdUniqueId) {
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
        a0(new C1635a(this, context));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.d.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, d.a.q0.s1.h.e.a aVar, SearchSuggestCommonViewHolder searchSuggestCommonViewHolder) {
        f0(i2, view, viewGroup, aVar, searchSuggestCommonViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: e0 */
    public SearchSuggestCommonViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new SearchSuggestCommonViewHolder(LayoutInflater.from(this.m).inflate(R.layout.search_suggest_common_item, viewGroup, false)) : (SearchSuggestCommonViewHolder) invokeL.objValue;
    }

    public View f0(int i2, View view, ViewGroup viewGroup, d.a.q0.s1.h.e.a aVar, SearchSuggestCommonViewHolder searchSuggestCommonViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, searchSuggestCommonViewHolder})) == null) {
            if (aVar == null) {
                return view;
            }
            g0(searchSuggestCommonViewHolder);
            WebPManager.setPureDrawable(searchSuggestCommonViewHolder.f18502c, R.drawable.icon_search_scan, R.color.CAM_X0109, null);
            d.a.q0.s1.h.c.a(searchSuggestCommonViewHolder.f18501b, aVar.c(), aVar.b());
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void g0(SearchSuggestCommonViewHolder searchSuggestCommonViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, searchSuggestCommonViewHolder) == null) {
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(searchSuggestCommonViewHolder.f18501b);
            d2.t(R.color.CAM_X0105);
            d2.x(R.dimen.T_X06);
            SkinManager.setBackgroundResource(searchSuggestCommonViewHolder.f18500a, R.drawable.addresslist_item_bg);
            d.a.p0.s.u.c.d(searchSuggestCommonViewHolder.f18503d).f(R.color.CAM_X0203);
        }
    }
}
