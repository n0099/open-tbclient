package d.b.i0.i3;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static b f57301c;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57303b = false;

    /* renamed from: a  reason: collision with root package name */
    public a f57302a = c();

    /* loaded from: classes5.dex */
    public interface a {
        void a(Application application);
    }

    public static b b() {
        if (f57301c == null) {
            synchronized (b.class) {
                if (f57301c == null) {
                    f57301c = new b();
                }
            }
        }
        return f57301c;
    }

    public final boolean a() {
        return d.b.h0.r.d0.b.j().k("pref_key_jpush_sdk_enable", 0) == 1;
    }

    public final a c() {
        CustomResponsedMessage runTask;
        if (!a() || (runTask = MessageManager.getInstance().runTask(2156672, a.class)) == null) {
            return null;
        }
        return (a) runTask.getData();
    }

    public void d(Application application) {
        a aVar;
        if (this.f57303b || (aVar = this.f57302a) == null) {
            return;
        }
        aVar.a(application);
        this.f57303b = true;
    }
}
