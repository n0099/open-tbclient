package d.b.i0.y1.h.d;

import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.managers.SingleThreadEmotionHorizontalAdater;
import d.b.i0.y1.h.f.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public SingleThreadEmotionHorizontalAdater f64162a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f64163b;

    /* renamed from: c  reason: collision with root package name */
    public e f64164c;

    /* renamed from: d  reason: collision with root package name */
    public List<EmotionPackageData> f64165d;

    public b(TbPageContext<?> tbPageContext, BdListView bdListView) {
        this.f64163b = bdListView;
        e eVar = new e(tbPageContext);
        this.f64164c = eVar;
        eVar.c(TbadkCoreApplication.getInst().getSkinType());
        this.f64163b.addHeaderView(this.f64164c.b());
        this.f64165d = new ArrayList();
        SingleThreadEmotionHorizontalAdater singleThreadEmotionHorizontalAdater = new SingleThreadEmotionHorizontalAdater(this.f64165d, tbPageContext);
        this.f64162a = singleThreadEmotionHorizontalAdater;
        this.f64163b.setAdapter((ListAdapter) singleThreadEmotionHorizontalAdater);
    }

    public void a(List<EmotionPackageData> list) {
        e eVar;
        if (list == null || (eVar = this.f64164c) == null || this.f64162a == null) {
            return;
        }
        eVar.d(Integer.valueOf(list.size()));
        this.f64165d.clear();
        if (list != null) {
            this.f64165d.addAll(list);
        }
        this.f64162a.notifyDataSetChanged();
    }
}
