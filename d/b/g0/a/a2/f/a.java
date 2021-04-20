package d.b.g0.a.a2.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.b.g0.a.k;
import java.io.File;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes3.dex */
public abstract class a implements d {

    /* renamed from: c  reason: collision with root package name */
    public static final ReadWriteLock f43623c = new ReentrantReadWriteLock();

    /* renamed from: a  reason: collision with root package name */
    public File f43624a = d();

    /* renamed from: b  reason: collision with root package name */
    public final long f43625b = getMaxSize();

    @Override // d.b.g0.a.a2.f.d
    public boolean a(long j) {
        f43623c.readLock().lock();
        try {
            return e() + j > this.f43625b;
        } finally {
            f43623c.readLock().unlock();
        }
    }

    @Override // d.b.g0.a.a2.f.d
    public void b(long j) {
        f43623c.writeLock().lock();
        try {
            try {
                if (this.f43624a == null) {
                    this.f43624a = d();
                }
                File file = this.f43624a;
                if (!file.exists()) {
                    file.createNewFile();
                }
                d.b.g0.p.d.z(String.valueOf(e() + j).getBytes(), file);
            } catch (Exception e2) {
                if (k.f45443a) {
                    e2.printStackTrace();
                }
            }
        } finally {
            f43623c.writeLock().unlock();
        }
    }

    @NonNull
    public abstract String c();

    public final File d() {
        return new File(c() + File.separator + "record.pro");
    }

    public final long e() {
        if (this.f43624a == null) {
            this.f43624a = d();
        }
        File file = this.f43624a;
        if (file.exists() && file.isFile()) {
            String r = d.b.g0.p.d.r(file);
            try {
                if (!TextUtils.isEmpty(r) && TextUtils.isDigitsOnly(r.trim())) {
                    return Long.valueOf(r.trim()).longValue();
                }
            } catch (Exception e2) {
                if (k.f45443a) {
                    e2.printStackTrace();
                }
            }
        }
        return 0L;
    }
}
