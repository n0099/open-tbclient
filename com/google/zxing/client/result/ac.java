package com.google.zxing.client.result;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class ac extends t {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f2842a = Pattern.compile("[a-zA-Z0-9]{2,}:");
    private static final Pattern b = Pattern.compile("([a-zA-Z0-9\\-]+\\.)+[a-zA-Z0-9\\-]{2,}(:\\d{1,5})?(/|\\?|$)");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.t
    /* renamed from: a */
    public ab b(com.google.zxing.h hVar) {
        String c = c(hVar);
        if (c.startsWith("URL:") || c.startsWith("URI:")) {
            return new ab(c.substring(4).trim(), null);
        }
        String trim = c.trim();
        if (a(trim)) {
            return new ab(trim, null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str) {
        if (str.contains(" ")) {
            return false;
        }
        Matcher matcher = f2842a.matcher(str);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        Matcher matcher2 = b.matcher(str);
        return matcher2.find() && matcher2.start() == 0;
    }
}
