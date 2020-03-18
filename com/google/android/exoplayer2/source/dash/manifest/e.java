package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class e {
    public final String id;
    public final long mwS;
    public final List<a> mwT;

    public e(String str, long j, List<a> list) {
        this.id = str;
        this.mwS = j;
        this.mwT = Collections.unmodifiableList(list);
    }

    public int Li(int i) {
        int size = this.mwT.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.mwT.get(i2).type == i) {
                return i2;
            }
        }
        return -1;
    }
}
