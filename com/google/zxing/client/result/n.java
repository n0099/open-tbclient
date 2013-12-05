package com.google.zxing.client.result;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class n extends t {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f2851a = Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.t
    /* renamed from: a */
    public m b(com.google.zxing.h hVar) {
        double d = 0.0d;
        Matcher matcher = f2851a.matcher(c(hVar));
        if (matcher.matches()) {
            String group = matcher.group(4);
            try {
                double parseDouble = Double.parseDouble(matcher.group(1));
                if (parseDouble > 90.0d || parseDouble < -90.0d) {
                    return null;
                }
                double parseDouble2 = Double.parseDouble(matcher.group(2));
                if (parseDouble2 > 180.0d || parseDouble2 < -180.0d) {
                    return null;
                }
                if (matcher.group(3) != null) {
                    double parseDouble3 = Double.parseDouble(matcher.group(3));
                    if (parseDouble3 < 0.0d) {
                        return null;
                    }
                    d = parseDouble3;
                }
                return new m(parseDouble, parseDouble2, d, group);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }
}
