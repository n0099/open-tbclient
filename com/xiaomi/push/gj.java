package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* loaded from: classes10.dex */
public class gj implements gn {
    public String a;

    /* renamed from: a  reason: collision with other field name */
    public List<gj> f436a;

    /* renamed from: a  reason: collision with other field name */
    public String[] f437a;
    public String b;

    /* renamed from: b  reason: collision with other field name */
    public String[] f438b;
    public String c;

    public gj(String str, String str2, String[] strArr, String[] strArr2) {
        this.f437a = null;
        this.f438b = null;
        this.f436a = null;
        this.a = str;
        this.b = str2;
        this.f437a = strArr;
        this.f438b = strArr2;
    }

    public gj(String str, String str2, String[] strArr, String[] strArr2, String str3, List<gj> list) {
        this.f437a = null;
        this.f438b = null;
        this.f436a = null;
        this.a = str;
        this.b = str2;
        this.f437a = strArr;
        this.f438b = strArr2;
        this.c = str3;
        this.f436a = list;
    }

    public static gj a(Bundle bundle) {
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
        if (bundle.containsKey(CriusAttrConstants.CHILDREN)) {
            Parcelable[] parcelableArray = bundle.getParcelableArray(CriusAttrConstants.CHILDREN);
            ArrayList arrayList2 = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList2.add(a((Bundle) parcelable));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new gj(string, string2, strArr, strArr2, string3, arrayList);
    }

    public static Parcelable[] a(List<gj> list) {
        return a((gj[]) list.toArray(new gj[list.size()]));
    }

    public static Parcelable[] a(gj[] gjVarArr) {
        if (gjVarArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[gjVarArr.length];
        for (int i = 0; i < gjVarArr.length; i++) {
            parcelableArr[i] = gjVarArr[i].m525a();
        }
        return parcelableArr;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.a);
        bundle.putString("ext_ns", this.b);
        bundle.putString("ext_text", this.c);
        Bundle bundle2 = new Bundle();
        String[] strArr = this.f437a;
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                String[] strArr2 = this.f437a;
                if (i >= strArr2.length) {
                    break;
                }
                bundle2.putString(strArr2[i], this.f438b[i]);
                i++;
            }
        }
        bundle.putBundle("attributes", bundle2);
        List<gj> list = this.f436a;
        if (list != null && list.size() > 0) {
            bundle.putParcelableArray(CriusAttrConstants.CHILDREN, a(this.f436a));
        }
        return bundle;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Parcelable m525a() {
        return a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m526a() {
        return this.a;
    }

    public String a(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (this.f437a == null) {
            return null;
        }
        int i = 0;
        while (true) {
            String[] strArr = this.f437a;
            if (i >= strArr.length) {
                return null;
            }
            if (str.equals(strArr[i])) {
                return this.f438b[i];
            }
            i++;
        }
    }

    public void a(gj gjVar) {
        if (this.f436a == null) {
            this.f436a = new ArrayList();
        }
        if (this.f436a.contains(gjVar)) {
            return;
        }
        this.f436a.add(gjVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m527a(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = gx.a(str);
        }
        this.c = str;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return !TextUtils.isEmpty(this.c) ? gx.b(this.c) : this.c;
    }

    @Override // com.xiaomi.push.gn
    public String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(this.a);
        if (!TextUtils.isEmpty(this.b)) {
            sb.append(" ");
            sb.append("xmlns=");
            sb.append("\"");
            sb.append(this.b);
            sb.append("\"");
        }
        String[] strArr = this.f437a;
        if (strArr != null && strArr.length > 0) {
            for (int i = 0; i < this.f437a.length; i++) {
                if (!TextUtils.isEmpty(this.f438b[i])) {
                    sb.append(" ");
                    sb.append(this.f437a[i]);
                    sb.append("=\"");
                    sb.append(gx.a(this.f438b[i]));
                    sb.append("\"");
                }
            }
        }
        if (TextUtils.isEmpty(this.c)) {
            List<gj> list = this.f436a;
            if (list == null || list.size() <= 0) {
                sb.append("/>");
                return sb.toString();
            }
            sb.append(">");
            for (gj gjVar : this.f436a) {
                sb.append(gjVar.d());
            }
        } else {
            sb.append(">");
            sb.append(this.c);
        }
        sb.append("</");
        sb.append(this.a);
        sb.append(">");
        return sb.toString();
    }

    public String toString() {
        return d();
    }
}
