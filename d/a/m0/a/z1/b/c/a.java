package d.a.m0.a.z1.b.c;

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
    public final ViewGroup f49924a;

    /* renamed from: b  reason: collision with root package name */
    public int f49925b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f49926c;

    /* renamed from: d.a.m0.a.z1.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0994a {
        a getFloatLayer();
    }

    public a(@NonNull InterfaceC0994a interfaceC0994a, @NonNull ViewGroup viewGroup, int i2) {
        this.f49924a = viewGroup;
        this.f49925b = i2;
    }

    @Nullable
    public final Container a() {
        synchronized (this.f49924a) {
            for (int i2 = 0; i2 < this.f49924a.getChildCount(); i2++) {
                View childAt = this.f49924a.getChildAt(i2);
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
        synchronized (this.f49924a) {
            a2 = a();
            if (a2 == null) {
                a2 = new Container(c());
                int height = this.f49924a.getHeight() - this.f49925b;
                int i2 = this.f49924a instanceof LinearLayout ? -height : this.f49925b;
                if (height <= 0) {
                    height = -1;
                    i2 = 0;
                }
                if (!(this.f49924a instanceof LinearLayout) && this.f49925b == 0) {
                    height = -1;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, height);
                layoutParams.setMargins(0, i2, 0, 0);
                a2.setLayoutParams(layoutParams);
                this.f49924a.addView(a2);
            }
        }
        return a2;
    }

    public final Context c() {
        return this.f49924a.getContext();
    }

    public boolean d() {
        return this.f49926c;
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
        synchronized (this.f49924a) {
            Container a2 = a();
            if (!z || a2 == null || a2.getChildCount() <= 0) {
                if (a2 != null) {
                    this.f49924a.removeView(a2);
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
        this.f49926c = z;
        this.f49925b = 0;
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
