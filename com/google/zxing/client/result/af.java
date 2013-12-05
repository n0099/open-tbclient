package com.google.zxing.client.result;

import java.util.List;
/* loaded from: classes.dex */
public final class af extends t {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.t
    /* renamed from: a */
    public g b(com.google.zxing.h hVar) {
        double parseDouble;
        double d = Double.NaN;
        String c = c(hVar);
        if (c.indexOf("BEGIN:VEVENT") < 0) {
            return null;
        }
        String a2 = a("SUMMARY", c, true);
        String a3 = a("DTSTART", c, true);
        if (a3 == null) {
            return null;
        }
        String a4 = a("DTEND", c, true);
        String a5 = a("DURATION", c, true);
        String a6 = a("LOCATION", c, true);
        String a7 = a(a("ORGANIZER", c, true));
        String[] b = b("ATTENDEE", c, true);
        if (b != null) {
            for (int i = 0; i < b.length; i++) {
                b[i] = a(b[i]);
            }
        }
        String a8 = a("DESCRIPTION", c, true);
        String a9 = a("GEO", c, true);
        if (a9 == null) {
            parseDouble = Double.NaN;
        } else {
            int indexOf = a9.indexOf(59);
            try {
                parseDouble = Double.parseDouble(a9.substring(0, indexOf));
                d = Double.parseDouble(a9.substring(indexOf + 1));
            } catch (NumberFormatException e) {
                return null;
            }
        }
        try {
            return new g(a2, a3, a4, a5, a6, a7, b, a8, parseDouble, d);
        } catch (IllegalArgumentException e2) {
            return null;
        }
    }

    private static String a(CharSequence charSequence, String str, boolean z) {
        List<String> b = ae.b(charSequence, str, z, false);
        if (b == null || b.isEmpty()) {
            return null;
        }
        return b.get(0);
    }

    private static String[] b(CharSequence charSequence, String str, boolean z) {
        List<List<String>> a2 = ae.a(charSequence, str, z, false);
        if (a2 == null || a2.isEmpty()) {
            return null;
        }
        int size = a2.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = a2.get(i).get(0);
        }
        return strArr;
    }

    private static String a(String str) {
        if (str != null) {
            if (str.startsWith("mailto:") || str.startsWith("MAILTO:")) {
                return str.substring(7);
            }
            return str;
        }
        return str;
    }
}
