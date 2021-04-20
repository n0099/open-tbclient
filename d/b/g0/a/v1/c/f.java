package d.b.g0.a.v1.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppScopeDetailActivity;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.s;
import d.b.g0.a.k;
import d.b.g0.a.p.c.j;
import d.b.g0.a.q1.b.b.g;
import d.b.g0.a.v1.c.e;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f implements j {
    public static final boolean l = k.f45443a;
    public static final int[] m = {d.b.g0.a.f.agreement_first, d.b.g0.a.f.agreement_second, d.b.g0.a.f.agreement_third, d.b.g0.a.f.agreement_forth};
    public static final int[] n = {d.b.g0.a.f.agreement_layout_first, d.b.g0.a.f.agreement_layout_second, d.b.g0.a.f.agreement_layout_third, d.b.g0.a.f.agreement_layout_forth};

    /* renamed from: a  reason: collision with root package name */
    public Context f47174a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.a.r1.e f47175b;

    /* renamed from: c  reason: collision with root package name */
    public DialogInterface.OnClickListener f47176c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.a.v1.c.e f47177d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f47178e;

    /* renamed from: f  reason: collision with root package name */
    public g.a f47179f;

    /* renamed from: g  reason: collision with root package name */
    public View f47180g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f47181h;
    public View i;
    public TextView j;
    public TextView k;

    /* loaded from: classes3.dex */
    public class a implements ActivityResultConsumer {
        public a(f fVar) {
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent) {
            d.b.g0.a.z0.f.V().f();
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ImageSpan {
        public b(f fVar, Drawable drawable) {
            super(drawable);
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, @NonNull Paint paint) {
            Drawable drawable = getDrawable();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.save();
            canvas.translate(f2, ((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2));
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    /* loaded from: classes3.dex */
    public class c extends ClickableSpan {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f47182e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f47183f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.v1.c.e f47184g;

        public c(TextView textView, View view, d.b.g0.a.v1.c.e eVar) {
            this.f47182e = textView;
            this.f47183f = view;
            this.f47184g = eVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            f.this.v(!this.f47182e.isEnabled(), this.f47183f, this.f47182e, this.f47184g);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends ClickableSpan {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f47186e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e.a f47187f;

        public d(View view, e.a aVar) {
            this.f47186e = view;
            this.f47187f = aVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            f.this.C(this.f47186e.getContext(), this.f47187f.f47170c);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    /* loaded from: classes3.dex */
    public class e extends ClickableSpan {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47189e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47190f;

        public e(String str, String str2) {
            this.f47189e = str;
            this.f47190f = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            f.this.C(d.b.g0.a.r1.d.e().n(), this.f47190f);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        @SuppressLint({"ResourceAsColor"})
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setColor(Color.parseColor(this.f47189e));
        }
    }

    /* renamed from: d.b.g0.a.v1.c.f$f  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0876f extends ClickableSpan {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f47192e;

        public C0876f(TextView textView) {
            this.f47192e = textView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            f fVar = f.this;
            fVar.B(fVar.f47177d, f.this.f47181h, f.this.f47180g, this.f47192e, f.this.f47178e, f.this.i);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements s.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f47194a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppRoundedImageView f47195b;

        public g(f fVar, Context context, SwanAppRoundedImageView swanAppRoundedImageView) {
            this.f47194a = context;
            this.f47195b = swanAppRoundedImageView;
        }

        @Override // d.b.g0.a.i2.s.b
        public void a(String str, Bitmap bitmap) {
            if (bitmap == null) {
                bitmap = BitmapFactory.decodeResource(this.f47194a.getResources(), d.b.g0.a.e.swan_app_user_portrait_pressed);
            }
            SwanAppRoundedImageView swanAppRoundedImageView = this.f47195b;
            if (swanAppRoundedImageView != null) {
                swanAppRoundedImageView.setImageBitmap(bitmap);
                this.f47195b.setBorderColor(this.f47194a.getResources().getColor(d.b.g0.a.c.swan_app_auth_icon_border));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends ImageSpan {
        public h(f fVar, Drawable drawable) {
            super(drawable);
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, @NonNull Paint paint) {
            Drawable drawable = getDrawable();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.save();
            canvas.translate(f2, ((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2));
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    /* loaded from: classes3.dex */
    public class i extends ClickableSpan {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f47196e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f47197f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.v1.c.e f47198g;

        public i(TextView textView, View view, d.b.g0.a.v1.c.e eVar) {
            this.f47196e = textView;
            this.f47197f = view;
            this.f47198g = eVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            f.this.y(!this.f47196e.isEnabled(), this.f47197f, this.f47196e, this.f47198g);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    public final void A(Context context, View view, JSONObject jSONObject) {
        if (context == null || view == null || jSONObject == null) {
            return;
        }
        SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) view.findViewById(d.b.g0.a.f.user_icon);
        TextView textView = (TextView) view.findViewById(d.b.g0.a.f.user_name);
        Pair<String, String> o = o(jSONObject);
        if (o != null) {
            s.e((String) o.second, new g(this, context, swanAppRoundedImageView));
            if (textView != null) {
                textView.setText((CharSequence) o.first);
            }
        }
    }

    public final void B(d.b.g0.a.v1.c.e eVar, TextView textView, View view, TextView textView2, JSONObject jSONObject, View view2) {
        if (eVar == null) {
            return;
        }
        String str = eVar.l;
        if (str != null) {
            textView2.setText(Html.fromHtml(str));
        }
        textView.setText(eVar.f47165f);
        ((LinearLayout) view.findViewById(d.b.g0.a.f.permission_detail_layout)).setVisibility(0);
        if (((!TextUtils.equals(eVar.f47161b, "snsapi_userinfo") || jSONObject == null) && !TextUtils.equals(eVar.f47161b, "mobile")) || view2 == null) {
            return;
        }
        view2.findViewById(d.b.g0.a.f.auth_divider1).setVisibility(8);
    }

    public final void C(Context context, String str) {
        if (context instanceof SwanAppActivity) {
            SwanAppActivity swanAppActivity = (SwanAppActivity) context;
            ActivityResultDispatcher resultDispatcher = swanAppActivity.getResultDispatcher();
            Intent intent = new Intent(context, SwanAppScopeDetailActivity.class);
            intent.putExtra("url", str);
            resultDispatcher.addConsumer(new a(this));
            d.b.g0.a.z0.f.V().D();
            resultDispatcher.startActivityForResult(intent);
            swanAppActivity.overridePendingTransition(d.b.g0.a.a.aiapps_slide_in_from_right, d.b.g0.a.a.aiapps_hold);
        }
    }

    @Override // d.b.g0.a.p.c.j
    public g.a a(Context context, d.b.g0.a.r1.e eVar, d.b.g0.a.v1.c.e eVar2, JSONObject jSONObject, DialogInterface.OnClickListener onClickListener) {
        if (context == null || eVar == null || eVar2 == null) {
            return null;
        }
        g.a aVar = new g.a(context);
        this.f47179f = aVar;
        this.f47174a = context;
        this.f47175b = eVar;
        this.f47177d = eVar2;
        this.f47178e = jSONObject;
        this.f47176c = onClickListener;
        aVar.f(true);
        this.f47179f.W(n());
        this.f47179f.n(new d.b.g0.a.j2.g.a());
        this.f47179f.p(d.b.g0.a.e.aiapps_action_sheet_bg);
        this.f47179f.k(false);
        this.f47179f.j();
        this.f47179f.u(false);
        return this.f47179f;
    }

    public final void k() {
        FrameLayout frameLayout = (FrameLayout) this.f47180g.findViewById(d.b.g0.a.f.auth_custom_layout);
        if (frameLayout == null) {
            return;
        }
        this.f47180g.findViewById(d.b.g0.a.f.multi_auth_custom_layout).setVisibility(8);
        this.f47180g.findViewById(d.b.g0.a.f.multi_auth_agreement_layout).setVisibility(8);
        this.f47180g.findViewById(d.b.g0.a.f.auth_custom_layout).setVisibility(0);
        this.i = View.inflate(this.f47174a, d.b.g0.a.g.swan_app_auth_scope_detail, null);
        this.f47177d.f();
        v(false, this.i, this.k, this.f47177d);
        frameLayout.addView(this.i);
    }

    public final void l() {
        int i2;
        if (((FrameLayout) this.f47180g.findViewById(d.b.g0.a.f.multi_auth_custom_layout)) == null) {
            return;
        }
        this.f47180g.findViewById(d.b.g0.a.f.multi_auth_custom_layout).setVisibility(0);
        this.f47180g.findViewById(d.b.g0.a.f.multi_auth_agreement_layout).setVisibility(0);
        this.f47180g.findViewById(d.b.g0.a.f.auth_custom_layout).setVisibility(8);
        this.f47177d.f();
        y(true, this.f47180g.findViewById(d.b.g0.a.f.auth_scope_detail_layout), this.k, this.f47177d);
        TextView textView = (TextView) this.f47180g.findViewById(d.b.g0.a.f.multi_auth_agreement_layout);
        textView.setVisibility(0);
        e.a aVar = this.f47177d.n;
        String str = aVar.f47172e;
        JSONArray jSONArray = aVar.f47173f;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f47174a.getString(d.b.g0.a.h.swanapp_multi_auth_agreement_head));
        if (!TextUtils.isEmpty(aVar.f47171d)) {
            sb.append(aVar.f47171d);
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                String optString = optJSONObject.optString("keyword");
                String optString2 = optJSONObject.optString("detail_url");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && optString.length() <= 17) {
                    sb.append(optString);
                }
            }
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        if (!TextUtils.isEmpty(aVar.f47171d)) {
            z(spannableString, sb, aVar.f47171d, aVar.f47170c, str);
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            int i4 = 0;
            while (i4 < jSONArray.length()) {
                JSONObject optJSONObject2 = jSONArray.optJSONObject(i4);
                String optString3 = optJSONObject2.optString("keyword");
                String optString4 = optJSONObject2.optString("detail_url");
                if (TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString4) || optString3.length() > 17) {
                    i2 = i4;
                } else {
                    i2 = i4;
                    z(spannableString, sb, optString3, optString4, str);
                }
                i4 = i2 + 1;
            }
        }
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(d.b.g0.m.a.b.a.b(this.f47174a, d.b.g0.a.c.aiapps_transparent));
        textView.setLongClickable(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0065, code lost:
        if (r1.equals("snsapi_userinfo") == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m() {
        FrameLayout frameLayout = (FrameLayout) this.f47180g.findViewById(d.b.g0.a.f.auth_custom_layout);
        if (frameLayout == null) {
            return;
        }
        this.f47180g.findViewById(d.b.g0.a.f.multi_auth_custom_layout).setVisibility(8);
        this.f47180g.findViewById(d.b.g0.a.f.multi_auth_agreement_layout).setVisibility(8);
        char c2 = 0;
        this.f47180g.findViewById(d.b.g0.a.f.auth_custom_layout).setVisibility(0);
        ((TextView) this.f47180g.findViewById(d.b.g0.a.f.multi_auth_agreement_layout)).setVisibility(8);
        this.i = p(this.f47174a, this.f47177d, this.f47178e);
        String str = this.f47177d.f47161b;
        int hashCode = str.hashCode();
        if (hashCode != -1068855134) {
            if (hashCode == -977063690) {
            }
            c2 = 65535;
        } else {
            if (str.equals("mobile")) {
                c2 = 1;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            JSONObject jSONObject = this.f47178e;
            if (jSONObject != null) {
                A(this.f47174a, this.i, jSONObject);
            } else {
                x(this.i, this.f47177d);
            }
        } else if (c2 != 1) {
            x(this.i, this.f47177d);
        } else {
            w(this.i, this.f47177d);
        }
        frameLayout.addView(this.i);
    }

    public View n() {
        this.f47180g = View.inflate(this.f47174a, d.b.g0.a.g.swan_app_auth_dialog_content_common, null);
        q();
        r();
        s();
        return this.f47180g;
    }

    public Pair<String, String> o(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(TableDefine.DB_TABLE_USERINFO);
        if (optJSONObject == null) {
            return null;
        }
        return new Pair<>(optJSONObject.optString("nickname"), optJSONObject.optString("headimgurl"));
    }

    public final View p(Context context, d.b.g0.a.v1.c.e eVar, JSONObject jSONObject) {
        int i2;
        if (context == null || eVar == null || TextUtils.isEmpty(eVar.f47161b)) {
            return null;
        }
        String str = eVar.f47161b;
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1068855134) {
            if (hashCode == -977063690 && str.equals("snsapi_userinfo")) {
                c2 = 0;
            }
        } else if (str.equals("mobile")) {
            c2 = 1;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                i2 = d.b.g0.a.g.swan_app_auth_level2_custom;
            } else {
                i2 = d.b.g0.a.g.swan_app_auth_level1_mobile_custom;
            }
        } else if (jSONObject != null) {
            i2 = d.b.g0.a.g.swan_app_auth_level1_userinfo_custom;
        } else {
            i2 = d.b.g0.a.g.swan_app_auth_level2_custom;
        }
        return View.inflate(context, i2, null);
    }

    public void q() {
        List<d.b.g0.a.v1.c.e> list;
        Bitmap j;
        boolean z = (TextUtils.isEmpty(this.f47177d.p) || TextUtils.isEmpty(this.f47177d.q)) ? false : true;
        SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) this.f47180g.findViewById(d.b.g0.a.f.swan_app_icon);
        if (swanAppRoundedImageView != null) {
            if (z) {
                j = k0.k(this.f47177d.q, "SwanAppAuthDialog", false);
            } else {
                j = k0.j(this.f47175b.L(), "SwanAppAuthDialog", false);
            }
            swanAppRoundedImageView.setImageDrawable(new BitmapDrawable(this.f47174a.getResources(), j));
            swanAppRoundedImageView.setBorderColor(this.f47174a.getResources().getColor(d.b.g0.a.c.swan_app_auth_icon_border));
        }
        ((TextView) this.f47180g.findViewById(d.b.g0.a.f.swan_app_name)).setText(z ? this.f47177d.p : this.f47175b.M());
        TextView textView = (TextView) this.f47180g.findViewById(d.b.g0.a.f.permission_name);
        this.f47181h = textView;
        if (textView != null) {
            if (u(this.f47177d)) {
                View findViewById = this.f47180g.findViewById(d.b.g0.a.f.swan_app_action_text);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                this.f47181h.setText(this.f47177d.r);
            } else {
                this.f47181h.setText(this.f47177d.f47165f);
            }
        }
        if (u(this.f47177d) && (list = this.f47177d.s) != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size() && i2 <= 3; i2++) {
                d.b.g0.a.v1.c.e eVar = list.get(i2);
                if (eVar != null) {
                    this.f47180g.findViewById(n[i2]).setVisibility(0);
                    ((TextView) this.f47180g.findViewById(m[i2])).setText(eVar.f47166g);
                }
            }
        }
        this.j = (TextView) this.f47180g.findViewById(d.b.g0.a.f.auth_negative_button);
        this.k = (TextView) this.f47180g.findViewById(d.b.g0.a.f.auth_positive_button);
        this.f47179f.l(this.j, -2, this.f47176c);
        this.f47179f.l(this.k, -1, this.f47176c);
    }

    public void r() {
        if (u(this.f47177d)) {
            l();
        } else if (t(this.f47177d)) {
            k();
        } else {
            m();
        }
    }

    public void s() {
        TextView textView;
        if (TextUtils.isEmpty(this.f47177d.l) || (textView = (TextView) this.f47180g.findViewById(d.b.g0.a.f.permission_detail)) == null) {
            return;
        }
        d.b.g0.a.r1.e eVar = this.f47175b;
        if (eVar != null && eVar.L() != null && TextUtils.equals(this.f47175b.L().S(), "11010020") && TextUtils.equals(this.f47177d.f47161b, "mobile")) {
            B(this.f47177d, this.f47181h, this.f47180g, textView, this.f47178e, this.i);
            textView.setTextColor(d.b.g0.m.a.b.a.b(this.f47174a, d.b.g0.a.c.aiapps_black));
            return;
        }
        if (!u(this.f47177d)) {
            d.b.g0.a.j2.b bVar = new d.b.g0.a.j2.b(this.f47174a, d.b.g0.a.e.swan_app_auth_question_mark_pressed);
            SpannableString spannableString = new SpannableString(" # ");
            spannableString.setSpan(bVar, 1, 2, 33);
            spannableString.setSpan(new C0876f(textView), 0, spannableString.length(), 33);
            this.f47181h.append(spannableString);
        }
        this.f47181h.setHighlightColor(d.b.g0.m.a.b.a.b(this.f47174a, d.b.g0.a.c.aiapps_transparent));
        this.f47181h.setMovementMethod(LinkMovementMethod.getInstance());
        this.f47181h.setLongClickable(false);
    }

    public boolean t(d.b.g0.a.v1.c.e eVar) {
        if (eVar == null) {
            return false;
        }
        return TextUtils.equals(eVar.f47161b, "ppcert") || TextUtils.equals(eVar.f47161b, "mapp_i_face_verify");
    }

    public boolean u(d.b.g0.a.v1.c.e eVar) {
        if (eVar == null) {
            return false;
        }
        return TextUtils.equals(eVar.f47161b, "scope_multi_authorize");
    }

    public final void v(boolean z, View view, TextView textView, d.b.g0.a.v1.c.e eVar) {
        e.a aVar;
        TextView textView2;
        Drawable drawable;
        if (view == null || eVar == null || (aVar = eVar.n) == null || (textView2 = (TextView) view.findViewById(d.b.g0.a.f.auth_scope_detail)) == null || TextUtils.isEmpty(aVar.f47168a)) {
            return;
        }
        if (!aVar.f47168a.startsWith("XXXX   ")) {
            aVar.f47168a = "XXXX   " + aVar.f47168a;
        }
        textView2.setText(aVar.f47168a);
        try {
            textView2.setTextColor(Color.parseColor(aVar.f47169b));
        } catch (RuntimeException e2) {
            if (l) {
                throw e2;
            }
        }
        SpannableString spannableString = new SpannableString(textView2.getText());
        textView.setEnabled(z);
        if (z) {
            drawable = view.getResources().getDrawable(d.b.g0.a.e.swanapp_scope_selected);
        } else {
            drawable = view.getResources().getDrawable(d.b.g0.a.e.swanapp_scope_unselected);
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        spannableString.setSpan(new b(this, drawable), 0, 4, 33);
        spannableString.setSpan(new c(textView, view, eVar), 0, 7, 33);
        int length = TextUtils.isEmpty(aVar.f47171d) ? 0 : aVar.f47171d.length();
        int indexOf = aVar.f47168a.indexOf(aVar.f47171d);
        int i2 = length + indexOf;
        try {
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(aVar.f47172e)), indexOf, i2, 33);
        } catch (RuntimeException e3) {
            if (l) {
                throw e3;
            }
        }
        spannableString.setSpan(new d(view, aVar), indexOf, i2, 33);
        textView2.setText(spannableString);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setHighlightColor(textView2.getResources().getColor(d.b.g0.a.c.aiapps_transparent));
    }

    public final void w(View view, d.b.g0.a.v1.c.e eVar) {
        if (view == null || eVar == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(d.b.g0.a.f.user_phone_number);
        StringBuilder sb = new StringBuilder();
        for (String str : eVar.i) {
            sb.append(str);
        }
        if (textView != null) {
            textView.setText(sb.toString());
        }
    }

    public final void x(View view, d.b.g0.a.v1.c.e eVar) {
        TextView textView;
        SwanAppConfigData I;
        SwanAppConfigData.b bVar;
        Map<String, String> map;
        if (view == null || eVar == null || (textView = (TextView) view.findViewById(d.b.g0.a.f.permission_function)) == null) {
            return;
        }
        if (TextUtils.equals(eVar.f47161b, "mapp_location") && (I = d.b.g0.a.z0.f.V().I()) != null && (bVar = I.n) != null && (map = bVar.f12283a.get("scope.userLocation")) != null) {
            String str = map.get("desc");
            if (!TextUtils.isEmpty(str)) {
                eVar.m = str;
            }
        }
        textView.setText(eVar.m);
    }

    public final void y(boolean z, View view, TextView textView, d.b.g0.a.v1.c.e eVar) {
        TextView textView2;
        Drawable drawable;
        if (view == null || eVar == null || eVar.n == null || (textView2 = (TextView) view.findViewById(d.b.g0.a.f.auth_scope_detail)) == null) {
            return;
        }
        textView2.setText("XXXX   " + this.f47174a.getString(d.b.g0.a.h.swanapp_multi_auth_agreement_desc));
        textView.setEnabled(z);
        if (z) {
            drawable = view.getResources().getDrawable(d.b.g0.a.e.swanapp_scope_selected);
        } else {
            drawable = view.getResources().getDrawable(d.b.g0.a.e.swanapp_scope_unselected);
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        h hVar = new h(this, drawable);
        SpannableString spannableString = new SpannableString(textView2.getText());
        spannableString.setSpan(hVar, 0, 4, 33);
        spannableString.setSpan(new i(textView, view, eVar), 0, 7, 33);
        textView2.setText(spannableString);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setHighlightColor(textView2.getResources().getColor(d.b.g0.a.c.aiapps_transparent));
    }

    public final void z(SpannableString spannableString, StringBuilder sb, String str, String str2, String str3) {
        int length = TextUtils.isEmpty(str) ? 0 : str.length();
        int indexOf = sb.indexOf(str);
        int i2 = length + indexOf;
        try {
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(str3)), indexOf, i2, 33);
            spannableString.setSpan(new e(str3, str2), indexOf, i2, 33);
        } catch (RuntimeException e2) {
            if (l) {
                e2.printStackTrace();
            }
        }
    }
}
