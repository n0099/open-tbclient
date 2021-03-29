package d.b.i0.h3;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes5.dex */
public class a {
    public static a mInstance;
    public InterfaceC1280a mICrabSdk = getCrabSdk();

    /* renamed from: d.b.i0.h3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1280a {
        void a(Application application);

        void b(String str);

        void c(Exception exc);

        void d(MotionEvent motionEvent, Activity activity);

        void e(String str);

        void f(String str);

        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private InterfaceC1280a getCrabSdk() {
        CustomResponsedMessage runTask;
        if (!isCrabSdkSwitchOn() || (runTask = MessageManager.getInstance().runTask(2016565, InterfaceC1280a.class)) == null) {
            return null;
        }
        return (InterfaceC1280a) runTask.getData();
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
        return d.b.h0.r.d0.b.i().j("pref_key_crab_sdk_enable", 1) == 1;
    }

    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        InterfaceC1280a interfaceC1280a = this.mICrabSdk;
        if (interfaceC1280a != null) {
            interfaceC1280a.d(motionEvent, activity);
        }
    }

    public void initSdk(Application application) {
        InterfaceC1280a interfaceC1280a = this.mICrabSdk;
        if (interfaceC1280a != null) {
            interfaceC1280a.a(application);
        }
    }

    public void onPause(Activity activity) {
        InterfaceC1280a interfaceC1280a = this.mICrabSdk;
        if (interfaceC1280a != null) {
            interfaceC1280a.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        InterfaceC1280a interfaceC1280a = this.mICrabSdk;
        if (interfaceC1280a != null) {
            interfaceC1280a.onResume(activity);
        }
    }

    public void setFlutterPath(String str) {
        InterfaceC1280a interfaceC1280a = this.mICrabSdk;
        if (interfaceC1280a != null) {
            interfaceC1280a.e(str);
        }
    }

    public void setLastFlutterPage(String str) {
        InterfaceC1280a interfaceC1280a = this.mICrabSdk;
        if (interfaceC1280a != null) {
            interfaceC1280a.b(str);
        }
    }

    public void setOpenFlutterPage(String str) {
        InterfaceC1280a interfaceC1280a = this.mICrabSdk;
        if (interfaceC1280a != null) {
            interfaceC1280a.f(str);
        }
    }

    public void uploadException(Exception exc) {
        InterfaceC1280a interfaceC1280a = this.mICrabSdk;
        if (interfaceC1280a != null) {
            interfaceC1280a.c(exc);
        }
    }
}
