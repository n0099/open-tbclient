package com.qq.e.ads.nativ;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
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
/* loaded from: classes7.dex */
public class NativeExpressADView extends FrameLayout implements ApkDownloadComplianceInterface, DownloadConfirmListener {

    /* renamed from: a  reason: collision with root package name */
    public NEADVI f39042a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f39043b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f39044c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f39045d;

    /* renamed from: e  reason: collision with root package name */
    public NativeExpressMediaListener f39046e;
    public Map<String, String> ext;

    /* renamed from: f  reason: collision with root package name */
    public AdData f39047f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f39048g;

    /* renamed from: h  reason: collision with root package name */
    public ViewBindStatusListener f39049h;

    /* renamed from: i  reason: collision with root package name */
    public DownloadConfirmListener f39050i;

    /* loaded from: classes7.dex */
    public interface ViewBindStatusListener {
        void onAttachedToWindow();

        void onDetachedFromWindow();

        void onFinishTemporaryDetach();

        void onStartTemporaryDetach();
    }

    public NativeExpressADView(final NEADI neadi, final Context context, final ADSize aDSize, final String str, final String str2, final JSONObject jSONObject, final HashMap<String, Object> hashMap) {
        super(context);
        this.f39043b = false;
        this.f39044c = false;
        this.f39045d = false;
        this.ext = new HashMap();
        this.f39048g = false;
        this.f39047f = a(hashMap);
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
                                    NativeExpressADView.this.f39042a = pOFactory.getNativeExpressADView(neadi, context, NativeExpressADView.this, aDSize, str, str2, jSONObject, hashMap);
                                    NativeExpressADView.this.f39043b = true;
                                    if (NativeExpressADView.this.f39046e != null) {
                                        NativeExpressADView.this.setMediaListener(NativeExpressADView.this.f39046e);
                                    }
                                    if (NativeExpressADView.this.f39044c) {
                                        NativeExpressADView.this.preloadVideo();
                                    }
                                    if (NativeExpressADView.this.f39045d) {
                                        NativeExpressADView.this.render();
                                    }
                                    if (NativeExpressADView.this.f39048g) {
                                        NativeExpressADView.this.negativeFeedback();
                                    }
                                }
                            } finally {
                                try {
                                } finally {
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

    /* JADX WARN: Removed duplicated region for block: B:12:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AdData a(HashMap<String, Object> hashMap) {
        JSONObject jSONObject;
        Object obj;
        if (hashMap != null) {
            try {
                jSONObject = (JSONObject) hashMap.get(Constants.KEYS.AD_INFO);
            } catch (JSONException unused) {
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            obj = jSONObject.get(Constants.KEYS.AD_INFO);
            if (obj instanceof AdData) {
                return null;
            }
            return (AdData) obj;
        }
        obj = null;
        if (obj instanceof AdData) {
        }
    }

    public void destroy() {
        NEADVI neadvi = this.f39042a;
        if (neadvi != null) {
            neadvi.destroy();
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        NEADVI neadvi = this.f39042a;
        if (neadvi != null) {
            return neadvi.getApkInfoUrl();
        }
        return null;
    }

    public AdData getBoundData() {
        return this.f39047f;
    }

    public void negativeFeedback() {
        if (!this.f39043b) {
            this.f39048g = true;
            return;
        }
        NEADVI neadvi = this.f39042a;
        if (neadvi == null) {
            GDTLogger.e("Native Express negativeFeedback  core is null");
            return;
        }
        neadvi.reportAdNegative();
        this.f39048g = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewBindStatusListener viewBindStatusListener = this.f39049h;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewBindStatusListener viewBindStatusListener = this.f39049h;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onDetachedFromWindow();
        }
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.f39050i;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i2, str, downloadConfirmCallBack);
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        ViewBindStatusListener viewBindStatusListener = this.f39049h;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onFinishTemporaryDetach();
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        ViewBindStatusListener viewBindStatusListener = this.f39049h;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onStartTemporaryDetach();
        }
    }

    public void preloadVideo() {
        if (!this.f39043b) {
            this.f39044c = true;
            return;
        }
        NEADVI neadvi = this.f39042a;
        if (neadvi != null) {
            neadvi.preloadVideo();
        } else {
            GDTLogger.e("Native Express AD View Init Error");
        }
    }

    public void render() {
        if (!this.f39043b) {
            this.f39045d = true;
            return;
        }
        NEADVI neadvi = this.f39042a;
        if (neadvi != null) {
            neadvi.render();
        } else {
            GDTLogger.e("Native Express AD View Init Error");
        }
    }

    public void setAdSize(ADSize aDSize) {
        NEADVI neadvi = this.f39042a;
        if (neadvi != null) {
            neadvi.setAdSize(aDSize);
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f39050i = downloadConfirmListener;
        NEADVI neadvi = this.f39042a;
        if (neadvi != null) {
            neadvi.setDownloadConfirmListener(this);
        }
    }

    public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
        this.f39046e = nativeExpressMediaListener;
        NEADVI neadvi = this.f39042a;
        if (neadvi == null || nativeExpressMediaListener == null) {
            return;
        }
        neadvi.setAdListener(new NativeExpressAD.ADListenerAdapter(nativeExpressMediaListener));
    }

    public void setViewBindStatusListener(ViewBindStatusListener viewBindStatusListener) {
        this.f39049h = viewBindStatusListener;
    }
}
