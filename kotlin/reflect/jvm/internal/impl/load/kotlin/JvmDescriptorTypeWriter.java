package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes9.dex */
public class JvmDescriptorTypeWriter<T> {
    public T jvmCurrentType;
    public int jvmCurrentTypeArrayLevel;
    public final JvmTypeFactory<T> jvmTypeFactory;

    public void writeArrayEnd() {
    }

    public void writeArrayType() {
        if (this.jvmCurrentType == null) {
            this.jvmCurrentTypeArrayLevel++;
        }
    }

    public void writeClass(T t) {
        writeJvmTypeAsIs(t);
    }

    public final void writeJvmTypeAsIs(T t) {
        if (this.jvmCurrentType == null) {
            if (this.jvmCurrentTypeArrayLevel > 0) {
                JvmTypeFactory<T> jvmTypeFactory = this.jvmTypeFactory;
                t = jvmTypeFactory.createFromString(StringsKt__StringsJVMKt.repeat(PreferencesUtil.LEFT_MOUNT, this.jvmCurrentTypeArrayLevel) + this.jvmTypeFactory.toString(t));
            }
            this.jvmCurrentType = t;
        }
    }

    public void writeTypeVariable(Name name, T t) {
        writeJvmTypeAsIs(t);
    }
}
