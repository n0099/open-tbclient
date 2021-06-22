package d.a.o0.z1.h.d;

import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.managers.SingleThreadEmotionHorizontalAdater;
import d.a.o0.z1.h.f.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public SingleThreadEmotionHorizontalAdater f67594a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f67595b;

    /* renamed from: c  reason: collision with root package name */
    public e f67596c;

    /* renamed from: d  reason: collision with root package name */
    public List<EmotionPackageData> f67597d;

    public b(TbPageContext<?> tbPageContext, BdListView bdListView) {
        this.f67595b = bdListView;
        e eVar = new e(tbPageContext);
        this.f67596c = eVar;
        eVar.c(TbadkCoreApplication.getInst().getSkinType());
        this.f67595b.addHeaderView(this.f67596c.b());
        this.f67597d = new ArrayList();
        SingleThreadEmotionHorizontalAdater singleThreadEmotionHorizontalAdater = new SingleThreadEmotionHorizontalAdater(this.f67597d, tbPageContext);
        this.f67594a = singleThreadEmotionHorizontalAdater;
        this.f67595b.setAdapter((ListAdapter) singleThreadEmotionHorizontalAdater);
    }

    public void a(List<EmotionPackageData> list) {
        e eVar;
        if (list == null || (eVar = this.f67596c) == null || this.f67594a == null) {
            return;
        }
        eVar.d(Integer.valueOf(list.size()));
        this.f67597d.clear();
        if (list != null) {
            this.f67597d.addAll(list);
        }
        this.f67594a.notifyDataSetChanged();
    }
}
