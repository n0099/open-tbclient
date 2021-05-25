package d.a.n0.v0.d;

import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import tbclient.PlaceOrder.DataRes;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f62276a;

    /* renamed from: b  reason: collision with root package name */
    public int f62277b;

    /* renamed from: c  reason: collision with root package name */
    public int f62278c;

    /* renamed from: d  reason: collision with root package name */
    public long f62279d;

    /* renamed from: e  reason: collision with root package name */
    public String f62280e;

    /* renamed from: f  reason: collision with root package name */
    public int f62281f;

    /* renamed from: g  reason: collision with root package name */
    public String f62282g;

    /* renamed from: h  reason: collision with root package name */
    public String f62283h;

    /* renamed from: i  reason: collision with root package name */
    public long f62284i;
    public int j;
    public int k;
    public long l;
    public int m;

    public PaymentConfirmRequestData a() {
        PaymentConfirmRequestData paymentConfirmRequestData = new PaymentConfirmRequestData();
        paymentConfirmRequestData.setTdou_num(this.f62284i);
        paymentConfirmRequestData.setOpen_id(this.l);
        paymentConfirmRequestData.setOrder_id(this.f62282g);
        paymentConfirmRequestData.setScene_id(this.f62277b);
        paymentConfirmRequestData.setGoods_name(this.f62276a);
        paymentConfirmRequestData.setGoods_pic(this.f62280e);
        paymentConfirmRequestData.setTerminal("" + this.f62281f);
        paymentConfirmRequestData.setGoods_num((long) this.j);
        paymentConfirmRequestData.setGoods_unit(this.f62283h);
        paymentConfirmRequestData.setGoods_duration(this.f62279d);
        paymentConfirmRequestData.setGoods_user_level(this.f62278c);
        paymentConfirmRequestData.setPay_type(this.k);
        paymentConfirmRequestData.setCurrency(this.m);
        return paymentConfirmRequestData;
    }

    public String b() {
        return this.f62282g;
    }

    public void c(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        dataRes.timestamp.intValue();
        this.f62276a = dataRes.goods_name;
        this.f62277b = dataRes.scene_id.intValue();
        this.f62278c = dataRes.goods_user_level.intValue();
        this.f62279d = dataRes.goods_duration.intValue();
        this.f62280e = dataRes.goods_pic;
        this.f62281f = dataRes.terminal.intValue();
        this.f62282g = dataRes.order_id;
        this.f62283h = dataRes.goods_unit;
        this.f62284i = dataRes.tdou_num.intValue();
        dataRes.goods_price.intValue();
        this.j = dataRes.goods_num.intValue();
        this.k = dataRes.pay_type.intValue();
        dataRes.user_id.longValue();
        dataRes.tb_timestamp.intValue();
        this.l = dataRes.open_id.longValue();
        dataRes.gift_count.intValue();
        this.m = dataRes.currency.intValue();
    }
}
