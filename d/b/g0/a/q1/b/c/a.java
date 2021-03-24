package d.b.g0.a.q1.b.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.res.widget.floatlayer.Container;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroup f45620a;

    /* renamed from: b  reason: collision with root package name */
    public int f45621b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45622c;

    /* renamed from: d.b.g0.a.q1.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0764a {
        a getFloatLayer();
    }

    public a(@NonNull InterfaceC0764a interfaceC0764a, @NonNull ViewGroup viewGroup, int i) {
        this.f45620a = viewGroup;
        this.f45621b = i;
    }

    @Nullable
    public final Container a() {
        synchronized (this.f45620a) {
            for (int i = 0; i < this.f45620a.getChildCount(); i++) {
                View childAt = this.f45620a.getChildAt(i);
                if (childAt instanceof Container) {
                    return (Container) childAt;
                }
            }
            return null;
        }
    }

    @NonNull
    public final Container b() {
        Container a2;
        synchronized (this.f45620a) {
            a2 = a();
            if (a2 == null) {
                a2 = new Container(c());
                int height = this.f45620a.getHeight() - this.f45621b;
                int i = this.f45620a instanceof LinearLayout ? -height : this.f45621b;
                if (height <= 0) {
                    height = -1;
                    i = 0;
                }
                if (!(this.f45620a instanceof LinearLayout) && this.f45621b == 0) {
                    height = -1;
                }
                if (this.f45622c) {
                    height = -1;
                    i = 0;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, height);
                layoutParams.setMargins(0, i, 0, 0);
                a2.setLayoutParams(layoutParams);
                this.f45620a.addView(a2);
            }
        }
        return a2;
    }

    public final Context c() {
        return this.f45620a.getContext();
    }

    public boolean d() {
        return this.f45622c;
    }

    @Nullable
    public View e() {
        Container a2 = a();
        if (a2 != null && a2.getChildCount() > 0) {
            return a2.getChildAt(0);
        }
        return null;
    }

    public boolean f() {
        Container a2 = a();
        if (a2 == null) {
            return false;
        }
        int childCount = a2.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = a2.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void g() {
        h(false);
    }

    public void h(boolean z) {
        synchronized (this.f45620a) {
            Container a2 = a();
            if (!z || a2 == null || a2.getChildCount() <= 0) {
                if (a2 != null) {
                    this.f45620a.removeView(a2);
                }
            }
        }
    }

    public void i(boolean z) {
        Container a2 = a();
        if (a2 != null) {
            a2.setClickable(z);
        }
    }

    public void j(@NonNull View view) {
        if (view != e()) {
            g();
            b().addView(view);
        }
    }

    public void k(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        if (view != e()) {
            g();
            b().addView(view, layoutParams);
        }
    }
}
