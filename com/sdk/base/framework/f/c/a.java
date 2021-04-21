package com.sdk.base.framework.f.c;

import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.bean.KInfo;
import com.sdk.base.framework.c.f;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f38926a = "com.sdk.base.framework.f.c.a";

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f38927b = f.f38904b;

    public static String a(Object obj) {
        try {
            Field[] declaredFields = Class.forName(obj.getClass().getName()).getDeclaredFields();
            JSONObject jSONObject = new JSONObject();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                String name = field.getName();
                if (!"serialVersionUID".equals(name)) {
                    Object obj2 = field.get(obj);
                    if (field.getType().equals(ArrayList.class)) {
                        JSONArray jSONArray = new JSONArray();
                        ArrayList arrayList = (ArrayList) obj2;
                        if (arrayList != null) {
                            for (int i = 0; i < arrayList.size(); i++) {
                                Object obj3 = arrayList.get(i);
                                Class<?> cls = obj3.getClass();
                                if (cls.equals(KInfo.class)) {
                                    Field[] declaredFields2 = cls.getDeclaredFields();
                                    JSONObject jSONObject2 = new JSONObject();
                                    for (Field field2 : declaredFields2) {
                                        field2.setAccessible(true);
                                        jSONObject2.put(field2.getName(), field2.get(obj3));
                                    }
                                    jSONArray.put(jSONObject2);
                                } else {
                                    jSONArray.put(obj3);
                                }
                            }
                        }
                        obj2 = jSONArray;
                    }
                    jSONObject.put(name, obj2);
                }
            }
            return jSONObject.toString();
        } catch (Exception e2) {
            c.b(f38926a, e2.getMessage(), Boolean.valueOf(f38927b));
            return null;
        }
    }
}
