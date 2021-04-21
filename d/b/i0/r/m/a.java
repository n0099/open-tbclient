package d.b.i0.r.m;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tbadk.coreExtra.share.ShareItem;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ShareItem f51388a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f51389b;

    /* renamed from: c  reason: collision with root package name */
    public int f51390c;

    /* renamed from: d  reason: collision with root package name */
    public DialogInterface.OnCancelListener f51391d;

    public a(ShareItem shareItem, Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        this.f51388a = shareItem;
        this.f51389b = activity;
        this.f51391d = onCancelListener;
    }

    public a(ShareItem shareItem, Activity activity, int i, DialogInterface.OnCancelListener onCancelListener) {
        this.f51388a = shareItem;
        this.f51389b = activity;
        this.f51390c = i;
        this.f51391d = onCancelListener;
    }
}
