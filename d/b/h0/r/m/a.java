package d.b.h0.r.m;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tbadk.coreExtra.share.ShareItem;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ShareItem f51052a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f51053b;

    /* renamed from: c  reason: collision with root package name */
    public int f51054c;

    /* renamed from: d  reason: collision with root package name */
    public DialogInterface.OnCancelListener f51055d;

    public a(ShareItem shareItem, Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        this.f51052a = shareItem;
        this.f51053b = activity;
        this.f51055d = onCancelListener;
    }

    public a(ShareItem shareItem, Activity activity, int i, DialogInterface.OnCancelListener onCancelListener) {
        this.f51052a = shareItem;
        this.f51053b = activity;
        this.f51054c = i;
        this.f51055d = onCancelListener;
    }
}
