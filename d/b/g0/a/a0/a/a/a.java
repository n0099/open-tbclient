package d.b.g0.a.a0.a.a;

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
import d.b.g0.a.a0.a.a.b;
/* loaded from: classes3.dex */
public abstract class a<V extends SwanEditText, M extends b> extends d.b.g0.a.a0.a.c.a<V, M> {
    public a(@Nullable Context context, @NonNull M m) {
        super(context, m);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.a0.a.c.a, d.b.g0.a.a0.a.d.a, d.b.g0.a.a0.b.a
    @NonNull
    /* renamed from: c0 */
    public d.b.g0.a.a0.f.b k(@NonNull M m, @NonNull M m2) {
        d.b.g0.a.a0.f.b k = super.k(m, m2);
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

    public void d0(@NonNull V v, @NonNull M m, @NonNull d.b.g0.a.a0.f.b bVar) {
        super.Q(v, m, bVar);
        if (bVar.a(11)) {
            g0(v, m);
        }
        if (bVar.a(12)) {
            i0(v, m);
        }
        if (bVar.a(10)) {
            h0(v, m);
        }
        if (bVar.a(13)) {
            f0(v, m);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.a0.a.d.a
    /* renamed from: e0 */
    public void S(@NonNull V v, @NonNull M m) {
        if (d.b.g0.a.a0.b.a.f43099h) {
            Log.d("Component-EditText", "renderBackground");
        }
        v.setBackgroundColor(0);
    }

    public boolean f0(@NonNull V v, @NonNull M m) {
        if (d.b.g0.a.a0.b.a.f43099h) {
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

    public void g0(@NonNull V v, @NonNull M m) {
        if (d.b.g0.a.a0.b.a.f43099h) {
            Log.d("Component-EditText", "renderCursor");
        }
        Editable text = v.getText();
        int length = text != null ? text.length() : 0;
        int i = m.I;
        if (i > length || i < 0) {
            return;
        }
        v.setSelection(i);
    }

    public final void h0(@NonNull V v, @NonNull M m) {
        if (d.b.g0.a.a0.b.a.f43099h) {
            Log.d("Component-EditText", "renderMaxLength");
        }
        if (m.G >= 0) {
            v.setFilters(new InputFilter[]{new InputFilter.LengthFilter(m.G)});
        }
    }

    public void i0(@NonNull V v, @NonNull M m) {
        int i;
        if (d.b.g0.a.a0.b.a.f43099h) {
            Log.d("Component-EditText", "renderSelection");
        }
        Editable text = v.getText();
        int length = text != null ? text.length() : 0;
        int i2 = m.K;
        if (i2 > length || (i = m.J) < 0 || i > i2) {
            return;
        }
        v.setSelection(i, i2);
    }
}
