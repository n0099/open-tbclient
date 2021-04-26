package d.a.h0.a.a2.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.a.h0.a.k;
import java.io.File;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes3.dex */
public abstract class a implements d {

    /* renamed from: c  reason: collision with root package name */
    public static final ReadWriteLock f41222c = new ReentrantReadWriteLock();

    /* renamed from: a  reason: collision with root package name */
    public File f41223a = d();

    /* renamed from: b  reason: collision with root package name */
    public final long f41224b = getMaxSize();

    @Override // d.a.h0.a.a2.f.d
    public boolean a(long j) {
        f41222c.readLock().lock();
        try {
            return e() + j > this.f41224b;
        } finally {
            f41222c.readLock().unlock();
        }
    }

    @Override // d.a.h0.a.a2.f.d
    public void b(long j) {
        f41222c.writeLock().lock();
        try {
            try {
                if (this.f41223a == null) {
                    this.f41223a = d();
                }
                File file = this.f41223a;
                if (!file.exists()) {
                    file.createNewFile();
                }
                d.a.h0.p.d.z(String.valueOf(e() + j).getBytes(), file);
            } catch (Exception e2) {
                if (k.f43101a) {
                    e2.printStackTrace();
                }
            }
        } finally {
            f41222c.writeLock().unlock();
        }
    }

    @NonNull
    public abstract String c();

    public final File d() {
        return new File(c() + File.separator + "record.pro");
    }

    public final long e() {
        if (this.f41223a == null) {
            this.f41223a = d();
        }
        File file = this.f41223a;
        if (file.exists() && file.isFile()) {
            String r = d.a.h0.p.d.r(file);
            try {
                if (!TextUtils.isEmpty(r) && TextUtils.isDigitsOnly(r.trim())) {
                    return Long.valueOf(r.trim()).longValue();
                }
            } catch (Exception e2) {
                if (k.f43101a) {
                    e2.printStackTrace();
                }
            }
        }
        return 0L;
    }
}
