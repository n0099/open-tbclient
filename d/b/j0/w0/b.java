package d.b.j0.w0;

import tbclient.GoodsWin;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Integer f64061a;

    /* renamed from: b  reason: collision with root package name */
    public String f64062b;

    public boolean a() {
        return this.f64061a.intValue() == 1;
    }

    public void b(GoodsWin goodsWin) {
        this.f64061a = goodsWin.show;
        this.f64062b = goodsWin.goods_url;
    }
}
