package com.bytedance.sdk.openadsdk.preload.a;

import java.lang.reflect.Field;
import java.util.Locale;
/* loaded from: classes6.dex */
public enum d implements e {
    IDENTITY { // from class: com.bytedance.sdk.openadsdk.preload.a.d.1
        @Override // com.bytedance.sdk.openadsdk.preload.a.e
        public String a(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE { // from class: com.bytedance.sdk.openadsdk.preload.a.d.2
        @Override // com.bytedance.sdk.openadsdk.preload.a.e
        public String a(Field field) {
            return d.a(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES { // from class: com.bytedance.sdk.openadsdk.preload.a.d.3
        @Override // com.bytedance.sdk.openadsdk.preload.a.e
        public String a(Field field) {
            return d.a(d.a(field.getName(), " "));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES { // from class: com.bytedance.sdk.openadsdk.preload.a.d.4
        @Override // com.bytedance.sdk.openadsdk.preload.a.e
        public String a(Field field) {
            return d.a(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DASHES { // from class: com.bytedance.sdk.openadsdk.preload.a.d.5
        @Override // com.bytedance.sdk.openadsdk.preload.a.e
        public String a(Field field) {
            return d.a(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DOTS { // from class: com.bytedance.sdk.openadsdk.preload.a.d.6
        @Override // com.bytedance.sdk.openadsdk.preload.a.e
        public String a(Field field) {
            return d.a(field.getName(), ".").toLowerCase(Locale.ENGLISH);
        }
    };

    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static String a(String str) {
        int length = str.length() - 1;
        int i2 = 0;
        while (!Character.isLetter(str.charAt(i2)) && i2 < length) {
            i2++;
        }
        char charAt = str.charAt(i2);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        char upperCase = Character.toUpperCase(charAt);
        if (i2 == 0) {
            return upperCase + str.substring(1);
        }
        return str.substring(0, i2) + upperCase + str.substring(i2 + 1);
    }
}
