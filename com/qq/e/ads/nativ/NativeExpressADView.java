package com.qq.e.ads.nativ;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.NEADVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class NativeExpressADView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private NEADVI f7522a;
    private boolean b;
    private volatile boolean c;
    private volatile boolean d;
    private NativeExpressMediaListener e;
    public Map<String, String> ext;
    private AdData f;
    private volatile boolean g;
    private ViewBindStatusListener h;

    /* loaded from: classes4.dex */
    public interface ViewBindStatusListener {
        void onAttachedToWindow();

        void onDetachedFromWindow();

        void onFinishTemporaryDetach();

        void onStartTemporaryDetach();
    }

    public NativeExpressADView(final NEADI neadi, final Context context, final ADSize aDSize, final String str, final String str2, final JSONObject jSONObject, final HashMap<String, JSONObject> hashMap) {
        super(context);
        this.b = false;
        this.c = false;
        this.d = false;
        this.ext = new HashMap();
        this.g = false;
        this.f = a(hashMap);
        GDTADManager.INIT_EXECUTOR.execute(new Runnable() { // from class: com.qq.e.ads.nativ.NativeExpressADView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!GDTADManager.getInstance().initWith(context, str)) {
                    GDTLogger.e("Fail to init ADManager");
                    return;
                }
                try {
                    final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.nativ.NativeExpressADView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (pOFactory != null) {
                                    NativeExpressADView.this.f7522a = pOFactory.getNativeExpressADView(neadi, context, NativeExpressADView.this, aDSize, str, str2, jSONObject, hashMap);
                                    NativeExpressADView.this.b = true;
                                    if (NativeExpressADView.this.e != null) {
                                        NativeExpressADView.this.setMediaListener(NativeExpressADView.this.e);
                                    }
                                    if (NativeExpressADView.this.c) {
                                        NativeExpressADView.this.preloadVideo();
                                    }
                                    if (NativeExpressADView.this.d) {
                                        NativeExpressADView.this.render();
                                    }
                                    if (NativeExpressADView.this.g) {
                                        NativeExpressADView.this.negativeFeedback();
                                    }
                                }
                            } catch (Throwable th) {
                                try {
                                    GDTLogger.e("Exception while init Native Express AD View Core", th);
                                } finally {
                                    NativeExpressADView.this.b = true;
                                }
                            }
                        }
                    });
                } catch (Throwable th) {
                    GDTLogger.e("Exception while init Native Express AD View plugin", th);
                }
            }
        });
    }

    private static AdData a(HashMap<String, JSONObject> hashMap) {
        JSONObject jSONObject;
        Object obj;
        if (hashMap != null) {
            try {
                jSONObject = hashMap.get(Constants.KEYS.AD_INFO);
            } catch (JSONException e) {
                obj = null;
            }
        } else {
            jSONObject = null;
        }
        obj = jSONObject != null ? jSONObject.get(Constants.KEYS.AD_INFO) : null;
        if (obj instanceof AdData) {
            return (AdData) obj;
        }
        return null;
    }

    public void destroy() {
        if (this.f7522a != null) {
            this.f7522a.destroy();
        }
    }

    public AdData getBoundData() {
        return this.f;
    }

    public void negativeFeedback() {
        if (!this.b) {
            this.g = true;
        } else if (this.f7522a == null) {
            GDTLogger.e("Native Express negativeFeedback  core is null");
        } else {
            this.f7522a.reportAdNegative();
            this.g = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.h != null) {
            this.h.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.h != null) {
            this.h.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.h != null) {
            this.h.onFinishTemporaryDetach();
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.h != null) {
            this.h.onStartTemporaryDetach();
        }
    }

    public void preloadVideo() {
        if (!this.b) {
            this.c = true;
        } else if (this.f7522a != null) {
            this.f7522a.preloadVideo();
        } else {
            GDTLogger.e("Native Express AD View Init Error");
        }
    }

    public void render() {
        if (!this.b) {
            this.d = true;
        } else if (this.f7522a != null) {
            this.f7522a.render();
        } else {
            GDTLogger.e("Native Express AD View Init Error");
        }
    }

    public void setAdSize(ADSize aDSize) {
        if (this.f7522a != null) {
            this.f7522a.setAdSize(aDSize);
        }
    }

    public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
        this.e = nativeExpressMediaListener;
        if (this.f7522a == null || nativeExpressMediaListener == null) {
            return;
        }
        this.f7522a.setAdListener(new NativeExpressAD.ADListenerAdapter(nativeExpressMediaListener));
    }

    public void setViewBindStatusListener(ViewBindStatusListener viewBindStatusListener) {
        this.h = viewBindStatusListener;
    }
}
