package org.chromium.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes2.dex */
public @interface ChildBindingState {
    public static final int MAX_VALUE = 3;
    public static final int MODERATE = 2;
    public static final int STRONG = 3;
    public static final int UNBOUND = 0;
    public static final int WAIVED = 1;
}
