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
import com.baidu.tieba.g8a;
import com.baidu.tieba.l7a;
import com.baidu.tieba.l8a;
import com.baidu.tieba.m8a;
import com.baidu.tieba.n7a;
import com.baidu.tieba.r7a;
import com.baidu.tieba.s4a;
import com.baidu.tieba.u8a;
import com.baidu.tieba.v7a;
import com.baidu.tieba.w5a;
import com.baidu.tieba.y7a;
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
public class YYPaySplitOrderView extends LinearLayout implements u8a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public int b;
    public int c;
    public PayUIKitConfig d;
    public u8a.b e;
    public u8a.a f;
    public View g;
    public ImageView h;
    public w5a i;
    public l7a j;
    public RecyclerView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public PaySplitOrderAdapter o;
    public List<SplitRecordItem> p;
    public PayFlowType q;

    @Override // com.baidu.tieba.p8a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.p8a
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
                g8a.a(this.a.a, splitRecordItem.value);
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
                r7a.d(i, i2, str2, "", "", "" + j);
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
                    l7a a = v7a.a((int) (l8a.d(splitRecordItem.value) * 100.0d), this.a.d);
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
                r7a.d(i, i2, str2, "", "", "" + j);
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
                r7a.d(i, i2, str2, "", "", "" + j);
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
    public YYPaySplitOrderView(Activity activity, PayUIKitConfig payUIKitConfig, int i, int i2, u8a.b bVar, w5a w5aVar) {
        super(activity);
        l7a l7aVar;
        long j;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, payUIKitConfig, Integer.valueOf(i), Integer.valueOf(i2), bVar, w5aVar};
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
        this.i = w5aVar;
        if (bVar != null) {
            l7aVar = bVar.a;
        } else {
            l7aVar = null;
        }
        this.j = l7aVar;
        u8a.b bVar2 = this.e;
        this.q = bVar2 != null ? bVar2.c : null;
        o(activity);
        l7a l7aVar2 = this.j;
        if (l7aVar2 != null) {
            j = (long) l7aVar2.c();
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
        r7a.d(this.b, this.c, str2, "", "", "" + j);
    }

    @Override // com.baidu.tieba.p8a
    public void attachWindow(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, window) == null) {
            w(window);
        }
    }

    @Override // com.baidu.tieba.u8a
    public void setCallback(u8a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.f = aVar;
        }
    }

    public final void q(int i, String str) {
        u8a.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048582, this, i, str) == null) && (aVar = this.f) != null) {
            aVar.onRefreshViewFail(i, str);
        }
    }

    @Override // com.baidu.tieba.u8a
    public void a() {
        long j;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            l7a l7aVar = this.j;
            if (l7aVar != null) {
                j = (long) l7aVar.c();
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
            r7a.d(i, i2, str, "", "", "" + j);
            RLog.info("YYPaySplitOrderView", "onBtnCloseClick mPayFlowType:" + this.q + " event:" + str);
        }
    }

    public final void p() {
        long j;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            u8a.a aVar = this.f;
            if (aVar != null) {
                aVar.b();
            }
            l7a l7aVar = this.j;
            if (l7aVar != null) {
                j = (long) l7aVar.c();
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
            r7a.d(i, i2, str2, "", "", "" + j);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            RLog.info("YYPaySplitOrderView", "querySplitOrderConfig mPayAmount:" + this.j);
            s4a yYPayMiddleService = RevenueManager.instance().getYYPayMiddleService(this.b, this.c);
            if (yYPayMiddleService == null) {
                RLog.error("YYPaySplitOrderView", "querySplitOrderConfig error yyPayMiddleService null", new Object[0]);
                return;
            }
            l7a l7aVar = this.j;
            if (l7aVar == null) {
                RLog.error("YYPaySplitOrderView", "querySplitOrderConfig error mPayAmount null", new Object[0]);
            } else {
                yYPayMiddleService.d(1, "", (long) l7aVar.c(), new c(this));
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            y7a.a(this.g, this.h);
        }
    }

    @Override // com.baidu.tieba.p8a
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
            y7a.b(this.g, this.h);
        }
    }

    public final void o(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
            LayoutInflater.from(new ContextThemeWrapper(activity, m8a.a.a(this.d))).inflate(R.layout.obfuscated_res_0x7f0d06c6, (ViewGroup) this, true);
            this.g = findViewById(R.id.obfuscated_res_0x7f091ccd);
            this.h = (ImageView) findViewById(R.id.obfuscated_res_0x7f091047);
            this.k = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f090d23);
            PaySplitOrderAdapter paySplitOrderAdapter = new PaySplitOrderAdapter(this.a, this.p, this.d);
            this.o = paySplitOrderAdapter;
            paySplitOrderAdapter.e(new a(this));
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0923ab);
            this.l = textView;
            textView.getPaint().setFlags(8);
            this.l.setOnClickListener(new b(this));
            this.m = (TextView) findViewById(R.id.obfuscated_res_0x7f09246d);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f0923ae);
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
                w5a w5aVar = this.i;
                if (w5aVar != null) {
                    w5aVar.c(new n7a(splitOrderConfigResult, this.e));
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
        View findViewById = window.findViewById(R.id.obfuscated_res_0x7f090456);
        if (findViewById == null) {
            RLog.error("YYPaySplitOrderView", "updateTopLeftBtn error btnLeft null", new Object[0]);
            return;
        }
        findViewById.setOnClickListener(new d(this));
        findViewById.setVisibility(0);
        findViewById.setBackgroundResource(R.drawable.obfuscated_res_0x7f080ee6);
    }

    public final void t() {
        u8a.b bVar;
        l7a l7aVar;
        boolean z;
        String format;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (bVar = this.e) != null && (l7aVar = bVar.a) != null) {
            double c2 = l7aVar.c();
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
