package d.b.i.u0;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<List<b>> f52251a = new SparseArray<>();

    /* loaded from: classes.dex */
    public interface b {
        boolean a(C1131a c1131a);
    }

    public void a(int i, b bVar) {
        if (this.f52251a == null) {
            this.f52251a = new SparseArray<>();
        }
        List<b> list = this.f52251a.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.f52251a.put(i, list);
        }
        list.add(bVar);
    }

    public boolean b(C1131a c1131a) {
        List<b> list = this.f52251a.get(c1131a.f52252a);
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c1131a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d.b.i.u0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C1131a {

        /* renamed from: a  reason: collision with root package name */
        public int f52252a;

        /* renamed from: b  reason: collision with root package name */
        public Object f52253b;

        public C1131a(int i, Object obj) {
            this.f52252a = i;
            this.f52253b = obj;
        }

        public int b() {
            return this.f52252a;
        }

        public Object c() {
            return this.f52253b;
        }

        public void d(Object obj) {
            this.f52253b = obj;
        }

        public C1131a(int i) {
            this.f52252a = i;
        }
    }
}
