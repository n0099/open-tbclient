package d.a.j0.b1.f.a;

import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<WeakReference<View>> f48995a;

    /* renamed from: b  reason: collision with root package name */
    public View f48996b;

    public c(View view) {
        this(view, -1);
    }

    public View a() {
        return this.f48996b;
    }

    public <T extends View> T b(int i2) {
        WeakReference<View> weakReference = this.f48995a.get(i2);
        if (weakReference == null) {
            T t = (T) this.f48996b.findViewById(i2);
            if (t != null) {
                this.f48995a.put(i2, new WeakReference<>(t));
                return t;
            }
            return t;
        }
        return (T) weakReference.get();
    }

    public c c(View.OnClickListener onClickListener) {
        this.f48996b.setOnClickListener(onClickListener);
        return this;
    }

    public c(View view, int i2) {
        this.f48996b = view;
        this.f48995a = new SparseArray<>();
    }
}
