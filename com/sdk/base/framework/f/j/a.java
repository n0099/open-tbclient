package com.sdk.base.framework.f.j;

import com.baidu.android.common.others.lang.StringUtil;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.f;
import com.sdk.base.framework.f.i.e;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;
/* loaded from: classes7.dex */
public class a extends com.sdk.base.framework.f.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f39392a = "com.sdk.base.framework.f.j.a";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f39393b = f.f39341b;

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : 0x0031: INVOKE  (r3v0 java.lang.Object A[REMOVE]) = (r5v4 java.util.Map$Entry<java.lang.String, java.lang.Object>) type: INTERFACE call: java.util.Map.Entry.getValue():java.lang.Object)] */
    public static String a(String str, String str2, TreeMap<String, Object> treeMap) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(str2);
            stringBuffer.append('?');
            for (Map.Entry<String, Object> entry : treeMap.entrySet()) {
                String key = entry.getKey();
                StringBuilder sb = new StringBuilder();
                sb.append(entry.getValue());
                String sb2 = sb.toString();
                if (entry.getValue() != null && sb2.length() > 0 && !StringUtil.NULL_STRING.equals(sb2) && !"sign".equals(key) && !key.startsWith("_") && !"file".equals(key)) {
                    stringBuffer.append(key);
                    stringBuffer.append(com.alipay.sdk.encrypt.a.f1886h);
                    stringBuffer.append(entry.getValue());
                    stringBuffer.append(Typography.amp);
                }
            }
            if (stringBuffer.charAt(stringBuffer.length() - 1) == '&') {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            return e.a(stringBuffer.toString());
        } catch (Exception e2) {
            c.b(f39392a, e2.getMessage(), Boolean.valueOf(f39393b));
            return null;
        }
    }
}
