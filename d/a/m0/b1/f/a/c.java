package d.a.m0.b1.f.a;

import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<WeakReference<View>> f52694a;

    /* renamed from: b  reason: collision with root package name */
    public View f52695b;

    public c(View view) {
        this(view, -1);
    }

    public View a() {
        return this.f52695b;
    }

    public <T extends View> T b(int i2) {
        WeakReference<View> weakReference = this.f52694a.get(i2);
        if (weakReference == null) {
            T t = (T) this.f52695b.findViewById(i2);
            if (t != null) {
                this.f52694a.put(i2, new WeakReference<>(t));
                return t;
            }
            return t;
        }
        return (T) weakReference.get();
    }

    public c c(View.OnClickListener onClickListener) {
        this.f52695b.setOnClickListener(onClickListener);
        return this;
    }

    public c(View view, int i2) {
        this.f52695b = view;
        this.f52694a = new SparseArray<>();
    }
}
