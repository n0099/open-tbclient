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
    public NEADVI f35265a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35266b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f35267c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f35268d;

    /* renamed from: e  reason: collision with root package name */
    public NativeExpressMediaListener f35269e;
    public Map<String, String> ext;

    /* renamed from: f  reason: collision with root package name */
    public AdData f35270f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f35271g;

    /* renamed from: h  reason: collision with root package name */
    public ViewBindStatusListener f35272h;

    /* renamed from: i  reason: collision with root package name */
    public DownloadConfirmListener f35273i;

    /* loaded from: classes7.dex */
    public interface ViewBindStatusListener {
        void onAttachedToWindow();

        void onDetachedFromWindow();

        void onFinishTemporaryDetach();

        void onStartTemporaryDetach();
    }

    public NativeExpressADView(final NEADI neadi, final Context context, final ADSize aDSize, final String str, final String str2, final JSONObject jSONObject, final HashMap<String, Object> hashMap) {
        super(context);
        this.f35266b = false;
        this.f35267c = false;
        this.f35268d = false;
        this.ext = new HashMap();
        this.f35271g = false;
        this.f35270f = a(hashMap);
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
                                    NativeExpressADView.this.f35265a = pOFactory.getNativeExpressADView(neadi, context, NativeExpressADView.this, aDSize, str, str2, jSONObject, hashMap);
                                    NativeExpressADView.this.f35266b = true;
                                    if (NativeExpressADView.this.f35269e != null) {
                                        NativeExpressADView.this.setMediaListener(NativeExpressADView.this.f35269e);
                                    }
                                    if (NativeExpressADView.this.f35267c) {
                                        NativeExpressADView.this.preloadVideo();
                                    }
                                    if (NativeExpressADView.this.f35268d) {
                                        NativeExpressADView.this.render();
                                    }
                                    if (NativeExpressADView.this.f35271g) {
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
        NEADVI neadvi = this.f35265a;
        if (neadvi != null) {
            neadvi.destroy();
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        NEADVI neadvi = this.f35265a;
        if (neadvi != null) {
            return neadvi.getApkInfoUrl();
        }
        return null;
    }

    public AdData getBoundData() {
        return this.f35270f;
    }

    public void negativeFeedback() {
        if (!this.f35266b) {
            this.f35271g = true;
            return;
        }
        NEADVI neadvi = this.f35265a;
        if (neadvi == null) {
            GDTLogger.e("Native Express negativeFeedback  core is null");
            return;
        }
        neadvi.reportAdNegative();
        this.f35271g = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewBindStatusListener viewBindStatusListener = this.f35272h;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewBindStatusListener viewBindStatusListener = this.f35272h;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onDetachedFromWindow();
        }
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.f35273i;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i2, str, downloadConfirmCallBack);
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        ViewBindStatusListener viewBindStatusListener = this.f35272h;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onFinishTemporaryDetach();
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        ViewBindStatusListener viewBindStatusListener = this.f35272h;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onStartTemporaryDetach();
        }
    }

    public void preloadVideo() {
        if (!this.f35266b) {
            this.f35267c = true;
            return;
        }
        NEADVI neadvi = this.f35265a;
        if (neadvi != null) {
            neadvi.preloadVideo();
        } else {
            GDTLogger.e("Native Express AD View Init Error");
        }
    }

    public void render() {
        if (!this.f35266b) {
            this.f35268d = true;
            return;
        }
        NEADVI neadvi = this.f35265a;
        if (neadvi != null) {
            neadvi.render();
        } else {
            GDTLogger.e("Native Express AD View Init Error");
        }
    }

    public void setAdSize(ADSize aDSize) {
        NEADVI neadvi = this.f35265a;
        if (neadvi != null) {
            neadvi.setAdSize(aDSize);
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f35273i = downloadConfirmListener;
        NEADVI neadvi = this.f35265a;
        if (neadvi != null) {
            neadvi.setDownloadConfirmListener(this);
        }
    }

    public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
        this.f35269e = nativeExpressMediaListener;
        NEADVI neadvi = this.f35265a;
        if (neadvi == null || nativeExpressMediaListener == null) {
            return;
        }
        neadvi.setAdListener(new NativeExpressAD.ADListenerAdapter(nativeExpressMediaListener));
    }

    public void setViewBindStatusListener(ViewBindStatusListener viewBindStatusListener) {
        this.f35272h = viewBindStatusListener;
    }
}
