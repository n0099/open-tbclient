package com.ksad.lottie.model.content;

import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class MergePaths implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f31482a;

    /* renamed from: b  reason: collision with root package name */
    public final MergePathsMode f31483b;

    /* loaded from: classes6.dex */
    public enum MergePathsMode {
        Merge,
        Add,
        Subtract,
        Intersect,
        ExcludeIntersections;

        public static MergePathsMode forId(int i) {
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? Merge : ExcludeIntersections : Intersect : Subtract : Add : Merge;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode) {
        this.f31482a = str;
        this.f31483b = mergePathsMode;
    }

    @Override // com.ksad.lottie.model.content.b
    @Nullable
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        if (fVar.a()) {
            return new com.ksad.lottie.a.a.k(this);
        }
        com.ksad.lottie.c.b("Animation contains merge paths but they are disabled.");
        return null;
    }

    public String a() {
        return this.f31482a;
    }

    public MergePathsMode b() {
        return this.f31483b;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f31483b + '}';
    }
}
