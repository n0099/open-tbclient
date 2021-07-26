package d.a.q0.n3.f.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.all.BubbleItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<List<DressItemData>> f61598e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f61599f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.n3.f.a.a f61600g;

    /* renamed from: d.a.q0.n3.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1581a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f61601a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleItemView f61602b;

        /* renamed from: c  reason: collision with root package name */
        public BubbleItemView f61603c;

        public C1581a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public a(TbPageContext<?> tbPageContext, d.a.q0.n3.f.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61599f = tbPageContext;
        this.f61600g = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public List<DressItemData> getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<List<DressItemData>> list = this.f61598e;
            if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f61598e.size()) {
                return null;
            }
            return this.f61598e.get(i2);
        }
        return (List) invokeI.objValue;
    }

    public void b(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f61598e = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<List<DressItemData>> list = this.f61598e;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1581a c1581a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            List<DressItemData> item = getItem(i2);
            if (view != null) {
                c1581a = (C1581a) view.getTag();
            } else {
                view = LayoutInflater.from(this.f61599f.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
                c1581a = new C1581a();
                c1581a.f61601a = view.findViewById(R.id.top_white_line);
                c1581a.f61602b = (BubbleItemView) view.findViewById(R.id.bg_view1);
                c1581a.f61603c = (BubbleItemView) view.findViewById(R.id.bg_view2);
                view.setTag(c1581a);
            }
            if (item != null) {
                if (i2 == 0) {
                    c1581a.f61601a.setVisibility(0);
                } else {
                    c1581a.f61601a.setVisibility(8);
                }
                c1581a.f61602b.d(item.get(0));
                c1581a.f61602b.setController(this.f61600g);
                c1581a.f61602b.setFromBubbleGroup(false);
                if (item.size() > 1) {
                    c1581a.f61603c.d(item.get(1));
                    c1581a.f61603c.setController(this.f61600g);
                    c1581a.f61603c.setFromBubbleGroup(false);
                } else {
                    c1581a.f61603c.e();
                }
            }
            this.f61599f.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
