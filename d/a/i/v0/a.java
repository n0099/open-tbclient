package d.a.i.v0;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<List<b>> f43764a = new SparseArray<>();

    /* loaded from: classes.dex */
    public interface b {
        boolean a(C0600a c0600a);
    }

    public void a(int i2, b bVar) {
        if (this.f43764a == null) {
            this.f43764a = new SparseArray<>();
        }
        List<b> list = this.f43764a.get(i2);
        if (list == null) {
            list = new ArrayList<>();
            this.f43764a.put(i2, list);
        }
        list.add(bVar);
    }

    public boolean b(C0600a c0600a) {
        List<b> list = this.f43764a.get(c0600a.f43765a);
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        for (b bVar : list) {
            if (bVar != null && bVar.a(c0600a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d.a.i.v0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0600a {

        /* renamed from: a  reason: collision with root package name */
        public int f43765a;

        /* renamed from: b  reason: collision with root package name */
        public Object f43766b;

        public C0600a(int i2, Object obj) {
            this.f43765a = i2;
            this.f43766b = obj;
        }

        public int b() {
            return this.f43765a;
        }

        public Object c() {
            return this.f43766b;
        }

        public void d(Object obj) {
            this.f43766b = obj;
        }

        public C0600a(int i2) {
            this.f43765a = i2;
        }
    }
}
