package com.google.zxing.client.result;

import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public final class URIParsedResult extends ParsedResult {
    public static final Pattern USER_IN_HOST = Pattern.compile(":/*([^/@]+)@[^/]+");
    public final String title;
    public final String uri;

    public URIParsedResult(String str, String str2) {
        super(ParsedResultType.URI);
        this.uri = massageURI(str);
        this.title = str2;
    }

    public static boolean isColonFollowedByPortNumber(String str, int i2) {
        int i3 = i2 + 1;
        int indexOf = str.indexOf(47, i3);
        if (indexOf < 0) {
            indexOf = str.length();
        }
        return ResultParser.isSubstringOfDigits(str, i3, indexOf - i3);
    }

    public static String massageURI(String str) {
        String trim = str.trim();
        int indexOf = trim.indexOf(58);
        if (indexOf < 0 || isColonFollowedByPortNumber(trim, indexOf)) {
            return "http://" + trim;
        }
        return trim;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder sb = new StringBuilder(30);
        ParsedResult.maybeAppend(this.title, sb);
        ParsedResult.maybeAppend(this.uri, sb);
        return sb.toString();
    }

    public String getTitle() {
        return this.title;
    }

    public String getURI() {
        return this.uri;
    }

    public boolean isPossiblyMaliciousURI() {
        return USER_IN_HOST.matcher(this.uri).find();
    }
}
