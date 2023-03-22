package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
/* loaded from: classes9.dex */
public final class MemberSignature {
    public static final Companion Companion = new Companion(null);
    public final String signature;

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof MemberSignature) && Intrinsics.areEqual(this.signature, ((MemberSignature) obj).signature);
        }
        return true;
    }

    public int hashCode() {
        String str = this.signature;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "MemberSignature(signature=" + this.signature + SmallTailInfo.EMOTION_SUFFIX;
    }

    /* loaded from: classes9.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MemberSignature fromJvmMemberSignature(JvmMemberSignature jvmMemberSignature) {
            if (jvmMemberSignature instanceof JvmMemberSignature.Method) {
                return fromMethodNameAndDesc(jvmMemberSignature.getName(), jvmMemberSignature.getDesc());
            }
            if (jvmMemberSignature instanceof JvmMemberSignature.Field) {
                return fromFieldNameAndDesc(jvmMemberSignature.getName(), jvmMemberSignature.getDesc());
            }
            throw new NoWhenBranchMatchedException();
        }

        @JvmStatic
        public final MemberSignature fromFieldNameAndDesc(String str, String str2) {
            return new MemberSignature(str + '#' + str2, null);
        }

        @JvmStatic
        public final MemberSignature fromMethod(NameResolver nameResolver, JvmProtoBuf.JvmMethodSignature jvmMethodSignature) {
            return fromMethodNameAndDesc(nameResolver.getString(jvmMethodSignature.getName()), nameResolver.getString(jvmMethodSignature.getDesc()));
        }

        @JvmStatic
        public final MemberSignature fromMethodNameAndDesc(String str, String str2) {
            return new MemberSignature(str + str2, null);
        }

        @JvmStatic
        public final MemberSignature fromMethodSignatureAndParameterIndex(MemberSignature memberSignature, int i) {
            return new MemberSignature(memberSignature.getSignature$descriptors_jvm() + '@' + i, null);
        }
    }

    public MemberSignature(String str) {
        this.signature = str;
    }

    public /* synthetic */ MemberSignature(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public final String getSignature$descriptors_jvm() {
        return this.signature;
    }
}
