package d.a.k0.u0.d;

import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import tbclient.PlaceOrder.DataRes;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f62119a;

    /* renamed from: b  reason: collision with root package name */
    public int f62120b;

    /* renamed from: c  reason: collision with root package name */
    public int f62121c;

    /* renamed from: d  reason: collision with root package name */
    public long f62122d;

    /* renamed from: e  reason: collision with root package name */
    public String f62123e;

    /* renamed from: f  reason: collision with root package name */
    public int f62124f;

    /* renamed from: g  reason: collision with root package name */
    public String f62125g;

    /* renamed from: h  reason: collision with root package name */
    public String f62126h;

    /* renamed from: i  reason: collision with root package name */
    public long f62127i;
    public int j;
    public int k;
    public long l;
    public int m;

    public PaymentConfirmRequestData a() {
        PaymentConfirmRequestData paymentConfirmRequestData = new PaymentConfirmRequestData();
        paymentConfirmRequestData.setTdou_num(this.f62127i);
        paymentConfirmRequestData.setOpen_id(this.l);
        paymentConfirmRequestData.setOrder_id(this.f62125g);
        paymentConfirmRequestData.setScene_id(this.f62120b);
        paymentConfirmRequestData.setGoods_name(this.f62119a);
        paymentConfirmRequestData.setGoods_pic(this.f62123e);
        paymentConfirmRequestData.setTerminal("" + this.f62124f);
        paymentConfirmRequestData.setGoods_num((long) this.j);
        paymentConfirmRequestData.setGoods_unit(this.f62126h);
        paymentConfirmRequestData.setGoods_duration(this.f62122d);
        paymentConfirmRequestData.setGoods_user_level(this.f62121c);
        paymentConfirmRequestData.setPay_type(this.k);
        paymentConfirmRequestData.setCurrency(this.m);
        return paymentConfirmRequestData;
    }

    public String b() {
        return this.f62125g;
    }

    public void c(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        dataRes.timestamp.intValue();
        this.f62119a = dataRes.goods_name;
        this.f62120b = dataRes.scene_id.intValue();
        this.f62121c = dataRes.goods_user_level.intValue();
        this.f62122d = dataRes.goods_duration.intValue();
        this.f62123e = dataRes.goods_pic;
        this.f62124f = dataRes.terminal.intValue();
        this.f62125g = dataRes.order_id;
        this.f62126h = dataRes.goods_unit;
        this.f62127i = dataRes.tdou_num.intValue();
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
