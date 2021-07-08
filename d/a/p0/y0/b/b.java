package d.a.p0.y0.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.q.j0;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f66314e;

    /* renamed from: f  reason: collision with root package name */
    public List<j0> f66315f;

    /* renamed from: g  reason: collision with root package name */
    public int f66316g;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: d.a.p0.y0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1850b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f66317a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f66318b;

        /* renamed from: c  reason: collision with root package name */
        public View f66319c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f66320d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f66321e;

        public C1850b() {
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

        public /* synthetic */ C1850b(a aVar) {
            this();
        }
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66316g = -1;
        this.f66314e = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public j0 getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 < 0 || i2 >= getCount()) {
                return null;
            }
            return this.f66315f.get(i2);
        }
        return (j0) invokeI.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f66316g : invokeV.intValue;
    }

    public void c(List<j0> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f66315f = list;
            notifyDataSetChanged();
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f66316g = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<j0> list = this.f66315f;
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1850b c1850b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view != null && view.getTag() != null) {
                c1850b = (C1850b) view.getTag();
            } else {
                view = LayoutInflater.from(this.f66314e).inflate(R.layout.gift_list_item, (ViewGroup) null);
                c1850b = new C1850b(null);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.image);
                c1850b.f66317a = tbImageView;
                tbImageView.setDefaultBgResource(R.drawable.transparent_bg);
                TbImageView tbImageView2 = (TbImageView) view.findViewById(R.id.mark_icon_iamge);
                c1850b.f66318b = tbImageView2;
                tbImageView2.setDefaultBgResource(R.drawable.transparent_bg);
                c1850b.f66318b.setDefaultResource(R.drawable.transparent_bg);
                c1850b.f66319c = view.findViewById(R.id.mask);
                c1850b.f66320d = (TextView) view.findViewById(R.id.name);
                c1850b.f66321e = (TextView) view.findViewById(R.id.price);
                view.setTag(c1850b);
            }
            SkinManager.setViewTextColor(c1850b.f66320d, R.color.CAM_X0105, 1);
            if (i2 == this.f66316g) {
                SkinManager.setBackgroundResource(c1850b.f66319c, R.drawable.chx_box_gift_s);
            } else {
                c1850b.f66319c.setBackgroundResource(R.color.common_color_10022);
            }
            j0 item = getItem(i2);
            if (item != null) {
                c1850b.f66320d.setText(item.f52697b);
                c1850b.f66317a.M(item.f52699d, 10, false);
                c1850b.f66318b.M(item.f52702g, 10, false);
                int i3 = item.f52701f;
                if (i3 == 5) {
                    c1850b.f66321e.setVisibility(8);
                } else if (i3 == 3) {
                    c1850b.f66321e.setVisibility(0);
                    c1850b.f66321e.setText(g.b(item.a(), false, item.s));
                } else {
                    c1850b.f66321e.setVisibility(0);
                    c1850b.f66321e.setText(g.b(item.b(), false, item.s));
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
