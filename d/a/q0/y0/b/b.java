package d.a.q0.y0.b;

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
import d.a.p0.s.q.j0;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f66992e;

    /* renamed from: f  reason: collision with root package name */
    public List<j0> f66993f;

    /* renamed from: g  reason: collision with root package name */
    public int f66994g;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: d.a.q0.y0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1855b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f66995a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f66996b;

        /* renamed from: c  reason: collision with root package name */
        public View f66997c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f66998d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f66999e;

        public C1855b() {
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

        public /* synthetic */ C1855b(a aVar) {
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
        this.f66994g = -1;
        this.f66992e = context;
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
            return this.f66993f.get(i2);
        }
        return (j0) invokeI.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f66994g : invokeV.intValue;
    }

    public void c(List<j0> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f66993f = list;
            notifyDataSetChanged();
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f66994g = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<j0> list = this.f66993f;
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
        C1855b c1855b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view != null && view.getTag() != null) {
                c1855b = (C1855b) view.getTag();
            } else {
                view = LayoutInflater.from(this.f66992e).inflate(R.layout.gift_list_item, (ViewGroup) null);
                c1855b = new C1855b(null);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.image);
                c1855b.f66995a = tbImageView;
                tbImageView.setDefaultBgResource(R.drawable.transparent_bg);
                TbImageView tbImageView2 = (TbImageView) view.findViewById(R.id.mark_icon_iamge);
                c1855b.f66996b = tbImageView2;
                tbImageView2.setDefaultBgResource(R.drawable.transparent_bg);
                c1855b.f66996b.setDefaultResource(R.drawable.transparent_bg);
                c1855b.f66997c = view.findViewById(R.id.mask);
                c1855b.f66998d = (TextView) view.findViewById(R.id.name);
                c1855b.f66999e = (TextView) view.findViewById(R.id.price);
                view.setTag(c1855b);
            }
            SkinManager.setViewTextColor(c1855b.f66998d, R.color.CAM_X0105, 1);
            if (i2 == this.f66994g) {
                SkinManager.setBackgroundResource(c1855b.f66997c, R.drawable.chx_box_gift_s);
            } else {
                c1855b.f66997c.setBackgroundResource(R.color.common_color_10022);
            }
            j0 item = getItem(i2);
            if (item != null) {
                c1855b.f66998d.setText(item.f53361b);
                c1855b.f66995a.M(item.f53363d, 10, false);
                c1855b.f66996b.M(item.f53366g, 10, false);
                int i3 = item.f53365f;
                if (i3 == 5) {
                    c1855b.f66999e.setVisibility(8);
                } else if (i3 == 3) {
                    c1855b.f66999e.setVisibility(0);
                    c1855b.f66999e.setText(g.b(item.a(), false, item.s));
                } else {
                    c1855b.f66999e.setVisibility(0);
                    c1855b.f66999e.setText(g.b(item.b(), false, item.s));
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
