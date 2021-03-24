package d.b.i0.x1.h.d;

import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.managers.SingleThreadEmotionHorizontalAdater;
import d.b.i0.x1.h.f.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public SingleThreadEmotionHorizontalAdater f62476a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f62477b;

    /* renamed from: c  reason: collision with root package name */
    public e f62478c;

    /* renamed from: d  reason: collision with root package name */
    public List<EmotionPackageData> f62479d;

    public b(TbPageContext<?> tbPageContext, BdListView bdListView) {
        this.f62477b = bdListView;
        e eVar = new e(tbPageContext);
        this.f62478c = eVar;
        eVar.c(TbadkCoreApplication.getInst().getSkinType());
        this.f62477b.addHeaderView(this.f62478c.b());
        this.f62479d = new ArrayList();
        SingleThreadEmotionHorizontalAdater singleThreadEmotionHorizontalAdater = new SingleThreadEmotionHorizontalAdater(this.f62479d, tbPageContext);
        this.f62476a = singleThreadEmotionHorizontalAdater;
        this.f62477b.setAdapter((ListAdapter) singleThreadEmotionHorizontalAdater);
    }

    public void a(List<EmotionPackageData> list) {
        e eVar;
        if (list == null || (eVar = this.f62478c) == null || this.f62476a == null) {
            return;
        }
        eVar.d(Integer.valueOf(list.size()));
        this.f62479d.clear();
        if (list != null) {
            this.f62479d.addAll(list);
        }
        this.f62476a.notifyDataSetChanged();
    }
}
