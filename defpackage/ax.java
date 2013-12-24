package defpackage;

import com.baidu.cloudsdk.DefaultBaiduListener;
import com.baidu.cloudsdk.IBaiduListener;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: ax  reason: default package */
/* loaded from: classes.dex */
class ax extends DefaultBaiduListener {
    final /* synthetic */ av a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ax(av avVar, IBaiduListener iBaiduListener) {
        super(iBaiduListener);
        this.a = avVar;
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete() {
        super.onComplete();
        this.a.dismiss();
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONArray jSONArray) {
        super.onComplete(jSONArray);
        this.a.dismiss();
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONObject jSONObject) {
        super.onComplete(jSONObject);
        this.a.dismiss();
    }
}
