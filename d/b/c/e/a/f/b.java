package d.b.c.e.a.f;

import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import d.b.c.e.a.f.c;
import java.io.ByteArrayInputStream;
/* loaded from: classes.dex */
public class b extends c {

    /* renamed from: f  reason: collision with root package name */
    public Rect f42334f;

    public b(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.f42334f = null;
        this.f42334f = new Rect();
    }

    public Rect e() {
        return this.f42334f;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0077 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0078 A[RETURN] */
    @Override // d.b.c.e.a.f.c, com.baidu.adp.lib.Disk.ops.DiskFileOperate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean formatData(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        if (bArr != null && this.f42337c.b(bArr)) {
            long j = this.f42337c.f42343b;
            if (j == 0 || j >= System.currentTimeMillis()) {
                if (this.f42336b == null) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    this.f42336b = options;
                    options.inDither = false;
                    int i = BdBaseApplication.getInst().getContext().getResources().getDisplayMetrics().densityDpi;
                    BitmapFactory.Options options2 = this.f42336b;
                    options2.inScreenDensity = i;
                    options2.inTargetDensity = i;
                    options2.inDensity = i;
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
                    this.f42335a = BitmapFactory.decodeStream(byteArrayInputStream, this.f42334f, this.f42336b);
                    d.b.c.e.m.a.c(byteArrayInputStream);
                } catch (Error e3) {
                    e = e3;
                    byteArrayInputStream2 = byteArrayInputStream;
                    BdLog.e(e.getMessage());
                    d.b.c.e.m.a.c(byteArrayInputStream2);
                    if (this.f42335a == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayInputStream2 = byteArrayInputStream;
                    d.b.c.e.m.a.c(byteArrayInputStream2);
                    throw th;
                }
                return this.f42335a == null;
            }
        }
        return false;
    }
}
