package com.sdk.base.framework.f.k;

import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.f;
import com.sdk.base.framework.f.j.e;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes4.dex */
public class a extends com.sdk.base.framework.f.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7655a = a.class.getName();
    private static boolean b = f.b;

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : 0x0034: INVOKE  (r6v0 java.lang.Object A[REMOVE]) = (r0v15 java.util.Map$Entry<java.lang.String, java.lang.Object>) type: INTERFACE call: java.util.Map.Entry.getValue():java.lang.Object)] */
    public static String a(String str, String str2, TreeMap<String, Object> treeMap) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str).append(str2).append('?');
            for (Map.Entry<String, Object> entry : treeMap.entrySet()) {
                String key = entry.getKey();
                String sb = new StringBuilder().append(entry.getValue()).toString();
                if (entry.getValue() != null && sb.length() > 0 && !"null".equals(sb) && !"sign".equals(key) && !key.startsWith(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) && !"file".equals(key)) {
                    stringBuffer.append(key).append('=').append(entry.getValue()).append('&');
                }
            }
            if (stringBuffer.charAt(stringBuffer.length() - 1) == '&') {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            return e.a(stringBuffer.toString());
        } catch (Exception e) {
            c.b(f7655a, e.getMessage(), Boolean.valueOf(b));
            return null;
        }
    }
}
