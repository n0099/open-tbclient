package d.b.h0.r.q;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class v implements Comparable<v> {

    /* renamed from: e  reason: collision with root package name */
    public int f51304e;

    /* renamed from: f  reason: collision with root package name */
    public int f51305f;

    /* renamed from: g  reason: collision with root package name */
    public String f51306g;

    /* renamed from: h  reason: collision with root package name */
    public String f51307h;
    public String i;
    public String j;
    public String k;
    public String l;
    public boolean m;
    public String n;
    public String o;
    public String p;
    public String q;
    public boolean r;
    public int s;
    public int t;

    public v(int i, int i2) {
        this.f51304e = i;
        this.f51305f = i2;
    }

    public static v b(TbLinkSpanGroup tbLinkSpanGroup, d.b.i0.w0.a aVar) {
        String str;
        if (tbLinkSpanGroup == null) {
            return null;
        }
        v vVar = new v(tbLinkSpanGroup.e(), 2);
        if (aVar == null) {
            return vVar;
        }
        if (TextUtils.isEmpty(aVar.f())) {
            str = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
        } else {
            str = aVar.f() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
        }
        vVar.f51307h = str;
        vVar.f51306g = aVar.c();
        vVar.q = aVar.a();
        if (!ListUtils.isEmpty(aVar.b()) && aVar.b().get(0) != null) {
            vVar.i = aVar.b().get(0).a();
        }
        vVar.p = aVar.f();
        vVar.j = aVar.d();
        if (aVar.e() != null) {
            vVar.n = aVar.e().a();
            vVar.o = aVar.e().b();
        }
        tbLinkSpanGroup.y(vVar);
        return vVar;
    }

    public static v c(TbLinkSpanGroup tbLinkSpanGroup, d.b.h0.r.f0.p.d dVar) {
        if (tbLinkSpanGroup == null) {
            return null;
        }
        v vVar = new v(tbLinkSpanGroup.e(), 1);
        if (dVar == null) {
            return vVar;
        }
        vVar.f51306g = dVar.f50960e;
        vVar.i = dVar.f50959d;
        vVar.p = dVar.f50961f;
        vVar.j = dVar.f50962g;
        vVar.k = dVar.f50958c;
        vVar.r = dVar.f50963h;
        String str = dVar.i;
        vVar.m = dVar.f50957b == 1;
        vVar.s = dVar.f50957b;
        tbLinkSpanGroup.y(vVar);
        return vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull v vVar) {
        return this.t - vVar.t;
    }
}
