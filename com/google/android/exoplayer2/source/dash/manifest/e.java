package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class e {
    public final String id;
    public final long muZ;
    public final List<a> mva;

    public e(String str, long j, List<a> list) {
        this.id = str;
        this.muZ = j;
        this.mva = Collections.unmodifiableList(list);
    }

    public int Lc(int i) {
        int size = this.mva.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.mva.get(i2).type == i) {
                return i2;
            }
        }
        return -1;
    }
}
