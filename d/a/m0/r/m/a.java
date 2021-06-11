package d.a.m0.r.m;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tbadk.coreExtra.share.ShareItem;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ShareItem f53556a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f53557b;

    /* renamed from: c  reason: collision with root package name */
    public int f53558c;

    /* renamed from: d  reason: collision with root package name */
    public DialogInterface.OnCancelListener f53559d;

    public a(ShareItem shareItem, Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        this.f53556a = shareItem;
        this.f53557b = activity;
        this.f53559d = onCancelListener;
    }

    public a(ShareItem shareItem, Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        this.f53556a = shareItem;
        this.f53557b = activity;
        this.f53558c = i2;
        this.f53559d = onCancelListener;
    }
}
