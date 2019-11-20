package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class MergePaths implements b {
    private final MergePathsMode ktF;
    private final String name;

    /* loaded from: classes6.dex */
    public enum MergePathsMode {
        Merge,
        Add,
        Subtract,
        Intersect,
        ExcludeIntersections;

        /* JADX INFO: Access modifiers changed from: private */
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

    private MergePaths(String str, MergePathsMode mergePathsMode) {
        this.name = str;
        this.ktF = mergePathsMode;
    }

    public String getName() {
        return this.name;
    }

    public MergePathsMode cLO() {
        return this.ktF;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        if (fVar.bc()) {
            return new com.tb.airbnb.lottie.a.a.j(this);
        }
        Log.w("LOTTIE", "Animation contains merge paths but they are disabled.");
        return null;
    }

    public String toString() {
        return "MergePaths{mode=" + this.ktF + '}';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static MergePaths cx(JSONObject jSONObject) {
            return new MergePaths(jSONObject.optString("nm"), MergePathsMode.forId(jSONObject.optInt("mm", 1)));
        }
    }
}
