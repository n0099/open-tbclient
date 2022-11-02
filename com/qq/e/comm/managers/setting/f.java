package com.qq.e.comm.managers.setting;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.comm.util.SystemUtil;
import java.io.File;
import java.io.FileWriter;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final T b;

        public b(String str, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = t;
        }

        public /* synthetic */ b(String str, Object obj, a aVar) {
            this(str, obj);
        }

        public T a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (T) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
        }
    }

    public static b<com.qq.e.comm.managers.setting.a> a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            Pair<String, String> a2 = a(context, "devCloudSetting");
            if (a2 == null) {
                return null;
            }
            return new b<>((String) a2.first, new com.qq.e.comm.managers.setting.a((String) a2.second), null);
        }
        return (b) invokeL.objValue;
    }

    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, str2)) == null) ? a(context, "devCloudSetting", str, str2) : invokeLLL.booleanValue;
    }

    public static b<d> b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            Pair<String, String> a2 = a(context, "placementCloudSetting");
            if (a2 == null) {
                return null;
            }
            return new b<>((String) a2.first, new d((String) a2.second), null);
        }
        return (b) invokeL.objValue;
    }

    public static boolean b(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, context, str, str2)) == null) ? a(context, "placementCloudSetting", str, str2) : invokeLLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0087 A[Catch: Exception -> 0x008a, TRY_LEAVE, TryCatch #4 {Exception -> 0x008a, blocks: (B:31:0x0082, B:33:0x0087), top: B:47:0x0082 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        FileWriter fileWriter;
        FileWriter fileWriter2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65542, null, context, str, str2, str3)) == null) {
            File dir = context.getDir(SystemUtil.buildNewPathByProcessName("e_qq_com_setting"), 0);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dir, str + ".cfg");
            File file2 = new File(dir, str + ".sig");
            FileWriter fileWriter3 = null;
            try {
                fileWriter2 = new FileWriter(file);
                try {
                    fileWriter2.write(str3);
                    fileWriter = new FileWriter(file2);
                } catch (Exception unused) {
                    fileWriter = null;
                } catch (Throwable th) {
                    fileWriter = null;
                    fileWriter3 = fileWriter2;
                    th = th;
                }
            } catch (Exception unused2) {
                fileWriter = null;
            } catch (Throwable th2) {
                th = th2;
                fileWriter = null;
            }
            try {
                fileWriter.write(str2);
                try {
                    fileWriter2.close();
                    fileWriter.close();
                } catch (Exception unused3) {
                }
                return true;
            } catch (Exception unused4) {
                fileWriter3 = fileWriter2;
                try {
                    file.delete();
                    file2.delete();
                    if (fileWriter3 != null) {
                        try {
                            fileWriter3.close();
                        } catch (Exception unused5) {
                            return false;
                        }
                    }
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    if (fileWriter3 != null) {
                        try {
                            fileWriter3.close();
                        } catch (Exception unused6) {
                            throw th;
                        }
                    }
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileWriter3 = fileWriter2;
                if (fileWriter3 != null) {
                }
                if (fileWriter != null) {
                }
                throw th;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static b<e> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            Pair<String, String> a2 = a(context, "sdkCloudSetting");
            if (a2 == null) {
                return null;
            }
            return new b<>((String) a2.first, new e((String) a2.second), null);
        }
        return (b) invokeL.objValue;
    }

    public static boolean c(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, context, str, str2)) == null) ? a(context, "sdkCloudSetting", str, str2) : invokeLLL.booleanValue;
    }

    public static Pair<String, String> a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            File dir = context.getDir(SystemUtil.buildNewPathByProcessName("e_qq_com_setting"), 0);
            if (!dir.exists()) {
                return null;
            }
            File file = new File(dir, str + ".sig");
            File file2 = new File(dir, str + ".cfg");
            if (file.exists() && file2.exists()) {
                try {
                    String readAll = StringUtil.readAll(file);
                    String readAll2 = StringUtil.readAll(file2);
                    if (!TextUtils.isEmpty(readAll) && !TextUtils.isEmpty(readAll2)) {
                        com.qq.e.comm.util.a a2 = com.qq.e.comm.util.a.a();
                        if (a2 != null) {
                            if (a2.a(readAll, Md5Util.encode(readAll2))) {
                                return new Pair<>(readAll, new String(Base64.decode(readAll2, 0), "UTF-8"));
                            }
                        } else {
                            throw null;
                        }
                    }
                    GDTLogger.d("verify " + str + " setting fail");
                } catch (Exception unused) {
                    GDTLogger.d("exception while loading local " + str);
                }
            }
            return null;
        }
        return (Pair) invokeLL.objValue;
    }

    public static final boolean a(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, context, str, str2, str3)) == null) {
            if (!StringUtil.isEmpty(str2) && !StringUtil.isEmpty(str3)) {
                com.qq.e.comm.util.a a2 = com.qq.e.comm.util.a.a();
                if (a2 != null) {
                    if (a2.a(str2, Md5Util.encode(str3))) {
                        return b(context, str, str2, str3);
                    }
                    GDTLogger.d(String.format("Fail to update Cloud setting due to sig verify fail,name=%s\tsig=%s\tsetting=%s", str, str2, str3));
                    return false;
                }
                throw null;
            }
            GDTLogger.d(String.format("Fail to update Cloud setting due to sig or setting is empty,name=%s\tsig=%s\tsetting=%s", str, str2, str3));
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
