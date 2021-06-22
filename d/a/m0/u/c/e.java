package d.a.m0.u.c;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.system.Os;
import java.io.File;
import java.io.FileOutputStream;
/* loaded from: classes3.dex */
public class e implements b<String> {

    /* renamed from: a  reason: collision with root package name */
    public Context f52287a;

    public e(Context context) {
        this.f52287a = context.getApplicationContext();
    }

    @Override // d.a.m0.u.c.b
    public boolean a() {
        return !new File(this.f52287a.getFilesDir(), "libuuid.so").exists();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.u.c.b
    /* renamed from: b */
    public String get() {
        return d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.u.c.b
    /* renamed from: c */
    public void put(String str) {
        e(str);
    }

    public final String d() {
        File file = new File(this.f52287a.getFilesDir(), "libuuid.so");
        if (file.exists()) {
            return d.a.m0.u.d.a.c(file);
        }
        return null;
    }

    @SuppressLint({"WorldReadableFiles"})
    @TargetApi(21)
    public final void e(String str) {
        File file = new File(this.f52287a.getFilesDir(), "libuuid.so");
        int i2 = Build.VERSION.SDK_INT >= 24 ? 1 : 0;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = this.f52287a.openFileOutput("libuuid.so", i2 ^ 1);
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
            d.a.m0.u.d.a.a(fileOutputStream);
        }
    }
}
