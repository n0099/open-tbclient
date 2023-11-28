package com.kuaishou.weapon.p0;

import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class di {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public di() {
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

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                return b(String.format(" lsof -p %1$s ", Integer.valueOf(Process.myPid())));
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                String a = a(" pidof adbd ");
                if (!TextUtils.isEmpty(a)) {
                    if (a.length() > 10) {
                        return a.substring(0, 10);
                    }
                    return a;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String str2 = "";
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        str2 = "" + readLine;
                    }
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused) {
                    }
                    return str2;
                } catch (Exception unused2) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused3) {
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
                ArrayList arrayList = new ArrayList();
                do {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (readLine.contains("TCP") && !readLine.contains(":443")) {
                        arrayList.add(readLine);
                    }
                } while (arrayList.size() <= 5);
                bufferedReader.close();
                if (arrayList.size() > 0) {
                    return arrayList.toString();
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
        if (r3 == null) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Set c() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            try {
                HashSet hashSet = new HashSet();
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(" netstat -nap ").getInputStream()));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        } else if (readLine.contains("tcp") && readLine.contains("ESTABLISHED") && readLine.contains(":5555 ")) {
                            hashSet.add(readLine);
                        }
                    } catch (Exception unused) {
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                }
                if (hashSet.size() > 0) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                    return hashSet;
                }
            } catch (Exception unused4) {
                bufferedReader = null;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
            try {
                bufferedReader.close();
            } catch (Exception unused5) {
                return null;
            }
        } else {
            return (Set) invokeV.objValue;
        }
    }

    public static int d() {
        InterceptResult invokeV;
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(" netstat -apn | grep scrcpy ").getInputStream()));
                do {
                    try {
                        readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            try {
                                bufferedReader2.close();
                            } catch (Exception unused) {
                            }
                            return 0;
                        }
                    } catch (Exception unused2) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused3) {
                            }
                        }
                        return 0;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused4) {
                            }
                        }
                        throw th;
                    }
                } while (!readLine.contains("scrcpy"));
                try {
                    bufferedReader2.close();
                    return 1;
                } catch (Exception unused5) {
                    return 1;
                }
            } catch (Exception unused6) {
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return invokeV.intValue;
        }
    }

    public static JSONObject e() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(" netstat -an ").getInputStream()));
                try {
                    JSONObject jSONObject = new JSONObject();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        } else if (readLine.contains("/") || readLine.contains("@")) {
                            if (readLine.contains("/")) {
                                readLine = readLine.substring(readLine.indexOf("/"));
                            } else if (readLine.contains("@")) {
                                readLine = readLine.substring(readLine.indexOf("@"));
                            }
                            if (readLine.contains("/ddy")) {
                                jSONObject.put("0", readLine);
                            } else if (readLine.contains("scrcpy")) {
                                jSONObject.put("1", readLine);
                            } else if (readLine.contains("supersu")) {
                                jSONObject.put("2", readLine);
                            } else if (readLine.contains("/adbd")) {
                                jSONObject.put("3", readLine);
                            }
                        }
                    }
                    if (jSONObject.length() > 0) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused) {
                        }
                        return jSONObject;
                    }
                    try {
                        bufferedReader.close();
                    } catch (Exception unused2) {
                    }
                    return null;
                } catch (Exception unused3) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused4) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Exception unused5) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused6) {
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return (JSONObject) invokeV.objValue;
        }
    }
}
