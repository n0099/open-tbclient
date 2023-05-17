package com.google.android.exoplayer2.source.hls.playlist;

import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class HlsPlaylist {
    public final String baseUri;
    public final List<String> tags;

    public HlsPlaylist(String str, List<String> list) {
        this.baseUri = str;
        this.tags = Collections.unmodifiableList(list);
    }
}
