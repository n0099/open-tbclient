package d.a.i.v0;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<List<b>> f43857a = new SparseArray<>();

    /* loaded from: classes.dex */
    public interface b {
        boolean a(C0602a c0602a);
    }

    public void a(int i2, b bVar) {
        if (this.f43857a == null) {
            this.f43857a = new SparseArray<>();
        }
        List<b> list = this.f43857a.get(i2);
        if (list == null) {
            list = new ArrayList<>();
            this.f43857a.put(i2, list);
        }
        list.add(bVar);
    }

    public boolean b(C0602a c0602a) {
        List<b> list = this.f43857a.get(c0602a.f43858a);
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c0602a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d.a.i.v0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0602a {

        /* renamed from: a  reason: collision with root package name */
        public int f43858a;

        /* renamed from: b  reason: collision with root package name */
        public Object f43859b;

        public C0602a(int i2, Object obj) {
            this.f43858a = i2;
            this.f43859b = obj;
        }

        public int b() {
            return this.f43858a;
        }

        public Object c() {
            return this.f43859b;
        }

        public void d(Object obj) {
            this.f43859b = obj;
        }

        public C0602a(int i2) {
            this.f43858a = i2;
        }
    }
}
