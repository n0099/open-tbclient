package i.a.a.e.o.e;

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
import i.a.a.e.d;
import i.a.a.e.e;
import i.a.a.e.f;
import i.a.a.e.n.k;
import i.a.a.e.n.l;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f73286e;

    /* renamed from: f  reason: collision with root package name */
    public int f73287f;

    /* renamed from: g  reason: collision with root package name */
    public List<i.a.a.e.l.c> f73288g;

    /* renamed from: h  reason: collision with root package name */
    public String f73289h;

    /* renamed from: i  reason: collision with root package name */
    public PayUIKitConfig f73290i;

    /* renamed from: i.a.a.e.o.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C2109a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f73291a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f73292b;

        /* renamed from: c  reason: collision with root package name */
        public View f73293c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f73294d;

        /* renamed from: e  reason: collision with root package name */
        public View f73295e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f73296f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f73297g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f73298h;

        public C2109a(a aVar) {
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

    public a(Context context, List<i.a.a.e.l.c> list, PayUIKitConfig payUIKitConfig) {
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
        this.f73289h = "Y币";
        this.f73286e = context;
        this.f73288g = list;
        this.f73290i = payUIKitConfig;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public i.a.a.e.l.c getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<i.a.a.e.l.c> list = this.f73288g;
            if (list == null || list.isEmpty() || i2 < 0 || i2 >= this.f73288g.size()) {
                return null;
            }
            return this.f73288g.get(i2);
        }
        return (i.a.a.e.l.c) invokeI.objValue;
    }

    public i.a.a.e.l.c b() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f73287f >= getCount() || (i2 = this.f73287f) < 0) {
                return null;
            }
            return getItem(i2);
        }
        return (i.a.a.e.l.c) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f73289h = str;
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f73287f = i2;
        }
    }

    public final void e(C2109a c2109a, i.a.a.e.l.c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, c2109a, cVar, i2) == null) {
            if (cVar.f73267c) {
                c2109a.f73296f.setVisibility(0);
                c2109a.f73295e.setVisibility(8);
                c2109a.f73294d.setVisibility(8);
                return;
            }
            c2109a.f73296f.setVisibility(8);
            c2109a.f73295e.setVisibility(0);
            c2109a.f73294d.setVisibility(0);
            c2109a.f73291a.setText(k.b(cVar.a()));
            c2109a.f73292b.setText(this.f73289h);
            c2109a.f73294d.setVisibility(0);
            Double valueOf = Double.valueOf(cVar.b());
            if (valueOf == null) {
                c2109a.f73294d.setText("");
            } else {
                c2109a.f73294d.setText(String.format(this.f73286e.getResources().getString(f.pay_ui_str_pay_amount_text_yuan), k.a(valueOf.doubleValue())));
            }
            if (this.f73287f == i2) {
                c2109a.f73293c.setSelected(true);
                c2109a.f73291a.setSelected(true);
                c2109a.f73292b.setSelected(true);
                return;
            }
            c2109a.f73293c.setSelected(false);
            c2109a.f73291a.setSelected(false);
            c2109a.f73292b.setSelected(false);
        }
    }

    public final void f(C2109a c2109a, i.a.a.e.l.c cVar) {
        List<GiftBagsInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, c2109a, cVar) == null) {
            ProductInfo productInfo = cVar.f73265a;
            if (productInfo != null && (list = productInfo.giftbags) != null && !list.isEmpty()) {
                String str = cVar.f73265a.giftbags.get(0).offersTips;
                if (TextUtils.isEmpty(str)) {
                    c2109a.f73297g.setVisibility(8);
                    return;
                }
                c2109a.f73297g.setVisibility(0);
                c2109a.f73297g.setText(str);
                return;
            }
            c2109a.f73297g.setVisibility(8);
        }
    }

    public final void g(C2109a c2109a, i.a.a.e.l.c cVar) {
        List<GiftBagTagInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, c2109a, cVar) == null) {
            ProductInfo productInfo = cVar.f73265a;
            if (productInfo != null && (list = productInfo.giftBagTagInfos) != null && !list.isEmpty()) {
                String str = cVar.f73265a.giftBagTagInfos.get(0).tag;
                if (TextUtils.isEmpty(str)) {
                    c2109a.f73298h.setVisibility(8);
                    return;
                }
                c2109a.f73298h.setVisibility(0);
                c2109a.f73298h.setText(str);
                return;
            }
            c2109a.f73298h.setVisibility(8);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f73288g.size() : invokeV.intValue;
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
        C2109a c2109a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(new ContextThemeWrapper(this.f73286e, l.f73284a.a(this.f73290i))).inflate(e.pay_ui_item_pay_amount_choose, (ViewGroup) null);
                c2109a = new C2109a(this);
                c2109a.f73291a = (TextView) view.findViewById(d.tv_dest_amount);
                c2109a.f73292b = (TextView) view.findViewById(d.tv_amount_unit);
                c2109a.f73293c = view.findViewById(d.amount_new_rl);
                c2109a.f73294d = (TextView) view.findViewById(d.amount_new);
                c2109a.f73295e = view.findViewById(d.ll_dest_amount_container);
                c2109a.f73296f = (TextView) view.findViewById(d.tv_other_amount);
                c2109a.f73297g = (TextView) view.findViewById(d.tvTips);
                c2109a.f73298h = (TextView) view.findViewById(d.tv_tag);
                view.setTag(c2109a);
            } else {
                c2109a = (C2109a) view.getTag();
            }
            i.a.a.e.l.c item = getItem(i2);
            e(c2109a, item, i2);
            f(c2109a, item);
            g(c2109a, item);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
