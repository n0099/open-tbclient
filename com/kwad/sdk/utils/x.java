package com.kwad.sdk.utils;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class x {
    @NonNull
    public static <T> List<List<T>> d(List<T> list, int i) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        int i2 = 0;
        while (i2 < list.size()) {
            int i3 = i2 + 200;
            arrayList.add(list.subList(i2, i3 > list.size() ? list.size() : i3));
            i2 = i3;
        }
        return arrayList;
    }
}
