package d.b.j0.s2.c0.d.a;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import d.b.j0.j1.o.l.j;
import d.b.j0.s2.f0.e;
import d.b.j0.s2.f0.h;
import d.b.j0.s2.k;
import d.b.j0.s2.w;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class d implements k {

    /* renamed from: a  reason: collision with root package name */
    public String f62048a;

    /* renamed from: b  reason: collision with root package name */
    public String f62049b;

    /* renamed from: c  reason: collision with root package name */
    public j f62050c;

    /* renamed from: d  reason: collision with root package name */
    public AdvertAppInfo f62051d;

    /* loaded from: classes4.dex */
    public class a implements d.b.j0.j1.o.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo.ILegoAdvert f62052a;

        public a(AdvertAppInfo.ILegoAdvert iLegoAdvert) {
            this.f62052a = iLegoAdvert;
        }

        @Override // d.b.j0.j1.o.a
        public void a(int i, HashMap<String, Object> hashMap) {
            if (i == 0 || d.this.f62051d == null) {
                return;
            }
            String str = "image";
            if (hashMap != null) {
                String str2 = (String) hashMap.get("da_area");
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
            }
            if (w.p(i)) {
                d.b.j0.s2.f0.d.e(d.this.f62051d, 0, str, i);
            } else {
                d.b.j0.s2.f0.d.m(d.this.f62051d, 0, null, null, str);
            }
            d.b.j0.j1.o.h.c.h(d.b.j0.j1.o.h.c.e(this.f62052a.getAdvertAppInfo()));
        }

        @Override // d.b.j0.j1.o.a
        public void b(String str, String str2, HashMap<String, Object> hashMap) {
        }
    }

    public d(@NonNull TbPageContext<?> tbPageContext, @NonNull AdvertAppInfo.ILegoAdvert iLegoAdvert, int i, boolean z, String str, String str2) {
        this.f62051d = iLegoAdvert.getAdvertAppInfo();
        this.f62048a = str;
        this.f62049b = str2;
        b bVar = new b(tbPageContext);
        bVar.setBusinessType(i);
        bVar.setFromCDN(z);
        bVar.c(iLegoAdvert);
        bVar.setAfterClickSchemeListener(new a(iLegoAdvert));
        this.f62050c = bVar;
    }

    @Override // d.b.j0.s2.k
    public void a(DragImageView.h hVar) {
        this.f62050c.a(hVar);
    }

    @Override // d.b.j0.s2.k
    public View b() {
        return this.f62050c.b();
    }

    public void d(String str) {
        d.b.i0.u.a.l().u(this.f62051d, this.f62048a, d.b.c.e.m.b.f(this.f62049b, 0L), "PIC_PAGE", str, 1);
    }

    @Override // d.b.j0.s2.k
    public void onAdShow() {
        AdvertAppInfo advertAppInfo = this.f62051d;
        if (advertAppInfo.g4) {
            d.b.j0.o.e.a.i().k(d.b.j0.o.e.a.g(this.f62051d.e4));
            e.b().d(h.b(this.f62051d, 103, 0));
            return;
        }
        d.b.j0.j1.o.h.c.g(d.b.j0.j1.o.h.c.e(advertAppInfo));
        d("show");
        e.b().d(h.b(this.f62051d, 3, 0));
    }

    @Override // d.b.j0.s2.k
    public void onDestroy() {
        this.f62050c.onDestroy();
    }
}
