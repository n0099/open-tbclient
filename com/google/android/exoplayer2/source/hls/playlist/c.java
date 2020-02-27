package com.google.android.exoplayer2.source.hls.playlist;

import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class c {
    public final String mwY;
    public final List<String> tags;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(String str, List<String> list) {
        this.mwY = str;
        this.tags = Collections.unmodifiableList(list);
    }
}
