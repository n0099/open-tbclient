package d.a.k0.w0;

import tbclient.GoodsWin;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Integer f63035a;

    /* renamed from: b  reason: collision with root package name */
    public String f63036b;

    public boolean a() {
        return this.f63035a.intValue() == 1;
    }

    public void b(GoodsWin goodsWin) {
        this.f63035a = goodsWin.show;
        this.f63036b = goodsWin.goods_url;
    }
}
