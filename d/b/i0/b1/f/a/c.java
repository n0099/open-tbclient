package d.b.i0.b1.f.a;

import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<WeakReference<View>> f50606a;

    /* renamed from: b  reason: collision with root package name */
    public View f50607b;

    public c(View view) {
        this(view, -1);
    }

    public View a() {
        return this.f50607b;
    }

    public <T extends View> T b(int i) {
        WeakReference<View> weakReference = this.f50606a.get(i);
        if (weakReference == null) {
            T t = (T) this.f50607b.findViewById(i);
            if (t != null) {
                this.f50606a.put(i, new WeakReference<>(t));
                return t;
            }
            return t;
        }
        return (T) weakReference.get();
    }

    public c c(View.OnClickListener onClickListener) {
        this.f50607b.setOnClickListener(onClickListener);
        return this;
    }

    public c(View view, int i) {
        this.f50607b = view;
        this.f50606a = new SparseArray<>();
    }
}
