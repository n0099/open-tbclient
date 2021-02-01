package com.ksad.lottie.model.content;

import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class MergePaths implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f8057a;

    /* renamed from: b  reason: collision with root package name */
    private final MergePathsMode f8058b;

    /* loaded from: classes3.dex */
    public enum MergePathsMode {
        Merge,
        Add,
        Subtract,
        Intersect,
        ExcludeIntersections;

        public static MergePathsMode forId(int i) {
            switch (i) {
                case 1:
                    return Merge;
                case 2:
                    return Add;
                case 3:
                    return Subtract;
                case 4:
                    return Intersect;
                case 5:
                    return ExcludeIntersections;
                default:
                    return Merge;
            }
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode) {
        this.f8057a = str;
        this.f8058b = mergePathsMode;
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
        return this.f8057a;
    }

    public MergePathsMode b() {
        return this.f8058b;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f8058b + '}';
    }
}
