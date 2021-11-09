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
    public Activity f73135e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f73136f;

    /* renamed from: g  reason: collision with root package name */
    public GiftBagsInfo f73137g;

    /* renamed from: h  reason: collision with root package name */
    public PayUIKitConfig f73138h;

    /* renamed from: i  reason: collision with root package name */
    public PayAmountTopListAdapter f73139i;
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
        this.f73135e = activity;
        this.f73138h = payUIKitConfig;
        a(activity);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(new ContextThemeWrapper(context, l.f72365a.a(this.f73138h))).inflate(e.pay_ui_layout_pay_amount_top_view, (ViewGroup) this, true);
            this.f73136f = (RecyclerView) findViewById(d.rv_gift);
            this.j = new LinearLayoutManager(context, 0, false);
            this.f73139i = new PayAmountTopListAdapter(this.f73135e, this.mGiftBagList, this.f73138h);
            this.f73136f.setLayoutManager(this.j);
            this.f73136f.setAdapter(this.f73139i);
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
            GiftBagsInfo giftBagsInfo = this.f73137g;
            if (giftBagsInfo == null) {
                RLog.error("YYPayAmountTopView", "refreshView error mGiftBagsInfo null", new Object[0]);
                return;
            }
            List<GiftBagItemInfo> list = giftBagsInfo.giftbag;
            if (list != null && !list.isEmpty()) {
                this.mGiftBagList.clear();
                this.mGiftBagList.addAll(this.f73137g.giftbag);
                this.f73139i.notifyDataSetChanged();
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
            this.f73137g = giftBagsInfo;
        }
    }
}
