package d.a.p0.n3.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.BackgroundItemView;
import com.baidu.tieba.themeCenter.background.DressItemData;
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
    public List<Object> f60894e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f60895f;

    /* renamed from: g  reason: collision with root package name */
    public d f60896g;

    /* renamed from: d.a.p0.n3.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1574a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f60897a;

        /* renamed from: b  reason: collision with root package name */
        public BackgroundItemView f60898b;

        /* renamed from: c  reason: collision with root package name */
        public BackgroundItemView f60899c;

        /* renamed from: d  reason: collision with root package name */
        public BackgroundItemView f60900d;

        /* renamed from: e  reason: collision with root package name */
        public View f60901e;

        public C1574a() {
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

    public a(TbPageContext<?> tbPageContext, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60895f = tbPageContext;
        this.f60896g = dVar;
    }

    public void a(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f60894e = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<Object> list = this.f60894e;
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
            List<Object> list = this.f60894e;
            if (list == null || list.size() <= 0 || i2 < 0 || i2 >= this.f60894e.size()) {
                return null;
            }
            return this.f60894e.get(i2);
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
        C1574a c1574a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            Object item = getItem(i2);
            if (view != null) {
                c1574a = (C1574a) view.getTag();
            } else if (getItemViewType(i2) == 0) {
                view = LayoutInflater.from(this.f60895f.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
                c1574a = new C1574a();
                c1574a.f60897a = (TextView) view.findViewById(R.id.group_name);
                view.setTag(c1574a);
            } else {
                view = LayoutInflater.from(this.f60895f.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
                c1574a = new C1574a();
                c1574a.f60898b = (BackgroundItemView) view.findViewById(R.id.bg_view1);
                c1574a.f60899c = (BackgroundItemView) view.findViewById(R.id.bg_view2);
                c1574a.f60900d = (BackgroundItemView) view.findViewById(R.id.bg_view3);
                c1574a.f60901e = view.findViewById(R.id.divider_line);
                view.setTag(c1574a);
            }
            if (item != null) {
                if (getItemViewType(i2) == 0) {
                    c1574a.f60897a.setText(item.toString());
                } else {
                    List list = (List) item;
                    c1574a.f60898b.e((DressItemData) list.get(0));
                    c1574a.f60898b.setController(this.f60896g);
                    if (list.size() > 2) {
                        c1574a.f60899c.e((DressItemData) list.get(1));
                        c1574a.f60900d.e((DressItemData) list.get(2));
                        c1574a.f60899c.setController(this.f60896g);
                        c1574a.f60900d.setController(this.f60896g);
                    } else if (list.size() > 1) {
                        c1574a.f60899c.e((DressItemData) list.get(1));
                        c1574a.f60899c.setController(this.f60896g);
                        c1574a.f60900d.f();
                    } else {
                        c1574a.f60899c.f();
                        c1574a.f60900d.f();
                    }
                    if (getItem(i2 + 1) instanceof List) {
                        c1574a.f60901e.setVisibility(8);
                    } else {
                        c1574a.f60901e.setVisibility(0);
                    }
                }
            }
            this.f60895f.getLayoutMode().j(view);
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
