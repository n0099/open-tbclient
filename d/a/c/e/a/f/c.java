package d.a.c.e.a.f;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.p.l;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f39528a;

    /* renamed from: b  reason: collision with root package name */
    public BitmapFactory.Options f39529b;

    /* renamed from: c  reason: collision with root package name */
    public a f39530c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39531d;

    /* renamed from: e  reason: collision with root package name */
    public long f39532e;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: d  reason: collision with root package name */
        public static byte f39533d = Byte.MIN_VALUE;

        /* renamed from: e  reason: collision with root package name */
        public static byte f39534e = Byte.MIN_VALUE;

        /* renamed from: a  reason: collision with root package name */
        public boolean f39535a = false;

        /* renamed from: b  reason: collision with root package name */
        public long f39536b = 0;

        /* renamed from: c  reason: collision with root package name */
        public boolean f39537c = true;

        public static int a() {
            return 14;
        }

        public boolean b(byte[] bArr) {
            if (bArr == null || bArr.length < a()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, a());
            if (wrap.getInt() != 1786600511) {
                return false;
            }
            if ((wrap.get() & f39533d) != 0) {
                this.f39535a = true;
            }
            this.f39536b = wrap.getLong();
            if ((wrap.get() & f39534e) != 0) {
                this.f39537c = false;
            }
            return true;
        }

        public byte[] c() {
            ByteBuffer allocate = ByteBuffer.allocate(a());
            allocate.putInt(1786600511);
            allocate.put(this.f39535a ? (byte) (f39533d | 0) : (byte) 0);
            allocate.putLong(this.f39536b);
            allocate.put(this.f39537c ? (byte) 0 : (byte) (f39534e | 0));
            allocate.flip();
            return allocate.array();
        }
    }

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.f39528a = null;
        this.f39529b = null;
        this.f39530c = null;
        this.f39531d = true;
        this.f39530c = new a();
    }

    public byte[] a() {
        int a2 = a.a();
        int length = this.mData.length - a2;
        byte[] bArr = new byte[length];
        System.arraycopy(this.mData, a2, bArr, 0, length);
        return bArr;
    }

    public boolean b() {
        return this.f39530c.f39537c;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] buildFormatData() {
        if (this.mData == null || !this.f39531d) {
            return null;
        }
        return this.f39530c.c();
    }

    public void c(boolean z) {
        this.f39530c.f39537c = z;
    }

    public void d(boolean z) {
        this.f39531d = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void endLog() {
        d.a.c.e.l.a.k(isSuccess(), System.currentTimeMillis() - this.f39532e);
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        if (bArr != null && this.f39530c.b(bArr)) {
            long j = this.f39530c.f39536b;
            if (j == 0 || j >= System.currentTimeMillis()) {
                if (this.f39529b == null) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    this.f39529b = options;
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int a2 = a.a();
                try {
                    this.f39528a = BitmapFactory.decodeByteArray(bArr, a2, bArr.length - a2, this.f39529b);
                } catch (Error e2) {
                    BdLog.e(e2.getMessage());
                }
                return this.f39528a != null;
            }
        }
        return false;
    }

    public Bitmap getBitmap() {
        return this.f39528a;
    }

    public boolean isGif() {
        return this.f39530c.f39535a;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (isGif() || !l.B(bArr)) {
            return;
        }
        setGif(true);
    }

    public void setGif(boolean z) {
        this.f39530c.f39535a = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void startLog() {
        this.f39532e = System.currentTimeMillis();
    }
}
