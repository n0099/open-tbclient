package d.b.j0.t.j.g.d.c;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.adapter.AlaEnterEffectAdapter;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.adapter.AlaEnterEffectCategoryAdapter;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import d.b.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62948a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f62949b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.c.j.e.a> f62950c;

    /* renamed from: d  reason: collision with root package name */
    public AlaEnterEffectAdapter f62951d;

    /* renamed from: e  reason: collision with root package name */
    public AlaEnterEffectCategoryAdapter f62952e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f62953f;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.f62948a = tbPageContext;
        this.f62949b = bdTypeListView;
        a();
    }

    public final void a() {
        this.f62950c = new ArrayList();
        AlaEnterEffectAdapter alaEnterEffectAdapter = new AlaEnterEffectAdapter(this.f62948a.getPageActivity());
        this.f62951d = alaEnterEffectAdapter;
        this.f62950c.add(alaEnterEffectAdapter);
        AlaEnterEffectCategoryAdapter alaEnterEffectCategoryAdapter = new AlaEnterEffectCategoryAdapter(this.f62948a.getPageActivity());
        this.f62952e = alaEnterEffectCategoryAdapter;
        this.f62950c.add(alaEnterEffectCategoryAdapter);
        this.f62949b.a(this.f62950c);
    }

    public void b() {
        for (d.b.c.j.e.a aVar : this.f62950c) {
            aVar.L();
        }
    }

    public void c(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f62949b.setData(list);
        this.f62953f = this.f62949b.getData();
    }

    public void d(String str, int i) {
        List<n> list;
        if (StringUtils.isNull(str) || (list = this.f62953f) == null) {
            return;
        }
        for (n nVar : list) {
            if (nVar instanceof AlaEnterEffectData) {
                AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) nVar;
                if (alaEnterEffectData.type == 1 && str.equals(alaEnterEffectData.gift.giftId)) {
                    alaEnterEffectData.downLoadStatus = i;
                    b();
                }
            }
        }
    }

    public void e(String str, boolean z) {
        List<n> list;
        if (TextUtils.isEmpty(str) || (list = this.f62953f) == null) {
            return;
        }
        for (n nVar : list) {
            if (nVar instanceof AlaEnterEffectData) {
                AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) nVar;
                if (str.equals(alaEnterEffectData.id)) {
                    alaEnterEffectData.isOwn = z;
                    b();
                    return;
                }
            }
        }
    }

    public void f(String str, boolean z) {
        List<n> list;
        if (TextUtils.isEmpty(str) || (list = this.f62953f) == null) {
            return;
        }
        for (n nVar : list) {
            if (nVar instanceof AlaEnterEffectData) {
                AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) nVar;
                if (str.equals(alaEnterEffectData.id)) {
                    alaEnterEffectData.use_status = z ? 1 : 0;
                } else {
                    alaEnterEffectData.use_status = 0;
                }
                b();
            }
        }
    }
}
