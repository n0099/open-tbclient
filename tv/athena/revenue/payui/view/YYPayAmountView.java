package tv.athena.revenue.payui.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import d.r.b.a.a.i.c.g;
import d.r.b.a.a.i.c.j;
import i.a.a.e.l.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tv.athena.revenue.payui.controller.IYYPayCallback;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.widget.NoScrollGridView;
/* loaded from: classes8.dex */
public class YYPayAmountView extends LinearLayout implements IYYPayAmountView {

    /* renamed from: e  reason: collision with root package name */
    public Activity f69608e;

    /* renamed from: f  reason: collision with root package name */
    public Button f69609f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f69610g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f69611h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f69612i;
    public NoScrollGridView j;
    public i.a.a.e.m.b.a k;
    public QueryCurrencyReqParams l;
    public i.a.a.e.i.c m;
    public List<i.a.a.e.j.b> n;
    public List<g> o;
    public i.a.a.e.j.b p;
    public IYYPayAmountView.Callback q;
    public String r;

    /* loaded from: classes8.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            i.a.a.e.j.b item = YYPayAmountView.this.k.getItem(i2);
            if (item != null) {
                YYPayAmountView.this.p = item;
                YYPayAmountView.this.m(item);
            }
            YYPayAmountView.this.k.c(i2);
            YYPayAmountView.this.k.notifyDataSetChanged();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            YYPayAmountView.this.i();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (YYPayAmountView.this.o != null) {
                if (YYPayAmountView.this.q != null) {
                    YYPayAmountView.this.q.showInputNumberDialog(YYPayAmountView.this.f69608e, YYPayAmountView.this.o);
                    return;
                }
                return;
            }
            d.r.b.a.a.f.d.d.e("YYPayAmountView", "mPayWayInfoList data null", new Object[0]);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements IResult<ProductListResult> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(ProductListResult productListResult, d.r.b.a.a.f.b bVar) {
            YYPayAmountView.this.l(productListResult);
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, d.r.b.a.a.f.b bVar) {
            d.r.b.a.a.f.d.d.e("YYPayAmountView", "refreshView()->queryProductList->onFail->code:" + i2 + " failReason:" + str, new Object[0]);
            if (e.f68885a.a(YYPayAmountView.this.f69608e)) {
                String str2 = "请求服务失败 code:" + i2 + " failReason:" + str;
                if (i2 == -500) {
                    str2 = "网络不给力，请稍后重试";
                }
                Toast.makeText(YYPayAmountView.this.f69608e, str2, 1).show();
            }
            if (YYPayAmountView.this.q != null) {
                YYPayAmountView.this.q.onFail(i2, str);
            }
        }
    }

    public YYPayAmountView(Activity activity, i.a.a.e.i.c cVar, IYYPayCallback iYYPayCallback, IYYPayAmountView.ViewParams viewParams, i.a.a.e.i.a aVar) {
        super(activity);
        this.n = new ArrayList();
        this.r = "Y币";
        this.f69608e = activity;
        this.m = cVar;
        this.l = aVar.a();
        k(activity);
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView, i.a.a.e.m.a
    public View getContentView() {
        return this;
    }

    public final void i() {
        List<g> list;
        i.a.a.e.j.b bVar = this.p;
        if (bVar != null && (list = this.o) != null) {
            IYYPayAmountView.Callback callback = this.q;
            if (callback != null) {
                callback.toPayWayDialog(bVar, list);
                return;
            }
            return;
        }
        d.r.b.a.a.f.d.d.e("YYPayAmountView", "confirmRecharge data null", new Object[0]);
    }

    public final int j(int i2) {
        return i2 < 5 ? 2 : 3;
    }

    public final void k(Activity activity) {
        LayoutInflater.from(activity).inflate(i.a.a.e.d.yy_layout_pay_amount_view, (ViewGroup) this, true);
        this.f69611h = (TextView) findViewById(i.a.a.e.c.tv_total_src_amount);
        this.f69612i = (TextView) findViewById(i.a.a.e.c.tv_gain_dest_amount);
        i.a.a.e.m.b.a aVar = new i.a.a.e.m.b.a(this.f69608e, this.n);
        this.k = aVar;
        aVar.b(this.r);
        NoScrollGridView noScrollGridView = (NoScrollGridView) findViewById(i.a.a.e.c.grid_recharge_amount);
        this.j = noScrollGridView;
        noScrollGridView.setSelector(i.a.a.e.b.yy_selector_transparent);
        this.j.setAdapter((ListAdapter) this.k);
        this.j.setOnItemClickListener(new a());
        Button button = (Button) findViewById(i.a.a.e.c.btn_confirm_recharge);
        this.f69609f = button;
        button.setOnClickListener(new b());
        TextView textView = (TextView) findViewById(i.a.a.e.c.et_input_text);
        this.f69610g = textView;
        textView.setOnClickListener(new c());
    }

    public final void l(ProductListResult productListResult) {
        if (productListResult == null) {
            d.r.b.a.a.f.d.d.e("YYPayAmountView", "showProductListView null", new Object[0]);
        } else if (this.j != null && this.k != null) {
            String currencyName = productListResult.getCurrencyName() != null ? productListResult.getCurrencyName() : "Y币";
            this.r = currencyName;
            this.k.b(currencyName);
            List<j> productInfoList = productListResult.getProductInfoList();
            if (productInfoList != null && productInfoList.size() != 0) {
                this.n.clear();
                for (int i2 = 0; i2 < productInfoList.size(); i2++) {
                    j jVar = productInfoList.get(i2);
                    d.r.b.a.a.f.d.d.f("YYPayAmountView", "productInfo-> destAmount=" + jVar.f67838g + ", symbol=" + jVar.f67837f);
                    this.n.add(new i.a.a.e.j.b(jVar));
                }
                this.j.setNumColumns(j(this.k.getCount()));
                this.k.notifyDataSetChanged();
                List<g> payWayInfoList = productListResult.getPayWayInfoList();
                this.o = payWayInfoList;
                if (payWayInfoList != null) {
                    Iterator<g> it = payWayInfoList.iterator();
                    while (it.hasNext()) {
                        d.r.b.a.a.f.d.d.f("YYPayAmountView", "payWayInfo-> " + it.next());
                    }
                }
                this.p = this.n.get(0);
                this.k.c(0);
                this.k.notifyDataSetChanged();
                m(this.k.getItem(0));
                i.a.a.e.j.c.f68874a = productListResult.getPaysSettingInfo();
                return;
            }
            d.r.b.a.a.f.d.d.e("YYPayAmountView", "productInfoList null", new Object[0]);
        }
    }

    public final void m(i.a.a.e.j.b bVar) {
        if (this.f69612i == null || this.f69611h == null || bVar == null) {
            return;
        }
        Double b2 = bVar.b();
        double a2 = bVar.a();
        if (b2 != null) {
            this.f69611h.setText(String.format("¥%s", i.a.a.e.l.d.a(b2.doubleValue())));
        }
        this.f69612i.setText(i.a.a.e.l.d.a(a2) + this.r);
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView
    public void refreshView() {
        i.a.a.e.i.c cVar = this.m;
        if (cVar == null) {
            return;
        }
        cVar.queryProductList(this.l, new d());
    }

    @Override // tv.athena.revenue.payui.view.IYYPayAmountView
    public void setCallback(IYYPayAmountView.Callback callback) {
        this.q = callback;
    }
}
