package d.a.l0.u.c;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
/* loaded from: classes3.dex */
public class a implements b<String> {

    /* renamed from: a  reason: collision with root package name */
    public Context f48502a;

    public a(Context context) {
        this.f48502a = context.getApplicationContext();
    }

    @Override // d.a.l0.u.c.b
    public boolean a() {
        if (TextUtils.equals("mounted", Environment.getExternalStorageState()) && d.a.l0.u.d.c.a(this.f48502a, "android.permission.READ_EXTERNAL_STORAGE")) {
            return !new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".uuid").exists();
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.u.c.b
    /* renamed from: b */
    public String get() {
        return c();
    }

    public final String c() {
        if (TextUtils.equals("mounted", Environment.getExternalStorageState()) && d.a.l0.u.d.c.a(this.f48502a, "android.permission.READ_EXTERNAL_STORAGE")) {
            File file = new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".uuid");
            if (file.exists()) {
                return d.a.l0.u.d.a.c(file);
            }
            return null;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.u.c.b
    /* renamed from: d */
    public void put(String str) {
        e(str);
    }

    public final void e(String str) {
        if (TextUtils.equals("mounted", Environment.getExternalStorageState()) && d.a.l0.u.d.c.a(this.f48502a, StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
            d.a.l0.u.d.a.d(str, new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".uuid"));
        }
    }
}
