package d.b.g0.q.c;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
/* loaded from: classes3.dex */
public class a implements b<String> {

    /* renamed from: a  reason: collision with root package name */
    public Context f49343a;

    public a(Context context) {
        if (context != null) {
            this.f49343a = context.getApplicationContext();
            return;
        }
        throw new RuntimeException("context can no be null");
    }

    @Override // d.b.g0.q.c.b
    public boolean a() {
        if (TextUtils.equals("mounted", Environment.getExternalStorageState()) && d.b.g0.q.d.c.a(this.f49343a, "android.permission.READ_EXTERNAL_STORAGE")) {
            return !new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".uuid").exists();
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.q.c.b
    /* renamed from: b */
    public String get() {
        return c();
    }

    public final String c() {
        if (TextUtils.equals("mounted", Environment.getExternalStorageState()) && d.b.g0.q.d.c.a(this.f49343a, "android.permission.READ_EXTERNAL_STORAGE")) {
            File file = new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".uuid");
            if (file.exists()) {
                return d.b.g0.q.d.a.c(file);
            }
            return null;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.q.c.b
    /* renamed from: d */
    public void put(String str) {
        e(str);
    }

    public final void e(String str) {
        if (TextUtils.equals("mounted", Environment.getExternalStorageState()) && d.b.g0.q.d.c.a(this.f49343a, StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
            d.b.g0.q.d.a.d(str, new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".uuid"));
        }
    }
}
