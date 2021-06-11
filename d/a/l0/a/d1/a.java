package d.a.l0.a.d1;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import d.a.l0.a.k;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class a {
    public static final boolean DEBUG = k.f46875a;
    public WeakReference<Activity> mActivityRef;
    public CallbackHandler mCallbackHandler;
    public Context mContext;
    public d.a.l0.a.h0.f.a mJsContainer;
    public UnitedSchemeMainDispatcher mMainDispatcher;

    public a(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler, d.a.l0.a.h0.f.a aVar) {
        this.mContext = context;
        this.mMainDispatcher = unitedSchemeMainDispatcher;
        this.mCallbackHandler = callbackHandler;
        this.mJsContainer = aVar;
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
