package defpackage;

import android.text.TextUtils;
import android.view.View;
import com.baidu.cloudsdk.social.share.ui.ShareDialog;
/* renamed from: v  reason: default package */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ ShareDialog a;

    public v(ShareDialog shareDialog) {
        this.a = shareDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        str = this.a.e;
        if (TextUtils.isEmpty(str)) {
            this.a.a("share_content_empty");
            return;
        }
        int i = this.a.mMaxLength;
        str2 = this.a.e;
        if (i - str2.length() >= 0) {
            this.a.doShare();
        } else {
            this.a.a("share_content_exceed");
        }
    }
}
