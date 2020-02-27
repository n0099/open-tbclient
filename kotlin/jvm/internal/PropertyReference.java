package kotlin.jvm.internal;
/* loaded from: classes7.dex */
public abstract class PropertyReference extends CallableReference implements kotlin.reflect.j {
    public PropertyReference() {
    }

    public PropertyReference(Object obj) {
        super(obj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.j getReflected() {
        return (kotlin.reflect.j) super.getReflected();
    }

    @Override // kotlin.reflect.j
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    @Override // kotlin.reflect.j
    public boolean isConst() {
        return getReflected().isConst();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            return getOwner().equals(propertyReference.getOwner()) && getName().equals(propertyReference.getName()) && getSignature().equals(propertyReference.getSignature()) && q.h(getBoundReceiver(), propertyReference.getBoundReceiver());
        } else if (obj instanceof kotlin.reflect.j) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public String toString() {
        kotlin.reflect.b compute = compute();
        return compute != this ? compute.toString() : "property " + getName() + " (Kotlin reflection is not available)";
    }
}
