package com.google.zxing.client.result;

import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class URIParsedResult extends ParsedResult {
    private static final Pattern USER_IN_HOST = Pattern.compile(":/*([^/@]+)@[^/]+");
    private final String title;
    private final String uri;

    public URIParsedResult(String str, String str2) {
        super(ParsedResultType.URI);
        this.uri = massageURI(str);
        this.title = str2;
    }

    public String getURI() {
        return this.uri;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isPossiblyMaliciousURI() {
        return USER_IN_HOST.matcher(this.uri).find();
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder sb = new StringBuilder(30);
        maybeAppend(this.title, sb);
        maybeAppend(this.uri, sb);
        return sb.toString();
    }

    private static String massageURI(String str) {
        String trim = str.trim();
        int indexOf = trim.indexOf(58);
        if (indexOf < 0) {
            return "http://" + trim;
        }
        if (isColonFollowedByPortNumber(trim, indexOf)) {
            return "http://" + trim;
        }
        return trim;
    }

    private static boolean isColonFollowedByPortNumber(String str, int i) {
        int indexOf = str.indexOf(47, i + 1);
        int length = indexOf < 0 ? str.length() : indexOf;
        if (length <= i + 1) {
            return false;
        }
        for (int i2 = i + 1; i2 < length; i2++) {
            if (str.charAt(i2) < '0' || str.charAt(i2) > '9') {
                return false;
            }
        }
        return true;
    }
}
