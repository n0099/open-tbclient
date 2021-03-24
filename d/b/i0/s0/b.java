package d.b.i0.s0;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.b.j.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
import tbclient.EsportStatic;
/* loaded from: classes4.dex */
public class b implements n {
    public static final BdUniqueId i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f60139e;

    /* renamed from: f  reason: collision with root package name */
    public List<a> f60140f;

    /* renamed from: g  reason: collision with root package name */
    public String f60141g;

    /* renamed from: h  reason: collision with root package name */
    public String f60142h;

    public int a() {
        return this.f60139e;
    }

    public List<a> e() {
        return this.f60140f;
    }

    public void f(Esport esport) {
        if (esport != null) {
            this.f60139e = esport.floor_no.intValue();
            EsportStatic esportStatic = esport._static;
            if (esportStatic != null) {
                this.f60141g = esportStatic.img;
                this.f60142h = esportStatic.url;
            }
            this.f60140f = new ArrayList();
            if (!StringUtils.isNull(this.f60141g)) {
                a aVar = new a();
                aVar.i(this.f60141g);
                aVar.j(this.f60142h);
                this.f60140f.add(aVar);
            }
            if (ListUtils.isEmpty(esport.billboard)) {
                return;
            }
            for (EsportRank esportRank : esport.billboard) {
                a aVar2 = new a();
                aVar2.h(esportRank);
                this.f60140f.add(aVar2);
            }
        }
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return i;
    }
}
