package defpackage;

import com.baidu.cloudsdk.DefaultBaiduListener;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.share.ShareContent;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: d  reason: default package */
/* loaded from: classes.dex */
public class d extends DefaultBaiduListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShareContent f2731a;
    final /* synthetic */ boolean b;
    final /* synthetic */ ae c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(ae aeVar, IBaiduListener iBaiduListener, ShareContent shareContent, boolean z) {
        super(iBaiduListener);
        this.c = aeVar;
        this.f2731a = shareContent;
        this.b = z;
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete() {
        this.c.share(this.f2731a, this.mListener, this.b);
    }
}
