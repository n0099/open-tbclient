package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import com.baidu.android.common.others.IStringUtil;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
/* loaded from: classes9.dex */
public class JvmClassName {
    public FqName fqName;
    public final String internalName;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 3 || i == 6 || i == 7 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 3 || i == 6 || i == 7 || i == 8) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "classId";
                break;
            case 2:
            case 4:
                objArr[0] = "fqName";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
                break;
            case 5:
            default:
                objArr[0] = "internalName";
                break;
        }
        if (i == 3) {
            objArr[1] = "byFqNameWithoutInnerClasses";
        } else if (i == 6) {
            objArr[1] = "getFqNameForClassNameWithoutDollars";
        } else if (i == 7) {
            objArr[1] = "getPackageFqName";
        } else if (i != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
        } else {
            objArr[1] = "getInternalName";
        }
        switch (i) {
            case 1:
                objArr[2] = "byClassId";
                break;
            case 2:
            case 4:
                objArr[2] = "byFqNameWithoutInnerClasses";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                break;
            case 5:
                objArr[2] = "<init>";
                break;
            default:
                objArr[2] = "byInternalName";
                break;
        }
        String format = String.format(str, objArr);
        if (i != 3 && i != 6 && i != 7 && i != 8) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    public JvmClassName(String str) {
        if (str == null) {
            $$$reportNull$$$0(5);
        }
        this.internalName = str;
    }

    public static JvmClassName byFqNameWithoutInnerClasses(FqName fqName) {
        if (fqName == null) {
            $$$reportNull$$$0(2);
        }
        JvmClassName jvmClassName = new JvmClassName(fqName.asString().replace(IStringUtil.EXTENSION_SEPARATOR, WebvttCueParser.CHAR_SLASH));
        jvmClassName.fqName = fqName;
        return jvmClassName;
    }

    public static JvmClassName byInternalName(String str) {
        if (str == null) {
            $$$reportNull$$$0(0);
        }
        return new JvmClassName(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && JvmClassName.class == obj.getClass()) {
            return this.internalName.equals(((JvmClassName) obj).internalName);
        }
        return false;
    }

    public static JvmClassName byClassId(ClassId classId) {
        if (classId == null) {
            $$$reportNull$$$0(1);
        }
        FqName packageFqName = classId.getPackageFqName();
        String replace = classId.getRelativeClassName().asString().replace(IStringUtil.EXTENSION_SEPARATOR, '$');
        if (packageFqName.isRoot()) {
            return new JvmClassName(replace);
        }
        return new JvmClassName(packageFqName.asString().replace(IStringUtil.EXTENSION_SEPARATOR, WebvttCueParser.CHAR_SLASH) + "/" + replace);
    }

    public FqName getFqNameForTopLevelClassMaybeWithDollars() {
        return new FqName(this.internalName.replace(WebvttCueParser.CHAR_SLASH, IStringUtil.EXTENSION_SEPARATOR));
    }

    public String getInternalName() {
        String str = this.internalName;
        if (str == null) {
            $$$reportNull$$$0(8);
        }
        return str;
    }

    public FqName getPackageFqName() {
        int lastIndexOf = this.internalName.lastIndexOf("/");
        if (lastIndexOf == -1) {
            FqName fqName = FqName.ROOT;
            if (fqName == null) {
                $$$reportNull$$$0(7);
            }
            return fqName;
        }
        return new FqName(this.internalName.substring(0, lastIndexOf).replace(WebvttCueParser.CHAR_SLASH, IStringUtil.EXTENSION_SEPARATOR));
    }

    public int hashCode() {
        return this.internalName.hashCode();
    }

    public String toString() {
        return this.internalName;
    }
}
