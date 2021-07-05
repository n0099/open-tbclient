package com.kwai.video.hodor.util;

import android.os.Build;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public final class Timber {
    public static /* synthetic */ Interceptable $ic;
    public static final List<Tree> FOREST;
    public static final Tree[] TREE_ARRAY_EMPTY;
    public static final Tree TREE_OF_SOULS;
    public static volatile Tree[] forestAsArray;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class DebugTree extends Tree {
        public static /* synthetic */ Interceptable $ic = null;
        public static final Pattern ANONYMOUS_CLASS;
        public static final int CALL_STACK_INDEX = 5;
        public static final int MAX_LOG_LENGTH = 4000;
        public static final int MAX_TAG_LENGTH = 23;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-854186258, "Lcom/kwai/video/hodor/util/Timber$DebugTree;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-854186258, "Lcom/kwai/video/hodor/util/Timber$DebugTree;");
                    return;
                }
            }
            ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$");
        }

        public DebugTree() {
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

        public String createStackElementTag(StackTraceElement stackTraceElement) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, stackTraceElement)) == null) {
                String className = stackTraceElement.getClassName();
                Matcher matcher = ANONYMOUS_CLASS.matcher(className);
                if (matcher.find()) {
                    className = matcher.replaceAll("");
                }
                String substring = className.substring(className.lastIndexOf(46) + 1);
                return (substring.length() <= 23 || Build.VERSION.SDK_INT >= 24) ? substring : substring.substring(0, 23);
            }
            return (String) invokeL.objValue;
        }

        @Override // com.kwai.video.hodor.util.Timber.Tree
        public final String getTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                String tag = super.getTag();
                if (tag != null) {
                    return tag;
                }
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                if (stackTrace.length > 5) {
                    return createStackElementTag(stackTrace[5]);
                }
                throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
            }
            return (String) invokeV.objValue;
        }

        @Override // com.kwai.video.hodor.util.Timber.Tree
        public void log(int i2, String str, String str2, Throwable th) {
            int min;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), str, str2, th}) == null) {
                if (str2.length() < 4000) {
                    if (i2 == 7) {
                        Log.wtf(str, str2);
                        return;
                    } else {
                        Log.println(i2, str, str2);
                        return;
                    }
                }
                int i3 = 0;
                int length = str2.length();
                while (i3 < length) {
                    int indexOf = str2.indexOf(10, i3);
                    if (indexOf == -1) {
                        indexOf = length;
                    }
                    while (true) {
                        min = Math.min(indexOf, i3 + 4000);
                        String substring = str2.substring(i3, min);
                        if (i2 == 7) {
                            Log.wtf(str, substring);
                        } else {
                            Log.println(i2, str, substring);
                        }
                        if (min >= indexOf) {
                            break;
                        }
                        i3 = min;
                    }
                    i3 = min + 1;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class Tree {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ThreadLocal<String> explicitTag;

        public Tree() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.explicitTag = new ThreadLocal<>();
        }

        private String getStackTraceString(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, th)) == null) {
                StringWriter stringWriter = new StringWriter(256);
                PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
                th.printStackTrace(printWriter);
                printWriter.flush();
                return stringWriter.toString();
            }
            return (String) invokeL.objValue;
        }

        private void prepareLog(int i2, Throwable th, String str, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i2), th, str, objArr}) == null) {
                String tag = getTag();
                if (isLoggable(tag, i2)) {
                    if (str != null && str.length() == 0) {
                        str = null;
                    }
                    if (str != null) {
                        if (objArr != null && objArr.length > 0) {
                            str = formatMessage(str, objArr);
                        }
                        if (th != null) {
                            str = str + "\n" + getStackTraceString(th);
                        }
                    } else if (th == null) {
                        return;
                    } else {
                        str = getStackTraceString(th);
                    }
                    log(i2, tag, str, th);
                }
            }
        }

        public void d(String str, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, objArr) == null) {
                prepareLog(3, null, str, objArr);
            }
        }

        public void d(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                prepareLog(3, th, null, new Object[0]);
            }
        }

        public void d(Throwable th, String str, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, th, str, objArr) == null) {
                prepareLog(3, th, str, objArr);
            }
        }

        public void e(String str, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, objArr) == null) {
                prepareLog(6, null, str, objArr);
            }
        }

        public void e(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
                prepareLog(6, th, null, new Object[0]);
            }
        }

        public void e(Throwable th, String str, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, th, str, objArr) == null) {
                prepareLog(6, th, str, objArr);
            }
        }

        public String formatMessage(String str, Object[] objArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, objArr)) == null) ? String.format(str, objArr) : (String) invokeLL.objValue;
        }

        public String getTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                String str = this.explicitTag.get();
                if (str != null) {
                    this.explicitTag.remove();
                }
                return str;
            }
            return (String) invokeV.objValue;
        }

        public void i(String str, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, objArr) == null) {
                prepareLog(4, null, str, objArr);
            }
        }

        public void i(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, th) == null) {
                prepareLog(4, th, null, new Object[0]);
            }
        }

        public void i(Throwable th, String str, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048586, this, th, str, objArr) == null) {
                prepareLog(4, th, str, objArr);
            }
        }

        @Deprecated
        public boolean isLoggable(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
                return true;
            }
            return invokeI.booleanValue;
        }

        public boolean isLoggable(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, str, i2)) == null) ? isLoggable(i2) : invokeLI.booleanValue;
        }

        public abstract void log(int i2, String str, String str2, Throwable th);

        public void log(int i2, String str, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048590, this, i2, str, objArr) == null) {
                prepareLog(i2, null, str, objArr);
            }
        }

        public void log(int i2, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048591, this, i2, th) == null) {
                prepareLog(i2, th, null, new Object[0]);
            }
        }

        public void log(int i2, Throwable th, String str, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), th, str, objArr}) == null) {
                prepareLog(i2, th, str, objArr);
            }
        }

        public void v(String str, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048593, this, str, objArr) == null) {
                prepareLog(2, null, str, objArr);
            }
        }

        public void v(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, th) == null) {
                prepareLog(2, th, null, new Object[0]);
            }
        }

        public void v(Throwable th, String str, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048595, this, th, str, objArr) == null) {
                prepareLog(2, th, str, objArr);
            }
        }

        public void w(String str, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048596, this, str, objArr) == null) {
                prepareLog(5, null, str, objArr);
            }
        }

        public void w(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, th) == null) {
                prepareLog(5, th, null, new Object[0]);
            }
        }

        public void w(Throwable th, String str, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048598, this, th, str, objArr) == null) {
                prepareLog(5, th, str, objArr);
            }
        }

        public void wtf(String str, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048599, this, str, objArr) == null) {
                prepareLog(7, null, str, objArr);
            }
        }

        public void wtf(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048600, this, th) == null) {
                prepareLog(7, th, null, new Object[0]);
            }
        }

        public void wtf(Throwable th, String str, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048601, this, th, str, objArr) == null) {
                prepareLog(7, th, str, objArr);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1306626587, "Lcom/kwai/video/hodor/util/Timber;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1306626587, "Lcom/kwai/video/hodor/util/Timber;");
                return;
            }
        }
        TREE_ARRAY_EMPTY = new Tree[0];
        FOREST = new ArrayList();
        forestAsArray = TREE_ARRAY_EMPTY;
        TREE_OF_SOULS = new Tree() { // from class: com.kwai.video.hodor.util.Timber.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.kwai.video.hodor.util.Timber.Tree
            public void d(String str, Object... objArr) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, objArr) == null) {
                    for (Tree tree : Timber.forestAsArray) {
                        tree.d(str, objArr);
                    }
                }
            }

            @Override // com.kwai.video.hodor.util.Timber.Tree
            public void d(Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    for (Tree tree : Timber.forestAsArray) {
                        tree.d(th);
                    }
                }
            }

            @Override // com.kwai.video.hodor.util.Timber.Tree
            public void d(Throwable th, String str, Object... objArr) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, th, str, objArr) == null) {
                    for (Tree tree : Timber.forestAsArray) {
                        tree.d(th, str, objArr);
                    }
                }
            }

            @Override // com.kwai.video.hodor.util.Timber.Tree
            public void e(String str, Object... objArr) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048579, this, str, objArr) == null) {
                    for (Tree tree : Timber.forestAsArray) {
                        tree.e(str, objArr);
                    }
                }
            }

            @Override // com.kwai.video.hodor.util.Timber.Tree
            public void e(Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048580, this, th) == null) {
                    for (Tree tree : Timber.forestAsArray) {
                        tree.e(th);
                    }
                }
            }

            @Override // com.kwai.video.hodor.util.Timber.Tree
            public void e(Throwable th, String str, Object... objArr) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048581, this, th, str, objArr) == null) {
                    for (Tree tree : Timber.forestAsArray) {
                        tree.e(th, str, objArr);
                    }
                }
            }

            @Override // com.kwai.video.hodor.util.Timber.Tree
            public void i(String str, Object... objArr) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048582, this, str, objArr) == null) {
                    for (Tree tree : Timber.forestAsArray) {
                        tree.i(str, objArr);
                    }
                }
            }

            @Override // com.kwai.video.hodor.util.Timber.Tree
            public void i(Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048583, this, th) == null) {
                    for (Tree tree : Timber.forestAsArray) {
                        tree.i(th);
                    }
                }
            }

            @Override // com.kwai.video.hodor.util.Timber.Tree
            public void i(Throwable th, String str, Object... objArr) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, th, str, objArr) == null) {
                    for (Tree tree : Timber.forestAsArray) {
                        tree.i(th, str, objArr);
                    }
                }
            }

            @Override // com.kwai.video.hodor.util.Timber.Tree
            public void log(int i2, String str, String str2, Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), str, str2, th}) == null) {
                    throw new AssertionError("Missing override for log method.");
                }
            }

            @Override // com.kwai.video.hodor.util.Timber.Tree
            public void log(int i2, String str, Object... objArr) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeILL(1048586, this, i2, str, objArr) == null) {
                    for (Tree tree : Timber.forestAsArray) {
                        tree.log(i2, str, objArr);
                    }
                }
            }

            @Override // com.kwai.video.hodor.util.Timber.Tree
            public void log(int i2, Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048587, this, i2, th) == null) {
                    for (Tree tree : Timber.forestAsArray) {
                        tree.log(i2, th);
                    }
                }
            }

            @Override // com.kwai.video.hodor.util.Timber.Tree
            public void log(int i2, Throwable th, String str, Object... objArr) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), th, str, objArr}) == null) {
                    for (Tree tree : Timber.forestAsArray) {
                        tree.log(i2, th, str, objArr);
                    }
                }
            }

            @Override // com.kwai.video.hodor.util.Timber.Tree
            public void v(String str, Object... objArr) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048589, this, str, objArr) == null) {
                    for (Tree tree : Timber.forestAsArray) {
                        tree.v(str, objArr);
                    }
                }
            }

            @Override // com.kwai.video.hodor.util.Timber.Tree
            public void v(Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048590, this, th) == null) {
                    for (Tree tree : Timber.forestAsArray) {
                        tree.v(th);
                    }
                }
            }

            @Override // com.kwai.video.hodor.util.Timber.Tree
            public void v(Throwable th, String str, Object... objArr) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048591, this, th, str, objArr) == null) {
                    for (Tree tree : Timber.forestAsArray) {
                        tree.v(th, str, objArr);
                    }
                }
            }

            @Override // com.kwai.video.hodor.util.Timber.Tree
            public void w(String str, Object... objArr) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048592, this, str, objArr) == null) {
                    for (Tree tree : Timber.forestAsArray) {
                        tree.w(str, objArr);
                    }
                }
            }

            @Override // com.kwai.video.hodor.util.Timber.Tree
            public void w(Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048593, this, th) == null) {
                    for (Tree tree : Timber.forestAsArray) {
                        tree.w(th);
                    }
                }
            }

            @Override // com.kwai.video.hodor.util.Timber.Tree
            public void w(Throwable th, String str, Object... objArr) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048594, this, th, str, objArr) == null) {
                    for (Tree tree : Timber.forestAsArray) {
                        tree.w(th, str, objArr);
                    }
                }
            }

            @Override // com.kwai.video.hodor.util.Timber.Tree
            public void wtf(String str, Object... objArr) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048595, this, str, objArr) == null) {
                    for (Tree tree : Timber.forestAsArray) {
                        tree.wtf(str, objArr);
                    }
                }
            }

            @Override // com.kwai.video.hodor.util.Timber.Tree
            public void wtf(Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048596, this, th) == null) {
                    for (Tree tree : Timber.forestAsArray) {
                        tree.wtf(th);
                    }
                }
            }

            @Override // com.kwai.video.hodor.util.Timber.Tree
            public void wtf(Throwable th, String str, Object... objArr) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048597, this, th, str, objArr) == null) {
                    for (Tree tree : Timber.forestAsArray) {
                        tree.wtf(th, str, objArr);
                    }
                }
            }
        };
    }

    public Timber() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        throw new AssertionError("No instances.");
    }

    public static Tree asTree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? TREE_OF_SOULS : (Tree) invokeV.objValue;
    }

    public static void d(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, objArr) == null) {
            TREE_OF_SOULS.d(str, objArr);
        }
    }

    public static void d(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, th) == null) {
            TREE_OF_SOULS.d(th);
        }
    }

    public static void d(Throwable th, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, th, str, objArr) == null) {
            TREE_OF_SOULS.d(th, str, objArr);
        }
    }

    public static void e(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, objArr) == null) {
            TREE_OF_SOULS.e(str, objArr);
        }
    }

    public static void e(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, th) == null) {
            TREE_OF_SOULS.e(th);
        }
    }

    public static void e(Throwable th, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, th, str, objArr) == null) {
            TREE_OF_SOULS.e(th, str, objArr);
        }
    }

    public static List<Tree> forest() {
        InterceptResult invokeV;
        List<Tree> unmodifiableList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            synchronized (FOREST) {
                unmodifiableList = Collections.unmodifiableList(new ArrayList(FOREST));
            }
            return unmodifiableList;
        }
        return (List) invokeV.objValue;
    }

    public static void i(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, objArr) == null) {
            TREE_OF_SOULS.i(str, objArr);
        }
    }

    public static void i(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, th) == null) {
            TREE_OF_SOULS.i(th);
        }
    }

    public static void i(Throwable th, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, th, str, objArr) == null) {
            TREE_OF_SOULS.i(th, str, objArr);
        }
    }

    public static void log(int i2, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65549, null, i2, str, objArr) == null) {
            TREE_OF_SOULS.log(i2, str, objArr);
        }
    }

    public static void log(int i2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65550, null, i2, th) == null) {
            TREE_OF_SOULS.log(i2, th);
        }
    }

    public static void log(int i2, Throwable th, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{Integer.valueOf(i2), th, str, objArr}) == null) {
            TREE_OF_SOULS.log(i2, th, str, objArr);
        }
    }

    public static void plant(Tree tree) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, tree) == null) {
            if (tree == null) {
                throw new NullPointerException("tree == null");
            }
            if (tree == TREE_OF_SOULS) {
                throw new IllegalArgumentException("Cannot plant Timber into itself.");
            }
            synchronized (FOREST) {
                FOREST.add(tree);
                forestAsArray = (Tree[]) FOREST.toArray(new Tree[FOREST.size()]);
            }
        }
    }

    public static void plant(Tree... treeArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, treeArr) == null) {
            if (treeArr == null) {
                throw new NullPointerException("trees == null");
            }
            for (Tree tree : treeArr) {
                if (tree == null) {
                    throw new NullPointerException("trees contains null");
                }
                if (tree == TREE_OF_SOULS) {
                    throw new IllegalArgumentException("Cannot plant Timber into itself.");
                }
            }
            synchronized (FOREST) {
                Collections.addAll(FOREST, treeArr);
                forestAsArray = (Tree[]) FOREST.toArray(new Tree[FOREST.size()]);
            }
        }
    }

    public static Tree tag(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            for (Tree tree : forestAsArray) {
                tree.explicitTag.set(str);
            }
            return TREE_OF_SOULS;
        }
        return (Tree) invokeL.objValue;
    }

    public static int treeCount() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            synchronized (FOREST) {
                size = FOREST.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public static void uproot(Tree tree) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, tree) == null) {
            synchronized (FOREST) {
                if (!FOREST.remove(tree)) {
                    throw new IllegalArgumentException("Cannot uproot tree which is not planted: " + tree);
                }
                forestAsArray = (Tree[]) FOREST.toArray(new Tree[FOREST.size()]);
            }
        }
    }

    public static void uprootAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, null) == null) {
            synchronized (FOREST) {
                FOREST.clear();
                forestAsArray = TREE_ARRAY_EMPTY;
            }
        }
    }

    public static void v(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, str, objArr) == null) {
            TREE_OF_SOULS.v(str, objArr);
        }
    }

    public static void v(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, th) == null) {
            TREE_OF_SOULS.v(th);
        }
    }

    public static void v(Throwable th, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65560, null, th, str, objArr) == null) {
            TREE_OF_SOULS.v(th, str, objArr);
        }
    }

    public static void w(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, null, str, objArr) == null) {
            TREE_OF_SOULS.w(str, objArr);
        }
    }

    public static void w(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, th) == null) {
            TREE_OF_SOULS.w(th);
        }
    }

    public static void w(Throwable th, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65563, null, th, str, objArr) == null) {
            TREE_OF_SOULS.w(th, str, objArr);
        }
    }

    public static void wtf(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65564, null, str, objArr) == null) {
            TREE_OF_SOULS.wtf(str, objArr);
        }
    }

    public static void wtf(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, null, th) == null) {
            TREE_OF_SOULS.wtf(th);
        }
    }

    public static void wtf(Throwable th, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65566, null, th, str, objArr) == null) {
            TREE_OF_SOULS.wtf(th, str, objArr);
        }
    }
}
