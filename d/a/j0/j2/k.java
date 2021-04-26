package d.a.j0.j2;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
/* loaded from: classes4.dex */
public class k extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public Context f55995a;

    /* renamed from: b  reason: collision with root package name */
    public a f55996b;

    /* loaded from: classes4.dex */
    public interface a {
        void a(boolean z);
    }

    public k(Context context, Handler handler) {
        super(handler);
        this.f55995a = context;
    }

    public final void a() {
        Context context = this.f55995a;
        if (context == null) {
            return;
        }
        try {
            int i2 = Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation");
            if (this.f55996b != null) {
                a aVar = this.f55996b;
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
        this.f55996b = aVar;
        a();
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        a();
    }
}
