package d.a.j0.r.m;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tbadk.coreExtra.share.ShareItem;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ShareItem f49836a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f49837b;

    /* renamed from: c  reason: collision with root package name */
    public int f49838c;

    /* renamed from: d  reason: collision with root package name */
    public DialogInterface.OnCancelListener f49839d;

    public a(ShareItem shareItem, Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        this.f49836a = shareItem;
        this.f49837b = activity;
        this.f49839d = onCancelListener;
    }

    public a(ShareItem shareItem, Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        this.f49836a = shareItem;
        this.f49837b = activity;
        this.f49838c = i2;
        this.f49839d = onCancelListener;
    }
}
