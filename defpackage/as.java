package defpackage;

import com.baidu.cloudsdk.DefaultBaiduListener;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: as  reason: default package */
/* loaded from: classes.dex */
public class as extends DefaultBaiduListener {
    final /* synthetic */ at a;
    final /* synthetic */ af b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(af afVar, at atVar) {
        this.b = afVar;
        this.a = atVar;
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONObject jSONObject) {
        this.a.a(jSONObject.optString("username"));
        this.b.notifyDataSetChanged();
    }
}
