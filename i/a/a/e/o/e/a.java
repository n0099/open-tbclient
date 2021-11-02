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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f72368e;

    /* renamed from: f  reason: collision with root package name */
    public int f72369f;

    /* renamed from: g  reason: collision with root package name */
    public List<i.a.a.e.l.c> f72370g;

    /* renamed from: h  reason: collision with root package name */
    public String f72371h;

    /* renamed from: i  reason: collision with root package name */
    public PayUIKitConfig f72372i;

    /* renamed from: i.a.a.e.o.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C2073a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f72373a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f72374b;

        /* renamed from: c  reason: collision with root package name */
        public View f72375c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f72376d;

        /* renamed from: e  reason: collision with root package name */
        public View f72377e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f72378f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f72379g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f72380h;

        public C2073a(a aVar) {
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
        this.f72371h = "Y币";
        this.f72368e = context;
        this.f72370g = list;
        this.f72372i = payUIKitConfig;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public i.a.a.e.l.c getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<i.a.a.e.l.c> list = this.f72370g;
            if (list == null || list.isEmpty() || i2 < 0 || i2 >= this.f72370g.size()) {
                return null;
            }
            return this.f72370g.get(i2);
        }
        return (i.a.a.e.l.c) invokeI.objValue;
    }

    public i.a.a.e.l.c b() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f72369f >= getCount() || (i2 = this.f72369f) < 0) {
                return null;
            }
            return getItem(i2);
        }
        return (i.a.a.e.l.c) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f72371h = str;
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f72369f = i2;
        }
    }

    public final void e(C2073a c2073a, i.a.a.e.l.c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, c2073a, cVar, i2) == null) {
            if (cVar.f72349c) {
                c2073a.f72378f.setVisibility(0);
                c2073a.f72377e.setVisibility(8);
                c2073a.f72376d.setVisibility(8);
                return;
            }
            c2073a.f72378f.setVisibility(8);
            c2073a.f72377e.setVisibility(0);
            c2073a.f72376d.setVisibility(0);
            c2073a.f72373a.setText(k.b(cVar.a()));
            c2073a.f72374b.setText(this.f72371h);
            c2073a.f72376d.setVisibility(0);
            Double valueOf = Double.valueOf(cVar.b());
            if (valueOf == null) {
                c2073a.f72376d.setText("");
            } else {
                c2073a.f72376d.setText(String.format(this.f72368e.getResources().getString(f.pay_ui_str_pay_amount_text_yuan), k.a(valueOf.doubleValue())));
            }
            if (this.f72369f == i2) {
                c2073a.f72375c.setSelected(true);
                c2073a.f72373a.setSelected(true);
                c2073a.f72374b.setSelected(true);
                return;
            }
            c2073a.f72375c.setSelected(false);
            c2073a.f72373a.setSelected(false);
            c2073a.f72374b.setSelected(false);
        }
    }

    public final void f(C2073a c2073a, i.a.a.e.l.c cVar) {
        List<GiftBagsInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, c2073a, cVar) == null) {
            ProductInfo productInfo = cVar.f72347a;
            if (productInfo != null && (list = productInfo.giftbags) != null && !list.isEmpty()) {
                String str = cVar.f72347a.giftbags.get(0).offersTips;
                if (TextUtils.isEmpty(str)) {
                    c2073a.f72379g.setVisibility(8);
                    return;
                }
                c2073a.f72379g.setVisibility(0);
                c2073a.f72379g.setText(str);
                return;
            }
            c2073a.f72379g.setVisibility(8);
        }
    }

    public final void g(C2073a c2073a, i.a.a.e.l.c cVar) {
        List<GiftBagTagInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, c2073a, cVar) == null) {
            ProductInfo productInfo = cVar.f72347a;
            if (productInfo != null && (list = productInfo.giftBagTagInfos) != null && !list.isEmpty()) {
                String str = cVar.f72347a.giftBagTagInfos.get(0).tag;
                if (TextUtils.isEmpty(str)) {
                    c2073a.f72380h.setVisibility(8);
                    return;
                }
                c2073a.f72380h.setVisibility(0);
                c2073a.f72380h.setText(str);
                return;
            }
            c2073a.f72380h.setVisibility(8);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f72370g.size() : invokeV.intValue;
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
        C2073a c2073a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(new ContextThemeWrapper(this.f72368e, l.f72366a.a(this.f72372i))).inflate(e.pay_ui_item_pay_amount_choose, (ViewGroup) null);
                c2073a = new C2073a(this);
                c2073a.f72373a = (TextView) view.findViewById(d.tv_dest_amount);
                c2073a.f72374b = (TextView) view.findViewById(d.tv_amount_unit);
                c2073a.f72375c = view.findViewById(d.amount_new_rl);
                c2073a.f72376d = (TextView) view.findViewById(d.amount_new);
                c2073a.f72377e = view.findViewById(d.ll_dest_amount_container);
                c2073a.f72378f = (TextView) view.findViewById(d.tv_other_amount);
                c2073a.f72379g = (TextView) view.findViewById(d.tvTips);
                c2073a.f72380h = (TextView) view.findViewById(d.tv_tag);
                view.setTag(c2073a);
            } else {
                c2073a = (C2073a) view.getTag();
            }
            i.a.a.e.l.c item = getItem(i2);
            e(c2073a, item, i2);
            f(c2073a, item);
            g(c2073a, item);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
