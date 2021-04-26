package d.a.j0.s2.e0.d.a;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import d.a.j0.j1.o.l.j;
import d.a.j0.s2.h0.e;
import d.a.j0.s2.h0.h;
import d.a.j0.s2.k;
import d.a.j0.s2.x;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class d implements k {

    /* renamed from: a  reason: collision with root package name */
    public String f60265a;

    /* renamed from: b  reason: collision with root package name */
    public String f60266b;

    /* renamed from: c  reason: collision with root package name */
    public j f60267c;

    /* renamed from: d  reason: collision with root package name */
    public AdvertAppInfo f60268d;

    /* loaded from: classes5.dex */
    public class a implements d.a.j0.j1.o.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo.ILegoAdvert f60269a;

        public a(AdvertAppInfo.ILegoAdvert iLegoAdvert) {
            this.f60269a = iLegoAdvert;
        }

        @Override // d.a.j0.j1.o.a
        public void a(int i2, HashMap<String, Object> hashMap) {
            if (i2 == 0 || d.this.f60268d == null) {
                return;
            }
            String str = "image";
            if (hashMap != null) {
                String str2 = (String) hashMap.get("da_area");
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
            }
            if (x.p(i2)) {
                d.a.j0.s2.h0.d.e(d.this.f60268d, 0, str, i2);
            } else {
                d.a.j0.s2.h0.d.m(d.this.f60268d, 0, null, null, str);
            }
            d.a.j0.j1.o.h.c.h(d.a.j0.j1.o.h.c.e(this.f60269a.getAdvertAppInfo()));
        }

        @Override // d.a.j0.j1.o.a
        public void b(String str, String str2, HashMap<String, Object> hashMap) {
        }
    }

    public d(@NonNull TbPageContext<?> tbPageContext, @NonNull AdvertAppInfo.ILegoAdvert iLegoAdvert, int i2, boolean z, String str, String str2) {
        this.f60268d = iLegoAdvert.getAdvertAppInfo();
        this.f60265a = str;
        this.f60266b = str2;
        b bVar = new b(tbPageContext);
        bVar.setBusinessType(i2);
        bVar.setFromCDN(z);
        bVar.g(iLegoAdvert);
        bVar.setAfterClickSchemeListener(new a(iLegoAdvert));
        this.f60267c = bVar;
    }

    @Override // d.a.j0.s2.k
    public void a(DragImageView.h hVar) {
        this.f60267c.a(hVar);
    }

    @Override // d.a.j0.s2.k
    public View b() {
        return this.f60267c.b();
    }

    public void d(String str) {
        d.a.i0.u.a.l().u(this.f60268d, this.f60265a, d.a.c.e.m.b.f(this.f60266b, 0L), "PIC_PAGE", str, 1);
    }

    @Override // d.a.j0.s2.k
    public void onAdShow() {
        AdvertAppInfo advertAppInfo = this.f60268d;
        if (advertAppInfo.g4) {
            d.a.j0.o.e.a.i().k(d.a.j0.o.e.a.g(this.f60268d.e4));
            e.b().d(h.b(this.f60268d, 103, 0));
            return;
        }
        d.a.j0.j1.o.h.c.g(d.a.j0.j1.o.h.c.e(advertAppInfo));
        d("show");
        e.b().d(h.b(this.f60268d, 3, 0));
    }

    @Override // d.a.j0.s2.k
    public void onDestroy() {
        this.f60267c.onDestroy();
    }
}
