package defpackage;

import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.DefaultBaiduListener;
/* renamed from: ar  reason: default package */
/* loaded from: classes.dex */
class ar extends DefaultBaiduListener {
    final /* synthetic */ an a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(an anVar) {
        this.a = anVar;
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onCancel() {
        this.a.g.a(this.a.a, false);
        this.a.f.setChecked(false);
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete() {
        this.a.g.a(this.a.a, true);
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onError(BaiduException baiduException) {
        this.a.g.a(this.a.a, false);
        this.a.f.setChecked(false);
    }
}
