package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.util.Check;
/* loaded from: classes10.dex */
public abstract class ValueParameterCountCheck implements Check {
    public final String description;

    /* loaded from: classes10.dex */
    public static final class AtLeast extends ValueParameterCountCheck {
        public final int n;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public AtLeast(int i) {
            super(r0.toString(), null);
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("must have at least ");
            sb.append(i);
            sb.append(" value parameter");
            if (i > 1) {
                str = "s";
            } else {
                str = "";
            }
            sb.append(str);
            this.n = i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor functionDescriptor) {
            if (functionDescriptor.getValueParameters().size() >= this.n) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes10.dex */
    public static final class Equals extends ValueParameterCountCheck {
        public final int n;

        public Equals(int i) {
            super("must have exactly " + i + " value parameters", null);
            this.n = i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor functionDescriptor) {
            if (functionDescriptor.getValueParameters().size() == this.n) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes10.dex */
    public static final class NoValueParameters extends ValueParameterCountCheck {
        public static final NoValueParameters INSTANCE = new NoValueParameters();

        public NoValueParameters() {
            super("must have no value parameters", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor functionDescriptor) {
            return functionDescriptor.getValueParameters().isEmpty();
        }
    }

    /* loaded from: classes10.dex */
    public static final class SingleValueParameter extends ValueParameterCountCheck {
        public static final SingleValueParameter INSTANCE = new SingleValueParameter();

        public SingleValueParameter() {
            super("must have a single value parameter", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor functionDescriptor) {
            if (functionDescriptor.getValueParameters().size() == 1) {
                return true;
            }
            return false;
        }
    }

    public ValueParameterCountCheck(String str) {
        this.description = str;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String invoke(FunctionDescriptor functionDescriptor) {
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }

    public /* synthetic */ ValueParameterCountCheck(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String getDescription() {
        return this.description;
    }
}
