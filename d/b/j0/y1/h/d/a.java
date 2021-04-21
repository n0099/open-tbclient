package d.b.j0.y1.h.d;

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
import d.b.j0.y1.h.f.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f64574a;

    /* renamed from: b  reason: collision with root package name */
    public MyEmotionHorizontalAdater f64575b;

    /* renamed from: c  reason: collision with root package name */
    public List<EmotionPackageData> f64576c;

    /* renamed from: d  reason: collision with root package name */
    public final List<C1749a> f64577d;

    /* renamed from: e  reason: collision with root package name */
    public c f64578e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.y1.h.b.a f64579f;

    /* renamed from: d.b.j0.y1.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1749a {

        /* renamed from: a  reason: collision with root package name */
        public int f64580a;

        /* renamed from: b  reason: collision with root package name */
        public int f64581b;

        /* renamed from: c  reason: collision with root package name */
        public int f64582c;

        public String toString() {
            return "id: " + this.f64580a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "firstVisibleItem: " + this.f64581b + StringUtil.ARRAY_ELEMENT_SEPARATOR + "padX: " + this.f64582c;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, d.b.j0.y1.h.b.a aVar) {
        this.f64574a = bdListView;
        c cVar = new c(tbPageContext);
        this.f64578e = cVar;
        cVar.b(TbadkCoreApplication.getInst().getSkinType());
        this.f64574a.addHeaderView(this.f64578e.a());
        this.f64576c = new ArrayList();
        this.f64577d = new ArrayList();
        MyEmotionHorizontalAdater myEmotionHorizontalAdater = new MyEmotionHorizontalAdater(this.f64576c, this.f64577d, tbPageContext);
        this.f64575b = myEmotionHorizontalAdater;
        this.f64579f = aVar;
        this.f64574a.setAdapter((ListAdapter) myEmotionHorizontalAdater);
    }

    public void a(int i, int i2) {
        if (i < 0 || i >= this.f64576c.size() || i2 < 0 || i2 >= this.f64576c.size()) {
            return;
        }
        List<EmotionPackageData> list = this.f64576c;
        list.add(i2, list.remove(i));
        List<C1749a> list2 = this.f64577d;
        list2.add(i2, list2.remove(i));
        this.f64575b.notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921312, new Pair(Integer.valueOf(i), Integer.valueOf(i2))));
    }

    public void b() {
        c cVar;
        if (this.f64575b == null || this.f64574a == null || this.f64576c == null || (cVar = this.f64578e) == null || this.f64579f == null) {
            return;
        }
        cVar.c();
        this.f64579f.b(0, this.f64575b.b());
        this.f64579f.a(d.b.j0.y1.h.a.b().a());
        this.f64575b.notifyDataSetChanged();
    }

    public void c(List<EmotionPackageData> list) {
        if (this.f64574a == null || this.f64575b == null) {
            return;
        }
        this.f64576c.clear();
        this.f64576c.addAll(list);
        d();
        this.f64575b.d();
        this.f64578e.d(Integer.valueOf(this.f64575b.b()));
        this.f64579f.b(0, this.f64575b.b());
        this.f64579f.a(d.b.j0.y1.h.a.b().a());
        this.f64575b.notifyDataSetChanged();
    }

    public final void d() {
        ArrayList arrayList = new ArrayList(this.f64577d);
        this.f64577d.clear();
        for (EmotionPackageData emotionPackageData : this.f64576c) {
            C1749a c1749a = null;
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C1749a c1749a2 = (C1749a) it.next();
                if (c1749a2 != null && c1749a2.f64580a == emotionPackageData.id) {
                    c1749a = c1749a2;
                    break;
                }
            }
            if (c1749a == null) {
                c1749a = new C1749a();
                c1749a.f64580a = emotionPackageData.id;
            }
            this.f64577d.add(c1749a);
        }
    }
}
