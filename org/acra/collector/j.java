package org.acra.collector;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j {
    public static String a(Class cls) {
        Field[] fields;
        StringBuilder sb = new StringBuilder();
        for (Field field : cls.getFields()) {
            sb.append(field.getName()).append("=");
            try {
                sb.append(field.get(null).toString());
            } catch (IllegalAccessException e) {
                sb.append("N/A");
            } catch (IllegalArgumentException e2) {
                sb.append("N/A");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String b(Class cls) {
        Method[] methods;
        StringBuilder sb = new StringBuilder();
        for (Method method : cls.getMethods()) {
            if (method.getParameterTypes().length == 0 && ((method.getName().startsWith("get") || method.getName().startsWith("is")) && !method.getName().equals("getClass"))) {
                try {
                    sb.append(method.getName());
                    sb.append('=');
                    sb.append(method.invoke(null, null));
                    sb.append("\n");
                } catch (IllegalAccessException e) {
                } catch (IllegalArgumentException e2) {
                } catch (InvocationTargetException e3) {
                }
            }
        }
        return sb.toString();
    }
}
