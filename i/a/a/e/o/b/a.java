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
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f75865e;

    /* renamed from: f  reason: collision with root package name */
    public int f75866f;

    /* renamed from: g  reason: collision with root package name */
    public List<i.a.a.e.l.a> f75867g;

    /* renamed from: h  reason: collision with root package name */
    public String f75868h;

    /* renamed from: i  reason: collision with root package name */
    public PayUIKitConfig f75869i;

    /* renamed from: i.a.a.e.o.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C2119a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f75870a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f75871b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f75872c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f75873d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f75874e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f75875f;

        public C2119a(a aVar) {
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
        this.f75868h = "Y币";
        this.f75865e = context;
        this.f75867g = list;
        this.f75869i = payUIKitConfig;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public i.a.a.e.l.a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<i.a.a.e.l.a> list = this.f75867g;
            if (list == null || list.isEmpty() || i2 < 0 || i2 >= this.f75867g.size()) {
                return null;
            }
            return this.f75867g.get(i2);
        }
        return (i.a.a.e.l.a) invokeI.objValue;
    }

    public i.a.a.e.l.a b() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f75866f >= getCount() || (i2 = this.f75866f) < 0) {
                return null;
            }
            return getItem(i2);
        }
        return (i.a.a.e.l.a) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f75868h = str;
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f75866f = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f75867g.size() : invokeV.intValue;
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
        C2119a c2119a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(new ContextThemeWrapper(this.f75865e, g.f75863a.a(this.f75869i))).inflate(e.pay_ui_item_pay_amount_choose, (ViewGroup) null);
                c2119a = new C2119a(this);
                c2119a.f75870a = (TextView) view.findViewById(d.tv_dest_amount);
                c2119a.f75871b = (TextView) view.findViewById(d.tv_amount_unit);
                c2119a.f75872c = (LinearLayout) view.findViewById(d.amount_new_rl);
                c2119a.f75873d = (TextView) view.findViewById(d.amount_new);
                c2119a.f75874e = (LinearLayout) view.findViewById(d.ll_dest_amount_container);
                c2119a.f75875f = (TextView) view.findViewById(d.tv_other_amount);
                view.setTag(c2119a);
            } else {
                c2119a = (C2119a) view.getTag();
            }
            i.a.a.e.l.a item = getItem(i2);
            if (item.f75850c) {
                c2119a.f75875f.setVisibility(0);
                c2119a.f75874e.setVisibility(8);
                c2119a.f75873d.setVisibility(8);
            } else {
                c2119a.f75875f.setVisibility(8);
                c2119a.f75874e.setVisibility(0);
                c2119a.f75873d.setVisibility(0);
                c2119a.f75870a.setText(String.valueOf(item.a()));
                c2119a.f75871b.setText(this.f75868h);
                c2119a.f75873d.setVisibility(0);
                Double b2 = item.b();
                if (b2 == null) {
                    c2119a.f75873d.setText("");
                } else {
                    c2119a.f75873d.setText(String.format("¥%s", f.a(b2.doubleValue())));
                }
                if (this.f75866f == i2) {
                    c2119a.f75872c.setSelected(true);
                    c2119a.f75870a.setSelected(true);
                    c2119a.f75871b.setSelected(true);
                } else {
                    c2119a.f75872c.setSelected(false);
                    c2119a.f75870a.setSelected(false);
                    c2119a.f75871b.setSelected(false);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
