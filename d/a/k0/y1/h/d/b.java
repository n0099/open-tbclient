package d.a.k0.y1.h.d;

import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.managers.SingleThreadEmotionHorizontalAdater;
import d.a.k0.y1.h.f.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public SingleThreadEmotionHorizontalAdater f63587a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f63588b;

    /* renamed from: c  reason: collision with root package name */
    public e f63589c;

    /* renamed from: d  reason: collision with root package name */
    public List<EmotionPackageData> f63590d;

    public b(TbPageContext<?> tbPageContext, BdListView bdListView) {
        this.f63588b = bdListView;
        e eVar = new e(tbPageContext);
        this.f63589c = eVar;
        eVar.c(TbadkCoreApplication.getInst().getSkinType());
        this.f63588b.addHeaderView(this.f63589c.b());
        this.f63590d = new ArrayList();
        SingleThreadEmotionHorizontalAdater singleThreadEmotionHorizontalAdater = new SingleThreadEmotionHorizontalAdater(this.f63590d, tbPageContext);
        this.f63587a = singleThreadEmotionHorizontalAdater;
        this.f63588b.setAdapter((ListAdapter) singleThreadEmotionHorizontalAdater);
    }

    public void a(List<EmotionPackageData> list) {
        e eVar;
        if (list == null || (eVar = this.f63589c) == null || this.f63587a == null) {
            return;
        }
        eVar.d(Integer.valueOf(list.size()));
        this.f63590d.clear();
        if (list != null) {
            this.f63590d.addAll(list);
        }
        this.f63587a.notifyDataSetChanged();
    }
}
