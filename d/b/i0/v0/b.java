package d.b.i0.v0;

import tbclient.GoodsWin;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Integer f61974a;

    /* renamed from: b  reason: collision with root package name */
    public String f61975b;

    public boolean a() {
        return this.f61974a.intValue() == 1;
    }

    public void b(GoodsWin goodsWin) {
        this.f61974a = goodsWin.show;
        this.f61975b = goodsWin.goods_url;
    }
}
