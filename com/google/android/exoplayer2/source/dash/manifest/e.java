package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class e {
    public final String id;
    public final long mvb;
    public final List<a> mvc;

    public e(String str, long j, List<a> list) {
        this.id = str;
        this.mvb = j;
        this.mvc = Collections.unmodifiableList(list);
    }

    public int Lc(int i) {
        int size = this.mvc.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.mvc.get(i2).type == i) {
                return i2;
            }
        }
        return -1;
    }
}
