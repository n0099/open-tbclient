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
    public Bitmap f42193a;

    /* renamed from: b  reason: collision with root package name */
    public BitmapFactory.Options f42194b;

    /* renamed from: c  reason: collision with root package name */
    public a f42195c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42196d;

    /* renamed from: e  reason: collision with root package name */
    public long f42197e;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: d  reason: collision with root package name */
        public static byte f42198d = Byte.MIN_VALUE;

        /* renamed from: e  reason: collision with root package name */
        public static byte f42199e = Byte.MIN_VALUE;

        /* renamed from: a  reason: collision with root package name */
        public boolean f42200a = false;

        /* renamed from: b  reason: collision with root package name */
        public long f42201b = 0;

        /* renamed from: c  reason: collision with root package name */
        public boolean f42202c = true;

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
            if ((wrap.get() & f42198d) != 0) {
                this.f42200a = true;
            }
            this.f42201b = wrap.getLong();
            if ((wrap.get() & f42199e) != 0) {
                this.f42202c = false;
            }
            return true;
        }

        public byte[] c() {
            ByteBuffer allocate = ByteBuffer.allocate(a());
            allocate.putInt(1786600511);
            allocate.put(this.f42200a ? (byte) (f42198d | 0) : (byte) 0);
            allocate.putLong(this.f42201b);
            allocate.put(this.f42202c ? (byte) 0 : (byte) (f42199e | 0));
            allocate.flip();
            return allocate.array();
        }
    }

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.f42193a = null;
        this.f42194b = null;
        this.f42195c = null;
        this.f42196d = true;
        this.f42195c = new a();
    }

    public static int a(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        int i6 = 1;
        if (i4 > i3 || i5 > i2) {
            int i7 = i4 / 2;
            int i8 = i5 / 2;
            while (i7 / i6 >= i3 && i8 / i6 >= i2) {
                i6 *= 2;
            }
        }
        return i6;
    }

    public boolean b(byte[] bArr, int i2, int i3) {
        if (bArr != null && this.f42195c.b(bArr)) {
            long j = this.f42195c.f42201b;
            if (j == 0 || j >= System.currentTimeMillis()) {
                int a2 = a.a();
                try {
                    if (this.f42194b == null) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        this.f42194b = options;
                        options.inPreferredConfig = Bitmap.Config.RGB_565;
                    }
                    this.f42194b.inJustDecodeBounds = true;
                    BitmapFactory.decodeByteArray(bArr, a2, bArr.length - a2, this.f42194b);
                } catch (Error e2) {
                    BdLog.e(e2.getMessage());
                }
                if (!this.f42194b.mCancel && this.f42194b.outWidth != -1 && this.f42194b.outHeight != -1) {
                    this.f42194b.inSampleSize = a(this.f42194b, i2, i3);
                    this.f42194b.inJustDecodeBounds = false;
                    this.f42193a = BitmapFactory.decodeByteArray(bArr, a2, bArr.length - a2, this.f42194b);
                    return this.f42193a != null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] buildFormatData() {
        if (this.mData == null || !this.f42196d) {
            return null;
        }
        return this.f42195c.c();
    }

    public byte[] c() {
        int a2 = a.a();
        int length = this.mData.length - a2;
        byte[] bArr = new byte[length];
        System.arraycopy(this.mData, a2, bArr, 0, length);
        return bArr;
    }

    public boolean d() {
        return this.f42195c.f42202c;
    }

    public void e(boolean z) {
        this.f42195c.f42202c = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void endLog() {
        d.a.c.e.l.a.k(isSuccess(), System.currentTimeMillis() - this.f42197e);
    }

    public void f(boolean z) {
        this.f42196d = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        if (bArr != null && this.f42195c.b(bArr)) {
            long j = this.f42195c.f42201b;
            if (j == 0 || j >= System.currentTimeMillis()) {
                if (this.f42194b == null) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    this.f42194b = options;
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int a2 = a.a();
                try {
                    this.f42193a = BitmapFactory.decodeByteArray(bArr, a2, bArr.length - a2, this.f42194b);
                } catch (Error e2) {
                    BdLog.e(e2.getMessage());
                }
                return this.f42193a != null;
            }
        }
        return false;
    }

    public Bitmap getBitmap() {
        return this.f42193a;
    }

    public boolean isGif() {
        return this.f42195c.f42200a;
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
        this.f42195c.f42200a = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void startLog() {
        this.f42197e = System.currentTimeMillis();
    }
}
