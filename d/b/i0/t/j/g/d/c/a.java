package d.b.i0.t.j.g.d.c;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.adapter.AlaEnterEffectAdapter;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.adapter.AlaEnterEffectCategoryAdapter;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import d.b.b.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60962a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f60963b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.b.j.e.a> f60964c;

    /* renamed from: d  reason: collision with root package name */
    public AlaEnterEffectAdapter f60965d;

    /* renamed from: e  reason: collision with root package name */
    public AlaEnterEffectCategoryAdapter f60966e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f60967f;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.f60962a = tbPageContext;
        this.f60963b = bdTypeListView;
        a();
    }

    public final void a() {
        this.f60964c = new ArrayList();
        AlaEnterEffectAdapter alaEnterEffectAdapter = new AlaEnterEffectAdapter(this.f60962a.getPageActivity());
        this.f60965d = alaEnterEffectAdapter;
        this.f60964c.add(alaEnterEffectAdapter);
        AlaEnterEffectCategoryAdapter alaEnterEffectCategoryAdapter = new AlaEnterEffectCategoryAdapter(this.f60962a.getPageActivity());
        this.f60966e = alaEnterEffectCategoryAdapter;
        this.f60964c.add(alaEnterEffectCategoryAdapter);
        this.f60963b.a(this.f60964c);
    }

    public void b() {
        for (d.b.b.j.e.a aVar : this.f60964c) {
            aVar.L();
        }
    }

    public void c(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f60963b.setData(list);
        this.f60967f = this.f60963b.getData();
    }

    public void d(String str, int i) {
        List<n> list;
        if (StringUtils.isNull(str) || (list = this.f60967f) == null) {
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
        if (TextUtils.isEmpty(str) || (list = this.f60967f) == null) {
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
        if (TextUtils.isEmpty(str) || (list = this.f60967f) == null) {
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
