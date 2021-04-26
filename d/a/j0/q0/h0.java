package d.a.j0.q0;

import androidx.collection.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class h0 {

    /* renamed from: b  reason: collision with root package name */
    public static final h0 f57742b = new h0();

    /* renamed from: a  reason: collision with root package name */
    public LongSparseArray<LinkedList<String>> f57743a = new LongSparseArray<>();

    public static h0 a() {
        return f57742b;
    }

    public void b(long j) {
        LinkedList<String> linkedList = this.f57743a.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
