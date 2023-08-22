package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class d0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private String a(int i, int i2) {
        InterceptResult invokeII;
        StringBuilder sb;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65537, this, i, i2)) == null) {
            if (i2 < 26) {
                return "u:r:untrusted_app";
            }
            if (i < i2) {
                if (i >= 26) {
                    if (i2 != 27) {
                        if (i2 == 28 || i2 == 29) {
                            if (i >= 26) {
                                sb = new StringBuilder();
                                sb.append("u:r:untrusted_app");
                                sb.append("_27:s0");
                            }
                        } else if (i2 == 30) {
                            if (i >= 29) {
                                sb = new StringBuilder();
                                sb.append("u:r:untrusted_app");
                                str = "_29:s0";
                            } else {
                                sb = new StringBuilder();
                                sb.append("u:r:untrusted_app");
                                sb.append("_27:s0");
                            }
                        }
                        return sb.toString();
                    } else if (i >= 26) {
                        sb = new StringBuilder();
                    }
                    return "u:r:untrusted_app";
                }
                sb = new StringBuilder();
                sb.append("u:r:untrusted_app");
                str = "_25:s0";
                sb.append(str);
                return sb.toString();
            }
            sb = new StringBuilder();
            sb.append("u:r:untrusted_app");
            sb.append(":s0");
            return sb.toString();
        }
        return (String) invokeII.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b5, code lost:
        if (r3 != null) goto L66;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONArray a(Context context) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/self/maps"));
                try {
                    HashSet hashSet = new HashSet();
                    String packageName = context.getPackageName();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            if (!readLine.contains("@Hw") && !readLine.contains(".apk@classes.dex") && !readLine.contains("WebViewGoogle") && !readLine.contains("FeatureFramework") && !readLine.contains("framework@oppo") && !readLine.contains("framework@mediatek")) {
                                if (hashSet.size() > 15) {
                                    break;
                                }
                                if (!readLine.contains(packageName) && readLine.contains("/data/") && readLine.contains(".so")) {
                                    substring = readLine.substring(readLine.indexOf("/data/"), readLine.indexOf(".so") + 3);
                                } else if (!readLine.contains(packageName) && readLine.contains("/data/") && readLine.contains(".dex")) {
                                    substring = readLine.substring(readLine.indexOf("/data/"), readLine.indexOf(".dex") + 4);
                                }
                                hashSet.add(substring);
                            }
                        } else {
                            break;
                        }
                    }
                    if (hashSet.size() > 0) {
                        JSONArray jSONArray = new JSONArray((Collection) hashSet);
                        try {
                            bufferedReader.close();
                        } catch (IOException unused) {
                        }
                        return jSONArray;
                    }
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                bufferedReader = null;
            }
            try {
                bufferedReader.close();
            } catch (IOException unused4) {
            }
            return null;
        }
        return (JSONArray) invokeL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Process.myUid() / DefaultOggSeeker.MATCH_BYTE_RANGE != 0 : invokeV.booleanValue;
    }

    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            try {
                Object invoke = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
                Field declaredField = invoke.getClass().getDeclaredField("mPackages");
                declaredField.setAccessible(true);
                Map map = (Map) declaredField.get(invoke);
                if (map != null && map.size() > 0) {
                    for (Object obj : map.keySet()) {
                        if (obj.toString().length() > 1 && !obj.toString().equals(context.getPackageName())) {
                            File file = new File(com.baidu.searchbox.antivr.b.a + File.separator + obj.toString());
                            if (file.exists() && file.canWrite()) {
                                return obj.toString();
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            try {
                return context.getFilesDir().getParentFile().getAbsolutePath();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            try {
                String absolutePath = context.getFilesDir().getParentFile().getAbsolutePath();
                return new File(absolutePath + File.separator + IStringUtil.TOP_PATH).canRead();
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            try {
                int i = context.getApplicationInfo().targetSdkVersion;
                Class<?> cls = Class.forName("android.os.SELinux");
                String str = (String) cls.getDeclaredMethod("getContext", new Class[0]).invoke(cls, new Object[0]);
                String a = a(i, Build.VERSION.SDK_INT);
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                return !str.startsWith(a);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public int f(Context context) {
        InterceptResult invokeL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048582, this, context)) != null) {
            return invokeL.intValue;
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                String str = "fk_w_" + System.currentTimeMillis();
                fileOutputStream = new FileOutputStream(context.getFilesDir().getParentFile().getAbsolutePath() + File.separator + str);
                try {
                    FileDescriptor fd = fileOutputStream.getFD();
                    Field declaredField = fd.getClass().getDeclaredField("descriptor");
                    declaredField.setAccessible(true);
                    declaredField.get(fd);
                    String absolutePath = Files.readSymbolicLink(Paths.get(String.format("/proc/self/fd/%d", Integer.valueOf(((Integer) declaredField.get(fd)).intValue())), new String[0])).toFile().getAbsolutePath();
                    if (!absolutePath.substring(absolutePath.lastIndexOf(File.separator)).equals(File.separator + str)) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused) {
                        }
                        return 1;
                    }
                    boolean canRead = new File(absolutePath.replace(str, "")).getParentFile().canRead();
                    File file = new File(absolutePath);
                    if (file.exists()) {
                        file.delete();
                    }
                    if (canRead) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused2) {
                        }
                        return 1;
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused3) {
                    }
                    return 0;
                } catch (Throwable unused4) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused5) {
                        }
                    }
                    return 0;
                }
            }
            return d(context) ? 1 : 0;
        } catch (Throwable unused6) {
            fileOutputStream = null;
        }
    }
}
