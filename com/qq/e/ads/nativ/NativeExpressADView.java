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
/* loaded from: classes6.dex */
public class NativeExpressADView extends FrameLayout implements ApkDownloadComplianceInterface, DownloadConfirmListener {

    /* renamed from: a  reason: collision with root package name */
    public NEADVI f36091a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f36092b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f36093c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f36094d;

    /* renamed from: e  reason: collision with root package name */
    public NativeExpressMediaListener f36095e;
    public Map<String, String> ext;

    /* renamed from: f  reason: collision with root package name */
    public AdData f36096f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f36097g;

    /* renamed from: h  reason: collision with root package name */
    public ViewBindStatusListener f36098h;

    /* renamed from: i  reason: collision with root package name */
    public DownloadConfirmListener f36099i;

    /* loaded from: classes6.dex */
    public interface ViewBindStatusListener {
        void onAttachedToWindow();

        void onDetachedFromWindow();

        void onFinishTemporaryDetach();

        void onStartTemporaryDetach();
    }

    public NativeExpressADView(final NEADI neadi, final Context context, final ADSize aDSize, final String str, final String str2, final JSONObject jSONObject, final HashMap<String, Object> hashMap) {
        super(context);
        this.f36092b = false;
        this.f36093c = false;
        this.f36094d = false;
        this.ext = new HashMap();
        this.f36097g = false;
        this.f36096f = a(hashMap);
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
                                    NativeExpressADView.this.f36091a = pOFactory.getNativeExpressADView(neadi, context, NativeExpressADView.this, aDSize, str, str2, jSONObject, hashMap);
                                    NativeExpressADView.this.f36092b = true;
                                    if (NativeExpressADView.this.f36095e != null) {
                                        NativeExpressADView.this.setMediaListener(NativeExpressADView.this.f36095e);
                                    }
                                    if (NativeExpressADView.this.f36093c) {
                                        NativeExpressADView.this.preloadVideo();
                                    }
                                    if (NativeExpressADView.this.f36094d) {
                                        NativeExpressADView.this.render();
                                    }
                                    if (NativeExpressADView.this.f36097g) {
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
        NEADVI neadvi = this.f36091a;
        if (neadvi != null) {
            neadvi.destroy();
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        NEADVI neadvi = this.f36091a;
        if (neadvi != null) {
            return neadvi.getApkInfoUrl();
        }
        return null;
    }

    public AdData getBoundData() {
        return this.f36096f;
    }

    public void negativeFeedback() {
        if (!this.f36092b) {
            this.f36097g = true;
            return;
        }
        NEADVI neadvi = this.f36091a;
        if (neadvi == null) {
            GDTLogger.e("Native Express negativeFeedback  core is null");
            return;
        }
        neadvi.reportAdNegative();
        this.f36097g = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewBindStatusListener viewBindStatusListener = this.f36098h;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewBindStatusListener viewBindStatusListener = this.f36098h;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onDetachedFromWindow();
        }
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.f36099i;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i2, str, downloadConfirmCallBack);
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        ViewBindStatusListener viewBindStatusListener = this.f36098h;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onFinishTemporaryDetach();
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        ViewBindStatusListener viewBindStatusListener = this.f36098h;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onStartTemporaryDetach();
        }
    }

    public void preloadVideo() {
        if (!this.f36092b) {
            this.f36093c = true;
            return;
        }
        NEADVI neadvi = this.f36091a;
        if (neadvi != null) {
            neadvi.preloadVideo();
        } else {
            GDTLogger.e("Native Express AD View Init Error");
        }
    }

    public void render() {
        if (!this.f36092b) {
            this.f36094d = true;
            return;
        }
        NEADVI neadvi = this.f36091a;
        if (neadvi != null) {
            neadvi.render();
        } else {
            GDTLogger.e("Native Express AD View Init Error");
        }
    }

    public void setAdSize(ADSize aDSize) {
        NEADVI neadvi = this.f36091a;
        if (neadvi != null) {
            neadvi.setAdSize(aDSize);
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f36099i = downloadConfirmListener;
        NEADVI neadvi = this.f36091a;
        if (neadvi != null) {
            neadvi.setDownloadConfirmListener(this);
        }
    }

    public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
        this.f36095e = nativeExpressMediaListener;
        NEADVI neadvi = this.f36091a;
        if (neadvi == null || nativeExpressMediaListener == null) {
            return;
        }
        neadvi.setAdListener(new NativeExpressAD.ADListenerAdapter(nativeExpressMediaListener));
    }

    public void setViewBindStatusListener(ViewBindStatusListener viewBindStatusListener) {
        this.f36098h = viewBindStatusListener;
    }
}
