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
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f62468a;

    /* renamed from: b  reason: collision with root package name */
    public MyEmotionHorizontalAdater f62469b;

    /* renamed from: c  reason: collision with root package name */
    public List<EmotionPackageData> f62470c;

    /* renamed from: d  reason: collision with root package name */
    public final List<C1667a> f62471d;

    /* renamed from: e  reason: collision with root package name */
    public c f62472e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.x1.h.b.a f62473f;

    /* renamed from: d.b.i0.x1.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1667a {

        /* renamed from: a  reason: collision with root package name */
        public int f62474a;

        /* renamed from: b  reason: collision with root package name */
        public int f62475b;

        /* renamed from: c  reason: collision with root package name */
        public int f62476c;

        public String toString() {
            return "id: " + this.f62474a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "firstVisibleItem: " + this.f62475b + StringUtil.ARRAY_ELEMENT_SEPARATOR + "padX: " + this.f62476c;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, d.b.i0.x1.h.b.a aVar) {
        this.f62468a = bdListView;
        c cVar = new c(tbPageContext);
        this.f62472e = cVar;
        cVar.b(TbadkCoreApplication.getInst().getSkinType());
        this.f62468a.addHeaderView(this.f62472e.a());
        this.f62470c = new ArrayList();
        this.f62471d = new ArrayList();
        MyEmotionHorizontalAdater myEmotionHorizontalAdater = new MyEmotionHorizontalAdater(this.f62470c, this.f62471d, tbPageContext);
        this.f62469b = myEmotionHorizontalAdater;
        this.f62473f = aVar;
        this.f62468a.setAdapter((ListAdapter) myEmotionHorizontalAdater);
    }

    public void a(int i, int i2) {
        if (i < 0 || i >= this.f62470c.size() || i2 < 0 || i2 >= this.f62470c.size()) {
            return;
        }
        List<EmotionPackageData> list = this.f62470c;
        list.add(i2, list.remove(i));
        List<C1667a> list2 = this.f62471d;
        list2.add(i2, list2.remove(i));
        this.f62469b.notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921312, new Pair(Integer.valueOf(i), Integer.valueOf(i2))));
    }

    public void b() {
        c cVar;
        if (this.f62469b == null || this.f62468a == null || this.f62470c == null || (cVar = this.f62472e) == null || this.f62473f == null) {
            return;
        }
        cVar.c();
        this.f62473f.b(0, this.f62469b.b());
        this.f62473f.a(d.b.i0.x1.h.a.b().a());
        this.f62469b.notifyDataSetChanged();
    }

    public void c(List<EmotionPackageData> list) {
        if (this.f62468a == null || this.f62469b == null) {
            return;
        }
        this.f62470c.clear();
        this.f62470c.addAll(list);
        d();
        this.f62469b.d();
        this.f62472e.d(Integer.valueOf(this.f62469b.b()));
        this.f62473f.b(0, this.f62469b.b());
        this.f62473f.a(d.b.i0.x1.h.a.b().a());
        this.f62469b.notifyDataSetChanged();
    }

    public final void d() {
        ArrayList arrayList = new ArrayList(this.f62471d);
        this.f62471d.clear();
        for (EmotionPackageData emotionPackageData : this.f62470c) {
            C1667a c1667a = null;
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C1667a c1667a2 = (C1667a) it.next();
                if (c1667a2 != null && c1667a2.f62474a == emotionPackageData.id) {
                    c1667a = c1667a2;
                    break;
                }
            }
            if (c1667a == null) {
                c1667a = new C1667a();
                c1667a.f62474a = emotionPackageData.id;
            }
            this.f62471d.add(c1667a);
        }
    }
}
