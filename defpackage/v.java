package defpackage;

import android.text.TextUtils;
import android.view.View;
import com.baidu.cloudsdk.social.share.ui.ShareDialog;
/* renamed from: v  reason: default package */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShareDialog f2973a;

    public v(ShareDialog shareDialog) {
        this.f2973a = shareDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        str = this.f2973a.e;
        if (TextUtils.isEmpty(str)) {
            this.f2973a.a("share_content_empty");
            return;
        }
        int i = this.f2973a.mMaxLength;
        str2 = this.f2973a.e;
        if (i - str2.length() >= 0) {
            this.f2973a.doShare();
        } else {
            this.f2973a.a("share_content_exceed");
        }
    }
}
