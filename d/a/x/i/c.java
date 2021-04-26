package d.a.x.i;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class c {
    public static boolean a(Context context, String str, String str2) {
        FileOutputStream fileOutputStream;
        try {
            if (context == null) {
                if (b.a()) {
                    Log.e("FileUtil", "copyAssetsTo: context is null");
                }
                return false;
            }
            InputStream open = context.getAssets().open(str);
            if (open == null) {
            }
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
            }
            try {
                byte[] bArr = new byte[4096];
                if (open == null) {
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException unused) {
                        }
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                    }
                    return false;
                }
                while (true) {
                    int read = open.read(bArr);
                    if (read < 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException unused3) {
                    }
                }
                try {
                    fileOutputStream.close();
                    return true;
                } catch (IOException unused4) {
                    return true;
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                if (b.a()) {
                    Log.e("FileUtil", "copyAssetsTo: destOutputStream e=" + e.toString());
                }
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException unused5) {
                    }
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused6) {
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException unused7) {
                    }
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused8) {
                    }
                }
                throw th;
            }
        } catch (IOException e4) {
            if (b.a()) {
                Log.e("FileUtil", "copyAssetsTo: sourceInputStream e=" + e4.toString());
            }
            return false;
        } finally {
            Log.e("FileUtil", "copyAssetsTo: sourceInputStream is null");
        }
    }

    public static boolean b(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                if (file2.exists()) {
                    file2.delete();
                }
                fileOutputStream2 = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read >= 0) {
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            fileOutputStream2.flush();
                            try {
                                fileInputStream2.close();
                                fileOutputStream2.close();
                                return true;
                            } catch (IOException unused) {
                                return true;
                            }
                        }
                    }
                } catch (FileNotFoundException unused2) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                            return false;
                        }
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    return false;
                } catch (IOException unused4) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused5) {
                            return false;
                        }
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    return false;
                } catch (Throwable th) {
                    fileInputStream = fileInputStream2;
                    fileOutputStream = fileOutputStream2;
                    th = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused6) {
                            throw th;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused7) {
                fileOutputStream2 = null;
            } catch (IOException unused8) {
                fileOutputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
            }
        } catch (FileNotFoundException unused9) {
            fileOutputStream2 = null;
        } catch (IOException unused10) {
            fileOutputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public static boolean c(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        if (inputStream != null && file != null) {
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read < 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (IOException unused2) {
                }
                return true;
            } catch (IOException unused3) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }
        return false;
    }

    public static File d(Context context, String str) {
        return new File(i(context), str);
    }

    public static File e(Context context, String str) {
        File file = new File(f(context, str), "lib");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File f(Context context, String str) {
        File file = new File(i(context), str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File g(Context context, String str) {
        return new File(h(context), str);
    }

    public static File h(Context context) {
        File dir = context.getDir("nps_download", 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }

    public static File i(Context context) {
        File dir = context.getDir("nps", 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }
}
