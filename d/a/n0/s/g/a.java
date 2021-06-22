package d.a.n0.s.g;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import d.a.c.a.j;
import d.a.n0.r.s.a;
import d.a.o0.e3.z;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.a.n0.s.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1214a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f54449e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f54450f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnCancelListener f54451g;

        public C1214a(int i2, Context context, DialogInterface.OnCancelListener onCancelListener) {
            this.f54449e = i2;
            this.f54450f = context;
            this.f54451g = onCancelListener;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            a.d(this.f54449e, this.f54450f);
            aVar.dismiss();
            DialogInterface.OnCancelListener onCancelListener = this.f54451g;
            if (onCancelListener != null) {
                onCancelListener.onCancel(aVar.getDialog());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnCancelListener f54452e;

        public b(DialogInterface.OnCancelListener onCancelListener) {
            this.f54452e = onCancelListener;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
            DialogInterface.OnCancelListener onCancelListener = this.f54452e;
            if (onCancelListener != null) {
                onCancelListener.onCancel(aVar.getDialog());
            }
        }
    }

    public static boolean b(Context context, int i2) {
        if (i2 == 3 || i2 == 2) {
            return z.b(context, "com.tencent.mm");
        }
        if (i2 == 8 || i2 == 4) {
            return z.b(context, "com.tencent.mobileqq");
        }
        if (i2 == 6) {
            return z.b(context, "com.sina.weibo");
        }
        return true;
    }

    public static String c(int i2, Context context) {
        if (i2 == 3 || i2 == 2) {
            return String.format(context.getString(R.string.command_share_paste), context.getString(R.string.wechat));
        }
        if (i2 == 8 || i2 == 4) {
            return String.format(context.getString(R.string.command_share_paste), context.getString(R.string.qq));
        }
        if (i2 == 6) {
            return String.format(context.getString(R.string.command_share_paste), context.getString(R.string.sinaweibo));
        }
        return null;
    }

    public static void d(int i2, Context context) {
        Intent intent;
        if (i2 == 3 || i2 == 2) {
            if (!b(context, i2)) {
                BdToast.c(context.getApplicationContext(), context.getText(R.string.share_wechat_not_install)).q();
                return;
            }
            intent = new Intent("android.intent.action.MAIN");
            ComponentName componentName = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.setComponent(componentName);
            context.startActivity(intent);
        } else if (i2 == 8 || i2 == 4) {
            if (!b(context, i2)) {
                BdToast.c(context.getApplicationContext(), context.getText(R.string.share_qq_not_install)).q();
                return;
            }
            intent = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mobileqq");
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            context.startActivity(intent);
        } else if (i2 != 6) {
            intent = null;
        } else if (!b(context, i2)) {
            BdToast.c(context.getApplicationContext(), context.getText(R.string.share_sina_weibo_not_install)).q();
            return;
        } else {
            intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("sinaweibo://splash"));
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        if (intent != null) {
            context.startActivity(intent);
        }
    }

    public static void e(ShareItem shareItem, Context context, int i2, DialogInterface.OnCancelListener onCancelListener) {
        if (shareItem == null || TextUtils.isEmpty(shareItem.s) || TextUtils.isEmpty(shareItem.r) || !(context instanceof Activity)) {
            return;
        }
        d.a.c.e.p.a.a(shareItem.n0);
        Activity activity = (Activity) context;
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(activity);
        aVar.setTitle(context.getString(R.string.command_share_tips));
        aVar.setMessage(shareItem.n0);
        aVar.setAutoNight(false);
        aVar.setCancelable(true);
        aVar.setTitleShowCenter(true);
        aVar.setPositiveButton(c(i2, context), new C1214a(i2, context, onCancelListener));
        aVar.setNegativeButton(R.string.cancel, new b(onCancelListener)).create(j.a(activity));
        if (onCancelListener != null) {
            aVar.setOnCalcelListener(onCancelListener);
        }
        aVar.show();
    }
}
