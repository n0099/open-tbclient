package d.a.m0.r.q;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class v implements Comparable<v> {

    /* renamed from: e  reason: collision with root package name */
    public int f50136e;

    /* renamed from: f  reason: collision with root package name */
    public int f50137f;

    /* renamed from: g  reason: collision with root package name */
    public String f50138g;

    /* renamed from: h  reason: collision with root package name */
    public String f50139h;

    /* renamed from: i  reason: collision with root package name */
    public String f50140i;
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
        this.f50136e = i2;
        this.f50137f = i3;
    }

    public static v b(TbLinkSpanGroup tbLinkSpanGroup, d.a.n0.x0.a aVar) {
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
        vVar.f50139h = str;
        vVar.f50138g = aVar.c();
        vVar.q = aVar.a();
        if (!ListUtils.isEmpty(aVar.b()) && aVar.b().get(0) != null) {
            vVar.f50140i = aVar.b().get(0).a();
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

    public static v c(TbLinkSpanGroup tbLinkSpanGroup, d.a.m0.r.f0.p.d dVar) {
        if (tbLinkSpanGroup == null) {
            return null;
        }
        v vVar = new v(tbLinkSpanGroup.e(), 1);
        if (dVar == null) {
            return vVar;
        }
        vVar.f50138g = dVar.f49782e;
        vVar.f50140i = dVar.f49781d;
        vVar.p = dVar.f49783f;
        vVar.j = dVar.f49784g;
        vVar.k = dVar.f49780c;
        vVar.r = dVar.f49785h;
        String str = dVar.f49786i;
        vVar.m = dVar.f49779b == 1;
        vVar.s = dVar.f49779b;
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
