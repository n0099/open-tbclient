package d.a.l0.a.f2;

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
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.l0.a.f1.e.c;
import d.a.l0.a.h;
import d.a.l0.a.h0.m.r.c;
import d.a.l0.a.k;
import d.a.l0.a.p.d.p;
import d.a.l0.a.v2.a0;
import d.a.l0.a.v2.q;
import d.a.l0.a.v2.q0;
import d.a.l0.a.v2.t;
import d.a.l0.a.v2.u;
import d.a.l0.a.z1.b.b.h;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41870a = k.f43199a;

    /* renamed from: d.a.l0.a.f2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0637a implements c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.f1.e.b f41871a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a f41872b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f41873c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f41874d;

        public C0637a(d.a.l0.a.f1.e.b bVar, c.a aVar, int i2, f fVar) {
            this.f41871a = bVar;
            this.f41872b = aVar;
            this.f41873c = i2;
            this.f41874d = fVar;
        }

        @Override // d.a.l0.a.h0.m.r.c.b
        public void a(Bitmap bitmap) {
            if (d.a.l0.a.a2.e.i() != null) {
                SwanAppActivity x = d.a.l0.a.a2.d.g().x();
                a.q(x, this.f41871a, this.f41872b, bitmap, this.f41873c);
                a.r(x, this.f41871a, this.f41874d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.f1.e.b f41875e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f41876f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f41877g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.f1.e.b f41878h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Bitmap f41879i;
        public final /* synthetic */ d.a.l0.a.f1.e.c j;

        public b(d.a.l0.a.f1.e.b bVar, Context context, int i2, d.a.l0.a.f1.e.b bVar2, Bitmap bitmap, d.a.l0.a.f1.e.c cVar) {
            this.f41875e = bVar;
            this.f41876f = context;
            this.f41877g = i2;
            this.f41878h = bVar2;
            this.f41879i = bitmap;
            this.j = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            p S = d.a.l0.a.c1.a.S();
            String o1 = this.f41875e.o1();
            if (!TextUtils.isEmpty(o1) && S.b(this.f41876f, o1)) {
                a.n(PrefetchEvent.STATE_CLICK);
                if (S.a(this.f41876f, o1)) {
                    if (this.f41877g != 1) {
                        a.u(this.f41876f);
                        return;
                    }
                    return;
                } else if (S.c(this.f41876f, o1)) {
                    a.n("show");
                    if (this.f41877g != 1) {
                        a.u(this.f41876f);
                        return;
                    }
                    return;
                }
            }
            if (d.a.l0.a.v2.d.j()) {
                a.t(this.f41876f, this.f41878h.H(), this.f41878h.K(), this.f41879i, d.a.l0.a.f1.e.c.d1(this.f41876f, this.j));
            } else {
                try {
                    this.f41876f.sendBroadcast(a.m(this.f41878h.K(), this.f41879i, d.a.l0.a.f1.e.c.d1(this.f41876f, this.j)));
                } catch (Throwable th) {
                    if (a.f41870a) {
                        th.printStackTrace();
                    }
                    try {
                        this.f41876f.sendBroadcast(a.m(this.f41878h.K(), u.a(this.f41879i, ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT, true), d.a.l0.a.f1.e.c.d1(this.f41876f, this.j)));
                    } catch (Throwable th2) {
                        if (a.f41870a) {
                            th2.printStackTrace();
                        }
                        d.a.l0.a.z1.b.f.e.f(this.f41876f, h.aiapps_shortcut_add_failure).F();
                    }
                }
            }
            if (this.f41877g != 1) {
                a.u(this.f41876f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f41880e;

        /* renamed from: d.a.l0.a.f2.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class DialogInterface$OnClickListenerC0638a implements DialogInterface.OnClickListener {
            public DialogInterface$OnClickListenerC0638a(c cVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
            }
        }

        public c(Context context) {
            this.f41880e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.a aVar = new h.a(this.f41880e);
            aVar.n(new d.a.l0.a.w2.h.a());
            d.a.l0.a.z1.b.b.h c2 = aVar.c();
            aVar.U(d.a.l0.a.h.aiapps_add_shortcut_note_dialog_title);
            aVar.w(a.p(this.f41880e, c2));
            aVar.y();
            aVar.H(d.a.l0.a.h.aiapps_confirm_text, new DialogInterface$OnClickListenerC0638a(this));
            aVar.J(d.a.l0.a.c1.a.H().a());
            aVar.a();
            c2.setCancelable(false);
            c2.show();
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends ClickableSpan {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.z1.b.b.h f41881e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f41882f;

        public d(d.a.l0.a.z1.b.b.h hVar, Context context) {
            this.f41881e = hVar;
            this.f41882f = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.f41881e.dismiss();
            a0.g(this.f41882f);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f41883e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f41884f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.f1.e.b f41885g;

        public e(f fVar, Context context, d.a.l0.a.f1.e.b bVar) {
            this.f41883e = fVar;
            this.f41884f = context;
            this.f41885g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f41883e.a(a.s(this.f41884f, this.f41885g.K(), this.f41885g.H()));
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(int i2);
    }

    public static void i(Context context, d.a.l0.a.f1.e.b bVar) {
        k(context, bVar, null);
    }

    public static void j(Context context, d.a.l0.a.f1.e.b bVar, int i2, f fVar) {
        Uri C;
        String Q = bVar.Q();
        if (TextUtils.isEmpty(Q) || (C = q0.C(Q)) == null) {
            return;
        }
        l(bVar);
        c.a aVar = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().u0(bVar.H())).H0(bVar.T())).O0(bVar.c0())).Q0(bVar.e0())).x0(bVar.L())).z0(bVar.m0())).K0(bVar.o0())).Y0(bVar.j0())).t0(bVar.G())).P0(bVar.d0())).J0(d.a.l0.a.f1.e.c.e1(bVar.H(), bVar.T(), bVar.G()));
        if (t.d(C)) {
            q(context, bVar, aVar, t.c(C, context), i2);
            r(context, bVar, fVar);
            return;
        }
        d.a.l0.a.h0.m.r.c.c(Q, aVar.G(), new C0637a(bVar, aVar, i2, fVar));
    }

    public static void k(Context context, d.a.l0.a.f1.e.b bVar, f fVar) {
        j(context, bVar, 0, fVar);
    }

    public static void l(d.a.l0.a.f1.e.b bVar) {
        bVar.Q0(null);
        bVar.H0("1230000000000000");
    }

    public static Intent m(String str, Bitmap bitmap, Intent intent) {
        Intent intent2 = new Intent(ShortcutManagerCompat.ACTION_INSTALL_SHORTCUT);
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.NAME", str);
        intent2.putExtra("android.intent.extra.shortcut.ICON", bitmap);
        intent2.putExtra("duplicate", false);
        return intent2;
    }

    public static void n(String str) {
        d.a.l0.a.j2.p.e eVar = new d.a.l0.a.j2.p.e();
        eVar.f43190f = d.a.l0.a.a2.d.g().getAppId();
        eVar.f43186b = str;
        eVar.f43185a = d.a.l0.a.j2.k.m(d.a.l0.a.a2.d.g().l());
        if (d.a.l0.a.a2.e.Q() != null && d.a.l0.a.a2.e.Q().L() != null) {
            eVar.f43187c = d.a.l0.a.a2.e.Q().L().T();
        }
        d.a.l0.a.j2.k.u("1591", eVar);
    }

    @NonNull
    public static String o(Context context) {
        ActivityInfo activityInfo;
        String[] split;
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

    public static SpannableStringBuilder p(Context context, d.a.l0.a.z1.b.b.h hVar) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String string = context.getString(d.a.l0.a.h.aiapps_add_shortcut_note_dialog_content);
        String string2 = context.getString(d.a.l0.a.h.aiapps_add_shortcut_permission_setting);
        int indexOf = string.indexOf(string2);
        int length = string2.length() + indexOf;
        spannableStringBuilder.append((CharSequence) string);
        spannableStringBuilder.setSpan(new d(hVar, context), indexOf, length, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(d.a.l0.a.c.aiapps_go_permission_color)), indexOf, length, 33);
        return spannableStringBuilder;
    }

    public static void q(Context context, d.a.l0.a.f1.e.b bVar, d.a.l0.a.f1.e.c cVar, Bitmap bitmap, int i2) {
        if (context == null) {
            return;
        }
        if (bitmap == null) {
            d.a.l0.a.z1.b.f.e.f(context, d.a.l0.a.h.swanapp_tip_net_unavailable).F();
        } else if (d.a.l0.a.a2.e.Q() == null) {
        } else {
            ExecutorUtilsExt.postOnElastic(new b(d.a.l0.a.a2.e.Q().L(), context, i2, bVar, bitmap, cVar), "add quick app shortcut", 2);
        }
    }

    public static void r(Context context, d.a.l0.a.f1.e.b bVar, f fVar) {
        if (fVar == null) {
            return;
        }
        if (context == null) {
            fVar.a(-1);
        } else {
            q.d(new e(fVar, context, bVar), "SwanAppShortcutHelper", 1000L, TimeUnit.MILLISECONDS);
        }
    }

    public static int s(@NonNull Context context, String str, String str2) {
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
            if (f41870a) {
                Log.d("SwanAppShortcutHelper", "fail: " + e2);
                return -1;
            }
            return -1;
        }
    }

    @TargetApi(26)
    public static void t(Context context, String str, String str2, Bitmap bitmap, Intent intent) {
        ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
        if (shortcutManager.isRequestPinShortcutSupported() && bitmap != null) {
            try {
                shortcutManager.requestPinShortcut(new ShortcutInfo.Builder(context, str).setShortLabel(str2).setLongLabel(str2).setIcon(Icon.createWithBitmap(bitmap)).setIntent(intent).build(), null);
                return;
            } catch (IllegalStateException e2) {
                if (f41870a) {
                    throw e2;
                }
                return;
            }
        }
        d.a.l0.a.z1.b.f.e.f(context, d.a.l0.a.h.aiapps_shortcut_not_supported_text).F();
    }

    public static void u(Context context) {
        if (!(context instanceof Activity)) {
            if (f41870a) {
                throw new IllegalArgumentException("context must be activity.");
            }
            return;
        }
        q0.X(new c(context));
    }
}
