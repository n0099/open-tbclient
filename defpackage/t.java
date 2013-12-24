package defpackage;

import android.view.View;
import com.baidu.cloudsdk.social.share.ui.ShareDialog;
/* renamed from: t  reason: default package */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ ShareDialog a;

    public t(ShareDialog shareDialog) {
        this.a = shareDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.dismiss();
    }
}
