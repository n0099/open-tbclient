package com.yy.hiidostatis.defs.handler;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.interf.IOnStatisListener;
import com.yy.hiidostatis.defs.interf.IStatisAPI;
import com.yy.hiidostatis.inner.util.FileUtil;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes4.dex */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    public static /* synthetic */ Interceptable $ic;
    public static Context mContext;
    public static Thread.UncaughtExceptionHandler mDefaultHandler;
    public static OnHandlerListener mOnHandlerListener;
    public static IOnStatisListener mOnStatisListener;
    public static IStatisAPI mStatisAPI;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface OnHandlerListener {
        void handler(int i2, String str, String str2);
    }

    public CrashHandler(Context context, IStatisAPI iStatisAPI, IOnStatisListener iOnStatisListener, OnHandlerListener onHandlerListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, iStatisAPI, iOnStatisListener, onHandlerListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        mContext = context;
        mStatisAPI = iStatisAPI;
        mOnStatisListener = iOnStatisListener;
        mOnHandlerListener = onHandlerListener;
    }

    public static void crashCallBack(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, null, i2, str) == null) {
            Object[] objArr = new Object[1];
            objArr[0] = i2 == 1 ? "java" : "native";
            L.debug("CrashHandler", "%s crash occur.", objArr);
            String replace = str.replace(".dmp", ".log");
            L.brief("crashCallBack,dmpFilePath=%s,logFilePath=%s", str, replace);
            FileUtil.writeFile(replace, generateCrashLog());
            OnHandlerListener onHandlerListener = mOnHandlerListener;
            if (onHandlerListener != null) {
                onHandlerListener.handler(i2, str, replace);
            }
        }
    }

    private void dealJavaException(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, th) == null) {
            String str = getDmpPath() + File.separator + "J-" + UUID.randomUUID().toString() + ".dmp";
            FileUtil.writeFile(str, getStackTrace(th));
            crashCallBack(1, str);
        }
    }

    public static String generateCrashLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65541, null)) != null) {
            return (String) invokeV.objValue;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("LOGCAT STACK:\n");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"logcat", "-v", "threadtime", "-t", "500", "-d", "*:V"}).getInputStream()), 1024);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (!readLine.contains(L.getTag())) {
                        stringBuffer.append(readLine);
                        stringBuffer.append(StringUtils.LF);
                    }
                } else {
                    bufferedReader.close();
                    return stringBuffer.toString();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String getCurrentStack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            StringBuilder sb = new StringBuilder();
            for (StackTraceElement stackTraceElement : new Throwable("").getStackTrace()) {
                sb.append(stackTraceElement.toString());
                sb.append(StringUtils.LF);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String getStackTrace(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, th)) == null) {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }
        return (String) invokeL.objValue;
    }

    private void handleException(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, th) == null) {
            ThreadPool.getPool().execute(new Thread(this, th) { // from class: com.yy.hiidostatis.defs.handler.CrashHandler.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CrashHandler this$0;
                public final /* synthetic */ Throwable val$t;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, th};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$t = th;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        CrashHandler.mStatisAPI.reportCrashInner(CrashHandler.mOnStatisListener.getCurrentUid(), this.val$t);
                    }
                }
            });
        }
    }

    public static void testJavaCrash() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            System.out.println(10 / 0);
        }
    }

    public static native void testNativeCrash();

    public static native void testNativeCrashThread();

    public String getDmpPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = mContext.getFilesDir().getAbsolutePath() + File.separator + "hdsdkDump";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            mDefaultHandler = defaultUncaughtExceptionHandler;
            L.debug(this, "old DefaultUncaughtExceptionHandler is %s,new DefaultUncaughtExceptionHandler is %s", defaultUncaughtExceptionHandler != null ? defaultUncaughtExceptionHandler.getClass().getSimpleName() : StringUtil.NULL_STRING, CrashHandler.class.getSimpleName());
            Thread.setDefaultUncaughtExceptionHandler(this);
            L.debug(this, "init java crash handler", new Object[0]);
            if (loadLibrary()) {
                try {
                    initNativeHandler(getDmpPath());
                    L.debug(this, "init native crash handler", new Object[0]);
                } catch (Throwable th) {
                    L.debug(this, "initNativeHandler error:%e", th);
                }
            }
        }
    }

    public native int initNativeHandler(String str);

    public boolean loadLibrary() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                System.loadLibrary("hiidostatisjni");
                return true;
            } catch (Throwable th) {
                L.debug(this, "loadLibrary failure. %s", th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, thread, th) == null) {
            try {
                handleException(th);
                Thread.sleep(800L);
            } catch (Throwable th2) {
                L.debug(this, "deal crash uncaughtException happen another exception=%s", th2);
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = mDefaultHandler;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        }
    }
}
