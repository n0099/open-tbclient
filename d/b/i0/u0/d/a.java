package d.b.i0.u0.d;

import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import tbclient.PlaceOrder.DataRes;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f62758a;

    /* renamed from: b  reason: collision with root package name */
    public int f62759b;

    /* renamed from: c  reason: collision with root package name */
    public int f62760c;

    /* renamed from: d  reason: collision with root package name */
    public long f62761d;

    /* renamed from: e  reason: collision with root package name */
    public String f62762e;

    /* renamed from: f  reason: collision with root package name */
    public int f62763f;

    /* renamed from: g  reason: collision with root package name */
    public String f62764g;

    /* renamed from: h  reason: collision with root package name */
    public String f62765h;
    public long i;
    public int j;
    public int k;
    public long l;

    public PaymentConfirmRequestData a() {
        PaymentConfirmRequestData paymentConfirmRequestData = new PaymentConfirmRequestData();
        paymentConfirmRequestData.setTdou_num(this.i);
        paymentConfirmRequestData.setOpen_id(this.l);
        paymentConfirmRequestData.setOrder_id(this.f62764g);
        paymentConfirmRequestData.setScene_id(this.f62759b);
        paymentConfirmRequestData.setGoods_name(this.f62758a);
        paymentConfirmRequestData.setGoods_pic(this.f62762e);
        paymentConfirmRequestData.setTerminal("" + this.f62763f);
        paymentConfirmRequestData.setGoods_num((long) this.j);
        paymentConfirmRequestData.setGoods_unit(this.f62765h);
        paymentConfirmRequestData.setGoods_duration(this.f62761d);
        paymentConfirmRequestData.setGoods_user_level(this.f62760c);
        paymentConfirmRequestData.setPay_type(this.k);
        return paymentConfirmRequestData;
    }

    public String b() {
        return this.f62764g;
    }

    public void c(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        dataRes.timestamp.intValue();
        this.f62758a = dataRes.goods_name;
        this.f62759b = dataRes.scene_id.intValue();
        this.f62760c = dataRes.goods_user_level.intValue();
        this.f62761d = dataRes.goods_duration.intValue();
        this.f62762e = dataRes.goods_pic;
        this.f62763f = dataRes.terminal.intValue();
        this.f62764g = dataRes.order_id;
        this.f62765h = dataRes.goods_unit;
        this.i = dataRes.tdou_num.intValue();
        dataRes.goods_price.intValue();
        this.j = dataRes.goods_num.intValue();
        this.k = dataRes.pay_type.intValue();
        dataRes.user_id.longValue();
        dataRes.tb_timestamp.intValue();
        this.l = dataRes.open_id.longValue();
        dataRes.gift_count.intValue();
    }
}
