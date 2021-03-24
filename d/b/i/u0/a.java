package d.b.i.u0;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<List<b>> f51826a = new SparseArray<>();

    /* loaded from: classes2.dex */
    public interface b {
        boolean a(C1117a c1117a);
    }

    public void a(int i, b bVar) {
        if (this.f51826a == null) {
            this.f51826a = new SparseArray<>();
        }
        List<b> list = this.f51826a.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.f51826a.put(i, list);
        }
        list.add(bVar);
    }

    public boolean b(C1117a c1117a) {
        List<b> list = this.f51826a.get(c1117a.f51827a);
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c1117a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d.b.i.u0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1117a {

        /* renamed from: a  reason: collision with root package name */
        public int f51827a;

        /* renamed from: b  reason: collision with root package name */
        public Object f51828b;

        public C1117a(int i, Object obj) {
            this.f51827a = i;
            this.f51828b = obj;
        }

        public int b() {
            return this.f51827a;
        }

        public Object c() {
            return this.f51828b;
        }

        public void d(Object obj) {
            this.f51828b = obj;
        }

        public C1117a(int i) {
            this.f51827a = i;
        }
    }
}
