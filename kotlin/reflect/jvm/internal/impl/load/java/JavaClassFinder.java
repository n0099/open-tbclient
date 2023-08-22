package kotlin.reflect.jvm.internal.impl.load.java;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.Arrays;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
/* loaded from: classes2.dex */
public interface JavaClassFinder {
    JavaClass findClass(Request request);

    JavaPackage findPackage(FqName fqName);

    Set<String> knownClassNamesInPackage(FqName fqName);

    /* loaded from: classes2.dex */
    public static final class Request {
        public final ClassId classId;
        public final JavaClass outerClass;
        public final byte[] previouslyFoundClassFileContent;

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Request) {
                    Request request = (Request) obj;
                    return Intrinsics.areEqual(this.classId, request.classId) && Intrinsics.areEqual(this.previouslyFoundClassFileContent, request.previouslyFoundClassFileContent) && Intrinsics.areEqual(this.outerClass, request.outerClass);
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            ClassId classId = this.classId;
            int hashCode = (classId != null ? classId.hashCode() : 0) * 31;
            byte[] bArr = this.previouslyFoundClassFileContent;
            int hashCode2 = (hashCode + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
            JavaClass javaClass = this.outerClass;
            return hashCode2 + (javaClass != null ? javaClass.hashCode() : 0);
        }

        public String toString() {
            return "Request(classId=" + this.classId + ", previouslyFoundClassFileContent=" + Arrays.toString(this.previouslyFoundClassFileContent) + ", outerClass=" + this.outerClass + SmallTailInfo.EMOTION_SUFFIX;
        }

        public Request(ClassId classId, byte[] bArr, JavaClass javaClass) {
            this.classId = classId;
            this.previouslyFoundClassFileContent = bArr;
            this.outerClass = javaClass;
        }

        public /* synthetic */ Request(ClassId classId, byte[] bArr, JavaClass javaClass, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(classId, (i & 2) != 0 ? null : bArr, (i & 4) != 0 ? null : javaClass);
        }

        public final ClassId getClassId() {
            return this.classId;
        }
    }
}
