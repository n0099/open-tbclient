package d.b.j0.j2;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
/* loaded from: classes3.dex */
public class k extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public Context f58016a;

    /* renamed from: b  reason: collision with root package name */
    public a f58017b;

    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z);
    }

    public k(Context context, Handler handler) {
        super(handler);
        this.f58016a = context;
    }

    public final void a() {
        Context context = this.f58016a;
        if (context == null) {
            return;
        }
        try {
            int i = Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation");
            if (this.f58017b != null) {
                a aVar = this.f58017b;
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
        this.f58017b = aVar;
        a();
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        a();
    }
}
