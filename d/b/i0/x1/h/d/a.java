package d.b.i0.x1.h.d;

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
import d.b.i0.x1.h.f.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f62467a;

    /* renamed from: b  reason: collision with root package name */
    public MyEmotionHorizontalAdater f62468b;

    /* renamed from: c  reason: collision with root package name */
    public List<EmotionPackageData> f62469c;

    /* renamed from: d  reason: collision with root package name */
    public final List<C1666a> f62470d;

    /* renamed from: e  reason: collision with root package name */
    public c f62471e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.x1.h.b.a f62472f;

    /* renamed from: d.b.i0.x1.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1666a {

        /* renamed from: a  reason: collision with root package name */
        public int f62473a;

        /* renamed from: b  reason: collision with root package name */
        public int f62474b;

        /* renamed from: c  reason: collision with root package name */
        public int f62475c;

        public String toString() {
            return "id: " + this.f62473a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "firstVisibleItem: " + this.f62474b + StringUtil.ARRAY_ELEMENT_SEPARATOR + "padX: " + this.f62475c;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, d.b.i0.x1.h.b.a aVar) {
        this.f62467a = bdListView;
        c cVar = new c(tbPageContext);
        this.f62471e = cVar;
        cVar.b(TbadkCoreApplication.getInst().getSkinType());
        this.f62467a.addHeaderView(this.f62471e.a());
        this.f62469c = new ArrayList();
        this.f62470d = new ArrayList();
        MyEmotionHorizontalAdater myEmotionHorizontalAdater = new MyEmotionHorizontalAdater(this.f62469c, this.f62470d, tbPageContext);
        this.f62468b = myEmotionHorizontalAdater;
        this.f62472f = aVar;
        this.f62467a.setAdapter((ListAdapter) myEmotionHorizontalAdater);
    }

    public void a(int i, int i2) {
        if (i < 0 || i >= this.f62469c.size() || i2 < 0 || i2 >= this.f62469c.size()) {
            return;
        }
        List<EmotionPackageData> list = this.f62469c;
        list.add(i2, list.remove(i));
        List<C1666a> list2 = this.f62470d;
        list2.add(i2, list2.remove(i));
        this.f62468b.notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921312, new Pair(Integer.valueOf(i), Integer.valueOf(i2))));
    }

    public void b() {
        c cVar;
        if (this.f62468b == null || this.f62467a == null || this.f62469c == null || (cVar = this.f62471e) == null || this.f62472f == null) {
            return;
        }
        cVar.c();
        this.f62472f.b(0, this.f62468b.b());
        this.f62472f.a(d.b.i0.x1.h.a.b().a());
        this.f62468b.notifyDataSetChanged();
    }

    public void c(List<EmotionPackageData> list) {
        if (this.f62467a == null || this.f62468b == null) {
            return;
        }
        this.f62469c.clear();
        this.f62469c.addAll(list);
        d();
        this.f62468b.d();
        this.f62471e.d(Integer.valueOf(this.f62468b.b()));
        this.f62472f.b(0, this.f62468b.b());
        this.f62472f.a(d.b.i0.x1.h.a.b().a());
        this.f62468b.notifyDataSetChanged();
    }

    public final void d() {
        ArrayList arrayList = new ArrayList(this.f62470d);
        this.f62470d.clear();
        for (EmotionPackageData emotionPackageData : this.f62469c) {
            C1666a c1666a = null;
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C1666a c1666a2 = (C1666a) it.next();
                if (c1666a2 != null && c1666a2.f62473a == emotionPackageData.id) {
                    c1666a = c1666a2;
                    break;
                }
            }
            if (c1666a == null) {
                c1666a = new C1666a();
                c1666a.f62473a = emotionPackageData.id;
            }
            this.f62470d.add(c1666a);
        }
    }
}
