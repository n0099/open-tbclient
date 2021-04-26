package d.a.i0.b1.f.a;

import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<WeakReference<View>> f48167a;

    /* renamed from: b  reason: collision with root package name */
    public View f48168b;

    public c(View view) {
        this(view, -1);
    }

    public View a() {
        return this.f48168b;
    }

    public <T extends View> T b(int i2) {
        WeakReference<View> weakReference = this.f48167a.get(i2);
        if (weakReference == null) {
            T t = (T) this.f48168b.findViewById(i2);
            if (t != null) {
                this.f48167a.put(i2, new WeakReference<>(t));
                return t;
            }
            return t;
        }
        return (T) weakReference.get();
    }

    public c c(View.OnClickListener onClickListener) {
        this.f48168b.setOnClickListener(onClickListener);
        return this;
    }

    public c(View view, int i2) {
        this.f48168b = view;
        this.f48167a = new SparseArray<>();
    }
}
