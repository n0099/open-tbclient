package d.a.i.v0;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<List<b>> f40391a = new SparseArray<>();

    /* loaded from: classes.dex */
    public interface b {
        boolean a(C0549a c0549a);
    }

    public void a(int i2, b bVar) {
        if (this.f40391a == null) {
            this.f40391a = new SparseArray<>();
        }
        List<b> list = this.f40391a.get(i2);
        if (list == null) {
            list = new ArrayList<>();
            this.f40391a.put(i2, list);
        }
        list.add(bVar);
    }

    public boolean b(C0549a c0549a) {
        List<b> list = this.f40391a.get(c0549a.f40392a);
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c0549a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d.a.i.v0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0549a {

        /* renamed from: a  reason: collision with root package name */
        public int f40392a;

        /* renamed from: b  reason: collision with root package name */
        public Object f40393b;

        public C0549a(int i2, Object obj) {
            this.f40392a = i2;
            this.f40393b = obj;
        }

        public int b() {
            return this.f40392a;
        }

        public Object c() {
            return this.f40393b;
        }

        public void d(Object obj) {
            this.f40393b = obj;
        }

        public C0549a(int i2) {
            this.f40392a = i2;
        }
    }
}
