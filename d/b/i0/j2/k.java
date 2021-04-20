package d.b.i0.j2;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
/* loaded from: classes3.dex */
public class k extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public Context f57595a;

    /* renamed from: b  reason: collision with root package name */
    public a f57596b;

    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z);
    }

    public k(Context context, Handler handler) {
        super(handler);
        this.f57595a = context;
    }

    public final void a() {
        Context context = this.f57595a;
        if (context == null) {
            return;
        }
        try {
            int i = Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation");
            if (this.f57596b != null) {
                a aVar = this.f57596b;
                boolean z = true;
                if (i != 1) {
                    z = false;
                }
                aVar.a(z);
            }
        } catch (Settings.SettingNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public void b(a aVar) {
        this.f57596b = aVar;
        a();
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        a();
    }
}
