package d.a.n0.t2.f0.d.a;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import d.a.n0.k1.o.l.j;
import d.a.n0.t2.i0.e;
import d.a.n0.t2.i0.g;
import d.a.n0.t2.l;
import d.a.n0.t2.y;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class d implements l {

    /* renamed from: a  reason: collision with root package name */
    public j f64804a;

    /* renamed from: b  reason: collision with root package name */
    public AdvertAppInfo f64805b;

    /* loaded from: classes5.dex */
    public class a implements d.a.n0.k1.o.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo.ILegoAdvert f64806a;

        public a(AdvertAppInfo.ILegoAdvert iLegoAdvert) {
            this.f64806a = iLegoAdvert;
        }

        @Override // d.a.n0.k1.o.a
        public void a(int i2, HashMap<String, Object> hashMap) {
            if (i2 == 0 || d.this.f64805b == null) {
                return;
            }
            String str = "image";
            if (hashMap != null) {
                String str2 = (String) hashMap.get("da_area");
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
            }
            if (y.p(i2)) {
                d.a.n0.t2.i0.d.e(d.this.f64805b, 0, str, i2);
            } else {
                d.a.n0.t2.i0.d.m(d.this.f64805b, 0, null, null, str);
            }
            d.a.n0.k1.o.h.c.h(d.a.n0.k1.o.h.c.e(this.f64806a.getAdvertAppInfo()));
        }
    }

    public d(@NonNull TbPageContext<?> tbPageContext, @NonNull AdvertAppInfo.ILegoAdvert iLegoAdvert, int i2, boolean z, String str, String str2) {
        this.f64805b = iLegoAdvert.getAdvertAppInfo();
        b bVar = new b(tbPageContext);
        bVar.setBusinessType(i2);
        bVar.setFromCDN(z);
        bVar.i(iLegoAdvert);
        bVar.setAfterClickSchemeListener(new a(iLegoAdvert));
        this.f64804a = bVar;
    }

    @Override // d.a.n0.t2.l
    public void a(DragImageView.h hVar) {
        this.f64804a.a(hVar);
    }

    @Override // d.a.n0.t2.l
    public View b() {
        return this.f64804a.b();
    }

    @Override // d.a.n0.t2.l
    public void onAdShow() {
        AdvertAppInfo advertAppInfo = this.f64805b;
        if (advertAppInfo.O3) {
            d.a.n0.q.e.a.i().k(d.a.n0.q.e.a.g(this.f64805b));
            e.b().d(g.b(this.f64805b, 103, 0));
            return;
        }
        d.a.n0.k1.o.h.c.g(d.a.n0.k1.o.h.c.e(advertAppInfo));
        e.b().d(g.b(this.f64805b, 3, 0));
    }

    @Override // d.a.n0.t2.l
    public void onDestroy() {
        this.f64804a.onDestroy();
    }
}
