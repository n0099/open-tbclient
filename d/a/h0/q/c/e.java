package d.a.h0.q.c;

import android.content.Context;
import android.os.Build;
import android.system.Os;
import java.io.File;
import java.io.FileOutputStream;
/* loaded from: classes3.dex */
public class e implements b<String> {

    /* renamed from: a  reason: collision with root package name */
    public Context f47599a;

    public e(Context context) {
        if (context != null) {
            this.f47599a = context.getApplicationContext();
            return;
        }
        throw new RuntimeException("context can not be null");
    }

    @Override // d.a.h0.q.c.b
    public boolean a() {
        return !new File(this.f47599a.getFilesDir(), "libuuid.so").exists();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.q.c.b
    /* renamed from: b */
    public String get() {
        return d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.q.c.b
    /* renamed from: c */
    public void put(String str) {
        e(str);
    }

    public final String d() {
        File file = new File(this.f47599a.getFilesDir(), "libuuid.so");
        if (file.exists()) {
            return d.a.h0.q.d.a.c(file);
        }
        return null;
    }

    public final void e(String str) {
        File file = new File(this.f47599a.getFilesDir(), "libuuid.so");
        int i2 = Build.VERSION.SDK_INT >= 24 ? 1 : 0;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = this.f47599a.openFileOutput("libuuid.so", i2 ^ 1);
                fileOutputStream.write(str.getBytes());
                fileOutputStream.flush();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (i2 != 0) {
                try {
                    Os.chmod(file.getAbsolutePath(), 436);
                } catch (Exception unused) {
                }
            }
        } finally {
            d.a.h0.q.d.a.a(fileOutputStream);
        }
    }
}
