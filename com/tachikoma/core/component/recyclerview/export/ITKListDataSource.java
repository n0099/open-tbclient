package com.tachikoma.core.component.recyclerview.export;

import com.kwad.v8.V8Object;
/* loaded from: classes8.dex */
public interface ITKListDataSource {
    int countOfItems(V8Object v8Object, int i);

    int countOfSections(V8Object v8Object);

    V8Object createItemView(V8Object v8Object, V8Object v8Object2, String str);

    V8Object createSectionFooter(V8Object v8Object, int i, String str);

    V8Object createSectionHeader(V8Object v8Object, int i, String str);

    int reusableKeyForItemView(V8Object v8Object, int i);

    String reusableKeyForSectionHeader(V8Object v8Object, int i);

    String reusableKeyForSetionFooter(V8Object v8Object, int i);

    void reuseItemView(V8Object v8Object, V8Object v8Object2, int i);

    void reuseSectionFooter(V8Object v8Object, V8Object v8Object2, int i);

    void reuseSectionHeader(V8Object v8Object, V8Object v8Object2, int i);

    V8Object sizeForItemView(V8Object v8Object, int i);
}
