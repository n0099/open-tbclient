package com.kwad.components.core.webview.tachikoma;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.sapi2.activity.BaseActivity;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.l;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.ap;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.av;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.a.r;
import com.kwad.components.core.webview.tachikoma.a.s;
import com.kwad.components.core.webview.tachikoma.a.t;
import com.kwad.components.core.webview.tachikoma.a.v;
import com.kwad.components.core.webview.tachikoma.a.x;
import com.kwad.components.core.webview.tachikoma.b.y;
import com.kwad.components.core.webview.tachikoma.c.e;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TKDownloadListener;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.components.offline.api.tk.model.report.TKPerformMsg;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.m;
import com.kwad.sdk.components.n;
import com.kwad.sdk.components.o;
import com.kwad.sdk.components.p;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.export.proxy.AdHttpBodyBuilder;
import com.kwad.sdk.export.proxy.AdHttpFormDataBuilder;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.q;
import com.kwad.sdk.utils.v;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class i implements com.kwad.components.core.e.e.f, m, com.kwad.sdk.core.view.b, com.kwad.sdk.core.webview.d.a.a {
    public static Map<Integer, WeakReference<com.kwad.components.core.webview.tachikoma.c.e>> YN = new HashMap();
    public long EV;
    public StyleTemplate Sq;
    public com.kwad.sdk.core.download.d Vo;
    public p YA;
    public com.kwad.components.core.webview.tachikoma.a.p YB;
    public av YC;
    public com.kwad.sdk.core.view.d YD;
    public boolean YE;
    public boolean YF;
    public boolean YG;
    public boolean YH;
    public boolean YI;
    public int YJ;
    public long YK;
    public long YL;
    public Map<String, Object> YM;
    public int YO;
    public int YP;
    public boolean YQ;
    public String YR;
    public String YS;
    public com.kwad.sdk.core.webview.e YT;
    public a YU;
    public n YV;
    public com.kwad.sdk.components.i YW;
    public final Runnable YX;
    public final Runnable YY;
    public com.kwad.components.core.webview.tachikoma.c.e Yv;
    public j Yw;
    public com.kwad.sdk.core.webview.c.g Yx;
    public com.kwad.components.core.n.a.d.c Yy;
    public Future<?> Yz;
    public aw cQ;
    public final l gO;
    @Nullable
    public Activity mActivity;
    public AdResultData mAdResultData;
    public final Context mContext;
    public long mInitTime;
    public final y wo;
    public long xr;

    /* loaded from: classes10.dex */
    public interface a {
        void onFailed();

        void onSuccess();
    }

    public void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, p pVar, ViewGroup viewGroup) {
    }

    public void f(String str, String str2) {
    }

    public void g(String str, String str2) {
    }

    public boolean nc() {
        return false;
    }

    public static boolean isLocalDebugEnable() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return false;
    }

    private Map<String, Object> sE() {
        if (this.YM == null) {
            HashMap hashMap = new HashMap();
            this.YM = hashMap;
            hashMap.put("TKVersion", "5.1.4");
            this.YM.put("SDKVersion", BuildConfig.VERSION_NAME);
            this.YM.put("sdkType", 1);
        }
        return this.YM;
    }

    private void su() {
        this.YG = false;
        this.YH = false;
        this.YE = false;
        this.YF = false;
        this.YI = false;
        this.EV = 0L;
        this.YL = 0L;
        this.mInitTime = 0L;
        this.YK = 0L;
    }

    private void sv() {
        if (isLocalDebugEnable()) {
            this.YO = 2000;
            this.YP = 3000;
        }
        bn.runOnUiThreadDelay(this.YX, this.YO);
        int i = this.YP;
        if (i > 0) {
            bn.runOnUiThreadDelay(this.YY, i);
        }
        this.Yz = GlobalThreadPools.Ey().submit(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.1
            @Override // java.lang.Runnable
            public final void run() {
                i.this.EV = SystemClock.elapsedRealtime();
                com.kwad.sdk.core.e.c.d("TKLoadController", "开始读取模板 id: " + i.this.Yw.getTkTemplateId());
                i.this.a(new TKDownloadListener() { // from class: com.kwad.components.core.webview.tachikoma.i.1.1
                    @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                    public final void onFailed(String str) {
                        i.this.aI(str);
                    }

                    @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                    public final void onSuccess(@NonNull StyleTemplate styleTemplate) {
                        i.this.b(styleTemplate);
                    }
                });
            }
        });
    }

    public static boolean sw() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return false;
    }

    private void sy() {
        this.YT.a(!ai.Kx() ? 1 : 0, this.Yw.getTouchCoordsView(), this.Yw.getTKContainer(), this.Yw.getTkTemplateId());
    }

    @Override // com.kwad.components.core.e.e.f
    public void dismiss() {
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sk();
        }
    }

    public final String getTkTemplateId() {
        j jVar = this.Yw;
        if (jVar == null) {
            return null;
        }
        return jVar.getTkTemplateId();
    }

    @Override // com.kwad.components.core.e.e.f
    public void show() {
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sl();
        }
    }

    public final com.kwad.sdk.core.webview.b st() {
        return this.YT;
    }

    public final AdTemplate sz() {
        return this.YT.getAdTemplate();
    }

    public i(long j, Context context) {
        this.YE = false;
        this.YF = false;
        this.YG = false;
        this.YH = false;
        this.YI = false;
        this.YJ = 0;
        this.xr = -1L;
        this.YO = 1000;
        this.YP = 0;
        this.YQ = true;
        this.YT = new com.kwad.sdk.core.webview.e();
        this.YU = new a() { // from class: com.kwad.components.core.webview.tachikoma.i.20
            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onFailed() {
                i.this.b(TKRenderFailReason.RENDER_ERROR);
                com.kwad.sdk.core.e.c.d("TKLoadController", "JS执行成功");
            }

            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onSuccess() {
                com.kwad.sdk.core.e.c.d("TKLoadController", "JS执行成功");
            }
        };
        this.YV = new n() { // from class: com.kwad.components.core.webview.tachikoma.i.22
            @Override // com.kwad.sdk.components.n
            public final void b(com.kwad.sdk.components.j jVar) {
                WeakReference weakReference = (WeakReference) i.YN.get(Integer.valueOf(jVar.getDialogId()));
                if (weakReference != null && weakReference.get() != null) {
                    ((com.kwad.components.core.webview.tachikoma.c.e) weakReference.get()).dismiss();
                }
            }

            @Override // com.kwad.sdk.components.n
            public final void a(com.kwad.sdk.components.j jVar) {
                Activity activity = i.this.mActivity;
                if (activity == null) {
                    com.kwad.sdk.core.c.b.Ct();
                    activity = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activity != null && !activity.isFinishing()) {
                    StyleTemplate styleTemplate = null;
                    final String viewKey = jVar.getViewKey();
                    if (viewKey == null) {
                        styleTemplate = new StyleTemplate();
                        try {
                            styleTemplate.parseJson(styleTemplate, new JSONObject(jVar.getStyleTemplate()));
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.c.printStackTrace(th);
                            jVar.callbackPageStatus(false, "template parse failed");
                            return;
                        }
                    }
                    e.b bVar = new e.b();
                    bVar.d(i.this.mAdResultData);
                    bVar.c(jVar);
                    if (styleTemplate != null) {
                        bVar.a(styleTemplate);
                    }
                    if (viewKey != null) {
                        bVar.a(new k() { // from class: com.kwad.components.core.webview.tachikoma.i.22.1
                            @Override // com.kwad.components.core.webview.tachikoma.k
                            public final com.kwad.sdk.components.l a(Object... objArr) {
                                if (i.this.YA != null) {
                                    return i.this.YA.aR(viewKey);
                                }
                                return null;
                            }
                        });
                    }
                    com.kwad.components.core.webview.tachikoma.c.e b = com.kwad.components.core.webview.tachikoma.c.e.b(bVar);
                    b.show(activity.getFragmentManager(), "");
                    i.YN.put(Integer.valueOf(jVar.getDialogId()), new WeakReference(b));
                    return;
                }
                jVar.callbackPageStatus(false, "no host activity");
            }

            /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
                if (r0 != com.kwad.sdk.core.c.b.getCurrentActivity()) goto L41;
             */
            @Override // com.kwad.sdk.components.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void a(com.kwad.sdk.components.k kVar) {
                Activity activity = i.this.mActivity;
                if (activity != null) {
                    com.kwad.sdk.core.c.b.Ct();
                }
                com.kwad.sdk.core.c.b.Ct();
                activity = com.kwad.sdk.core.c.b.getCurrentActivity();
                if (activity == null) {
                    kVar.callbackPageStatus(false, "no host activity");
                    return;
                }
                Intent intent = kVar.getIntent();
                if (TextUtils.isEmpty(kVar.getTemplateString()) && TextUtils.isEmpty(kVar.getViewKey())) {
                    if (!TextUtils.isEmpty(kVar.getClassName())) {
                        try {
                            com.kwad.sdk.service.b.a(FeedDownloadActivity.class, Class.forName(kVar.getClassName()));
                            intent.setClass(i.this.mContext, FeedDownloadActivity.class);
                        } catch (ClassNotFoundException e) {
                            kVar.callbackPageStatus(false, e.getMessage());
                            return;
                        }
                    }
                } else {
                    com.kwad.sdk.service.b.a(FeedDownloadActivity.class, com.kwad.components.core.r.a.a.class);
                    int qE = com.kwad.components.core.r.a.a.qE();
                    com.kwad.components.core.r.a.a.a(qE, "native_intent", kVar);
                    if (i.this.mAdResultData != null) {
                        intent.putExtra("ad_result_cache_idx", com.kwad.components.core.c.f.mB().i(i.this.mAdResultData));
                    }
                    if (!TextUtils.isEmpty(kVar.getTemplateString())) {
                        intent.putExtra("tk_style_template", kVar.getTemplateString());
                    } else {
                        final String viewKey = kVar.getViewKey();
                        com.kwad.components.core.r.a.a.a(qE, "tk_view_holder", new k() { // from class: com.kwad.components.core.webview.tachikoma.i.22.2
                            @Override // com.kwad.components.core.webview.tachikoma.k
                            public final com.kwad.sdk.components.l a(Object... objArr) {
                                if (i.this.YA != null) {
                                    return i.this.YA.aR(viewKey);
                                }
                                return null;
                            }
                        });
                    }
                    intent.putExtra("tk_id", qE);
                    intent.setClass(i.this.mContext, FeedDownloadActivity.class);
                }
                if (!TextUtils.isEmpty(kVar.getUrl())) {
                    intent.setData(Uri.parse(kVar.getUrl()));
                }
                try {
                    activity.startActivity(intent);
                    kVar.callbackPageStatus(true, null);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                    kVar.callbackPageStatus(false, th.getMessage());
                }
            }
        };
        this.YW = new com.kwad.sdk.components.i() { // from class: com.kwad.components.core.webview.tachikoma.i.23
            @Override // com.kwad.sdk.components.i
            public final com.kwad.sdk.components.h aM(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(jSONObject);
                    return i.this.aB(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                    return null;
                }
            }

            @Override // com.kwad.sdk.components.i
            public final com.kwad.sdk.components.h aN(int i) {
                return i.this.aB(com.kwad.sdk.core.response.b.c.m(com.kwad.components.core.n.a.d.a.a.at(i)));
            }
        };
        this.YX = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.25
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.e.c.d("TKLoadController", "已经超时" + i.this.Yw.getTkTemplateId());
                i.this.sD();
                i.a(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.YY = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.26
            @Override // java.lang.Runnable
            public final void run() {
                i.b(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.gO = new l() { // from class: com.kwad.components.core.webview.tachikoma.i.17
            private void g(double d) {
                i.this.wo.aak = false;
                i.this.wo.aag = false;
                i.this.wo.nD = (int) ((d / 1000.0d) + 0.5d);
                iS();
            }

            private void iS() {
                if (i.this.YB != null && i.this.wo != null) {
                    i.this.YB.a(i.this.wo);
                }
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                i.this.wo.aag = true;
                i.this.wo.aak = false;
                i.this.wo.nD = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.dP(i.this.sz()));
                iS();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                g(0.0d);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPreparing() {
                g(0.0d);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i, int i2) {
                i.this.wo.aak = true;
                i.this.wo.aag = false;
                iS();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j2, long j3) {
                g(j3);
            }
        };
        this.mContext = context;
        this.xr = j;
        this.wo = new y();
    }

    public i(Context context) {
        this(context, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.sdk.components.h aB(final AdTemplate adTemplate) {
        final com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(adTemplate);
        cVar.nR();
        return new com.kwad.sdk.components.h() { // from class: com.kwad.components.core.webview.tachikoma.i.24
            @Override // com.kwad.sdk.components.h
            public final void a(final com.kwad.sdk.components.g gVar) {
                cVar.b(new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.tachikoma.i.24.1
                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFailed() {
                        gVar.onDownloadFailed();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFinished() {
                        gVar.onDownloadFinished();
                    }

                    @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadStarted() {
                        gVar.onDownloadStarted();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onIdle() {
                        gVar.onIdle();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onInstalled() {
                        gVar.onInstalled();
                    }

                    @Override // com.kwad.sdk.core.download.a.a
                    public final void onPaused(int i) {
                        gVar.onPaused(i);
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onProgressUpdate(int i) {
                        gVar.onProgressUpdate(i);
                    }
                });
            }

            @Override // com.kwad.sdk.components.h
            public final void setCustomReportParam(String str) {
                try {
                    cVar.d(new JSONObject(str));
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                }
            }

            @Override // com.kwad.sdk.components.h
            public final void cancelDownload() {
                com.kwad.sdk.core.download.a.cZ(com.kwad.sdk.core.response.b.e.dS(adTemplate));
            }

            @Override // com.kwad.sdk.components.h
            public final void installApp() {
                cVar.nW();
            }

            @Override // com.kwad.sdk.components.h
            public final void openApp() {
                cVar.nU();
            }

            @Override // com.kwad.sdk.components.h
            public final void pauseDownload() {
                cVar.nY();
            }

            @Override // com.kwad.sdk.components.h
            public final void resumeDownload() {
                cVar.nZ();
            }

            @Override // com.kwad.sdk.components.h
            public final void startDownload() {
                cVar.nX();
            }

            @Override // com.kwad.sdk.components.h
            public final void stopDownload() {
                cVar.nY();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(String str) {
        b(TKRenderFailReason.TK_FILE_LOAD_ERROR);
        aK(str);
    }

    public static StyleTemplate aJ(String str) {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return null;
    }

    @Override // com.kwad.sdk.components.m
    public final void callJS(String str) {
        p pVar = this.YA;
        if (pVar != null) {
            pVar.a(str, null, null);
        }
    }

    public i(Context context, int i, int i2) {
        this.YE = false;
        this.YF = false;
        this.YG = false;
        this.YH = false;
        this.YI = false;
        this.YJ = 0;
        this.xr = -1L;
        this.YO = 1000;
        this.YP = 0;
        this.YQ = true;
        this.YT = new com.kwad.sdk.core.webview.e();
        this.YU = new a() { // from class: com.kwad.components.core.webview.tachikoma.i.20
            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onFailed() {
                i.this.b(TKRenderFailReason.RENDER_ERROR);
                com.kwad.sdk.core.e.c.d("TKLoadController", "JS执行成功");
            }

            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onSuccess() {
                com.kwad.sdk.core.e.c.d("TKLoadController", "JS执行成功");
            }
        };
        this.YV = new n() { // from class: com.kwad.components.core.webview.tachikoma.i.22
            @Override // com.kwad.sdk.components.n
            public final void b(com.kwad.sdk.components.j jVar) {
                WeakReference weakReference = (WeakReference) i.YN.get(Integer.valueOf(jVar.getDialogId()));
                if (weakReference != null && weakReference.get() != null) {
                    ((com.kwad.components.core.webview.tachikoma.c.e) weakReference.get()).dismiss();
                }
            }

            @Override // com.kwad.sdk.components.n
            public final void a(com.kwad.sdk.components.j jVar) {
                Activity activity = i.this.mActivity;
                if (activity == null) {
                    com.kwad.sdk.core.c.b.Ct();
                    activity = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activity != null && !activity.isFinishing()) {
                    StyleTemplate styleTemplate = null;
                    final String viewKey = jVar.getViewKey();
                    if (viewKey == null) {
                        styleTemplate = new StyleTemplate();
                        try {
                            styleTemplate.parseJson(styleTemplate, new JSONObject(jVar.getStyleTemplate()));
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.c.printStackTrace(th);
                            jVar.callbackPageStatus(false, "template parse failed");
                            return;
                        }
                    }
                    e.b bVar = new e.b();
                    bVar.d(i.this.mAdResultData);
                    bVar.c(jVar);
                    if (styleTemplate != null) {
                        bVar.a(styleTemplate);
                    }
                    if (viewKey != null) {
                        bVar.a(new k() { // from class: com.kwad.components.core.webview.tachikoma.i.22.1
                            @Override // com.kwad.components.core.webview.tachikoma.k
                            public final com.kwad.sdk.components.l a(Object... objArr) {
                                if (i.this.YA != null) {
                                    return i.this.YA.aR(viewKey);
                                }
                                return null;
                            }
                        });
                    }
                    com.kwad.components.core.webview.tachikoma.c.e b = com.kwad.components.core.webview.tachikoma.c.e.b(bVar);
                    b.show(activity.getFragmentManager(), "");
                    i.YN.put(Integer.valueOf(jVar.getDialogId()), new WeakReference(b));
                    return;
                }
                jVar.callbackPageStatus(false, "no host activity");
            }

            /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
                if (r0 != com.kwad.sdk.core.c.b.getCurrentActivity()) goto L41;
             */
            @Override // com.kwad.sdk.components.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void a(com.kwad.sdk.components.k kVar) {
                Activity activity = i.this.mActivity;
                if (activity != null) {
                    com.kwad.sdk.core.c.b.Ct();
                }
                com.kwad.sdk.core.c.b.Ct();
                activity = com.kwad.sdk.core.c.b.getCurrentActivity();
                if (activity == null) {
                    kVar.callbackPageStatus(false, "no host activity");
                    return;
                }
                Intent intent = kVar.getIntent();
                if (TextUtils.isEmpty(kVar.getTemplateString()) && TextUtils.isEmpty(kVar.getViewKey())) {
                    if (!TextUtils.isEmpty(kVar.getClassName())) {
                        try {
                            com.kwad.sdk.service.b.a(FeedDownloadActivity.class, Class.forName(kVar.getClassName()));
                            intent.setClass(i.this.mContext, FeedDownloadActivity.class);
                        } catch (ClassNotFoundException e) {
                            kVar.callbackPageStatus(false, e.getMessage());
                            return;
                        }
                    }
                } else {
                    com.kwad.sdk.service.b.a(FeedDownloadActivity.class, com.kwad.components.core.r.a.a.class);
                    int qE = com.kwad.components.core.r.a.a.qE();
                    com.kwad.components.core.r.a.a.a(qE, "native_intent", kVar);
                    if (i.this.mAdResultData != null) {
                        intent.putExtra("ad_result_cache_idx", com.kwad.components.core.c.f.mB().i(i.this.mAdResultData));
                    }
                    if (!TextUtils.isEmpty(kVar.getTemplateString())) {
                        intent.putExtra("tk_style_template", kVar.getTemplateString());
                    } else {
                        final String viewKey = kVar.getViewKey();
                        com.kwad.components.core.r.a.a.a(qE, "tk_view_holder", new k() { // from class: com.kwad.components.core.webview.tachikoma.i.22.2
                            @Override // com.kwad.components.core.webview.tachikoma.k
                            public final com.kwad.sdk.components.l a(Object... objArr) {
                                if (i.this.YA != null) {
                                    return i.this.YA.aR(viewKey);
                                }
                                return null;
                            }
                        });
                    }
                    intent.putExtra("tk_id", qE);
                    intent.setClass(i.this.mContext, FeedDownloadActivity.class);
                }
                if (!TextUtils.isEmpty(kVar.getUrl())) {
                    intent.setData(Uri.parse(kVar.getUrl()));
                }
                try {
                    activity.startActivity(intent);
                    kVar.callbackPageStatus(true, null);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                    kVar.callbackPageStatus(false, th.getMessage());
                }
            }
        };
        this.YW = new com.kwad.sdk.components.i() { // from class: com.kwad.components.core.webview.tachikoma.i.23
            @Override // com.kwad.sdk.components.i
            public final com.kwad.sdk.components.h aM(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(jSONObject);
                    return i.this.aB(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                    return null;
                }
            }

            @Override // com.kwad.sdk.components.i
            public final com.kwad.sdk.components.h aN(int i3) {
                return i.this.aB(com.kwad.sdk.core.response.b.c.m(com.kwad.components.core.n.a.d.a.a.at(i3)));
            }
        };
        this.YX = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.25
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.e.c.d("TKLoadController", "已经超时" + i.this.Yw.getTkTemplateId());
                i.this.sD();
                i.a(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.YY = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.26
            @Override // java.lang.Runnable
            public final void run() {
                i.b(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.gO = new l() { // from class: com.kwad.components.core.webview.tachikoma.i.17
            private void g(double d) {
                i.this.wo.aak = false;
                i.this.wo.aag = false;
                i.this.wo.nD = (int) ((d / 1000.0d) + 0.5d);
                iS();
            }

            private void iS() {
                if (i.this.YB != null && i.this.wo != null) {
                    i.this.YB.a(i.this.wo);
                }
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                i.this.wo.aag = true;
                i.this.wo.aak = false;
                i.this.wo.nD = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.dP(i.this.sz()));
                iS();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                g(0.0d);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPreparing() {
                g(0.0d);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i3, int i22) {
                i.this.wo.aak = true;
                i.this.wo.aag = false;
                iS();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j2, long j3) {
                g(j3);
            }
        };
        this.mContext = context;
        this.YO = i;
        this.wo = new y();
        this.YP = i2;
    }

    public i(Context context, boolean z) {
        this.YE = false;
        this.YF = false;
        this.YG = false;
        this.YH = false;
        this.YI = false;
        this.YJ = 0;
        this.xr = -1L;
        this.YO = 1000;
        this.YP = 0;
        this.YQ = true;
        this.YT = new com.kwad.sdk.core.webview.e();
        this.YU = new a() { // from class: com.kwad.components.core.webview.tachikoma.i.20
            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onFailed() {
                i.this.b(TKRenderFailReason.RENDER_ERROR);
                com.kwad.sdk.core.e.c.d("TKLoadController", "JS执行成功");
            }

            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onSuccess() {
                com.kwad.sdk.core.e.c.d("TKLoadController", "JS执行成功");
            }
        };
        this.YV = new n() { // from class: com.kwad.components.core.webview.tachikoma.i.22
            @Override // com.kwad.sdk.components.n
            public final void b(com.kwad.sdk.components.j jVar) {
                WeakReference weakReference = (WeakReference) i.YN.get(Integer.valueOf(jVar.getDialogId()));
                if (weakReference != null && weakReference.get() != null) {
                    ((com.kwad.components.core.webview.tachikoma.c.e) weakReference.get()).dismiss();
                }
            }

            @Override // com.kwad.sdk.components.n
            public final void a(com.kwad.sdk.components.j jVar) {
                Activity activity = i.this.mActivity;
                if (activity == null) {
                    com.kwad.sdk.core.c.b.Ct();
                    activity = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activity != null && !activity.isFinishing()) {
                    StyleTemplate styleTemplate = null;
                    final String viewKey = jVar.getViewKey();
                    if (viewKey == null) {
                        styleTemplate = new StyleTemplate();
                        try {
                            styleTemplate.parseJson(styleTemplate, new JSONObject(jVar.getStyleTemplate()));
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.c.printStackTrace(th);
                            jVar.callbackPageStatus(false, "template parse failed");
                            return;
                        }
                    }
                    e.b bVar = new e.b();
                    bVar.d(i.this.mAdResultData);
                    bVar.c(jVar);
                    if (styleTemplate != null) {
                        bVar.a(styleTemplate);
                    }
                    if (viewKey != null) {
                        bVar.a(new k() { // from class: com.kwad.components.core.webview.tachikoma.i.22.1
                            @Override // com.kwad.components.core.webview.tachikoma.k
                            public final com.kwad.sdk.components.l a(Object... objArr) {
                                if (i.this.YA != null) {
                                    return i.this.YA.aR(viewKey);
                                }
                                return null;
                            }
                        });
                    }
                    com.kwad.components.core.webview.tachikoma.c.e b = com.kwad.components.core.webview.tachikoma.c.e.b(bVar);
                    b.show(activity.getFragmentManager(), "");
                    i.YN.put(Integer.valueOf(jVar.getDialogId()), new WeakReference(b));
                    return;
                }
                jVar.callbackPageStatus(false, "no host activity");
            }

            /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
                if (r0 != com.kwad.sdk.core.c.b.getCurrentActivity()) goto L41;
             */
            @Override // com.kwad.sdk.components.n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void a(com.kwad.sdk.components.k kVar) {
                Activity activity = i.this.mActivity;
                if (activity != null) {
                    com.kwad.sdk.core.c.b.Ct();
                }
                com.kwad.sdk.core.c.b.Ct();
                activity = com.kwad.sdk.core.c.b.getCurrentActivity();
                if (activity == null) {
                    kVar.callbackPageStatus(false, "no host activity");
                    return;
                }
                Intent intent = kVar.getIntent();
                if (TextUtils.isEmpty(kVar.getTemplateString()) && TextUtils.isEmpty(kVar.getViewKey())) {
                    if (!TextUtils.isEmpty(kVar.getClassName())) {
                        try {
                            com.kwad.sdk.service.b.a(FeedDownloadActivity.class, Class.forName(kVar.getClassName()));
                            intent.setClass(i.this.mContext, FeedDownloadActivity.class);
                        } catch (ClassNotFoundException e) {
                            kVar.callbackPageStatus(false, e.getMessage());
                            return;
                        }
                    }
                } else {
                    com.kwad.sdk.service.b.a(FeedDownloadActivity.class, com.kwad.components.core.r.a.a.class);
                    int qE = com.kwad.components.core.r.a.a.qE();
                    com.kwad.components.core.r.a.a.a(qE, "native_intent", kVar);
                    if (i.this.mAdResultData != null) {
                        intent.putExtra("ad_result_cache_idx", com.kwad.components.core.c.f.mB().i(i.this.mAdResultData));
                    }
                    if (!TextUtils.isEmpty(kVar.getTemplateString())) {
                        intent.putExtra("tk_style_template", kVar.getTemplateString());
                    } else {
                        final String viewKey = kVar.getViewKey();
                        com.kwad.components.core.r.a.a.a(qE, "tk_view_holder", new k() { // from class: com.kwad.components.core.webview.tachikoma.i.22.2
                            @Override // com.kwad.components.core.webview.tachikoma.k
                            public final com.kwad.sdk.components.l a(Object... objArr) {
                                if (i.this.YA != null) {
                                    return i.this.YA.aR(viewKey);
                                }
                                return null;
                            }
                        });
                    }
                    intent.putExtra("tk_id", qE);
                    intent.setClass(i.this.mContext, FeedDownloadActivity.class);
                }
                if (!TextUtils.isEmpty(kVar.getUrl())) {
                    intent.setData(Uri.parse(kVar.getUrl()));
                }
                try {
                    activity.startActivity(intent);
                    kVar.callbackPageStatus(true, null);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                    kVar.callbackPageStatus(false, th.getMessage());
                }
            }
        };
        this.YW = new com.kwad.sdk.components.i() { // from class: com.kwad.components.core.webview.tachikoma.i.23
            @Override // com.kwad.sdk.components.i
            public final com.kwad.sdk.components.h aM(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(jSONObject);
                    return i.this.aB(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                    return null;
                }
            }

            @Override // com.kwad.sdk.components.i
            public final com.kwad.sdk.components.h aN(int i3) {
                return i.this.aB(com.kwad.sdk.core.response.b.c.m(com.kwad.components.core.n.a.d.a.a.at(i3)));
            }
        };
        this.YX = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.25
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.e.c.d("TKLoadController", "已经超时" + i.this.Yw.getTkTemplateId());
                i.this.sD();
                i.a(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.YY = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.26
            @Override // java.lang.Runnable
            public final void run() {
                i.b(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.gO = new l() { // from class: com.kwad.components.core.webview.tachikoma.i.17
            private void g(double d) {
                i.this.wo.aak = false;
                i.this.wo.aag = false;
                i.this.wo.nD = (int) ((d / 1000.0d) + 0.5d);
                iS();
            }

            private void iS() {
                if (i.this.YB != null && i.this.wo != null) {
                    i.this.YB.a(i.this.wo);
                }
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                i.this.wo.aag = true;
                i.this.wo.aak = false;
                i.this.wo.nD = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.dP(i.this.sz()));
                iS();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                g(0.0d);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPreparing() {
                g(0.0d);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i3, int i22) {
                i.this.wo.aak = true;
                i.this.wo.aag = false;
                iS();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j2, long j3) {
                g(j3);
            }
        };
        this.mContext = context;
        this.xr = -1L;
        this.YO = 1000;
        this.YQ = z;
        this.wo = new y();
    }

    public static /* synthetic */ boolean c(i iVar, boolean z) {
        iVar.YI = true;
        return true;
    }

    @Override // com.kwad.sdk.core.view.b
    public final void i(View view2, boolean z) {
        av avVar;
        FrameLayout tKContainer = this.Yw.getTKContainer();
        if (tKContainer != null && tKContainer.equals(view2) && (avVar = this.YC) != null) {
            avVar.aT(z);
        }
    }

    public static /* synthetic */ boolean b(i iVar, boolean z) {
        iVar.YF = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TKDownloadListener tKDownloadListener) {
        StyleTemplate sx = sx();
        if (sx == null) {
            tKDownloadListener.onFailed("no template");
            return;
        }
        if (!isLocalDebugEnable()) {
            String o = h.sr().o(sx.templateId, sx.templateVersionCode);
            if (!TextUtils.isEmpty(o) && !isLocalDebugEnable()) {
                sx.jsStr = o;
                sx.tkSouce = 4;
                com.kwad.sdk.core.e.c.d("TKLoadController", "使用TK模板缓存");
                tKDownloadListener.onSuccess(sx);
                return;
            }
        }
        this.Yy.loadTkFileByTemplateId(this.mContext, sx.templateId, sx.templateMd5, sx.templateUrl, sx.templateVersionCode, tKDownloadListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final StyleTemplate styleTemplate) {
        com.kwad.sdk.utils.i.e("", "renderType_tk", styleTemplate.templateId, styleTemplate.templateUrl);
        com.kwad.sdk.core.e.c.d("TKLoadController", "读取完毕，总耗时" + (SystemClock.elapsedRealtime() - this.EV) + ", 读取成功" + styleTemplate.templateId);
        if (this.YE) {
            return;
        }
        com.kwad.sdk.core.e.c.d("TKLoadController", "没有超时");
        bn.c(this.YX);
        bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.12
            @Override // java.lang.Runnable
            public final void run() {
                i iVar = i.this;
                iVar.a(styleTemplate, iVar.YU);
            }
        });
        FrameLayout tKContainer = this.Yw.getTKContainer();
        if (tKContainer instanceof com.kwad.sdk.core.view.d) {
            com.kwad.sdk.core.view.d dVar = (com.kwad.sdk.core.view.d) tKContainer;
            this.YD = dVar;
            dVar.getWindowFocusChangeHelper().a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StyleTemplate styleTemplate, final a aVar) {
        boolean z;
        this.Sq = styleTemplate;
        com.kwad.sdk.core.e.c.w("TKLoadController", "addTKView mTKPlugin.getState(): " + this.Yy.getState());
        if (this.Yy.getState() == ITkOfflineCompo.TKState.SO_FAIL) {
            aK(TKPerformMsg.ERROR_REASON.KSAD_TK_SO_FAIL);
            if (aVar != null) {
                aVar.onFailed();
            }
        } else if (TextUtils.isEmpty(styleTemplate.jsStr)) {
            aL(TKPerformMsg.ERROR_REASON.KSAD_TK_NO_TEMPLATE);
            if (aVar != null) {
                aVar.onFailed();
            }
        } else {
            try {
                sB();
                this.YL = SystemClock.elapsedRealtime();
                p a2 = this.Yy.a(this.mContext, styleTemplate.templateId, styleTemplate.templateVersionCode, styleTemplate.tkSouce, this.YQ);
                com.kwad.components.core.n.a.d.a.a.a(a2.getUniqId(), this.mAdResultData);
                a2.a(this.YV);
                a2.a(this.YW);
                if (this.mAdResultData != null && com.kwad.sdk.core.response.b.c.m(this.mAdResultData).mAdScene != null) {
                    sE().put("adStyle", Integer.valueOf(com.kwad.sdk.core.response.b.c.m(this.mAdResultData).mAdScene.getAdStyle()));
                    sE().put("adScene", com.kwad.sdk.core.response.b.c.m(this.mAdResultData).mAdScene.toJson().toString());
                }
                if (this.Sq != null) {
                    sE().put("styleTemplate", this.Sq.toJson().toString());
                }
                sE().put("adCacheId", Integer.valueOf(a2.getUniqId()));
                sE().put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, KsAdSDKImpl.get().getAppId());
                sE().put("isDebug", com.kwad.components.core.a.mc);
                a2.setCustomEnv(sE());
                this.YA = a2;
                com.kwad.sdk.core.c.b.Ct();
                Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
                if (currentActivity != null) {
                    ViewGroup viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView();
                    if (com.kwad.sdk.d.a.a.C(viewGroup) && com.kwad.sdk.d.a.a.aH(currentActivity) == viewGroup.getHeight()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    sE().put("isImmersiveMode", Boolean.valueOf(z));
                }
                a2.setCustomEnv(sE());
                if (this.Yx != null) {
                    a2.b(this.Yx);
                }
                this.mInitTime = SystemClock.elapsedRealtime() - this.YL;
                this.YK = SystemClock.elapsedRealtime();
                sy();
                a(a2);
                File file = new File(this.Yy.getJsBaseDir(this.mContext, this.Yw.getTkTemplateId()));
                String str = styleTemplate.jsStr;
                a2.a(str, file.getAbsolutePath() + "/", new o() { // from class: com.kwad.components.core.webview.tachikoma.i.21
                    @Override // com.kwad.sdk.components.o
                    public final void onFailed(Throwable th) {
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.onFailed();
                        }
                        i.this.g(th);
                    }

                    @Override // com.kwad.sdk.components.o
                    public final void onSuccess() {
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.onSuccess();
                        }
                    }
                });
                FrameLayout tKContainer = this.Yw.getTKContainer();
                if (tKContainer != null && this.YQ) {
                    View view2 = a2.getView();
                    view2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    tKContainer.addView(view2);
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTrace(th);
                g(th);
                if (aVar != null) {
                    aVar.onFailed();
                }
            }
        }
    }

    private void a(p pVar) {
        com.kwad.components.core.e.d.c cVar;
        if (sz() != null) {
            cVar = new com.kwad.components.core.e.d.c(sz());
        } else {
            cVar = null;
        }
        this.Yw.a(pVar, this.YT);
        a(pVar, new com.kwad.components.core.webview.jshandler.o());
        a(pVar, new com.kwad.components.core.webview.jshandler.p());
        s sVar = new s();
        sVar.a(new s.a() { // from class: com.kwad.components.core.webview.tachikoma.i.3
            @Override // com.kwad.components.core.webview.tachikoma.a.s.a
            public final void a(com.kwad.components.core.webview.tachikoma.b.s sVar2) {
                if (!TextUtils.isEmpty(sVar2.message)) {
                    v.d(i.this.mContext, sVar2.message, 0L);
                }
            }
        });
        a(pVar, sVar);
        a(pVar, c(this.YT));
        a(pVar, new com.kwad.components.core.webview.jshandler.l(this.YT));
        a(pVar, new com.kwad.components.core.webview.jshandler.m(this.YT));
        a(pVar, new com.kwad.sdk.core.webview.d.a());
        a(pVar, new com.kwad.components.core.webview.tachikoma.a.f());
        a(pVar, new x());
        if (nc()) {
            com.kwad.components.core.webview.jshandler.x xVar = new com.kwad.components.core.webview.jshandler.x(this.YT, cVar, this);
            if (!this.YR.equals(com.kwad.sdk.core.response.b.b.cO(this.YT.getAdTemplate()))) {
                com.kwad.components.core.e.e.g.oh().a(this);
            }
            a(pVar, xVar);
        } else {
            a(pVar, new aa(this.YT, cVar, this, (byte) 0));
        }
        a(pVar, new z());
        a(pVar, new com.kwad.components.core.webview.tachikoma.a.k());
        a(pVar, new ad(this.YT));
        a(pVar, new ag(this.YT));
        a(pVar, new ap(this.mContext, sz()));
        ac acVar = new ac(this.YT);
        acVar.a(new ac.b() { // from class: com.kwad.components.core.webview.tachikoma.i.4
            @Override // com.kwad.components.core.webview.jshandler.ac.b
            public final void c(ac.a aVar) {
                i.this.Yw.b(aVar);
            }
        });
        a(pVar, acVar);
        a(pVar, new aj(this.YT, new aj.b() { // from class: com.kwad.components.core.webview.tachikoma.i.5
            @Override // com.kwad.components.core.webview.jshandler.aj.b
            public final void a(aj.a aVar) {
                i.this.b(aVar);
            }
        }));
        a(pVar, new aq(new aq.b() { // from class: com.kwad.components.core.webview.tachikoma.i.6
            @Override // com.kwad.components.core.webview.jshandler.aq.b
            public final void a(aq.a aVar) {
                long j;
                if (aVar.status == 1) {
                    if (!i.this.YF) {
                        bn.c(i.this.YY);
                        i.this.sC();
                        if (i.this.Yw != null) {
                            bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.6.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    i.this.Yw.bF();
                                }
                            });
                            com.kwad.components.core.webview.tachikoma.d.b sS = com.kwad.components.core.webview.tachikoma.d.b.sS();
                            String tkTemplateId = i.this.Yw.getTkTemplateId();
                            long j2 = i.this.YL - i.this.EV;
                            long j3 = i.this.mInitTime;
                            if (i.this.YK > 0) {
                                j = SystemClock.elapsedRealtime() - i.this.YK;
                            } else {
                                j = 0;
                            }
                            sS.c(tkTemplateId, j2, j3, j);
                            return;
                        }
                        return;
                    }
                    i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
                    return;
                }
                i.this.b(TKRenderFailReason.RENDER_ERROR);
                i.this.aL(aVar.errorMsg);
            }
        }));
        aw awVar = new aw();
        this.cQ = awVar;
        a(pVar, awVar);
        this.Yw.a(this.cQ);
        av avVar = new av();
        this.YC = avVar;
        a(pVar, avVar);
        a(pVar, new az(this.YT, cVar));
        com.kwad.components.core.webview.tachikoma.a.p pVar2 = new com.kwad.components.core.webview.tachikoma.a.p();
        this.YB = pVar2;
        a(pVar, pVar2);
        this.Yw.a(this.YB);
        a(pVar, new com.kwad.components.core.webview.jshandler.a(new a.b() { // from class: com.kwad.components.core.webview.tachikoma.i.7
            @Override // com.kwad.components.core.webview.jshandler.a.b
            public final void c(a.C0664a c0664a) {
                i.this.Yw.a(c0664a);
            }
        }));
        if (sz() != null && com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.dP(sz()))) {
            final com.kwad.components.core.webview.tachikoma.a.l lVar = new com.kwad.components.core.webview.tachikoma.a.l();
            a(pVar, lVar);
            this.Vo = new com.kwad.sdk.core.download.d(sz()) { // from class: com.kwad.components.core.webview.tachikoma.i.8
                @Override // com.kwad.sdk.core.download.d, com.kwad.sdk.core.download.c
                public final void b(String str, String str2, com.kwad.sdk.core.download.e eVar) {
                    super.b(str, str2, eVar);
                    com.kwad.components.core.webview.tachikoma.b.b bVar = new com.kwad.components.core.webview.tachikoma.b.b();
                    bVar.ZQ = 1;
                    lVar.a(bVar);
                }
            };
            com.kwad.sdk.core.download.b.BU().a(this.Vo, sz());
        }
        t tVar = new t();
        tVar.a(new t.a() { // from class: com.kwad.components.core.webview.tachikoma.i.9
            @Override // com.kwad.components.core.webview.tachikoma.a.t.a
            public final void b(com.kwad.components.core.webview.tachikoma.b.t tVar2) {
                i.this.Yw.a(tVar2);
            }
        });
        a(pVar, tVar);
        com.kwad.components.core.webview.tachikoma.a.v vVar = new com.kwad.components.core.webview.tachikoma.a.v();
        vVar.a(new v.a() { // from class: com.kwad.components.core.webview.tachikoma.i.10
            @Override // com.kwad.components.core.webview.tachikoma.a.v.a
            public final void b(com.kwad.components.core.webview.tachikoma.b.m mVar) {
                i.this.Yw.a(mVar);
            }
        });
        a(pVar, vVar);
        com.kwad.components.core.webview.tachikoma.a.o oVar = new com.kwad.components.core.webview.tachikoma.a.o();
        a(pVar, oVar);
        this.Yw.a(oVar);
        a(pVar, new r() { // from class: com.kwad.components.core.webview.tachikoma.i.11
            @Override // com.kwad.components.core.webview.tachikoma.a.r
            public final void a(com.kwad.components.core.webview.tachikoma.b.r rVar) {
                super.a(rVar);
                if (i.this.mActivity == null) {
                    i iVar = i.this;
                    com.kwad.sdk.core.c.b.Ct();
                    iVar.mActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (i.this.mActivity != null && !i.this.mActivity.isFinishing()) {
                    if (i.this.Yv != null) {
                        i.this.Yv.dismiss();
                    }
                    e.b bVar = new e.b();
                    bVar.d(i.this.mAdResultData);
                    bVar.aN(rVar.templateId);
                    i.this.Yv = com.kwad.components.core.webview.tachikoma.c.e.b(bVar);
                    i.this.Yv.show(i.this.mActivity.getFragmentManager(), "");
                }
            }
        });
        a(pVar, new com.kwad.components.core.webview.tachikoma.a.c() { // from class: com.kwad.components.core.webview.tachikoma.i.13
            @Override // com.kwad.components.core.webview.tachikoma.a.c
            public final void iV() {
                super.iV();
                if (i.this.Yv != null) {
                    i.this.Yv.dismiss();
                }
                j jVar = i.this.Yw;
                if (jVar != null) {
                    jVar.bG();
                }
            }
        });
        a(pVar, new com.kwad.components.core.webview.jshandler.y(new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.core.webview.tachikoma.i.14
            @Override // com.kwad.sdk.core.webview.d.a.b
            public final void b(WebCloseStatus webCloseStatus) {
                i.this.Yw.a(webCloseStatus);
            }
        }));
        a(pVar, new com.kwad.components.core.webview.tachikoma.a.d() { // from class: com.kwad.components.core.webview.tachikoma.i.15
            @Override // com.kwad.components.core.webview.tachikoma.a.d
            public final void a(com.kwad.components.core.webview.tachikoma.b.g gVar) {
                AdTemplate adTemplate;
                int i = gVar.VA;
                if (i >= 0) {
                    adTemplate = com.kwad.sdk.core.response.b.c.a(com.kwad.components.core.n.a.d.a.a.at(i), gVar.Jw);
                } else {
                    adTemplate = null;
                }
                if (adTemplate == null) {
                    adTemplate = i.this.sz();
                }
                com.kwad.components.core.o.a.pX().a(gVar.actionType, adTemplate, gVar.Xd);
            }
        });
        a(pVar, new com.kwad.components.core.webview.tachikoma.a.j() { // from class: com.kwad.components.core.webview.tachikoma.i.16
            @Override // com.kwad.components.core.webview.tachikoma.a.j
            public final void a(com.kwad.components.core.webview.tachikoma.b.n nVar) {
                super.a(nVar);
                AdWebViewActivityProxy.launch(i.this.mContext, new AdWebViewActivityProxy.a.C0655a().al(nVar.title).am(nVar.url).aD(!nVar.aab).l(i.this.mAdResultData).pa());
            }
        });
        a(pVar, new com.kwad.components.core.webview.tachikoma.a.a(sz()));
        a(pVar, new com.kwad.components.core.webview.tachikoma.a(sz()));
        a(this.YT, cVar, pVar, this.Yw.getTKContainer());
    }

    public static void a(p pVar, com.kwad.sdk.core.webview.c.a aVar) {
        pVar.c(aVar);
    }

    public static /* synthetic */ boolean a(i iVar, boolean z) {
        iVar.YE = true;
        return true;
    }

    private void aK(String str) {
        f(this.Yw.getTkTemplateId(), str);
        StyleTemplate sx = sx();
        if (sx == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.YJ).setRenderState(4).setErrorReason(str).setTemplateId(this.Yw.getTkTemplateId()).setVersionCode(String.valueOf(sx.templateVersionCode)).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(aj.a aVar) {
        FrameLayout tKContainer = this.Yw.getTKContainer();
        if (tKContainer != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tKContainer.getLayoutParams();
            layoutParams.height = com.kwad.sdk.d.a.a.a(this.mContext, aVar.height);
            layoutParams.leftMargin = com.kwad.sdk.d.a.a.a(this.mContext, aVar.leftMargin);
            layoutParams.rightMargin = com.kwad.sdk.d.a.a.a(this.mContext, aVar.rightMargin);
            layoutParams.bottomMargin = com.kwad.sdk.d.a.a.a(this.mContext, aVar.bottomMargin);
            layoutParams.width = -1;
            tKContainer.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(String str) {
        com.kwad.sdk.core.e.c.d("TKLoadController", "logTkRenderFail : " + str + ", templateId = " + this.Yw.getTkTemplateId());
        g(this.Yw.getTkTemplateId(), str);
        if (this.YG && !this.YH) {
            this.YH = true;
            TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.YJ).setRenderState(2).setErrorReason(str).setTemplateId(this.Yw.getTkTemplateId()).setVersionCode(String.valueOf(this.Sq.templateVersionCode)).toJson());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Throwable th) {
        com.kwad.sdk.core.e.c.d("TKLoadController", "logTkRenderFail : " + th + ", templateId = " + this.Yw.getTkTemplateId());
        String tkTemplateId = this.Yw.getTkTemplateId();
        StringBuilder sb = new StringBuilder("error:");
        sb.append(th.toString());
        g(tkTemplateId, sb.toString());
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.YJ).setRenderState(3).setErrorReason(th.toString()).setTemplateId(this.Yw.getTkTemplateId()).setVersionCode(String.valueOf(this.Sq.templateVersionCode)).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final TKRenderFailReason tKRenderFailReason) {
        bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.2
            @Override // java.lang.Runnable
            public final void run() {
                if (i.this.YI) {
                    return;
                }
                i.c(i.this, true);
                i.this.Yw.a(tKRenderFailReason);
                com.kwad.components.core.e.e.g.oh().b(i.this);
                com.kwad.components.core.webview.tachikoma.d.b.sS().p(i.this.YR, i.this.YS);
            }
        });
    }

    public final void a(StyleTemplate styleTemplate) {
        this.Sq = styleTemplate;
    }

    public ak c(com.kwad.sdk.core.webview.b bVar) {
        return new ak(bVar);
    }

    private void sA() {
        StyleTemplate sx = sx();
        if (sx == null) {
            return;
        }
        this.YJ = sx.tkSouce;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.YJ).setRenderState(-1).setTemplateId(this.Yw.getTkTemplateId()).setVersionCode(String.valueOf(sx.templateVersionCode)).toJson());
    }

    private void sB() {
        this.YG = true;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.YJ).setRenderState(0).setTemplateId(this.Yw.getTkTemplateId()).setVersionCode(String.valueOf(this.Sq.templateVersionCode)).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sC() {
        com.kwad.sdk.core.e.c.d("TKLoadController", "logTkRenderSuccess, templateId = " + this.Yw.getTkTemplateId());
        if (this.YG && !this.YH) {
            this.YH = true;
            long j = 0;
            if (this.YK > 0) {
                j = SystemClock.elapsedRealtime() - this.YK;
            }
            TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.YJ).setRenderState(1).setRenderTime(j).setTemplateId(this.Yw.getTkTemplateId()).setLoadTime(this.YL - this.EV).setInitTime(this.mInitTime).setVersionCode(String.valueOf(this.Sq.templateVersionCode)).toJson());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sD() {
        com.kwad.sdk.core.e.c.d("TKLoadController", "logTkRenderFail : timeout, templateId = " + this.Yw.getTkTemplateId());
        StyleTemplate sx = sx();
        if (sx == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.YJ).setRenderState(3).setErrorReason("timeout").setTemplateId(this.Yw.getTkTemplateId()).setVersionCode(String.valueOf(sx.templateVersionCode)).toJson());
    }

    public void jn() {
        com.kwad.sdk.core.view.d dVar = this.YD;
        if (dVar != null) {
            dVar.getWindowFocusChangeHelper().b(this);
            this.YD = null;
        }
        Future<?> future = this.Yz;
        if (future != null) {
            future.cancel(true);
        }
        bn.c(this.YX);
        bn.c(this.YY);
        com.kwad.components.core.e.e.g.oh().b(this);
        if (this.Vo != null) {
            com.kwad.sdk.core.download.b.BU().a(this.Vo);
        }
        com.kwad.components.core.webview.tachikoma.c.e eVar = this.Yv;
        if (eVar != null) {
            eVar.dismiss();
        }
        if (com.kwad.components.core.a.mc.booleanValue()) {
            sF();
        }
        com.kwad.components.core.n.a.d.c cVar = this.Yy;
        if (cVar != null) {
            cVar.onDestroy();
        }
        final p pVar = this.YA;
        if (pVar != null) {
            this.YA = null;
            bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.18
                @Override // java.lang.Runnable
                public final void run() {
                    p pVar2 = pVar;
                    if (pVar2 != null) {
                        pVar2.onDestroy();
                    }
                }
            });
        }
    }

    private void sF() {
        String str;
        if (this.Yy != null && this.YA != null) {
            File file = new File(new File(this.Yy.getJsBaseDir(this.mContext, this.Yw.getTkTemplateId())), "kcov.json");
            if (!file.exists()) {
                return;
            }
            try {
                String V = q.V(file);
                if (TextUtils.isEmpty(V)) {
                    return;
                }
                com.kwad.sdk.core.e.c.d("TKLoadController", "kcov.json:" + V);
                JSONObject jSONObject = new JSONObject(V);
                final String string = jSONObject.getString("gitHeadCommit");
                final String string2 = jSONObject.getString("coverageApi");
                final String string3 = jSONObject.getString("coverageTaskId");
                final String string4 = jSONObject.getString("currentBranch");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                    if (("尝试获取覆盖率统计... " + this.Sq) != null) {
                        str = this.Sq.templateId;
                    } else {
                        str = "";
                    }
                    com.kwad.sdk.core.e.c.d("TKLoadController", str);
                    Object execute = this.YA.execute("JSON.stringify(this.__coverage__)");
                    if (!(execute instanceof String)) {
                        return;
                    }
                    final String str2 = (String) execute;
                    com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.19
                        @Override // java.lang.Runnable
                        public final void run() {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("coverage_task_id", Integer.valueOf(string3));
                                jSONObject2.put("user", "");
                                jSONObject2.put("timestamp", System.currentTimeMillis() / 1000);
                                jSONObject2.put("branch_name", string4);
                                jSONObject2.put("version", BuildConfig.VERSION_NAME);
                                jSONObject2.put("tk_version", String.valueOf(i.this.Sq.templateVersionCode));
                                jSONObject2.put("tk_template_ids", i.this.Sq.templateId);
                            } catch (JSONException e) {
                                com.kwad.sdk.core.e.c.printStackTrace(e);
                            }
                            AdHttpProxy xI = com.kwad.sdk.f.xI();
                            com.kwad.sdk.core.network.c doPost = xI.doPost(string2 + "/analysis/add/pkg/info", (Map<String, String>) null, jSONObject2);
                            if (doPost.CB()) {
                                com.kwad.sdk.core.e.c.d("TKLoadController", "上传TK覆盖率pkg完成:" + doPost.atm);
                            } else {
                                com.kwad.sdk.core.e.c.d("TKLoadController", "上传覆盖率pkg失败");
                            }
                            AdHttpProxy xI2 = com.kwad.sdk.f.xI();
                            com.kwad.sdk.core.network.c doPost2 = xI2.doPost(string2 + "/attachment/ec", (Map<String, String>) null, new AdHttpBodyBuilder() { // from class: com.kwad.components.core.webview.tachikoma.i.19.1
                                @Override // com.kwad.sdk.export.proxy.AdHttpBodyBuilder
                                public final void buildFormData(AdHttpFormDataBuilder adHttpFormDataBuilder) {
                                    adHttpFormDataBuilder.addFormDataPart("task_id", string3);
                                    adHttpFormDataBuilder.addFormDataPart("os_build_model", Build.MODEL);
                                    adHttpFormDataBuilder.addFormDataPart("os_build_serial", "unknown");
                                    adHttpFormDataBuilder.addFormDataPart("os_build_brand", Build.BRAND);
                                    adHttpFormDataBuilder.addFormDataPart("app_version", BuildConfig.VERSION_NAME);
                                    adHttpFormDataBuilder.addFormDataPart("git_head_commit", string);
                                    adHttpFormDataBuilder.addFormDataPart("execute_type", "manual_qa");
                                    adHttpFormDataBuilder.addFormDataPart("uid", "");
                                    adHttpFormDataBuilder.addFormDataPart("did", com.kwad.sdk.utils.av.getDeviceId());
                                    adHttpFormDataBuilder.addFormDataPart("execute_user", "");
                                    adHttpFormDataBuilder.addFormDataPart("url_type", "transform");
                                    try {
                                        adHttpFormDataBuilder.addFormDataPart("file", UUID.randomUUID().toString() + ".json", "application/octet-stream", str2.getBytes("UTF-8"));
                                    } catch (UnsupportedEncodingException e2) {
                                        com.kwad.sdk.core.e.c.printStackTrace(e2);
                                    }
                                }
                            });
                            if (doPost2.CB()) {
                                com.kwad.sdk.core.e.c.d("TKLoadController", "上传TK覆盖率完成:" + doPost2.atm);
                                return;
                            }
                            com.kwad.sdk.core.e.c.d("TKLoadController", "上传TK覆盖率失败");
                        }
                    });
                    return;
                }
                com.kwad.sdk.core.e.c.d("TKLoadController", "kcov.json数据不合法，缺少关键字段gitHeadCommit | coverageApi | coverageTaskId | currentBranch");
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            }
        }
    }

    private StyleTemplate sx() {
        String tkTemplateId = this.Yw.getTkTemplateId();
        StyleTemplate styleTemplate = this.Sq;
        if (styleTemplate != null) {
            tkTemplateId = styleTemplate.templateId;
        }
        StyleTemplate aJ = aJ(tkTemplateId);
        if (aJ != null) {
            return aJ;
        }
        if (isLocalDebugEnable()) {
            StyleTemplate styleTemplate2 = new StyleTemplate();
            styleTemplate2.templateId = tkTemplateId;
            styleTemplate2.templateVersion = "1.0.4";
            styleTemplate2.templateVersionCode = 104;
            if (sw()) {
                styleTemplate2.templateUrl = "http://" + OfflineHostProvider.getApi().env().localIpAddress() + ":9292/" + tkTemplateId + ".104.coverage.zip";
            } else {
                styleTemplate2.templateUrl = "http://" + OfflineHostProvider.getApi().env().localIpAddress() + ":9292/" + tkTemplateId + ".104.zip";
            }
            return styleTemplate2;
        }
        StyleTemplate styleTemplate3 = this.Sq;
        if (styleTemplate3 != null) {
            return styleTemplate3;
        }
        AdMatrixInfo.MatrixTemplate k = com.kwad.sdk.core.response.b.b.k(sz(), this.Yw.getTkTemplateId());
        if (k == null) {
            return null;
        }
        com.kwad.components.core.n.a.d.c cVar = this.Yy;
        if (cVar == null) {
            StyleTemplate styleTemplate4 = new StyleTemplate();
            styleTemplate4.templateId = k.templateId;
            styleTemplate4.templateMd5 = k.templateMd5;
            styleTemplate4.templateUrl = k.templateUrl;
            styleTemplate4.templateVersionCode = (int) k.templateVersionCode;
            styleTemplate4.tkSouce = 0;
            return styleTemplate4;
        }
        return cVar.checkStyleTemplateById(this.mContext, k.templateId, k.templateMd5, k.templateUrl, (int) k.templateVersionCode);
    }

    public void a(@Nullable Activity activity, AdResultData adResultData, j jVar) {
        this.mActivity = activity;
        this.mAdResultData = adResultData;
        this.YT.d(adResultData);
        this.Yw = jVar;
        this.YR = jVar.getTkTemplateId();
        this.YS = this.Yw.getTKReaderScene();
        su();
        FrameLayout tKContainer = this.Yw.getTKContainer();
        if (tKContainer != null) {
            tKContainer.removeAllViews();
        }
        if (!com.kwad.sdk.core.config.d.AM()) {
            b(TKRenderFailReason.SWITCH_CLOSE);
            return;
        }
        this.Yy = (com.kwad.components.core.n.a.d.c) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.d.c.class);
        sA();
        com.kwad.sdk.core.e.c.d("TKLoadController", "bind mTKPlugin: " + this.Yy);
        if (TextUtils.isEmpty(this.YR)) {
            com.kwad.sdk.commercial.f.a.e(sz(), this.YS);
        }
        if (this.Yy != null) {
            sv();
            return;
        }
        b(TKRenderFailReason.PLUGIN_NOT_READY);
        f(this.YR, TKPerformMsg.ERROR_REASON.KSAD_TK_OFFLINE_FAILED);
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.YJ).setRenderState(4).setErrorReason(TKPerformMsg.ERROR_REASON.KSAD_TK_OFFLINE_FAILED).setTemplateId(this.YR).toJson());
    }

    public final void a(com.kwad.sdk.core.webview.c.g gVar) {
        this.Yx = gVar;
    }

    @Override // com.kwad.sdk.core.webview.d.a.a
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        j jVar = this.Yw;
        if (jVar != null) {
            jVar.a(aVar);
        }
    }

    public final void a(String str, Object obj) {
        sE().put(str, obj);
    }
}
