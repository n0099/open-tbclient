package tv.athena.revenue.payui.view.impl;

import android.app.Activity;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.k5a;
import com.baidu.tieba.o5a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagItemInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.WindowParams;
import tv.athena.revenue.payui.view.adapter.PayAmountCampaignListAdapter;
import tv.athena.revenue.payui.view.adapter.PayCampaignListItemDecoration;
/* loaded from: classes9.dex */
public class YYPayCampaignView extends LinearLayout implements o5a {
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
    public YYPayCampaignView(Activity activity, int i, int i2, PayUIKitConfig payUIKitConfig) {
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
            LayoutInflater.from(new ContextThemeWrapper(context, k5a.a.a(this.e))).inflate(R.layout.obfuscated_res_0x7f0d06ab, (ViewGroup) this, true);
            this.b = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091c9d);
            this.c = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091c56);
            this.h = new LinearLayoutManager(context, 0, false);
            this.g = new PayAmountCampaignListAdapter(this.a, this.f, this.e);
            this.b.setLayoutManager(this.h);
            this.b.addItemDecoration(new PayCampaignListItemDecoration());
            this.b.setAdapter(this.g);
        }
    }

    @Override // com.baidu.tieba.n5a
    public void attachWindow(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, window) == null) {
        }
    }

    @Override // com.baidu.tieba.n5a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.n5a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            GiftBagsInfo giftBagsInfo = this.d;
            if (giftBagsInfo == null) {
                RLog.error("YYPayCampaignView", "refreshView error mGiftBagsInfo null", new Object[0]);
                return;
            }
            List<GiftBagItemInfo> list = giftBagsInfo.giftbag;
            if (list != null && !list.isEmpty()) {
                this.f.clear();
                this.f.addAll(this.d.giftbag);
                this.g.notifyDataSetChanged();
                return;
            }
            RLog.error("YYPayCampaignView", "refreshView error giftbag null", new Object[0]);
        }
    }

    @Override // com.baidu.tieba.n5a
    public void refreshWindow(WindowParams windowParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, windowParams) == null) {
        }
    }

    @Override // com.baidu.tieba.o5a
    public void setGiftBagsInfo(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, giftBagsInfo) == null) {
            RLog.info("YYPayCampaignView", "setGiftBagsInfo giftBagsInfo:" + giftBagsInfo);
            this.d = giftBagsInfo;
        }
    }
}
