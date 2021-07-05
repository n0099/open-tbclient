package d.a.s0.i1.f.j;

import android.util.LongSparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.chat.MsgCommonItemAdapter;
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.i1.l.c.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class f extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<OfficialBarFeedActivity> f61585e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.s0.i1.l.c.b> f61586f;

    /* renamed from: g  reason: collision with root package name */
    public LongSparseArray<d.a.s0.i1.i.a.b.b> f61587g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialBarFeedMsglistAdapter.c f61588h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeListView f61589i;
    public boolean j;

    /* loaded from: classes9.dex */
    public class a extends MsgCommonItemAdapter.MsgViewHolder<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, View view, b bVar) {
            super(view, bVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, view, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((View) objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public f(TbPageContext<OfficialBarFeedActivity> tbPageContext, BdTypeListView bdTypeListView, OfficialBarFeedMsglistAdapter.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61586f = null;
        this.f61587g = null;
        this.f61585e = tbPageContext;
        this.f61588h = cVar;
        this.f61589i = bdTypeListView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.a.s0.i1.l.c.b getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<d.a.s0.i1.l.c.b> list = this.f61586f;
            if (list == null || list.size() == 0 || i2 < 0 || i2 >= getCount()) {
                return null;
            }
            return this.f61586f.get(i2);
        }
        return (d.a.s0.i1.l.c.b) invokeI.objValue;
    }

    public final View b(int i2, View view, ViewGroup viewGroup, d.a.s0.i1.l.c.b bVar, MsgCommonItemAdapter.MsgViewHolder<b> msgViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, msgViewHolder})) == null) {
            b b2 = msgViewHolder.b();
            a.C1512a e2 = bVar.e();
            e2.m = bVar.c();
            LongSparseArray<d.a.s0.i1.i.a.b.b> longSparseArray = this.f61587g;
            b2.k(this.f61585e.getPageActivity().getBaseContext(), e2, bVar.d(), longSparseArray == null ? null : longSparseArray.get(e2.f61771h), bVar.f(), bVar.g(), i2);
            StatisticItem statisticItem = new StatisticItem(this.j ? "c13865" : "c13863");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            String str = e2.n;
            if (str == null) {
                str = "";
            }
            statisticItem.param("tid", str);
            statisticItem.param("fid", e2.f61768e);
            TiebaStatic.log(statisticItem);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void c(List<d.a.s0.i1.l.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            if (this.f61586f == null) {
                this.f61586f = new LinkedList();
            }
            this.f61586f.clear();
            this.f61586f.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.j = z;
        }
    }

    @RequiresApi(api = 16)
    public void e(LongSparseArray<d.a.s0.i1.i.a.b.b> longSparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, longSparseArray) == null) {
            if (this.f61587g == null) {
                this.f61587g = new LongSparseArray<>();
            }
            this.f61587g.clear();
            for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
                this.f61587g.put(longSparseArray.keyAt(i2), longSparseArray.valueAt(i2));
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<d.a.s0.i1.l.c.b> list = this.f61586f;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            a aVar2 = view != null ? (a) view.getTag() : null;
            if (aVar2 == null) {
                b bVar = new b(this.f61585e, this.j);
                bVar.l(this.f61588h);
                View e2 = bVar.e();
                a aVar3 = new a(this, bVar.e(), bVar);
                e2.setTag(aVar3);
                view = e2;
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            b(i2, view, viewGroup, getItem(i2), aVar);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
