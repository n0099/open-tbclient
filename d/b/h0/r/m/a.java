package d.b.h0.r.m;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tbadk.coreExtra.share.ShareItem;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ShareItem f50645a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f50646b;

    /* renamed from: c  reason: collision with root package name */
    public int f50647c;

    /* renamed from: d  reason: collision with root package name */
    public DialogInterface.OnCancelListener f50648d;

    public a(ShareItem shareItem, Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        this.f50645a = shareItem;
        this.f50646b = activity;
        this.f50648d = onCancelListener;
    }

    public a(ShareItem shareItem, Activity activity, int i, DialogInterface.OnCancelListener onCancelListener) {
        this.f50645a = shareItem;
        this.f50646b = activity;
        this.f50647c = i;
        this.f50648d = onCancelListener;
    }
}
