package d.b.b;

import android.os.Build;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class h2 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f64300a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64301b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f64302c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64303d;

    public h2(boolean z, boolean z2) {
        this.f64301b = z;
        this.f64302c = z2;
        this.f64303d = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(String str, String str2) {
        RandomAccessFile randomAccessFile;
        byte[] bArr;
        int read;
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return str2;
        }
        String str3 = Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.snssdk.api.embed/cache";
        String str4 = str3 + "/" + str;
        FileLock fileLock = null;
        try {
            File file = new File(str3);
            if (file.exists() || file.mkdirs()) {
                File file2 = new File(str4);
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rwd");
                try {
                    fileLock = randomAccessFile2.getChannel().lock();
                    if (file2.isFile() && (read = randomAccessFile2.read((bArr = new byte[129]), 0, 129)) > 0 && read < 129) {
                        String str5 = new String(bArr, 0, read, "UTF-8");
                        if (j.n(str5)) {
                            if (fileLock != null) {
                                try {
                                    fileLock.release();
                                } catch (Exception unused) {
                                }
                            }
                            try {
                                randomAccessFile2.close();
                            } catch (Exception unused2) {
                            }
                            return str5;
                        }
                    }
                    byte[] bytes = str2.getBytes("UTF-8");
                    randomAccessFile2.setLength(0L);
                    randomAccessFile2.write(bytes);
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (Exception unused3) {
                        }
                    }
                    try {
                        randomAccessFile2.close();
                    } catch (Exception unused4) {
                    }
                    return str2;
                } catch (IOException e2) {
                    randomAccessFile = randomAccessFile2;
                    e = e2;
                    try {
                        if (Build.VERSION.SDK_INT >= 23) {
                            if (x1.f().f64405g.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
                                r0.b(e);
                            } else {
                                throw new SecurityException(e);
                            }
                        }
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (Exception unused5) {
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception unused6) {
                            }
                        }
                        return str2;
                    } catch (Throwable th) {
                        th = th;
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (Exception unused7) {
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception unused8) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    randomAccessFile = randomAccessFile2;
                    th = th2;
                    if (fileLock != null) {
                    }
                    if (randomAccessFile != null) {
                    }
                    throw th;
                }
            }
            return str2;
        } catch (IOException e3) {
            e = e3;
            randomAccessFile = null;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
    }

    public abstract boolean b(JSONObject jSONObject);

    public h2(boolean z, boolean z2, boolean z3) {
        this.f64301b = z;
        this.f64302c = z2;
        this.f64303d = z3;
    }
}
