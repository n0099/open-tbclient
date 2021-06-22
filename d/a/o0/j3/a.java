package d.a.o0.j3;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes5.dex */
public class a {
    public static a mInstance;
    public InterfaceC1467a mICrabSdk = getCrabSdk();

    /* renamed from: d.a.o0.j3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1467a {
        void a(Application application);

        void b(Exception exc);

        void c(String str);

        void d(String str);

        void e(String str);

        void f(MotionEvent motionEvent, Activity activity);

        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private InterfaceC1467a getCrabSdk() {
        CustomResponsedMessage runTask;
        if (!isCrabSdkSwitchOn() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC1467a.class)) == null) {
            return null;
        }
        return (InterfaceC1467a) runTask.getData();
    }

    public static a getInstance() {
        if (mInstance == null) {
            synchronized (a.class) {
                if (mInstance == null) {
                    mInstance = new a();
                }
            }
        }
        return mInstance;
    }

    private boolean isCrabSdkSwitchOn() {
        return d.a.n0.r.d0.b.j().k("pref_key_crab_sdk_enable", 1) == 1;
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        InterfaceC1467a interfaceC1467a = this.mICrabSdk;
        if (interfaceC1467a != null) {
            interfaceC1467a.f(motionEvent, activity);
        }
    }

    public void initSdk(Application application) {
        InterfaceC1467a interfaceC1467a = this.mICrabSdk;
        if (interfaceC1467a != null) {
            interfaceC1467a.a(application);
        }
    }

    public void onPause(Activity activity) {
        InterfaceC1467a interfaceC1467a = this.mICrabSdk;
        if (interfaceC1467a != null) {
            interfaceC1467a.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        InterfaceC1467a interfaceC1467a = this.mICrabSdk;
        if (interfaceC1467a != null) {
            interfaceC1467a.onResume(activity);
        }
    }

    public void setFlutterPath(String str) {
        InterfaceC1467a interfaceC1467a = this.mICrabSdk;
        if (interfaceC1467a != null) {
            interfaceC1467a.c(str);
        }
    }

    public void setLastFlutterPage(String str) {
        InterfaceC1467a interfaceC1467a = this.mICrabSdk;
        if (interfaceC1467a != null) {
            interfaceC1467a.e(str);
        }
    }

    public void setOpenFlutterPage(String str) {
        InterfaceC1467a interfaceC1467a = this.mICrabSdk;
        if (interfaceC1467a != null) {
            interfaceC1467a.d(str);
        }
    }

    public void uploadException(Exception exc) {
        InterfaceC1467a interfaceC1467a = this.mICrabSdk;
        if (interfaceC1467a != null) {
            interfaceC1467a.b(exc);
        }
    }
}
