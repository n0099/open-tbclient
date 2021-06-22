package d.a.o0.z1.h.d;

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
import d.a.o0.z1.h.f.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f67585a;

    /* renamed from: b  reason: collision with root package name */
    public MyEmotionHorizontalAdater f67586b;

    /* renamed from: c  reason: collision with root package name */
    public List<EmotionPackageData> f67587c;

    /* renamed from: d  reason: collision with root package name */
    public final List<C1828a> f67588d;

    /* renamed from: e  reason: collision with root package name */
    public c f67589e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.z1.h.b.a f67590f;

    /* renamed from: d.a.o0.z1.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1828a {

        /* renamed from: a  reason: collision with root package name */
        public int f67591a;

        /* renamed from: b  reason: collision with root package name */
        public int f67592b;

        /* renamed from: c  reason: collision with root package name */
        public int f67593c;

        public String toString() {
            return "id: " + this.f67591a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "firstVisibleItem: " + this.f67592b + StringUtil.ARRAY_ELEMENT_SEPARATOR + "padX: " + this.f67593c;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, d.a.o0.z1.h.b.a aVar) {
        this.f67585a = bdListView;
        c cVar = new c(tbPageContext);
        this.f67589e = cVar;
        cVar.b(TbadkCoreApplication.getInst().getSkinType());
        this.f67585a.addHeaderView(this.f67589e.a());
        this.f67587c = new ArrayList();
        this.f67588d = new ArrayList();
        MyEmotionHorizontalAdater myEmotionHorizontalAdater = new MyEmotionHorizontalAdater(this.f67587c, this.f67588d, tbPageContext);
        this.f67586b = myEmotionHorizontalAdater;
        this.f67590f = aVar;
        this.f67585a.setAdapter((ListAdapter) myEmotionHorizontalAdater);
    }

    public void a(int i2, int i3) {
        if (i2 < 0 || i2 >= this.f67587c.size() || i3 < 0 || i3 >= this.f67587c.size()) {
            return;
        }
        List<EmotionPackageData> list = this.f67587c;
        list.add(i3, list.remove(i2));
        List<C1828a> list2 = this.f67588d;
        list2.add(i3, list2.remove(i2));
        this.f67586b.notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921312, new Pair(Integer.valueOf(i2), Integer.valueOf(i3))));
    }

    public void b() {
        c cVar;
        if (this.f67586b == null || this.f67585a == null || this.f67587c == null || (cVar = this.f67589e) == null || this.f67590f == null) {
            return;
        }
        cVar.c();
        this.f67590f.b(0, this.f67586b.b());
        this.f67590f.a(d.a.o0.z1.h.a.b().a());
        this.f67586b.notifyDataSetChanged();
    }

    public void c(List<EmotionPackageData> list) {
        if (this.f67585a == null || this.f67586b == null) {
            return;
        }
        this.f67587c.clear();
        this.f67587c.addAll(list);
        d();
        this.f67586b.d();
        this.f67589e.d(Integer.valueOf(this.f67586b.b()));
        this.f67590f.b(0, this.f67586b.b());
        this.f67590f.a(d.a.o0.z1.h.a.b().a());
        this.f67586b.notifyDataSetChanged();
    }

    public final void d() {
        ArrayList arrayList = new ArrayList(this.f67588d);
        this.f67588d.clear();
        for (EmotionPackageData emotionPackageData : this.f67587c) {
            C1828a c1828a = null;
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C1828a c1828a2 = (C1828a) it.next();
                if (c1828a2 != null && c1828a2.f67591a == emotionPackageData.id) {
                    c1828a = c1828a2;
                    break;
                }
            }
            if (c1828a == null) {
                c1828a = new C1828a();
                c1828a.f67591a = emotionPackageData.id;
            }
            this.f67588d.add(c1828a);
        }
    }
}
