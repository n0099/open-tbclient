package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public final int id;
    public final List<g> mqd;
    public final List<d> mqe;
    public final List<d> mqf;
    public final int type;

    public a(int i, int i2, List<g> list, List<d> list2, List<d> list3) {
        List<d> unmodifiableList;
        List<d> unmodifiableList2;
        this.id = i;
        this.type = i2;
        this.mqd = Collections.unmodifiableList(list);
        if (list2 == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list2);
        }
        this.mqe = unmodifiableList;
        if (list3 == null) {
            unmodifiableList2 = Collections.emptyList();
        } else {
            unmodifiableList2 = Collections.unmodifiableList(list3);
        }
        this.mqf = unmodifiableList2;
    }
}
