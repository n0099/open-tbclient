package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.SinceKotlin;
import kotlin.reflect.KDeclarationContainer;
@SinceKotlin(version = "1.4")
/* loaded from: classes8.dex */
public class AdaptedFunctionReference implements FunctionBase, Serializable {
    public final int arity;
    public final int flags;
    public final boolean isTopLevel;
    public final String name;
    public final Class owner;
    public final Object receiver;
    public final String signature;

    public AdaptedFunctionReference(int i, Class cls, String str, String str2, int i2) {
        this(i, CallableReference.NO_RECEIVER, cls, str, str2, i2);
    }

    public AdaptedFunctionReference(int i, Object obj, Class cls, String str, String str2, int i2) {
        boolean z;
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        if ((i2 & 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isTopLevel = z;
        this.arity = i;
        this.flags = i2 >> 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdaptedFunctionReference)) {
            return false;
        }
        AdaptedFunctionReference adaptedFunctionReference = (AdaptedFunctionReference) obj;
        if (this.isTopLevel == adaptedFunctionReference.isTopLevel && this.arity == adaptedFunctionReference.arity && this.flags == adaptedFunctionReference.flags && Intrinsics.areEqual(this.receiver, adaptedFunctionReference.receiver) && Intrinsics.areEqual(this.owner, adaptedFunctionReference.owner) && this.name.equals(adaptedFunctionReference.name) && this.signature.equals(adaptedFunctionReference.signature)) {
            return true;
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    public KDeclarationContainer getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (this.isTopLevel) {
            return Reflection.getOrCreateKotlinPackage(cls);
        }
        return Reflection.getOrCreateKotlinClass(cls);
    }

    public String toString() {
        return Reflection.renderLambdaToString(this);
    }

    public int hashCode() {
        int i;
        int i2;
        Object obj = this.receiver;
        int i3 = 0;
        if (obj != null) {
            i = obj.hashCode();
        } else {
            i = 0;
        }
        int i4 = i * 31;
        Class cls = this.owner;
        if (cls != null) {
            i3 = cls.hashCode();
        }
        int hashCode = (((((i4 + i3) * 31) + this.name.hashCode()) * 31) + this.signature.hashCode()) * 31;
        if (this.isTopLevel) {
            i2 = 1231;
        } else {
            i2 = 1237;
        }
        return ((((hashCode + i2) * 31) + this.arity) * 31) + this.flags;
    }
}
