package d.a.i0.r.m;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tbadk.coreExtra.share.ShareItem;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ShareItem f49006a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f49007b;

    /* renamed from: c  reason: collision with root package name */
    public int f49008c;

    /* renamed from: d  reason: collision with root package name */
    public DialogInterface.OnCancelListener f49009d;

    public a(ShareItem shareItem, Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        this.f49006a = shareItem;
        this.f49007b = activity;
        this.f49009d = onCancelListener;
    }

    public a(ShareItem shareItem, Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        this.f49006a = shareItem;
        this.f49007b = activity;
        this.f49008c = i2;
        this.f49009d = onCancelListener;
    }
}
