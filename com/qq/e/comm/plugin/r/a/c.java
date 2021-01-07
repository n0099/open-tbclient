package com.qq.e.comm.plugin.r.a;

import android.content.Context;
import com.qq.e.comm.util.GDTLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/* loaded from: classes4.dex */
class c {
    public static String a(Context context) {
        File c = c(context, "config");
        if (c == null) {
            return null;
        }
        try {
            String a2 = a(c);
            if (a2 != null) {
                return com.qq.e.comm.plugin.util.c.b(a2);
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:5:0x0007 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v7 */
    private static String a(File file) throws IOException {
        Throwable th;
        String str = 0;
        str = 0;
        if (file != null) {
            try {
                if (file.exists()) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            }
                            str = sb.toString();
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e) {
                                    GDTLogger.e("Exception while close bufferreader", e);
                                }
                            }
                        } catch (IOException e2) {
                            throw e2;
                        }
                    } catch (IOException e3) {
                        throw e3;
                    } catch (Throwable th2) {
                        th = th2;
                        if (0 != 0) {
                            try {
                                str.close();
                            } catch (Exception e4) {
                                GDTLogger.e("Exception while close bufferreader", e4);
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(Context context, File file, String str, boolean z) {
        OutputStreamWriter outputStreamWriter;
        Throwable th;
        OutputStreamWriter outputStreamWriter2;
        if (file == null) {
            return;
        }
        try {
            outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            if (z) {
                try {
                    try {
                        str = com.qq.e.comm.plugin.util.c.a(str);
                    } catch (Exception e) {
                        GDTLogger.d("write mediation config to file fail");
                        if (outputStreamWriter2 != null) {
                            try {
                                outputStreamWriter2.close();
                                return;
                            } catch (Exception e2) {
                                GDTLogger.d("close config writer failed");
                                return;
                            }
                        }
                        return;
                    }
                } catch (Throwable th2) {
                    outputStreamWriter = outputStreamWriter2;
                    th = th2;
                    if (outputStreamWriter != null) {
                        try {
                            outputStreamWriter.close();
                        } catch (Exception e3) {
                            GDTLogger.d("close config writer failed");
                        }
                    }
                    throw th;
                }
            }
            outputStreamWriter2.write(str);
            if (outputStreamWriter2 != null) {
                try {
                    outputStreamWriter2.close();
                } catch (Exception e4) {
                    GDTLogger.d("close config writer failed");
                }
            }
        } catch (Exception e5) {
            outputStreamWriter2 = null;
        } catch (Throwable th3) {
            outputStreamWriter = null;
            th = th3;
            if (outputStreamWriter != null) {
            }
            throw th;
        }
    }

    public static void a(Context context, String str) {
        a(context, c(context, "config"), str, true);
    }

    public static void b(Context context, String str) {
        a(context, c(context, "test"), str, false);
    }

    private static File c(Context context, String str) {
        File dir = context.getDir("e_qq_com_mediation", 0);
        if (!dir.exists() && !dir.mkdirs()) {
            GDTLogger.w("Create mediation config dir failed!");
            return null;
        }
        File file = new File(dir, str);
        try {
            if (file.exists() || file.createNewFile()) {
                return file;
            }
            GDTLogger.w("Create mediation config file failed!");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            GDTLogger.w("Create mediation config file failed!");
            return null;
        }
    }
}
