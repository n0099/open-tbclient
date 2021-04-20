package d.b.i0.y1.h.d;

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
import d.b.i0.y1.h.f.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f64153a;

    /* renamed from: b  reason: collision with root package name */
    public MyEmotionHorizontalAdater f64154b;

    /* renamed from: c  reason: collision with root package name */
    public List<EmotionPackageData> f64155c;

    /* renamed from: d  reason: collision with root package name */
    public final List<C1726a> f64156d;

    /* renamed from: e  reason: collision with root package name */
    public c f64157e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.y1.h.b.a f64158f;

    /* renamed from: d.b.i0.y1.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1726a {

        /* renamed from: a  reason: collision with root package name */
        public int f64159a;

        /* renamed from: b  reason: collision with root package name */
        public int f64160b;

        /* renamed from: c  reason: collision with root package name */
        public int f64161c;

        public String toString() {
            return "id: " + this.f64159a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "firstVisibleItem: " + this.f64160b + StringUtil.ARRAY_ELEMENT_SEPARATOR + "padX: " + this.f64161c;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, d.b.i0.y1.h.b.a aVar) {
        this.f64153a = bdListView;
        c cVar = new c(tbPageContext);
        this.f64157e = cVar;
        cVar.b(TbadkCoreApplication.getInst().getSkinType());
        this.f64153a.addHeaderView(this.f64157e.a());
        this.f64155c = new ArrayList();
        this.f64156d = new ArrayList();
        MyEmotionHorizontalAdater myEmotionHorizontalAdater = new MyEmotionHorizontalAdater(this.f64155c, this.f64156d, tbPageContext);
        this.f64154b = myEmotionHorizontalAdater;
        this.f64158f = aVar;
        this.f64153a.setAdapter((ListAdapter) myEmotionHorizontalAdater);
    }

    public void a(int i, int i2) {
        if (i < 0 || i >= this.f64155c.size() || i2 < 0 || i2 >= this.f64155c.size()) {
            return;
        }
        List<EmotionPackageData> list = this.f64155c;
        list.add(i2, list.remove(i));
        List<C1726a> list2 = this.f64156d;
        list2.add(i2, list2.remove(i));
        this.f64154b.notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921312, new Pair(Integer.valueOf(i), Integer.valueOf(i2))));
    }

    public void b() {
        c cVar;
        if (this.f64154b == null || this.f64153a == null || this.f64155c == null || (cVar = this.f64157e) == null || this.f64158f == null) {
            return;
        }
        cVar.c();
        this.f64158f.b(0, this.f64154b.b());
        this.f64158f.a(d.b.i0.y1.h.a.b().a());
        this.f64154b.notifyDataSetChanged();
    }

    public void c(List<EmotionPackageData> list) {
        if (this.f64153a == null || this.f64154b == null) {
            return;
        }
        this.f64155c.clear();
        this.f64155c.addAll(list);
        d();
        this.f64154b.d();
        this.f64157e.d(Integer.valueOf(this.f64154b.b()));
        this.f64158f.b(0, this.f64154b.b());
        this.f64158f.a(d.b.i0.y1.h.a.b().a());
        this.f64154b.notifyDataSetChanged();
    }

    public final void d() {
        ArrayList arrayList = new ArrayList(this.f64156d);
        this.f64156d.clear();
        for (EmotionPackageData emotionPackageData : this.f64155c) {
            C1726a c1726a = null;
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C1726a c1726a2 = (C1726a) it.next();
                if (c1726a2 != null && c1726a2.f64159a == emotionPackageData.id) {
                    c1726a = c1726a2;
                    break;
                }
            }
            if (c1726a == null) {
                c1726a = new C1726a();
                c1726a.f64159a = emotionPackageData.id;
            }
            this.f64156d.add(c1726a);
        }
    }
}
