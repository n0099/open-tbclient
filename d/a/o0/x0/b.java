package d.a.o0.x0;

import tbclient.GoodsWin;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Integer f67060a;

    /* renamed from: b  reason: collision with root package name */
    public String f67061b;

    public boolean a() {
        return this.f67060a.intValue() == 1;
    }

    public void b(GoodsWin goodsWin) {
        this.f67060a = goodsWin.show;
        this.f67061b = goodsWin.goods_url;
    }
}
