package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.NormalResultData;
import com.kwad.sdk.core.network.n;
/* loaded from: classes10.dex */
public abstract class m<R extends n, T extends NormalResultData> extends a<R> {
    public static final String TAG = "NormalNetworking";
    @Nullable
    public g<R, T> mListener = null;

    public abstract T createResponseData();

    @Override // com.kwad.sdk.core.network.a
    public void cancel() {
        super.cancel();
        this.mListener = null;
    }

    private void onRequest(@NonNull g<R, T> gVar) {
        this.mListener = gVar;
    }

    public void request(@NonNull g<R, T> gVar) {
        onRequest(gVar);
        fetch();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.kwad.sdk.core.network.m<R extends com.kwad.sdk.core.network.n, T extends com.kwad.sdk.core.network.NormalResultData> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.core.network.a
    public void fetchImpl() {
        n nVar = (n) createRequest();
        c cVar = null;
        try {
            String url = nVar.getUrl();
            if (nVar.getMethod().equals("POST")) {
                cVar = com.kwad.sdk.f.xI().doPost(url, nVar.getHeader(), nVar.getBody());
            } else {
                cVar = com.kwad.sdk.f.xI().doGet(url, nVar.getHeader());
            }
            if (cVar != null && cVar.code == 200) {
                com.kwad.sdk.core.e.c.d(TAG, "normal request success:" + cVar.code);
            } else {
                com.kwad.sdk.core.e.c.d(TAG, "normal request failed");
            }
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            if (0 == 0) {
                cVar = new c();
            }
            cVar.code = -1;
            cVar.atl = e;
        }
        onResponse((m<R, T>) nVar, cVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.kwad.sdk.core.network.m<R extends com.kwad.sdk.core.network.n, T extends com.kwad.sdk.core.network.NormalResultData> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.core.network.a
    public /* bridge */ /* synthetic */ void onResponse(f fVar, c cVar) {
        onResponse((m<R, T>) ((n) fVar), cVar);
    }

    public void parseResponse(T t, c cVar) {
        t.parseResponse(cVar);
    }

    public void onResponse(R r, c cVar) {
        String str;
        if (this.mListener == null) {
            return;
        }
        if (cVar.CB()) {
            T createResponseData = createResponseData();
            parseResponse(createResponseData, cVar);
            this.mListener.onSuccess(r, createResponseData);
            return;
        }
        g<R, T> gVar = this.mListener;
        int i = cVar.code;
        Exception exc = cVar.atl;
        if (exc != null) {
            str = exc.getMessage();
        } else {
            str = "";
        }
        gVar.onError(r, i, str);
    }
}
