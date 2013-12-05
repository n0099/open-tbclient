package com.google.zxing.client.result;

import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class j extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f2848a = Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.t
    /* renamed from: a */
    public h b(com.google.zxing.h hVar) {
        String[] a2;
        String c = c(hVar);
        if (c.startsWith("MATMSG:") && (a2 = a("TO:", c, true)) != null) {
            String str = a2[0];
            if (a(str)) {
                return new h(str, b("SUB:", c, false), b("BODY:", c, false), "mailto:" + str);
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str) {
        return str != null && f2848a.matcher(str).matches() && str.indexOf(64) >= 0;
    }
}
