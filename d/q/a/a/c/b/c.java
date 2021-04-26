package d.q.a.a.c.b;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tbadk.core.util.FieldBuilder;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes7.dex */
public class c implements d.q.a.a.a.b.b {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:113:0x016e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:135:0x0168 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:136:0x0002 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:92:0x013d */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0160, code lost:
        if (r11 != 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0162, code lost:
        r11.destroy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0165, code lost:
        r10 = r0;
        r12 = r1;
        r0 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x013d, code lost:
        if (r11 != 0) goto L49;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0154 A[Catch: IOException -> 0x0150, TryCatch #5 {IOException -> 0x0150, blocks: (B:99:0x014c, B:103:0x0154, B:105:0x0159), top: B:131:0x014c }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0159 A[Catch: IOException -> 0x0150, TRY_LEAVE, TryCatch #5 {IOException -> 0x0150, blocks: (B:99:0x014c, B:103:0x0154, B:105:0x0159), top: B:131:0x014c }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0179 A[Catch: IOException -> 0x0175, TryCatch #1 {IOException -> 0x0175, blocks: (B:115:0x0171, B:119:0x0179, B:121:0x017e), top: B:127:0x0171 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x017e A[Catch: IOException -> 0x0175, TRY_LEAVE, TryCatch #1 {IOException -> 0x0175, blocks: (B:115:0x0171, B:119:0x0179, B:121:0x017e), top: B:127:0x0171 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0171 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x014c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0129 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0131 A[Catch: IOException -> 0x012d, TryCatch #7 {IOException -> 0x012d, blocks: (B:83:0x0129, B:87:0x0131, B:89:0x0136), top: B:133:0x0129 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0136 A[Catch: IOException -> 0x012d, TRY_LEAVE, TryCatch #7 {IOException -> 0x012d, blocks: (B:83:0x0129, B:87:0x0131, B:89:0x0136), top: B:133:0x0129 }] */
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
        DataOutputStream dataOutputStream2 = 0;
        try {
            try {
                z = Runtime.getRuntime().exec(z != 0 ? "su" : IAdRequestParam.SCREEN_HEIGHT);
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
                                dataOutputStream.writeBytes("\n");
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
                        b.c(e);
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
                        b.c(e);
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
                b.c(e);
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
                b.c(e);
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
        } catch (IOException e8) {
            e = e8;
            obj2 = null;
            str2 = null;
        } catch (Exception e9) {
            e = e9;
            obj = null;
            str = null;
        } catch (Throwable th4) {
            th = th4;
            z = 0;
            bufferedReader = null;
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
                        sb.append(FieldBuilder.SE);
                    } catch (Throwable th5) {
                        th = th5;
                        dataOutputStream2 = dataOutputStream;
                        if (dataOutputStream2 != null) {
                            try {
                                dataOutputStream2.close();
                            } catch (IOException e10) {
                                b.c(e10);
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
                } catch (IOException e11) {
                    e = e11;
                    i2 = i3;
                    bufferedReader4 = null;
                    dataOutputStream2 = dataOutputStream;
                    bufferedReader3 = bufferedReader4;
                    str = bufferedReader4;
                    z = z;
                    b.c(e);
                    if (dataOutputStream2 != null) {
                        try {
                            dataOutputStream2.close();
                        } catch (IOException e12) {
                            b.c(e12);
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                } catch (Exception e13) {
                    e = e13;
                    i2 = i3;
                    str = null;
                    dataOutputStream2 = dataOutputStream;
                    bufferedReader3 = str;
                    z = z;
                    b.c(e);
                    if (dataOutputStream2 != null) {
                        try {
                            dataOutputStream2.close();
                        } catch (IOException e14) {
                            b.c(e14);
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
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
                    sb2.append(FieldBuilder.SE);
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
                } catch (IOException e15) {
                    b.c(e15);
                }
                if (z != null) {
                    z.destroy();
                }
            } catch (IOException e16) {
                str = str3;
                e = e16;
                i2 = i3;
                bufferedReader3 = null;
                dataOutputStream2 = dataOutputStream;
                z = z;
                b.c(e);
                if (dataOutputStream2 != null) {
                }
                if (bufferedReader != null) {
                }
                if (bufferedReader2 != null) {
                }
            } catch (Exception e17) {
                str = str3;
                e = e17;
                i2 = i3;
                bufferedReader3 = null;
                dataOutputStream2 = dataOutputStream;
                z = z;
                b.c(e);
                if (dataOutputStream2 != null) {
                }
                if (bufferedReader != null) {
                }
                if (bufferedReader2 != null) {
                }
            }
        } catch (IOException e18) {
            e = e18;
            bufferedReader2 = null;
            i2 = i3;
            bufferedReader4 = bufferedReader2;
            dataOutputStream2 = dataOutputStream;
            bufferedReader3 = bufferedReader4;
            str = bufferedReader4;
            z = z;
            b.c(e);
            if (dataOutputStream2 != null) {
            }
            if (bufferedReader != null) {
            }
            if (bufferedReader2 != null) {
            }
        } catch (Exception e19) {
            e = e19;
            bufferedReader2 = null;
            i2 = i3;
            str = bufferedReader2;
            dataOutputStream2 = dataOutputStream;
            bufferedReader3 = str;
            z = z;
            b.c(e);
            if (dataOutputStream2 != null) {
            }
            if (bufferedReader != null) {
            }
            if (bufferedReader2 != null) {
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedReader2 = null;
        }
        return new d(i3, str3, dataOutputStream2);
    }

    @Override // d.q.a.a.a.b.b
    public void a(d.q.a.a.a.a.a aVar) {
    }

    @Override // d.q.a.a.a.b.b
    public boolean a() {
        return true;
    }

    @Override // d.q.a.a.a.b.b
    public String b() {
        return "";
    }

    @Override // d.q.a.a.a.b.b
    public boolean c() {
        return false;
    }

    @Override // d.q.a.a.a.b.b
    public void d() {
    }
}
