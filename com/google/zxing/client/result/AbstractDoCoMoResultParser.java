package com.google.zxing.client.result;

import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
/* loaded from: classes8.dex */
public abstract class AbstractDoCoMoResultParser extends ResultParser {
    public static String[] matchDoCoMoPrefixedField(String str, String str2, boolean z) {
        return ResultParser.matchPrefixedField(str, str2, WebvttCueParser.CHAR_SEMI_COLON, z);
    }

    public static String matchSingleDoCoMoPrefixedField(String str, String str2, boolean z) {
        return ResultParser.matchSinglePrefixedField(str, str2, WebvttCueParser.CHAR_SEMI_COLON, z);
    }
}
