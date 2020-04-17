package tv.chushou.basis.c;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class b implements a {
    private final Map<String, Object> nqU = new ConcurrentHashMap();

    @Override // tv.chushou.basis.c.a
    public String getString(String str, @Nullable String str2) {
        Object obj = get(str);
        return obj instanceof String ? (String) obj : str2;
    }

    @Override // tv.chushou.basis.c.a
    public void putString(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str2 != null) {
            this.nqU.put(str, str2);
        }
    }

    @Override // tv.chushou.basis.c.a
    public int getInt(String str, int i) {
        Object obj = get(str);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return i;
    }

    @Override // tv.chushou.basis.c.a
    public void putInt(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.nqU.put(str, Integer.valueOf(i));
        }
    }

    @Override // tv.chushou.basis.c.a
    public void putBoolean(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.nqU.put(str, Boolean.valueOf(z));
        }
    }

    @Nullable
    public Object get(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.nqU.get(str);
    }

    @Override // tv.chushou.basis.c.a
    public Object remove(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.nqU.remove(str);
    }
}
