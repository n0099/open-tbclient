package d.b.i0.t0.d;

import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import tbclient.PlaceOrder.DataRes;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f61068a;

    /* renamed from: b  reason: collision with root package name */
    public int f61069b;

    /* renamed from: c  reason: collision with root package name */
    public int f61070c;

    /* renamed from: d  reason: collision with root package name */
    public long f61071d;

    /* renamed from: e  reason: collision with root package name */
    public String f61072e;

    /* renamed from: f  reason: collision with root package name */
    public int f61073f;

    /* renamed from: g  reason: collision with root package name */
    public String f61074g;

    /* renamed from: h  reason: collision with root package name */
    public String f61075h;
    public long i;
    public int j;
    public int k;
    public long l;

    public PaymentConfirmRequestData a() {
        PaymentConfirmRequestData paymentConfirmRequestData = new PaymentConfirmRequestData();
        paymentConfirmRequestData.setTdou_num(this.i);
        paymentConfirmRequestData.setOpen_id(this.l);
        paymentConfirmRequestData.setOrder_id(this.f61074g);
        paymentConfirmRequestData.setScene_id(this.f61069b);
        paymentConfirmRequestData.setGoods_name(this.f61068a);
        paymentConfirmRequestData.setGoods_pic(this.f61072e);
        paymentConfirmRequestData.setTerminal("" + this.f61073f);
        paymentConfirmRequestData.setGoods_num((long) this.j);
        paymentConfirmRequestData.setGoods_unit(this.f61075h);
        paymentConfirmRequestData.setGoods_duration(this.f61071d);
        paymentConfirmRequestData.setGoods_user_level(this.f61070c);
        paymentConfirmRequestData.setPay_type(this.k);
        return paymentConfirmRequestData;
    }

    public String b() {
        return this.f61074g;
    }

    public void c(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        dataRes.timestamp.intValue();
        this.f61068a = dataRes.goods_name;
        this.f61069b = dataRes.scene_id.intValue();
        this.f61070c = dataRes.goods_user_level.intValue();
        this.f61071d = dataRes.goods_duration.intValue();
        this.f61072e = dataRes.goods_pic;
        this.f61073f = dataRes.terminal.intValue();
        this.f61074g = dataRes.order_id;
        this.f61075h = dataRes.goods_unit;
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
