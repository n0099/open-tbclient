package d.a.i0.a.k2.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.a.i0.a.k;
import java.io.File;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes3.dex */
public abstract class a implements e {

    /* renamed from: c  reason: collision with root package name */
    public static final ReadWriteLock f43062c = new ReentrantReadWriteLock();

    /* renamed from: a  reason: collision with root package name */
    public File f43063a = d();

    /* renamed from: b  reason: collision with root package name */
    public final long f43064b = getMaxSize();

    @Override // d.a.i0.a.k2.f.e
    public boolean a(long j) {
        f43062c.readLock().lock();
        try {
            return e() + j > this.f43064b;
        } finally {
            f43062c.readLock().unlock();
        }
    }

    @Override // d.a.i0.a.k2.f.e
    public void b(long j) {
        f43062c.writeLock().lock();
        try {
            try {
                if (this.f43063a == null) {
                    this.f43063a = d();
                }
                File file = this.f43063a;
                if (!file.exists()) {
                    file.createNewFile();
                }
                d.a.i0.t.d.N(String.valueOf(e() + j).getBytes(), file);
            } catch (Exception e2) {
                if (k.f43025a) {
                    e2.printStackTrace();
                }
            }
        } finally {
            f43062c.writeLock().unlock();
        }
    }

    @NonNull
    public abstract String c();

    public final File d() {
        return new File(c() + File.separator + "record.pro");
    }

    public final long e() {
        if (this.f43063a == null) {
            this.f43063a = d();
        }
        File file = this.f43063a;
        if (file.exists() && file.isFile()) {
            String D = d.a.i0.t.d.D(file);
            try {
                if (!TextUtils.isEmpty(D) && TextUtils.isDigitsOnly(D.trim())) {
                    return Long.valueOf(D.trim()).longValue();
                }
            } catch (Exception e2) {
                if (k.f43025a) {
                    e2.printStackTrace();
                }
            }
        }
        return 0L;
    }
}
