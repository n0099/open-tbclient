package com.tachikoma.core.component.recyclerview.export;

import com.kwad.v8.V8Object;
/* loaded from: classes8.dex */
public interface ITKListDataSource {
    int countOfItems(V8Object v8Object, int i2);

    int countOfSections(V8Object v8Object);

    V8Object createItemView(V8Object v8Object, V8Object v8Object2, String str);

    V8Object createSectionFooter(V8Object v8Object, int i2, String str);

    V8Object createSectionHeader(V8Object v8Object, int i2, String str);

    int reusableKeyForItemView(V8Object v8Object, int i2);

    String reusableKeyForSectionHeader(V8Object v8Object, int i2);

    String reusableKeyForSetionFooter(V8Object v8Object, int i2);

    void reuseItemView(V8Object v8Object, V8Object v8Object2, int i2);

    void reuseSectionFooter(V8Object v8Object, V8Object v8Object2, int i2);

    void reuseSectionHeader(V8Object v8Object, V8Object v8Object2, int i2);

    V8Object sizeForItemView(V8Object v8Object, int i2);
}
