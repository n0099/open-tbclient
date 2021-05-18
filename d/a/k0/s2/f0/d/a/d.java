package d.a.k0.s2.f0.d.a;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import d.a.k0.j1.o.l.j;
import d.a.k0.s2.i0.e;
import d.a.k0.s2.i0.g;
import d.a.k0.s2.l;
import d.a.k0.s2.y;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class d implements l {

    /* renamed from: a  reason: collision with root package name */
    public j f61010a;

    /* renamed from: b  reason: collision with root package name */
    public AdvertAppInfo f61011b;

    /* loaded from: classes5.dex */
    public class a implements d.a.k0.j1.o.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo.ILegoAdvert f61012a;

        public a(AdvertAppInfo.ILegoAdvert iLegoAdvert) {
            this.f61012a = iLegoAdvert;
        }

        @Override // d.a.k0.j1.o.a
        public void a(int i2, HashMap<String, Object> hashMap) {
            if (i2 == 0 || d.this.f61011b == null) {
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
                d.a.k0.s2.i0.d.e(d.this.f61011b, 0, str, i2);
            } else {
                d.a.k0.s2.i0.d.m(d.this.f61011b, 0, null, null, str);
            }
            d.a.k0.j1.o.h.c.h(d.a.k0.j1.o.h.c.e(this.f61012a.getAdvertAppInfo()));
        }
    }

    public d(@NonNull TbPageContext<?> tbPageContext, @NonNull AdvertAppInfo.ILegoAdvert iLegoAdvert, int i2, boolean z, String str, String str2) {
        this.f61011b = iLegoAdvert.getAdvertAppInfo();
        b bVar = new b(tbPageContext);
        bVar.setBusinessType(i2);
        bVar.setFromCDN(z);
        bVar.g(iLegoAdvert);
        bVar.setAfterClickSchemeListener(new a(iLegoAdvert));
        this.f61010a = bVar;
    }

    @Override // d.a.k0.s2.l
    public void a(DragImageView.h hVar) {
        this.f61010a.a(hVar);
    }

    @Override // d.a.k0.s2.l
    public View b() {
        return this.f61010a.b();
    }

    @Override // d.a.k0.s2.l
    public void onAdShow() {
        AdvertAppInfo advertAppInfo = this.f61011b;
        if (advertAppInfo.K3) {
            d.a.k0.o.e.a.i().k(d.a.k0.o.e.a.g(this.f61011b));
            e.b().d(g.b(this.f61011b, 103, 0));
            return;
        }
        d.a.k0.j1.o.h.c.g(d.a.k0.j1.o.h.c.e(advertAppInfo));
        e.b().d(g.b(this.f61011b, 3, 0));
    }

    @Override // d.a.k0.s2.l
    public void onDestroy() {
        this.f61010a.onDestroy();
    }
}
