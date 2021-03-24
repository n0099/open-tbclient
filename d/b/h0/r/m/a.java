package d.b.h0.r.m;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tbadk.coreExtra.share.ShareItem;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ShareItem f50644a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f50645b;

    /* renamed from: c  reason: collision with root package name */
    public int f50646c;

    /* renamed from: d  reason: collision with root package name */
    public DialogInterface.OnCancelListener f50647d;

    public a(ShareItem shareItem, Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        this.f50644a = shareItem;
        this.f50645b = activity;
        this.f50647d = onCancelListener;
    }

    public a(ShareItem shareItem, Activity activity, int i, DialogInterface.OnCancelListener onCancelListener) {
        this.f50644a = shareItem;
        this.f50645b = activity;
        this.f50646c = i;
        this.f50647d = onCancelListener;
    }
}
