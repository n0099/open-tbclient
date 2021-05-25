package tv.athena.revenue.payui.view;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import d.r.b.a.a.i.c.g;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.widget.NoScrollGridView;
/* loaded from: classes8.dex */
public class YYPayWayView extends LinearLayout implements IYYPayWayView {

    /* renamed from: e  reason: collision with root package name */
    public List<i.a.a.e.j.d> f69624e;

    /* renamed from: f  reason: collision with root package name */
    public NoScrollGridView f69625f;

    /* renamed from: g  reason: collision with root package name */
    public i.a.a.e.m.b.b f69626g;

    /* renamed from: h  reason: collision with root package name */
    public List<g> f69627h;

    /* renamed from: i  reason: collision with root package name */
    public int f69628i;
    public int j;
    public IYYPayWayView.a k;
    public i.a.a.e.j.d l;
    public Button m;
    public i.a.a.e.j.b n;
    public IYYPayWayView.b o;
    public Context p;
    public TextView q;
    public ImageView r;
    public i.a.a.e.i.c s;
    public SharedPreferences t;
    public String u;

    /* loaded from: classes8.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f69629e;

        public a(Context context) {
            this.f69629e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            YYPayWayView yYPayWayView = YYPayWayView.this;
            yYPayWayView.l = yYPayWayView.f69626g.getItem(i2);
            if (YYPayWayView.this.f69626g.b() != i2) {
                YYPayWayView.this.f69626g.c(i2);
                YYPayWayView.this.f69626g.notifyDataSetChanged();
            }
            if (YYPayWayView.this.l.f68877a != PayType.WECHAT_PAY || d.r.b.a.a.f.h.c.a(this.f69629e)) {
                return;
            }
            Toast.makeText(this.f69629e, "未安装微信", 1).show();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f69631e;

        public b(Context context) {
            this.f69631e = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (YYPayWayView.this.l != null) {
                if (YYPayWayView.this.l.f68877a != PayType.WECHAT_PAY || d.r.b.a.a.f.h.c.a(this.f69631e)) {
                    if (YYPayWayView.this.k != null && YYPayWayView.this.n != null && YYPayWayView.this.n.f68873a != null) {
                        YYPayWayView.this.k.a(YYPayWayView.this.l, YYPayWayView.this.n);
                        i.a.a.e.k.a.c(YYPayWayView.this.f69628i, YYPayWayView.this.j, "paypagepaybt", String.valueOf(YYPayWayView.this.n.f68873a.f67836e));
                        d.r.b.a.a.f.d.d.h("YYPayWayView", "paypagepaybt amount:" + YYPayWayView.this.n.f68873a.f67836e);
                        return;
                    }
                    d.r.b.a.a.f.d.d.e("YYPayWayView", "mCallback or mPayAmount or productInfo null", new Object[0]);
                    return;
                }
                Toast.makeText(this.f69631e, "未安装微信", 1).show();
                return;
            }
            d.r.b.a.a.f.d.d.e("YYPayWayView", "mPayWay null", new Object[0]);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (YYPayWayView.this.s != null) {
                String f2 = YYPayWayView.this.s.f();
                d.r.b.a.a.f.d.d.b("YYPayWayView", "agreeUrl:" + f2);
                if (YYPayWayView.this.p instanceof Activity) {
                    YYPayWayView.this.s.h((Activity) YYPayWayView.this.p, f2, "Y币充值协议");
                } else {
                    d.r.b.a.a.f.d.d.e("YYPayWayView", "mContext not Activity", new Object[0]);
                }
                i.a.a.e.k.a.b(YYPayWayView.this.f69628i, YYPayWayView.this.j, "paypageprotocol");
                d.r.b.a.a.f.d.d.h("YYPayWayView", "paypageprotocol");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = !YYPayWayView.this.m.isEnabled();
            YYPayWayView.this.m.setEnabled(z);
            YYPayWayView.this.t.edit().putBoolean("yy_paysdk_sp_use_item_state_key", z).commit();
            YYPayWayView.this.r.setBackgroundResource(z ? i.a.a.e.b.yy_pay_way_item_select : i.a.a.e.b.yy_pay_way_item_unselect);
        }
    }

    public YYPayWayView(Context context, int i2, int i3, IYYPayWayView.b bVar, i.a.a.e.i.c cVar) {
        super(context);
        this.f69624e = new ArrayList();
        this.u = "";
        if (bVar == null) {
            d.r.b.a.a.f.d.d.e("YYPayWayView", "YYPayWayView construct error viewParams null", new Object[0]);
        }
        LayoutInflater.from(context).inflate(i.a.a.e.d.yy_layout_pay_way_view, (ViewGroup) this, true);
        this.o = bVar;
        this.f69627h = bVar.f69606a;
        this.n = bVar.f69607b;
        this.p = context;
        this.s = cVar;
        this.f69628i = i2;
        this.j = i3;
        this.f69624e.clear();
        this.f69624e.addAll(m());
        this.f69626g = new i.a.a.e.m.b.b(context, this.f69624e);
        NoScrollGridView noScrollGridView = (NoScrollGridView) findViewById(i.a.a.e.c.grid_recharge_way);
        this.f69625f = noScrollGridView;
        noScrollGridView.setSelector(i.a.a.e.b.yy_selector_transparent);
        this.f69625f.setAdapter((ListAdapter) this.f69626g);
        this.f69625f.setOnItemClickListener(new a(context));
        Button button = (Button) findViewById(i.a.a.e.c.btn_confirm_recharge);
        this.m = button;
        button.setOnClickListener(new b(context));
        TextView textView = (TextView) findViewById(i.a.a.e.c.tv_total_src_amount);
        TextView textView2 = (TextView) findViewById(i.a.a.e.c.tv_total_dst_amount);
        IYYPayWayView.b bVar2 = this.o;
        if (bVar2 != null && bVar2.f69607b != null) {
            String str = "0.00";
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            decimalFormat.setRoundingMode(RoundingMode.DOWN);
            Double b2 = this.o.f69607b.b();
            if (b2 != null) {
                str = decimalFormat.format(b2);
                textView.setText(str);
            } else {
                textView.setText("0.00");
            }
            textView2.setText(decimalFormat.format(this.o.f69607b.a()));
            this.m.setText("确认支付 " + str + "元");
        }
        if (this.f69624e.size() > 0) {
            this.l = this.f69624e.get(0);
            this.f69626g.c(0);
            this.f69626g.notifyDataSetChanged();
        }
        TextView textView3 = (TextView) findViewById(i.a.a.e.c.tv_use_item);
        this.q = textView3;
        textView3.setOnClickListener(new c());
        this.t = this.p.getSharedPreferences("yy_paysdk_sp_name", 0);
        this.r = (ImageView) findViewById(i.a.a.e.c.img_select);
        boolean z = this.t.getBoolean("yy_paysdk_sp_use_item_state_key", true);
        this.m.setEnabled(z);
        this.r.setBackgroundResource(z ? i.a.a.e.b.yy_pay_way_item_select : i.a.a.e.b.yy_pay_way_item_unselect);
        this.r.setOnClickListener(new d());
    }

    @Override // i.a.a.e.m.a
    public View getContentView() {
        return this;
    }

    public List<i.a.a.e.j.d> m() {
        ArrayList arrayList = new ArrayList();
        List<g> list = this.f69627h;
        if (list != null && list.size() != 0) {
            for (int i2 = 0; i2 < this.f69627h.size(); i2++) {
                g gVar = this.f69627h.get(i2);
                try {
                    if (PayType.ALI_PAY.getChannel().equals(gVar.f67823d) && PayType.ALI_PAY.getMethod().equals(gVar.f67824e)) {
                        arrayList.add(new i.a.a.e.j.d(PayType.ALI_PAY, "支付宝", gVar.f67822c));
                    } else if (PayType.WECHAT_PAY.getChannel().equals(gVar.f67823d) && PayType.WECHAT_PAY.getMethod().equals(gVar.f67824e)) {
                        arrayList.add(new i.a.a.e.j.d(PayType.WECHAT_PAY, "微信", gVar.f67822c));
                    } else if (PayType.DXM_PAY.getChannel().equals(gVar.f67823d) && PayType.DXM_PAY.getMethod().equals(gVar.f67824e)) {
                        arrayList.add(new i.a.a.e.j.d(PayType.DXM_PAY, "度小满", gVar.f67822c));
                    }
                } catch (Exception unused) {
                    d.r.b.a.a.f.d.d.e("YYPayWayView", "createRechargeWayList: error, payWayInfo=" + gVar, new Object[0]);
                }
            }
            return arrayList;
        }
        d.r.b.a.a.f.d.d.e("YYPayWayView", "createRechargeWayList error mPayWayInfoList null", new Object[0]);
        return arrayList;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView
    public void setCallback(IYYPayWayView.a aVar) {
        this.k = aVar;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView
    public void setViewState(IYYPayWayView.PayViewState payViewState) {
        if (payViewState == IYYPayWayView.PayViewState.WAITING_VIEW_STATE) {
            d.r.b.a.a.f.d.d.f("YYPayWayView", "setViewState waiting");
            Button button = this.m;
            if (button == null) {
                return;
            }
            this.u = button.getText().toString();
            this.m.setText("等待支付结果...");
            this.m.setClickable(false);
        } else if (payViewState == IYYPayWayView.PayViewState.SELECTING_VIEW_STATE) {
            d.r.b.a.a.f.d.d.f("YYPayWayView", "setViewState selecting");
            Button button2 = this.m;
            if (button2 == null) {
                return;
            }
            button2.setText(this.u);
            this.m.setClickable(true);
        }
    }
}
