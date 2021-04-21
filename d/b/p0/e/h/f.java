package d.b.p0.e.h;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public class f {
    public static long a(InputStream inputStream, OutputStream outputStream) {
        if (inputStream != null && outputStream != null) {
            try {
                byte[] bArr = new byte[3072];
                long j = 0;
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        j += read;
                    } else {
                        outputStream.flush();
                        return j;
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return 0L;
    }

    public static String b(File file) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                String c2 = c(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (IOException unused) {
                }
                return c2;
            } catch (FileNotFoundException unused2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable unused4) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                return null;
            }
        } catch (FileNotFoundException unused6) {
            fileInputStream = null;
        } catch (Throwable unused7) {
            fileInputStream = null;
        }
    }

    public static String c(@NonNull FileInputStream fileInputStream) {
        if (fileInputStream != null) {
            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        return sb.toString();
                    }
                }
            } catch (IOException unused) {
                return sb.toString();
            } catch (Throwable unused2) {
                return sb.toString();
            }
        } else {
            throw new NullPointerException("inputStream should not be null");
        }
    }

    public static boolean d(InputStream inputStream, File file, boolean z) {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, z);
            try {
                boolean z2 = a(inputStream, fileOutputStream2) != 0;
                try {
                    fileOutputStream2.close();
                } catch (IOException unused) {
                }
                return z2;
            } catch (FileNotFoundException unused2) {
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return false;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean e(String str, File file, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return d(new ByteArrayInputStream(str.getBytes()), file, z);
    }
}
