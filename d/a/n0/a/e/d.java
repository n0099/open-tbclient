package d.a.n0.a.e;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public Stack<WeakReference<Activity>> f63377a;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f63378a = new d((byte) 0);
    }

    public /* synthetic */ d(byte b2) {
        this();
    }

    public final Stack<WeakReference<Activity>> a() {
        return this.f63377a;
    }

    public final String b() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < this.f63377a.size(); i2++) {
            Activity activity = this.f63377a.get(i2).get();
            if (activity != null) {
                sb.append(activity.getClass().getSimpleName());
                sb.append("->");
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "没有路径了";
    }

    public final void c(WeakReference<Activity> weakReference) {
        this.f63377a.add(weakReference);
    }

    public final void d(Activity activity) {
        if (this.f63377a != null) {
            for (int i2 = 0; i2 < this.f63377a.size(); i2++) {
                if (this.f63377a.get(i2).get() == activity) {
                    Stack<WeakReference<Activity>> stack = this.f63377a;
                    stack.remove(stack.get(i2));
                }
            }
        }
        b();
    }

    public d() {
        this.f63377a = new Stack<>();
    }
}
