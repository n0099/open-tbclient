package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    public final int id;
    public final List<g> mtT;
    public final List<d> mtU;
    public final List<d> mtV;
    public final int type;

    public a(int i, int i2, List<g> list, List<d> list2, List<d> list3) {
        List<d> unmodifiableList;
        List<d> unmodifiableList2;
        this.id = i;
        this.type = i2;
        this.mtT = Collections.unmodifiableList(list);
        if (list2 == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list2);
        }
        this.mtU = unmodifiableList;
        if (list3 == null) {
            unmodifiableList2 = Collections.emptyList();
        } else {
            unmodifiableList2 = Collections.unmodifiableList(list3);
        }
        this.mtV = unmodifiableList2;
    }
}
