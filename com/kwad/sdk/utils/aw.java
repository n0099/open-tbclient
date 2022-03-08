package com.kwad.sdk.utils;

import com.baidu.searchbox.player.widget.BdPlayerProgressView;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes8.dex */
public class aw {
    public static String a(long j2) {
        if (j2 <= 0 || j2 >= 86400000) {
            return BdPlayerProgressView.DEFAULT_TIME_TEXT;
        }
        try {
            long j3 = j2 / 1000;
            long j4 = j3 % 60;
            long j5 = (j3 / 60) % 60;
            long j6 = j3 / 3600;
            Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
            return j6 > 0 ? formatter.format("%d:%02d:%02d", Long.valueOf(j6), Long.valueOf(j5), Long.valueOf(j4)).toString() : formatter.format("%02d:%02d", Long.valueOf(j5), Long.valueOf(j4)).toString();
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            return "";
        }
    }
}
