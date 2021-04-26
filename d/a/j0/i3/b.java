package d.a.j0.i3;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static b f55684c;

    /* renamed from: b  reason: collision with root package name */
    public boolean f55686b = false;

    /* renamed from: a  reason: collision with root package name */
    public a f55685a = c();

    /* loaded from: classes5.dex */
    public interface a {
        void a(Application application);
    }

    public static b b() {
        if (f55684c == null) {
            synchronized (b.class) {
                if (f55684c == null) {
                    f55684c = new b();
                }
            }
        }
        return f55684c;
    }

    public final boolean a() {
        return d.a.i0.r.d0.b.j().k("pref_key_jpush_sdk_enable", 0) == 1;
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
        if (this.f55686b || (aVar = this.f55685a) == null) {
            return;
        }
        aVar.a(application);
        this.f55686b = true;
    }
}
