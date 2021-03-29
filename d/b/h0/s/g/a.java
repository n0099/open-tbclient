package d.b.h0.s.g;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import d.b.b.a.j;
import d.b.h0.r.s.a;
import d.b.i0.c3.z;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.b.h0.s.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1097a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f51356e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f51357f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnCancelListener f51358g;

        public C1097a(int i, Context context, DialogInterface.OnCancelListener onCancelListener) {
            this.f51356e = i;
            this.f51357f = context;
            this.f51358g = onCancelListener;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            a.d(this.f51356e, this.f51357f);
            aVar.dismiss();
            DialogInterface.OnCancelListener onCancelListener = this.f51358g;
            if (onCancelListener != null) {
                onCancelListener.onCancel(aVar.getDialog());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnCancelListener f51359e;

        public b(DialogInterface.OnCancelListener onCancelListener) {
            this.f51359e = onCancelListener;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            DialogInterface.OnCancelListener onCancelListener = this.f51359e;
            if (onCancelListener != null) {
                onCancelListener.onCancel(aVar.getDialog());
            }
        }
    }

    public static boolean b(Context context, int i) {
        if (i == 3 || i == 2) {
            return z.b(context, "com.tencent.mm");
        }
        if (i == 8 || i == 4) {
            return z.b(context, "com.tencent.mobileqq");
        }
        if (i == 6) {
            return z.b(context, "com.sina.weibo");
        }
        return true;
    }

    public static String c(int i, Context context) {
        if (i == 3 || i == 2) {
            return String.format(context.getString(R.string.command_share_paste), context.getString(R.string.wechat));
        }
        if (i == 8 || i == 4) {
            return String.format(context.getString(R.string.command_share_paste), context.getString(R.string.qq));
        }
        if (i == 6) {
            return String.format(context.getString(R.string.command_share_paste), context.getString(R.string.sinaweibo));
        }
        return null;
    }

    public static void d(int i, Context context) {
        Intent intent;
        if (i == 3 || i == 2) {
            if (!b(context, i)) {
                BdToast.c(context.getApplicationContext(), context.getText(R.string.share_wechat_not_install)).q();
                return;
            }
            intent = new Intent("android.intent.action.MAIN");
            ComponentName componentName = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(268435456);
            intent.setComponent(componentName);
            context.startActivity(intent);
        } else if (i == 8 || i == 4) {
            if (!b(context, i)) {
                BdToast.c(context.getApplicationContext(), context.getText(R.string.share_qq_not_install)).q();
                return;
            }
            intent = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mobileqq");
            intent.addFlags(268435456);
            context.startActivity(intent);
        } else if (i != 6) {
            intent = null;
        } else if (!b(context, i)) {
            BdToast.c(context.getApplicationContext(), context.getText(R.string.share_sina_weibo_not_install)).q();
            return;
        } else {
            intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("sinaweibo://splash"));
            intent.addFlags(268435456);
        }
        if (intent != null) {
            context.startActivity(intent);
        }
    }

    public static void e(ShareItem shareItem, Context context, int i, DialogInterface.OnCancelListener onCancelListener) {
        if (shareItem == null || TextUtils.isEmpty(shareItem.s) || TextUtils.isEmpty(shareItem.r) || !(context instanceof Activity)) {
            return;
        }
        d.b.b.e.p.a.a(shareItem.l0);
        Activity activity = (Activity) context;
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(activity);
        aVar.setTitle(context.getString(R.string.command_share_tips));
        aVar.setMessage(shareItem.l0);
        aVar.setAutoNight(false);
        aVar.setCancelable(true);
        aVar.setTitleShowCenter(true);
        aVar.setPositiveButton(c(i, context), new C1097a(i, context, onCancelListener));
        aVar.setNegativeButton(R.string.cancel, new b(onCancelListener)).create(j.a(activity));
        if (onCancelListener != null) {
            aVar.setOnCalcelListener(onCancelListener);
        }
        aVar.show();
    }
}
