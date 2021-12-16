package tv.athena.revenue.payui.view;

import android.app.Activity;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import j.a.a.e.f;
import j.a.a.e.g;
import j.a.a.e.p.o;
import j.a.a.e.q.b;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.adapter.PayAmountCampaignListAdapter;
import tv.athena.revenue.payui.view.adapter.PayCampaignListItemDecoration;
/* loaded from: classes5.dex */
public class YYPayAmountCampaignView extends LinearLayout implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Activity f65390e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f65391f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f65392g;

    /* renamed from: h  reason: collision with root package name */
    public GiftBagsInfo f65393h;

    /* renamed from: i  reason: collision with root package name */
    public PayUIKitConfig f65394i;

    /* renamed from: j  reason: collision with root package name */
    public PayAmountCampaignListAdapter f65395j;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayoutManager f65396k;
    public List<GiftBagItemInfo> mGiftBagList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayAmountCampaignView(Activity activity, int i2, int i3, PayUIKitConfig payUIKitConfig) {
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
        this.f65390e = activity;
        this.f65394i = payUIKitConfig;
        a(activity);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(new ContextThemeWrapper(context, o.a.a(this.f65394i))).inflate(g.pay_ui_layout_pay_amount_campaign_view, (ViewGroup) this, true);
            this.f65391f = (RecyclerView) findViewById(f.rv_campaign);
            this.f65392g = (RelativeLayout) findViewById(f.rl_content);
            this.f65396k = new LinearLayoutManager(context, 0, false);
            this.f65395j = new PayAmountCampaignListAdapter(this.f65390e, this.mGiftBagList, this.f65394i);
            this.f65391f.setLayoutManager(this.f65396k);
            this.f65391f.addItemDecoration(new PayCampaignListItemDecoration());
            this.f65391f.setAdapter(this.f65395j);
        }
    }

    @Override // j.a.a.e.q.a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // j.a.a.e.q.a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            GiftBagsInfo giftBagsInfo = this.f65393h;
            if (giftBagsInfo == null) {
                RLog.error("YYPayAmountCampaignView", "refreshView error mGiftBagsInfo null", new Object[0]);
                return;
            }
            List<GiftBagItemInfo> list = giftBagsInfo.giftbag;
            if (list != null && !list.isEmpty()) {
                this.mGiftBagList.clear();
                this.mGiftBagList.addAll(this.f65393h.giftbag);
                this.f65395j.notifyDataSetChanged();
                return;
            }
            RLog.error("YYPayAmountCampaignView", "refreshView error giftbag null", new Object[0]);
        }
    }

    @Override // j.a.a.e.q.b
    public void setGiftBagsInfo(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, giftBagsInfo) == null) {
            RLog.info("YYPayAmountCampaignView", "setGiftBagsInfo giftBagsInfo:" + giftBagsInfo);
            this.f65393h = giftBagsInfo;
        }
    }
}
