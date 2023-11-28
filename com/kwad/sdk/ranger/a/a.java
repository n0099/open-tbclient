package com.kwad.sdk.ranger.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.List;
@KsJson
/* loaded from: classes10.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public static final String TAG = "Ranger_" + a.class.getSimpleName();
    public Object aLU;
    public String aLV;
    public String aLW;
    public boolean aLX;
    @NonNull
    public String aLY;
    public b aLZ;
    public a aMa;

    @KsJson
    /* renamed from: com.kwad.sdk.ranger.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0725a extends com.kwad.sdk.core.response.a.a {
        public String aMb;
        public String aMc;
        public String aMd;
        public List<String> aMe;
        public List<C0725a> aMf = new ArrayList();
        public Object aMg;
        public List<Object> aMh;
        public String className;
        public String fieldName;

        public final Object getValue() {
            if (TextUtils.isEmpty(this.aMb) && TextUtils.isEmpty(this.aMd)) {
                return Jf();
            }
            return Jg();
        }

        private Object Jf() {
            Object obj = null;
            try {
            } catch (Exception e) {
                c.d(a.TAG, Log.getStackTraceString(e));
            }
            if (TextUtils.isEmpty(this.className)) {
                c.w(a.TAG, "SpecialParam className is null");
                return null;
            }
            obj = s.fO(this.className);
            String str = a.TAG;
            c.d(str, "Class.forName(className):" + this.className + " value:" + obj);
            if (this.aMf != null && !this.aMf.isEmpty()) {
                for (C0725a c0725a : this.aMf) {
                    c0725a.aMg = obj;
                    String str2 = a.TAG;
                    c.d(str2, "param.ob:" + c0725a.aMg);
                    try {
                        s.a(c0725a.aMg, c0725a.fieldName, c0725a.getValue());
                    } catch (Exception e2) {
                        c.d(a.TAG, Log.getStackTraceString(e2));
                    }
                }
            }
            String str3 = a.TAG;
            c.d(str3, "return value in special:" + obj);
            return obj;
        }

        private Object Jg() {
            if (TextUtils.isEmpty(this.aMd)) {
                return am(this.aMb, this.aMc);
            }
            this.aMh = new ArrayList();
            for (String str : this.aMe) {
                Object am = am(this.aMd, str);
                if (am != null) {
                    this.aMh.add(am);
                }
            }
            return this.aMh;
        }

        public static Object am(String str, String str2) {
            Object obj = null;
            try {
                Class<?> cls = Class.forName(str);
                if (cls == Integer.class) {
                    obj = Integer.valueOf(Integer.parseInt(str2));
                } else if (cls == Long.class) {
                    obj = Long.valueOf(Long.parseLong(str2));
                } else if (cls == Float.class) {
                    obj = Float.valueOf(Float.parseFloat(str2));
                } else if (cls == Boolean.class) {
                    obj = Boolean.valueOf(Boolean.parseBoolean(str2));
                } else if (cls == Double.class) {
                    obj = Double.valueOf(Double.parseDouble(str2));
                } else {
                    if (cls != String.class) {
                        str2 = null;
                    }
                    obj = str2;
                }
            } catch (Exception e) {
                c.w(a.TAG, Log.getStackTraceString(e));
            }
            return obj;
        }
    }

    @KsJson
    /* loaded from: classes10.dex */
    public static class b extends com.kwad.sdk.core.response.a.a {
        public boolean aMi;
        public List<C0725a> aMj;
        public Object[] aMk;
        public String name;

        public final boolean Je() {
            if (TextUtils.isEmpty(this.name)) {
                List<C0725a> list = this.aMj;
                if ((list == null || list.isEmpty()) && this.aMk == null) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public final Object[] Jh() {
            List<C0725a> list = this.aMj;
            if (list != null && !list.isEmpty()) {
                Object[] objArr = new Object[this.aMj.size()];
                for (int i = 0; i < this.aMj.size(); i++) {
                    objArr[i] = this.aMj.get(i).getValue();
                }
                return objArr;
            }
            return null;
        }
    }

    public final boolean Je() {
        if (this.aLU == null && TextUtils.isEmpty(this.aLV) && TextUtils.isEmpty(this.aLW) && TextUtils.isEmpty(this.aLY)) {
            b bVar = this.aLZ;
            if (bVar == null || bVar.Je()) {
                a aVar = this.aMa;
                if (aVar == null || aVar.Je()) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
