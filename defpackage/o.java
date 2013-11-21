package defpackage;

import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.http.JsonHttpResponseHandler;
import com.baidu.cloudsdk.social.core.BaseConfig;
import org.json.JSONObject;
/* renamed from: o  reason: default package */
/* loaded from: classes.dex */
public class o extends JsonHttpResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IBaiduListener f2867a;
    final /* synthetic */ String b;
    final /* synthetic */ BaseConfig c;

    public o(BaseConfig baseConfig, IBaiduListener iBaiduListener, String str) {
        this.c = baseConfig;
        this.f2867a = iBaiduListener;
        this.b = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
    public void onFailure(Throwable th, String str) {
        this.f2867a.onError(new BaiduException(th));
    }

    @Override // com.baidu.cloudsdk.common.http.JsonHttpResponseHandler
    protected void onSuccess(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.f2867a.onError(new BaiduException("Load config from server failed, url: " + this.b));
            return;
        }
        this.c.a(jSONObject);
        this.f2867a.onComplete(jSONObject);
    }
}
