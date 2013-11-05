package defpackage;

import com.baidu.cloudsdk.DefaultBaiduListener;
import com.baidu.cloudsdk.IBaiduListener;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: ax  reason: default package */
/* loaded from: classes.dex */
class ax extends DefaultBaiduListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ av f369a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ax(av avVar, IBaiduListener iBaiduListener) {
        super(iBaiduListener);
        this.f369a = avVar;
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete() {
        super.onComplete();
        this.f369a.dismiss();
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONArray jSONArray) {
        super.onComplete(jSONArray);
        this.f369a.dismiss();
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONObject jSONObject) {
        super.onComplete(jSONObject);
        this.f369a.dismiss();
    }
}
