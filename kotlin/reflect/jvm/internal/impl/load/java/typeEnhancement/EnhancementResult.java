package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
/* loaded from: classes9.dex */
public final class EnhancementResult<T> {
    public final Annotations enhancementAnnotations;
    public final T result;

    public final T component1() {
        return this.result;
    }

    public final Annotations component2() {
        return this.enhancementAnnotations;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof EnhancementResult) {
                EnhancementResult enhancementResult = (EnhancementResult) obj;
                return Intrinsics.areEqual(this.result, enhancementResult.result) && Intrinsics.areEqual(this.enhancementAnnotations, enhancementResult.enhancementAnnotations);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        T t = this.result;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        Annotations annotations = this.enhancementAnnotations;
        return hashCode + (annotations != null ? annotations.hashCode() : 0);
    }

    public String toString() {
        return "EnhancementResult(result=" + this.result + ", enhancementAnnotations=" + this.enhancementAnnotations + SmallTailInfo.EMOTION_SUFFIX;
    }

    public EnhancementResult(T t, Annotations annotations) {
        this.result = t;
        this.enhancementAnnotations = annotations;
    }
}
