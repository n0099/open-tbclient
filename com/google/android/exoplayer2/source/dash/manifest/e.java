package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class e {
    public final String id;
    public final long mvm;
    public final List<a> mvn;

    public e(String str, long j, List<a> list) {
        this.id = str;
        this.mvm = j;
        this.mvn = Collections.unmodifiableList(list);
    }

    public int Lc(int i) {
        int size = this.mvn.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.mvn.get(i2).type == i) {
                return i2;
            }
        }
        return -1;
    }
}
