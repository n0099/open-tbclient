package org.json.alipay;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f68318a;

    public a() {
        this.f68318a = new ArrayList();
    }

    public a(Object obj) {
        this();
        if (!obj.getClass().isArray()) {
            throw new JSONException("JSONArray initial value should be a string or collection or array.");
        }
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.f68318a.add(Array.get(obj, i2));
        }
    }

    public a(String str) {
        this(new c(str));
    }

    public a(Collection collection) {
        this.f68318a = collection == null ? new ArrayList() : new ArrayList(collection);
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
                arrayList = this.f68318a;
                d2 = null;
            } else {
                arrayList = this.f68318a;
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
        int size = this.f68318a.size();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                stringBuffer.append(str);
            }
            stringBuffer.append(b.a(this.f68318a.get(i2)));
        }
        return stringBuffer.toString();
    }

    public final int a() {
        return this.f68318a.size();
    }

    public final Object a(int i2) {
        Object obj = (i2 < 0 || i2 >= this.f68318a.size()) ? null : this.f68318a.get(i2);
        if (obj != null) {
            return obj;
        }
        throw new JSONException("JSONArray[" + i2 + "] not found.");
    }

    public String toString() {
        try {
            return "[" + a(",") + ']';
        } catch (Exception unused) {
            return null;
        }
    }
}
