package d.b.i0.h3;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static b f55442c;

    /* renamed from: b  reason: collision with root package name */
    public boolean f55444b = false;

    /* renamed from: a  reason: collision with root package name */
    public a f55443a = c();

    /* loaded from: classes5.dex */
    public interface a {
        void a(Application application);
    }

    public static b b() {
        if (f55442c == null) {
            synchronized (b.class) {
                if (f55442c == null) {
                    f55442c = new b();
                }
            }
        }
        return f55442c;
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
        if (this.f55444b || (aVar = this.f55443a) == null) {
            return;
        }
        aVar.a(application);
        this.f55444b = true;
    }
}
