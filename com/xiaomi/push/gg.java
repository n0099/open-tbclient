package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* loaded from: classes6.dex */
public class gg implements gk {

    /* renamed from: a  reason: collision with root package name */
    private String f14343a;

    /* renamed from: a  reason: collision with other field name */
    private List<gg> f467a;

    /* renamed from: a  reason: collision with other field name */
    private String[] f468a;

    /* renamed from: b  reason: collision with root package name */
    private String f14344b;

    /* renamed from: b  reason: collision with other field name */
    private String[] f469b;
    private String c;

    public gg(String str, String str2, String[] strArr, String[] strArr2) {
        this.f468a = null;
        this.f469b = null;
        this.f467a = null;
        this.f14343a = str;
        this.f14344b = str2;
        this.f468a = strArr;
        this.f469b = strArr2;
    }

    public gg(String str, String str2, String[] strArr, String[] strArr2, String str3, List<gg> list) {
        this.f468a = null;
        this.f469b = null;
        this.f467a = null;
        this.f14343a = str;
        this.f14344b = str2;
        this.f468a = strArr;
        this.f469b = strArr2;
        this.c = str3;
        this.f467a = list;
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
            parcelableArr[i] = ggVarArr[i].m341a();
        }
        return parcelableArr;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.f14343a);
        bundle.putString("ext_ns", this.f14344b);
        bundle.putString("ext_text", this.c);
        Bundle bundle2 = new Bundle();
        if (this.f468a != null && this.f468a.length > 0) {
            for (int i = 0; i < this.f468a.length; i++) {
                bundle2.putString(this.f468a[i], this.f469b[i]);
            }
        }
        bundle.putBundle("attributes", bundle2);
        if (this.f467a != null && this.f467a.size() > 0) {
            bundle.putParcelableArray("children", a(this.f467a));
        }
        return bundle;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Parcelable m341a() {
        return a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m342a() {
        return this.f14343a;
    }

    public String a(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (this.f468a != null) {
            for (int i = 0; i < this.f468a.length; i++) {
                if (str.equals(this.f468a[i])) {
                    return this.f469b[i];
                }
            }
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m343a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.c = str;
        } else {
            this.c = gu.a(str);
        }
    }

    public String b() {
        return this.f14344b;
    }

    public String c() {
        return !TextUtils.isEmpty(this.c) ? gu.b(this.c) : this.c;
    }

    @Override // com.xiaomi.push.gk
    public String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(this.f14343a);
        if (!TextUtils.isEmpty(this.f14344b)) {
            sb.append(" ").append("xmlns=").append("\"").append(this.f14344b).append("\"");
        }
        if (this.f468a != null && this.f468a.length > 0) {
            for (int i = 0; i < this.f468a.length; i++) {
                if (!TextUtils.isEmpty(this.f469b[i])) {
                    sb.append(" ").append(this.f468a[i]).append("=\"").append(gu.a(this.f469b[i])).append("\"");
                }
            }
        }
        if (!TextUtils.isEmpty(this.c)) {
            sb.append(">").append(this.c).append("</").append(this.f14343a).append(">");
        } else if (this.f467a == null || this.f467a.size() <= 0) {
            sb.append("/>");
        } else {
            sb.append(">");
            for (gg ggVar : this.f467a) {
                sb.append(ggVar.d());
            }
            sb.append("</").append(this.f14343a).append(">");
        }
        return sb.toString();
    }

    public String toString() {
        return d();
    }
}
