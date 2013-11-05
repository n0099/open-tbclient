package org.a.a.a.a.a;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static ResourceBundle f2837a = null;

    public static String a(String str) {
        if (f2837a != null) {
            try {
                return f2837a.getString(str);
            } catch (MissingResourceException e) {
                return "Missing message: " + str;
            }
        }
        return str;
    }
}
