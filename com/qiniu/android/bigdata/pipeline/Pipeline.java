package com.qiniu.android.bigdata.pipeline;

import com.qiniu.android.http.CompletionHandler;
import com.qiniu.android.http.ResponseInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Pipeline {

    /* loaded from: classes5.dex */
    public interface PumpCompleteHandler {
        void a(ResponseInfo responseInfo);
    }

    /* renamed from: com.qiniu.android.bigdata.pipeline.Pipeline$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass1 implements CompletionHandler {
        final /* synthetic */ PumpCompleteHandler nCi;

        @Override // com.qiniu.android.http.CompletionHandler
        public void a(ResponseInfo responseInfo, JSONObject jSONObject) {
            this.nCi.a(responseInfo);
        }
    }
}
