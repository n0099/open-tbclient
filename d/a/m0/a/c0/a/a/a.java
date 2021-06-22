package d.a.m0.a.c0.a.a;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import d.a.m0.a.c0.a.a.b;
/* loaded from: classes2.dex */
public abstract class a<V extends SwanEditText, M extends b> extends d.a.m0.a.c0.a.c.b<V, M> {
    public a(@Nullable Context context, @NonNull M m) {
        super(context, m);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.c0.a.c.b, d.a.m0.a.c0.a.d.a, d.a.m0.a.c0.b.a
    @NonNull
    /* renamed from: b0 */
    public d.a.m0.a.c0.f.b k(@NonNull M m, @NonNull M m2) {
        d.a.m0.a.c0.f.b k = super.k(m, m2);
        if (q() != 0 && !TextUtils.equals(((SwanEditText) q()).getText().toString(), m2.x)) {
            k.b(6);
        }
        if (m.G != m2.G) {
            k.b(10);
        }
        if (m.I != m2.I) {
            k.b(11);
        }
        if (m.J != m2.J || m.K != m2.K) {
            k.b(12);
        }
        if (!TextUtils.equals(m.L, m2.L)) {
            k.b(13);
        }
        return k;
    }

    public void c0(@NonNull V v, @NonNull M m, @NonNull d.a.m0.a.c0.f.b bVar) {
        super.Q(v, m, bVar);
        if (bVar.a(11)) {
            f0(v, m);
        }
        if (bVar.a(12)) {
            h0(v, m);
        }
        if (bVar.a(10)) {
            g0(v, m);
        }
        if (bVar.a(13)) {
            e0(v, m);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.c0.a.d.a
    /* renamed from: d0 */
    public void S(@NonNull V v, @NonNull M m) {
        if (d.a.m0.a.c0.b.a.f44616h) {
            Log.d("Component-EditText", "renderBackground");
        }
        v.setBackgroundColor(0);
    }

    public boolean e0(@NonNull V v, @NonNull M m) {
        if (d.a.m0.a.c0.b.a.f44616h) {
            Log.d("Component-EditText", "renderConfirmType:" + m.L);
        }
        String str = m.L;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -906336856:
                if (str.equals("search")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3304:
                if (str.equals("go")) {
                    c2 = 3;
                    break;
                }
                break;
            case 3089282:
                if (str.equals(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE)) {
                    c2 = 4;
                    break;
                }
                break;
            case 3377907:
                if (str.equals(UnitedSchemeConstants.UNITED_SCHEME_NEXT)) {
                    c2 = 2;
                    break;
                }
                break;
            case 3526536:
                if (str.equals("send")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            v.setImeOptions(4);
        } else if (c2 == 1) {
            v.setImeOptions(3);
        } else if (c2 == 2) {
            v.setImeOptions(5);
        } else if (c2 == 3) {
            v.setImeOptions(2);
        } else if (c2 != 4) {
            return false;
        } else {
            v.setImeOptions(6);
        }
        return true;
    }

    public void f0(@NonNull V v, @NonNull M m) {
        if (d.a.m0.a.c0.b.a.f44616h) {
            Log.d("Component-EditText", "renderCursor");
        }
        Editable text = v.getText();
        int length = text != null ? text.length() : 0;
        int i2 = m.I;
        if (i2 > length || i2 < 0) {
            return;
        }
        v.setSelection(i2);
    }

    public final void g0(@NonNull V v, @NonNull M m) {
        if (d.a.m0.a.c0.b.a.f44616h) {
            Log.d("Component-EditText", "renderMaxLength");
        }
        if (m.G >= 0) {
            v.setFilters(new InputFilter[]{new InputFilter.LengthFilter(m.G)});
        }
    }

    public void h0(@NonNull V v, @NonNull M m) {
        int i2;
        if (d.a.m0.a.c0.b.a.f44616h) {
            Log.d("Component-EditText", "renderSelection");
        }
        Editable text = v.getText();
        int length = text != null ? text.length() : 0;
        int i3 = m.K;
        if (i3 > length || (i2 = m.J) < 0 || i2 > i3) {
            return;
        }
        v.setSelection(i2, i3);
    }
}
