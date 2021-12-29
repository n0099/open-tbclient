package com.kwad.sdk.utils;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class y {
    @NonNull
    public static <T> List<List<T>> a(List<T> list, int i2) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        if (i2 <= 0) {
            i2 = list.size();
        }
        int i3 = 0;
        while (i3 < list.size()) {
            int i4 = i3 + i2;
            arrayList.add(list.subList(i3, i4 > list.size() ? list.size() : i4));
            i3 = i4;
        }
        return arrayList;
    }
}
