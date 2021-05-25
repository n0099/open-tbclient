package d.a.i.v0;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<List<b>> f40083a = new SparseArray<>();

    /* loaded from: classes.dex */
    public interface b {
        boolean a(C0544a c0544a);
    }

    public void a(int i2, b bVar) {
        if (this.f40083a == null) {
            this.f40083a = new SparseArray<>();
        }
        List<b> list = this.f40083a.get(i2);
        if (list == null) {
            list = new ArrayList<>();
            this.f40083a.put(i2, list);
        }
        list.add(bVar);
    }

    public boolean b(C0544a c0544a) {
        List<b> list = this.f40083a.get(c0544a.f40084a);
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c0544a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d.a.i.v0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0544a {

        /* renamed from: a  reason: collision with root package name */
        public int f40084a;

        /* renamed from: b  reason: collision with root package name */
        public Object f40085b;

        public C0544a(int i2, Object obj) {
            this.f40084a = i2;
            this.f40085b = obj;
        }

        public int b() {
            return this.f40084a;
        }

        public Object c() {
            return this.f40085b;
        }

        public void d(Object obj) {
            this.f40085b = obj;
        }

        public C0544a(int i2) {
            this.f40084a = i2;
        }
    }
}
