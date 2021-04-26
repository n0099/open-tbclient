package d.a.h0.a.v1.c;

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
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.s;
import d.a.h0.a.k;
import d.a.h0.a.p.c.j;
import d.a.h0.a.q1.b.b.g;
import d.a.h0.a.v1.c.e;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f implements j {
    public static final boolean l = k.f43101a;
    public static final int[] m = {d.a.h0.a.f.agreement_first, d.a.h0.a.f.agreement_second, d.a.h0.a.f.agreement_third, d.a.h0.a.f.agreement_forth};
    public static final int[] n = {d.a.h0.a.f.agreement_layout_first, d.a.h0.a.f.agreement_layout_second, d.a.h0.a.f.agreement_layout_third, d.a.h0.a.f.agreement_layout_forth};

    /* renamed from: a  reason: collision with root package name */
    public Context f44925a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.h0.a.r1.e f44926b;

    /* renamed from: c  reason: collision with root package name */
    public DialogInterface.OnClickListener f44927c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.h0.a.v1.c.e f44928d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f44929e;

    /* renamed from: f  reason: collision with root package name */
    public g.a f44930f;

    /* renamed from: g  reason: collision with root package name */
    public View f44931g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f44932h;

    /* renamed from: i  reason: collision with root package name */
    public View f44933i;
    public TextView j;
    public TextView k;

    /* loaded from: classes3.dex */
    public class a implements ActivityResultConsumer {
        public a(f fVar) {
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i2, Intent intent) {
            d.a.h0.a.z0.f.V().d();
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ImageSpan {
        public b(f fVar, Drawable drawable) {
            super(drawable);
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, @NonNull Paint paint) {
            Drawable drawable = getDrawable();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.save();
            canvas.translate(f2, ((((fontMetricsInt.descent + i5) + i5) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2));
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    /* loaded from: classes3.dex */
    public class c extends ClickableSpan {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f44934e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f44935f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.v1.c.e f44936g;

        public c(TextView textView, View view, d.a.h0.a.v1.c.e eVar) {
            this.f44934e = textView;
            this.f44935f = view;
            this.f44936g = eVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            f.this.v(!this.f44934e.isEnabled(), this.f44935f, this.f44934e, this.f44936g);
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
        public final /* synthetic */ View f44938e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e.a f44939f;

        public d(View view, e.a aVar) {
            this.f44938e = view;
            this.f44939f = aVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            f.this.C(this.f44938e.getContext(), this.f44939f.f44921c);
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
        public final /* synthetic */ String f44941e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44942f;

        public e(String str, String str2) {
            this.f44941e = str;
            this.f44942f = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            f.this.C(d.a.h0.a.r1.d.e().v(), this.f44942f);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        @SuppressLint({"ResourceAsColor"})
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setColor(Color.parseColor(this.f44941e));
        }
    }

    /* renamed from: d.a.h0.a.v1.c.f$f  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0835f extends ClickableSpan {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f44944e;

        public C0835f(TextView textView) {
            this.f44944e = textView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            f fVar = f.this;
            fVar.B(fVar.f44928d, f.this.f44932h, f.this.f44931g, this.f44944e, f.this.f44929e, f.this.f44933i);
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
        public final /* synthetic */ Context f44946a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppRoundedImageView f44947b;

        public g(f fVar, Context context, SwanAppRoundedImageView swanAppRoundedImageView) {
            this.f44946a = context;
            this.f44947b = swanAppRoundedImageView;
        }

        @Override // d.a.h0.a.i2.s.b
        public void a(String str, Bitmap bitmap) {
            if (bitmap == null) {
                bitmap = BitmapFactory.decodeResource(this.f44946a.getResources(), d.a.h0.a.e.swan_app_user_portrait_pressed);
            }
            SwanAppRoundedImageView swanAppRoundedImageView = this.f44947b;
            if (swanAppRoundedImageView != null) {
                swanAppRoundedImageView.setImageBitmap(bitmap);
                this.f44947b.setBorderColor(this.f44946a.getResources().getColor(d.a.h0.a.c.swan_app_auth_icon_border));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends ImageSpan {
        public h(f fVar, Drawable drawable) {
            super(drawable);
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, @NonNull Paint paint) {
            Drawable drawable = getDrawable();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.save();
            canvas.translate(f2, ((((fontMetricsInt.descent + i5) + i5) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2));
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    /* loaded from: classes3.dex */
    public class i extends ClickableSpan {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f44948e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f44949f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.v1.c.e f44950g;

        public i(TextView textView, View view, d.a.h0.a.v1.c.e eVar) {
            this.f44948e = textView;
            this.f44949f = view;
            this.f44950g = eVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            f.this.y(!this.f44948e.isEnabled(), this.f44949f, this.f44948e, this.f44950g);
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
        SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) view.findViewById(d.a.h0.a.f.user_icon);
        TextView textView = (TextView) view.findViewById(d.a.h0.a.f.user_name);
        Pair<String, String> o = o(jSONObject);
        if (o != null) {
            s.e((String) o.second, new g(this, context, swanAppRoundedImageView));
            if (textView != null) {
                textView.setText((CharSequence) o.first);
            }
        }
    }

    public final void B(d.a.h0.a.v1.c.e eVar, TextView textView, View view, TextView textView2, JSONObject jSONObject, View view2) {
        if (eVar == null) {
            return;
        }
        String str = eVar.l;
        if (str != null) {
            textView2.setText(Html.fromHtml(str));
        }
        textView.setText(eVar.f44915f);
        ((LinearLayout) view.findViewById(d.a.h0.a.f.permission_detail_layout)).setVisibility(0);
        if (((!TextUtils.equals(eVar.f44911b, "snsapi_userinfo") || jSONObject == null) && !TextUtils.equals(eVar.f44911b, "mobile")) || view2 == null) {
            return;
        }
        view2.findViewById(d.a.h0.a.f.auth_divider1).setVisibility(8);
    }

    public final void C(Context context, String str) {
        if (context instanceof SwanAppActivity) {
            SwanAppActivity swanAppActivity = (SwanAppActivity) context;
            ActivityResultDispatcher resultDispatcher = swanAppActivity.getResultDispatcher();
            Intent intent = new Intent(context, SwanAppScopeDetailActivity.class);
            intent.putExtra("url", str);
            resultDispatcher.addConsumer(new a(this));
            d.a.h0.a.z0.f.V().r();
            resultDispatcher.startActivityForResult(intent);
            swanAppActivity.overridePendingTransition(d.a.h0.a.a.aiapps_slide_in_from_right, d.a.h0.a.a.aiapps_hold);
        }
    }

    @Override // d.a.h0.a.p.c.j
    public g.a a(Context context, d.a.h0.a.r1.e eVar, d.a.h0.a.v1.c.e eVar2, JSONObject jSONObject, DialogInterface.OnClickListener onClickListener) {
        if (context == null || eVar == null || eVar2 == null) {
            return null;
        }
        g.a aVar = new g.a(context);
        this.f44930f = aVar;
        this.f44925a = context;
        this.f44926b = eVar;
        this.f44928d = eVar2;
        this.f44929e = jSONObject;
        this.f44927c = onClickListener;
        aVar.f(true);
        this.f44930f.W(n());
        this.f44930f.n(new d.a.h0.a.j2.g.a());
        this.f44930f.p(d.a.h0.a.e.aiapps_action_sheet_bg);
        this.f44930f.k(false);
        this.f44930f.j();
        this.f44930f.u(false);
        return this.f44930f;
    }

    public final void k() {
        FrameLayout frameLayout = (FrameLayout) this.f44931g.findViewById(d.a.h0.a.f.auth_custom_layout);
        if (frameLayout == null) {
            return;
        }
        this.f44931g.findViewById(d.a.h0.a.f.multi_auth_custom_layout).setVisibility(8);
        this.f44931g.findViewById(d.a.h0.a.f.multi_auth_agreement_layout).setVisibility(8);
        this.f44931g.findViewById(d.a.h0.a.f.auth_custom_layout).setVisibility(0);
        this.f44933i = View.inflate(this.f44925a, d.a.h0.a.g.swan_app_auth_scope_detail, null);
        this.f44928d.f();
        v(false, this.f44933i, this.k, this.f44928d);
        frameLayout.addView(this.f44933i);
    }

    public final void l() {
        int i2;
        if (((FrameLayout) this.f44931g.findViewById(d.a.h0.a.f.multi_auth_custom_layout)) == null) {
            return;
        }
        this.f44931g.findViewById(d.a.h0.a.f.multi_auth_custom_layout).setVisibility(0);
        this.f44931g.findViewById(d.a.h0.a.f.multi_auth_agreement_layout).setVisibility(0);
        this.f44931g.findViewById(d.a.h0.a.f.auth_custom_layout).setVisibility(8);
        this.f44928d.f();
        y(true, this.f44931g.findViewById(d.a.h0.a.f.auth_scope_detail_layout), this.k, this.f44928d);
        TextView textView = (TextView) this.f44931g.findViewById(d.a.h0.a.f.multi_auth_agreement_layout);
        textView.setVisibility(0);
        e.a aVar = this.f44928d.n;
        String str = aVar.f44923e;
        JSONArray jSONArray = aVar.f44924f;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f44925a.getString(d.a.h0.a.h.swanapp_multi_auth_agreement_head));
        if (!TextUtils.isEmpty(aVar.f44922d)) {
            sb.append(aVar.f44922d);
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
        if (!TextUtils.isEmpty(aVar.f44922d)) {
            z(spannableString, sb, aVar.f44922d, aVar.f44921c, str);
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
        textView.setHighlightColor(d.a.h0.m.a.b.a.b(this.f44925a, d.a.h0.a.c.aiapps_transparent));
        textView.setLongClickable(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0065, code lost:
        if (r1.equals("snsapi_userinfo") == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m() {
        FrameLayout frameLayout = (FrameLayout) this.f44931g.findViewById(d.a.h0.a.f.auth_custom_layout);
        if (frameLayout == null) {
            return;
        }
        this.f44931g.findViewById(d.a.h0.a.f.multi_auth_custom_layout).setVisibility(8);
        this.f44931g.findViewById(d.a.h0.a.f.multi_auth_agreement_layout).setVisibility(8);
        char c2 = 0;
        this.f44931g.findViewById(d.a.h0.a.f.auth_custom_layout).setVisibility(0);
        ((TextView) this.f44931g.findViewById(d.a.h0.a.f.multi_auth_agreement_layout)).setVisibility(8);
        this.f44933i = p(this.f44925a, this.f44928d, this.f44929e);
        String str = this.f44928d.f44911b;
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
            JSONObject jSONObject = this.f44929e;
            if (jSONObject != null) {
                A(this.f44925a, this.f44933i, jSONObject);
            } else {
                x(this.f44933i, this.f44928d);
            }
        } else if (c2 != 1) {
            x(this.f44933i, this.f44928d);
        } else {
            w(this.f44933i, this.f44928d);
        }
        frameLayout.addView(this.f44933i);
    }

    public View n() {
        this.f44931g = View.inflate(this.f44925a, d.a.h0.a.g.swan_app_auth_dialog_content_common, null);
        q();
        r();
        s();
        return this.f44931g;
    }

    public Pair<String, String> o(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(TableDefine.DB_TABLE_USERINFO);
        if (optJSONObject == null) {
            return null;
        }
        return new Pair<>(optJSONObject.optString("nickname"), optJSONObject.optString("headimgurl"));
    }

    public final View p(Context context, d.a.h0.a.v1.c.e eVar, JSONObject jSONObject) {
        int i2;
        if (context == null || eVar == null || TextUtils.isEmpty(eVar.f44911b)) {
            return null;
        }
        String str = eVar.f44911b;
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
                i2 = d.a.h0.a.g.swan_app_auth_level2_custom;
            } else {
                i2 = d.a.h0.a.g.swan_app_auth_level1_mobile_custom;
            }
        } else if (jSONObject != null) {
            i2 = d.a.h0.a.g.swan_app_auth_level1_userinfo_custom;
        } else {
            i2 = d.a.h0.a.g.swan_app_auth_level2_custom;
        }
        return View.inflate(context, i2, null);
    }

    public void q() {
        List<d.a.h0.a.v1.c.e> list;
        Bitmap j;
        boolean z = (TextUtils.isEmpty(this.f44928d.p) || TextUtils.isEmpty(this.f44928d.q)) ? false : true;
        SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) this.f44931g.findViewById(d.a.h0.a.f.swan_app_icon);
        if (swanAppRoundedImageView != null) {
            if (z) {
                j = k0.k(this.f44928d.q, "SwanAppAuthDialog", false);
            } else {
                j = k0.j(this.f44926b.L(), "SwanAppAuthDialog", false);
            }
            swanAppRoundedImageView.setImageDrawable(new BitmapDrawable(this.f44925a.getResources(), j));
            swanAppRoundedImageView.setBorderColor(this.f44925a.getResources().getColor(d.a.h0.a.c.swan_app_auth_icon_border));
        }
        ((TextView) this.f44931g.findViewById(d.a.h0.a.f.swan_app_name)).setText(z ? this.f44928d.p : this.f44926b.M());
        TextView textView = (TextView) this.f44931g.findViewById(d.a.h0.a.f.permission_name);
        this.f44932h = textView;
        if (textView != null) {
            if (u(this.f44928d)) {
                View findViewById = this.f44931g.findViewById(d.a.h0.a.f.swan_app_action_text);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                this.f44932h.setText(this.f44928d.r);
            } else {
                this.f44932h.setText(this.f44928d.f44915f);
            }
        }
        if (u(this.f44928d) && (list = this.f44928d.s) != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size() && i2 <= 3; i2++) {
                d.a.h0.a.v1.c.e eVar = list.get(i2);
                if (eVar != null) {
                    this.f44931g.findViewById(n[i2]).setVisibility(0);
                    ((TextView) this.f44931g.findViewById(m[i2])).setText(eVar.f44916g);
                }
            }
        }
        this.j = (TextView) this.f44931g.findViewById(d.a.h0.a.f.auth_negative_button);
        this.k = (TextView) this.f44931g.findViewById(d.a.h0.a.f.auth_positive_button);
        this.f44930f.l(this.j, -2, this.f44927c);
        this.f44930f.l(this.k, -1, this.f44927c);
    }

    public void r() {
        if (u(this.f44928d)) {
            l();
        } else if (t(this.f44928d)) {
            k();
        } else {
            m();
        }
    }

    public void s() {
        TextView textView;
        if (TextUtils.isEmpty(this.f44928d.l) || (textView = (TextView) this.f44931g.findViewById(d.a.h0.a.f.permission_detail)) == null) {
            return;
        }
        d.a.h0.a.r1.e eVar = this.f44926b;
        if (eVar != null && eVar.L() != null && TextUtils.equals(this.f44926b.L().S(), "11010020") && TextUtils.equals(this.f44928d.f44911b, "mobile")) {
            B(this.f44928d, this.f44932h, this.f44931g, textView, this.f44929e, this.f44933i);
            textView.setTextColor(d.a.h0.m.a.b.a.b(this.f44925a, d.a.h0.a.c.aiapps_black));
            return;
        }
        if (!u(this.f44928d)) {
            d.a.h0.a.j2.b bVar = new d.a.h0.a.j2.b(this.f44925a, d.a.h0.a.e.swan_app_auth_question_mark_pressed);
            SpannableString spannableString = new SpannableString(" # ");
            spannableString.setSpan(bVar, 1, 2, 33);
            spannableString.setSpan(new C0835f(textView), 0, spannableString.length(), 33);
            this.f44932h.append(spannableString);
        }
        this.f44932h.setHighlightColor(d.a.h0.m.a.b.a.b(this.f44925a, d.a.h0.a.c.aiapps_transparent));
        this.f44932h.setMovementMethod(LinkMovementMethod.getInstance());
        this.f44932h.setLongClickable(false);
    }

    public boolean t(d.a.h0.a.v1.c.e eVar) {
        if (eVar == null) {
            return false;
        }
        return TextUtils.equals(eVar.f44911b, "ppcert") || TextUtils.equals(eVar.f44911b, "mapp_i_face_verify");
    }

    public boolean u(d.a.h0.a.v1.c.e eVar) {
        if (eVar == null) {
            return false;
        }
        return TextUtils.equals(eVar.f44911b, "scope_multi_authorize");
    }

    public final void v(boolean z, View view, TextView textView, d.a.h0.a.v1.c.e eVar) {
        e.a aVar;
        TextView textView2;
        Drawable drawable;
        if (view == null || eVar == null || (aVar = eVar.n) == null || (textView2 = (TextView) view.findViewById(d.a.h0.a.f.auth_scope_detail)) == null || TextUtils.isEmpty(aVar.f44919a)) {
            return;
        }
        if (!aVar.f44919a.startsWith("XXXX   ")) {
            aVar.f44919a = "XXXX   " + aVar.f44919a;
        }
        textView2.setText(aVar.f44919a);
        try {
            textView2.setTextColor(Color.parseColor(aVar.f44920b));
        } catch (RuntimeException e2) {
            if (l) {
                throw e2;
            }
        }
        SpannableString spannableString = new SpannableString(textView2.getText());
        textView.setEnabled(z);
        if (z) {
            drawable = view.getResources().getDrawable(d.a.h0.a.e.swanapp_scope_selected);
        } else {
            drawable = view.getResources().getDrawable(d.a.h0.a.e.swanapp_scope_unselected);
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        spannableString.setSpan(new b(this, drawable), 0, 4, 33);
        spannableString.setSpan(new c(textView, view, eVar), 0, 7, 33);
        int length = TextUtils.isEmpty(aVar.f44922d) ? 0 : aVar.f44922d.length();
        int indexOf = aVar.f44919a.indexOf(aVar.f44922d);
        int i2 = length + indexOf;
        try {
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(aVar.f44923e)), indexOf, i2, 33);
        } catch (RuntimeException e3) {
            if (l) {
                throw e3;
            }
        }
        spannableString.setSpan(new d(view, aVar), indexOf, i2, 33);
        textView2.setText(spannableString);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setHighlightColor(textView2.getResources().getColor(d.a.h0.a.c.aiapps_transparent));
    }

    public final void w(View view, d.a.h0.a.v1.c.e eVar) {
        if (view == null || eVar == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(d.a.h0.a.f.user_phone_number);
        StringBuilder sb = new StringBuilder();
        for (String str : eVar.f44918i) {
            sb.append(str);
        }
        if (textView != null) {
            textView.setText(sb.toString());
        }
    }

    public final void x(View view, d.a.h0.a.v1.c.e eVar) {
        TextView textView;
        SwanAppConfigData u;
        SwanAppConfigData.b bVar;
        Map<String, String> map;
        if (view == null || eVar == null || (textView = (TextView) view.findViewById(d.a.h0.a.f.permission_function)) == null) {
            return;
        }
        if (TextUtils.equals(eVar.f44911b, "mapp_location") && (u = d.a.h0.a.z0.f.V().u()) != null && (bVar = u.n) != null && (map = bVar.f12162a.get("scope.userLocation")) != null) {
            String str = map.get("desc");
            if (!TextUtils.isEmpty(str)) {
                eVar.m = str;
            }
        }
        textView.setText(eVar.m);
    }

    public final void y(boolean z, View view, TextView textView, d.a.h0.a.v1.c.e eVar) {
        TextView textView2;
        Drawable drawable;
        if (view == null || eVar == null || eVar.n == null || (textView2 = (TextView) view.findViewById(d.a.h0.a.f.auth_scope_detail)) == null) {
            return;
        }
        textView2.setText("XXXX   " + this.f44925a.getString(d.a.h0.a.h.swanapp_multi_auth_agreement_desc));
        textView.setEnabled(z);
        if (z) {
            drawable = view.getResources().getDrawable(d.a.h0.a.e.swanapp_scope_selected);
        } else {
            drawable = view.getResources().getDrawable(d.a.h0.a.e.swanapp_scope_unselected);
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        h hVar = new h(this, drawable);
        SpannableString spannableString = new SpannableString(textView2.getText());
        spannableString.setSpan(hVar, 0, 4, 33);
        spannableString.setSpan(new i(textView, view, eVar), 0, 7, 33);
        textView2.setText(spannableString);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setHighlightColor(textView2.getResources().getColor(d.a.h0.a.c.aiapps_transparent));
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
