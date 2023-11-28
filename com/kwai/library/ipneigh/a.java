package com.kwai.library.ipneigh;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes10.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public interface b<T> {
        T b(BufferedReader bufferedReader);
    }

    /* renamed from: com.kwai.library.ipneigh.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0732a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final InputStream aSQ;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0732a(InputStream inputStream) {
            super("NoopStreamConsumer");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.aSQ = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            BufferedReader bufferedReader;
            Throwable th;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BufferedReader bufferedReader2 = null;
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(this.aSQ));
                    do {
                        try {
                        } catch (IOException unused) {
                            bufferedReader2 = bufferedReader;
                            a.closeQuietly(bufferedReader2);
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            a.closeQuietly(bufferedReader);
                            throw th;
                        }
                    } while (bufferedReader.readLine() != null);
                    a.closeQuietly(bufferedReader);
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    bufferedReader = null;
                    th = th3;
                }
            }
        }
    }

    public static <T> T a(String str, b<T> bVar) {
        InterceptResult invokeLL;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, bVar)) == null) {
            Process process = null;
            try {
                Process exec = Runtime.getRuntime().exec(str);
                try {
                    C0732a c0732a = new C0732a(exec.getErrorStream());
                    c0732a.start();
                    bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                    try {
                        T b2 = bVar.b(bufferedReader);
                        c0732a.join();
                        exec.waitFor();
                        if (exec != null) {
                            exec.destroy();
                        }
                        closeQuietly(bufferedReader);
                        return b2;
                    } catch (Throwable th) {
                        th = th;
                        process = exec;
                        if (process != null) {
                            process.destroy();
                        }
                        closeQuietly(bufferedReader);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } else {
            return (T) invokeLL.objValue;
        }
    }

    public static void closeQuietly(Closeable closeable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, closeable) == null) && closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String gH(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                return (String) a(str, new b<String>() { // from class: com.kwai.library.ipneigh.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    public static String a(BufferedReader bufferedReader) {
                        InterceptResult invokeL2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(65537, null, bufferedReader)) == null) {
                            String readLine = bufferedReader.readLine();
                            do {
                            } while (bufferedReader.readLine() != null);
                            return readLine;
                        }
                        return (String) invokeL2.objValue;
                    }

                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // com.kwai.library.ipneigh.a.b
                    public final /* synthetic */ String b(BufferedReader bufferedReader) {
                        return a(bufferedReader);
                    }
                });
            } catch (IOException | InterruptedException unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
