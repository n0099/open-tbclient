package d.b.i0.r2.z.c.a;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import d.b.i0.i1.o.l.j;
import d.b.i0.r2.b0.d;
import d.b.i0.r2.b0.e;
import d.b.i0.r2.b0.h;
import d.b.i0.r2.i;
import d.b.i0.r2.t;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class c implements i {

    /* renamed from: a  reason: collision with root package name */
    public String f60000a;

    /* renamed from: b  reason: collision with root package name */
    public String f60001b;

    /* renamed from: c  reason: collision with root package name */
    public j f60002c;

    /* renamed from: d  reason: collision with root package name */
    public AdvertAppInfo f60003d;

    /* loaded from: classes5.dex */
    public class a implements d.b.i0.i1.o.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo.ILegoAdvert f60004a;

        public a(AdvertAppInfo.ILegoAdvert iLegoAdvert) {
            this.f60004a = iLegoAdvert;
        }

        @Override // d.b.i0.i1.o.a
        public void a(int i, HashMap<String, Object> hashMap) {
            if (i == 0 || c.this.f60003d == null) {
                return;
            }
            String str = "image";
            if (hashMap != null) {
                String str2 = (String) hashMap.get("da_area");
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
            }
            if (t.p(i)) {
                d.d(c.this.f60003d, 0, str, i);
            } else {
                d.j(c.this.f60003d, 0, null, null, str);
            }
            d.b.i0.i1.o.h.c.h(d.b.i0.i1.o.h.c.e(this.f60004a.getAdvertAppInfo()));
        }

        @Override // d.b.i0.i1.o.a
        public void b(String str, String str2, HashMap<String, Object> hashMap) {
        }
    }

    public c(@NonNull TbPageContext<?> tbPageContext, @NonNull AdvertAppInfo.ILegoAdvert iLegoAdvert, int i, boolean z, String str, String str2) {
        this.f60003d = iLegoAdvert.getAdvertAppInfo();
        this.f60000a = str;
        this.f60001b = str2;
        b bVar = new b(tbPageContext);
        bVar.setBusinessType(i);
        bVar.setFromCDN(z);
        bVar.c(iLegoAdvert);
        bVar.setAfterClickSchemeListener(new a(iLegoAdvert));
        this.f60002c = bVar;
    }

    @Override // d.b.i0.r2.i
    public void a(DragImageView.h hVar) {
        this.f60002c.a(hVar);
    }

    @Override // d.b.i0.r2.i
    public View b() {
        return this.f60002c.b();
    }

    public void d(String str) {
        d.b.h0.u.a.l().u(this.f60003d, this.f60000a, d.b.b.e.m.b.f(this.f60001b, 0L), "PIC_PAGE", str, 1);
    }

    @Override // d.b.i0.r2.i
    public void onAdShow() {
        AdvertAppInfo advertAppInfo = this.f60003d;
        if (advertAppInfo.g4) {
            d.b.i0.o.d.a.i().k(d.b.i0.o.d.a.g(this.f60003d.e4));
            e.b().d(h.b(this.f60003d, 103, 0));
            return;
        }
        d.b.i0.i1.o.h.c.g(d.b.i0.i1.o.h.c.e(advertAppInfo));
        d("show");
        e.b().d(h.b(this.f60003d, 3, 0));
    }

    @Override // d.b.i0.r2.i
    public void onDestroy() {
        this.f60002c.onDestroy();
    }
}
