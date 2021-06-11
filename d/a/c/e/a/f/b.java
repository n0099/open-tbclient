package d.a.c.e.a.f;

import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.a.f.c;
import java.io.ByteArrayInputStream;
/* loaded from: classes.dex */
public class b extends c {

    /* renamed from: f  reason: collision with root package name */
    public Rect f42089f;

    public b(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.f42089f = null;
        this.f42089f = new Rect();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0077 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0078 A[RETURN] */
    @Override // d.a.c.e.a.f.c, com.baidu.adp.lib.Disk.ops.DiskFileOperate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean formatData(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        if (bArr != null && this.f42092c.b(bArr)) {
            long j = this.f42092c.f42098b;
            if (j == 0 || j >= System.currentTimeMillis()) {
                if (this.f42091b == null) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    this.f42091b = options;
                    options.inDither = false;
                    int i2 = BdBaseApplication.getInst().getContext().getResources().getDisplayMetrics().densityDpi;
                    BitmapFactory.Options options2 = this.f42091b;
                    options2.inScreenDensity = i2;
                    options2.inTargetDensity = i2;
                    options2.inDensity = i2;
                }
                int a2 = c.a.a();
                ByteArrayInputStream byteArrayInputStream2 = null;
                try {
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(bArr, a2, bArr.length - a2);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Error e2) {
                    e = e2;
                }
                try {
                    this.f42090a = BitmapFactory.decodeStream(byteArrayInputStream, this.f42089f, this.f42091b);
                    d.a.c.e.m.a.c(byteArrayInputStream);
                } catch (Error e3) {
                    e = e3;
                    byteArrayInputStream2 = byteArrayInputStream;
                    BdLog.e(e.getMessage());
                    d.a.c.e.m.a.c(byteArrayInputStream2);
                    if (this.f42090a == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayInputStream2 = byteArrayInputStream;
                    d.a.c.e.m.a.c(byteArrayInputStream2);
                    throw th;
                }
                return this.f42090a == null;
            }
        }
        return false;
    }

    public Rect g() {
        return this.f42089f;
    }
}
