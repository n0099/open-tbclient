package com.yxcorp.kuaishou.addfp.android.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.j0;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes4.dex */
public class c implements com.yxcorp.kuaishou.addfp.a.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:115:0x0172 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:141:0x016c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:142:0x0006 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:94:0x0141 */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0164, code lost:
        if (r11 != 0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0166, code lost:
        r11.destroy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0169, code lost:
        r10 = r0;
        r12 = r1;
        r0 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0141, code lost:
        if (r11 != 0) goto L51;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0158 A[Catch: IOException -> 0x0154, TryCatch #6 {IOException -> 0x0154, blocks: (B:101:0x0150, B:105:0x0158, B:107:0x015d), top: B:137:0x0150 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x015d A[Catch: IOException -> 0x0154, TRY_LEAVE, TryCatch #6 {IOException -> 0x0154, blocks: (B:101:0x0150, B:105:0x0158, B:107:0x015d), top: B:137:0x0150 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x017d A[Catch: IOException -> 0x0179, TryCatch #0 {IOException -> 0x0179, blocks: (B:117:0x0175, B:121:0x017d, B:123:0x0182), top: B:133:0x0175 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0182 A[Catch: IOException -> 0x0179, TRY_LEAVE, TryCatch #0 {IOException -> 0x0179, blocks: (B:117:0x0175, B:121:0x017d, B:123:0x0182), top: B:133:0x0175 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0175 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0150 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x012d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0135 A[Catch: IOException -> 0x0131, TryCatch #7 {IOException -> 0x0131, blocks: (B:85:0x012d, B:89:0x0135, B:91:0x013a), top: B:139:0x012d }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x013a A[Catch: IOException -> 0x0131, TRY_LEAVE, TryCatch #7 {IOException -> 0x0131, blocks: (B:85:0x012d, B:89:0x0135, B:91:0x013a), top: B:139:0x012d }] */
    /* JADX WARN: Type inference failed for: r10v37 */
    /* JADX WARN: Type inference failed for: r11v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static d a(String[] strArr, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        BufferedReader bufferedReader;
        Object obj;
        String str;
        Object obj2;
        String str2;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        int i2;
        String str3;
        int i3;
        DataOutputStream dataOutputStream;
        BufferedReader bufferedReader4;
        StringBuilder sb;
        StringBuilder sb2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{strArr, Boolean.valueOf((boolean) z), Boolean.valueOf(z2)})) == null) {
            DataOutputStream dataOutputStream2 = 0;
            try {
                try {
                    z = Runtime.getRuntime().exec(z != 0 ? j0.f55302b : "sh");
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    dataOutputStream = new DataOutputStream(z.getOutputStream());
                    for (int i4 = 0; i4 <= 0; i4++) {
                        try {
                            try {
                                String str4 = strArr[0];
                                if (str4 != null) {
                                    dataOutputStream.write(str4.getBytes());
                                    dataOutputStream.writeBytes(StringUtils.LF);
                                    dataOutputStream.flush();
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedReader = null;
                                bufferedReader2 = null;
                                dataOutputStream2 = dataOutputStream;
                                if (dataOutputStream2 != null) {
                                }
                                if (bufferedReader != null) {
                                }
                                if (bufferedReader2 != null) {
                                }
                                if (z != 0) {
                                }
                                throw th;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            str = null;
                            bufferedReader = null;
                            bufferedReader2 = null;
                            i2 = -1;
                            dataOutputStream2 = dataOutputStream;
                            bufferedReader3 = null;
                            z = z;
                            e.printStackTrace();
                            if (dataOutputStream2 != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            if (bufferedReader2 != null) {
                            }
                        } catch (Exception e3) {
                            e = e3;
                            str = null;
                            bufferedReader = null;
                            bufferedReader2 = null;
                            i2 = -1;
                            dataOutputStream2 = dataOutputStream;
                            bufferedReader3 = null;
                            z = z;
                            e.printStackTrace();
                            if (dataOutputStream2 != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            if (bufferedReader2 != null) {
                            }
                        }
                    }
                    dataOutputStream.writeBytes("exit\n");
                    dataOutputStream.flush();
                    i3 = z.waitFor();
                    try {
                        sb = new StringBuilder();
                        sb2 = new StringBuilder();
                        bufferedReader = new BufferedReader(new InputStreamReader(z.getInputStream()));
                    } catch (IOException e4) {
                        e = e4;
                        bufferedReader = null;
                        bufferedReader2 = null;
                    } catch (Exception e5) {
                        e = e5;
                        bufferedReader = null;
                        bufferedReader2 = null;
                    }
                } catch (IOException e6) {
                    e = e6;
                    str2 = null;
                    obj2 = z;
                    String str5 = str2;
                    bufferedReader = str5;
                    bufferedReader2 = bufferedReader;
                    i2 = -1;
                    str = str2;
                    bufferedReader3 = str5;
                    z = obj2;
                    e.printStackTrace();
                    if (dataOutputStream2 != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (bufferedReader2 != null) {
                    }
                } catch (Exception e7) {
                    e = e7;
                    str = null;
                    obj = z;
                    bufferedReader3 = str;
                    bufferedReader = bufferedReader3;
                    bufferedReader2 = bufferedReader;
                    i2 = -1;
                    z = obj;
                    e.printStackTrace();
                    if (dataOutputStream2 != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (bufferedReader2 != null) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    z = z;
                    bufferedReader2 = bufferedReader;
                    if (dataOutputStream2 != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (bufferedReader2 != null) {
                    }
                    if (z != 0) {
                    }
                    throw th;
                }
                try {
                    bufferedReader2 = new BufferedReader(new InputStreamReader(z.getErrorStream()));
                    while (true) {
                        try {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                                sb.append("|");
                            } catch (Throwable th4) {
                                th = th4;
                                dataOutputStream2 = dataOutputStream;
                                if (dataOutputStream2 != null) {
                                    try {
                                        dataOutputStream2.close();
                                    } catch (IOException e8) {
                                        e8.printStackTrace();
                                        if (z != 0) {
                                            z.destroy();
                                        }
                                        throw th;
                                    }
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                }
                                if (z != 0) {
                                }
                                throw th;
                            }
                        } catch (IOException e9) {
                            e = e9;
                            i2 = i3;
                            bufferedReader4 = null;
                            dataOutputStream2 = dataOutputStream;
                            bufferedReader3 = bufferedReader4;
                            str = bufferedReader4;
                            z = z;
                            e.printStackTrace();
                            if (dataOutputStream2 != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            if (bufferedReader2 != null) {
                            }
                        } catch (Exception e10) {
                            e = e10;
                            i2 = i3;
                            str = null;
                            dataOutputStream2 = dataOutputStream;
                            bufferedReader3 = str;
                            z = z;
                            e.printStackTrace();
                            if (dataOutputStream2 != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            if (bufferedReader2 != null) {
                            }
                        }
                    }
                    str3 = sb.toString();
                    try {
                        if (str3.length() > 0) {
                            str3 = str3.substring(0, str3.length() - 1);
                        }
                        while (true) {
                            String readLine2 = bufferedReader2.readLine();
                            if (readLine2 == null) {
                                break;
                            }
                            sb2.append(readLine2);
                            sb2.append("|");
                        }
                        String sb3 = sb2.toString();
                        int length = sb3.length();
                        dataOutputStream2 = sb3;
                        if (length > 0) {
                            dataOutputStream2 = sb3.substring(0, sb3.length() - 1);
                        }
                        try {
                            dataOutputStream.close();
                            bufferedReader.close();
                            bufferedReader2.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                        if (z != null) {
                            z.destroy();
                        }
                    } catch (IOException e12) {
                        str = str3;
                        e = e12;
                        i2 = i3;
                        bufferedReader3 = null;
                        dataOutputStream2 = dataOutputStream;
                        z = z;
                        e.printStackTrace();
                        if (dataOutputStream2 != null) {
                            try {
                                dataOutputStream2.close();
                            } catch (IOException e13) {
                                e13.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                    } catch (Exception e14) {
                        str = str3;
                        e = e14;
                        i2 = i3;
                        bufferedReader3 = null;
                        dataOutputStream2 = dataOutputStream;
                        z = z;
                        e.printStackTrace();
                        if (dataOutputStream2 != null) {
                            try {
                                dataOutputStream2.close();
                            } catch (IOException e15) {
                                e15.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                    }
                } catch (IOException e16) {
                    e = e16;
                    bufferedReader2 = null;
                    i2 = i3;
                    bufferedReader4 = bufferedReader2;
                    dataOutputStream2 = dataOutputStream;
                    bufferedReader3 = bufferedReader4;
                    str = bufferedReader4;
                    z = z;
                    e.printStackTrace();
                    if (dataOutputStream2 != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (bufferedReader2 != null) {
                    }
                } catch (Exception e17) {
                    e = e17;
                    bufferedReader2 = null;
                    i2 = i3;
                    str = bufferedReader2;
                    dataOutputStream2 = dataOutputStream;
                    bufferedReader3 = str;
                    z = z;
                    e.printStackTrace();
                    if (dataOutputStream2 != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (bufferedReader2 != null) {
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedReader2 = null;
                }
            } catch (IOException e18) {
                e = e18;
                obj2 = null;
                str2 = null;
            } catch (Exception e19) {
                e = e19;
                obj = null;
                str = null;
            } catch (Throwable th6) {
                th = th6;
                z = 0;
                bufferedReader = null;
            }
            return new d(i3, str3, dataOutputStream2);
        }
        return (d) invokeCommon.objValue;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public void a(com.yxcorp.kuaishou.addfp.a.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }
}
