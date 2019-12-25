package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class e {
    public final String id;
    public final List<a> mqA;
    public final long mqz;

    public e(String str, long j, List<a> list) {
        this.id = str;
        this.mqz = j;
        this.mqA = Collections.unmodifiableList(list);
    }

    public int KO(int i) {
        int size = this.mqA.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.mqA.get(i2).type == i) {
                return i2;
            }
        }
        return -1;
    }
}
