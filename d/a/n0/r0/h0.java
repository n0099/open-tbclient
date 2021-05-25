package d.a.n0.r0;

import androidx.collection.LongSparseArray;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class h0 {

    /* renamed from: b  reason: collision with root package name */
    public static final h0 f58625b = new h0();

    /* renamed from: a  reason: collision with root package name */
    public LongSparseArray<LinkedList<String>> f58626a = new LongSparseArray<>();

    public static h0 a() {
        return f58625b;
    }

    public void b(long j) {
        LinkedList<String> linkedList = this.f58626a.get(j);
        if (linkedList != null) {
            linkedList.clear();
        }
    }
}
