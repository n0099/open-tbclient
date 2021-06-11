package d.a.n0.z1.h.d;

import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.managers.SingleThreadEmotionHorizontalAdater;
import d.a.n0.z1.h.f.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public SingleThreadEmotionHorizontalAdater f67469a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f67470b;

    /* renamed from: c  reason: collision with root package name */
    public e f67471c;

    /* renamed from: d  reason: collision with root package name */
    public List<EmotionPackageData> f67472d;

    public b(TbPageContext<?> tbPageContext, BdListView bdListView) {
        this.f67470b = bdListView;
        e eVar = new e(tbPageContext);
        this.f67471c = eVar;
        eVar.c(TbadkCoreApplication.getInst().getSkinType());
        this.f67470b.addHeaderView(this.f67471c.b());
        this.f67472d = new ArrayList();
        SingleThreadEmotionHorizontalAdater singleThreadEmotionHorizontalAdater = new SingleThreadEmotionHorizontalAdater(this.f67472d, tbPageContext);
        this.f67469a = singleThreadEmotionHorizontalAdater;
        this.f67470b.setAdapter((ListAdapter) singleThreadEmotionHorizontalAdater);
    }

    public void a(List<EmotionPackageData> list) {
        e eVar;
        if (list == null || (eVar = this.f67471c) == null || this.f67469a == null) {
            return;
        }
        eVar.d(Integer.valueOf(list.size()));
        this.f67472d.clear();
        if (list != null) {
            this.f67472d.addAll(list);
        }
        this.f67469a.notifyDataSetChanged();
    }
}
