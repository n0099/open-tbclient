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
    public BdListView f63742a;

    /* renamed from: b  reason: collision with root package name */
    public MyEmotionHorizontalAdater f63743b;

    /* renamed from: c  reason: collision with root package name */
    public List<EmotionPackageData> f63744c;

    /* renamed from: d  reason: collision with root package name */
    public final List<C1766a> f63745d;

    /* renamed from: e  reason: collision with root package name */
    public c f63746e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.z1.h.b.a f63747f;

    /* renamed from: d.a.n0.z1.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1766a {

        /* renamed from: a  reason: collision with root package name */
        public int f63748a;

        /* renamed from: b  reason: collision with root package name */
        public int f63749b;

        /* renamed from: c  reason: collision with root package name */
        public int f63750c;

        public String toString() {
            return "id: " + this.f63748a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "firstVisibleItem: " + this.f63749b + StringUtil.ARRAY_ELEMENT_SEPARATOR + "padX: " + this.f63750c;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, d.a.n0.z1.h.b.a aVar) {
        this.f63742a = bdListView;
        c cVar = new c(tbPageContext);
        this.f63746e = cVar;
        cVar.b(TbadkCoreApplication.getInst().getSkinType());
        this.f63742a.addHeaderView(this.f63746e.a());
        this.f63744c = new ArrayList();
        this.f63745d = new ArrayList();
        MyEmotionHorizontalAdater myEmotionHorizontalAdater = new MyEmotionHorizontalAdater(this.f63744c, this.f63745d, tbPageContext);
        this.f63743b = myEmotionHorizontalAdater;
        this.f63747f = aVar;
        this.f63742a.setAdapter((ListAdapter) myEmotionHorizontalAdater);
    }

    public void a(int i2, int i3) {
        if (i2 < 0 || i2 >= this.f63744c.size() || i3 < 0 || i3 >= this.f63744c.size()) {
            return;
        }
        List<EmotionPackageData> list = this.f63744c;
        list.add(i3, list.remove(i2));
        List<C1766a> list2 = this.f63745d;
        list2.add(i3, list2.remove(i2));
        this.f63743b.notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921312, new Pair(Integer.valueOf(i2), Integer.valueOf(i3))));
    }

    public void b() {
        c cVar;
        if (this.f63743b == null || this.f63742a == null || this.f63744c == null || (cVar = this.f63746e) == null || this.f63747f == null) {
            return;
        }
        cVar.c();
        this.f63747f.b(0, this.f63743b.b());
        this.f63747f.a(d.a.n0.z1.h.a.b().a());
        this.f63743b.notifyDataSetChanged();
    }

    public void c(List<EmotionPackageData> list) {
        if (this.f63742a == null || this.f63743b == null) {
            return;
        }
        this.f63744c.clear();
        this.f63744c.addAll(list);
        d();
        this.f63743b.d();
        this.f63746e.d(Integer.valueOf(this.f63743b.b()));
        this.f63747f.b(0, this.f63743b.b());
        this.f63747f.a(d.a.n0.z1.h.a.b().a());
        this.f63743b.notifyDataSetChanged();
    }

    public final void d() {
        ArrayList arrayList = new ArrayList(this.f63745d);
        this.f63745d.clear();
        for (EmotionPackageData emotionPackageData : this.f63744c) {
            C1766a c1766a = null;
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C1766a c1766a2 = (C1766a) it.next();
                if (c1766a2 != null && c1766a2.f63748a == emotionPackageData.id) {
                    c1766a = c1766a2;
                    break;
                }
            }
            if (c1766a == null) {
                c1766a = new C1766a();
                c1766a.f63748a = emotionPackageData.id;
            }
            this.f63745d.add(c1766a);
        }
    }
}
