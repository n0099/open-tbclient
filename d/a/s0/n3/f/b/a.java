package d.a.s0.n3.f.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
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
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<Object> f64199e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f64200f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.s0.n3.f.a.a f64201g;

    /* renamed from: d.a.s0.n3.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1619a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f64202a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleItemView f64203b;

        /* renamed from: c  reason: collision with root package name */
        public BubbleItemView f64204c;

        /* renamed from: d  reason: collision with root package name */
        public View f64205d;

        public C1619a() {
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

    public a(TbPageContext<?> tbPageContext, d.a.s0.n3.f.a.a aVar) {
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
        this.f64200f = tbPageContext;
        this.f64201g = aVar;
    }

    public void a(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f64199e = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<Object> list = this.f64199e;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            List<Object> list = this.f64199e;
            if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f64199e.size()) {
                return null;
            }
            return this.f64199e.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (getItem(i2) != null) {
                return i2;
            }
            return -1L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? getItem(i2) instanceof List ? 1 : 0 : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1619a c1619a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            Object item = getItem(i2);
            if (view != null) {
                c1619a = (C1619a) view.getTag();
            } else if (getItemViewType(i2) == 0) {
                view = LayoutInflater.from(this.f64200f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
                c1619a = new C1619a();
                c1619a.f64202a = (TextView) view.findViewById(R.id.group_name);
                view.setTag(c1619a);
            } else {
                view = LayoutInflater.from(this.f64200f.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
                c1619a = new C1619a();
                c1619a.f64203b = (BubbleItemView) view.findViewById(R.id.bg_view1);
                c1619a.f64204c = (BubbleItemView) view.findViewById(R.id.bg_view2);
                c1619a.f64205d = view.findViewById(R.id.divider_line);
                view.setTag(c1619a);
            }
            if (item != null) {
                if (getItemViewType(i2) == 0) {
                    c1619a.f64202a.setText(item.toString());
                } else {
                    List list = (List) item;
                    c1619a.f64203b.d((DressItemData) list.get(0));
                    c1619a.f64203b.setController(this.f64201g);
                    c1619a.f64203b.setFromBubbleGroup(true);
                    if (list.size() > 1) {
                        c1619a.f64204c.d((DressItemData) list.get(1));
                        c1619a.f64204c.setController(this.f64201g);
                        c1619a.f64204c.setFromBubbleGroup(true);
                    } else {
                        c1619a.f64204c.e();
                    }
                    if (getItem(i2 + 1) instanceof List) {
                        c1619a.f64205d.setVisibility(8);
                    } else {
                        c1619a.f64205d.setVisibility(0);
                    }
                }
            }
            this.f64200f.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }
}
