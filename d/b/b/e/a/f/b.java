package d.b.b.e.a.f;

import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import d.b.b.e.a.f.c;
import java.io.ByteArrayInputStream;
/* loaded from: classes.dex */
public class b extends c {

    /* renamed from: f  reason: collision with root package name */
    public Rect f41597f;

    public b(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.f41597f = null;
        this.f41597f = new Rect();
    }

    public Rect e() {
        return this.f41597f;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0077 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0078 A[RETURN] */
    @Override // d.b.b.e.a.f.c, com.baidu.adp.lib.Disk.ops.DiskFileOperate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean formatData(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        if (bArr != null && this.f41600c.b(bArr)) {
            long j = this.f41600c.f41606b;
            if (j == 0 || j >= System.currentTimeMillis()) {
                if (this.f41599b == null) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    this.f41599b = options;
                    options.inDither = false;
                    int i = BdBaseApplication.getInst().getContext().getResources().getDisplayMetrics().densityDpi;
                    BitmapFactory.Options options2 = this.f41599b;
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
                    this.f41598a = BitmapFactory.decodeStream(byteArrayInputStream, this.f41597f, this.f41599b);
                    d.b.b.e.m.a.c(byteArrayInputStream);
                } catch (Error e3) {
                    e = e3;
                    byteArrayInputStream2 = byteArrayInputStream;
                    BdLog.e(e.getMessage());
                    d.b.b.e.m.a.c(byteArrayInputStream2);
                    if (this.f41598a == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayInputStream2 = byteArrayInputStream;
                    d.b.b.e.m.a.c(byteArrayInputStream2);
                    throw th;
                }
                return this.f41598a == null;
            }
        }
        return false;
    }
}
