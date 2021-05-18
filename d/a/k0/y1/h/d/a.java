package d.a.k0.y1.h.d;

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
import d.a.k0.y1.h.f.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f63578a;

    /* renamed from: b  reason: collision with root package name */
    public MyEmotionHorizontalAdater f63579b;

    /* renamed from: c  reason: collision with root package name */
    public List<EmotionPackageData> f63580c;

    /* renamed from: d  reason: collision with root package name */
    public final List<C1751a> f63581d;

    /* renamed from: e  reason: collision with root package name */
    public c f63582e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.y1.h.b.a f63583f;

    /* renamed from: d.a.k0.y1.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1751a {

        /* renamed from: a  reason: collision with root package name */
        public int f63584a;

        /* renamed from: b  reason: collision with root package name */
        public int f63585b;

        /* renamed from: c  reason: collision with root package name */
        public int f63586c;

        public String toString() {
            return "id: " + this.f63584a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "firstVisibleItem: " + this.f63585b + StringUtil.ARRAY_ELEMENT_SEPARATOR + "padX: " + this.f63586c;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, d.a.k0.y1.h.b.a aVar) {
        this.f63578a = bdListView;
        c cVar = new c(tbPageContext);
        this.f63582e = cVar;
        cVar.b(TbadkCoreApplication.getInst().getSkinType());
        this.f63578a.addHeaderView(this.f63582e.a());
        this.f63580c = new ArrayList();
        this.f63581d = new ArrayList();
        MyEmotionHorizontalAdater myEmotionHorizontalAdater = new MyEmotionHorizontalAdater(this.f63580c, this.f63581d, tbPageContext);
        this.f63579b = myEmotionHorizontalAdater;
        this.f63583f = aVar;
        this.f63578a.setAdapter((ListAdapter) myEmotionHorizontalAdater);
    }

    public void a(int i2, int i3) {
        if (i2 < 0 || i2 >= this.f63580c.size() || i3 < 0 || i3 >= this.f63580c.size()) {
            return;
        }
        List<EmotionPackageData> list = this.f63580c;
        list.add(i3, list.remove(i2));
        List<C1751a> list2 = this.f63581d;
        list2.add(i3, list2.remove(i2));
        this.f63579b.notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921312, new Pair(Integer.valueOf(i2), Integer.valueOf(i3))));
    }

    public void b() {
        c cVar;
        if (this.f63579b == null || this.f63578a == null || this.f63580c == null || (cVar = this.f63582e) == null || this.f63583f == null) {
            return;
        }
        cVar.c();
        this.f63583f.b(0, this.f63579b.b());
        this.f63583f.a(d.a.k0.y1.h.a.b().a());
        this.f63579b.notifyDataSetChanged();
    }

    public void c(List<EmotionPackageData> list) {
        if (this.f63578a == null || this.f63579b == null) {
            return;
        }
        this.f63580c.clear();
        this.f63580c.addAll(list);
        d();
        this.f63579b.d();
        this.f63582e.d(Integer.valueOf(this.f63579b.b()));
        this.f63583f.b(0, this.f63579b.b());
        this.f63583f.a(d.a.k0.y1.h.a.b().a());
        this.f63579b.notifyDataSetChanged();
    }

    public final void d() {
        ArrayList arrayList = new ArrayList(this.f63581d);
        this.f63581d.clear();
        for (EmotionPackageData emotionPackageData : this.f63580c) {
            C1751a c1751a = null;
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C1751a c1751a2 = (C1751a) it.next();
                if (c1751a2 != null && c1751a2.f63584a == emotionPackageData.id) {
                    c1751a = c1751a2;
                    break;
                }
            }
            if (c1751a == null) {
                c1751a = new C1751a();
                c1751a.f63584a = emotionPackageData.id;
            }
            this.f63581d.add(c1751a);
        }
    }
}
