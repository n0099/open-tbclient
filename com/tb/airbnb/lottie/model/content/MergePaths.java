package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
/* loaded from: classes5.dex */
public class MergePaths implements b {
    private final String name;
    private final MergePathsMode nqu;

    /* loaded from: classes5.dex */
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
        this.name = str;
        this.nqu = mergePathsMode;
    }

    public String getName() {
        return this.name;
    }

    public MergePathsMode dFZ() {
        return this.nqu;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        if (fVar.bp()) {
            return new com.tb.airbnb.lottie.a.a.k(this);
        }
        com.tb.airbnb.lottie.c.warn("Animation contains merge paths but they are disabled.");
        return null;
    }

    public String toString() {
        return "MergePaths{mode=" + this.nqu + '}';
    }
}
