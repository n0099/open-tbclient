package com.repackage;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.content.pm.ShortcutManagerCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b42;
import com.repackage.fl2;
import com.repackage.lz2;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public final class u53 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements b42.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ el2 a;
        public final /* synthetic */ fl2.a b;
        public final /* synthetic */ int c;
        public final /* synthetic */ f d;

        public a(el2 el2Var, fl2.a aVar, int i, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {el2Var, aVar, Integer.valueOf(i), fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = el2Var;
            this.b = aVar;
            this.c = i;
            this.d = fVar;
        }

        @Override // com.repackage.b42.b
        public void a(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) || h03.M() == null) {
                return;
            }
            SwanAppActivity w = g03.K().w();
            u53.q(w, this.a, this.b, bitmap, this.c);
            u53.r(w, this.a, this.d);
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ el2 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ int c;
        public final /* synthetic */ el2 d;
        public final /* synthetic */ Bitmap e;
        public final /* synthetic */ fl2 f;

        public b(el2 el2Var, Context context, int i, el2 el2Var2, Bitmap bitmap, fl2 fl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {el2Var, context, Integer.valueOf(i), el2Var2, bitmap, fl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = el2Var;
            this.b = context;
            this.c = i;
            this.d = el2Var2;
            this.e = bitmap;
            this.f = fl2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gk1 X = oj2.X();
                String q1 = this.a.q1();
                if (!TextUtils.isEmpty(q1) && X.b(this.b, q1)) {
                    u53.n("click");
                    if (X.a(this.b, q1)) {
                        if (this.c != 1) {
                            u53.u(this.b);
                            return;
                        }
                        return;
                    } else if (X.c(this.b, q1)) {
                        u53.n("show");
                        if (this.c != 1) {
                            u53.u(this.b);
                            return;
                        }
                        return;
                    }
                }
                if (oc3.j()) {
                    u53.t(this.b, this.d.H(), this.d.K(), this.e, fl2.g1(this.b, this.f));
                } else {
                    try {
                        this.b.sendBroadcast(u53.m(this.d.K(), this.e, fl2.g1(this.b, this.f)));
                    } catch (Throwable th) {
                        if (u53.a) {
                            th.printStackTrace();
                        }
                        try {
                            this.b.sendBroadcast(u53.m(this.d.K(), fd3.a(this.e, ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT, true), fl2.g1(this.b, this.f)));
                        } catch (Throwable th2) {
                            if (u53.a) {
                                th2.printStackTrace();
                            }
                            zz2.f(this.b, R.string.obfuscated_res_0x7f0f01c3).G();
                        }
                    }
                }
                if (this.c != 1) {
                    u53.u(this.b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* loaded from: classes7.dex */
        public class a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                }
            }
        }

        public c(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                lz2.a aVar = new lz2.a(this.a);
                aVar.n(new pf3());
                lz2 c = aVar.c();
                aVar.U(R.string.obfuscated_res_0x7f0f00ff);
                aVar.w(u53.p(this.a, c));
                aVar.y();
                aVar.H(R.string.obfuscated_res_0x7f0f0117, new a(this));
                aVar.J(oj2.M().a());
                aVar.a();
                c.setCancelable(false);
                c.show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lz2 a;
        public final /* synthetic */ Context b;

        public d(lz2 lz2Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lz2Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lz2Var;
            this.b = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
                ld3.g(this.b);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ el2 c;

        public e(f fVar, Context context, el2 el2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, context, el2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
            this.b = context;
            this.c = el2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(u53.s(this.b, this.c.K(), this.c.H()));
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface f {
        void a(int i);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755310018, "Lcom/repackage/u53;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755310018, "Lcom/repackage/u53;");
                return;
            }
        }
        a = rg1.a;
    }

    public static void i(Context context, el2 el2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, el2Var) == null) {
            k(context, el2Var, null);
        }
    }

    public static void j(Context context, el2 el2Var, int i, f fVar) {
        Uri C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65546, null, context, el2Var, i, fVar) == null) {
            String Q = el2Var.Q();
            if (TextUtils.isEmpty(Q) || (C = be3.C(Q)) == null) {
                return;
            }
            l(el2Var);
            fl2.a aVar = (fl2.a) ((fl2.a) ((fl2.a) ((fl2.a) ((fl2.a) ((fl2.a) ((fl2.a) ((fl2.a) ((fl2.a) ((fl2.a) ((fl2.a) new fl2.a().v0(el2Var.H())).I0(el2Var.T())).P0(el2Var.c0())).R0(el2Var.e0())).y0(el2Var.L())).A0(el2Var.n0())).L0(el2Var.p0())).a1(el2Var.k0())).u0(el2Var.G())).Q0(el2Var.d0())).K0(fl2.h1(el2Var.H(), el2Var.T(), el2Var.G()));
            if (ed3.d(C)) {
                q(context, el2Var, aVar, ed3.c(C, context), i);
                r(context, el2Var, fVar);
                return;
            }
            b42.c(Q, aVar.G(), new a(el2Var, aVar, i, fVar));
        }
    }

    public static void k(Context context, el2 el2Var, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, context, el2Var, fVar) == null) {
            j(context, el2Var, 0, fVar);
        }
    }

    public static void l(el2 el2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, el2Var) == null) {
            el2Var.R0(null);
            el2Var.I0("1230000000000000");
        }
    }

    public static Intent m(String str, Bitmap bitmap, Intent intent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, str, bitmap, intent)) == null) {
            Intent intent2 = new Intent(ShortcutManagerCompat.ACTION_INSTALL_SHORTCUT);
            intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
            intent2.putExtra("android.intent.extra.shortcut.NAME", str);
            intent2.putExtra("android.intent.extra.shortcut.ICON", bitmap);
            intent2.putExtra("duplicate", false);
            return intent2;
        }
        return (Intent) invokeLLL.objValue;
    }

    public static void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, str) == null) {
            j73 j73Var = new j73();
            j73Var.f = g03.K().getAppId();
            j73Var.b = str;
            j73Var.a = a73.n(g03.K().k());
            if (h03.b0() != null && h03.b0().W() != null) {
                j73Var.c = h03.b0().W().T();
            }
            a73.x("1591", j73Var);
        }
    }

    @NonNull
    public static String o(Context context) {
        InterceptResult invokeL;
        ActivityInfo activityInfo;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
            if (resolveActivity != null && (activityInfo = resolveActivity.activityInfo) != null && !"android".equals(activityInfo.packageName)) {
                PackageManager packageManager = context.getPackageManager();
                ActivityInfo activityInfo2 = resolveActivity.activityInfo;
                List<ProviderInfo> queryContentProviders = packageManager.queryContentProviders(activityInfo2.processName, activityInfo2.applicationInfo.uid, 65536);
                if (queryContentProviders == null) {
                    return "com.android.launcher3.settings";
                }
                for (ProviderInfo providerInfo : queryContentProviders) {
                    if (!TextUtils.isEmpty(providerInfo.authority) && !TextUtils.isEmpty(providerInfo.readPermission) && Pattern.matches(".*launcher.*permission\\.READ_SETTINGS", providerInfo.readPermission)) {
                        for (String str : providerInfo.authority.split(ParamableElem.DIVIDE_PARAM)) {
                            if (str != null && str.endsWith(".settings")) {
                                return str;
                            }
                        }
                        continue;
                    }
                }
            }
            return "com.android.launcher3.settings";
        }
        return (String) invokeL.objValue;
    }

    public static SpannableStringBuilder p(Context context, lz2 lz2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, context, lz2Var)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            String string = context.getString(R.string.obfuscated_res_0x7f0f00fe);
            String string2 = context.getString(R.string.obfuscated_res_0x7f0f0100);
            int indexOf = string.indexOf(string2);
            int length = string2.length() + indexOf;
            spannableStringBuilder.append((CharSequence) string);
            spannableStringBuilder.setSpan(new d(lz2Var, context), indexOf, length, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.obfuscated_res_0x7f0603b2)), indexOf, length, 33);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public static void q(Context context, el2 el2Var, fl2 fl2Var, Bitmap bitmap, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{context, el2Var, fl2Var, bitmap, Integer.valueOf(i)}) == null) || context == null) {
            return;
        }
        if (bitmap == null) {
            zz2.f(context, R.string.obfuscated_res_0x7f0f131d).G();
        } else if (h03.b0() == null) {
        } else {
            ExecutorUtilsExt.postOnElastic(new b(h03.b0().W(), context, i, el2Var, bitmap, fl2Var), "add quick app shortcut", 2);
        }
    }

    public static void r(Context context, el2 el2Var, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65554, null, context, el2Var, fVar) == null) || fVar == null) {
            return;
        }
        if (context == null) {
            fVar.a(-1);
        } else {
            bd3.d(new e(fVar, context, el2Var), "SwanAppShortcutHelper", 1000L, TimeUnit.MILLISECONDS);
        }
    }

    public static int s(@NonNull Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65555, null, context, str, str2)) == null) {
            try {
                Cursor query = context.getContentResolver().query(Uri.parse(String.format("content://%s/favorites?notify=true", o(context))), new String[]{"title", "intent"}, "title = ?", new String[]{str}, null);
                while (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("intent"));
                    if (string != null && string.contains(str2)) {
                        if (query != null) {
                            query.close();
                        }
                        return 1;
                    }
                }
                if (query != null) {
                    query.close();
                }
                return 0;
            } catch (Exception e2) {
                if (a) {
                    Log.d("SwanAppShortcutHelper", "fail: " + e2);
                    return -1;
                }
                return -1;
            }
        }
        return invokeLLL.intValue;
    }

    @TargetApi(26)
    public static void t(Context context, String str, String str2, Bitmap bitmap, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65556, null, context, str, str2, bitmap, intent) == null) {
            ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
            if (shortcutManager.isRequestPinShortcutSupported() && bitmap != null) {
                try {
                    shortcutManager.requestPinShortcut(new ShortcutInfo.Builder(context, str).setShortLabel(str2).setLongLabel(str2).setIcon(Icon.createWithBitmap(bitmap)).setIntent(intent).build(), null);
                    return;
                } catch (IllegalStateException e2) {
                    if (a) {
                        throw e2;
                    }
                    return;
                }
            }
            zz2.f(context, R.string.obfuscated_res_0x7f0f01c4).G();
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, context) == null) {
            if (!(context instanceof Activity)) {
                if (a) {
                    throw new IllegalArgumentException("context must be activity.");
                }
                return;
            }
            be3.a0(new c(context));
        }
    }
}
