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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f72899e;

    /* renamed from: f  reason: collision with root package name */
    public int f72900f;

    /* renamed from: g  reason: collision with root package name */
    public List<i.a.a.e.l.a> f72901g;

    /* renamed from: h  reason: collision with root package name */
    public String f72902h;

    /* renamed from: i  reason: collision with root package name */
    public PayUIKitConfig f72903i;

    /* renamed from: i.a.a.e.o.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C2087a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f72904a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f72905b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f72906c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f72907d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f72908e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f72909f;

        public C2087a(a aVar) {
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
        this.f72902h = "Y币";
        this.f72899e = context;
        this.f72901g = list;
        this.f72903i = payUIKitConfig;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public i.a.a.e.l.a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<i.a.a.e.l.a> list = this.f72901g;
            if (list == null || list.isEmpty() || i2 < 0 || i2 >= this.f72901g.size()) {
                return null;
            }
            return this.f72901g.get(i2);
        }
        return (i.a.a.e.l.a) invokeI.objValue;
    }

    public i.a.a.e.l.a b() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f72900f >= getCount() || (i2 = this.f72900f) < 0) {
                return null;
            }
            return getItem(i2);
        }
        return (i.a.a.e.l.a) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f72902h = str;
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f72900f = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f72901g.size() : invokeV.intValue;
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
        C2087a c2087a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(new ContextThemeWrapper(this.f72899e, g.f72897a.a(this.f72903i))).inflate(e.pay_ui_item_pay_amount_choose, (ViewGroup) null);
                c2087a = new C2087a(this);
                c2087a.f72904a = (TextView) view.findViewById(d.tv_dest_amount);
                c2087a.f72905b = (TextView) view.findViewById(d.tv_amount_unit);
                c2087a.f72906c = (LinearLayout) view.findViewById(d.amount_new_rl);
                c2087a.f72907d = (TextView) view.findViewById(d.amount_new);
                c2087a.f72908e = (LinearLayout) view.findViewById(d.ll_dest_amount_container);
                c2087a.f72909f = (TextView) view.findViewById(d.tv_other_amount);
                view.setTag(c2087a);
            } else {
                c2087a = (C2087a) view.getTag();
            }
            i.a.a.e.l.a item = getItem(i2);
            if (item.f72884c) {
                c2087a.f72909f.setVisibility(0);
                c2087a.f72908e.setVisibility(8);
                c2087a.f72907d.setVisibility(8);
            } else {
                c2087a.f72909f.setVisibility(8);
                c2087a.f72908e.setVisibility(0);
                c2087a.f72907d.setVisibility(0);
                c2087a.f72904a.setText(String.valueOf(item.a()));
                c2087a.f72905b.setText(this.f72902h);
                c2087a.f72907d.setVisibility(0);
                Double b2 = item.b();
                if (b2 == null) {
                    c2087a.f72907d.setText("");
                } else {
                    c2087a.f72907d.setText(String.format("¥%s", f.a(b2.doubleValue())));
                }
                if (this.f72900f == i2) {
                    c2087a.f72906c.setSelected(true);
                    c2087a.f72904a.setSelected(true);
                    c2087a.f72905b.setSelected(true);
                } else {
                    c2087a.f72906c.setSelected(false);
                    c2087a.f72904a.setSelected(false);
                    c2087a.f72905b.setSelected(false);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
