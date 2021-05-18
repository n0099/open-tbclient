package d.a.i0.a.z1.b.c;

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
    public final ViewGroup f45966a;

    /* renamed from: b  reason: collision with root package name */
    public int f45967b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45968c;

    /* renamed from: d.a.i0.a.z1.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0924a {
        a getFloatLayer();
    }

    public a(@NonNull InterfaceC0924a interfaceC0924a, @NonNull ViewGroup viewGroup, int i2) {
        this.f45966a = viewGroup;
        this.f45967b = i2;
    }

    @Nullable
    public final Container a() {
        synchronized (this.f45966a) {
            for (int i2 = 0; i2 < this.f45966a.getChildCount(); i2++) {
                View childAt = this.f45966a.getChildAt(i2);
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
        synchronized (this.f45966a) {
            a2 = a();
            if (a2 == null) {
                a2 = new Container(c());
                int height = this.f45966a.getHeight() - this.f45967b;
                int i2 = this.f45966a instanceof LinearLayout ? -height : this.f45967b;
                if (height <= 0) {
                    height = -1;
                    i2 = 0;
                }
                if (!(this.f45966a instanceof LinearLayout) && this.f45967b == 0) {
                    height = -1;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, height);
                layoutParams.setMargins(0, i2, 0, 0);
                a2.setLayoutParams(layoutParams);
                this.f45966a.addView(a2);
            }
        }
        return a2;
    }

    public final Context c() {
        return this.f45966a.getContext();
    }

    public boolean d() {
        return this.f45968c;
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
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = a2.getChildAt(i2);
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
        synchronized (this.f45966a) {
            Container a2 = a();
            if (!z || a2 == null || a2.getChildCount() <= 0) {
                if (a2 != null) {
                    this.f45966a.removeView(a2);
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

    public void j(boolean z) {
        this.f45968c = z;
        this.f45967b = 0;
    }

    public void k(@NonNull View view) {
        if (view != e()) {
            g();
            b().addView(view);
        }
    }

    public void l(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        if (view != e()) {
            g();
            b().addView(view, layoutParams);
        }
    }
}
