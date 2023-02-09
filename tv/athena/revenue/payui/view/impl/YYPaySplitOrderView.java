package tv.athena.revenue.payui.view.impl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.ama;
import com.baidu.tieba.bka;
import com.baidu.tieba.dma;
import com.baidu.tieba.lma;
import com.baidu.tieba.qla;
import com.baidu.tieba.qma;
import com.baidu.tieba.rma;
import com.baidu.tieba.sla;
import com.baidu.tieba.wla;
import com.baidu.tieba.xia;
import com.baidu.tieba.zma;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.SplitRecordItem;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.SplitOrderConfigResult;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.RevenueManager;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.WindowParams;
import tv.athena.revenue.payui.view.adapter.PaySplitOrderAdapter;
/* loaded from: classes9.dex */
public class YYPaySplitOrderView extends LinearLayout implements zma {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public int b;
    public int c;
    public PayUIKitConfig d;
    public zma.b e;
    public zma.a f;
    public View g;
    public ImageView h;
    public bka i;
    public qla j;
    public RecyclerView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public PaySplitOrderAdapter o;
    public List<SplitRecordItem> p;
    public PayFlowType q;

    @Override // com.baidu.tieba.uma
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uma
    public void refreshWindow(WindowParams windowParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, windowParams) == null) {
        }
    }

    /* loaded from: classes9.dex */
    public class a implements PaySplitOrderAdapter.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPaySplitOrderView a;

        public a(YYPaySplitOrderView yYPaySplitOrderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPaySplitOrderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPaySplitOrderView;
        }

        @Override // tv.athena.revenue.payui.view.adapter.PaySplitOrderAdapter.c
        public void a(SplitRecordItem splitRecordItem) {
            long j;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, splitRecordItem) == null) {
                RLog.info("YYPaySplitOrderView", "onLinkItemClick mPayAmount:" + this.a.j + " item:" + splitRecordItem);
                lma.a(this.a.a, splitRecordItem.value);
                if (this.a.j != null) {
                    j = (long) this.a.j.c();
                } else {
                    j = -1;
                }
                if (this.a.q == PayFlowType.DIOALOG_PAY_FLOW) {
                    str = PayUVEventType.PAY_SPLIT_ORDER_LINK_ITME_CLICK;
                } else {
                    str = PayUVEventType.PAY_FULL_SPLIT_ORDER_LINK_ITME_CLICK;
                }
                String str2 = str;
                int i = this.a.b;
                int i2 = this.a.c;
                wla.d(i, i2, str2, "", "", "" + j);
            }
        }

        @Override // tv.athena.revenue.payui.view.adapter.PaySplitOrderAdapter.c
        public void b(SplitRecordItem splitRecordItem) {
            long j;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, splitRecordItem) == null) {
                RLog.info("YYPaySplitOrderView", "onPayAmoyntItemClick mPayAmount:" + this.a.j + " item:" + splitRecordItem);
                if (this.a.f != null) {
                    qla a = ama.a((int) (qma.d(splitRecordItem.value) * 100.0d), this.a.d);
                    a.d(splitRecordItem.id);
                    this.a.f.a(a);
                }
                if (this.a.j != null) {
                    j = (long) this.a.j.c();
                } else {
                    j = -1;
                }
                if (this.a.q == PayFlowType.DIOALOG_PAY_FLOW) {
                    str = "36";
                } else {
                    str = "42";
                }
                String str2 = str;
                int i = this.a.b;
                int i2 = this.a.c;
                wla.d(i, i2, str2, "", "", "" + j);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPaySplitOrderView a;

        public b(YYPaySplitOrderView yYPaySplitOrderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPaySplitOrderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPaySplitOrderView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            long j;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.f != null) {
                    this.a.f.b();
                }
                if (this.a.j != null) {
                    j = (long) this.a.j.c();
                } else {
                    j = -1;
                }
                if (this.a.q == PayFlowType.DIOALOG_PAY_FLOW) {
                    str = PayUVEventType.PAY_SPLIT_ORDER_MOTIFY_BTN_CLICK;
                } else {
                    str = PayUVEventType.PAY_FULL_SPLIT_ORDER_MOTIFY_BTN_CLICK;
                }
                String str2 = str;
                int i = this.a.b;
                int i2 = this.a.c;
                wla.d(i, i2, str2, "", "", "" + j);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements IResult<SplitOrderConfigResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPaySplitOrderView a;

        public c(YYPaySplitOrderView yYPaySplitOrderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPaySplitOrderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPaySplitOrderView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(SplitOrderConfigResult splitOrderConfigResult, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, splitOrderConfigResult, payCallBackBean) == null) {
                RLog.info("YYPaySplitOrderView", "querySplitOrderConfig onSuccess result:" + splitOrderConfigResult);
                this.a.n();
                this.a.r(splitOrderConfigResult);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, payCallBackBean) == null) {
                RLog.error("YYPaySplitOrderView", "querySplitOrderConfig onFail code:" + i + " failReason:" + str, new Object[0]);
                this.a.n();
                this.a.q(i, str);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPaySplitOrderView a;

        public d(YYPaySplitOrderView yYPaySplitOrderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPaySplitOrderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPaySplitOrderView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.p();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPaySplitOrderView(Activity activity, PayUIKitConfig payUIKitConfig, int i, int i2, zma.b bVar, bka bkaVar) {
        super(activity);
        qla qlaVar;
        long j;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, payUIKitConfig, Integer.valueOf(i), Integer.valueOf(i2), bVar, bkaVar};
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
        this.p = new ArrayList();
        this.a = activity;
        this.d = payUIKitConfig;
        this.e = bVar;
        this.b = i;
        this.c = i2;
        this.i = bkaVar;
        if (bVar != null) {
            qlaVar = bVar.a;
        } else {
            qlaVar = null;
        }
        this.j = qlaVar;
        zma.b bVar2 = this.e;
        this.q = bVar2 != null ? bVar2.c : null;
        o(activity);
        qla qlaVar2 = this.j;
        if (qlaVar2 != null) {
            j = (long) qlaVar2.c();
        } else {
            j = -1;
        }
        if (this.q == PayFlowType.DIOALOG_PAY_FLOW) {
            str = PayUVEventType.PAY_SPLIT_ORDER_PAGE_SHOW;
        } else {
            str = "37";
        }
        String str2 = str;
        RLog.debug("YYPaySplitOrderView", "mPayFlowType:" + this.q + " event:" + str2);
        wla.d(this.b, this.c, str2, "", "", "" + j);
    }

    @Override // com.baidu.tieba.uma
    public void attachWindow(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, window) == null) {
            w(window);
        }
    }

    @Override // com.baidu.tieba.zma
    public void setCallback(zma.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.f = aVar;
        }
    }

    public final void q(int i, String str) {
        zma.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048582, this, i, str) == null) && (aVar = this.f) != null) {
            aVar.onRefreshViewFail(i, str);
        }
    }

    @Override // com.baidu.tieba.zma
    public void a() {
        long j;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            qla qlaVar = this.j;
            if (qlaVar != null) {
                j = (long) qlaVar.c();
            } else {
                j = -1;
            }
            if (this.q == PayFlowType.DIOALOG_PAY_FLOW) {
                str = PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK;
            } else {
                str = PayUVEventType.PAY_FULL_SPLIT_ORDER_CLOSE_BTN_CLICK;
            }
            int i = this.b;
            int i2 = this.c;
            wla.d(i, i2, str, "", "", "" + j);
            RLog.info("YYPaySplitOrderView", "onBtnCloseClick mPayFlowType:" + this.q + " event:" + str);
        }
    }

    public final void p() {
        long j;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            zma.a aVar = this.f;
            if (aVar != null) {
                aVar.b();
            }
            qla qlaVar = this.j;
            if (qlaVar != null) {
                j = (long) qlaVar.c();
            } else {
                j = -1;
            }
            if (this.q == PayFlowType.DIOALOG_PAY_FLOW) {
                str = PayUVEventType.PAY_SPLIT_ORDER_BACK_BTN_CLICK;
            } else {
                str = PayUVEventType.PAY_FULL_SPLIT_ORDER_BACK_BTN_CLICK;
            }
            String str2 = str;
            int i = this.b;
            int i2 = this.c;
            wla.d(i, i2, str2, "", "", "" + j);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            RLog.info("YYPaySplitOrderView", "querySplitOrderConfig mPayAmount:" + this.j);
            xia yYPayMiddleService = RevenueManager.instance().getYYPayMiddleService(this.b, this.c);
            if (yYPayMiddleService == null) {
                RLog.error("YYPaySplitOrderView", "querySplitOrderConfig error yyPayMiddleService null", new Object[0]);
                return;
            }
            qla qlaVar = this.j;
            if (qlaVar == null) {
                RLog.error("YYPaySplitOrderView", "querySplitOrderConfig error mPayAmount null", new Object[0]);
            } else {
                yYPayMiddleService.d(1, "", (long) qlaVar.c(), new c(this));
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            dma.a(this.g, this.h);
        }
    }

    @Override // com.baidu.tieba.uma
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            RLog.info("YYPaySplitOrderView", "refreshView");
            u();
            s();
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            dma.b(this.g, this.h);
        }
    }

    public final void o(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
            LayoutInflater.from(new ContextThemeWrapper(activity, rma.a.a(this.d))).inflate(R.layout.pay_ui_layout_pay_split_order_view, (ViewGroup) this, true);
            this.g = findViewById(R.id.root_loading);
            this.h = (ImageView) findViewById(R.id.iv_loading_circle);
            this.k = (RecyclerView) findViewById(R.id.grid_recharge_split_order);
            PaySplitOrderAdapter paySplitOrderAdapter = new PaySplitOrderAdapter(this.a, this.p, this.d);
            this.o = paySplitOrderAdapter;
            paySplitOrderAdapter.e(new a(this));
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0924a5);
            this.l = textView;
            textView.getPaint().setFlags(8);
            this.l.setOnClickListener(new b(this));
            this.m = (TextView) findViewById(R.id.tv_total_src_amount);
            this.n = (TextView) findViewById(R.id.tv_Split_Order_Hint);
            t();
        }
    }

    public final void v(SplitOrderConfigResult splitOrderConfigResult) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, splitOrderConfigResult) == null) && this.n != null && this.k != null && this.o != null && this.l != null) {
            if (TextUtils.isEmpty(splitOrderConfigResult.bottomGuideMsg)) {
                this.l.setVisibility(4);
            } else {
                this.l.setVisibility(0);
                this.l.setText(splitOrderConfigResult.bottomGuideMsg);
            }
            this.n.setText(splitOrderConfigResult.hintMsg);
            this.p.clear();
            List<SplitRecordItem> list = splitOrderConfigResult.splitRecordItemList;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).type == 1 || list.get(i).type == 2) {
                    this.p.add(list.get(i));
                }
            }
            this.k.setLayoutManager(new LinearLayoutManager(this.a));
            this.k.setAdapter(this.o);
            this.o.notifyDataSetChanged();
        }
    }

    public final void r(SplitOrderConfigResult splitOrderConfigResult) {
        List<SplitRecordItem> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, splitOrderConfigResult) == null) {
            if (splitOrderConfigResult != null && (list = splitOrderConfigResult.splitRecordItemList) != null && !list.isEmpty()) {
                bka bkaVar = this.i;
                if (bkaVar != null) {
                    bkaVar.c(new sla(splitOrderConfigResult, this.e));
                }
                v(splitOrderConfigResult);
                return;
            }
            q(-1, "splitRecordItemList null");
        }
    }

    public final void w(Window window) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, window) != null) || window == null) {
            return;
        }
        View findViewById = window.findViewById(R.id.btn_left);
        if (findViewById == null) {
            RLog.error("YYPaySplitOrderView", "updateTopLeftBtn error btnLeft null", new Object[0]);
            return;
        }
        findViewById.setOnClickListener(new d(this));
        findViewById.setVisibility(0);
        findViewById.setBackgroundResource(R.drawable.pay_ui_bottom_left_back_icon);
    }

    public final void t() {
        zma.b bVar;
        qla qlaVar;
        boolean z;
        String format;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (bVar = this.e) != null && (qlaVar = bVar.a) != null) {
            double c2 = qlaVar.c();
            if (c2 == ((long) c2)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                format = new DecimalFormat("0").format(c2);
            } else {
                format = new DecimalFormat("0.00").format(c2);
            }
            this.m.setText(format);
        }
    }
}
