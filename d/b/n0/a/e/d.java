package d.b.n0.a.e;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public Stack<WeakReference<Activity>> f65066a;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f65067a = new d((byte) 0);
    }

    public /* synthetic */ d(byte b2) {
        this();
    }

    public final Stack<WeakReference<Activity>> a() {
        return this.f65066a;
    }

    public final String b() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f65066a.size(); i++) {
            Activity activity = this.f65066a.get(i).get();
            if (activity != null) {
                sb.append(activity.getClass().getSimpleName());
                sb.append("->");
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "没有路径了";
    }

    public final void c(WeakReference<Activity> weakReference) {
        this.f65066a.add(weakReference);
    }

    public final void d(Activity activity) {
        if (this.f65066a != null) {
            for (int i = 0; i < this.f65066a.size(); i++) {
                if (this.f65066a.get(i).get() == activity) {
                    Stack<WeakReference<Activity>> stack = this.f65066a;
                    stack.remove(stack.get(i));
                }
            }
        }
        b();
    }

    public d() {
        this.f65066a = new Stack<>();
    }
}
