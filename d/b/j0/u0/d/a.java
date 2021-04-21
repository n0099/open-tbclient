package d.b.j0.u0.d;

import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import tbclient.PlaceOrder.DataRes;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f63179a;

    /* renamed from: b  reason: collision with root package name */
    public int f63180b;

    /* renamed from: c  reason: collision with root package name */
    public int f63181c;

    /* renamed from: d  reason: collision with root package name */
    public long f63182d;

    /* renamed from: e  reason: collision with root package name */
    public String f63183e;

    /* renamed from: f  reason: collision with root package name */
    public int f63184f;

    /* renamed from: g  reason: collision with root package name */
    public String f63185g;

    /* renamed from: h  reason: collision with root package name */
    public String f63186h;
    public long i;
    public int j;
    public int k;
    public long l;

    public PaymentConfirmRequestData a() {
        PaymentConfirmRequestData paymentConfirmRequestData = new PaymentConfirmRequestData();
        paymentConfirmRequestData.setTdou_num(this.i);
        paymentConfirmRequestData.setOpen_id(this.l);
        paymentConfirmRequestData.setOrder_id(this.f63185g);
        paymentConfirmRequestData.setScene_id(this.f63180b);
        paymentConfirmRequestData.setGoods_name(this.f63179a);
        paymentConfirmRequestData.setGoods_pic(this.f63183e);
        paymentConfirmRequestData.setTerminal("" + this.f63184f);
        paymentConfirmRequestData.setGoods_num((long) this.j);
        paymentConfirmRequestData.setGoods_unit(this.f63186h);
        paymentConfirmRequestData.setGoods_duration(this.f63182d);
        paymentConfirmRequestData.setGoods_user_level(this.f63181c);
        paymentConfirmRequestData.setPay_type(this.k);
        return paymentConfirmRequestData;
    }

    public String b() {
        return this.f63185g;
    }

    public void c(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        dataRes.timestamp.intValue();
        this.f63179a = dataRes.goods_name;
        this.f63180b = dataRes.scene_id.intValue();
        this.f63181c = dataRes.goods_user_level.intValue();
        this.f63182d = dataRes.goods_duration.intValue();
        this.f63183e = dataRes.goods_pic;
        this.f63184f = dataRes.terminal.intValue();
        this.f63185g = dataRes.order_id;
        this.f63186h = dataRes.goods_unit;
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
