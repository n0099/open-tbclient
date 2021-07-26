package i.a.a.e.o.b;

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
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import i.a.a.e.d;
import i.a.a.e.e;
import i.a.a.e.l.c;
import i.a.a.e.n.g;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f73364e;

    /* renamed from: f  reason: collision with root package name */
    public int f73365f;

    /* renamed from: g  reason: collision with root package name */
    public List<c> f73366g;

    /* renamed from: h  reason: collision with root package name */
    public PayUIKitConfig f73367h;

    /* loaded from: classes9.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f73368a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f73369b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f73370c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f73371d;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
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

    public b(Context context, PayUIKitConfig payUIKitConfig, List<c> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, payUIKitConfig, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73366g = new ArrayList();
        this.f73364e = context;
        this.f73366g = list;
        this.f73367h = payUIKitConfig;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public c getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f73366g.get(i2) : (c) invokeI.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f73365f : invokeV.intValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f73365f = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f73366g.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f73364e).inflate(e.pay_ui_item_pay_way_choose, viewGroup, false);
                aVar = new a(this);
                aVar.f73368a = (TextView) view.findViewById(d.way_tv_title);
                aVar.f73370c = (ImageView) view.findViewById(d.img_select);
                aVar.f73369b = (ImageView) view.findViewById(d.recharge_way_bg);
                aVar.f73371d = (TextView) view.findViewById(d.tv_tips);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            c item = getItem(i2);
            aVar.f73368a.setText(item.a());
            PayType payType = item.f73343a;
            if (PayType.ALI_PAY.equals(payType)) {
                aVar.f73369b.setBackgroundResource(i.a.a.e.c.pay_ui_recharge_zhifubao);
            } else if (PayType.WECHAT_PAY.equals(payType)) {
                aVar.f73369b.setBackgroundResource(i.a.a.e.c.pay_ui_recharge_weixin);
            } else if (PayType.DXM_PAY.equals(payType)) {
                aVar.f73369b.setBackgroundResource(i.a.a.e.c.pay_ui_recharge_dxm);
            } else if (PayType.DXM_PAY_KJ.equals(payType)) {
                aVar.f73369b.setBackgroundResource(i.a.a.e.c.pay_ui_recharge_dxmkj);
            }
            aVar.f73368a.setTextColor(this.f73364e.getResources().getColor(i.a.a.e.a.pay_ui_font_color_6));
            if (this.f73365f == i2) {
                aVar.f73370c.setBackgroundResource(g.f73351a.b(this.f73367h) ? i.a.a.e.c.pay_ui_pay_way_item_select : i.a.a.e.c.pay_ui_pay_way_item_select_y);
            } else {
                aVar.f73370c.setBackgroundResource(i.a.a.e.c.pay_ui_pay_way_item_unselect);
            }
            if (TextUtils.isEmpty(item.f73345c)) {
                aVar.f73371d.setVisibility(8);
            } else {
                aVar.f73371d.setVisibility(0);
                aVar.f73371d.setText(item.f73345c);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
