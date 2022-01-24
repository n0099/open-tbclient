package tv.athena.revenue.payui.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
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
import j.a.a.e.o.b;
import j.a.a.e.p.j;
import j.a.a.e.p.o;
import j.a.a.e.q.d;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes5.dex */
public class YYPayGiftView extends LinearLayout implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f63011e;

    /* renamed from: f  reason: collision with root package name */
    public int f63012f;

    /* renamed from: g  reason: collision with root package name */
    public Button f63013g;

    /* renamed from: h  reason: collision with root package name */
    public GridView f63014h;

    /* renamed from: i  reason: collision with root package name */
    public View f63015i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f63016j;
    public d.a k;
    public GiftBagsInfo l;
    public PayUIKitConfig m;
    public List<GiftBagItemInfo> mGiftBagList;
    public j.a.a.e.q.e.a n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayGiftView f63017e;

        public a(YYPayGiftView yYPayGiftView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayGiftView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63017e = yYPayGiftView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f63017e.k == null) {
                return;
            }
            this.f63017e.k.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayGiftView(Context context, int i2, int i3, PayUIKitConfig payUIKitConfig) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), payUIKitConfig};
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
        this.f63011e = i2;
        this.f63012f = i3;
        this.m = payUIKitConfig;
        b(context);
        b.d(this.f63011e, this.f63012f, "17", "", "", "");
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(new ContextThemeWrapper(context, o.a.a(this.m))).inflate(g.pay_ui_layout_pay_success_gift_view, (ViewGroup) this, true);
            Button button = (Button) findViewById(f.btn_know);
            this.f63013g = button;
            button.setOnClickListener(new a(this));
            this.f63016j = (TextView) findViewById(f.tv_title);
            this.f63015i = findViewById(f.rl_container);
            this.f63014h = (GridView) findViewById(f.grid_pay_gift);
            j.a.a.e.q.e.a aVar = new j.a.a.e.q.e.a(context, this.mGiftBagList, this.m);
            this.n = aVar;
            this.f63014h.setAdapter((ListAdapter) aVar);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || TextUtils.isEmpty(this.l.successButtonMsg)) {
            return;
        }
        this.f63013g.setText(this.l.successButtonMsg);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TextUtils.isEmpty(this.l.successTitle)) {
            return;
        }
        this.f63016j.setText(this.l.successTitle);
    }

    @Override // j.a.a.e.q.a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // j.a.a.e.q.a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            RLog.info("YYPayGiftView", "refreshView mGiftBagsInfo:" + this.l);
            GiftBagsInfo giftBagsInfo = this.l;
            if (giftBagsInfo == null) {
                RLog.error("YYPayGiftView", "refreshView error mGiftBagsInfo null", new Object[0]);
                return;
            }
            List<GiftBagItemInfo> list = giftBagsInfo.giftbag;
            if (list != null && !list.isEmpty()) {
                this.mGiftBagList.clear();
                this.mGiftBagList.addAll(this.l.giftbag);
                this.n.notifyDataSetChanged();
                j.a(this.mGiftBagList.size(), this.f63015i, this.f63014h);
                d();
                c();
                return;
            }
            RLog.error("YYPayGiftView", "refreshView error giftbag empty", new Object[0]);
        }
    }

    @Override // j.a.a.e.q.d
    public void setCallback(d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.k = aVar;
        }
    }

    @Override // j.a.a.e.q.d
    public void setGiftBagsInfo(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, giftBagsInfo) == null) {
            RLog.info("YYPayGiftView", "setGiftBagsInfo giftBagsInfo:" + giftBagsInfo);
            this.l = giftBagsInfo;
        }
    }
}
