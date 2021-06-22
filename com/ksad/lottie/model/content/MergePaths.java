package com.ksad.lottie.model.content;

import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class MergePaths implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f32113a;

    /* renamed from: b  reason: collision with root package name */
    public final MergePathsMode f32114b;

    /* loaded from: classes6.dex */
    public enum MergePathsMode {
        Merge,
        Add,
        Subtract,
        Intersect,
        ExcludeIntersections;

        public static MergePathsMode forId(int i2) {
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? Merge : ExcludeIntersections : Intersect : Subtract : Add : Merge;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode) {
        this.f32113a = str;
        this.f32114b = mergePathsMode;
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
        return this.f32113a;
    }

    public MergePathsMode b() {
        return this.f32114b;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f32114b + '}';
    }
}
