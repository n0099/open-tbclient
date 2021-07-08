package com.qq.e.comm.managers.setting;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.comm.util.SystemUtil;
import java.io.File;
import java.io.FileWriter;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f38010a;

    /* loaded from: classes6.dex */
    public static class a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f38011a;

        /* renamed from: b  reason: collision with root package name */
        public final T f38012b;

        public a(String str, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38011a = str;
            this.f38012b = t;
        }

        public /* synthetic */ a(String str, Object obj, byte b2) {
            this(str, obj);
        }

        public final String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38011a : (String) invokeV.objValue;
        }

        public final T b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38012b : (T) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        String simpleName = getClass().getSimpleName();
        GDTLogger.d("Initialize " + simpleName + ",Json=" + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                this.f38010a = new JSONObject(str);
            } catch (JSONException e2) {
                GDTLogger.e("JsonException While build" + simpleName + " Instance from JSON", e2);
            }
        }
        if (this.f38010a == null) {
            this.f38010a = new JSONObject();
        }
    }

    public static Pair<String, String> a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            File dir = context.getDir(SystemUtil.buildNewPathByProcessName("e_qq_com_setting"), 0);
            if (dir.exists()) {
                File file = new File(dir, str + ".sig");
                File file2 = new File(dir, str + ".cfg");
                if (file.exists() && file2.exists()) {
                    try {
                        String readAll = StringUtil.readAll(file);
                        String readAll2 = StringUtil.readAll(file2);
                        if (!TextUtils.isEmpty(readAll) && !TextUtils.isEmpty(readAll2) && com.qq.e.comm.util.a.a().a(readAll, readAll2)) {
                            return new Pair<>(readAll, new String(Base64.decode(readAll2, 0), "UTF-8"));
                        }
                        GDTLogger.e("verify " + str + " setting fail");
                    } catch (Exception e2) {
                        GDTLogger.e("exception while loading local " + str, e2);
                    }
                }
                return null;
            }
            return null;
        }
        return (Pair) invokeLL.objValue;
    }

    public static a<com.qq.e.comm.managers.setting.a> a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            Pair<String, String> a2 = a(context, "devCloudSetting");
            if (a2 == null) {
                return null;
            }
            return new a<>((String) a2.first, new com.qq.e.comm.managers.setting.a((String) a2.second), (byte) 0);
        }
        return (a) invokeL.objValue;
    }

    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, str2)) == null) ? a(context, "sdkCloudSetting", str, str2) : invokeLLL.booleanValue;
    }

    public static final boolean a(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, context, str, str2, str3)) == null) {
            if (StringUtil.isEmpty(str2) || StringUtil.isEmpty(str3)) {
                format = String.format("Fail to update Cloud setting due to sig or setting is empty,name=%s\tsig=%s\tsetting=%s", str, str2, str3);
            } else if (com.qq.e.comm.util.a.a().a(str2, str3)) {
                return b(context, str, str2, str3);
            } else {
                format = String.format("Fail to update Cloud setting due to sig verify fail,name=%s\tsig=%s\tsetting=%s", str, str2, str3);
            }
            GDTLogger.e(format);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static a<d> b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            Pair<String, String> a2 = a(context, "sdkCloudSetting");
            if (a2 == null) {
                return null;
            }
            return new a<>((String) a2.first, new d((String) a2.second), (byte) 0);
        }
        return (a) invokeL.objValue;
    }

    public static boolean b(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, context, str, str2)) == null) ? a(context, "devCloudSetting", str, str2) : invokeLLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0088 A[Catch: Exception -> 0x008b, TRY_LEAVE, TryCatch #1 {Exception -> 0x008b, blocks: (B:32:0x0083, B:34:0x0088), top: B:46:0x0083 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        FileWriter fileWriter;
        Throwable th;
        FileWriter fileWriter2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLL = interceptable.invokeLLLL(65544, null, context, str, str2, str3)) != null) {
            return invokeLLLL.booleanValue;
        }
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
                try {
                    fileWriter.write(str2);
                    try {
                        fileWriter2.close();
                        fileWriter.close();
                        return true;
                    } catch (Exception unused) {
                        return true;
                    }
                } catch (Exception unused2) {
                    fileWriter3 = fileWriter2;
                    try {
                        file.delete();
                        file2.delete();
                        if (fileWriter3 != null) {
                            try {
                                fileWriter3.close();
                            } catch (Exception unused3) {
                                return false;
                            }
                        }
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        fileWriter2 = fileWriter3;
                        th = th2;
                        if (fileWriter2 != null) {
                            try {
                                fileWriter2.close();
                            } catch (Exception unused4) {
                                throw th;
                            }
                        }
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fileWriter2 != null) {
                    }
                    if (fileWriter != null) {
                    }
                    throw th;
                }
            } catch (Exception unused5) {
                fileWriter = null;
            } catch (Throwable th4) {
                fileWriter = null;
                th = th4;
            }
        } catch (Exception unused6) {
            fileWriter = null;
        } catch (Throwable th5) {
            fileWriter = null;
            th = th5;
            fileWriter2 = null;
        }
    }

    public static a<c> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            Pair<String, String> a2 = a(context, "placementCloudSetting");
            if (a2 == null) {
                return null;
            }
            return new a<>((String) a2.first, new c((String) a2.second), (byte) 0);
        }
        return (a) invokeL.objValue;
    }

    public static boolean c(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, context, str, str2)) == null) ? a(context, "placementCloudSetting", str, str2) : invokeLLL.booleanValue;
    }

    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            File dir = context.getDir(SystemUtil.buildNewPathByProcessName("e_qq_com_setting"), 0);
            if (dir.exists()) {
                File file = new File(dir, "placementCloudSetting.cfg");
                if (file.exists()) {
                    file.delete();
                }
                File file2 = new File(dir, "placementCloudSetting.sig");
                if (file2.exists()) {
                    file2.delete();
                }
            }
        }
    }
}
