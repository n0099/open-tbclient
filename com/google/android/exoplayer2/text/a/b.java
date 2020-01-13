package com.google.android.exoplayer2.text.a;

import android.support.annotation.NonNull;
import android.text.Layout;
/* loaded from: classes5.dex */
final class b extends com.google.android.exoplayer2.text.b implements Comparable<b> {
    public final int priority;

    public b(CharSequence charSequence, Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z, int i4, int i5) {
        super(charSequence, alignment, f, i, i2, f2, i3, f3, z, i4);
        this.priority = i5;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull b bVar) {
        if (bVar.priority < this.priority) {
            return -1;
        }
        if (bVar.priority > this.priority) {
            return 1;
        }
        return 0;
    }
}
