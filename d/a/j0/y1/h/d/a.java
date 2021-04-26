package d.a.j0.y1.h.d;

import android.util.Pair;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.managers.MyEmotionHorizontalAdater;
import d.a.j0.y1.h.f.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f62854a;

    /* renamed from: b  reason: collision with root package name */
    public MyEmotionHorizontalAdater f62855b;

    /* renamed from: c  reason: collision with root package name */
    public List<EmotionPackageData> f62856c;

    /* renamed from: d  reason: collision with root package name */
    public final List<C1686a> f62857d;

    /* renamed from: e  reason: collision with root package name */
    public c f62858e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.y1.h.b.a f62859f;

    /* renamed from: d.a.j0.y1.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1686a {

        /* renamed from: a  reason: collision with root package name */
        public int f62860a;

        /* renamed from: b  reason: collision with root package name */
        public int f62861b;

        /* renamed from: c  reason: collision with root package name */
        public int f62862c;

        public String toString() {
            return "id: " + this.f62860a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "firstVisibleItem: " + this.f62861b + StringUtil.ARRAY_ELEMENT_SEPARATOR + "padX: " + this.f62862c;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, d.a.j0.y1.h.b.a aVar) {
        this.f62854a = bdListView;
        c cVar = new c(tbPageContext);
        this.f62858e = cVar;
        cVar.b(TbadkCoreApplication.getInst().getSkinType());
        this.f62854a.addHeaderView(this.f62858e.a());
        this.f62856c = new ArrayList();
        this.f62857d = new ArrayList();
        MyEmotionHorizontalAdater myEmotionHorizontalAdater = new MyEmotionHorizontalAdater(this.f62856c, this.f62857d, tbPageContext);
        this.f62855b = myEmotionHorizontalAdater;
        this.f62859f = aVar;
        this.f62854a.setAdapter((ListAdapter) myEmotionHorizontalAdater);
    }

    public void a(int i2, int i3) {
        if (i2 < 0 || i2 >= this.f62856c.size() || i3 < 0 || i3 >= this.f62856c.size()) {
            return;
        }
        List<EmotionPackageData> list = this.f62856c;
        list.add(i3, list.remove(i2));
        List<C1686a> list2 = this.f62857d;
        list2.add(i3, list2.remove(i2));
        this.f62855b.notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921312, new Pair(Integer.valueOf(i2), Integer.valueOf(i3))));
    }

    public void b() {
        c cVar;
        if (this.f62855b == null || this.f62854a == null || this.f62856c == null || (cVar = this.f62858e) == null || this.f62859f == null) {
            return;
        }
        cVar.c();
        this.f62859f.b(0, this.f62855b.b());
        this.f62859f.a(d.a.j0.y1.h.a.b().a());
        this.f62855b.notifyDataSetChanged();
    }

    public void c(List<EmotionPackageData> list) {
        if (this.f62854a == null || this.f62855b == null) {
            return;
        }
        this.f62856c.clear();
        this.f62856c.addAll(list);
        d();
        this.f62855b.d();
        this.f62858e.d(Integer.valueOf(this.f62855b.b()));
        this.f62859f.b(0, this.f62855b.b());
        this.f62859f.a(d.a.j0.y1.h.a.b().a());
        this.f62855b.notifyDataSetChanged();
    }

    public final void d() {
        ArrayList arrayList = new ArrayList(this.f62857d);
        this.f62857d.clear();
        for (EmotionPackageData emotionPackageData : this.f62856c) {
            C1686a c1686a = null;
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C1686a c1686a2 = (C1686a) it.next();
                if (c1686a2 != null && c1686a2.f62860a == emotionPackageData.id) {
                    c1686a = c1686a2;
                    break;
                }
            }
            if (c1686a == null) {
                c1686a = new C1686a();
                c1686a.f62860a = emotionPackageData.id;
            }
            this.f62857d.add(c1686a);
        }
    }
}
