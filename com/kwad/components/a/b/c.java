package com.kwad.components.a.b;

import com.baidu.sapi2.SapiWebView;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public final class c {
    public static final List<String> Qe;

    static {
        ArrayList arrayList = new ArrayList();
        Qe = arrayList;
        arrayList.add("application/x-javascript");
        Qe.add("image/jpeg");
        Qe.add("image/tiff");
        Qe.add("text/css");
        Qe.add(SapiWebView.DATA_MIME_TYPE);
        Qe.add("image/gif");
        Qe.add("image/png");
        Qe.add("application/javascript");
        Qe.add(MimeTypes.VIDEO_MP4);
        Qe.add(MimeTypes.AUDIO_MPEG);
        Qe.add("application/json");
        Qe.add("image/webp");
        Qe.add("image/apng");
        Qe.add("image/svg+xml");
        Qe.add("application/octet-stream");
    }

    public static boolean aX(String str) {
        return Qe.contains(str);
    }
}
