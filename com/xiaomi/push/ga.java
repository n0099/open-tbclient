package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* loaded from: classes8.dex */
public class ga implements ge {
    private String a;

    /* renamed from: a  reason: collision with other field name */
    private List<ga> f400a;

    /* renamed from: a  reason: collision with other field name */
    private String[] f401a;
    private String b;

    /* renamed from: b  reason: collision with other field name */
    private String[] f402b;
    private String c;

    public ga(String str, String str2, String[] strArr, String[] strArr2) {
        this.f401a = null;
        this.f402b = null;
        this.f400a = null;
        this.a = str;
        this.b = str2;
        this.f401a = strArr;
        this.f402b = strArr2;
    }

    public ga(String str, String str2, String[] strArr, String[] strArr2, String str3, List<ga> list) {
        this.f401a = null;
        this.f402b = null;
        this.f400a = null;
        this.a = str;
        this.b = str2;
        this.f401a = strArr;
        this.f402b = strArr2;
        this.c = str3;
        this.f400a = list;
    }

    public static ga a(Bundle bundle) {
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
        return new ga(string, string2, strArr, strArr2, string3, arrayList);
    }

    public static Parcelable[] a(List<ga> list) {
        return a((ga[]) list.toArray(new ga[list.size()]));
    }

    public static Parcelable[] a(ga[] gaVarArr) {
        if (gaVarArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[gaVarArr.length];
        for (int i = 0; i < gaVarArr.length; i++) {
            parcelableArr[i] = gaVarArr[i].m300a();
        }
        return parcelableArr;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.a);
        bundle.putString("ext_ns", this.b);
        bundle.putString("ext_text", this.c);
        Bundle bundle2 = new Bundle();
        if (this.f401a != null && this.f401a.length > 0) {
            for (int i = 0; i < this.f401a.length; i++) {
                bundle2.putString(this.f401a[i], this.f402b[i]);
            }
        }
        bundle.putBundle("attributes", bundle2);
        if (this.f400a != null && this.f400a.size() > 0) {
            bundle.putParcelableArray("children", a(this.f400a));
        }
        return bundle;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Parcelable m300a() {
        return a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m301a() {
        return this.a;
    }

    public String a(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (this.f401a != null) {
            for (int i = 0; i < this.f401a.length; i++) {
                if (str.equals(this.f401a[i])) {
                    return this.f402b[i];
                }
            }
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m302a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.c = str;
        } else {
            this.c = go.a(str);
        }
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return !TextUtils.isEmpty(this.c) ? go.b(this.c) : this.c;
    }

    @Override // com.xiaomi.push.ge
    public String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(this.a);
        if (!TextUtils.isEmpty(this.b)) {
            sb.append(HanziToPinyin.Token.SEPARATOR).append("xmlns=").append("\"").append(this.b).append("\"");
        }
        if (this.f401a != null && this.f401a.length > 0) {
            for (int i = 0; i < this.f401a.length; i++) {
                if (!TextUtils.isEmpty(this.f402b[i])) {
                    sb.append(HanziToPinyin.Token.SEPARATOR).append(this.f401a[i]).append("=\"").append(go.a(this.f402b[i])).append("\"");
                }
            }
        }
        if (!TextUtils.isEmpty(this.c)) {
            sb.append(">").append(this.c).append("</").append(this.a).append(">");
        } else if (this.f400a == null || this.f400a.size() <= 0) {
            sb.append("/>");
        } else {
            sb.append(">");
            for (ga gaVar : this.f400a) {
                sb.append(gaVar.d());
            }
            sb.append("</").append(this.a).append(">");
        }
        return sb.toString();
    }

    public String toString() {
        return d();
    }
}
