package org.aspectj.internal.lang.reflect;

import org.aspectj.lang.reflect.PerClause;
import org.aspectj.lang.reflect.PerClauseKind;
/* loaded from: classes10.dex */
public class PerClauseImpl implements PerClause {
    public final PerClauseKind kind;

    public String toString() {
        return "issingleton()";
    }

    public PerClauseImpl(PerClauseKind perClauseKind) {
        this.kind = perClauseKind;
    }

    @Override // org.aspectj.lang.reflect.PerClause
    public PerClauseKind getKind() {
        return this.kind;
    }
}
