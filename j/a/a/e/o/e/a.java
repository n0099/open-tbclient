package j.a.a.e.o.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagTagInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import j.a.a.e.d;
import j.a.a.e.e;
import j.a.a.e.f;
import j.a.a.e.n.k;
import j.a.a.e.n.l;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f64205e;

    /* renamed from: f  reason: collision with root package name */
    public int f64206f;

    /* renamed from: g  reason: collision with root package name */
    public List<j.a.a.e.l.c> f64207g;

    /* renamed from: h  reason: collision with root package name */
    public String f64208h;

    /* renamed from: i  reason: collision with root package name */
    public PayUIKitConfig f64209i;

    /* renamed from: j.a.a.e.o.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C2223a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f64210b;

        /* renamed from: c  reason: collision with root package name */
        public View f64211c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f64212d;

        /* renamed from: e  reason: collision with root package name */
        public View f64213e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f64214f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f64215g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f64216h;

        public C2223a(a aVar) {
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

    public a(Context context, List<j.a.a.e.l.c> list, PayUIKitConfig payUIKitConfig) {
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
        this.f64208h = "Y币";
        this.f64205e = context;
        this.f64207g = list;
        this.f64209i = payUIKitConfig;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public j.a.a.e.l.c getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<j.a.a.e.l.c> list = this.f64207g;
            if (list == null || list.isEmpty() || i2 < 0 || i2 >= this.f64207g.size()) {
                return null;
            }
            return this.f64207g.get(i2);
        }
        return (j.a.a.e.l.c) invokeI.objValue;
    }

    public j.a.a.e.l.c b() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f64206f >= getCount() || (i2 = this.f64206f) < 0) {
                return null;
            }
            return getItem(i2);
        }
        return (j.a.a.e.l.c) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f64208h = str;
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f64206f = i2;
        }
    }

    public final void e(C2223a c2223a, j.a.a.e.l.c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, c2223a, cVar, i2) == null) {
            if (cVar.f64196c) {
                c2223a.f64214f.setVisibility(0);
                c2223a.f64213e.setVisibility(8);
                c2223a.f64212d.setVisibility(8);
                return;
            }
            c2223a.f64214f.setVisibility(8);
            c2223a.f64213e.setVisibility(0);
            c2223a.f64212d.setVisibility(0);
            c2223a.a.setText(k.b(cVar.a()));
            c2223a.f64210b.setText(this.f64208h);
            c2223a.f64212d.setVisibility(0);
            Double valueOf = Double.valueOf(cVar.b());
            if (valueOf == null) {
                c2223a.f64212d.setText("");
            } else {
                c2223a.f64212d.setText(String.format(this.f64205e.getResources().getString(f.pay_ui_str_pay_amount_text_yuan), k.a(valueOf.doubleValue())));
            }
            if (this.f64206f == i2) {
                c2223a.f64211c.setSelected(true);
                c2223a.a.setSelected(true);
                c2223a.f64210b.setSelected(true);
                return;
            }
            c2223a.f64211c.setSelected(false);
            c2223a.a.setSelected(false);
            c2223a.f64210b.setSelected(false);
        }
    }

    public final void f(C2223a c2223a, j.a.a.e.l.c cVar) {
        List<GiftBagsInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, c2223a, cVar) == null) {
            ProductInfo productInfo = cVar.a;
            if (productInfo != null && (list = productInfo.giftbags) != null && !list.isEmpty()) {
                String str = cVar.a.giftbags.get(0).offersTips;
                if (TextUtils.isEmpty(str)) {
                    c2223a.f64215g.setVisibility(8);
                    return;
                }
                c2223a.f64215g.setVisibility(0);
                c2223a.f64215g.setText(str);
                return;
            }
            c2223a.f64215g.setVisibility(8);
        }
    }

    public final void g(C2223a c2223a, j.a.a.e.l.c cVar) {
        List<GiftBagTagInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, c2223a, cVar) == null) {
            ProductInfo productInfo = cVar.a;
            if (productInfo != null && (list = productInfo.giftBagTagInfos) != null && !list.isEmpty()) {
                String str = cVar.a.giftBagTagInfos.get(0).tag;
                if (TextUtils.isEmpty(str)) {
                    c2223a.f64216h.setVisibility(8);
                    return;
                }
                c2223a.f64216h.setVisibility(0);
                c2223a.f64216h.setText(str);
                return;
            }
            c2223a.f64216h.setVisibility(8);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f64207g.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C2223a c2223a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(new ContextThemeWrapper(this.f64205e, l.a.a(this.f64209i))).inflate(e.pay_ui_item_pay_amount_choose, (ViewGroup) null);
                c2223a = new C2223a(this);
                c2223a.a = (TextView) view.findViewById(d.tv_dest_amount);
                c2223a.f64210b = (TextView) view.findViewById(d.tv_amount_unit);
                c2223a.f64211c = view.findViewById(d.amount_new_rl);
                c2223a.f64212d = (TextView) view.findViewById(d.amount_new);
                c2223a.f64213e = view.findViewById(d.ll_dest_amount_container);
                c2223a.f64214f = (TextView) view.findViewById(d.tv_other_amount);
                c2223a.f64215g = (TextView) view.findViewById(d.tvTips);
                c2223a.f64216h = (TextView) view.findViewById(d.tv_tag);
                view.setTag(c2223a);
            } else {
                c2223a = (C2223a) view.getTag();
            }
            j.a.a.e.l.c item = getItem(i2);
            e(c2223a, item, i2);
            f(c2223a, item);
            g(c2223a, item);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
