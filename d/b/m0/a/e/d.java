package d.b.m0.a.e;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public Stack<WeakReference<Activity>> f64070a;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f64071a = new d((byte) 0);
    }

    public /* synthetic */ d(byte b2) {
        this();
    }

    public final Stack<WeakReference<Activity>> a() {
        return this.f64070a;
    }

    public final String b() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f64070a.size(); i++) {
            Activity activity = this.f64070a.get(i).get();
            if (activity != null) {
                sb.append(activity.getClass().getSimpleName());
                sb.append("->");
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "没有路径了";
    }

    public final void c(WeakReference<Activity> weakReference) {
        this.f64070a.add(weakReference);
    }

    public final void d(Activity activity) {
        if (this.f64070a != null) {
            for (int i = 0; i < this.f64070a.size(); i++) {
                if (this.f64070a.get(i).get() == activity) {
                    Stack<WeakReference<Activity>> stack = this.f64070a;
                    stack.remove(stack.get(i));
                }
            }
        }
        b();
    }

    public d() {
        this.f64070a = new Stack<>();
    }
}
