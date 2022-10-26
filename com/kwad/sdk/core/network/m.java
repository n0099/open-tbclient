package com.kwad.sdk.core.network;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.api.INet;
import com.kwad.sdk.core.network.idc.DomainException;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ae;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class m extends a {
    public static final String TAG = "Networking";
    public h mListener = null;
    public final com.kwad.sdk.core.network.a.b mMonitorRecorder = com.kwad.sdk.core.network.a.c.tT();

    private void checkAndSetHasData(BaseResultData baseResultData) {
        if (baseResultData.hasData()) {
            this.mMonitorRecorder.aC(1);
        }
    }

    private void checkIpDirect(c cVar) {
        com.kwad.sdk.service.kwai.d dVar;
        if (cVar == null || cVar.tx() || (dVar = (com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)) == null || !ae.isNetworkConnected(dVar.getContext())) {
            return;
        }
        com.kwad.sdk.ip.direct.a.xE();
    }

    private void notifyOnErrorListener(g gVar, int i, String str) {
        i.tB().b(gVar, i);
        h hVar = this.mListener;
        if (hVar == null) {
            return;
        }
        hVar.onError(gVar, i, str);
        this.mMonitorRecorder.tS();
    }

    private void notifyOnErrorListener(g gVar, c cVar, String str) {
        String url = gVar.getUrl();
        com.kwad.sdk.core.network.idc.a.tH().a(url, url.contains("/rest/zt/emoticon/package/list") ? INet.HostType.ZT : "api", new DomainException(cVar.XT, cVar.XU));
        notifyOnErrorListener(gVar, cVar.code, str);
    }

    private void notifyOnStartRequest(g gVar) {
        h hVar = this.mListener;
        if (hVar == null) {
            return;
        }
        hVar.onStartRequest(gVar);
    }

    private void notifyOnSuccess(g gVar, BaseResultData baseResultData) {
        h hVar = this.mListener;
        if (hVar == null) {
            return;
        }
        hVar.onSuccess(gVar, baseResultData);
        this.mMonitorRecorder.tS();
    }

    private void onRequest(h hVar) {
        this.mMonitorRecorder.tM();
        this.mListener = hVar;
    }

    private void parseCommonData(String str, String str2) {
        try {
            p.tE().D(str, new JSONObject(str2).optString("requestSessionData"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void setMonitorRequestId(g gVar) {
        Map header = gVar.getHeader();
        if (header != null) {
            String str = (String) header.get(d.TRACK_ID_KEY);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mMonitorRecorder.cg(str);
        }
    }

    public void afterParseData(BaseResultData baseResultData) {
    }

    @Override // com.kwad.sdk.core.network.a
    public void cancel() {
        super.cancel();
        this.mListener = null;
    }

    public boolean enableMonitorReport() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.a
    public void fetchImpl() {
        try {
            try {
                this.mMonitorRecorder.tQ();
                g createRequest = createRequest();
                notifyOnStartRequest(createRequest);
                this.mMonitorRecorder.cc(createRequest.getUrl()).cd(createRequest.getUrl());
                setMonitorRequestId(createRequest);
                if (ae.isNetworkConnected(((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext())) {
                    c cVar = null;
                    try {
                        String url = createRequest.getUrl();
                        AdHttpProxy adHttpProxy = (AdHttpProxy) ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).lm();
                        (adHttpProxy instanceof com.kwad.sdk.core.network.b.b ? this.mMonitorRecorder.cf("ok_http") : this.mMonitorRecorder.cf("http")).tP();
                        cVar = isPostByJson() ? adHttpProxy.doPost(url, createRequest.getHeader(), createRequest.getBody()) : adHttpProxy.doPost(url, createRequest.getHeader(), createRequest.getBodyMap());
                    } catch (Exception e) {
                        com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                        com.kwad.sdk.core.network.a.b bVar = this.mMonitorRecorder;
                        bVar.ce("requestError:" + e.getMessage());
                    }
                    this.mMonitorRecorder.tN().tO().aE(com.kwad.sdk.ip.direct.a.getType());
                    try {
                        onResponse(createRequest, cVar);
                    } catch (Exception e2) {
                        com.kwad.sdk.core.network.a.b bVar2 = this.mMonitorRecorder;
                        bVar2.ce("onResponseError:" + e2.getMessage());
                        com.kwad.sdk.core.e.b.printStackTraceOnly(e2);
                    }
                } else {
                    notifyOnErrorListener(createRequest, f.Yb.errorCode, f.Yb.Qd);
                    this.mMonitorRecorder.aB(f.Yb.errorCode).ce(f.Yb.Qd);
                }
                try {
                    if (enableMonitorReport()) {
                        this.mMonitorRecorder.of();
                    }
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                try {
                    if (enableMonitorReport()) {
                        this.mMonitorRecorder.of();
                    }
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (Exception e3) {
            try {
                com.kwad.sdk.core.network.a.b bVar3 = this.mMonitorRecorder;
                bVar3.ce("requestError:" + e3.getMessage());
            } catch (Exception unused3) {
            }
            com.kwad.sdk.core.e.b.printStackTrace(e3);
            try {
                if (enableMonitorReport()) {
                    this.mMonitorRecorder.of();
                }
            } catch (Exception unused4) {
            }
        }
    }

    public boolean isPostByJson() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.a
    public void onResponse(g gVar, c cVar) {
        if (cVar == null) {
            f fVar = f.Yb;
            notifyOnErrorListener(gVar, fVar.errorCode, fVar.Qd);
            this.mMonitorRecorder.ce("responseBase is null");
            com.kwad.sdk.core.e.b.e(TAG, "request responseBase is null");
            return;
        }
        this.mMonitorRecorder.aB(cVar.code);
        checkIpDirect(cVar);
        if (TextUtils.isEmpty(cVar.XV) || !cVar.tx()) {
            notifyOnErrorListener(gVar, cVar, "网络错误");
            com.kwad.sdk.core.network.a.b bVar = this.mMonitorRecorder;
            bVar.ce("httpCodeError:" + cVar.code + ":" + cVar.XV);
            StringBuilder sb = new StringBuilder("request responseBase httpCodeError:");
            sb.append(cVar.code);
            com.kwad.sdk.core.e.b.e(TAG, sb.toString());
            return;
        }
        try {
            parseCommonData(gVar.getUrl(), cVar.XV);
            BaseResultData parseData = parseData(cVar.XV);
            afterParseData(parseData);
            String str = cVar.XV;
            if (str != null) {
                this.mMonitorRecorder.z(str.length()).tR().aD(parseData.result);
            }
            if (parseData.isResultOk()) {
                if (parseData.isDataEmpty()) {
                    f fVar2 = f.Yd;
                    notifyOnErrorListener(gVar, fVar2.errorCode, fVar2.Qd);
                    return;
                }
                checkAndSetHasData(parseData);
                notifyOnSuccess(gVar, parseData);
                return;
            }
            notifyOnErrorListener(gVar, parseData.result, parseData.errorMsg);
            com.kwad.sdk.core.network.a.b bVar2 = this.mMonitorRecorder;
            bVar2.ce("serverCodeError:" + parseData.result + ":" + parseData.errorMsg);
        } catch (Exception e) {
            f fVar3 = f.Yc;
            notifyOnErrorListener(gVar, fVar3.errorCode, fVar3.Qd);
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            com.kwad.sdk.core.network.a.b bVar3 = this.mMonitorRecorder;
            bVar3.ce("parseDataError:" + e.getMessage());
        }
    }

    public abstract BaseResultData parseData(String str);

    public void request(h hVar) {
        onRequest(hVar);
        fetch();
    }
}
