package d.a.o0.u0;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
import tbclient.EsportStatic;
/* loaded from: classes4.dex */
public class b implements n {

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f65148i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f65149e;

    /* renamed from: f  reason: collision with root package name */
    public List<a> f65150f;

    /* renamed from: g  reason: collision with root package name */
    public String f65151g;

    /* renamed from: h  reason: collision with root package name */
    public String f65152h;

    public int b() {
        return this.f65149e;
    }

    public List<a> c() {
        return this.f65150f;
    }

    public void e(Esport esport) {
        if (esport != null) {
            this.f65149e = esport.floor_no.intValue();
            EsportStatic esportStatic = esport._static;
            if (esportStatic != null) {
                this.f65151g = esportStatic.img;
                this.f65152h = esportStatic.url;
            }
            this.f65150f = new ArrayList();
            if (!StringUtils.isNull(this.f65151g)) {
                a aVar = new a();
                aVar.i(this.f65151g);
                aVar.j(this.f65152h);
                this.f65150f.add(aVar);
            }
            if (ListUtils.isEmpty(esport.billboard)) {
                return;
            }
            for (EsportRank esportRank : esport.billboard) {
                a aVar2 = new a();
                aVar2.h(esportRank);
                this.f65150f.add(aVar2);
            }
        }
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f65148i;
    }
}
