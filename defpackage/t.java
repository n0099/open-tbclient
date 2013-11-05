package defpackage;

import android.view.View;
import com.baidu.cloudsdk.social.share.ui.ShareDialog;
/* renamed from: t  reason: default package */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShareDialog f2939a;

    public t(ShareDialog shareDialog) {
        this.f2939a = shareDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2939a.dismiss();
    }
}
