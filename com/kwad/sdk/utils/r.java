package com.kwad.sdk.utils;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class r {
    @NonNull
    public static <T> List<List<T>> a(List<T> list, int i) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        if (i <= 0) {
            i = list.size();
        }
        for (int i2 = 0; i2 < list.size(); i2 += i) {
            arrayList.add(list.subList(i2, i2 + i > list.size() ? list.size() : i2 + i));
        }
        return arrayList;
    }
}
