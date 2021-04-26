package d.a.j0.w0;

import tbclient.GoodsWin;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Integer f62311a;

    /* renamed from: b  reason: collision with root package name */
    public String f62312b;

    public boolean a() {
        return this.f62311a.intValue() == 1;
    }

    public void b(GoodsWin goodsWin) {
        this.f62311a = goodsWin.show;
        this.f62312b = goodsWin.goods_url;
    }
}
