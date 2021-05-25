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
    public SingleThreadEmotionHorizontalAdater f63751a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f63752b;

    /* renamed from: c  reason: collision with root package name */
    public e f63753c;

    /* renamed from: d  reason: collision with root package name */
    public List<EmotionPackageData> f63754d;

    public b(TbPageContext<?> tbPageContext, BdListView bdListView) {
        this.f63752b = bdListView;
        e eVar = new e(tbPageContext);
        this.f63753c = eVar;
        eVar.c(TbadkCoreApplication.getInst().getSkinType());
        this.f63752b.addHeaderView(this.f63753c.b());
        this.f63754d = new ArrayList();
        SingleThreadEmotionHorizontalAdater singleThreadEmotionHorizontalAdater = new SingleThreadEmotionHorizontalAdater(this.f63754d, tbPageContext);
        this.f63751a = singleThreadEmotionHorizontalAdater;
        this.f63752b.setAdapter((ListAdapter) singleThreadEmotionHorizontalAdater);
    }

    public void a(List<EmotionPackageData> list) {
        e eVar;
        if (list == null || (eVar = this.f63753c) == null || this.f63751a == null) {
            return;
        }
        eVar.d(Integer.valueOf(list.size()));
        this.f63754d.clear();
        if (list != null) {
            this.f63754d.addAll(list);
        }
        this.f63751a.notifyDataSetChanged();
    }
}
