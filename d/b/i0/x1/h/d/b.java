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
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public SingleThreadEmotionHorizontalAdater f62477a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f62478b;

    /* renamed from: c  reason: collision with root package name */
    public e f62479c;

    /* renamed from: d  reason: collision with root package name */
    public List<EmotionPackageData> f62480d;

    public b(TbPageContext<?> tbPageContext, BdListView bdListView) {
        this.f62478b = bdListView;
        e eVar = new e(tbPageContext);
        this.f62479c = eVar;
        eVar.c(TbadkCoreApplication.getInst().getSkinType());
        this.f62478b.addHeaderView(this.f62479c.b());
        this.f62480d = new ArrayList();
        SingleThreadEmotionHorizontalAdater singleThreadEmotionHorizontalAdater = new SingleThreadEmotionHorizontalAdater(this.f62480d, tbPageContext);
        this.f62477a = singleThreadEmotionHorizontalAdater;
        this.f62478b.setAdapter((ListAdapter) singleThreadEmotionHorizontalAdater);
    }

    public void a(List<EmotionPackageData> list) {
        e eVar;
        if (list == null || (eVar = this.f62479c) == null || this.f62477a == null) {
            return;
        }
        eVar.d(Integer.valueOf(list.size()));
        this.f62480d.clear();
        if (list != null) {
            this.f62480d.addAll(list);
        }
        this.f62477a.notifyDataSetChanged();
    }
}
