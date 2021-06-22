package d.a.o0.k2;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
/* loaded from: classes5.dex */
public class k extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public Context f60696a;

    /* renamed from: b  reason: collision with root package name */
    public a f60697b;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z);
    }

    public k(Context context, Handler handler) {
        super(handler);
        this.f60696a = context;
    }

    public final void a() {
        Context context = this.f60696a;
        if (context == null) {
            return;
        }
        try {
            int i2 = Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation");
            if (this.f60697b != null) {
                a aVar = this.f60697b;
                boolean z = true;
                if (i2 != 1) {
                    z = false;
                }
                aVar.a(z);
            }
        } catch (Settings.SettingNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public void b(a aVar) {
        this.f60697b = aVar;
        a();
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        a();
    }
}
