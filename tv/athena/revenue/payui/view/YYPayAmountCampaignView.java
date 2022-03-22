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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagItemInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import h.a.a.e.h.o;
import h.a.a.e.i.b;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.adapter.PayAmountCampaignListAdapter;
import tv.athena.revenue.payui.view.adapter.PayCampaignListItemDecoration;
/* loaded from: classes8.dex */
public class YYPayAmountCampaignView extends LinearLayout implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f45842b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f45843c;

    /* renamed from: d  reason: collision with root package name */
    public GiftBagsInfo f45844d;

    /* renamed from: e  reason: collision with root package name */
    public PayUIKitConfig f45845e;

    /* renamed from: f  reason: collision with root package name */
    public List<GiftBagItemInfo> f45846f;

    /* renamed from: g  reason: collision with root package name */
    public PayAmountCampaignListAdapter f45847g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayoutManager f45848h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayAmountCampaignView(Activity activity, int i, int i2, PayUIKitConfig payUIKitConfig) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i), Integer.valueOf(i2), payUIKitConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45846f = new ArrayList();
        this.a = activity;
        this.f45845e = payUIKitConfig;
        a(activity);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(new ContextThemeWrapper(context, o.a.a(this.f45845e))).inflate(R.layout.obfuscated_res_0x7f0d0668, (ViewGroup) this, true);
            this.f45842b = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091b06);
            this.f45843c = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091ac8);
            this.f45848h = new LinearLayoutManager(context, 0, false);
            this.f45847g = new PayAmountCampaignListAdapter(this.a, this.f45846f, this.f45845e);
            this.f45842b.setLayoutManager(this.f45848h);
            this.f45842b.addItemDecoration(new PayCampaignListItemDecoration());
            this.f45842b.setAdapter(this.f45847g);
        }
    }

    @Override // h.a.a.e.i.a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // h.a.a.e.i.a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            GiftBagsInfo giftBagsInfo = this.f45844d;
            if (giftBagsInfo == null) {
                RLog.error("YYPayAmountCampaignView", "refreshView error mGiftBagsInfo null", new Object[0]);
                return;
            }
            List<GiftBagItemInfo> list = giftBagsInfo.giftbag;
            if (list != null && !list.isEmpty()) {
                this.f45846f.clear();
                this.f45846f.addAll(this.f45844d.giftbag);
                this.f45847g.notifyDataSetChanged();
                return;
            }
            RLog.error("YYPayAmountCampaignView", "refreshView error giftbag null", new Object[0]);
        }
    }

    @Override // h.a.a.e.i.b
    public void setGiftBagsInfo(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, giftBagsInfo) == null) {
            RLog.info("YYPayAmountCampaignView", "setGiftBagsInfo giftBagsInfo:" + giftBagsInfo);
            this.f45844d = giftBagsInfo;
        }
    }
}
