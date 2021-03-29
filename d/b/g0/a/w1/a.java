package d.b.g0.a.w1;

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
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.content.pm.ShortcutManagerCompat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.b.g0.a.e0.p.r.c;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.p;
import d.b.g0.a.i2.s;
import d.b.g0.a.i2.y;
import d.b.g0.a.k;
import d.b.g0.a.p.c.h;
import d.b.g0.a.q1.b.b.g;
import d.b.g0.a.y0.e.c;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46862a = k.f45051a;

    /* renamed from: d.b.g0.a.w1.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0873a implements c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.y0.e.b f46863a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a f46864b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f46865c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f46866d;

        public C0873a(d.b.g0.a.y0.e.b bVar, c.a aVar, int i, f fVar) {
            this.f46863a = bVar;
            this.f46864b = aVar;
            this.f46865c = i;
            this.f46866d = fVar;
        }

        @Override // d.b.g0.a.e0.p.r.c.b
        public void a(Bitmap bitmap) {
            if (d.b.g0.a.r1.e.y() != null) {
                SwanAppActivity n = d.b.g0.a.r1.d.e().n();
                a.p(n, this.f46863a, this.f46864b, bitmap, this.f46865c);
                a.q(n, this.f46863a, this.f46866d);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.y0.e.b f46867e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f46868f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46869g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.y0.e.b f46870h;
        public final /* synthetic */ Bitmap i;
        public final /* synthetic */ d.b.g0.a.y0.e.c j;

        public b(d.b.g0.a.y0.e.b bVar, Context context, int i, d.b.g0.a.y0.e.b bVar2, Bitmap bitmap, d.b.g0.a.y0.e.c cVar) {
            this.f46867e = bVar;
            this.f46868f = context;
            this.f46869g = i;
            this.f46870h = bVar2;
            this.i = bitmap;
            this.j = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            h H = d.b.g0.a.w0.a.H();
            String h1 = this.f46867e.h1();
            if (!TextUtils.isEmpty(h1) && H.a(this.f46868f, h1)) {
                a.m(PrefetchEvent.STATE_CLICK);
                if (H.c(this.f46868f, h1)) {
                    if (this.f46869g != 1) {
                        a.t(this.f46868f);
                        return;
                    }
                    return;
                } else if (H.b(this.f46868f, h1)) {
                    a.m("show");
                    if (this.f46869g != 1) {
                        a.t(this.f46868f);
                        return;
                    }
                    return;
                }
            }
            if (d.b.g0.a.i2.c.j()) {
                a.s(this.f46868f, this.f46870h.G(), this.f46870h.J(), this.i, d.b.g0.a.y0.e.c.W0(this.f46868f, this.j));
            } else {
                this.f46868f.sendBroadcast(a.l(this.f46870h.J(), this.i, d.b.g0.a.y0.e.c.W0(this.f46868f, this.j)));
            }
            if (this.f46869g != 1) {
                a.t(this.f46868f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f46871e;

        /* renamed from: d.b.g0.a.w1.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class DialogInterface$OnClickListenerC0874a implements DialogInterface.OnClickListener {
            public DialogInterface$OnClickListenerC0874a(c cVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public c(Context context) {
            this.f46871e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.a aVar = new g.a(this.f46871e);
            aVar.n(new d.b.g0.a.j2.g.a());
            g c2 = aVar.c();
            aVar.U(d.b.g0.a.h.aiapps_add_shortcut_note_dialog_title);
            aVar.x(a.o(this.f46871e, c2));
            aVar.z();
            aVar.I(d.b.g0.a.h.aiapps_add_shortcut_note_dialog_button, new DialogInterface$OnClickListenerC0874a(this));
            aVar.K(d.b.g0.a.w0.a.z().a());
            aVar.a();
            c2.setCancelable(false);
            c2.show();
        }
    }

    /* loaded from: classes2.dex */
    public static class d extends ClickableSpan {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f46872e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f46873f;

        public d(g gVar, Context context) {
            this.f46872e = gVar;
            this.f46873f = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.f46872e.dismiss();
            y.g(this.f46873f);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    /* loaded from: classes2.dex */
    public static class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f46874e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f46875f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.y0.e.b f46876g;

        public e(f fVar, Context context, d.b.g0.a.y0.e.b bVar) {
            this.f46874e = fVar;
            this.f46875f = context;
            this.f46876g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f46874e.a(a.r(this.f46875f, this.f46876g.J(), this.f46876g.G()));
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a(int i);
    }

    public static void h(Context context, d.b.g0.a.y0.e.b bVar) {
        j(context, bVar, null);
    }

    public static void i(Context context, d.b.g0.a.y0.e.b bVar, int i, f fVar) {
        Uri y;
        String P = bVar.P();
        if (TextUtils.isEmpty(P) || (y = k0.y(P)) == null) {
            return;
        }
        k(bVar);
        c.a aVar = (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().q0(bVar.G())).D0(bVar.S())).H0(bVar.Z())).J0(bVar.b0())).t0(bVar.K())).v0(bVar.j0())).R0(bVar.g0())).p0(bVar.F())).I0(bVar.a0())).F0(d.b.g0.a.y0.e.c.X0(bVar.G(), bVar.S(), bVar.F()));
        if (s.d(y)) {
            p(context, bVar, aVar, s.c(y, context), i);
            q(context, bVar, fVar);
            return;
        }
        d.b.g0.a.e0.p.r.c.c(P, aVar.F(), new C0873a(bVar, aVar, i, fVar));
    }

    public static void j(Context context, d.b.g0.a.y0.e.b bVar, f fVar) {
        i(context, bVar, 0, fVar);
    }

    public static void k(d.b.g0.a.y0.e.b bVar) {
        bVar.J0(null);
        bVar.D0("1230000000000000");
    }

    public static Intent l(String str, Bitmap bitmap, Intent intent) {
        Intent intent2 = new Intent(ShortcutManagerCompat.ACTION_INSTALL_SHORTCUT);
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.NAME", str);
        intent2.putExtra("android.intent.extra.shortcut.ICON", bitmap);
        intent2.putExtra("duplicate", false);
        return intent2;
    }

    public static void m(String str) {
        d.b.g0.a.z1.k.e eVar = new d.b.g0.a.z1.k.e();
        eVar.f47255e = d.b.g0.a.r1.d.e().getAppId();
        eVar.f47252b = str;
        eVar.f47251a = d.b.g0.a.z1.h.n(d.b.g0.a.r1.d.e().h());
        if (d.b.g0.a.r1.e.O() != null && d.b.g0.a.r1.e.O().J() != null) {
            eVar.f47253c = d.b.g0.a.r1.e.O().J().S();
        }
        d.b.g0.a.z1.h.u("1591", eVar);
    }

    @NonNull
    public static String n(Context context) {
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

    public static SpannableStringBuilder o(Context context, g gVar) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String string = context.getString(d.b.g0.a.h.aiapps_add_shortcut_note_dialog_content);
        String string2 = context.getString(d.b.g0.a.h.aiapps_add_shortcut_permission_setting);
        int indexOf = string.indexOf(string2);
        int length = string2.length() + indexOf;
        spannableStringBuilder.append((CharSequence) string);
        spannableStringBuilder.setSpan(new d(gVar, context), indexOf, length, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(d.b.g0.a.c.aiapps_go_permission_color)), indexOf, length, 33);
        return spannableStringBuilder;
    }

    public static void p(Context context, d.b.g0.a.y0.e.b bVar, d.b.g0.a.y0.e.c cVar, Bitmap bitmap, int i) {
        if (context == null) {
            return;
        }
        if (bitmap == null) {
            Toast.makeText(context, d.b.g0.a.h.aiapps_common_emptyview_detail_text, 0).show();
        } else if (d.b.g0.a.r1.e.O() == null) {
        } else {
            ExecutorUtilsExt.postOnElastic(new b(d.b.g0.a.r1.e.O().J(), context, i, bVar, bitmap, cVar), "add quick app shortcut", 2);
        }
    }

    public static void q(Context context, d.b.g0.a.y0.e.b bVar, f fVar) {
        if (fVar == null) {
            return;
        }
        if (context == null) {
            fVar.a(-1);
        } else {
            p.d(new e(fVar, context, bVar), "SwanAppShortcutHelper", 1000L, TimeUnit.MILLISECONDS);
        }
    }

    public static int r(@NonNull Context context, String str, String str2) {
        try {
            Cursor query = context.getContentResolver().query(Uri.parse(String.format("content://%s/favorites?notify=true", n(context))), new String[]{"title", "intent"}, "title = ?", new String[]{str}, null);
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
            if (f46862a) {
                Log.d("SwanAppShortcutHelper", "fail: " + e2);
                return -1;
            }
            return -1;
        }
    }

    @TargetApi(26)
    public static void s(Context context, String str, String str2, Bitmap bitmap, Intent intent) {
        ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
        if (shortcutManager.isRequestPinShortcutSupported() && bitmap != null) {
            try {
                shortcutManager.requestPinShortcut(new ShortcutInfo.Builder(context, str).setShortLabel(str2).setLongLabel(str2).setIcon(Icon.createWithBitmap(bitmap)).setIntent(intent).build(), null);
                return;
            } catch (IllegalStateException e2) {
                if (f46862a) {
                    throw e2;
                }
                return;
            }
        }
        d.b.g0.a.q1.b.f.d.e(context, d.b.g0.a.h.aiapps_shortcut_not_supported_text).C();
    }

    public static void t(Context context) {
        if (!(context instanceof Activity)) {
            if (f46862a) {
                throw new IllegalArgumentException("context must be activity.");
            }
            return;
        }
        k0.T(new c(context));
    }
}
