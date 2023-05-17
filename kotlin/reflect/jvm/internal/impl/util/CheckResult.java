package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes10.dex */
public abstract class CheckResult {
    public final boolean isSuccess;

    /* loaded from: classes10.dex */
    public static final class IllegalFunctionName extends CheckResult {
        public static final IllegalFunctionName INSTANCE = new IllegalFunctionName();

        public IllegalFunctionName() {
            super(false, null);
        }
    }

    /* loaded from: classes10.dex */
    public static final class IllegalSignature extends CheckResult {
        public final String error;

        public IllegalSignature(String str) {
            super(false, null);
            this.error = str;
        }
    }

    /* loaded from: classes10.dex */
    public static final class SuccessCheck extends CheckResult {
        public static final SuccessCheck INSTANCE = new SuccessCheck();

        public SuccessCheck() {
            super(true, null);
        }
    }

    public CheckResult(boolean z) {
        this.isSuccess = z;
    }

    public /* synthetic */ CheckResult(boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(z);
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }
}
