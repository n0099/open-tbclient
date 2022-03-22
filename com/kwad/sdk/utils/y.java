package com.kwad.sdk.utils;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class y {
    @NonNull
    public static <T> List<List<T>> a(List<T> list, int i) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        if (i <= 0) {
            i = list.size();
        }
        int i2 = 0;
        while (i2 < list.size()) {
            int i3 = i2 + i;
            arrayList.add(list.subList(i2, i3 > list.size() ? list.size() : i3));
            i2 = i3;
        }
        return arrayList;
    }
}
