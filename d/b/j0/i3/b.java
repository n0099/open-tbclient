package d.b.j0.i3;

import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static b f57722c;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57724b = false;

    /* renamed from: a  reason: collision with root package name */
    public a f57723a = c();

    /* loaded from: classes5.dex */
    public interface a {
        void a(Application application);
    }

    public static b b() {
        if (f57722c == null) {
            synchronized (b.class) {
                if (f57722c == null) {
                    f57722c = new b();
                }
            }
        }
        return f57722c;
    }

    public final boolean a() {
        return d.b.i0.r.d0.b.j().k("pref_key_jpush_sdk_enable", 0) == 1;
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
        if (this.f57724b || (aVar = this.f57723a) == null) {
            return;
        }
        aVar.a(application);
        this.f57724b = true;
    }
}
