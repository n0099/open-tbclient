package d.a.o0.j3;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static b f60389c;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60391b = false;

    /* renamed from: a  reason: collision with root package name */
    public a f60390a = c();

    /* loaded from: classes5.dex */
    public interface a {
        void a(Application application);
    }

    public static b b() {
        if (f60389c == null) {
            synchronized (b.class) {
                if (f60389c == null) {
                    f60389c = new b();
                }
            }
        }
        return f60389c;
    }

    public final boolean a() {
        return d.a.n0.r.d0.b.j().k("pref_key_jpush_sdk_enable", 0) == 1;
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
        if (this.f60391b || (aVar = this.f60390a) == null) {
            return;
        }
        aVar.a(application);
        this.f60391b = true;
    }
}
