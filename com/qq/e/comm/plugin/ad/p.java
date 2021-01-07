package com.qq.e.comm.plugin.ad;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public abstract class p {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Object> f12204a = new HashMap();

    private void a(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        this.f12204a.put(str, obj);
    }

    public String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Object obj = this.f12204a.get(str);
        if (obj != null) {
            try {
                str2 = (String) obj;
            } catch (ClassCastException e) {
                return null;
            }
        } else {
            str2 = null;
        }
        return str2;
    }

    public void a(String str, int i) {
        a(str, Integer.valueOf(i));
    }

    public void a(String str, String str2) {
        a(str, (Object) str2);
    }

    public void a(String str, boolean z) {
        a(str, Boolean.valueOf(z));
    }

    public int b(String str) {
        Object obj;
        if (!TextUtils.isEmpty(str) && (obj = this.f12204a.get(str)) != null) {
            try {
                return ((Integer) obj).intValue();
            } catch (ClassCastException e) {
                return 0;
            }
        }
        return 0;
    }

    public boolean c(String str) {
        boolean booleanValue;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Object obj = this.f12204a.get(str);
        if (obj != null) {
            try {
                booleanValue = ((Boolean) obj).booleanValue();
            } catch (ClassCastException e) {
                return false;
            }
        } else {
            booleanValue = false;
        }
        return booleanValue;
    }
}
