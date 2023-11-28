package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.idc.DomainException;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class l<R extends f, T extends BaseResultData> extends a<R> {
    public static final String TAG = "Networking";
    @Nullable
    public g<R, T> mListener = null;
    public final com.kwad.sdk.core.network.b.b mMonitorRecorder = com.kwad.sdk.core.network.b.c.CY();

    public void afterParseData(T t) {
    }

    public boolean enableMonitorReport() {
        return true;
    }

    public boolean isPostByJson() {
        return true;
    }

    @NonNull
    public abstract T parseData(String str);

    @Override // com.kwad.sdk.core.network.a
    public void cancel() {
        super.cancel();
        this.mListener = null;
    }

    private void checkAndSetHasData(BaseResultData baseResultData) {
        if (baseResultData.hasData()) {
            this.mMonitorRecorder.ct(1);
        }
    }

    private void checkIpDirect(c cVar) {
        com.kwad.sdk.service.a.f fVar;
        if (cVar != null && !cVar.CB() && (fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) != null && ag.isNetworkConnected(fVar.getContext())) {
            com.kwad.sdk.ip.direct.a.Hz();
        }
    }

    private String getHostTypeByUrl(@NonNull String str) {
        if (str.contains("/rest/zt/emoticon/package/list")) {
            return "zt";
        }
        return "api";
    }

    private void notifyOnStartRequest(@NonNull R r) {
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onStartRequest(r);
    }

    private void onRequest(@NonNull g<R, T> gVar) {
        this.mMonitorRecorder.CR();
        this.mListener = gVar;
    }

    private void setMonitorRequestId(@NonNull f fVar) {
        Map<String, String> header = fVar.getHeader();
        if (header != null) {
            String str = header.get(d.TRACK_ID_KEY);
            if (!TextUtils.isEmpty(str)) {
                this.mMonitorRecorder.dB(str);
            }
        }
    }

    public void request(@NonNull g<R, T> gVar) {
        onRequest(gVar);
        fetch();
    }

    private void notifyOnErrorListener(@NonNull R r, int i, String str) {
        h.CC().b(r, i);
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onError(r, i, str);
        this.mMonitorRecorder.CX();
    }

    private void notifyOnErrorListener(@NonNull R r, c cVar, String str) {
        String url = r.getUrl();
        DomainException domainException = new DomainException(cVar.atk, cVar.atl);
        com.kwad.sdk.core.network.idc.a.CJ().a(url, getHostTypeByUrl(url), domainException);
        notifyOnErrorListener((l<R, T>) r, cVar.code, str);
    }

    private void notifyOnSuccess(@NonNull R r, T t) {
        if (com.kwad.sdk.core.network.idc.a.CJ().CL()) {
            String hostTypeByUrl = getHostTypeByUrl(r.getUrl());
            if ("api".equals(hostTypeByUrl)) {
                com.kwad.sdk.core.network.idc.a.CJ().dr(hostTypeByUrl);
            }
        }
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onSuccess(r, t);
        this.mMonitorRecorder.CX();
    }

    private void parseCommonData(String str, String str2) {
        try {
            q.CF().S(str, new JSONObject(str2).optString("requestSessionData"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.network.a
    @WorkerThread
    public void fetchImpl() {
        try {
            this.mMonitorRecorder.CV();
            R createRequest = createRequest();
            notifyOnStartRequest(createRequest);
            this.mMonitorRecorder.dx(createRequest.getUrl()).dy(createRequest.getUrl());
            setMonitorRequestId(createRequest);
            if (!ag.isNetworkConnected(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())) {
                notifyOnErrorListener((l<R, T>) createRequest, e.atq.errorCode, e.atq.msg);
                this.mMonitorRecorder.cs(e.atq.errorCode).dz(e.atq.msg);
            } else {
                c cVar = null;
                try {
                    String url = createRequest.getUrl();
                    AdHttpProxy xI = com.kwad.sdk.f.xI();
                    if (xI instanceof com.kwad.sdk.core.network.c.b) {
                        this.mMonitorRecorder.dA("ok_http").CU();
                    } else {
                        this.mMonitorRecorder.dA("http").CU();
                    }
                    if (isPostByJson()) {
                        cVar = xI.doPost(url, createRequest.getHeader(), createRequest.getBody());
                    } else {
                        cVar = xI.doPost(url, createRequest.getHeader(), createRequest.getBodyMap());
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                    com.kwad.sdk.core.network.b.b bVar = this.mMonitorRecorder;
                    bVar.dz("requestError:" + e.getMessage());
                }
                this.mMonitorRecorder.CS().CT().cv(com.kwad.sdk.ip.direct.a.getType());
                try {
                    onResponse(createRequest, cVar);
                } catch (Exception e2) {
                    com.kwad.sdk.core.network.b.b bVar2 = this.mMonitorRecorder;
                    bVar2.dz("onResponseError:" + e2.getMessage());
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
                }
            }
            try {
                if (enableMonitorReport()) {
                    this.mMonitorRecorder.report();
                }
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            try {
                try {
                    com.kwad.sdk.core.network.b.b bVar3 = this.mMonitorRecorder;
                    bVar3.dz("requestError:" + th.getMessage());
                } catch (Throwable th2) {
                    try {
                        if (enableMonitorReport()) {
                            this.mMonitorRecorder.report();
                        }
                    } catch (Exception unused2) {
                    }
                    throw th2;
                }
            } catch (Exception unused3) {
            }
            com.kwad.sdk.core.e.c.printStackTrace(th);
            try {
                if (enableMonitorReport()) {
                    this.mMonitorRecorder.report();
                }
            } catch (Exception unused4) {
            }
        }
    }

    @Override // com.kwad.sdk.core.network.a
    public void onResponse(R r, c cVar) {
        String str;
        if (cVar == null) {
            e eVar = e.atq;
            notifyOnErrorListener((l<R, T>) r, eVar.errorCode, eVar.msg);
            this.mMonitorRecorder.dz("responseBase is null");
            com.kwad.sdk.core.e.c.e(TAG, "request responseBase is null");
            return;
        }
        this.mMonitorRecorder.cs(cVar.code);
        checkIpDirect(cVar);
        if (!TextUtils.isEmpty(cVar.atm) && cVar.CB()) {
            try {
                parseCommonData(r.getUrl(), cVar.atm);
                T parseData = parseData(cVar.atm);
                afterParseData(parseData);
                String str2 = cVar.atm;
                if (str2 != null) {
                    this.mMonitorRecorder.ab(str2.length()).CW().cu(parseData.result);
                }
                if (!parseData.isResultOk()) {
                    com.kwad.sdk.core.network.b.b bVar = this.mMonitorRecorder;
                    bVar.dz("serverCodeError:" + parseData.result + ":" + parseData.errorMsg);
                    if (parseData.notifyFailOnResultError()) {
                        notifyOnErrorListener((l<R, T>) r, parseData.result, parseData.errorMsg);
                        return;
                    }
                }
                if (parseData.isDataEmpty()) {
                    int i = e.ats.errorCode;
                    if (!TextUtils.isEmpty(parseData.testErrorMsg)) {
                        str = parseData.testErrorMsg;
                    } else {
                        str = e.ats.msg;
                    }
                    notifyOnErrorListener((l<R, T>) r, i, str);
                    return;
                }
                checkAndSetHasData(parseData);
                notifyOnSuccess(r, parseData);
                return;
            } catch (Exception e) {
                e eVar2 = e.atr;
                notifyOnErrorListener((l<R, T>) r, eVar2.errorCode, eVar2.msg);
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                com.kwad.sdk.core.network.b.b bVar2 = this.mMonitorRecorder;
                bVar2.dz("parseDataError:" + e.getMessage());
                return;
            }
        }
        notifyOnErrorListener((l<R, T>) r, cVar, "网络错误");
        com.kwad.sdk.core.network.b.b bVar3 = this.mMonitorRecorder;
        bVar3.dz("httpCodeError:" + cVar.code + ":" + cVar.atm);
        StringBuilder sb = new StringBuilder("request responseBase httpCodeError:");
        sb.append(cVar.code);
        com.kwad.sdk.core.e.c.w(TAG, sb.toString());
    }
}
