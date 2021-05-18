package d.a.k0.i3;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes5.dex */
public class a {
    public static a mInstance;
    public InterfaceC1389a mICrabSdk = getCrabSdk();

    /* renamed from: d.a.k0.i3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1389a {
        void a(Application application);

        void b(Exception exc);

        void c(String str);

        void d(String str);

        void e(String str);

        void f(MotionEvent motionEvent, Activity activity);

        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private InterfaceC1389a getCrabSdk() {
        CustomResponsedMessage runTask;
        if (!isCrabSdkSwitchOn() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC1389a.class)) == null) {
            return null;
        }
        return (InterfaceC1389a) runTask.getData();
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
        return d.a.j0.r.d0.b.j().k("pref_key_crab_sdk_enable", 1) == 1;
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        InterfaceC1389a interfaceC1389a = this.mICrabSdk;
        if (interfaceC1389a != null) {
            interfaceC1389a.f(motionEvent, activity);
        }
    }

    public void initSdk(Application application) {
        InterfaceC1389a interfaceC1389a = this.mICrabSdk;
        if (interfaceC1389a != null) {
            interfaceC1389a.a(application);
        }
    }

    public void onPause(Activity activity) {
        InterfaceC1389a interfaceC1389a = this.mICrabSdk;
        if (interfaceC1389a != null) {
            interfaceC1389a.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        InterfaceC1389a interfaceC1389a = this.mICrabSdk;
        if (interfaceC1389a != null) {
            interfaceC1389a.onResume(activity);
        }
    }

    public void setFlutterPath(String str) {
        InterfaceC1389a interfaceC1389a = this.mICrabSdk;
        if (interfaceC1389a != null) {
            interfaceC1389a.c(str);
        }
    }

    public void setLastFlutterPage(String str) {
        InterfaceC1389a interfaceC1389a = this.mICrabSdk;
        if (interfaceC1389a != null) {
            interfaceC1389a.e(str);
        }
    }

    public void setOpenFlutterPage(String str) {
        InterfaceC1389a interfaceC1389a = this.mICrabSdk;
        if (interfaceC1389a != null) {
            interfaceC1389a.d(str);
        }
    }

    public void uploadException(Exception exc) {
        InterfaceC1389a interfaceC1389a = this.mICrabSdk;
        if (interfaceC1389a != null) {
            interfaceC1389a.b(exc);
        }
    }
}
