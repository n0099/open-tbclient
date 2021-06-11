package d.a.n0.j3;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static b f60264c;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60266b = false;

    /* renamed from: a  reason: collision with root package name */
    public a f60265a = c();

    /* loaded from: classes5.dex */
    public interface a {
        void a(Application application);
    }

    public static b b() {
        if (f60264c == null) {
            synchronized (b.class) {
                if (f60264c == null) {
                    f60264c = new b();
                }
            }
        }
        return f60264c;
    }

    public final boolean a() {
        return d.a.m0.r.d0.b.j().k("pref_key_jpush_sdk_enable", 0) == 1;
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
        if (this.f60266b || (aVar = this.f60265a) == null) {
            return;
        }
        aVar.a(application);
        this.f60266b = true;
    }
}
