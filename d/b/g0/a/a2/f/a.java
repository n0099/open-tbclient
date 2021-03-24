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
    public static final ReadWriteLock f43230c = new ReentrantReadWriteLock();

    /* renamed from: a  reason: collision with root package name */
    public File f43231a = d();

    /* renamed from: b  reason: collision with root package name */
    public final long f43232b = getMaxSize();

    @Override // d.b.g0.a.a2.f.d
    public boolean a(long j) {
        f43230c.readLock().lock();
        try {
            return e() + j > this.f43232b;
        } finally {
            f43230c.readLock().unlock();
        }
    }

    @Override // d.b.g0.a.a2.f.d
    public void b(long j) {
        f43230c.writeLock().lock();
        try {
            try {
                if (this.f43231a == null) {
                    this.f43231a = d();
                }
                File file = this.f43231a;
                if (!file.exists()) {
                    file.createNewFile();
                }
                d.b.g0.p.d.z(String.valueOf(e() + j).getBytes(), file);
            } catch (Exception e2) {
                if (k.f45050a) {
                    e2.printStackTrace();
                }
            }
        } finally {
            f43230c.writeLock().unlock();
        }
    }

    @NonNull
    public abstract String c();

    public final File d() {
        return new File(c() + File.separator + "record.pro");
    }

    public final long e() {
        if (this.f43231a == null) {
            this.f43231a = d();
        }
        File file = this.f43231a;
        if (file.exists() && file.isFile()) {
            String r = d.b.g0.p.d.r(file);
            try {
                if (!TextUtils.isEmpty(r) && TextUtils.isDigitsOnly(r.trim())) {
                    return Long.valueOf(r.trim()).longValue();
                }
            } catch (Exception e2) {
                if (k.f45050a) {
                    e2.printStackTrace();
                }
            }
        }
        return 0L;
    }
}
