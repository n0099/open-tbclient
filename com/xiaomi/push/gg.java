package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* loaded from: classes18.dex */
public class gg implements gk {

    /* renamed from: a  reason: collision with root package name */
    private String f4921a;

    /* renamed from: a  reason: collision with other field name */
    private List<gg> f390a;

    /* renamed from: a  reason: collision with other field name */
    private String[] f391a;
    private String b;

    /* renamed from: b  reason: collision with other field name */
    private String[] f392b;
    private String c;

    public gg(String str, String str2, String[] strArr, String[] strArr2) {
        this.f391a = null;
        this.f392b = null;
        this.f390a = null;
        this.f4921a = str;
        this.b = str2;
        this.f391a = strArr;
        this.f392b = strArr2;
    }

    public gg(String str, String str2, String[] strArr, String[] strArr2, String str3, List<gg> list) {
        this.f391a = null;
        this.f392b = null;
        this.f390a = null;
        this.f4921a = str;
        this.b = str2;
        this.f391a = strArr;
        this.f392b = strArr2;
        this.c = str3;
        this.f390a = list;
    }

    public static gg a(Bundle bundle) {
        ArrayList arrayList;
        String string = bundle.getString("ext_ele_name");
        String string2 = bundle.getString("ext_ns");
        String string3 = bundle.getString("ext_text");
        Bundle bundle2 = bundle.getBundle("attributes");
        Set<String> keySet = bundle2.keySet();
        String[] strArr = new String[keySet.size()];
        String[] strArr2 = new String[keySet.size()];
        int i = 0;
        for (String str : keySet) {
            strArr[i] = str;
            strArr2[i] = bundle2.getString(str);
            i++;
        }
        if (bundle.containsKey("children")) {
            Parcelable[] parcelableArray = bundle.getParcelableArray("children");
            arrayList = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList.add(a((Bundle) parcelable));
            }
        } else {
            arrayList = null;
        }
        return new gg(string, string2, strArr, strArr2, string3, arrayList);
    }

    public static Parcelable[] a(List<gg> list) {
        return a((gg[]) list.toArray(new gg[list.size()]));
    }

    public static Parcelable[] a(gg[] ggVarArr) {
        if (ggVarArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[ggVarArr.length];
        for (int i = 0; i < ggVarArr.length; i++) {
            parcelableArr[i] = ggVarArr[i].m314a();
        }
        return parcelableArr;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.f4921a);
        bundle.putString("ext_ns", this.b);
        bundle.putString("ext_text", this.c);
        Bundle bundle2 = new Bundle();
        if (this.f391a != null && this.f391a.length > 0) {
            for (int i = 0; i < this.f391a.length; i++) {
                bundle2.putString(this.f391a[i], this.f392b[i]);
            }
        }
        bundle.putBundle("attributes", bundle2);
        if (this.f390a != null && this.f390a.size() > 0) {
            bundle.putParcelableArray("children", a(this.f390a));
        }
        return bundle;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Parcelable m314a() {
        return a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m315a() {
        return this.f4921a;
    }

    public String a(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (this.f391a != null) {
            for (int i = 0; i < this.f391a.length; i++) {
                if (str.equals(this.f391a[i])) {
                    return this.f392b[i];
                }
            }
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m316a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.c = str;
        } else {
            this.c = gu.a(str);
        }
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return !TextUtils.isEmpty(this.c) ? gu.b(this.c) : this.c;
    }

    @Override // com.xiaomi.push.gk
    public String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(this.f4921a);
        if (!TextUtils.isEmpty(this.b)) {
            sb.append(" ").append("xmlns=").append("\"").append(this.b).append("\"");
        }
        if (this.f391a != null && this.f391a.length > 0) {
            for (int i = 0; i < this.f391a.length; i++) {
                if (!TextUtils.isEmpty(this.f392b[i])) {
                    sb.append(" ").append(this.f391a[i]).append("=\"").append(gu.a(this.f392b[i])).append("\"");
                }
            }
        }
        if (!TextUtils.isEmpty(this.c)) {
            sb.append(">").append(this.c).append("</").append(this.f4921a).append(">");
        } else if (this.f390a == null || this.f390a.size() <= 0) {
            sb.append("/>");
        } else {
            sb.append(">");
            for (gg ggVar : this.f390a) {
                sb.append(ggVar.d());
            }
            sb.append("</").append(this.f4921a).append(">");
        }
        return sb.toString();
    }

    public String toString() {
        return d();
    }
}
