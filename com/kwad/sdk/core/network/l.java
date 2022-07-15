package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.components.offline.api.core.api.INet;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.idc.DomainException;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class l<R extends g, T extends BaseResultData> extends a<R> {
    public static final int NETWORK_OK = 200;
    public static final String TAG = "Networking";
    @Nullable
    public h<R, T> mListener = null;
    public final com.kwad.sdk.core.network.a.b mMonitorRecorder = com.kwad.sdk.core.network.a.c.a();

    private void checkAndSetHasData(BaseResultData baseResultData) {
        if (baseResultData.hasData()) {
            this.mMonitorRecorder.b(1);
        }
    }

    private void checkIpDirect(c cVar) {
        com.kwad.sdk.service.kwai.d dVar;
        if (cVar == null || cVar.a == 200 || (dVar = (com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)) == null || !ac.b(dVar.a())) {
            return;
        }
        com.kwad.sdk.f.kwai.a.f();
    }

    private void notifyOnErrorListener(@NonNull R r, int i, String str) {
        h<R, T> hVar = this.mListener;
        if (hVar == null) {
            return;
        }
        hVar.onError(r, i, str);
        this.mMonitorRecorder.g();
    }

    private void notifyOnErrorListener(@NonNull R r, c cVar, String str) {
        String url = r.getUrl();
        com.kwad.sdk.core.network.idc.a.a().a(url, url.contains("/rest/zt/emoticon/package/list") ? INet.HostType.ZT : "api", new DomainException(cVar.b, cVar.c));
        notifyOnErrorListener((l<R, T>) r, cVar.a, str);
    }

    private void notifyOnStartRequest(@NonNull R r) {
        h<R, T> hVar = this.mListener;
        if (hVar == null) {
            return;
        }
        hVar.onStartRequest(r);
    }

    private void notifyOnSuccess(@NonNull R r, T t) {
        h<R, T> hVar = this.mListener;
        if (hVar == null) {
            return;
        }
        hVar.onSuccess(r, t);
        this.mMonitorRecorder.g();
    }

    private void onRequest(@NonNull h<R, T> hVar) {
        this.mMonitorRecorder.a();
        this.mListener = hVar;
    }

    private void parseCommonData(String str, String str2) {
        try {
            o.a().a(str, new JSONObject(str2).optString("requestSessionData"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void setMonitorRequestId(@NonNull g gVar) {
        Map<String, String> header = gVar.getHeader();
        if (header != null) {
            String str = header.get(d.TRACK_ID_KEY);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mMonitorRecorder.e(str);
        }
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
    @WorkerThread
    public void fetchImpl() {
        try {
            try {
                this.mMonitorRecorder.e();
                R createRequest = createRequest();
                notifyOnStartRequest(createRequest);
                this.mMonitorRecorder.a(createRequest.getUrl()).b(createRequest.getUrl());
                setMonitorRequestId(createRequest);
                if (ac.b(((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a())) {
                    c cVar = null;
                    try {
                        String url = createRequest.getUrl();
                        AdHttpProxy adHttpProxy = (AdHttpProxy) ((com.kwad.sdk.service.kwai.e) ServiceProvider.a(com.kwad.sdk.service.kwai.e.class)).a();
                        (adHttpProxy instanceof com.kwad.sdk.core.network.b.b ? this.mMonitorRecorder.d("ok_http") : this.mMonitorRecorder.d("http")).d();
                        cVar = isPostByJson() ? adHttpProxy.doPost(url, createRequest.getHeader(), createRequest.getBody()) : adHttpProxy.doPost(url, createRequest.getHeader(), createRequest.getBodyMap());
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.b.b(e);
                        com.kwad.sdk.core.network.a.b bVar = this.mMonitorRecorder;
                        bVar.c("requestError:" + e.getMessage());
                    }
                    this.mMonitorRecorder.b().c().d(com.kwad.sdk.f.kwai.a.e());
                    try {
                        onResponse(createRequest, cVar);
                    } catch (Exception e2) {
                        com.kwad.sdk.core.network.a.b bVar2 = this.mMonitorRecorder;
                        bVar2.c("onResponseError:" + e2.getMessage());
                        com.kwad.sdk.core.d.b.b(e2);
                    }
                } else {
                    notifyOnErrorListener((l<R, T>) createRequest, f.d.p, f.d.q);
                    this.mMonitorRecorder.a(f.d.p).c(f.d.q);
                }
                try {
                    if (enableMonitorReport()) {
                        this.mMonitorRecorder.h();
                    }
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                try {
                    if (enableMonitorReport()) {
                        this.mMonitorRecorder.h();
                    }
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (Exception e3) {
            try {
                com.kwad.sdk.core.network.a.b bVar3 = this.mMonitorRecorder;
                bVar3.c("requestError:" + e3.getMessage());
            } catch (Exception unused3) {
            }
            com.kwad.sdk.core.d.b.a(e3);
            try {
                if (enableMonitorReport()) {
                    this.mMonitorRecorder.h();
                }
            } catch (Exception unused4) {
            }
        }
    }

    public boolean isPostByJson() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.a
    public void onResponse(R r, c cVar) {
        if (cVar == null) {
            f fVar = f.d;
            notifyOnErrorListener((l<R, T>) r, fVar.p, fVar.q);
            this.mMonitorRecorder.c("responseBase is null");
            com.kwad.sdk.core.d.b.e(TAG, "request responseBase is null");
            return;
        }
        this.mMonitorRecorder.a(cVar.a);
        checkIpDirect(cVar);
        if (TextUtils.isEmpty(cVar.d) || cVar.a != 200) {
            notifyOnErrorListener((l<R, T>) r, cVar, "网络错误");
            com.kwad.sdk.core.network.a.b bVar = this.mMonitorRecorder;
            bVar.c("httpCodeError:" + cVar.a + ":" + cVar.d);
            StringBuilder sb = new StringBuilder("request responseBase httpCodeError:");
            sb.append(cVar.a);
            com.kwad.sdk.core.d.b.e(TAG, sb.toString());
            return;
        }
        try {
            parseCommonData(r.getUrl(), cVar.d);
            T parseData = parseData(cVar.d);
            String str = cVar.d;
            if (str != null) {
                this.mMonitorRecorder.a(str.length()).f().c(parseData.result);
            }
            if (parseData.isResultOk()) {
                if (parseData.isDataEmpty()) {
                    f fVar2 = f.f;
                    notifyOnErrorListener((l<R, T>) r, fVar2.p, fVar2.q);
                    return;
                }
                checkAndSetHasData(parseData);
                notifyOnSuccess(r, parseData);
                return;
            }
            notifyOnErrorListener((l<R, T>) r, parseData.result, parseData.errorMsg);
            com.kwad.sdk.core.network.a.b bVar2 = this.mMonitorRecorder;
            bVar2.c("serverCodeError:" + parseData.result + ":" + parseData.errorMsg);
        } catch (Exception e) {
            f fVar3 = f.e;
            notifyOnErrorListener((l<R, T>) r, fVar3.p, fVar3.q);
            com.kwad.sdk.core.d.b.b(e);
            com.kwad.sdk.core.network.a.b bVar3 = this.mMonitorRecorder;
            bVar3.c("parseDataError:" + e.getMessage());
        }
    }

    @NonNull
    public abstract T parseData(String str);

    public void request(@NonNull h<R, T> hVar) {
        onRequest(hVar);
        fetch();
    }
}
