package d.a.m0.b1.f.a;

import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<WeakReference<View>> f49020a;

    /* renamed from: b  reason: collision with root package name */
    public View f49021b;

    public c(View view) {
        this(view, -1);
    }

    public View a() {
        return this.f49021b;
    }

    public <T extends View> T b(int i2) {
        WeakReference<View> weakReference = this.f49020a.get(i2);
        if (weakReference == null) {
            T t = (T) this.f49021b.findViewById(i2);
            if (t != null) {
                this.f49020a.put(i2, new WeakReference<>(t));
                return t;
            }
            return t;
        }
        return (T) weakReference.get();
    }

    public c c(View.OnClickListener onClickListener) {
        this.f49021b.setOnClickListener(onClickListener);
        return this;
    }

    public c(View view, int i2) {
        this.f49021b = view;
        this.f49020a = new SparseArray<>();
    }
}
