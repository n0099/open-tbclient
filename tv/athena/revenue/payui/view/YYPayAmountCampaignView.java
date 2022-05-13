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
import com.repackage.p5a;
import com.repackage.t5a;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagItemInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.adapter.PayAmountCampaignListAdapter;
import tv.athena.revenue.payui.view.adapter.PayCampaignListItemDecoration;
/* loaded from: classes9.dex */
public class YYPayAmountCampaignView extends LinearLayout implements t5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public RecyclerView b;
    public RelativeLayout c;
    public GiftBagsInfo d;
    public PayUIKitConfig e;
    public List<GiftBagItemInfo> f;
    public PayAmountCampaignListAdapter g;
    public LinearLayoutManager h;

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
        this.f = new ArrayList();
        this.a = activity;
        this.e = payUIKitConfig;
        a(activity);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(new ContextThemeWrapper(context, p5a.a.a(this.e))).inflate(R.layout.obfuscated_res_0x7f0d0657, (ViewGroup) this, true);
            this.b = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091b44);
            this.c = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091b07);
            this.h = new LinearLayoutManager(context, 0, false);
            this.g = new PayAmountCampaignListAdapter(this.a, this.f, this.e);
            this.b.setLayoutManager(this.h);
            this.b.addItemDecoration(new PayCampaignListItemDecoration());
            this.b.setAdapter(this.g);
        }
    }

    @Override // com.repackage.s5a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.repackage.s5a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            GiftBagsInfo giftBagsInfo = this.d;
            if (giftBagsInfo == null) {
                RLog.error("YYPayAmountCampaignView", "refreshView error mGiftBagsInfo null", new Object[0]);
                return;
            }
            List<GiftBagItemInfo> list = giftBagsInfo.giftbag;
            if (list != null && !list.isEmpty()) {
                this.f.clear();
                this.f.addAll(this.d.giftbag);
                this.g.notifyDataSetChanged();
                return;
            }
            RLog.error("YYPayAmountCampaignView", "refreshView error giftbag null", new Object[0]);
        }
    }

    @Override // com.repackage.t5a
    public void setGiftBagsInfo(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, giftBagsInfo) == null) {
            RLog.info("YYPayAmountCampaignView", "setGiftBagsInfo giftBagsInfo:" + giftBagsInfo);
            this.d = giftBagsInfo;
        }
    }
}
