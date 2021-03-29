package d.b.i.u0;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<List<b>> f51827a = new SparseArray<>();

    /* loaded from: classes.dex */
    public interface b {
        boolean a(C1118a c1118a);
    }

    public void a(int i, b bVar) {
        if (this.f51827a == null) {
            this.f51827a = new SparseArray<>();
        }
        List<b> list = this.f51827a.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.f51827a.put(i, list);
        }
        list.add(bVar);
    }

    public boolean b(C1118a c1118a) {
        List<b> list = this.f51827a.get(c1118a.f51828a);
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c1118a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d.b.i.u0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C1118a {

        /* renamed from: a  reason: collision with root package name */
        public int f51828a;

        /* renamed from: b  reason: collision with root package name */
        public Object f51829b;

        public C1118a(int i, Object obj) {
            this.f51828a = i;
            this.f51829b = obj;
        }

        public int b() {
            return this.f51828a;
        }

        public Object c() {
            return this.f51829b;
        }

        public void d(Object obj) {
            this.f51829b = obj;
        }

        public C1118a(int i) {
            this.f51828a = i;
        }
    }
}
