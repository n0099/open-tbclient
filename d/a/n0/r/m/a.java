package d.a.n0.r.m;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tbadk.coreExtra.share.ShareItem;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ShareItem f53663a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f53664b;

    /* renamed from: c  reason: collision with root package name */
    public int f53665c;

    /* renamed from: d  reason: collision with root package name */
    public DialogInterface.OnCancelListener f53666d;

    public a(ShareItem shareItem, Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        this.f53663a = shareItem;
        this.f53664b = activity;
        this.f53666d = onCancelListener;
    }

    public a(ShareItem shareItem, Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        this.f53663a = shareItem;
        this.f53664b = activity;
        this.f53665c = i2;
        this.f53666d = onCancelListener;
    }
}
