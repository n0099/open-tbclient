package defpackage;

import android.view.View;
import android.widget.ImageButton;
import com.baidu.cloudsdk.social.share.ui.ShareDialog;
/* renamed from: aa  reason: default package */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImageButton f261a;
    final /* synthetic */ ShareDialog b;

    public aa(ShareDialog shareDialog, ImageButton imageButton) {
        this.b = shareDialog;
        this.f261a = imageButton;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        ShareDialog shareDialog = this.b;
        z = this.b.f;
        shareDialog.f = !z;
        ImageButton imageButton = this.f261a;
        z2 = this.b.f;
        imageButton.setVisibility(z2 ? 0 : 4);
    }
}
