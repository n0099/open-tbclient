package j.a.a.e.o.e;

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
import j.a.a.e.d;
import j.a.a.e.e;
import j.a.a.e.l.f;
import j.a.a.e.n.l;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f64222e;

    /* renamed from: f  reason: collision with root package name */
    public int f64223f;

    /* renamed from: g  reason: collision with root package name */
    public List<f> f64224g;

    /* renamed from: h  reason: collision with root package name */
    public PayUIKitConfig f64225h;

    /* loaded from: classes3.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f64226b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f64227c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f64228d;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
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

    public c(Context context, PayUIKitConfig payUIKitConfig, List<f> list) {
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
        this.f64224g = new ArrayList();
        this.f64222e = context;
        this.f64224g = list;
        this.f64225h = payUIKitConfig;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public f getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f64224g.get(i2) : (f) invokeI.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64223f : invokeV.intValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f64223f = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f64224g.size() : invokeV.intValue;
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
                view = LayoutInflater.from(this.f64222e).inflate(e.pay_ui_item_pay_way_choose, viewGroup, false);
                aVar = new a(this);
                aVar.a = (TextView) view.findViewById(d.way_tv_title);
                aVar.f64227c = (ImageView) view.findViewById(d.img_select);
                aVar.f64226b = (ImageView) view.findViewById(d.recharge_way_bg);
                aVar.f64228d = (TextView) view.findViewById(d.tv_tips);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            f item = getItem(i2);
            aVar.a.setText(item.a());
            PayType payType = item.a;
            if (PayType.ALI_PAY.equals(payType)) {
                aVar.f64226b.setBackgroundResource(j.a.a.e.c.pay_ui_pay_channel_zhifubao_icon);
            } else if (PayType.WECHAT_PAY.equals(payType)) {
                aVar.f64226b.setBackgroundResource(j.a.a.e.c.pay_ui_pay_channel_weixin_icon);
            } else if (PayType.DXM_PAY.equals(payType)) {
                aVar.f64226b.setBackgroundResource(j.a.a.e.c.pay_ui_pay_channel_dxm_icon);
            } else if (PayType.DXM_PAY_KJ.equals(payType)) {
                aVar.f64226b.setBackgroundResource(j.a.a.e.c.pay_ui_pay_channel_dxmkj_icon);
            } else if (PayType.UNION_PAY.equals(payType)) {
                aVar.f64226b.setBackgroundResource(j.a.a.e.c.pay_ui_pay_channel_unionpay_icon);
            } else if (PayType.QQ_PAY.equals(payType)) {
                aVar.f64226b.setBackgroundResource(j.a.a.e.c.pay_ui_pay_channel_qqpay_icon);
            }
            aVar.a.setTextColor(this.f64222e.getResources().getColor(j.a.a.e.a.pay_ui_font_color_6));
            if (this.f64223f == i2) {
                aVar.f64227c.setBackgroundResource(l.a.b(this.f64225h) ? j.a.a.e.c.pay_ui_pay_way_item_select : j.a.a.e.c.pay_ui_pay_way_item_select_y);
            } else {
                aVar.f64227c.setBackgroundResource(j.a.a.e.c.pay_ui_pay_way_item_unselect);
            }
            if (TextUtils.isEmpty(item.f64201c)) {
                aVar.f64228d.setVisibility(8);
            } else {
                aVar.f64228d.setVisibility(0);
                aVar.f64228d.setText(item.f64201c);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
