package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* loaded from: classes7.dex */
public class fz implements gd {

    /* renamed from: a  reason: collision with root package name */
    public String f38442a;

    /* renamed from: a  reason: collision with other field name */
    public List<fz> f415a;

    /* renamed from: a  reason: collision with other field name */
    public String[] f416a;

    /* renamed from: b  reason: collision with root package name */
    public String f38443b;

    /* renamed from: b  reason: collision with other field name */
    public String[] f417b;

    /* renamed from: c  reason: collision with root package name */
    public String f38444c;

    public fz(String str, String str2, String[] strArr, String[] strArr2) {
        this.f416a = null;
        this.f417b = null;
        this.f415a = null;
        this.f38442a = str;
        this.f38443b = str2;
        this.f416a = strArr;
        this.f417b = strArr2;
    }

    public fz(String str, String str2, String[] strArr, String[] strArr2, String str3, List<fz> list) {
        this.f416a = null;
        this.f417b = null;
        this.f415a = null;
        this.f38442a = str;
        this.f38443b = str2;
        this.f416a = strArr;
        this.f417b = strArr2;
        this.f38444c = str3;
        this.f415a = list;
    }

    public static fz a(Bundle bundle) {
        ArrayList arrayList;
        String string = bundle.getString("ext_ele_name");
        String string2 = bundle.getString("ext_ns");
        String string3 = bundle.getString("ext_text");
        Bundle bundle2 = bundle.getBundle("attributes");
        Set<String> keySet = bundle2.keySet();
        String[] strArr = new String[keySet.size()];
        String[] strArr2 = new String[keySet.size()];
        int i2 = 0;
        for (String str : keySet) {
            strArr[i2] = str;
            strArr2[i2] = bundle2.getString(str);
            i2++;
        }
        if (bundle.containsKey("children")) {
            Parcelable[] parcelableArray = bundle.getParcelableArray("children");
            ArrayList arrayList2 = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList2.add(a((Bundle) parcelable));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new fz(string, string2, strArr, strArr2, string3, arrayList);
    }

    public static Parcelable[] a(List<fz> list) {
        return a((fz[]) list.toArray(new fz[list.size()]));
    }

    public static Parcelable[] a(fz[] fzVarArr) {
        if (fzVarArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[fzVarArr.length];
        for (int i2 = 0; i2 < fzVarArr.length; i2++) {
            parcelableArr[i2] = fzVarArr[i2].m321a();
        }
        return parcelableArr;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.f38442a);
        bundle.putString("ext_ns", this.f38443b);
        bundle.putString("ext_text", this.f38444c);
        Bundle bundle2 = new Bundle();
        String[] strArr = this.f416a;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.f416a;
                if (i2 >= strArr2.length) {
                    break;
                }
                bundle2.putString(strArr2[i2], this.f417b[i2]);
                i2++;
            }
        }
        bundle.putBundle("attributes", bundle2);
        List<fz> list = this.f415a;
        if (list != null && list.size() > 0) {
            bundle.putParcelableArray("children", a(this.f415a));
        }
        return bundle;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Parcelable m321a() {
        return a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m322a() {
        return this.f38442a;
    }

    public String a(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (this.f416a == null) {
            return null;
        }
        int i2 = 0;
        while (true) {
            String[] strArr = this.f416a;
            if (i2 >= strArr.length) {
                return null;
            }
            if (str.equals(strArr[i2])) {
                return this.f417b[i2];
            }
            i2++;
        }
    }

    public void a(fz fzVar) {
        if (this.f415a == null) {
            this.f415a = new ArrayList();
        }
        if (this.f415a.contains(fzVar)) {
            return;
        }
        this.f415a.add(fzVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m323a(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = gn.a(str);
        }
        this.f38444c = str;
    }

    public String b() {
        return this.f38443b;
    }

    public String c() {
        return !TextUtils.isEmpty(this.f38444c) ? gn.b(this.f38444c) : this.f38444c;
    }

    @Override // com.xiaomi.push.gd
    public String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(this.f38442a);
        if (!TextUtils.isEmpty(this.f38443b)) {
            sb.append(" ");
            sb.append("xmlns=");
            sb.append("\"");
            sb.append(this.f38443b);
            sb.append("\"");
        }
        String[] strArr = this.f416a;
        if (strArr != null && strArr.length > 0) {
            for (int i2 = 0; i2 < this.f416a.length; i2++) {
                if (!TextUtils.isEmpty(this.f417b[i2])) {
                    sb.append(" ");
                    sb.append(this.f416a[i2]);
                    sb.append("=\"");
                    sb.append(gn.a(this.f417b[i2]));
                    sb.append("\"");
                }
            }
        }
        if (TextUtils.isEmpty(this.f38444c)) {
            List<fz> list = this.f415a;
            if (list == null || list.size() <= 0) {
                sb.append("/>");
                return sb.toString();
            }
            sb.append(">");
            for (fz fzVar : this.f415a) {
                sb.append(fzVar.d());
            }
        } else {
            sb.append(">");
            sb.append(this.f38444c);
        }
        sb.append("</");
        sb.append(this.f38442a);
        sb.append(">");
        return sb.toString();
    }

    public String toString() {
        return d();
    }
}
