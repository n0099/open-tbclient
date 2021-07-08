package com.google.common.base;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class StandardSystemProperty {
    public static final /* synthetic */ StandardSystemProperty[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final StandardSystemProperty FILE_SEPARATOR;
    public static final StandardSystemProperty JAVA_CLASS_PATH;
    public static final StandardSystemProperty JAVA_CLASS_VERSION;
    public static final StandardSystemProperty JAVA_COMPILER;
    public static final StandardSystemProperty JAVA_EXT_DIRS;
    public static final StandardSystemProperty JAVA_HOME;
    public static final StandardSystemProperty JAVA_IO_TMPDIR;
    public static final StandardSystemProperty JAVA_LIBRARY_PATH;
    public static final StandardSystemProperty JAVA_SPECIFICATION_NAME;
    public static final StandardSystemProperty JAVA_SPECIFICATION_VENDOR;
    public static final StandardSystemProperty JAVA_SPECIFICATION_VERSION;
    public static final StandardSystemProperty JAVA_VENDOR;
    public static final StandardSystemProperty JAVA_VENDOR_URL;
    public static final StandardSystemProperty JAVA_VERSION;
    public static final StandardSystemProperty JAVA_VM_NAME;
    public static final StandardSystemProperty JAVA_VM_SPECIFICATION_NAME;
    public static final StandardSystemProperty JAVA_VM_SPECIFICATION_VENDOR;
    public static final StandardSystemProperty JAVA_VM_SPECIFICATION_VERSION;
    public static final StandardSystemProperty JAVA_VM_VENDOR;
    public static final StandardSystemProperty JAVA_VM_VERSION;
    public static final StandardSystemProperty LINE_SEPARATOR;
    public static final StandardSystemProperty OS_ARCH;
    public static final StandardSystemProperty OS_NAME;
    public static final StandardSystemProperty OS_VERSION;
    public static final StandardSystemProperty PATH_SEPARATOR;
    public static final StandardSystemProperty USER_DIR;
    public static final StandardSystemProperty USER_HOME;
    public static final StandardSystemProperty USER_NAME;
    public transient /* synthetic */ FieldHolder $fh;
    public final String key;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(694590244, "Lcom/google/common/base/StandardSystemProperty;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(694590244, "Lcom/google/common/base/StandardSystemProperty;");
                return;
            }
        }
        JAVA_VERSION = new StandardSystemProperty("JAVA_VERSION", 0, "java.version");
        JAVA_VENDOR = new StandardSystemProperty("JAVA_VENDOR", 1, "java.vendor");
        JAVA_VENDOR_URL = new StandardSystemProperty("JAVA_VENDOR_URL", 2, "java.vendor.url");
        JAVA_HOME = new StandardSystemProperty("JAVA_HOME", 3, "java.home");
        JAVA_VM_SPECIFICATION_VERSION = new StandardSystemProperty("JAVA_VM_SPECIFICATION_VERSION", 4, "java.vm.specification.version");
        JAVA_VM_SPECIFICATION_VENDOR = new StandardSystemProperty("JAVA_VM_SPECIFICATION_VENDOR", 5, "java.vm.specification.vendor");
        JAVA_VM_SPECIFICATION_NAME = new StandardSystemProperty("JAVA_VM_SPECIFICATION_NAME", 6, "java.vm.specification.name");
        JAVA_VM_VERSION = new StandardSystemProperty("JAVA_VM_VERSION", 7, "java.vm.version");
        JAVA_VM_VENDOR = new StandardSystemProperty("JAVA_VM_VENDOR", 8, "java.vm.vendor");
        JAVA_VM_NAME = new StandardSystemProperty("JAVA_VM_NAME", 9, "java.vm.name");
        JAVA_SPECIFICATION_VERSION = new StandardSystemProperty("JAVA_SPECIFICATION_VERSION", 10, "java.specification.version");
        JAVA_SPECIFICATION_VENDOR = new StandardSystemProperty("JAVA_SPECIFICATION_VENDOR", 11, "java.specification.vendor");
        JAVA_SPECIFICATION_NAME = new StandardSystemProperty("JAVA_SPECIFICATION_NAME", 12, "java.specification.name");
        JAVA_CLASS_VERSION = new StandardSystemProperty("JAVA_CLASS_VERSION", 13, "java.class.version");
        JAVA_CLASS_PATH = new StandardSystemProperty("JAVA_CLASS_PATH", 14, "java.class.path");
        JAVA_LIBRARY_PATH = new StandardSystemProperty("JAVA_LIBRARY_PATH", 15, "java.library.path");
        JAVA_IO_TMPDIR = new StandardSystemProperty("JAVA_IO_TMPDIR", 16, "java.io.tmpdir");
        JAVA_COMPILER = new StandardSystemProperty("JAVA_COMPILER", 17, "java.compiler");
        JAVA_EXT_DIRS = new StandardSystemProperty("JAVA_EXT_DIRS", 18, "java.ext.dirs");
        OS_NAME = new StandardSystemProperty("OS_NAME", 19, "os.name");
        OS_ARCH = new StandardSystemProperty("OS_ARCH", 20, "os.arch");
        OS_VERSION = new StandardSystemProperty("OS_VERSION", 21, "os.version");
        FILE_SEPARATOR = new StandardSystemProperty("FILE_SEPARATOR", 22, "file.separator");
        PATH_SEPARATOR = new StandardSystemProperty("PATH_SEPARATOR", 23, "path.separator");
        LINE_SEPARATOR = new StandardSystemProperty("LINE_SEPARATOR", 24, "line.separator");
        USER_NAME = new StandardSystemProperty("USER_NAME", 25, "user.name");
        USER_HOME = new StandardSystemProperty("USER_HOME", 26, "user.home");
        StandardSystemProperty standardSystemProperty = new StandardSystemProperty("USER_DIR", 27, "user.dir");
        USER_DIR = standardSystemProperty;
        $VALUES = new StandardSystemProperty[]{JAVA_VERSION, JAVA_VENDOR, JAVA_VENDOR_URL, JAVA_HOME, JAVA_VM_SPECIFICATION_VERSION, JAVA_VM_SPECIFICATION_VENDOR, JAVA_VM_SPECIFICATION_NAME, JAVA_VM_VERSION, JAVA_VM_VENDOR, JAVA_VM_NAME, JAVA_SPECIFICATION_VERSION, JAVA_SPECIFICATION_VENDOR, JAVA_SPECIFICATION_NAME, JAVA_CLASS_VERSION, JAVA_CLASS_PATH, JAVA_LIBRARY_PATH, JAVA_IO_TMPDIR, JAVA_COMPILER, JAVA_EXT_DIRS, OS_NAME, OS_ARCH, OS_VERSION, FILE_SEPARATOR, PATH_SEPARATOR, LINE_SEPARATOR, USER_NAME, USER_HOME, standardSystemProperty};
    }

    public StandardSystemProperty(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.key = str2;
    }

    public static StandardSystemProperty valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (StandardSystemProperty) Enum.valueOf(StandardSystemProperty.class, str) : (StandardSystemProperty) invokeL.objValue;
    }

    public static StandardSystemProperty[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (StandardSystemProperty[]) $VALUES.clone() : (StandardSystemProperty[]) invokeV.objValue;
    }

    public String key() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.key : (String) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return key() + "=" + value();
        }
        return (String) invokeV.objValue;
    }

    public String value() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? System.getProperty(this.key) : (String) invokeV.objValue;
    }
}
