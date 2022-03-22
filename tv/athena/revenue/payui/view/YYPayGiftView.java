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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagItemInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import h.a.a.e.g.b;
import h.a.a.e.h.j;
import h.a.a.e.h.o;
import h.a.a.e.i.d;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes8.dex */
public class YYPayGiftView extends LinearLayout implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f45864b;

    /* renamed from: c  reason: collision with root package name */
    public Button f45865c;

    /* renamed from: d  reason: collision with root package name */
    public GridView f45866d;

    /* renamed from: e  reason: collision with root package name */
    public View f45867e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f45868f;

    /* renamed from: g  reason: collision with root package name */
    public d.a f45869g;

    /* renamed from: h  reason: collision with root package name */
    public GiftBagsInfo f45870h;
    public PayUIKitConfig i;
    public List<GiftBagItemInfo> j;
    public h.a.a.e.i.e.a k;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayGiftView a;

        public a(YYPayGiftView yYPayGiftView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayGiftView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPayGiftView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f45869g == null) {
                return;
            }
            this.a.f45869g.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayGiftView(Context context, int i, int i2, PayUIKitConfig payUIKitConfig) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), payUIKitConfig};
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
        this.j = new ArrayList();
        this.a = i;
        this.f45864b = i2;
        this.i = payUIKitConfig;
        b(context);
        b.d(this.a, this.f45864b, "17", "", "", "");
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(new ContextThemeWrapper(context, o.a.a(this.i))).inflate(R.layout.obfuscated_res_0x7f0d066c, (ViewGroup) this, true);
            Button button = (Button) findViewById(R.id.obfuscated_res_0x7f090418);
            this.f45865c = button;
            button.setOnClickListener(new a(this));
            this.f45868f = (TextView) findViewById(R.id.obfuscated_res_0x7f09221e);
            this.f45867e = findViewById(R.id.obfuscated_res_0x7f091ac7);
            this.f45866d = (GridView) findViewById(R.id.obfuscated_res_0x7f090cec);
            h.a.a.e.i.e.a aVar = new h.a.a.e.i.e.a(context, this.j, this.i);
            this.k = aVar;
            this.f45866d.setAdapter((ListAdapter) aVar);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || TextUtils.isEmpty(this.f45870h.successButtonMsg)) {
            return;
        }
        this.f45865c.setText(this.f45870h.successButtonMsg);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TextUtils.isEmpty(this.f45870h.successTitle)) {
            return;
        }
        this.f45868f.setText(this.f45870h.successTitle);
    }

    @Override // h.a.a.e.i.a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // h.a.a.e.i.a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            RLog.info("YYPayGiftView", "refreshView mGiftBagsInfo:" + this.f45870h);
            GiftBagsInfo giftBagsInfo = this.f45870h;
            if (giftBagsInfo == null) {
                RLog.error("YYPayGiftView", "refreshView error mGiftBagsInfo null", new Object[0]);
                return;
            }
            List<GiftBagItemInfo> list = giftBagsInfo.giftbag;
            if (list != null && !list.isEmpty()) {
                this.j.clear();
                this.j.addAll(this.f45870h.giftbag);
                this.k.notifyDataSetChanged();
                j.a(this.j.size(), this.f45867e, this.f45866d);
                d();
                c();
                return;
            }
            RLog.error("YYPayGiftView", "refreshView error giftbag empty", new Object[0]);
        }
    }

    @Override // h.a.a.e.i.d
    public void setCallback(d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f45869g = aVar;
        }
    }

    @Override // h.a.a.e.i.d
    public void setGiftBagsInfo(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, giftBagsInfo) == null) {
            RLog.info("YYPayGiftView", "setGiftBagsInfo giftBagsInfo:" + giftBagsInfo);
            this.f45870h = giftBagsInfo;
        }
    }
}
