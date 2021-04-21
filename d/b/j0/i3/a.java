package d.b.j0.i3;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes5.dex */
public class a {
    public static a mInstance;
    public InterfaceC1378a mICrabSdk = getCrabSdk();

    /* renamed from: d.b.j0.i3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1378a {
        void a(Application application);

        void b(String str);

        void c(Exception exc);

        void d(MotionEvent motionEvent, Activity activity);

        void e(String str);

        void f(String str);

        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private InterfaceC1378a getCrabSdk() {
        CustomResponsedMessage runTask;
        if (!isCrabSdkSwitchOn() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC1378a.class)) == null) {
            return null;
        }
        return (InterfaceC1378a) runTask.getData();
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
        return d.b.i0.r.d0.b.j().k("pref_key_crab_sdk_enable", 1) == 1;
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        InterfaceC1378a interfaceC1378a = this.mICrabSdk;
        if (interfaceC1378a != null) {
            interfaceC1378a.d(motionEvent, activity);
        }
    }

    public void initSdk(Application application) {
        InterfaceC1378a interfaceC1378a = this.mICrabSdk;
        if (interfaceC1378a != null) {
            interfaceC1378a.a(application);
        }
    }

    public void onPause(Activity activity) {
        InterfaceC1378a interfaceC1378a = this.mICrabSdk;
        if (interfaceC1378a != null) {
            interfaceC1378a.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        InterfaceC1378a interfaceC1378a = this.mICrabSdk;
        if (interfaceC1378a != null) {
            interfaceC1378a.onResume(activity);
        }
    }

    public void setFlutterPath(String str) {
        InterfaceC1378a interfaceC1378a = this.mICrabSdk;
        if (interfaceC1378a != null) {
            interfaceC1378a.e(str);
        }
    }

    public void setLastFlutterPage(String str) {
        InterfaceC1378a interfaceC1378a = this.mICrabSdk;
        if (interfaceC1378a != null) {
            interfaceC1378a.b(str);
        }
    }

    public void setOpenFlutterPage(String str) {
        InterfaceC1378a interfaceC1378a = this.mICrabSdk;
        if (interfaceC1378a != null) {
            interfaceC1378a.f(str);
        }
    }

    public void uploadException(Exception exc) {
        InterfaceC1378a interfaceC1378a = this.mICrabSdk;
        if (interfaceC1378a != null) {
            interfaceC1378a.c(exc);
        }
    }
}
