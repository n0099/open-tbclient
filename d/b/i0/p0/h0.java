package d.b.i0.p0;

import androidx.collection.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class h0 {

    /* renamed from: b  reason: collision with root package name */
    public static final h0 f57558b = new h0();

    /* renamed from: a  reason: collision with root package name */
    public LongSparseArray<LinkedList<String>> f57559a = new LongSparseArray<>();

    public static h0 a() {
        return f57558b;
    }

    public void b(long j) {
        LinkedList<String> linkedList = this.f57559a.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
