package d.a.o0.v.j.g.d.c;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.adapter.AlaEnterEffectAdapter;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.adapter.AlaEnterEffectCategoryAdapter;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f66003a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f66004b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.k.e.a> f66005c;

    /* renamed from: d  reason: collision with root package name */
    public AlaEnterEffectAdapter f66006d;

    /* renamed from: e  reason: collision with root package name */
    public AlaEnterEffectCategoryAdapter f66007e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f66008f;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.f66003a = tbPageContext;
        this.f66004b = bdTypeListView;
        a();
    }

    public final void a() {
        this.f66005c = new ArrayList();
        AlaEnterEffectAdapter alaEnterEffectAdapter = new AlaEnterEffectAdapter(this.f66003a.getPageActivity());
        this.f66006d = alaEnterEffectAdapter;
        this.f66005c.add(alaEnterEffectAdapter);
        AlaEnterEffectCategoryAdapter alaEnterEffectCategoryAdapter = new AlaEnterEffectCategoryAdapter(this.f66003a.getPageActivity());
        this.f66007e = alaEnterEffectCategoryAdapter;
        this.f66005c.add(alaEnterEffectCategoryAdapter);
        this.f66004b.a(this.f66005c);
    }

    public void b() {
        for (d.a.c.k.e.a aVar : this.f66005c) {
            aVar.L();
        }
    }

    public void c(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f66004b.setData(list);
        this.f66008f = this.f66004b.getData();
    }

    public void d(String str, int i2) {
        List<n> list;
        if (StringUtils.isNull(str) || (list = this.f66008f) == null) {
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
        if (TextUtils.isEmpty(str) || (list = this.f66008f) == null) {
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
        if (TextUtils.isEmpty(str) || (list = this.f66008f) == null) {
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
