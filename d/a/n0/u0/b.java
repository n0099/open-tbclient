package d.a.n0.u0;

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
    public static final BdUniqueId f65023i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f65024e;

    /* renamed from: f  reason: collision with root package name */
    public List<a> f65025f;

    /* renamed from: g  reason: collision with root package name */
    public String f65026g;

    /* renamed from: h  reason: collision with root package name */
    public String f65027h;

    public int b() {
        return this.f65024e;
    }

    public List<a> c() {
        return this.f65025f;
    }

    public void e(Esport esport) {
        if (esport != null) {
            this.f65024e = esport.floor_no.intValue();
            EsportStatic esportStatic = esport._static;
            if (esportStatic != null) {
                this.f65026g = esportStatic.img;
                this.f65027h = esportStatic.url;
            }
            this.f65025f = new ArrayList();
            if (!StringUtils.isNull(this.f65026g)) {
                a aVar = new a();
                aVar.i(this.f65026g);
                aVar.j(this.f65027h);
                this.f65025f.add(aVar);
            }
            if (ListUtils.isEmpty(esport.billboard)) {
                return;
            }
            for (EsportRank esportRank : esport.billboard) {
                a aVar2 = new a();
                aVar2.h(esportRank);
                this.f65025f.add(aVar2);
            }
        }
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f65023i;
    }
}
