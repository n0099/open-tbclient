package d.a.n0.z1.h.d;

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
import d.a.n0.z1.h.f.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f67460a;

    /* renamed from: b  reason: collision with root package name */
    public MyEmotionHorizontalAdater f67461b;

    /* renamed from: c  reason: collision with root package name */
    public List<EmotionPackageData> f67462c;

    /* renamed from: d  reason: collision with root package name */
    public final List<C1824a> f67463d;

    /* renamed from: e  reason: collision with root package name */
    public c f67464e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.z1.h.b.a f67465f;

    /* renamed from: d.a.n0.z1.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1824a {

        /* renamed from: a  reason: collision with root package name */
        public int f67466a;

        /* renamed from: b  reason: collision with root package name */
        public int f67467b;

        /* renamed from: c  reason: collision with root package name */
        public int f67468c;

        public String toString() {
            return "id: " + this.f67466a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "firstVisibleItem: " + this.f67467b + StringUtil.ARRAY_ELEMENT_SEPARATOR + "padX: " + this.f67468c;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, d.a.n0.z1.h.b.a aVar) {
        this.f67460a = bdListView;
        c cVar = new c(tbPageContext);
        this.f67464e = cVar;
        cVar.b(TbadkCoreApplication.getInst().getSkinType());
        this.f67460a.addHeaderView(this.f67464e.a());
        this.f67462c = new ArrayList();
        this.f67463d = new ArrayList();
        MyEmotionHorizontalAdater myEmotionHorizontalAdater = new MyEmotionHorizontalAdater(this.f67462c, this.f67463d, tbPageContext);
        this.f67461b = myEmotionHorizontalAdater;
        this.f67465f = aVar;
        this.f67460a.setAdapter((ListAdapter) myEmotionHorizontalAdater);
    }

    public void a(int i2, int i3) {
        if (i2 < 0 || i2 >= this.f67462c.size() || i3 < 0 || i3 >= this.f67462c.size()) {
            return;
        }
        List<EmotionPackageData> list = this.f67462c;
        list.add(i3, list.remove(i2));
        List<C1824a> list2 = this.f67463d;
        list2.add(i3, list2.remove(i2));
        this.f67461b.notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921312, new Pair(Integer.valueOf(i2), Integer.valueOf(i3))));
    }

    public void b() {
        c cVar;
        if (this.f67461b == null || this.f67460a == null || this.f67462c == null || (cVar = this.f67464e) == null || this.f67465f == null) {
            return;
        }
        cVar.c();
        this.f67465f.b(0, this.f67461b.b());
        this.f67465f.a(d.a.n0.z1.h.a.b().a());
        this.f67461b.notifyDataSetChanged();
    }

    public void c(List<EmotionPackageData> list) {
        if (this.f67460a == null || this.f67461b == null) {
            return;
        }
        this.f67462c.clear();
        this.f67462c.addAll(list);
        d();
        this.f67461b.d();
        this.f67464e.d(Integer.valueOf(this.f67461b.b()));
        this.f67465f.b(0, this.f67461b.b());
        this.f67465f.a(d.a.n0.z1.h.a.b().a());
        this.f67461b.notifyDataSetChanged();
    }

    public final void d() {
        ArrayList arrayList = new ArrayList(this.f67463d);
        this.f67463d.clear();
        for (EmotionPackageData emotionPackageData : this.f67462c) {
            C1824a c1824a = null;
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C1824a c1824a2 = (C1824a) it.next();
                if (c1824a2 != null && c1824a2.f67466a == emotionPackageData.id) {
                    c1824a = c1824a2;
                    break;
                }
            }
            if (c1824a == null) {
                c1824a = new C1824a();
                c1824a.f67466a = emotionPackageData.id;
            }
            this.f67463d.add(c1824a);
        }
    }
}
