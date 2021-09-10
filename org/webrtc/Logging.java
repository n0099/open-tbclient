package org.webrtc;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.EnumSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class Logging {
    public static /* synthetic */ Interceptable $ic;
    public static final Logger fallbackLogger;
    @Nullable
    public static Loggable loggable;
    public static Severity loggableSeverity;
    public static volatile boolean loggingEnabled;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: org.webrtc.Logging$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$webrtc$Logging$Severity;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-622854342, "Lorg/webrtc/Logging$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-622854342, "Lorg/webrtc/Logging$1;");
                    return;
                }
            }
            int[] iArr = new int[Severity.values().length];
            $SwitchMap$org$webrtc$Logging$Severity = iArr;
            try {
                iArr[Severity.LS_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$webrtc$Logging$Severity[Severity.LS_WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$webrtc$Logging$Severity[Severity.LS_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class Severity {
        public static final /* synthetic */ Severity[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Severity LS_ERROR;
        public static final Severity LS_INFO;
        public static final Severity LS_NONE;
        public static final Severity LS_SENSITIVE;
        public static final Severity LS_VERBOSE;
        public static final Severity LS_WARNING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1578098258, "Lorg/webrtc/Logging$Severity;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1578098258, "Lorg/webrtc/Logging$Severity;");
                    return;
                }
            }
            LS_SENSITIVE = new Severity("LS_SENSITIVE", 0);
            LS_VERBOSE = new Severity("LS_VERBOSE", 1);
            LS_INFO = new Severity("LS_INFO", 2);
            LS_WARNING = new Severity("LS_WARNING", 3);
            LS_ERROR = new Severity("LS_ERROR", 4);
            Severity severity = new Severity("LS_NONE", 5);
            LS_NONE = severity;
            $VALUES = new Severity[]{LS_SENSITIVE, LS_VERBOSE, LS_INFO, LS_WARNING, LS_ERROR, severity};
        }

        public Severity(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Severity valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Severity) Enum.valueOf(Severity.class, str) : (Severity) invokeL.objValue;
        }

        public static Severity[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Severity[]) $VALUES.clone() : (Severity[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Deprecated
    /* loaded from: classes2.dex */
    public static final class TraceLevel {
        public static final /* synthetic */ TraceLevel[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final TraceLevel TRACE_ALL;
        public static final TraceLevel TRACE_APICALL;
        public static final TraceLevel TRACE_CRITICAL;
        public static final TraceLevel TRACE_DEBUG;
        public static final TraceLevel TRACE_DEFAULT;
        public static final TraceLevel TRACE_ERROR;
        public static final TraceLevel TRACE_INFO;
        public static final TraceLevel TRACE_MEMORY;
        public static final TraceLevel TRACE_MODULECALL;
        public static final TraceLevel TRACE_NONE;
        public static final TraceLevel TRACE_STATEINFO;
        public static final TraceLevel TRACE_STREAM;
        public static final TraceLevel TRACE_TERSEINFO;
        public static final TraceLevel TRACE_TIMER;
        public static final TraceLevel TRACE_WARNING;
        public transient /* synthetic */ FieldHolder $fh;
        public final int level;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(128764844, "Lorg/webrtc/Logging$TraceLevel;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(128764844, "Lorg/webrtc/Logging$TraceLevel;");
                    return;
                }
            }
            TRACE_NONE = new TraceLevel("TRACE_NONE", 0, 0);
            TRACE_STATEINFO = new TraceLevel("TRACE_STATEINFO", 1, 1);
            TRACE_WARNING = new TraceLevel("TRACE_WARNING", 2, 2);
            TRACE_ERROR = new TraceLevel("TRACE_ERROR", 3, 4);
            TRACE_CRITICAL = new TraceLevel("TRACE_CRITICAL", 4, 8);
            TRACE_APICALL = new TraceLevel("TRACE_APICALL", 5, 16);
            TRACE_DEFAULT = new TraceLevel("TRACE_DEFAULT", 6, 255);
            TRACE_MODULECALL = new TraceLevel("TRACE_MODULECALL", 7, 32);
            TRACE_MEMORY = new TraceLevel("TRACE_MEMORY", 8, 256);
            TRACE_TIMER = new TraceLevel("TRACE_TIMER", 9, 512);
            TRACE_STREAM = new TraceLevel("TRACE_STREAM", 10, 1024);
            TRACE_DEBUG = new TraceLevel("TRACE_DEBUG", 11, 2048);
            TRACE_INFO = new TraceLevel("TRACE_INFO", 12, 4096);
            TRACE_TERSEINFO = new TraceLevel("TRACE_TERSEINFO", 13, 8192);
            TraceLevel traceLevel = new TraceLevel("TRACE_ALL", 14, 65535);
            TRACE_ALL = traceLevel;
            $VALUES = new TraceLevel[]{TRACE_NONE, TRACE_STATEINFO, TRACE_WARNING, TRACE_ERROR, TRACE_CRITICAL, TRACE_APICALL, TRACE_DEFAULT, TRACE_MODULECALL, TRACE_MEMORY, TRACE_TIMER, TRACE_STREAM, TRACE_DEBUG, TRACE_INFO, TRACE_TERSEINFO, traceLevel};
        }

        public TraceLevel(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.level = i3;
        }

        public static TraceLevel valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TraceLevel) Enum.valueOf(TraceLevel.class, str) : (TraceLevel) invokeL.objValue;
        }

        public static TraceLevel[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TraceLevel[]) $VALUES.clone() : (TraceLevel[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1716847321, "Lorg/webrtc/Logging;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1716847321, "Lorg/webrtc/Logging;");
                return;
            }
        }
        fallbackLogger = createFallbackLogger();
    }

    public Logging() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Logger createFallbackLogger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Logger logger = Logger.getLogger("org.webrtc.Logging");
            logger.setLevel(Level.ALL);
            return logger;
        }
        return (Logger) invokeV.objValue;
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            log(Severity.LS_INFO, str, str2);
        }
    }

    public static void deleteInjectedLoggable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            loggable = null;
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2) == null) {
            log(Severity.LS_ERROR, str, str2);
        }
    }

    public static void enableLogThreads() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            nativeEnableLogThreads();
        }
    }

    public static void enableLogTimeStamps() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            nativeEnableLogTimeStamps();
        }
    }

    public static synchronized void enableLogToDebugOutput(Severity severity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, severity) == null) {
            synchronized (Logging.class) {
                if (loggable == null) {
                    nativeEnableLogToDebugOutput(severity.ordinal());
                    loggingEnabled = true;
                } else {
                    throw new IllegalStateException("Logging to native debug output not supported while Loggable is injected. Delete the Loggable before calling this method.");
                }
            }
        }
    }

    @Deprecated
    public static void enableTracing(String str, EnumSet<TraceLevel> enumSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, enumSet) == null) {
        }
    }

    public static String getStackTraceString(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, th)) == null) {
            if (th == null) {
                return "";
            }
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void injectLoggable(Loggable loggable2, Severity severity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, loggable2, severity) == null) || loggable2 == null) {
            return;
        }
        loggable = loggable2;
        loggableSeverity = severity;
    }

    public static void log(Severity severity, String str, String str2) {
        Level level;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, severity, str, str2) == null) {
            if (str != null && str2 != null) {
                if (loggable != null) {
                    if (severity.ordinal() < loggableSeverity.ordinal()) {
                        return;
                    }
                    loggable.onLogMessage(str2, severity, str);
                    return;
                } else if (loggingEnabled) {
                    nativeLog(severity.ordinal(), str, str2);
                    return;
                } else {
                    int i2 = AnonymousClass1.$SwitchMap$org$webrtc$Logging$Severity[severity.ordinal()];
                    if (i2 == 1) {
                        level = Level.SEVERE;
                    } else if (i2 == 2) {
                        level = Level.WARNING;
                    } else if (i2 != 3) {
                        level = Level.FINE;
                    } else {
                        level = Level.INFO;
                    }
                    Logger logger = fallbackLogger;
                    logger.log(level, str + ": " + str2);
                    return;
                }
            }
            throw new IllegalArgumentException("Logging tag or message may not be null.");
        }
    }

    public static native void nativeEnableLogThreads();

    public static native void nativeEnableLogTimeStamps();

    public static native void nativeEnableLogToDebugOutput(int i2);

    public static native void nativeLog(int i2, String str, String str2);

    public static void v(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, str, str2) == null) {
            log(Severity.LS_VERBOSE, str, str2);
        }
    }

    public static void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, str, str2) == null) {
            log(Severity.LS_WARNING, str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2, th) == null) {
            log(Severity.LS_ERROR, str, str2);
            log(Severity.LS_ERROR, str, th.toString());
            log(Severity.LS_ERROR, str, getStackTraceString(th));
        }
    }

    public static void w(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65556, null, str, str2, th) == null) {
            log(Severity.LS_WARNING, str, str2);
            log(Severity.LS_WARNING, str, th.toString());
            log(Severity.LS_WARNING, str, getStackTraceString(th));
        }
    }
}
