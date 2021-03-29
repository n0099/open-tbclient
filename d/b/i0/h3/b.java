package d.b.i0.h3;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static b f55443c;

    /* renamed from: b  reason: collision with root package name */
    public boolean f55445b = false;

    /* renamed from: a  reason: collision with root package name */
    public a f55444a = c();

    /* loaded from: classes5.dex */
    public interface a {
        void a(Application application);
    }

    public static b b() {
        if (f55443c == null) {
            synchronized (b.class) {
                if (f55443c == null) {
                    f55443c = new b();
                }
            }
        }
        return f55443c;
    }

    public final boolean a() {
        return d.b.h0.r.d0.b.i().j("pref_key_jpush_sdk_enable", 0) == 1;
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
        if (this.f55445b || (aVar = this.f55444a) == null) {
            return;
        }
        aVar.a(application);
        this.f55445b = true;
    }
}
