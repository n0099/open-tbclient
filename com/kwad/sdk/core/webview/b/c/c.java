package com.kwad.sdk.core.webview.b.c;

import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.wordscommand.WordCommandManager;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class c {
    public static final List<String> aDx;

    static {
        ArrayList arrayList = new ArrayList();
        aDx = arrayList;
        arrayList.add("application/x-javascript");
        aDx.add("image/jpeg");
        aDx.add("image/tiff");
        aDx.add("text/css");
        aDx.add(SapiWebView.DATA_MIME_TYPE);
        aDx.add("image/gif");
        aDx.add(WordCommandManager.IMAGE_PNG);
        aDx.add("application/javascript");
        aDx.add("video/mp4");
        aDx.add(MimeTypes.AUDIO_MPEG);
        aDx.add("application/json");
        aDx.add("image/webp");
        aDx.add("image/apng");
        aDx.add("image/svg+xml");
        aDx.add("application/octet-stream");
    }

    public static boolean eB(String str) {
        return aDx.contains(str);
    }
}
