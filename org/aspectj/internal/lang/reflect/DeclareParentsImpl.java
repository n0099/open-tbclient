package org.aspectj.internal.lang.reflect;

import java.lang.reflect.Type;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.DeclareParents;
import org.aspectj.lang.reflect.TypePattern;
/* loaded from: classes2.dex */
public class DeclareParentsImpl implements DeclareParents {
    public AjType<?> declaringType;
    public String firstMissingTypeName;
    public boolean isExtends;
    public Type[] parents;
    public boolean parentsError;
    public String parentsString;
    public TypePattern targetTypesPattern;

    public DeclareParentsImpl(String str, String str2, boolean z, AjType<?> ajType) {
        this.parentsError = false;
        this.targetTypesPattern = new TypePatternImpl(str);
        this.isExtends = z;
        this.declaringType = ajType;
        this.parentsString = str2;
        try {
            this.parents = StringToType.commaSeparatedListToTypeArray(str2, ajType.getJavaClass());
        } catch (ClassNotFoundException e) {
            this.parentsError = true;
            this.firstMissingTypeName = e.getMessage();
        }
    }

    @Override // org.aspectj.lang.reflect.DeclareParents
    public AjType getDeclaringType() {
        return this.declaringType;
    }

    @Override // org.aspectj.lang.reflect.DeclareParents
    public Type[] getParentTypes() throws ClassNotFoundException {
        if (!this.parentsError) {
            return this.parents;
        }
        throw new ClassNotFoundException(this.firstMissingTypeName);
    }

    @Override // org.aspectj.lang.reflect.DeclareParents
    public TypePattern getTargetTypesPattern() {
        return this.targetTypesPattern;
    }

    @Override // org.aspectj.lang.reflect.DeclareParents
    public boolean isExtends() {
        return this.isExtends;
    }

    @Override // org.aspectj.lang.reflect.DeclareParents
    public boolean isImplements() {
        return !this.isExtends;
    }

    public String toString() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("declare parents : ");
        stringBuffer.append(getTargetTypesPattern().asString());
        if (isExtends()) {
            str = " extends ";
        } else {
            str = " implements ";
        }
        stringBuffer.append(str);
        stringBuffer.append(this.parentsString);
        return stringBuffer.toString();
    }
}
