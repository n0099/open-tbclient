package d.a.r0.s.g;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.j;
import d.a.r0.r.s.a;
import d.a.s0.h3.z;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.r0.s.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1274a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f56590e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f56591f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnCancelListener f56592g;

        public C1274a(int i2, Context context, DialogInterface.OnCancelListener onCancelListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), context, onCancelListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56590e = i2;
            this.f56591f = context;
            this.f56592g = onCancelListener;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                a.d(this.f56590e, this.f56591f);
                aVar.dismiss();
                DialogInterface.OnCancelListener onCancelListener = this.f56592g;
                if (onCancelListener != null) {
                    onCancelListener.onCancel(aVar.getDialog());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnCancelListener f56593e;

        public b(DialogInterface.OnCancelListener onCancelListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {onCancelListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56593e = onCancelListener;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                DialogInterface.OnCancelListener onCancelListener = this.f56593e;
                if (onCancelListener != null) {
                    onCancelListener.onCancel(aVar.getDialog());
                }
            }
        }
    }

    public static boolean b(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i2)) == null) {
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
        return invokeLI.booleanValue;
    }

    public static String c(int i2, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i2, context)) == null) {
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
        return (String) invokeIL.objValue;
    }

    public static void d(int i2, Context context) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, null, i2, context) == null) {
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
    }

    public static void e(ShareItem shareItem, Context context, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLIL(65540, null, shareItem, context, i2, onCancelListener) == null) || shareItem == null || TextUtils.isEmpty(shareItem.s) || TextUtils.isEmpty(shareItem.r) || !(context instanceof Activity)) {
            return;
        }
        d.a.c.e.p.a.a(shareItem.n0);
        Activity activity = (Activity) context;
        d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(activity);
        aVar.setTitle(context.getString(R.string.command_share_tips));
        aVar.setMessage(shareItem.n0);
        aVar.setAutoNight(false);
        aVar.setCancelable(true);
        aVar.setTitleShowCenter(true);
        aVar.setPositiveButton(c(i2, context), new C1274a(i2, context, onCancelListener));
        aVar.setNegativeButton(R.string.cancel, new b(onCancelListener)).create(j.a(activity));
        if (onCancelListener != null) {
            aVar.setOnCalcelListener(onCancelListener);
        }
        aVar.show();
    }
}
