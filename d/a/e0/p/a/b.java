package d.a.e0.p.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.e0.f;
import d.a.e0.g;
import d.a.e0.p.a.a;
import java.util.List;
/* loaded from: classes7.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<a.C0594a> f42695e;

    /* renamed from: f  reason: collision with root package name */
    public Context f42696f;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f42697a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f42698b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f42699c;

        public a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42697a = (TextView) view.findViewById(f.coupon_title);
            this.f42698b = (TextView) view.findViewById(f.coupon_subtitle);
            this.f42699c = (ImageView) view.findViewById(f.select_icon);
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
        this.f42696f = context;
    }

    public void a(List<a.C0594a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f42695e = list;
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public a.C0594a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 < this.f42695e.size()) {
                return this.f42695e.get(i2);
            }
            return null;
        }
        return (a.C0594a) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<a.C0594a> list = this.f42695e;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            a.C0594a item = getItem(i2);
            if (item == null) {
                return view;
            }
            if (view == null) {
                view = LayoutInflater.from(this.f42696f).inflate(g.coupon_list_item, (ViewGroup) null, false);
                view.setTag(new a(view));
            }
            if (view.getTag() != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
                aVar.f42697a.setText(item.f42689c);
                if (TextUtils.isEmpty(item.f42690d)) {
                    aVar.f42698b.setVisibility(8);
                } else {
                    aVar.f42698b.setVisibility(0);
                    aVar.f42698b.setText(item.f42690d);
                }
                aVar.f42699c.setSelected(item.f42693g == 1);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
