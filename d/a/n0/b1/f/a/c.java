package d.a.n0.b1.f.a;

import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<WeakReference<View>> f52801a;

    /* renamed from: b  reason: collision with root package name */
    public View f52802b;

    public c(View view) {
        this(view, -1);
    }

    public View a() {
        return this.f52802b;
    }

    public <T extends View> T b(int i2) {
        WeakReference<View> weakReference = this.f52801a.get(i2);
        if (weakReference == null) {
            T t = (T) this.f52802b.findViewById(i2);
            if (t != null) {
                this.f52801a.put(i2, new WeakReference<>(t));
                return t;
            }
            return t;
        }
        return (T) weakReference.get();
    }

    public c c(View.OnClickListener onClickListener) {
        this.f52802b.setOnClickListener(onClickListener);
        return this;
    }

    public c(View view, int i2) {
        this.f52802b = view;
        this.f52801a = new SparseArray<>();
    }
}
