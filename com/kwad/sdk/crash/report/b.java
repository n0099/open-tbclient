package com.kwad.sdk.crash.report;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.crash.utils.f;
import com.kwad.sdk.crash.utils.h;
import io.reactivex.annotations.SchedulerSupport;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes2.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f65478a;

    /* renamed from: b  reason: collision with root package name */
    public String f65479b;

    public b() {
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
        this.f65479b = "";
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) ? (str == null || !str.contains("-")) ? str : str.substring(0, str.lastIndexOf(45)) : (String) invokeL.objValue;
    }

    public abstract ExceptionMessage a(@NonNull File file, File file2, File file3, String str);

    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f65478a = cVar;
        }
    }

    @SuppressLint({"CheckResult"})
    public void a(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, file) == null) {
            com.kwad.sdk.core.d.a.a("ExceptionCollector", "reportException dir =" + file);
            for (File file2 : file.listFiles(new FileFilter(this) { // from class: com.kwad.sdk.crash.report.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f65480a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f65480a = this;
                }

                @Override // java.io.FileFilter
                public boolean accept(File file3) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file3)) == null) ? file3.getName().endsWith(".dump") : invokeL.booleanValue;
                }
            })) {
                b(file2);
            }
        }
    }

    public void a(File file, ExceptionMessage exceptionMessage) {
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048579, this, file, exceptionMessage) != null) {
            return;
        }
        try {
            MemoryInfo memoryInfo = new MemoryInfo(exceptionMessage.mMemoryInfo);
            ArrayList arrayList = new ArrayList();
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                ThreadInfo threadInfo = new ThreadInfo();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        memoryInfo.mJavaThreads = arrayList;
                        exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
                        com.kwad.sdk.crash.utils.b.a((Reader) bufferedReader);
                        return;
                    } else if (readLine.isEmpty()) {
                        arrayList.add(threadInfo);
                        threadInfo = new ThreadInfo();
                    } else {
                        if (!readLine.startsWith("at ") && !readLine.startsWith("(no ")) {
                            threadInfo.mName = readLine;
                        }
                        if (threadInfo.mTrace != null) {
                            readLine = threadInfo.mTrace + readLine;
                        }
                        threadInfo.mTrace = readLine;
                        threadInfo.mTrace += "#";
                    }
                }
            } catch (IOException e3) {
                e = e3;
                bufferedReader2 = bufferedReader;
                com.kwad.sdk.core.d.a.b(e);
                com.kwad.sdk.crash.utils.b.a((Reader) bufferedReader2);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                com.kwad.sdk.crash.utils.b.a((Reader) bufferedReader2);
                throw th;
            }
        } catch (Exception e4) {
            com.kwad.sdk.core.d.a.b(e4);
        }
    }

    public void b(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, file) == null) {
            String a2 = f.a(file.getPath());
            File file2 = new File(a2 + ".msg");
            File file3 = new File(a2 + ".log");
            File file4 = new File(a2 + ".blog");
            File file5 = new File(a2 + ".jtrace");
            ArrayList<File> arrayList = new ArrayList();
            try {
                ExceptionMessage a3 = a(file, file2, file3, a2);
                this.f65478a.a(a3);
                f.a(file4);
                ArrayList arrayList2 = new ArrayList();
                Collections.addAll(arrayList2, file3, file4);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    if (!((File) it.next()).exists()) {
                        it.remove();
                    }
                }
                File file6 = new File(file.getParentFile().getParent(), SchedulerSupport.CUSTOM);
                if (file6.exists()) {
                    for (File file7 : file6.listFiles()) {
                        if (!file7.isDirectory() && (file7.getName().startsWith(a3.mLogUUID) || file7.getName().startsWith(a(a3.mLogUUID)))) {
                            arrayList.add(file7);
                        }
                    }
                    arrayList2.addAll(arrayList);
                }
                h.b(file.getPath());
                h.b(file3.getPath());
                h.b(file4.getPath());
                for (File file8 : arrayList) {
                    h.b(file8.getPath());
                }
                h.b(file5.getPath());
                f.b(com.kwad.sdk.crash.c.b.f65447b);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
        }
    }

    public void b(File file, ExceptionMessage exceptionMessage) {
        String str;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048581, this, file, exceptionMessage) != null) {
            return;
        }
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                boolean z = false;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            com.kwad.sdk.crash.utils.b.a((Reader) bufferedReader2);
                            return;
                        } else if (z || !readLine.contains("JNI DETECTED ERROR IN APPLICATION")) {
                            if (!readLine.contains("Waiting for a blocking GC ") && !readLine.contains("WaitForGcToComplete")) {
                                if (readLine.contains("dvm_lock_sample")) {
                                    if (TextUtils.isEmpty(exceptionMessage.mLockInfo)) {
                                        sb2 = new StringBuilder();
                                        sb2.append(readLine);
                                        sb2.append(StringUtils.LF);
                                    } else {
                                        sb2 = new StringBuilder();
                                        sb2.append(exceptionMessage.mLockInfo);
                                        sb2.append(readLine);
                                        sb2.append(StringUtils.LF);
                                    }
                                    exceptionMessage.mLockInfo = sb2.toString();
                                } else if (readLine.contains("Long monitor")) {
                                    if (TextUtils.isEmpty(exceptionMessage.mMonitorInfo)) {
                                        sb3 = new StringBuilder();
                                        sb3.append(readLine);
                                        sb3.append(StringUtils.LF);
                                    } else {
                                        sb3 = new StringBuilder();
                                        sb3.append(exceptionMessage.mMonitorInfo);
                                        sb3.append(readLine);
                                        sb3.append(StringUtils.LF);
                                    }
                                    exceptionMessage.mMonitorInfo = sb3.toString();
                                } else if (readLine.contains("Slow Looper")) {
                                    if (TextUtils.isEmpty(exceptionMessage.mSlowLooper)) {
                                        sb4 = new StringBuilder();
                                        sb4.append(readLine);
                                        sb4.append(StringUtils.LF);
                                    } else {
                                        sb4 = new StringBuilder();
                                        sb4.append(exceptionMessage.mSlowLooper);
                                        sb4.append(readLine);
                                        sb4.append(StringUtils.LF);
                                    }
                                    exceptionMessage.mSlowLooper = sb4.toString();
                                } else if (readLine.contains("Slow Operation")) {
                                    if (TextUtils.isEmpty(exceptionMessage.mSlowOperation)) {
                                        sb5 = new StringBuilder();
                                        sb5.append(readLine);
                                        sb5.append(StringUtils.LF);
                                    } else {
                                        sb5 = new StringBuilder();
                                        sb5.append(exceptionMessage.mSlowOperation);
                                        sb5.append(readLine);
                                        sb5.append(StringUtils.LF);
                                    }
                                    exceptionMessage.mSlowOperation = sb5.toString();
                                }
                            }
                            if (TextUtils.isEmpty(exceptionMessage.mGCInfo)) {
                                sb = new StringBuilder();
                                sb.append(readLine);
                                sb.append(StringUtils.LF);
                            } else {
                                sb = new StringBuilder();
                                sb.append(exceptionMessage.mGCInfo);
                                sb.append(readLine);
                                sb.append(StringUtils.LF);
                            }
                            exceptionMessage.mGCInfo = sb.toString();
                        } else {
                            exceptionMessage.mJNIError = readLine.substring(readLine.indexOf("JNI DETECTED ERROR IN APPLICATION"));
                            z = true;
                        }
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        bufferedReader = bufferedReader2;
                        str = this.f65479b + e + StringUtils.LF;
                        this.f65479b = str;
                        com.kwad.sdk.crash.utils.b.a((Reader) bufferedReader);
                        return;
                    } catch (IOException e3) {
                        e = e3;
                        bufferedReader = bufferedReader2;
                        str = this.f65479b + e + StringUtils.LF;
                        this.f65479b = str;
                        com.kwad.sdk.crash.utils.b.a((Reader) bufferedReader);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        com.kwad.sdk.crash.utils.b.a((Reader) bufferedReader);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e4) {
            e = e4;
        } catch (IOException e5) {
            e = e5;
        }
    }
}
