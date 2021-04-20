package d.b.i0.w0;

import tbclient.GoodsWin;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Integer f63640a;

    /* renamed from: b  reason: collision with root package name */
    public String f63641b;

    public boolean a() {
        return this.f63640a.intValue() == 1;
    }

    public void b(GoodsWin goodsWin) {
        this.f63640a = goodsWin.show;
        this.f63641b = goodsWin.goods_url;
    }
}
