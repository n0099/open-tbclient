package d.b.h0.b1.f.a;

import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<WeakReference<View>> f50270a;

    /* renamed from: b  reason: collision with root package name */
    public View f50271b;

    public c(View view) {
        this(view, -1);
    }

    public View a() {
        return this.f50271b;
    }

    public <T extends View> T b(int i) {
        WeakReference<View> weakReference = this.f50270a.get(i);
        if (weakReference == null) {
            T t = (T) this.f50271b.findViewById(i);
            if (t != null) {
                this.f50270a.put(i, new WeakReference<>(t));
                return t;
            }
            return t;
        }
        return (T) weakReference.get();
    }

    public c c(View.OnClickListener onClickListener) {
        this.f50271b.setOnClickListener(onClickListener);
        return this;
    }

    public c(View view, int i) {
        this.f50271b = view;
        this.f50270a = new SparseArray<>();
    }
}
