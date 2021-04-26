package d.a.i.u0;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<List<b>> f47764a = new SparseArray<>();

    /* loaded from: classes.dex */
    public interface b {
        boolean a(C1011a c1011a);
    }

    public void a(int i2, b bVar) {
        if (this.f47764a == null) {
            this.f47764a = new SparseArray<>();
        }
        List<b> list = this.f47764a.get(i2);
        if (list == null) {
            list = new ArrayList<>();
            this.f47764a.put(i2, list);
        }
        list.add(bVar);
    }

    public boolean b(C1011a c1011a) {
        List<b> list = this.f47764a.get(c1011a.f47765a);
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c1011a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d.a.i.u0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C1011a {

        /* renamed from: a  reason: collision with root package name */
        public int f47765a;

        /* renamed from: b  reason: collision with root package name */
        public Object f47766b;

        public C1011a(int i2, Object obj) {
            this.f47765a = i2;
            this.f47766b = obj;
        }

        public int b() {
            return this.f47765a;
        }

        public Object c() {
            return this.f47766b;
        }

        public void d(Object obj) {
            this.f47766b = obj;
        }

        public C1011a(int i2) {
            this.f47765a = i2;
        }
    }
}
