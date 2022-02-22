package j.a.a.e.q.e;

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
import j.a.a.e.c;
import j.a.a.e.e;
import j.a.a.e.g;
import j.a.a.e.n.f;
import j.a.a.e.p.o;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes5.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f62571e;

    /* renamed from: f  reason: collision with root package name */
    public int f62572f;

    /* renamed from: g  reason: collision with root package name */
    public List<f> f62573g;

    /* renamed from: h  reason: collision with root package name */
    public PayUIKitConfig f62574h;

    /* loaded from: classes5.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f62575b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f62576c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f62577d;

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

    public b(Context context, PayUIKitConfig payUIKitConfig, List<f> list) {
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
        this.f62573g = new ArrayList();
        this.f62571e = context;
        this.f62573g = list;
        this.f62574h = payUIKitConfig;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public f getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f62573g.get(i2) : (f) invokeI.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f62572f : invokeV.intValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f62572f = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f62573g.size() : invokeV.intValue;
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
                view = LayoutInflater.from(this.f62571e).inflate(g.pay_ui_item_pay_way_choose, viewGroup, false);
                aVar = new a(this);
                aVar.a = (TextView) view.findViewById(j.a.a.e.f.way_tv_title);
                aVar.f62576c = (ImageView) view.findViewById(j.a.a.e.f.img_select);
                aVar.f62575b = (ImageView) view.findViewById(j.a.a.e.f.recharge_way_bg);
                aVar.f62577d = (TextView) view.findViewById(j.a.a.e.f.tv_tips);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            f item = getItem(i2);
            aVar.a.setText(item.a());
            PayType payType = item.a;
            if (PayType.ALI_PAY.equals(payType)) {
                aVar.f62575b.setBackgroundResource(e.pay_ui_pay_channel_zhifubao_icon);
            } else if (PayType.WECHAT_PAY.equals(payType)) {
                aVar.f62575b.setBackgroundResource(e.pay_ui_pay_channel_weixin_icon);
            } else if (PayType.DXM_PAY.equals(payType)) {
                aVar.f62575b.setBackgroundResource(e.pay_ui_pay_channel_dxm_icon);
            } else if (PayType.DXM_PAY_KJ.equals(payType)) {
                aVar.f62575b.setBackgroundResource(e.pay_ui_pay_channel_dxmkj_icon);
            } else if (PayType.UNION_PAY.equals(payType)) {
                aVar.f62575b.setBackgroundResource(e.pay_ui_pay_channel_unionpay_icon);
            } else if (PayType.QQ_PAY.equals(payType)) {
                aVar.f62575b.setBackgroundResource(e.pay_ui_pay_channel_qqpay_icon);
            }
            aVar.a.setTextColor(this.f62571e.getResources().getColor(c.pay_ui_font_color_6));
            if (this.f62572f == i2) {
                aVar.f62576c.setBackgroundResource(o.a.b(this.f62574h) ? e.pay_ui_pay_way_item_select : e.pay_ui_pay_way_item_select_y);
            } else {
                aVar.f62576c.setBackgroundResource(e.pay_ui_pay_way_item_unselect);
            }
            if (TextUtils.isEmpty(item.f62561c)) {
                aVar.f62577d.setVisibility(8);
            } else {
                aVar.f62577d.setVisibility(0);
                aVar.f62577d.setText(item.f62561c);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
