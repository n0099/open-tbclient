package d.b.i0.t0;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
import tbclient.EsportStatic;
/* loaded from: classes4.dex */
public class b implements n {
    public static final BdUniqueId i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f62554e;

    /* renamed from: f  reason: collision with root package name */
    public List<a> f62555f;

    /* renamed from: g  reason: collision with root package name */
    public String f62556g;

    /* renamed from: h  reason: collision with root package name */
    public String f62557h;

    public int a() {
        return this.f62554e;
    }

    public List<a> e() {
        return this.f62555f;
    }

    public void f(Esport esport) {
        if (esport != null) {
            this.f62554e = esport.floor_no.intValue();
            EsportStatic esportStatic = esport._static;
            if (esportStatic != null) {
                this.f62556g = esportStatic.img;
                this.f62557h = esportStatic.url;
            }
            this.f62555f = new ArrayList();
            if (!StringUtils.isNull(this.f62556g)) {
                a aVar = new a();
                aVar.i(this.f62556g);
                aVar.j(this.f62557h);
                this.f62555f.add(aVar);
            }
            if (ListUtils.isEmpty(esport.billboard)) {
                return;
            }
            for (EsportRank esportRank : esport.billboard) {
                a aVar2 = new a();
                aVar2.h(esportRank);
                this.f62555f.add(aVar2);
            }
        }
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return i;
    }
}
