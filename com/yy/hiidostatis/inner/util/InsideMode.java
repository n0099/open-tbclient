package com.yy.hiidostatis.inner.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import com.yy.hiidostatis.inner.util.log.L;
/* loaded from: classes8.dex */
public class InsideMode {
    public static /* synthetic */ Interceptable $ic;
    public static boolean encriptIMEI;
    public static boolean encriptIMSI;
    public static boolean encriptMAC;
    public static EncriptType encriptType;
    public static HostApp hostApp;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.yy.hiidostatis.inner.util.InsideMode$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$yy$hiidostatis$inner$util$InsideMode$EncriptType;
        public static final /* synthetic */ int[] $SwitchMap$com$yy$hiidostatis$inner$util$InsideMode$HostApp;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(705775438, "Lcom/yy/hiidostatis/inner/util/InsideMode$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(705775438, "Lcom/yy/hiidostatis/inner/util/InsideMode$1;");
                    return;
                }
            }
            int[] iArr = new int[HostApp.values().length];
            $SwitchMap$com$yy$hiidostatis$inner$util$InsideMode$HostApp = iArr;
            try {
                iArr[HostApp.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$yy$hiidostatis$inner$util$InsideMode$HostApp[HostApp.MI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$yy$hiidostatis$inner$util$InsideMode$HostApp[HostApp.VIVO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$yy$hiidostatis$inner$util$InsideMode$HostApp[HostApp.MEIPAI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[EncriptType.values().length];
            $SwitchMap$com$yy$hiidostatis$inner$util$InsideMode$EncriptType = iArr2;
            try {
                iArr2[EncriptType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$yy$hiidostatis$inner$util$InsideMode$EncriptType[EncriptType.MD5.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$yy$hiidostatis$inner$util$InsideMode$EncriptType[EncriptType.SHA256.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$yy$hiidostatis$inner$util$InsideMode$EncriptType[EncriptType.DOUBLE_MD5.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class EncriptType {
        public static final /* synthetic */ EncriptType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final EncriptType DOUBLE_MD5;
        public static final EncriptType MD5;
        public static final EncriptType NONE;
        public static final EncriptType SHA256;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1589405904, "Lcom/yy/hiidostatis/inner/util/InsideMode$EncriptType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1589405904, "Lcom/yy/hiidostatis/inner/util/InsideMode$EncriptType;");
                    return;
                }
            }
            NONE = new EncriptType("NONE", 0);
            MD5 = new EncriptType("MD5", 1);
            DOUBLE_MD5 = new EncriptType("DOUBLE_MD5", 2);
            EncriptType encriptType = new EncriptType("SHA256", 3);
            SHA256 = encriptType;
            $VALUES = new EncriptType[]{NONE, MD5, DOUBLE_MD5, encriptType};
        }

        public EncriptType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static EncriptType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EncriptType) Enum.valueOf(EncriptType.class, str) : (EncriptType) invokeL.objValue;
        }

        public static EncriptType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EncriptType[]) $VALUES.clone() : (EncriptType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class HostApp {
        public static final /* synthetic */ HostApp[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final HostApp MEIPAI;
        public static final HostApp MI;
        public static final HostApp NONE;
        public static final HostApp VIVO;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1889819206, "Lcom/yy/hiidostatis/inner/util/InsideMode$HostApp;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1889819206, "Lcom/yy/hiidostatis/inner/util/InsideMode$HostApp;");
                    return;
                }
            }
            NONE = new HostApp("NONE", 0);
            MI = new HostApp("MI", 1);
            VIVO = new HostApp("VIVO", 2);
            HostApp hostApp = new HostApp("MEIPAI", 3);
            MEIPAI = hostApp;
            $VALUES = new HostApp[]{NONE, MI, VIVO, hostApp};
        }

        public HostApp(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static HostApp valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (HostApp) Enum.valueOf(HostApp.class, str) : (HostApp) invokeL.objValue;
        }

        public static HostApp[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (HostApp[]) $VALUES.clone() : (HostApp[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(183974459, "Lcom/yy/hiidostatis/inner/util/InsideMode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(183974459, "Lcom/yy/hiidostatis/inner/util/InsideMode;");
                return;
            }
        }
        encriptType = EncriptType.NONE;
        hostApp = HostApp.NONE;
    }

    public InsideMode() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String encript(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str == null || str.isEmpty()) {
                return str;
            }
            try {
                int i = AnonymousClass1.$SwitchMap$com$yy$hiidostatis$inner$util$InsideMode$EncriptType[encriptType.ordinal()];
                if (i != 2) {
                    if (i != 3) {
                        return i != 4 ? str : Coder.encryptMD5(Coder.encryptMD5(str));
                    }
                    return Coder.sha256Encrypt(str);
                }
                return Coder.encryptMD5(str);
            } catch (Throwable th) {
                L.debug("InsideMode", "encript", th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void initHostApp(HostApp hostApp2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, hostApp2) == null) {
            int i = AnonymousClass1.$SwitchMap$com$yy$hiidostatis$inner$util$InsideMode$HostApp[hostApp2.ordinal()];
            if (i == 1) {
                encriptIMEI = false;
                encriptIMSI = false;
                encriptMAC = false;
                encriptType = EncriptType.NONE;
            } else if (i == 2) {
                encriptIMEI = true;
                encriptIMSI = true;
                encriptMAC = false;
                encriptType = EncriptType.SHA256;
            } else if (i == 3) {
                encriptIMEI = true;
                encriptIMSI = true;
                encriptMAC = true;
                encriptType = EncriptType.DOUBLE_MD5;
            } else if (i != 4) {
            } else {
                encriptIMEI = true;
                encriptIMSI = true;
                encriptMAC = false;
                encriptType = EncriptType.SHA256;
            }
        }
    }

    public static boolean isSafeMac() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? encriptMAC : invokeV.booleanValue;
    }

    public static String safeIMEI(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? encriptIMEI ? encript(str) : str : (String) invokeL.objValue;
    }

    public static String safeIMSI(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? encriptIMSI ? encript(str) : str : (String) invokeL.objValue;
    }

    public static String safeMac(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? encriptMAC ? encript(str) : str : (String) invokeL.objValue;
    }
}
