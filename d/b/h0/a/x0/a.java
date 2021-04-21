package d.b.h0.a.x0;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import d.b.h0.a.k;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class a {
    public static final boolean DEBUG = k.f45772a;
    public WeakReference<Activity> mActivityRef;
    public CallbackHandler mCallbackHandler;
    public Context mContext;
    public UnitedSchemeMainDispatcher mMainDispatcher;

    public a(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler) {
        this.mContext = context;
        this.mMainDispatcher = unitedSchemeMainDispatcher;
        this.mCallbackHandler = callbackHandler;
        if (DEBUG) {
            if (context == null || unitedSchemeMainDispatcher == null) {
                throw new IllegalArgumentException("any of context, dispatcher objects can't be null.");
            }
        }
    }

    public Context getDispatchContext() {
        WeakReference<Activity> weakReference = this.mActivityRef;
        Activity activity = weakReference != null ? weakReference.get() : null;
        return activity == null ? this.mContext : activity;
    }

    public void setActivityRef(Activity activity) {
        if (activity != null) {
            this.mActivityRef = new WeakReference<>(activity);
        }
    }

    public void setCallbackHandler(CallbackHandler callbackHandler) {
        this.mCallbackHandler = callbackHandler;
    }
}
