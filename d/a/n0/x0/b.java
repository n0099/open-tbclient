package d.a.n0.x0;

import tbclient.GoodsWin;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Integer f63220a;

    /* renamed from: b  reason: collision with root package name */
    public String f63221b;

    public boolean a() {
        return this.f63220a.intValue() == 1;
    }

    public void b(GoodsWin goodsWin) {
        this.f63220a = goodsWin.show;
        this.f63221b = goodsWin.goods_url;
    }
}
