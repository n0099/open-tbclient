package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class e {
    public final String id;
    public final long muo;
    public final List<a> mup;

    public e(String str, long j, List<a> list) {
        this.id = str;
        this.muo = j;
        this.mup = Collections.unmodifiableList(list);
    }

    public int KX(int i) {
        int size = this.mup.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.mup.get(i2).type == i) {
                return i2;
            }
        }
        return -1;
    }
}
