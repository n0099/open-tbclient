package d.a.i0.r.q;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class v implements Comparable<v> {

    /* renamed from: e  reason: collision with root package name */
    public int f49273e;

    /* renamed from: f  reason: collision with root package name */
    public int f49274f;

    /* renamed from: g  reason: collision with root package name */
    public String f49275g;

    /* renamed from: h  reason: collision with root package name */
    public String f49276h;

    /* renamed from: i  reason: collision with root package name */
    public String f49277i;
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

    public v(int i2, int i3) {
        this.f49273e = i2;
        this.f49274f = i3;
    }

    public static v b(TbLinkSpanGroup tbLinkSpanGroup, d.a.j0.w0.a aVar) {
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
        vVar.f49276h = str;
        vVar.f49275g = aVar.c();
        vVar.q = aVar.a();
        if (!ListUtils.isEmpty(aVar.b()) && aVar.b().get(0) != null) {
            vVar.f49277i = aVar.b().get(0).a();
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

    public static v c(TbLinkSpanGroup tbLinkSpanGroup, d.a.i0.r.f0.p.d dVar) {
        if (tbLinkSpanGroup == null) {
            return null;
        }
        v vVar = new v(tbLinkSpanGroup.e(), 1);
        if (dVar == null) {
            return vVar;
        }
        vVar.f49275g = dVar.f48909e;
        vVar.f49277i = dVar.f48908d;
        vVar.p = dVar.f48910f;
        vVar.j = dVar.f48911g;
        vVar.k = dVar.f48907c;
        vVar.r = dVar.f48912h;
        String str = dVar.f48913i;
        vVar.m = dVar.f48906b == 1;
        vVar.s = dVar.f48906b;
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
