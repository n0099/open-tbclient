package i.a.a.e.o.b;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.a.a.e.d;
import i.a.a.e.e;
import i.a.a.e.n.f;
import i.a.a.e.n.g;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f73353e;

    /* renamed from: f  reason: collision with root package name */
    public int f73354f;

    /* renamed from: g  reason: collision with root package name */
    public List<i.a.a.e.l.a> f73355g;

    /* renamed from: h  reason: collision with root package name */
    public String f73356h;

    /* renamed from: i  reason: collision with root package name */
    public PayUIKitConfig f73357i;

    /* renamed from: i.a.a.e.o.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C2086a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f73358a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f73359b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f73360c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f73361d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f73362e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f73363f;

        public C2086a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
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

    public a(Context context, List<i.a.a.e.l.a> list, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, payUIKitConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73356h = "Y币";
        this.f73353e = context;
        this.f73355g = list;
        this.f73357i = payUIKitConfig;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public i.a.a.e.l.a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<i.a.a.e.l.a> list = this.f73355g;
            if (list == null || list.isEmpty() || i2 < 0 || i2 >= this.f73355g.size()) {
                return null;
            }
            return this.f73355g.get(i2);
        }
        return (i.a.a.e.l.a) invokeI.objValue;
    }

    public i.a.a.e.l.a b() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f73354f >= getCount() || (i2 = this.f73354f) < 0) {
                return null;
            }
            return getItem(i2);
        }
        return (i.a.a.e.l.a) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f73356h = str;
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f73354f = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f73355g.size() : invokeV.intValue;
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
        C2086a c2086a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(new ContextThemeWrapper(this.f73353e, g.f73351a.a(this.f73357i))).inflate(e.pay_ui_item_pay_amount_choose, (ViewGroup) null);
                c2086a = new C2086a(this);
                c2086a.f73358a = (TextView) view.findViewById(d.tv_dest_amount);
                c2086a.f73359b = (TextView) view.findViewById(d.tv_amount_unit);
                c2086a.f73360c = (LinearLayout) view.findViewById(d.amount_new_rl);
                c2086a.f73361d = (TextView) view.findViewById(d.amount_new);
                c2086a.f73362e = (LinearLayout) view.findViewById(d.ll_dest_amount_container);
                c2086a.f73363f = (TextView) view.findViewById(d.tv_other_amount);
                view.setTag(c2086a);
            } else {
                c2086a = (C2086a) view.getTag();
            }
            i.a.a.e.l.a item = getItem(i2);
            if (item.f73338c) {
                c2086a.f73363f.setVisibility(0);
                c2086a.f73362e.setVisibility(8);
                c2086a.f73361d.setVisibility(8);
            } else {
                c2086a.f73363f.setVisibility(8);
                c2086a.f73362e.setVisibility(0);
                c2086a.f73361d.setVisibility(0);
                c2086a.f73358a.setText(String.valueOf(item.a()));
                c2086a.f73359b.setText(this.f73356h);
                c2086a.f73361d.setVisibility(0);
                Double b2 = item.b();
                if (b2 == null) {
                    c2086a.f73361d.setText("");
                } else {
                    c2086a.f73361d.setText(String.format("¥%s", f.a(b2.doubleValue())));
                }
                if (this.f73354f == i2) {
                    c2086a.f73360c.setSelected(true);
                    c2086a.f73358a.setSelected(true);
                    c2086a.f73359b.setSelected(true);
                } else {
                    c2086a.f73360c.setSelected(false);
                    c2086a.f73358a.setSelected(false);
                    c2086a.f73359b.setSelected(false);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
