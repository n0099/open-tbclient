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
/* renamed from: com.kuaishou.weapon.p0.ٴ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0432 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public C0432() {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    private String m842(int i, int i2) {
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

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00bf, code lost:
        if (r3 != null) goto L66;
     */
    /* renamed from: ʻ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONArray m843(Context context) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            BufferedReader bufferedReader2 = null;
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
                } catch (Exception unused2) {
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused4) {
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                bufferedReader.close();
            } catch (IOException unused5) {
            }
            return null;
        }
        return (JSONArray) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m844() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Process.myUid() / 100000 != 0 : invokeV.booleanValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public String m845(Context context) {
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
                            File file = new File("/data/data" + File.separator + obj.toString());
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

    /* renamed from: ʽ  reason: contains not printable characters */
    public String m846(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? context.getFilesDir().getParentFile().getAbsolutePath() : (String) invokeL.objValue;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public boolean m847(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            String absolutePath = context.getFilesDir().getParentFile().getAbsolutePath();
            return new File(absolutePath + File.separator + IStringUtil.TOP_PATH).canRead();
        }
        return invokeL.booleanValue;
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public boolean m848(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            try {
                int i = context.getApplicationInfo().targetSdkVersion;
                Class<?> cls = Class.forName("android.os.SELinux");
                String str = (String) cls.getDeclaredMethod("getContext", new Class[0]).invoke(cls, new Object[0]);
                String m842 = m842(i, Build.VERSION.SDK_INT);
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                return !str.startsWith(m842);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* renamed from: ˆ  reason: contains not printable characters */
    public int m849(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048582, this, context)) != null) {
            return invokeL.intValue;
        }
        FileOutputStream fileOutputStream = null;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                String str = "fk_w_" + System.currentTimeMillis();
                FileOutputStream fileOutputStream2 = new FileOutputStream(context.getFilesDir().getParentFile().getAbsolutePath() + File.separator + str);
                try {
                    FileDescriptor fd = fileOutputStream2.getFD();
                    Field declaredField = fd.getClass().getDeclaredField("descriptor");
                    declaredField.setAccessible(true);
                    declaredField.get(fd);
                    String absolutePath = Files.readSymbolicLink(Paths.get(String.format("/proc/self/fd/%d", Integer.valueOf(((Integer) declaredField.get(fd)).intValue())), new String[0])).toFile().getAbsolutePath();
                    if (!absolutePath.substring(absolutePath.lastIndexOf(File.separator)).equals(File.separator + str)) {
                        try {
                            fileOutputStream2.close();
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
                            fileOutputStream2.close();
                        } catch (Exception unused2) {
                        }
                        return 1;
                    }
                    try {
                        fileOutputStream2.close();
                    } catch (Exception unused3) {
                    }
                    return 0;
                } catch (Exception unused4) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused5) {
                        }
                    }
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused6) {
                        }
                    }
                    throw th;
                }
            }
            return m847(context) ? 1 : 0;
        } catch (Exception unused7) {
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
