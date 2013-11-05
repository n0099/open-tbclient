package defpackage;

import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.DefaultBaiduListener;
/* renamed from: ar  reason: default package */
/* loaded from: classes.dex */
class ar extends DefaultBaiduListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ an f363a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(an anVar) {
        this.f363a = anVar;
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onCancel() {
        this.f363a.g.a(this.f363a.f269a, false);
        this.f363a.f.setChecked(false);
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete() {
        this.f363a.g.a(this.f363a.f269a, true);
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onError(BaiduException baiduException) {
        this.f363a.g.a(this.f363a.f269a, false);
        this.f363a.f.setChecked(false);
    }
}
