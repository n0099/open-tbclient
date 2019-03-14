package com.googlecode.mp4parser.srt;

import com.baidu.mobstat.Config;
import com.googlecode.mp4parser.authoring.tracks.TextTrackImpl;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public class SrtParser {
    public static TextTrackImpl parse(InputStream inputStream) throws IOException {
        LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(inputStream, HTTP.UTF_8));
        TextTrackImpl textTrackImpl = new TextTrackImpl();
        while (lineNumberReader.readLine() != null) {
            String readLine = lineNumberReader.readLine();
            String str = "";
            while (true) {
                String readLine2 = lineNumberReader.readLine();
                if (readLine2 != null && !readLine2.trim().equals("")) {
                    str = String.valueOf(str) + readLine2 + "\n";
                }
            }
            textTrackImpl.getSubs().add(new TextTrackImpl.Line(parse(readLine.split("-->")[0]), parse(readLine.split("-->")[1]), str));
        }
        return textTrackImpl;
    }

    private static long parse(String str) {
        return (Long.parseLong(str.split(Config.TRACE_TODAY_VISIT_SPLIT)[0].trim()) * 60 * 60 * 1000) + (Long.parseLong(str.split(Config.TRACE_TODAY_VISIT_SPLIT)[1].trim()) * 60 * 1000) + (Long.parseLong(str.split(Config.TRACE_TODAY_VISIT_SPLIT)[2].split(Constants.ACCEPT_TIME_SEPARATOR_SP)[0].trim()) * 1000) + Long.parseLong(str.split(Config.TRACE_TODAY_VISIT_SPLIT)[2].split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1].trim());
    }
}
