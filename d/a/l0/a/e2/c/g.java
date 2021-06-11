package d.a.l0.a.e2.c;

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
import d.a.l0.a.e2.c.f;
import d.a.l0.a.k;
import d.a.l0.a.p.d.r;
import d.a.l0.a.v2.q0;
import d.a.l0.a.v2.t;
import d.a.l0.a.z1.b.b.h;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g implements r {
    public static final boolean l = k.f46875a;
    public static final int[] m = {d.a.l0.a.f.agreement_first, d.a.l0.a.f.agreement_second, d.a.l0.a.f.agreement_third, d.a.l0.a.f.agreement_forth};
    public static final int[] n = {d.a.l0.a.f.agreement_layout_first, d.a.l0.a.f.agreement_layout_second, d.a.l0.a.f.agreement_layout_third, d.a.l0.a.f.agreement_layout_forth};

    /* renamed from: a  reason: collision with root package name */
    public Context f45385a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.a.a2.e f45386b;

    /* renamed from: c  reason: collision with root package name */
    public DialogInterface.OnClickListener f45387c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.e2.c.f f45388d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f45389e;

    /* renamed from: f  reason: collision with root package name */
    public h.a f45390f;

    /* renamed from: g  reason: collision with root package name */
    public View f45391g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f45392h;

    /* renamed from: i  reason: collision with root package name */
    public View f45393i;
    public TextView j;
    public TextView k;

    /* loaded from: classes3.dex */
    public class a implements ActivityResultConsumer {
        public a(g gVar) {
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i2, Intent intent) {
            d.a.l0.a.g1.f.V().b();
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ImageSpan {
        public b(g gVar, Drawable drawable) {
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
        public final /* synthetic */ TextView f45394e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f45395f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.e2.c.f f45396g;

        public c(TextView textView, View view, d.a.l0.a.e2.c.f fVar) {
            this.f45394e = textView;
            this.f45395f = view;
            this.f45396g = fVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            g.this.v(!this.f45394e.isEnabled(), this.f45395f, this.f45394e, this.f45396g);
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
        public final /* synthetic */ View f45398e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f.a f45399f;

        public d(View view, f.a aVar) {
            this.f45398e = view;
            this.f45399f = aVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            g.this.C(this.f45398e.getContext(), this.f45399f.f45381c);
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
        public final /* synthetic */ String f45401e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45402f;

        public e(String str, String str2) {
            this.f45401e = str;
            this.f45402f = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            g.this.C(d.a.l0.a.a2.d.g().x(), this.f45402f);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        @SuppressLint({"ResourceAsColor"})
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setColor(Color.parseColor(this.f45401e));
        }
    }

    /* loaded from: classes3.dex */
    public class f extends ClickableSpan {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f45404e;

        public f(TextView textView) {
            this.f45404e = textView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            g gVar = g.this;
            gVar.B(gVar.f45388d, g.this.f45392h, g.this.f45391g, this.f45404e, g.this.f45389e, g.this.f45393i);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    /* renamed from: d.a.l0.a.e2.c.g$g  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0676g implements t.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f45406a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppRoundedImageView f45407b;

        public C0676g(g gVar, Context context, SwanAppRoundedImageView swanAppRoundedImageView) {
            this.f45406a = context;
            this.f45407b = swanAppRoundedImageView;
        }

        @Override // d.a.l0.a.v2.t.b
        public void a(String str, Bitmap bitmap) {
            if (bitmap == null) {
                bitmap = BitmapFactory.decodeResource(this.f45406a.getResources(), d.a.l0.a.e.swan_app_user_portrait_pressed);
            }
            SwanAppRoundedImageView swanAppRoundedImageView = this.f45407b;
            if (swanAppRoundedImageView != null) {
                swanAppRoundedImageView.setImageBitmap(bitmap);
                this.f45407b.setBorderColor(this.f45406a.getResources().getColor(d.a.l0.a.c.swan_app_auth_icon_border));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends ImageSpan {
        public h(g gVar, Drawable drawable) {
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
        public final /* synthetic */ TextView f45408e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f45409f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.e2.c.f f45410g;

        public i(TextView textView, View view, d.a.l0.a.e2.c.f fVar) {
            this.f45408e = textView;
            this.f45409f = view;
            this.f45410g = fVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            g.this.y(!this.f45408e.isEnabled(), this.f45409f, this.f45408e, this.f45410g);
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
        SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) view.findViewById(d.a.l0.a.f.user_icon);
        TextView textView = (TextView) view.findViewById(d.a.l0.a.f.user_name);
        Pair<String, String> o = o(jSONObject);
        if (o != null) {
            t.e((String) o.second, new C0676g(this, context, swanAppRoundedImageView));
            if (textView != null) {
                textView.setText((CharSequence) o.first);
            }
        }
    }

    public final void B(d.a.l0.a.e2.c.f fVar, TextView textView, View view, TextView textView2, JSONObject jSONObject, View view2) {
        if (fVar == null) {
            return;
        }
        String str = fVar.l;
        if (str != null) {
            textView2.setText(Html.fromHtml(str));
        }
        textView.setText(fVar.f45375f);
        ((LinearLayout) view.findViewById(d.a.l0.a.f.permission_detail_layout)).setVisibility(0);
        if (((!TextUtils.equals(fVar.f45371b, "snsapi_userinfo") || jSONObject == null) && !TextUtils.equals(fVar.f45371b, "mobile")) || view2 == null) {
            return;
        }
        view2.findViewById(d.a.l0.a.f.auth_divider1).setVisibility(8);
    }

    public final void C(Context context, String str) {
        if (context instanceof SwanAppActivity) {
            SwanAppActivity swanAppActivity = (SwanAppActivity) context;
            ActivityResultDispatcher resultDispatcher = swanAppActivity.getResultDispatcher();
            Intent intent = new Intent(context, SwanAppScopeDetailActivity.class);
            intent.putExtra("url", str);
            resultDispatcher.addConsumer(new a(this));
            d.a.l0.a.g1.f.V().p();
            resultDispatcher.startActivityForResult(intent);
            swanAppActivity.overridePendingTransition(d.a.l0.a.a.aiapps_slide_in_from_right, d.a.l0.a.a.aiapps_hold);
        }
    }

    @Override // d.a.l0.a.p.d.r
    public h.a a(Context context, d.a.l0.a.a2.e eVar, d.a.l0.a.e2.c.f fVar, JSONObject jSONObject, DialogInterface.OnClickListener onClickListener) {
        if (context == null || eVar == null || fVar == null) {
            return null;
        }
        h.a aVar = new h.a(context);
        this.f45390f = aVar;
        this.f45385a = context;
        this.f45386b = eVar;
        this.f45388d = fVar;
        this.f45389e = jSONObject;
        this.f45387c = onClickListener;
        aVar.f(true);
        this.f45390f.W(n());
        this.f45390f.n(new d.a.l0.a.w2.h.a());
        this.f45390f.p(d.a.l0.a.e.aiapps_action_sheet_bg);
        this.f45390f.k(false);
        this.f45390f.j();
        this.f45390f.t(false);
        return this.f45390f;
    }

    public final void k() {
        FrameLayout frameLayout = (FrameLayout) this.f45391g.findViewById(d.a.l0.a.f.auth_custom_layout);
        if (frameLayout == null) {
            return;
        }
        this.f45391g.findViewById(d.a.l0.a.f.multi_auth_custom_layout).setVisibility(8);
        this.f45391g.findViewById(d.a.l0.a.f.multi_auth_agreement_layout).setVisibility(8);
        this.f45391g.findViewById(d.a.l0.a.f.auth_custom_layout).setVisibility(0);
        this.f45393i = View.inflate(this.f45385a, d.a.l0.a.g.swan_app_auth_scope_detail, null);
        this.f45388d.f();
        v(false, this.f45393i, this.k, this.f45388d);
        frameLayout.addView(this.f45393i);
    }

    public final void l() {
        int i2;
        if (((FrameLayout) this.f45391g.findViewById(d.a.l0.a.f.multi_auth_custom_layout)) == null) {
            return;
        }
        this.f45391g.findViewById(d.a.l0.a.f.multi_auth_custom_layout).setVisibility(0);
        this.f45391g.findViewById(d.a.l0.a.f.multi_auth_agreement_layout).setVisibility(0);
        this.f45391g.findViewById(d.a.l0.a.f.auth_custom_layout).setVisibility(8);
        this.f45388d.f();
        y(true, this.f45391g.findViewById(d.a.l0.a.f.auth_scope_detail_layout), this.k, this.f45388d);
        TextView textView = (TextView) this.f45391g.findViewById(d.a.l0.a.f.multi_auth_agreement_layout);
        textView.setVisibility(0);
        f.a aVar = this.f45388d.n;
        String str = aVar.f45383e;
        JSONArray jSONArray = aVar.f45384f;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f45385a.getString(d.a.l0.a.h.aiapps_check_action_text));
        if (!TextUtils.isEmpty(aVar.f45382d)) {
            sb.append(aVar.f45382d);
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
        if (!TextUtils.isEmpty(aVar.f45382d)) {
            z(spannableString, sb, aVar.f45382d, aVar.f45381c, str);
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
        textView.setHighlightColor(0);
        textView.setLongClickable(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0065, code lost:
        if (r1.equals("snsapi_userinfo") == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m() {
        FrameLayout frameLayout = (FrameLayout) this.f45391g.findViewById(d.a.l0.a.f.auth_custom_layout);
        if (frameLayout == null) {
            return;
        }
        this.f45391g.findViewById(d.a.l0.a.f.multi_auth_custom_layout).setVisibility(8);
        this.f45391g.findViewById(d.a.l0.a.f.multi_auth_agreement_layout).setVisibility(8);
        char c2 = 0;
        this.f45391g.findViewById(d.a.l0.a.f.auth_custom_layout).setVisibility(0);
        ((TextView) this.f45391g.findViewById(d.a.l0.a.f.multi_auth_agreement_layout)).setVisibility(8);
        this.f45393i = p(this.f45385a, this.f45388d, this.f45389e);
        String str = this.f45388d.f45371b;
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
            JSONObject jSONObject = this.f45389e;
            if (jSONObject != null) {
                A(this.f45385a, this.f45393i, jSONObject);
            } else {
                x(this.f45393i, this.f45388d);
            }
        } else if (c2 != 1) {
            x(this.f45393i, this.f45388d);
        } else {
            w(this.f45393i, this.f45388d);
        }
        frameLayout.addView(this.f45393i);
    }

    public View n() {
        this.f45391g = View.inflate(this.f45385a, d.a.l0.a.g.swan_app_auth_dialog_content_common, null);
        q();
        r();
        s();
        return this.f45391g;
    }

    public Pair<String, String> o(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(TableDefine.DB_TABLE_USERINFO);
        if (optJSONObject == null) {
            return null;
        }
        return new Pair<>(optJSONObject.optString("nickname"), optJSONObject.optString("headimgurl"));
    }

    public final View p(Context context, d.a.l0.a.e2.c.f fVar, JSONObject jSONObject) {
        int i2;
        if (context == null || fVar == null || TextUtils.isEmpty(fVar.f45371b)) {
            return null;
        }
        String str = fVar.f45371b;
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
                i2 = d.a.l0.a.g.swan_app_auth_level2_custom;
            } else {
                i2 = d.a.l0.a.g.swan_app_auth_level1_mobile_custom;
            }
        } else if (jSONObject != null) {
            i2 = d.a.l0.a.g.swan_app_auth_level1_userinfo_custom;
        } else {
            i2 = d.a.l0.a.g.swan_app_auth_level2_custom;
        }
        return View.inflate(context, i2, null);
    }

    public void q() {
        List<d.a.l0.a.e2.c.f> list;
        Bitmap i2;
        boolean z = (TextUtils.isEmpty(this.f45388d.p) || TextUtils.isEmpty(this.f45388d.q)) ? false : true;
        SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) this.f45391g.findViewById(d.a.l0.a.f.swan_app_icon);
        if (swanAppRoundedImageView != null) {
            if (z) {
                i2 = q0.j(this.f45388d.q, "SwanAppAuthDialog", false);
            } else {
                i2 = q0.i(this.f45386b.N(), "SwanAppAuthDialog", false);
            }
            swanAppRoundedImageView.setImageDrawable(new BitmapDrawable(this.f45385a.getResources(), i2));
            swanAppRoundedImageView.setBorderColor(this.f45385a.getResources().getColor(d.a.l0.a.c.swan_app_auth_icon_border));
        }
        ((TextView) this.f45391g.findViewById(d.a.l0.a.f.swan_app_name)).setText(z ? this.f45388d.p : this.f45386b.O());
        TextView textView = (TextView) this.f45391g.findViewById(d.a.l0.a.f.permission_name);
        this.f45392h = textView;
        if (textView != null) {
            if (u(this.f45388d)) {
                View findViewById = this.f45391g.findViewById(d.a.l0.a.f.swan_app_action_text);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                this.f45392h.setText(this.f45388d.r);
            } else {
                this.f45392h.setText(this.f45388d.f45375f);
            }
        }
        if (u(this.f45388d) && (list = this.f45388d.s) != null && list.size() > 0) {
            for (int i3 = 0; i3 < list.size() && i3 <= 3; i3++) {
                d.a.l0.a.e2.c.f fVar = list.get(i3);
                if (fVar != null) {
                    this.f45391g.findViewById(n[i3]).setVisibility(0);
                    ((TextView) this.f45391g.findViewById(m[i3])).setText(fVar.f45376g);
                }
            }
        }
        this.j = (TextView) this.f45391g.findViewById(d.a.l0.a.f.auth_negative_button);
        this.k = (TextView) this.f45391g.findViewById(d.a.l0.a.f.auth_positive_button);
        this.f45390f.l(this.j, -2, this.f45387c);
        this.f45390f.l(this.k, -1, this.f45387c);
    }

    public void r() {
        if (u(this.f45388d)) {
            l();
        } else if (t(this.f45388d)) {
            k();
        } else {
            m();
        }
    }

    public void s() {
        TextView textView;
        if (TextUtils.isEmpty(this.f45388d.l) || (textView = (TextView) this.f45391g.findViewById(d.a.l0.a.f.permission_detail)) == null) {
            return;
        }
        d.a.l0.a.a2.e eVar = this.f45386b;
        if (eVar != null && eVar.N() != null && TextUtils.equals(this.f45386b.N().T(), "11010020") && TextUtils.equals(this.f45388d.f45371b, "mobile")) {
            B(this.f45388d, this.f45392h, this.f45391g, textView, this.f45389e, this.f45393i);
            textView.setTextColor(-16777216);
            return;
        }
        if (!u(this.f45388d)) {
            d.a.l0.a.w2.b bVar = new d.a.l0.a.w2.b(this.f45385a, d.a.l0.a.e.swan_app_auth_question_mark_pressed);
            SpannableString spannableString = new SpannableString(" # ");
            spannableString.setSpan(bVar, 1, 2, 33);
            spannableString.setSpan(new f(textView), 0, spannableString.length(), 33);
            this.f45392h.append(spannableString);
        }
        this.f45392h.setHighlightColor(0);
        this.f45392h.setMovementMethod(LinkMovementMethod.getInstance());
        this.f45392h.setLongClickable(false);
    }

    public boolean t(d.a.l0.a.e2.c.f fVar) {
        if (fVar == null) {
            return false;
        }
        return TextUtils.equals(fVar.f45371b, "ppcert") || TextUtils.equals(fVar.f45371b, "mapp_i_face_verify");
    }

    public boolean u(d.a.l0.a.e2.c.f fVar) {
        if (fVar == null) {
            return false;
        }
        return TextUtils.equals(fVar.f45371b, "scope_multi_authorize");
    }

    public final void v(boolean z, View view, TextView textView, d.a.l0.a.e2.c.f fVar) {
        f.a aVar;
        TextView textView2;
        Drawable drawable;
        if (view == null || fVar == null || (aVar = fVar.n) == null || (textView2 = (TextView) view.findViewById(d.a.l0.a.f.auth_scope_detail)) == null || TextUtils.isEmpty(aVar.f45379a)) {
            return;
        }
        if (!aVar.f45379a.startsWith("XXXX   ")) {
            aVar.f45379a = "XXXX   " + aVar.f45379a;
        }
        textView2.setText(aVar.f45379a);
        try {
            textView2.setTextColor(Color.parseColor(aVar.f45380b));
        } catch (RuntimeException e2) {
            if (l) {
                throw e2;
            }
        }
        SpannableString spannableString = new SpannableString(textView2.getText());
        textView.setEnabled(z);
        if (z) {
            drawable = view.getResources().getDrawable(d.a.l0.a.e.swanapp_scope_selected);
        } else {
            drawable = view.getResources().getDrawable(d.a.l0.a.e.swanapp_scope_unselected);
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        spannableString.setSpan(new b(this, drawable), 0, 4, 33);
        spannableString.setSpan(new c(textView, view, fVar), 0, 7, 33);
        int length = TextUtils.isEmpty(aVar.f45382d) ? 0 : aVar.f45382d.length();
        int indexOf = aVar.f45379a.indexOf(aVar.f45382d);
        int i2 = length + indexOf;
        try {
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(aVar.f45383e)), indexOf, i2, 33);
        } catch (RuntimeException e3) {
            if (l) {
                throw e3;
            }
        }
        spannableString.setSpan(new d(view, aVar), indexOf, i2, 33);
        textView2.setText(spannableString);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setHighlightColor(0);
    }

    public final void w(View view, d.a.l0.a.e2.c.f fVar) {
        if (view == null || fVar == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(d.a.l0.a.f.user_phone_number);
        StringBuilder sb = new StringBuilder();
        for (String str : fVar.f45378i) {
            sb.append(str);
        }
        if (textView != null) {
            textView.setText(sb.toString());
        }
    }

    public final void x(View view, d.a.l0.a.e2.c.f fVar) {
        TextView textView;
        SwanAppConfigData s;
        SwanAppConfigData.e eVar;
        Map<String, String> map;
        if (view == null || fVar == null || (textView = (TextView) view.findViewById(d.a.l0.a.f.permission_function)) == null) {
            return;
        }
        if (TextUtils.equals(fVar.f45371b, "mapp_location") && (s = d.a.l0.a.g1.f.V().s()) != null && (eVar = s.o) != null && (map = eVar.f11324a.get("scope.userLocation")) != null) {
            String str = map.get("desc");
            if (!TextUtils.isEmpty(str)) {
                fVar.m = str;
            }
        }
        textView.setText(fVar.m);
    }

    public final void y(boolean z, View view, TextView textView, d.a.l0.a.e2.c.f fVar) {
        TextView textView2;
        Drawable drawable;
        if (view == null || fVar == null || fVar.n == null || (textView2 = (TextView) view.findViewById(d.a.l0.a.f.auth_scope_detail)) == null) {
            return;
        }
        textView2.setText("XXXX   " + this.f45385a.getString(d.a.l0.a.h.swanapp_multi_auth_agreement_desc));
        textView.setEnabled(z);
        if (z) {
            drawable = view.getResources().getDrawable(d.a.l0.a.e.swanapp_scope_selected);
        } else {
            drawable = view.getResources().getDrawable(d.a.l0.a.e.swanapp_scope_unselected);
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        h hVar = new h(this, drawable);
        SpannableString spannableString = new SpannableString(textView2.getText());
        spannableString.setSpan(hVar, 0, 4, 33);
        spannableString.setSpan(new i(textView, view, fVar), 0, 7, 33);
        textView2.setText(spannableString);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setHighlightColor(0);
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
