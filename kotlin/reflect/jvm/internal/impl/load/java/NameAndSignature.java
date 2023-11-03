package kotlin.reflect.jvm.internal.impl.load.java;

import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
/* loaded from: classes2.dex */
public final class NameAndSignature {
    public final Name name;
    public final String signature;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof NameAndSignature) {
                NameAndSignature nameAndSignature = (NameAndSignature) obj;
                return Intrinsics.areEqual(this.name, nameAndSignature.name) && Intrinsics.areEqual(this.signature, nameAndSignature.signature);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Name name = this.name;
        int hashCode = (name != null ? name.hashCode() : 0) * 31;
        String str = this.signature;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "NameAndSignature(name=" + this.name + ", signature=" + this.signature + SmallTailInfo.EMOTION_SUFFIX;
    }

    public NameAndSignature(Name name, String str) {
        this.name = name;
        this.signature = str;
    }

    public final Name getName() {
        return this.name;
    }

    public final String getSignature() {
        return this.signature;
    }
}
