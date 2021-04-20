package org.json.alipay;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f69134a;

    public a() {
        this.f69134a = new ArrayList();
    }

    public a(Object obj) {
        this();
        if (!obj.getClass().isArray()) {
            throw new JSONException("JSONArray initial value should be a string or collection or array.");
        }
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f69134a.add(Array.get(obj, i));
        }
    }

    public a(String str) {
        this(new c(str));
    }

    public a(Collection collection) {
        this.f69134a = collection == null ? new ArrayList() : new ArrayList(collection);
    }

    public a(c cVar) {
        this();
        char c2;
        ArrayList arrayList;
        Object d2;
        char c3 = cVar.c();
        if (c3 == '[') {
            c2 = ']';
        } else if (c3 != '(') {
            throw cVar.a("A JSONArray text must start with '['");
        } else {
            c2 = ')';
        }
        if (cVar.c() == ']') {
            return;
        }
        do {
            cVar.a();
            char c4 = cVar.c();
            cVar.a();
            if (c4 == ',') {
                arrayList = this.f69134a;
                d2 = null;
            } else {
                arrayList = this.f69134a;
                d2 = cVar.d();
            }
            arrayList.add(d2);
            char c5 = cVar.c();
            if (c5 != ')') {
                if (c5 != ',' && c5 != ';') {
                    if (c5 != ']') {
                        throw cVar.a("Expected a ',' or ']'");
                    }
                }
            }
            if (c2 == c5) {
                return;
            }
            throw cVar.a("Expected a '" + new Character(c2) + "'");
        } while (cVar.c() != ']');
    }

    private String a(String str) {
        int size = this.f69134a.size();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuffer.append(str);
            }
            stringBuffer.append(b.a(this.f69134a.get(i)));
        }
        return stringBuffer.toString();
    }

    public final int a() {
        return this.f69134a.size();
    }

    public final Object a(int i) {
        Object obj = (i < 0 || i >= this.f69134a.size()) ? null : this.f69134a.get(i);
        if (obj != null) {
            return obj;
        }
        throw new JSONException("JSONArray[" + i + "] not found.");
    }

    public String toString() {
        try {
            return "[" + a(",") + ']';
        } catch (Exception unused) {
            return null;
        }
    }
}
