package d.b.i.u0;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<List<b>> f50219a = new SparseArray<>();

    /* loaded from: classes.dex */
    public interface b {
        boolean a(C1072a c1072a);
    }

    public void a(int i, b bVar) {
        if (this.f50219a == null) {
            this.f50219a = new SparseArray<>();
        }
        List<b> list = this.f50219a.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.f50219a.put(i, list);
        }
        list.add(bVar);
    }

    public boolean b(C1072a c1072a) {
        List<b> list = this.f50219a.get(c1072a.f50220a);
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c1072a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d.b.i.u0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C1072a {

        /* renamed from: a  reason: collision with root package name */
        public int f50220a;

        /* renamed from: b  reason: collision with root package name */
        public Object f50221b;

        public C1072a(int i, Object obj) {
            this.f50220a = i;
            this.f50221b = obj;
        }

        public int b() {
            return this.f50220a;
        }

        public Object c() {
            return this.f50221b;
        }

        public void d(Object obj) {
            this.f50221b = obj;
        }

        public C1072a(int i) {
            this.f50220a = i;
        }
    }
}
