package org.apache.commons.lang3.exception;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
/* loaded from: classes2.dex */
public class ExceptionUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String[] CAUSE_METHOD_NAMES;
    public static final String WRAPPED_MARKER = " [wrapped] ";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1781391010, "Lorg/apache/commons/lang3/exception/ExceptionUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1781391010, "Lorg/apache/commons/lang3/exception/ExceptionUtils;");
                return;
            }
        }
        CAUSE_METHOD_NAMES = new String[]{"getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable"};
    }

    public ExceptionUtils() {
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

    @Deprecated
    public static Throwable getCause(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, th)) == null) ? getCause(th, null) : (Throwable) invokeL.objValue;
    }

    public static Throwable getCauseUsingMethodName(Throwable th, String str) {
        InterceptResult invokeLL;
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, th, str)) == null) {
            try {
                method = th.getClass().getMethod(str, new Class[0]);
            } catch (NoSuchMethodException | SecurityException unused) {
                method = null;
            }
            if (method != null && Throwable.class.isAssignableFrom(method.getReturnType())) {
                try {
                    return (Throwable) method.invoke(th, new Object[0]);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
                }
            }
            return null;
        }
        return (Throwable) invokeLL.objValue;
    }

    @Deprecated
    public static String[] getDefaultCauseMethodNames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? (String[]) ArrayUtils.clone(CAUSE_METHOD_NAMES) : (String[]) invokeV.objValue;
    }

    public static String getMessage(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, th)) == null) {
            if (th == null) {
                return "";
            }
            String shortClassName = ClassUtils.getShortClassName(th, null);
            String message = th.getMessage();
            return shortClassName + ": " + StringUtils.defaultString(message);
        }
        return (String) invokeL.objValue;
    }

    public static Throwable getRootCause(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, th)) == null) {
            List<Throwable> throwableList = getThrowableList(th);
            if (throwableList.size() < 2) {
                return null;
            }
            return throwableList.get(throwableList.size() - 1);
        }
        return (Throwable) invokeL.objValue;
    }

    public static String getRootCauseMessage(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, th)) == null) {
            Throwable rootCause = getRootCause(th);
            if (rootCause != null) {
                th = rootCause;
            }
            return getMessage(th);
        }
        return (String) invokeL.objValue;
    }

    public static String[] getRootCauseStackTrace(Throwable th) {
        InterceptResult invokeL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65545, null, th)) != null) {
            return (String[]) invokeL.objValue;
        }
        if (th == null) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        Throwable[] throwables = getThrowables(th);
        int length = throwables.length;
        ArrayList arrayList = new ArrayList();
        int i2 = length - 1;
        List<String> stackFrameList = getStackFrameList(throwables[i2]);
        while (true) {
            length--;
            if (length >= 0) {
                if (length != 0) {
                    list = getStackFrameList(throwables[length - 1]);
                    removeCommonFrames(stackFrameList, list);
                } else {
                    list = stackFrameList;
                }
                if (length == i2) {
                    arrayList.add(throwables[length].toString());
                } else {
                    arrayList.add(WRAPPED_MARKER + throwables[length].toString());
                }
                for (int i3 = 0; i3 < stackFrameList.size(); i3++) {
                    arrayList.add(stackFrameList.get(i3));
                }
                stackFrameList = list;
            } else {
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
        }
    }

    public static List<String> getStackFrameList(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, th)) == null) {
            StringTokenizer stringTokenizer = new StringTokenizer(getStackTrace(th), SystemUtils.LINE_SEPARATOR);
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf("at");
                if (indexOf != -1 && nextToken.substring(0, indexOf).trim().isEmpty()) {
                    z = true;
                    arrayList.add(nextToken);
                } else if (z) {
                    break;
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String[] getStackFrames(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, th)) == null) {
            if (th == null) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            }
            return getStackFrames(getStackTrace(th));
        }
        return (String[]) invokeL.objValue;
    }

    public static String getStackTrace(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, th)) == null) {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter((Writer) stringWriter, true));
            return stringWriter.getBuffer().toString();
        }
        return (String) invokeL.objValue;
    }

    public static int getThrowableCount(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, th)) == null) ? getThrowableList(th).size() : invokeL.intValue;
    }

    public static List<Throwable> getThrowableList(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, th)) == null) {
            ArrayList arrayList = new ArrayList();
            while (th != null && !arrayList.contains(th)) {
                arrayList.add(th);
                th = getCause(th);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static Throwable[] getThrowables(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, th)) == null) {
            List<Throwable> throwableList = getThrowableList(th);
            return (Throwable[]) throwableList.toArray(new Throwable[throwableList.size()]);
        }
        return (Throwable[]) invokeL.objValue;
    }

    public static boolean hasCause(Throwable th, Class<? extends Throwable> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, th, cls)) == null) {
            if (th instanceof UndeclaredThrowableException) {
                th = th.getCause();
            }
            return cls.isInstance(th);
        }
        return invokeLL.booleanValue;
    }

    public static int indexOf(Throwable th, Class<?> cls, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{th, cls, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (th != null && cls != null) {
                if (i2 < 0) {
                    i2 = 0;
                }
                Throwable[] throwables = getThrowables(th);
                if (i2 >= throwables.length) {
                    return -1;
                }
                if (z) {
                    while (i2 < throwables.length) {
                        if (cls.isAssignableFrom(throwables[i2].getClass())) {
                            return i2;
                        }
                        i2++;
                    }
                } else {
                    while (i2 < throwables.length) {
                        if (cls.equals(throwables[i2].getClass())) {
                            return i2;
                        }
                        i2++;
                    }
                }
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static int indexOfThrowable(Throwable th, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, th, cls)) == null) ? indexOf(th, cls, 0, false) : invokeLL.intValue;
    }

    public static int indexOfType(Throwable th, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, th, cls)) == null) ? indexOf(th, cls, 0, true) : invokeLL.intValue;
    }

    public static void printRootCauseStackTrace(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, th) == null) {
            printRootCauseStackTrace(th, System.err);
        }
    }

    public static void removeCommonFrames(List<String> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65562, null, list, list2) == null) {
            if (list != null && list2 != null) {
                int size = list.size() - 1;
                for (int size2 = list2.size() - 1; size >= 0 && size2 >= 0; size2--) {
                    if (list.get(size).equals(list2.get(size2))) {
                        list.remove(size);
                    }
                    size--;
                }
                return;
            }
            throw new IllegalArgumentException("The List must not be null");
        }
    }

    public static <R> R rethrow(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, th)) == null) ? (R) typeErasure(th) : (R) invokeL.objValue;
    }

    public static <R, T extends Throwable> R typeErasure(Throwable th) throws Throwable {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, th)) == null) {
            throw th;
        }
        return (R) invokeL.objValue;
    }

    public static <R> R wrapAndThrow(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, th)) == null) {
            if (!(th instanceof RuntimeException)) {
                if (th instanceof Error) {
                    throw ((Error) th);
                }
                throw new UndeclaredThrowableException(th);
            }
            throw ((RuntimeException) th);
        }
        return (R) invokeL.objValue;
    }

    @Deprecated
    public static Throwable getCause(Throwable th, String[] strArr) {
        InterceptResult invokeLL;
        Throwable causeUsingMethodName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, th, strArr)) == null) {
            if (th == null) {
                return null;
            }
            if (strArr == null) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    return cause;
                }
                strArr = CAUSE_METHOD_NAMES;
            }
            for (String str : strArr) {
                if (str != null && (causeUsingMethodName = getCauseUsingMethodName(th, str)) != null) {
                    return causeUsingMethodName;
                }
            }
            return null;
        }
        return (Throwable) invokeLL.objValue;
    }

    public static int indexOfThrowable(Throwable th, Class<?> cls, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65556, null, th, cls, i2)) == null) ? indexOf(th, cls, i2, false) : invokeLLI.intValue;
    }

    public static int indexOfType(Throwable th, Class<?> cls, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65558, null, th, cls, i2)) == null) ? indexOf(th, cls, i2, true) : invokeLLI.intValue;
    }

    public static void printRootCauseStackTrace(Throwable th, PrintStream printStream) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65560, null, th, printStream) == null) || th == null) {
            return;
        }
        if (printStream != null) {
            for (String str : getRootCauseStackTrace(th)) {
                printStream.println(str);
            }
            printStream.flush();
            return;
        }
        throw new IllegalArgumentException("The PrintStream must not be null");
    }

    public static String[] getStackFrames(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, SystemUtils.LINE_SEPARATOR);
            ArrayList arrayList = new ArrayList();
            while (stringTokenizer.hasMoreTokens()) {
                arrayList.add(stringTokenizer.nextToken());
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return (String[]) invokeL.objValue;
    }

    public static void printRootCauseStackTrace(Throwable th, PrintWriter printWriter) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65561, null, th, printWriter) == null) || th == null) {
            return;
        }
        if (printWriter != null) {
            for (String str : getRootCauseStackTrace(th)) {
                printWriter.println(str);
            }
            printWriter.flush();
            return;
        }
        throw new IllegalArgumentException("The PrintWriter must not be null");
    }
}
