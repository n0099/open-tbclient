package d.a.n0.v0.d;

import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import tbclient.PlaceOrder.DataRes;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f65991a;

    /* renamed from: b  reason: collision with root package name */
    public int f65992b;

    /* renamed from: c  reason: collision with root package name */
    public int f65993c;

    /* renamed from: d  reason: collision with root package name */
    public long f65994d;

    /* renamed from: e  reason: collision with root package name */
    public String f65995e;

    /* renamed from: f  reason: collision with root package name */
    public int f65996f;

    /* renamed from: g  reason: collision with root package name */
    public String f65997g;

    /* renamed from: h  reason: collision with root package name */
    public String f65998h;

    /* renamed from: i  reason: collision with root package name */
    public long f65999i;
    public int j;
    public int k;
    public long l;
    public int m;

    public PaymentConfirmRequestData a() {
        PaymentConfirmRequestData paymentConfirmRequestData = new PaymentConfirmRequestData();
        paymentConfirmRequestData.setTdou_num(this.f65999i);
        paymentConfirmRequestData.setOpen_id(this.l);
        paymentConfirmRequestData.setOrder_id(this.f65997g);
        paymentConfirmRequestData.setScene_id(this.f65992b);
        paymentConfirmRequestData.setGoods_name(this.f65991a);
        paymentConfirmRequestData.setGoods_pic(this.f65995e);
        paymentConfirmRequestData.setTerminal("" + this.f65996f);
        paymentConfirmRequestData.setGoods_num((long) this.j);
        paymentConfirmRequestData.setGoods_unit(this.f65998h);
        paymentConfirmRequestData.setGoods_duration(this.f65994d);
        paymentConfirmRequestData.setGoods_user_level(this.f65993c);
        paymentConfirmRequestData.setPay_type(this.k);
        paymentConfirmRequestData.setCurrency(this.m);
        return paymentConfirmRequestData;
    }

    public String b() {
        return this.f65997g;
    }

    public void c(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        dataRes.timestamp.intValue();
        this.f65991a = dataRes.goods_name;
        this.f65992b = dataRes.scene_id.intValue();
        this.f65993c = dataRes.goods_user_level.intValue();
        this.f65994d = dataRes.goods_duration.intValue();
        this.f65995e = dataRes.goods_pic;
        this.f65996f = dataRes.terminal.intValue();
        this.f65997g = dataRes.order_id;
        this.f65998h = dataRes.goods_unit;
        this.f65999i = dataRes.tdou_num.intValue();
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
