package d.a.j0.u0.d;

import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import tbclient.PlaceOrder.DataRes;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f61395a;

    /* renamed from: b  reason: collision with root package name */
    public int f61396b;

    /* renamed from: c  reason: collision with root package name */
    public int f61397c;

    /* renamed from: d  reason: collision with root package name */
    public long f61398d;

    /* renamed from: e  reason: collision with root package name */
    public String f61399e;

    /* renamed from: f  reason: collision with root package name */
    public int f61400f;

    /* renamed from: g  reason: collision with root package name */
    public String f61401g;

    /* renamed from: h  reason: collision with root package name */
    public String f61402h;

    /* renamed from: i  reason: collision with root package name */
    public long f61403i;
    public int j;
    public int k;
    public long l;
    public int m;

    public PaymentConfirmRequestData a() {
        PaymentConfirmRequestData paymentConfirmRequestData = new PaymentConfirmRequestData();
        paymentConfirmRequestData.setTdou_num(this.f61403i);
        paymentConfirmRequestData.setOpen_id(this.l);
        paymentConfirmRequestData.setOrder_id(this.f61401g);
        paymentConfirmRequestData.setScene_id(this.f61396b);
        paymentConfirmRequestData.setGoods_name(this.f61395a);
        paymentConfirmRequestData.setGoods_pic(this.f61399e);
        paymentConfirmRequestData.setTerminal("" + this.f61400f);
        paymentConfirmRequestData.setGoods_num((long) this.j);
        paymentConfirmRequestData.setGoods_unit(this.f61402h);
        paymentConfirmRequestData.setGoods_duration(this.f61398d);
        paymentConfirmRequestData.setGoods_user_level(this.f61397c);
        paymentConfirmRequestData.setPay_type(this.k);
        paymentConfirmRequestData.setCurrency(this.m);
        return paymentConfirmRequestData;
    }

    public String b() {
        return this.f61401g;
    }

    public void c(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        dataRes.timestamp.intValue();
        this.f61395a = dataRes.goods_name;
        this.f61396b = dataRes.scene_id.intValue();
        this.f61397c = dataRes.goods_user_level.intValue();
        this.f61398d = dataRes.goods_duration.intValue();
        this.f61399e = dataRes.goods_pic;
        this.f61400f = dataRes.terminal.intValue();
        this.f61401g = dataRes.order_id;
        this.f61402h = dataRes.goods_unit;
        this.f61403i = dataRes.tdou_num.intValue();
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
