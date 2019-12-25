package com.google.android.exoplayer2.text.g;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.l;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public final class h {
    private static final Pattern mxN = Pattern.compile("^NOTE(( |\t).*)?$");
    private static final Pattern mxO = Pattern.compile("^\ufeff?WEBVTT(( |\t).*)?$");

    public static void ae(l lVar) throws SubtitleDecoderException {
        String readLine = lVar.readLine();
        if (readLine == null || !mxO.matcher(readLine).matches()) {
            throw new SubtitleDecoderException("Expected WEBVTT. Got " + readLine);
        }
    }

    public static long PL(String str) throws NumberFormatException {
        long j = 0;
        String[] split = str.split("\\.", 2);
        for (String str2 : split[0].split(":")) {
            j = (j * 60) + Long.parseLong(str2);
        }
        long j2 = j * 1000;
        if (split.length == 2) {
            j2 += Long.parseLong(split[1]);
        }
        return j2 * 1000;
    }

    public static float PM(String str) throws NumberFormatException {
        if (!str.endsWith("%")) {
            throw new NumberFormatException("Percentages must end with %");
        }
        return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
    }

    public static Matcher af(l lVar) {
        String readLine;
        while (true) {
            String readLine2 = lVar.readLine();
            if (readLine2 == null) {
                return null;
            }
            if (mxN.matcher(readLine2).matches()) {
                do {
                    readLine = lVar.readLine();
                    if (readLine != null) {
                    }
                } while (!readLine.isEmpty());
            } else {
                Matcher matcher = f.mxC.matcher(readLine2);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }
}
