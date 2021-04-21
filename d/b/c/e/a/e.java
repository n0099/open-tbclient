package d.b.c.e.a;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public d.b.c.e.a.b f42329a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f42330b;

    /* renamed from: c  reason: collision with root package name */
    public DiskFileOperate f42331c;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f42332a;

        static {
            int[] iArr = new int[DiskFileOperate.Action.values().length];
            f42332a = iArr;
            try {
                iArr[DiskFileOperate.Action.WRITE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f42332a[DiskFileOperate.Action.WRITE_FORCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f42332a[DiskFileOperate.Action.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f42332a[DiskFileOperate.Action.DELETE_FILES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f42332a[DiskFileOperate.Action.APPEND.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f42332a[DiskFileOperate.Action.APPEND_MORE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f42332a[DiskFileOperate.Action.INFO.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f42332a[DiskFileOperate.Action.RENAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f42332a[DiskFileOperate.Action.READ.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f42332a[DiskFileOperate.Action.CUSTOM.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean a(e eVar, DiskFileOperate diskFileOperate, d.b.c.e.a.b bVar);
    }

    public e(d.b.c.e.a.b bVar, DiskFileOperate diskFileOperate) {
        this.f42329a = null;
        this.f42330b = null;
        this.f42331c = null;
        if (bVar != null && diskFileOperate != null && diskFileOperate.getAction() != null) {
            this.f42330b = new AtomicBoolean(false);
            this.f42329a = bVar;
            this.f42331c = diskFileOperate;
            return;
        }
        throw new InvalidParameterException("DiskWorker Parameter is null");
    }

    public boolean a(boolean z) {
        OutputStream outputStream = this.f42331c.getOutputStream();
        File fileInfo = this.f42331c.getFileInfo();
        try {
            if (outputStream == null) {
                try {
                    fileInfo = this.f42329a.c(this.f42331c.buildPath(), this.f42331c.getName(), true, this.f42331c.isSdCard(), this.f42331c.isSavedCache());
                    if (fileInfo != null && !this.f42330b.get()) {
                        outputStream = new FileOutputStream(fileInfo, true);
                    }
                    this.f42331c.unLock();
                    return false;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    if (!z) {
                        d.b.c.e.m.a.d(outputStream);
                    }
                    this.f42331c.unLock();
                    return false;
                }
            }
            byte[] buildFormatData = this.f42331c.buildFormatData();
            byte[] data = this.f42331c.getData();
            if ((buildFormatData == null && data == null) || this.f42330b.get()) {
                if (!z) {
                    d.b.c.e.m.a.d(outputStream);
                }
                this.f42331c.unLock();
                return false;
            }
            if (buildFormatData != null) {
                outputStream.write(buildFormatData);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.f42331c.setFileInfo(fileInfo);
            this.f42331c.setSuccess(true);
            if (!z) {
                d.b.c.e.m.a.d(outputStream);
            } else {
                this.f42331c.setOutputStream(outputStream);
            }
            this.f42331c.unLock();
            return true;
        } catch (Throwable th) {
            if (!z) {
                d.b.c.e.m.a.d(outputStream);
            }
            this.f42331c.unLock();
            throw th;
        }
    }

    public boolean b() {
        switch (a.f42332a[this.f42331c.getAction().ordinal()]) {
            case 1:
                return k(false);
            case 2:
                return k(true);
            case 3:
                return e();
            case 4:
                return g();
            case 5:
                return a(false);
            case 6:
                return a(true);
            case 7:
                return h();
            case 8:
                return j();
            case 9:
                return i();
            case 10:
                return d();
            default:
                return false;
        }
    }

    public void c() {
        this.f42330b.set(true);
    }

    public boolean d() {
        try {
            try {
                r0 = this.f42331c.getCustomOperate() != null ? this.f42331c.getCustomOperate().a(this, this.f42331c, this.f42329a) : false;
                if (r0) {
                    this.f42331c.setSuccess(true);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            return r0;
        } finally {
            this.f42331c.unLock();
        }
    }

    public final boolean e() {
        File c2;
        try {
            try {
                c2 = this.f42329a.c(this.f42331c.buildPath(), this.f42331c.getName(), false, this.f42331c.isSdCard(), this.f42331c.isSavedCache());
            } catch (Exception e2) {
                e2.getMessage();
            }
            if (c2 != null && !this.f42330b.get()) {
                r0 = c2.exists() ? c2.delete() : false;
                if (r0) {
                    this.f42331c.setFileInfo(c2);
                    this.f42331c.setSuccess(true);
                }
                return r0;
            }
            return false;
        } finally {
            this.f42331c.unLock();
        }
    }

    public final boolean f(File file) {
        if (file != null) {
            DiskFileOperate diskFileOperate = this.f42331c;
            if (diskFileOperate instanceof d.b.c.e.a.a) {
                d.b.c.e.a.a aVar = (d.b.c.e.a.a) diskFileOperate;
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (int i = 0; i < listFiles.length && !this.f42330b.get(); i++) {
                            if (listFiles[i].isDirectory()) {
                                f(listFiles[i]);
                            } else if (aVar.compare(listFiles[i])) {
                                listFiles[i].delete();
                            }
                        }
                    }
                    file.delete();
                } else if (aVar.compare(file)) {
                    file.delete();
                }
                return true;
            }
        }
        return false;
    }

    public final boolean g() {
        boolean z = false;
        try {
            try {
                File d2 = this.f42329a.d(this.f42331c.getPath(), false, this.f42331c.isSdCard(), this.f42331c.isSavedCache());
                z = f(d2);
                if (z) {
                    this.f42331c.setFileInfo(d2);
                    this.f42331c.setSuccess(true);
                }
            } catch (Exception e2) {
                e2.getMessage();
            }
            return z;
        } finally {
            this.f42331c.unLock();
        }
    }

    public boolean h() {
        File d2;
        if (this.f42331c.getName() != null) {
            d2 = this.f42329a.c(this.f42331c.buildPath(), this.f42331c.getName(), false, this.f42331c.isSdCard(), this.f42331c.isSavedCache());
        } else {
            d2 = this.f42329a.d(this.f42331c.buildPath(), false, this.f42331c.isSdCard(), this.f42331c.isSavedCache());
        }
        if (d2 != null && d2.exists()) {
            this.f42331c.setFileInfo(d2);
            this.f42331c.setSuccess(true);
            this.f42331c.unLock();
            return true;
        }
        this.f42331c.unLock();
        return false;
    }

    public final boolean i() {
        OutputStream outputStream;
        FileInputStream fileInputStream;
        Exception e2;
        ByteArrayOutputStream byteArrayOutputStream;
        File c2;
        this.f42331c.startLog();
        boolean z = false;
        try {
            try {
                c2 = this.f42329a.c(this.f42331c.buildPath(), this.f42331c.getName(), false, this.f42331c.isSdCard(), this.f42331c.isSavedCache());
            } catch (Throwable th) {
                th = th;
                d.b.c.e.m.a.c(fileInputStream);
                d.b.c.e.m.a.d(outputStream);
                this.f42331c.unLock();
                throw th;
            }
        } catch (Exception e3) {
            fileInputStream = null;
            e2 = e3;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
            fileInputStream = null;
        }
        if (c2 != null && c2.exists() && !this.f42330b.get()) {
            fileInputStream = new FileInputStream(c2);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(1024);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read == -1 || this.f42330b.get()) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (!this.f42330b.get()) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (!this.f42331c.isFormatData() || this.f42331c.formatData(byteArray)) {
                            this.f42331c.setData(byteArray);
                            z = true;
                        }
                    }
                    d.b.c.e.m.a.c(fileInputStream);
                    d.b.c.e.m.a.d(byteArrayOutputStream);
                    if (z) {
                        this.f42331c.setSuccess(true);
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    BdLog.e(e2.getMessage());
                    d.b.c.e.m.a.c(fileInputStream);
                    d.b.c.e.m.a.d(byteArrayOutputStream);
                    this.f42331c.unLock();
                    this.f42331c.endLog();
                    return z;
                }
            } catch (Exception e5) {
                byteArrayOutputStream = null;
                e2 = e5;
            } catch (Throwable th3) {
                th = th3;
                outputStream = null;
                th = th;
                d.b.c.e.m.a.c(fileInputStream);
                d.b.c.e.m.a.d(outputStream);
                this.f42331c.unLock();
                throw th;
            }
            this.f42331c.unLock();
            this.f42331c.endLog();
            return z;
        }
        d.b.c.e.m.a.c(null);
        d.b.c.e.m.a.d(null);
        this.f42331c.unLock();
        return false;
    }

    public boolean j() {
        boolean z = false;
        try {
            try {
                File c2 = this.f42329a.c(this.f42331c.buildPath(), this.f42331c.getName(), false, this.f42331c.isSdCard(), this.f42331c.isSavedCache());
                File c3 = this.f42329a.c(this.f42331c.buildDesPath(), this.f42331c.getDesName(), true, this.f42331c.isSdCard(), this.f42331c.isSavedCache());
                if (c2 != null) {
                    if (c3 != null) {
                        c3.delete();
                    }
                    z = c2.renameTo(c3);
                }
                if (z) {
                    this.f42331c.setSuccess(true);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            return z;
        } finally {
            this.f42331c.unLock();
        }
    }

    public boolean k(boolean z) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File c2 = this.f42329a.c(this.f42331c.buildPath(), this.f42331c.getName(), true, this.f42331c.isSdCard(), this.f42331c.isSavedCache());
                if (c2 != null && !this.f42330b.get()) {
                    if (c2.exists()) {
                        if (z) {
                            c2.delete();
                        } else {
                            d.b.c.e.m.a.d(null);
                            this.f42331c.unLock();
                            return true;
                        }
                    }
                    byte[] buildFormatData = this.f42331c.buildFormatData();
                    byte[] data = this.f42331c.getData();
                    if ((buildFormatData != null || data != null) && !this.f42330b.get()) {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(c2);
                        if (buildFormatData != null) {
                            try {
                                fileOutputStream2.write(buildFormatData);
                            } catch (Exception e2) {
                                e = e2;
                                fileOutputStream = fileOutputStream2;
                                BdLog.e(e.getMessage());
                                d.b.c.e.m.a.d(fileOutputStream);
                                this.f42331c.unLock();
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                d.b.c.e.m.a.d(fileOutputStream);
                                this.f42331c.unLock();
                                throw th;
                            }
                        }
                        if (data != null) {
                            fileOutputStream2.write(data);
                        }
                        fileOutputStream2.flush();
                        d.b.c.e.m.a.d(fileOutputStream2);
                        this.f42331c.setFileInfo(c2);
                        this.f42331c.setSuccess(true);
                        this.f42331c.unLock();
                        return true;
                    }
                }
                d.b.c.e.m.a.d(null);
                this.f42331c.unLock();
                return false;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }
}
