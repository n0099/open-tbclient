package kascend.core.a;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import kascend.core.utils.KSUtils;
/* loaded from: classes9.dex */
public class c extends a {
    private File mFile;
    private String mPath;
    private final String pTq;

    public c(Context context) {
        super(context);
        this.pTq = "ksdevice";
        this.mPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/kascend/.kas";
        this.mFile = new File(this.mPath);
        File parentFile = this.mFile.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdir();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [66=4, 70=4, 71=4, 52=5, 54=4, 55=4, 56=4, 57=4, 58=4, 59=4, 61=4, 62=4, 63=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:62:0x016b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:73:? */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v22, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v29, types: [java.lang.CharSequence, java.lang.String] */
    @Override // kascend.core.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getDS() {
        ?? r0;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        FileInputStream fileInputStream;
        String[] split;
        ByteArrayOutputStream byteArrayOutputStream2;
        String[] split2;
        ByteArrayOutputStream byteArrayOutputStream3;
        String[] split3;
        ByteArrayOutputStream byteArrayOutputStream4;
        if (this.mFile.exists()) {
            byteArrayOutputStream = new ByteArrayOutputStream();
            r0 = 8192;
            try {
                try {
                    byte[] bArr = new byte[8192];
                    fileInputStream = new FileInputStream(this.mFile);
                    try {
                        byteArrayOutputStream.write(bArr, 0, fileInputStream.read(bArr));
                    } catch (FileNotFoundException e) {
                        deleteFile();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                split2 = KSUtils.decrypt(new String(byteArrayOutputStream.toByteArray())).split(":");
                            } catch (Exception e2) {
                                deleteFile();
                            }
                            if (split2.length == 2) {
                                String str = split2[0];
                                String str2 = split2[1];
                                ?? Zy = kascend.core.utils.c.Zy("ksdevice" + str);
                                boolean equals = TextUtils.equals(str2, Zy);
                                r0 = str;
                                byteArrayOutputStream = Zy;
                                if (!equals) {
                                    deleteFile();
                                    byteArrayOutputStream3 = Zy;
                                }
                                return r0;
                            }
                            deleteFile();
                            byteArrayOutputStream3 = byteArrayOutputStream;
                            r0 = 0;
                            byteArrayOutputStream = byteArrayOutputStream3;
                            return r0;
                        }
                        r0 = 0;
                        byteArrayOutputStream = byteArrayOutputStream;
                        return r0;
                    } catch (IOException e3) {
                        deleteFile();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                split = KSUtils.decrypt(new String(byteArrayOutputStream.toByteArray())).split(":");
                            } catch (Exception e4) {
                                deleteFile();
                            }
                            if (split.length == 2) {
                                String str3 = split[0];
                                String str4 = split[1];
                                ?? Zy2 = kascend.core.utils.c.Zy("ksdevice" + str3);
                                boolean equals2 = TextUtils.equals(str4, Zy2);
                                r0 = str3;
                                byteArrayOutputStream = Zy2;
                                if (!equals2) {
                                    deleteFile();
                                    byteArrayOutputStream2 = Zy2;
                                }
                                return r0;
                            }
                            deleteFile();
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            r0 = 0;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            return r0;
                        }
                        r0 = 0;
                        byteArrayOutputStream = byteArrayOutputStream;
                        return r0;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (r0 != 0) {
                        try {
                            r0.close();
                            String[] split4 = KSUtils.decrypt(new String(byteArrayOutputStream.toByteArray())).split(":");
                            if (split4.length != 2) {
                                deleteFile();
                            } else {
                                String str5 = split4[0];
                                if (TextUtils.equals(split4[1], kascend.core.utils.c.Zy("ksdevice" + str5))) {
                                    return str5;
                                }
                                deleteFile();
                            }
                            return null;
                        } catch (Exception e5) {
                            deleteFile();
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e6) {
                fileInputStream = null;
            } catch (IOException e7) {
                fileInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                r0 = 0;
                if (r0 != 0) {
                }
                throw th;
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                    split3 = KSUtils.decrypt(new String(byteArrayOutputStream.toByteArray())).split(":");
                } catch (Exception e8) {
                    deleteFile();
                }
                if (split3.length == 2) {
                    String str6 = split3[0];
                    String str7 = split3[1];
                    ?? Zy3 = kascend.core.utils.c.Zy("ksdevice" + str6);
                    boolean equals3 = TextUtils.equals(str7, Zy3);
                    r0 = str6;
                    byteArrayOutputStream = Zy3;
                    if (!equals3) {
                        deleteFile();
                        byteArrayOutputStream4 = Zy3;
                    }
                    return r0;
                }
                deleteFile();
                byteArrayOutputStream4 = byteArrayOutputStream;
                r0 = 0;
                byteArrayOutputStream = byteArrayOutputStream4;
                return r0;
            }
        }
        r0 = 0;
        byteArrayOutputStream = byteArrayOutputStream;
        return r0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [92=4] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // kascend.core.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Zw(String str) {
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.mFile.createNewFile();
            fileOutputStream = new FileOutputStream(this.mFile, false);
            try {
                try {
                    fileOutputStream.write(KSUtils.encrypt(String.format("%s:%s", str, kascend.core.utils.c.Zy("ksdevice" + str))).getBytes());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    private void deleteFile() {
        if (this.mFile != null && this.mFile.exists()) {
            this.mFile.delete();
        }
    }
}
