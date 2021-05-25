package d.a.n0.u0;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
import tbclient.EsportStatic;
/* loaded from: classes4.dex */
public class b implements n {

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f61310i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f61311e;

    /* renamed from: f  reason: collision with root package name */
    public List<a> f61312f;

    /* renamed from: g  reason: collision with root package name */
    public String f61313g;

    /* renamed from: h  reason: collision with root package name */
    public String f61314h;

    public int c() {
        return this.f61311e;
    }

    public List<a> e() {
        return this.f61312f;
    }

    public void f(Esport esport) {
        if (esport != null) {
            this.f61311e = esport.floor_no.intValue();
            EsportStatic esportStatic = esport._static;
            if (esportStatic != null) {
                this.f61313g = esportStatic.img;
                this.f61314h = esportStatic.url;
            }
            this.f61312f = new ArrayList();
            if (!StringUtils.isNull(this.f61313g)) {
                a aVar = new a();
                aVar.i(this.f61313g);
                aVar.j(this.f61314h);
                this.f61312f.add(aVar);
            }
            if (ListUtils.isEmpty(esport.billboard)) {
                return;
            }
            for (EsportRank esportRank : esport.billboard) {
                a aVar2 = new a();
                aVar2.h(esportRank);
                this.f61312f.add(aVar2);
            }
        }
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f61310i;
    }
}
