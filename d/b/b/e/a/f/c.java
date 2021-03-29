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
    public Bitmap f41598a;

    /* renamed from: b  reason: collision with root package name */
    public BitmapFactory.Options f41599b;

    /* renamed from: c  reason: collision with root package name */
    public a f41600c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f41601d;

    /* renamed from: e  reason: collision with root package name */
    public long f41602e;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: d  reason: collision with root package name */
        public static byte f41603d = Byte.MIN_VALUE;

        /* renamed from: e  reason: collision with root package name */
        public static byte f41604e = Byte.MIN_VALUE;

        /* renamed from: a  reason: collision with root package name */
        public boolean f41605a = false;

        /* renamed from: b  reason: collision with root package name */
        public long f41606b = 0;

        /* renamed from: c  reason: collision with root package name */
        public boolean f41607c = true;

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
            if ((wrap.get() & f41603d) != 0) {
                this.f41605a = true;
            }
            this.f41606b = wrap.getLong();
            if ((wrap.get() & f41604e) != 0) {
                this.f41607c = false;
            }
            return true;
        }

        public byte[] c() {
            ByteBuffer allocate = ByteBuffer.allocate(a());
            allocate.putInt(1786600511);
            allocate.put(this.f41605a ? (byte) (f41603d | 0) : (byte) 0);
            allocate.putLong(this.f41606b);
            allocate.put(this.f41607c ? (byte) 0 : (byte) (f41604e | 0));
            allocate.flip();
            return allocate.array();
        }
    }

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.f41598a = null;
        this.f41599b = null;
        this.f41600c = null;
        this.f41601d = true;
        this.f41600c = new a();
    }

    public byte[] a() {
        int a2 = a.a();
        int length = this.mData.length - a2;
        byte[] bArr = new byte[length];
        System.arraycopy(this.mData, a2, bArr, 0, length);
        return bArr;
    }

    public boolean b() {
        return this.f41600c.f41607c;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] buildFormatData() {
        if (this.mData == null || !this.f41601d) {
            return null;
        }
        return this.f41600c.c();
    }

    public void c(boolean z) {
        this.f41600c.f41607c = z;
    }

    public void d(boolean z) {
        this.f41601d = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void endLog() {
        d.b.b.e.l.a.k(isSuccess(), System.currentTimeMillis() - this.f41602e);
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        if (bArr != null && this.f41600c.b(bArr)) {
            long j = this.f41600c.f41606b;
            if (j == 0 || j >= System.currentTimeMillis()) {
                if (this.f41599b == null) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    this.f41599b = options;
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int a2 = a.a();
                try {
                    this.f41598a = BitmapFactory.decodeByteArray(bArr, a2, bArr.length - a2, this.f41599b);
                } catch (Error e2) {
                    BdLog.e(e2.getMessage());
                }
                return this.f41598a != null;
            }
        }
        return false;
    }

    public Bitmap getBitmap() {
        return this.f41598a;
    }

    public boolean isGif() {
        return this.f41600c.f41605a;
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
        this.f41600c.f41605a = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void startLog() {
        this.f41602e = System.currentTimeMillis();
    }
}
