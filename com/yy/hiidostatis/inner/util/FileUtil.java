package com.yy.hiidostatis.inner.util;

import com.yy.hiidostatis.inner.util.log.L;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
/* loaded from: classes8.dex */
public class FileUtil {
    public static final boolean isExist(String str) {
        return new File(str).exists();
    }

    public static final String readFile(String str) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    String trim = new String(byteArrayOutputStream.toByteArray(), "UTF-8").trim();
                    try {
                        fileInputStream.close();
                        byteArrayOutputStream.close();
                    } catch (IOException e) {
                        L.debug(com.baidu.searchbox.aperf.bosuploader.FileUtil.TAG, e.getMessage(), new Object[0]);
                    }
                    return trim;
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                                L.debug(com.baidu.searchbox.aperf.bosuploader.FileUtil.TAG, e2.getMessage(), new Object[0]);
                                return null;
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                L.debug(com.baidu.searchbox.aperf.bosuploader.FileUtil.TAG, e3.getMessage(), new Object[0]);
                                throw th2;
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            byteArrayOutputStream = null;
        }
    }

    public static final void saveFile(String str, String str2) {
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(str);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdir();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(str2.getBytes("UTF-8"));
                fileOutputStream2.flush();
                try {
                    fileOutputStream2.close();
                } catch (Throwable th) {
                    L.debug(com.baidu.searchbox.aperf.bosuploader.FileUtil.TAG, th.getMessage(), new Object[0]);
                }
            } catch (Throwable th2) {
                fileOutputStream = fileOutputStream2;
                th = th2;
                try {
                    th.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th3) {
                            L.debug(com.baidu.searchbox.aperf.bosuploader.FileUtil.TAG, th3.getMessage(), new Object[0]);
                        }
                    }
                } catch (Throwable th4) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th5) {
                            L.debug(com.baidu.searchbox.aperf.bosuploader.FileUtil.TAG, th5.getMessage(), new Object[0]);
                        }
                    }
                    throw th4;
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static boolean writeFile(String str, String str2) {
        PrintWriter printWriter = null;
        try {
            PrintWriter printWriter2 = new PrintWriter(str);
            try {
                printWriter2.print(str2);
                printWriter2.flush();
                printWriter2.close();
                return true;
            } catch (Throwable th) {
                th = th;
                printWriter = printWriter2;
                try {
                    th.printStackTrace();
                    return false;
                } finally {
                    if (printWriter != null) {
                        printWriter.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
