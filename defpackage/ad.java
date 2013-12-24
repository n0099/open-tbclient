package defpackage;

import android.widget.LinearLayout;
import android.widget.Toast;
import com.baidu.cloudsdk.assets.DrawableUtils;
import com.baidu.cloudsdk.social.share.ui.ShareDialog;
import com.baidu.location.LocationClientOption;
/* renamed from: ad  reason: default package */
/* loaded from: classes.dex */
public class ad implements Runnable {
    final /* synthetic */ LinearLayout a;
    final /* synthetic */ ShareDialog b;

    public ad(ShareDialog shareDialog, LinearLayout linearLayout) {
        this.b = shareDialog;
        this.a = linearLayout;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast toast = new Toast(this.b.getContext());
        toast.setGravity(53, DrawableUtils.fix720px(this.b.getContext(), 66), DrawableUtils.fix720px(this.b.getContext(), 456));
        toast.setView(this.a);
        toast.setDuration(LocationClientOption.MIN_SCAN_SPAN);
        toast.show();
    }
}
