package com.yxcorp.kuaishou.addfp.android.b;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes4.dex */
public class c implements com.yxcorp.kuaishou.addfp.a.b.a {
    /* JADX WARN: Removed duplicated region for block: B:113:0x00fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x011d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0088 A[Catch: IOException -> 0x00ed, TryCatch #8 {IOException -> 0x00ed, blocks: (B:26:0x0083, B:28:0x0088, B:30:0x008d), top: B:117:0x0083 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008d A[Catch: IOException -> 0x00ed, TRY_LEAVE, TryCatch #8 {IOException -> 0x00ed, blocks: (B:26:0x0083, B:28:0x0088, B:30:0x008d), top: B:117:0x0083 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0103 A[Catch: IOException -> 0x0111, TryCatch #4 {IOException -> 0x0111, blocks: (B:59:0x00fe, B:61:0x0103, B:63:0x0108), top: B:113:0x00fe }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0108 A[Catch: IOException -> 0x0111, TRY_LEAVE, TryCatch #4 {IOException -> 0x0111, blocks: (B:59:0x00fe, B:61:0x0103, B:63:0x0108), top: B:113:0x00fe }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0122 A[Catch: IOException -> 0x0130, TryCatch #6 {IOException -> 0x0130, blocks: (B:71:0x011d, B:73:0x0122, B:75:0x0127), top: B:115:0x011d }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0127 A[Catch: IOException -> 0x0130, TRY_LEAVE, TryCatch #6 {IOException -> 0x0130, blocks: (B:71:0x011d, B:73:0x0122, B:75:0x0127), top: B:115:0x011d }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static d a(String[] strArr, boolean z, boolean z2) {
        DataOutputStream dataOutputStream;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        Process process;
        String str;
        String str2;
        BufferedReader bufferedReader3;
        StringBuilder sb;
        StringBuilder sb2;
        int i = -1;
        try {
            try {
                process = Runtime.getRuntime().exec(z ? "su" : IXAdRequestInfo.SCREEN_HEIGHT);
                try {
                    dataOutputStream = new DataOutputStream(process.getOutputStream());
                    for (int i2 = 0; i2 <= 0; i2++) {
                        try {
                            String str3 = strArr[0];
                            if (str3 != null) {
                                dataOutputStream.write(str3.getBytes());
                                dataOutputStream.writeBytes("\n");
                                dataOutputStream.flush();
                            }
                        } catch (IOException e) {
                            e = e;
                            str = null;
                            str2 = null;
                            bufferedReader3 = null;
                            bufferedReader2 = null;
                            b.a(e);
                            if (dataOutputStream != null) {
                            }
                            if (bufferedReader2 != null) {
                            }
                            if (bufferedReader3 != null) {
                            }
                            if (process != null) {
                            }
                            return new d(i, str2, str);
                        } catch (Exception e2) {
                            e = e2;
                            str = null;
                            str2 = null;
                            bufferedReader3 = null;
                            bufferedReader2 = null;
                            b.a(e);
                            if (dataOutputStream != null) {
                            }
                            if (bufferedReader2 != null) {
                            }
                            if (bufferedReader3 != null) {
                            }
                            if (process != null) {
                            }
                            return new d(i, str2, str);
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = null;
                            bufferedReader2 = null;
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (IOException e3) {
                                    b.a(e3);
                                    if (process != null) {
                                        process.destroy();
                                    }
                                    throw th;
                                }
                            }
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (process != null) {
                            }
                            throw th;
                        }
                    }
                    dataOutputStream.writeBytes("exit\n");
                    dataOutputStream.flush();
                    i = process.waitFor();
                    sb = new StringBuilder();
                    sb2 = new StringBuilder();
                    bufferedReader2 = new BufferedReader(new InputStreamReader(process.getInputStream()));
                } catch (IOException e4) {
                    e = e4;
                    dataOutputStream = null;
                    str = null;
                    str2 = null;
                    bufferedReader3 = null;
                    bufferedReader2 = null;
                } catch (Exception e5) {
                    e = e5;
                    dataOutputStream = null;
                    str = null;
                    str2 = null;
                    bufferedReader3 = null;
                    bufferedReader2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    dataOutputStream = null;
                    bufferedReader = null;
                    bufferedReader2 = null;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e6) {
            e = e6;
            dataOutputStream = null;
            str = null;
            str2 = null;
            bufferedReader3 = null;
            bufferedReader2 = null;
            process = null;
        } catch (Exception e7) {
            e = e7;
            dataOutputStream = null;
            str = null;
            str2 = null;
            bufferedReader3 = null;
            bufferedReader2 = null;
            process = null;
        } catch (Throwable th4) {
            th = th4;
            dataOutputStream = null;
            bufferedReader = null;
            bufferedReader2 = null;
            process = null;
        }
        try {
            bufferedReader3 = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine).append("|");
                } catch (IOException e8) {
                    e = e8;
                    str = null;
                    str2 = null;
                } catch (Exception e9) {
                    e = e9;
                    str = null;
                    str2 = null;
                }
            }
            str2 = sb.toString();
            try {
                if (str2.length() > 0) {
                    str2 = str2.substring(0, str2.length() - 1);
                }
                while (true) {
                    String readLine2 = bufferedReader3.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    sb2.append(readLine2).append("|");
                }
                String sb3 = sb2.toString();
                try {
                    str = sb3.length() > 0 ? sb3.substring(0, sb3.length() - 1) : sb3;
                    try {
                        dataOutputStream.close();
                        bufferedReader2.close();
                        bufferedReader3.close();
                    } catch (IOException e10) {
                        b.a(e10);
                    }
                    if (process != null) {
                        process.destroy();
                    }
                } catch (IOException e11) {
                    e = e11;
                    str = sb3;
                    b.a(e);
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e12) {
                            b.a(e12);
                            if (process != null) {
                                process.destroy();
                            }
                            return new d(i, str2, str);
                        }
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    if (bufferedReader3 != null) {
                        bufferedReader3.close();
                    }
                    if (process != null) {
                    }
                    return new d(i, str2, str);
                } catch (Exception e13) {
                    e = e13;
                    str = sb3;
                    b.a(e);
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e14) {
                            b.a(e14);
                            if (process != null) {
                                process.destroy();
                            }
                            return new d(i, str2, str);
                        }
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    if (bufferedReader3 != null) {
                        bufferedReader3.close();
                    }
                    if (process != null) {
                    }
                    return new d(i, str2, str);
                }
            } catch (IOException e15) {
                e = e15;
                str = null;
            } catch (Exception e16) {
                e = e16;
                str = null;
            }
        } catch (IOException e17) {
            e = e17;
            str = null;
            str2 = null;
            bufferedReader3 = null;
        } catch (Exception e18) {
            e = e18;
            str = null;
            str2 = null;
            bufferedReader3 = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            if (dataOutputStream != null) {
            }
            if (bufferedReader2 != null) {
            }
            if (bufferedReader != null) {
            }
            if (process != null) {
            }
            throw th;
        }
        return new d(i, str2, str);
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public void a(com.yxcorp.kuaishou.addfp.a.a.a aVar) {
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public boolean a() {
        return true;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public String b() {
        return "";
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public boolean c() {
        return false;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a
    public void d() {
    }
}
