package j.a.a.e.o.b;

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
import j.a.a.e.l.c;
import j.a.a.e.n.h;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f79541e;

    /* renamed from: f  reason: collision with root package name */
    public int f79542f;

    /* renamed from: g  reason: collision with root package name */
    public List<c> f79543g;

    /* renamed from: h  reason: collision with root package name */
    public PayUIKitConfig f79544h;

    /* loaded from: classes2.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f79545a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f79546b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f79547c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f79548d;

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
        this.f79543g = new ArrayList();
        this.f79541e = context;
        this.f79543g = list;
        this.f79544h = payUIKitConfig;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public c getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f79543g.get(i2) : (c) invokeI.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f79542f : invokeV.intValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f79542f = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f79543g.size() : invokeV.intValue;
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
                view = LayoutInflater.from(this.f79541e).inflate(e.pay_ui_item_pay_way_choose, viewGroup, false);
                aVar = new a(this);
                aVar.f79545a = (TextView) view.findViewById(d.way_tv_title);
                aVar.f79547c = (ImageView) view.findViewById(d.img_select);
                aVar.f79546b = (ImageView) view.findViewById(d.recharge_way_bg);
                aVar.f79548d = (TextView) view.findViewById(d.tv_tips);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            c item = getItem(i2);
            aVar.f79545a.setText(item.a());
            PayType payType = item.f79520a;
            if (PayType.ALI_PAY.equals(payType)) {
                aVar.f79546b.setBackgroundResource(j.a.a.e.c.pay_ui_recharge_zhifubao);
            } else if (PayType.WECHAT_PAY.equals(payType)) {
                aVar.f79546b.setBackgroundResource(j.a.a.e.c.pay_ui_recharge_weixin);
            } else if (PayType.DXM_PAY.equals(payType)) {
                aVar.f79546b.setBackgroundResource(j.a.a.e.c.pay_ui_recharge_dxm);
            } else if (PayType.DXM_PAY_KJ.equals(payType)) {
                aVar.f79546b.setBackgroundResource(j.a.a.e.c.pay_ui_recharge_dxmkj);
            } else if (PayType.UNION_PAY.equals(payType)) {
                aVar.f79546b.setBackgroundResource(j.a.a.e.c.pay_ui_recharge_unionpay);
            } else if (PayType.QQ_PAY.equals(payType)) {
                aVar.f79546b.setBackgroundResource(j.a.a.e.c.pay_ui_recharge_qqpay);
            }
            aVar.f79545a.setTextColor(this.f79541e.getResources().getColor(j.a.a.e.a.pay_ui_font_color_6));
            if (this.f79542f == i2) {
                aVar.f79547c.setBackgroundResource(h.f79528a.b(this.f79544h) ? j.a.a.e.c.pay_ui_pay_way_item_select : j.a.a.e.c.pay_ui_pay_way_item_select_y);
            } else {
                aVar.f79547c.setBackgroundResource(j.a.a.e.c.pay_ui_pay_way_item_unselect);
            }
            if (TextUtils.isEmpty(item.f79522c)) {
                aVar.f79548d.setVisibility(8);
            } else {
                aVar.f79548d.setVisibility(0);
                aVar.f79548d.setText(item.f79522c);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
