package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder;
/* loaded from: classes10.dex */
public interface KotlinClassFinder extends KotlinMetadataFinder {
    Result findKotlinClassOrContent(JavaClass javaClass);

    Result findKotlinClassOrContent(ClassId classId);

    /* loaded from: classes10.dex */
    public static abstract class Result {

        /* loaded from: classes10.dex */
        public static final class ClassFileContent extends Result {
            public final byte[] content;

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof ClassFileContent) && Intrinsics.areEqual(this.content, ((ClassFileContent) obj).content);
                }
                return true;
            }

            public int hashCode() {
                byte[] bArr = this.content;
                if (bArr != null) {
                    return Arrays.hashCode(bArr);
                }
                return 0;
            }

            public String toString() {
                return "ClassFileContent(content=" + Arrays.toString(this.content) + SmallTailInfo.EMOTION_SUFFIX;
            }

            public final byte[] getContent() {
                return this.content;
            }
        }

        /* loaded from: classes10.dex */
        public static final class KotlinClass extends Result {
            public final KotlinJvmBinaryClass kotlinJvmBinaryClass;

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof KotlinClass) && Intrinsics.areEqual(this.kotlinJvmBinaryClass, ((KotlinClass) obj).kotlinJvmBinaryClass);
                }
                return true;
            }

            public int hashCode() {
                KotlinJvmBinaryClass kotlinJvmBinaryClass = this.kotlinJvmBinaryClass;
                if (kotlinJvmBinaryClass != null) {
                    return kotlinJvmBinaryClass.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "KotlinClass(kotlinJvmBinaryClass=" + this.kotlinJvmBinaryClass + SmallTailInfo.EMOTION_SUFFIX;
            }

            public KotlinClass(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
                super(null);
                this.kotlinJvmBinaryClass = kotlinJvmBinaryClass;
            }

            public final KotlinJvmBinaryClass getKotlinJvmBinaryClass() {
                return this.kotlinJvmBinaryClass;
            }
        }

        public Result() {
        }

        public final KotlinJvmBinaryClass toKotlinJvmBinaryClass() {
            Result result;
            if (!(this instanceof KotlinClass)) {
                result = null;
            } else {
                result = this;
            }
            KotlinClass kotlinClass = (KotlinClass) result;
            if (kotlinClass == null) {
                return null;
            }
            return kotlinClass.getKotlinJvmBinaryClass();
        }

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
