package d.a.n0.a.f2;

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
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.f1.e.c;
import d.a.n0.a.h;
import d.a.n0.a.h0.m.r.c;
import d.a.n0.a.k;
import d.a.n0.a.p.d.p;
import d.a.n0.a.v2.a0;
import d.a.n0.a.v2.q;
import d.a.n0.a.v2.q0;
import d.a.n0.a.v2.t;
import d.a.n0.a.v2.u;
import d.a.n0.a.z1.b.b.h;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44502a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.n0.a.f2.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0705a implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.f1.e.b f44503a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a f44504b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f44505c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f44506d;

        public C0705a(d.a.n0.a.f1.e.b bVar, c.a aVar, int i2, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar, Integer.valueOf(i2), fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44503a = bVar;
            this.f44504b = aVar;
            this.f44505c = i2;
            this.f44506d = fVar;
        }

        @Override // d.a.n0.a.h0.m.r.c.b
        public void a(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) || d.a.n0.a.a2.e.i() == null) {
                return;
            }
            SwanAppActivity x = d.a.n0.a.a2.d.g().x();
            a.q(x, this.f44503a, this.f44504b, bitmap, this.f44505c);
            a.r(x, this.f44503a, this.f44506d);
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.f1.e.b f44507e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f44508f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44509g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.f1.e.b f44510h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Bitmap f44511i;
        public final /* synthetic */ d.a.n0.a.f1.e.c j;

        public b(d.a.n0.a.f1.e.b bVar, Context context, int i2, d.a.n0.a.f1.e.b bVar2, Bitmap bitmap, d.a.n0.a.f1.e.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context, Integer.valueOf(i2), bVar2, bitmap, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44507e = bVar;
            this.f44508f = context;
            this.f44509g = i2;
            this.f44510h = bVar2;
            this.f44511i = bitmap;
            this.j = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p S = d.a.n0.a.c1.a.S();
                String o1 = this.f44507e.o1();
                if (!TextUtils.isEmpty(o1) && S.b(this.f44508f, o1)) {
                    a.n(PrefetchEvent.STATE_CLICK);
                    if (S.a(this.f44508f, o1)) {
                        if (this.f44509g != 1) {
                            a.u(this.f44508f);
                            return;
                        }
                        return;
                    } else if (S.c(this.f44508f, o1)) {
                        a.n("show");
                        if (this.f44509g != 1) {
                            a.u(this.f44508f);
                            return;
                        }
                        return;
                    }
                }
                if (d.a.n0.a.v2.d.j()) {
                    a.t(this.f44508f, this.f44510h.H(), this.f44510h.K(), this.f44511i, d.a.n0.a.f1.e.c.d1(this.f44508f, this.j));
                } else {
                    try {
                        this.f44508f.sendBroadcast(a.m(this.f44510h.K(), this.f44511i, d.a.n0.a.f1.e.c.d1(this.f44508f, this.j)));
                    } catch (Throwable th) {
                        if (a.f44502a) {
                            th.printStackTrace();
                        }
                        try {
                            this.f44508f.sendBroadcast(a.m(this.f44510h.K(), u.a(this.f44511i, ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT, true), d.a.n0.a.f1.e.c.d1(this.f44508f, this.j)));
                        } catch (Throwable th2) {
                            if (a.f44502a) {
                                th2.printStackTrace();
                            }
                            d.a.n0.a.z1.b.f.e.f(this.f44508f, h.aiapps_shortcut_add_failure).F();
                        }
                    }
                }
                if (this.f44509g != 1) {
                    a.u(this.f44508f);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f44512e;

        /* renamed from: d.a.n0.a.f2.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class DialogInterface$OnClickListenerC0706a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0706a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44512e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.a aVar = new h.a(this.f44512e);
                aVar.n(new d.a.n0.a.w2.h.a());
                d.a.n0.a.z1.b.b.h c2 = aVar.c();
                aVar.U(d.a.n0.a.h.aiapps_add_shortcut_note_dialog_title);
                aVar.w(a.p(this.f44512e, c2));
                aVar.y();
                aVar.H(d.a.n0.a.h.aiapps_confirm_text, new DialogInterface$OnClickListenerC0706a(this));
                aVar.J(d.a.n0.a.c1.a.H().a());
                aVar.a();
                c2.setCancelable(false);
                c2.show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.z1.b.b.h f44513e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f44514f;

        public d(d.a.n0.a.z1.b.b.h hVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44513e = hVar;
            this.f44514f = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f44513e.dismiss();
                a0.g(this.f44514f);
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44515e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f44516f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.f1.e.b f44517g;

        public e(f fVar, Context context, d.a.n0.a.f1.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, context, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44515e = fVar;
            this.f44516f = context;
            this.f44517g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44515e.a(a.s(this.f44516f, this.f44517g.K(), this.f44517g.H()));
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface f {
        void a(int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(704687911, "Ld/a/n0/a/f2/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(704687911, "Ld/a/n0/a/f2/a;");
                return;
            }
        }
        f44502a = k.f45831a;
    }

    public static void i(Context context, d.a.n0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, bVar) == null) {
            k(context, bVar, null);
        }
    }

    public static void j(Context context, d.a.n0.a.f1.e.b bVar, int i2, f fVar) {
        Uri C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65546, null, context, bVar, i2, fVar) == null) {
            String Q = bVar.Q();
            if (TextUtils.isEmpty(Q) || (C = q0.C(Q)) == null) {
                return;
            }
            l(bVar);
            c.a aVar = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().u0(bVar.H())).H0(bVar.T())).O0(bVar.c0())).Q0(bVar.e0())).x0(bVar.L())).z0(bVar.m0())).K0(bVar.o0())).Y0(bVar.j0())).t0(bVar.G())).P0(bVar.d0())).J0(d.a.n0.a.f1.e.c.e1(bVar.H(), bVar.T(), bVar.G()));
            if (t.d(C)) {
                q(context, bVar, aVar, t.c(C, context), i2);
                r(context, bVar, fVar);
                return;
            }
            d.a.n0.a.h0.m.r.c.c(Q, aVar.G(), new C0705a(bVar, aVar, i2, fVar));
        }
    }

    public static void k(Context context, d.a.n0.a.f1.e.b bVar, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, context, bVar, fVar) == null) {
            j(context, bVar, 0, fVar);
        }
    }

    public static void l(d.a.n0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, bVar) == null) {
            bVar.Q0(null);
            bVar.H0("1230000000000000");
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
            d.a.n0.a.j2.p.e eVar = new d.a.n0.a.j2.p.e();
            eVar.f45822f = d.a.n0.a.a2.d.g().getAppId();
            eVar.f45818b = str;
            eVar.f45817a = d.a.n0.a.j2.k.m(d.a.n0.a.a2.d.g().l());
            if (d.a.n0.a.a2.e.Q() != null && d.a.n0.a.a2.e.Q().L() != null) {
                eVar.f45819c = d.a.n0.a.a2.e.Q().L().T();
            }
            d.a.n0.a.j2.k.u("1591", eVar);
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
                        for (String str : providerInfo.authority.split(";")) {
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

    public static SpannableStringBuilder p(Context context, d.a.n0.a.z1.b.b.h hVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, context, hVar)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            String string = context.getString(d.a.n0.a.h.aiapps_add_shortcut_note_dialog_content);
            String string2 = context.getString(d.a.n0.a.h.aiapps_add_shortcut_permission_setting);
            int indexOf = string.indexOf(string2);
            int length = string2.length() + indexOf;
            spannableStringBuilder.append((CharSequence) string);
            spannableStringBuilder.setSpan(new d(hVar, context), indexOf, length, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(d.a.n0.a.c.aiapps_go_permission_color)), indexOf, length, 33);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public static void q(Context context, d.a.n0.a.f1.e.b bVar, d.a.n0.a.f1.e.c cVar, Bitmap bitmap, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{context, bVar, cVar, bitmap, Integer.valueOf(i2)}) == null) || context == null) {
            return;
        }
        if (bitmap == null) {
            d.a.n0.a.z1.b.f.e.f(context, d.a.n0.a.h.swanapp_tip_net_unavailable).F();
        } else if (d.a.n0.a.a2.e.Q() == null) {
        } else {
            ExecutorUtilsExt.postOnElastic(new b(d.a.n0.a.a2.e.Q().L(), context, i2, bVar, bitmap, cVar), "add quick app shortcut", 2);
        }
    }

    public static void r(Context context, d.a.n0.a.f1.e.b bVar, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65554, null, context, bVar, fVar) == null) || fVar == null) {
            return;
        }
        if (context == null) {
            fVar.a(-1);
        } else {
            q.d(new e(fVar, context, bVar), "SwanAppShortcutHelper", 1000L, TimeUnit.MILLISECONDS);
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
                if (f44502a) {
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
                    if (f44502a) {
                        throw e2;
                    }
                    return;
                }
            }
            d.a.n0.a.z1.b.f.e.f(context, d.a.n0.a.h.aiapps_shortcut_not_supported_text).F();
        }
    }

    public static void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, context) == null) {
            if (!(context instanceof Activity)) {
                if (f44502a) {
                    throw new IllegalArgumentException("context must be activity.");
                }
                return;
            }
            q0.X(new c(context));
        }
    }
}
