package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public final int id;
    public final List<g> mwx;
    public final List<d> mwy;
    public final List<d> mwz;
    public final int type;

    public a(int i, int i2, List<g> list, List<d> list2, List<d> list3) {
        List<d> unmodifiableList;
        List<d> unmodifiableList2;
        this.id = i;
        this.type = i2;
        this.mwx = Collections.unmodifiableList(list);
        if (list2 == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list2);
        }
        this.mwy = unmodifiableList;
        if (list3 == null) {
            unmodifiableList2 = Collections.emptyList();
        } else {
            unmodifiableList2 = Collections.unmodifiableList(list3);
        }
        this.mwz = unmodifiableList2;
    }
}
