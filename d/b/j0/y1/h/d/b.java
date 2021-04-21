package d.b.j0.y1.h.d;

import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.managers.SingleThreadEmotionHorizontalAdater;
import d.b.j0.y1.h.f.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public SingleThreadEmotionHorizontalAdater f64583a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f64584b;

    /* renamed from: c  reason: collision with root package name */
    public e f64585c;

    /* renamed from: d  reason: collision with root package name */
    public List<EmotionPackageData> f64586d;

    public b(TbPageContext<?> tbPageContext, BdListView bdListView) {
        this.f64584b = bdListView;
        e eVar = new e(tbPageContext);
        this.f64585c = eVar;
        eVar.c(TbadkCoreApplication.getInst().getSkinType());
        this.f64584b.addHeaderView(this.f64585c.b());
        this.f64586d = new ArrayList();
        SingleThreadEmotionHorizontalAdater singleThreadEmotionHorizontalAdater = new SingleThreadEmotionHorizontalAdater(this.f64586d, tbPageContext);
        this.f64583a = singleThreadEmotionHorizontalAdater;
        this.f64584b.setAdapter((ListAdapter) singleThreadEmotionHorizontalAdater);
    }

    public void a(List<EmotionPackageData> list) {
        e eVar;
        if (list == null || (eVar = this.f64585c) == null || this.f64583a == null) {
            return;
        }
        eVar.d(Integer.valueOf(list.size()));
        this.f64586d.clear();
        if (list != null) {
            this.f64586d.addAll(list);
        }
        this.f64583a.notifyDataSetChanged();
    }
}
