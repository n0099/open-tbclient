package d.a.j0.t0;

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
    public static final BdUniqueId f61179i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f61180e;

    /* renamed from: f  reason: collision with root package name */
    public List<a> f61181f;

    /* renamed from: g  reason: collision with root package name */
    public String f61182g;

    /* renamed from: h  reason: collision with root package name */
    public String f61183h;

    public int c() {
        return this.f61180e;
    }

    public List<a> e() {
        return this.f61181f;
    }

    public void f(Esport esport) {
        if (esport != null) {
            this.f61180e = esport.floor_no.intValue();
            EsportStatic esportStatic = esport._static;
            if (esportStatic != null) {
                this.f61182g = esportStatic.img;
                this.f61183h = esportStatic.url;
            }
            this.f61181f = new ArrayList();
            if (!StringUtils.isNull(this.f61182g)) {
                a aVar = new a();
                aVar.i(this.f61182g);
                aVar.j(this.f61183h);
                this.f61181f.add(aVar);
            }
            if (ListUtils.isEmpty(esport.billboard)) {
                return;
            }
            for (EsportRank esportRank : esport.billboard) {
                a aVar2 = new a();
                aVar2.h(esportRank);
                this.f61181f.add(aVar2);
            }
        }
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f61179i;
    }
}
