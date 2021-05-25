package d.a.n0.v.j.g.d.c;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.adapter.AlaEnterEffectAdapter;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.adapter.AlaEnterEffectCategoryAdapter;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62163a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f62164b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.j.e.a> f62165c;

    /* renamed from: d  reason: collision with root package name */
    public AlaEnterEffectAdapter f62166d;

    /* renamed from: e  reason: collision with root package name */
    public AlaEnterEffectCategoryAdapter f62167e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f62168f;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.f62163a = tbPageContext;
        this.f62164b = bdTypeListView;
        a();
    }

    public final void a() {
        this.f62165c = new ArrayList();
        AlaEnterEffectAdapter alaEnterEffectAdapter = new AlaEnterEffectAdapter(this.f62163a.getPageActivity());
        this.f62166d = alaEnterEffectAdapter;
        this.f62165c.add(alaEnterEffectAdapter);
        AlaEnterEffectCategoryAdapter alaEnterEffectCategoryAdapter = new AlaEnterEffectCategoryAdapter(this.f62163a.getPageActivity());
        this.f62167e = alaEnterEffectCategoryAdapter;
        this.f62165c.add(alaEnterEffectCategoryAdapter);
        this.f62164b.a(this.f62165c);
    }

    public void b() {
        for (d.a.c.j.e.a aVar : this.f62165c) {
            aVar.K();
        }
    }

    public void c(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f62164b.setData(list);
        this.f62168f = this.f62164b.getData();
    }

    public void d(String str, int i2) {
        List<n> list;
        if (StringUtils.isNull(str) || (list = this.f62168f) == null) {
            return;
        }
        for (n nVar : list) {
            if (nVar instanceof AlaEnterEffectData) {
                AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) nVar;
                if (alaEnterEffectData.type == 1 && str.equals(alaEnterEffectData.gift.giftId)) {
                    alaEnterEffectData.downLoadStatus = i2;
                    b();
                }
            }
        }
    }

    public void e(String str, boolean z) {
        List<n> list;
        if (TextUtils.isEmpty(str) || (list = this.f62168f) == null) {
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
        if (TextUtils.isEmpty(str) || (list = this.f62168f) == null) {
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
