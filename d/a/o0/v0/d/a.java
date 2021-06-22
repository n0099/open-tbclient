package d.a.o0.v0.d;

import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import tbclient.PlaceOrder.DataRes;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f66116a;

    /* renamed from: b  reason: collision with root package name */
    public int f66117b;

    /* renamed from: c  reason: collision with root package name */
    public int f66118c;

    /* renamed from: d  reason: collision with root package name */
    public long f66119d;

    /* renamed from: e  reason: collision with root package name */
    public String f66120e;

    /* renamed from: f  reason: collision with root package name */
    public int f66121f;

    /* renamed from: g  reason: collision with root package name */
    public String f66122g;

    /* renamed from: h  reason: collision with root package name */
    public String f66123h;

    /* renamed from: i  reason: collision with root package name */
    public long f66124i;
    public int j;
    public int k;
    public long l;
    public int m;

    public PaymentConfirmRequestData a() {
        PaymentConfirmRequestData paymentConfirmRequestData = new PaymentConfirmRequestData();
        paymentConfirmRequestData.setTdou_num(this.f66124i);
        paymentConfirmRequestData.setOpen_id(this.l);
        paymentConfirmRequestData.setOrder_id(this.f66122g);
        paymentConfirmRequestData.setScene_id(this.f66117b);
        paymentConfirmRequestData.setGoods_name(this.f66116a);
        paymentConfirmRequestData.setGoods_pic(this.f66120e);
        paymentConfirmRequestData.setTerminal("" + this.f66121f);
        paymentConfirmRequestData.setGoods_num((long) this.j);
        paymentConfirmRequestData.setGoods_unit(this.f66123h);
        paymentConfirmRequestData.setGoods_duration(this.f66119d);
        paymentConfirmRequestData.setGoods_user_level(this.f66118c);
        paymentConfirmRequestData.setPay_type(this.k);
        paymentConfirmRequestData.setCurrency(this.m);
        return paymentConfirmRequestData;
    }

    public String b() {
        return this.f66122g;
    }

    public void c(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        dataRes.timestamp.intValue();
        this.f66116a = dataRes.goods_name;
        this.f66117b = dataRes.scene_id.intValue();
        this.f66118c = dataRes.goods_user_level.intValue();
        this.f66119d = dataRes.goods_duration.intValue();
        this.f66120e = dataRes.goods_pic;
        this.f66121f = dataRes.terminal.intValue();
        this.f66122g = dataRes.order_id;
        this.f66123h = dataRes.goods_unit;
        this.f66124i = dataRes.tdou_num.intValue();
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
