package d.a.j0.y1.h.d;

import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.managers.SingleThreadEmotionHorizontalAdater;
import d.a.j0.y1.h.f.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public SingleThreadEmotionHorizontalAdater f62863a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f62864b;

    /* renamed from: c  reason: collision with root package name */
    public e f62865c;

    /* renamed from: d  reason: collision with root package name */
    public List<EmotionPackageData> f62866d;

    public b(TbPageContext<?> tbPageContext, BdListView bdListView) {
        this.f62864b = bdListView;
        e eVar = new e(tbPageContext);
        this.f62865c = eVar;
        eVar.c(TbadkCoreApplication.getInst().getSkinType());
        this.f62864b.addHeaderView(this.f62865c.b());
        this.f62866d = new ArrayList();
        SingleThreadEmotionHorizontalAdater singleThreadEmotionHorizontalAdater = new SingleThreadEmotionHorizontalAdater(this.f62866d, tbPageContext);
        this.f62863a = singleThreadEmotionHorizontalAdater;
        this.f62864b.setAdapter((ListAdapter) singleThreadEmotionHorizontalAdater);
    }

    public void a(List<EmotionPackageData> list) {
        e eVar;
        if (list == null || (eVar = this.f62865c) == null || this.f62863a == null) {
            return;
        }
        eVar.d(Integer.valueOf(list.size()));
        this.f62866d.clear();
        if (list != null) {
            this.f62866d.addAll(list);
        }
        this.f62863a.notifyDataSetChanged();
    }
}
