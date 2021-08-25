package j.a.a.e.o.b;

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
import j.a.a.e.d;
import j.a.a.e.e;
import j.a.a.e.n.g;
import j.a.a.e.n.h;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f78938e;

    /* renamed from: f  reason: collision with root package name */
    public int f78939f;

    /* renamed from: g  reason: collision with root package name */
    public List<j.a.a.e.l.a> f78940g;

    /* renamed from: h  reason: collision with root package name */
    public String f78941h;

    /* renamed from: i  reason: collision with root package name */
    public PayUIKitConfig f78942i;

    /* renamed from: j.a.a.e.o.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C2147a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f78943a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f78944b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f78945c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f78946d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f78947e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f78948f;

        public C2147a(a aVar) {
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

    public a(Context context, List<j.a.a.e.l.a> list, PayUIKitConfig payUIKitConfig) {
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
        this.f78941h = "Y币";
        this.f78938e = context;
        this.f78940g = list;
        this.f78942i = payUIKitConfig;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public j.a.a.e.l.a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<j.a.a.e.l.a> list = this.f78940g;
            if (list == null || list.isEmpty() || i2 < 0 || i2 >= this.f78940g.size()) {
                return null;
            }
            return this.f78940g.get(i2);
        }
        return (j.a.a.e.l.a) invokeI.objValue;
    }

    public j.a.a.e.l.a b() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f78939f >= getCount() || (i2 = this.f78939f) < 0) {
                return null;
            }
            return getItem(i2);
        }
        return (j.a.a.e.l.a) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f78941h = str;
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f78939f = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f78940g.size() : invokeV.intValue;
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
        C2147a c2147a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(new ContextThemeWrapper(this.f78938e, h.f78936a.a(this.f78942i))).inflate(e.pay_ui_item_pay_amount_choose, (ViewGroup) null);
                c2147a = new C2147a(this);
                c2147a.f78943a = (TextView) view.findViewById(d.tv_dest_amount);
                c2147a.f78944b = (TextView) view.findViewById(d.tv_amount_unit);
                c2147a.f78945c = (LinearLayout) view.findViewById(d.amount_new_rl);
                c2147a.f78946d = (TextView) view.findViewById(d.amount_new);
                c2147a.f78947e = (LinearLayout) view.findViewById(d.ll_dest_amount_container);
                c2147a.f78948f = (TextView) view.findViewById(d.tv_other_amount);
                view.setTag(c2147a);
            } else {
                c2147a = (C2147a) view.getTag();
            }
            j.a.a.e.l.a item = getItem(i2);
            if (item.f78923c) {
                c2147a.f78948f.setVisibility(0);
                c2147a.f78947e.setVisibility(8);
                c2147a.f78946d.setVisibility(8);
            } else {
                c2147a.f78948f.setVisibility(8);
                c2147a.f78947e.setVisibility(0);
                c2147a.f78946d.setVisibility(0);
                c2147a.f78943a.setText(String.valueOf(item.a()));
                c2147a.f78944b.setText(this.f78941h);
                c2147a.f78946d.setVisibility(0);
                Double b2 = item.b();
                if (b2 == null) {
                    c2147a.f78946d.setText("");
                } else {
                    c2147a.f78946d.setText(String.format("¥%s", g.a(b2.doubleValue())));
                }
                if (this.f78939f == i2) {
                    c2147a.f78945c.setSelected(true);
                    c2147a.f78943a.setSelected(true);
                    c2147a.f78944b.setSelected(true);
                } else {
                    c2147a.f78945c.setSelected(false);
                    c2147a.f78943a.setSelected(false);
                    c2147a.f78944b.setSelected(false);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
