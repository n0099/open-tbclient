package d.b.h0.a.a0.a.c;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import d.b.h0.a.a0.a.c.b;
import d.b.h0.a.c0.c;
/* loaded from: classes2.dex */
public abstract class a<V extends TextView, M extends b> extends d.b.h0.a.a0.a.d.a<V, M> {
    public a(@Nullable Context context, @NonNull M m) {
        super(context, m);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.a0.a.d.a, d.b.h0.a.a0.b.a
    @NonNull
    /* renamed from: U */
    public d.b.h0.a.a0.f.b k(@NonNull M m, @NonNull M m2) {
        d.b.h0.a.a0.f.b k = super.k(m, m2);
        if (!TextUtils.equals(m.x, m2.x)) {
            k.b(6);
        }
        return k;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.a0.a.d.a
    /* renamed from: V */
    public void Q(@NonNull V v, @NonNull M m, @NonNull d.b.h0.a.a0.f.b bVar) {
        super.D(v, m, bVar);
        if (bVar.a(6)) {
            W(v, m);
        }
        if (bVar.a(4)) {
            X(v, m);
        }
    }

    public void W(@NonNull V v, @NonNull M m) {
        if (d.b.h0.a.a0.b.a.f43821h) {
            Log.d("Component-TextView", "renderText");
        }
        v.setText(m.x);
    }

    public final void X(@NonNull V v, @NonNull M m) {
        if (m.n == null) {
            return;
        }
        if (d.b.h0.a.a0.b.a.f43821h) {
            Log.d("Component-TextView", "renderTextStyle");
        }
        if (m.z) {
            v.setTextColor(m.y);
        }
        float f2 = (float) m.A;
        if (f2 > 0.0f) {
            v.setTextSize(1, f2);
        }
        Z(v, m);
        a0(v, m);
        Y(v, m);
        String str = m.E;
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1039745817) {
            if (hashCode == -1039592053 && str.equals("nowrap")) {
                c2 = 1;
            }
        } else if (str.equals("normal")) {
            c2 = 0;
        }
        if (c2 == 0) {
            v.setSingleLine(false);
        } else if (c2 == 1) {
            v.setSingleLine(true);
        }
        if ("ellipsis".equals(m.F)) {
            v.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    public void Y(@NonNull V v, @NonNull M m) {
        if (m.n == null) {
            return;
        }
        if (d.b.h0.a.a0.b.a.f43821h) {
            Log.d("Component-TextView", "renderTextStyleFontWeight");
        }
        String str = m.D;
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1039745817) {
            if (hashCode == 3029637 && str.equals("bold")) {
                c2 = 1;
            }
        } else if (str.equals("normal")) {
            c2 = 0;
        }
        if (c2 == 0) {
            v.setTypeface(Typeface.SANS_SERIF, 0);
        } else if (c2 != 1) {
            c.l("Component-TextView", "invalid font weight : " + m.D);
            v.setTypeface(Typeface.SANS_SERIF, 0);
        } else {
            v.setTypeface(Typeface.SANS_SERIF, 1);
        }
    }

    public void Z(@NonNull V v, @NonNull M m) {
        if (m.n == null) {
            return;
        }
        if (d.b.h0.a.a0.b.a.f43821h) {
            Log.d("Component-TextView", "renderTextStyleLineSpace");
        }
        int i = m.B;
        if (i > 0) {
            v.setPadding(v.getPaddingLeft(), v.getPaddingTop() + (i / 2), v.getPaddingRight(), v.getPaddingBottom());
            v.setLineSpacing(i, 1.0f);
        }
    }

    public void a0(@NonNull V v, @NonNull M m) {
        b0(v, m, 48);
    }

    public final void b0(@NonNull V v, @NonNull M m, int i) {
        int i2;
        if (m.n == null) {
            return;
        }
        if (d.b.h0.a.a0.b.a.f43821h) {
            Log.d("Component-TextView", "renderTextStyleTextAlign");
        }
        String str = m.C;
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1364013995) {
            if (hashCode != 3317767) {
                if (hashCode == 108511772 && str.equals("right")) {
                    c2 = 1;
                }
            } else if (str.equals(CustomDialogData.POS_LEFT)) {
                c2 = 0;
            }
        } else if (str.equals("center")) {
            c2 = 2;
        }
        if (c2 != 0) {
            if (c2 == 1) {
                i2 = 8388613 | i;
            } else if (c2 != 2) {
                c.l("Component-TextView", "invalid text align: " + m.C);
            } else {
                i2 = i | 1;
            }
            v.setGravity(i2);
        }
        i2 = i | GravityCompat.START;
        v.setGravity(i2);
    }
}
