package d.b.b.e.a.f;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import d.b.b.e.p.l;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f41597a;

    /* renamed from: b  reason: collision with root package name */
    public BitmapFactory.Options f41598b;

    /* renamed from: c  reason: collision with root package name */
    public a f41599c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f41600d;

    /* renamed from: e  reason: collision with root package name */
    public long f41601e;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: d  reason: collision with root package name */
        public static byte f41602d = Byte.MIN_VALUE;

        /* renamed from: e  reason: collision with root package name */
        public static byte f41603e = Byte.MIN_VALUE;

        /* renamed from: a  reason: collision with root package name */
        public boolean f41604a = false;

        /* renamed from: b  reason: collision with root package name */
        public long f41605b = 0;

        /* renamed from: c  reason: collision with root package name */
        public boolean f41606c = true;

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
            if ((wrap.get() & f41602d) != 0) {
                this.f41604a = true;
            }
            this.f41605b = wrap.getLong();
            if ((wrap.get() & f41603e) != 0) {
                this.f41606c = false;
            }
            return true;
        }

        public byte[] c() {
            ByteBuffer allocate = ByteBuffer.allocate(a());
            allocate.putInt(1786600511);
            allocate.put(this.f41604a ? (byte) (f41602d | 0) : (byte) 0);
            allocate.putLong(this.f41605b);
            allocate.put(this.f41606c ? (byte) 0 : (byte) (f41603e | 0));
            allocate.flip();
            return allocate.array();
        }
    }

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.f41597a = null;
        this.f41598b = null;
        this.f41599c = null;
        this.f41600d = true;
        this.f41599c = new a();
    }

    public byte[] a() {
        int a2 = a.a();
        int length = this.mData.length - a2;
        byte[] bArr = new byte[length];
        System.arraycopy(this.mData, a2, bArr, 0, length);
        return bArr;
    }

    public boolean b() {
        return this.f41599c.f41606c;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] buildFormatData() {
        if (this.mData == null || !this.f41600d) {
            return null;
        }
        return this.f41599c.c();
    }

    public void c(boolean z) {
        this.f41599c.f41606c = z;
    }

    public void d(boolean z) {
        this.f41600d = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void endLog() {
        d.b.b.e.l.a.k(isSuccess(), System.currentTimeMillis() - this.f41601e);
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        if (bArr != null && this.f41599c.b(bArr)) {
            long j = this.f41599c.f41605b;
            if (j == 0 || j >= System.currentTimeMillis()) {
                if (this.f41598b == null) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    this.f41598b = options;
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int a2 = a.a();
                try {
                    this.f41597a = BitmapFactory.decodeByteArray(bArr, a2, bArr.length - a2, this.f41598b);
                } catch (Error e2) {
                    BdLog.e(e2.getMessage());
                }
                return this.f41597a != null;
            }
        }
        return false;
    }

    public Bitmap getBitmap() {
        return this.f41597a;
    }

    public boolean isGif() {
        return this.f41599c.f41604a;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (isGif() || !l.A(bArr)) {
            return;
        }
        setGif(true);
    }

    public void setGif(boolean z) {
        this.f41599c.f41604a = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void startLog() {
        this.f41601e = System.currentTimeMillis();
    }
}
