package tv.athena.revenue.payui.view;

import android.app.Activity;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagItemInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import i.a.a.e.d;
import i.a.a.e.e;
import i.a.a.e.n.l;
import i.a.a.e.o.b;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.adapter.PayAmountTopListAdapter;
/* loaded from: classes3.dex */
public class YYPayAmountTopView extends LinearLayout implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Activity f74056e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f74057f;

    /* renamed from: g  reason: collision with root package name */
    public GiftBagsInfo f74058g;

    /* renamed from: h  reason: collision with root package name */
    public PayUIKitConfig f74059h;

    /* renamed from: i  reason: collision with root package name */
    public PayAmountTopListAdapter f74060i;
    public LinearLayoutManager j;
    public List<GiftBagItemInfo> mGiftBagList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayAmountTopView(Activity activity, int i2, int i3, PayUIKitConfig payUIKitConfig) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i2), Integer.valueOf(i3), payUIKitConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mGiftBagList = new ArrayList();
        this.f74056e = activity;
        this.f74059h = payUIKitConfig;
        a(activity);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(new ContextThemeWrapper(context, l.f73284a.a(this.f74059h))).inflate(e.pay_ui_layout_pay_amount_top_view, (ViewGroup) this, true);
            this.f74057f = (RecyclerView) findViewById(d.rv_gift);
            this.j = new LinearLayoutManager(context, 0, false);
            this.f74060i = new PayAmountTopListAdapter(this.f74056e, this.mGiftBagList, this.f74059h);
            this.f74057f.setLayoutManager(this.j);
            this.f74057f.setAdapter(this.f74060i);
        }
    }

    @Override // i.a.a.e.o.a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // i.a.a.e.o.a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            GiftBagsInfo giftBagsInfo = this.f74058g;
            if (giftBagsInfo == null) {
                RLog.error("YYPayAmountTopView", "refreshView error mGiftBagsInfo null", new Object[0]);
                return;
            }
            List<GiftBagItemInfo> list = giftBagsInfo.giftbag;
            if (list != null && !list.isEmpty()) {
                this.mGiftBagList.clear();
                this.mGiftBagList.addAll(this.f74058g.giftbag);
                this.f74060i.notifyDataSetChanged();
                return;
            }
            RLog.error("YYPayAmountTopView", "refreshView error giftbag null", new Object[0]);
        }
    }

    @Override // i.a.a.e.o.b
    public void setGiftBagsInfo(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, giftBagsInfo) == null) {
            RLog.info("YYPayAmountTopView", "setGiftBagsInfo giftBagsInfo:" + giftBagsInfo);
            this.f74058g = giftBagsInfo;
        }
    }
}
