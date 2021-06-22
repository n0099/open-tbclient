package d.a.m0.a.w1;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.publisher.ReplyEditorParams;
import com.baidu.swan.apps.publisher.emoji.EmojiEditText;
import com.baidu.swan.apps.publisher.view.SPSwitchPanelLinearLayout;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d.a.m0.a.p.d.h0;
import d.a.m0.a.v2.m0;
import d.a.m0.a.v2.n0;
import d.a.m0.a.v2.u;
import d.a.m0.a.w1.j.b;
import d.a.m0.a.w1.j.e;
import d.a.m0.a.z1.b.b.h;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends d.a.m0.o.a.a.h implements View.OnClickListener, d.a.m0.a.i1.d.d.c<MediaModel> {
    public SimpleDraweeView A0;
    public BdBaseImageView B0;
    public ImageView C0;
    public SPSwitchPanelLinearLayout D0;
    public View E0;
    public ImageView G0;
    public ReplyEditorParams J0;
    public d.a.m0.a.w1.a L0;
    public String M0;
    public MediaModel N0;
    public LinearLayout t0;
    public Context u0;
    public EmojiEditText v0;
    public LinearLayout w0;
    public TextView x0;
    public TextView y0;
    public FrameLayout z0;
    public boolean F0 = false;
    public boolean H0 = false;
    public boolean I0 = false;
    public boolean K0 = false;

    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            d.this.n1();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnKeyListener {
        public b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0 && i2 == 4) {
                d.this.F1();
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            d.this.F1();
            return false;
        }
    }

    /* renamed from: d.a.m0.a.w1.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0950d implements TextWatcher {
        public C0950d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            d.this.O1(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes3.dex */
    public class e implements EmojiEditText.e {
        public e() {
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void a(int i2) {
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void b(int i2) {
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void onBack() {
            d.this.F1();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements EmojiEditText.e {
        public f() {
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void a(int i2) {
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void b(int i2) {
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void onBack() {
            d.this.F1();
        }
    }

    /* loaded from: classes3.dex */
    public class g implements e.b {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f49334e;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.t0.setVisibility(0);
            }
        }

        public g(ViewGroup viewGroup) {
            this.f49334e = viewGroup;
        }

        @Override // d.a.m0.a.w1.j.e.b
        public void onSoftInputShowing(boolean z) {
            d.this.I0 = z;
            if (z) {
                d.this.G0.setImageResource(d.a.m0.a.e.swanapp_reply_editor_emotion);
                this.f49334e.post(new a());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements b.c {
        public h() {
        }

        @Override // d.a.m0.a.w1.j.b.c
        public void onClickSwitch(View view, boolean z) {
            d.this.H0 = z;
            if (z) {
                d.this.G0.setImageResource(d.a.m0.a.e.swanapp_reply_editor_keyboard);
            } else {
                d.this.G0.setImageResource(d.a.m0.a.e.swanapp_reply_editor_emotion);
            }
            d.a.m0.a.w1.j.d.onEvent("emoji_clk");
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.t0.setVisibility(0);
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((InputMethodManager) d.this.v0.getContext().getSystemService("input_method")).hideSoftInputFromWindow(d.this.v0.getWindowToken(), 0);
        }
    }

    public final void A1(boolean z) {
        EmojiEditText emojiEditText = this.v0;
        if (emojiEditText == null) {
            return;
        }
        if (z) {
            emojiEditText.setPadding(n0.g(8.0f), this.v0.getPaddingTop(), 0, this.v0.getPaddingBottom());
        } else {
            emojiEditText.setPadding(n0.g(8.0f), this.v0.getPaddingTop(), n0.g(8.0f), this.v0.getPaddingBottom());
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @SuppressLint({"ClickableViewAccessibility"})
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(d.a.m0.a.g.swanapp_reply_editor_layout, viewGroup, false);
        this.t0 = linearLayout;
        M1(linearLayout);
        this.t0.setFocusableInTouchMode(true);
        this.t0.setOnKeyListener(new b());
        this.y0.setOnClickListener(this);
        if (this.J0.d()) {
            this.C0.setVisibility(0);
            this.C0.setOnClickListener(this);
            this.C0.setOnTouchListener(new m0());
        } else {
            this.C0.setVisibility(8);
        }
        if (this.J0.b()) {
            this.G0.setVisibility(0);
            this.G0.setOnTouchListener(new m0());
        } else {
            this.G0.setVisibility(8);
        }
        this.E0.setOnTouchListener(new c());
        this.v0.addTextChangedListener(new C0950d());
        this.v0.setListener(new e());
        this.v0.setListener(new f());
        L1();
        if (this.N0 == null) {
            J1();
        }
        this.v0.requestFocus();
        return this.t0;
    }

    public final void B1() {
        int childCount = this.w0.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.w0.getChildAt(i2);
            if (!(childAt instanceof EmojiEditText)) {
                this.w0.removeView(childAt);
            }
        }
    }

    public void C1() {
        this.v0.setText("");
        F1();
    }

    public final void D1() {
        if (this.M0 != null) {
            SpannableString g2 = d.a.m0.a.w1.h.b.c().g(this.u0, this.M0, this.v0);
            this.v0.setText(g2);
            this.v0.setSelection(g2.length());
            O1(g2);
        }
        if (this.N0 != null) {
            A1(true);
            R1(this.N0);
            return;
        }
        A1(false);
    }

    public final void E1() {
        this.v0.setHint(this.J0.f11141e);
        this.y0.setText(this.J0.f11142f);
        this.y0.setTextColor(this.J0.f11143g);
        this.y0.setBackground(G1(this.J0.f11144h));
        if (this.J0.c()) {
            this.t0.findViewById(d.a.m0.a.f.module_layout).setVisibility(8);
        }
    }

    public void F1() {
        if (TextUtils.isEmpty(this.M0) && this.N0 == null) {
            d.a.m0.a.w1.e.c().a();
        } else {
            d.a.m0.a.w1.e.c().d(this.M0, this.N0);
        }
        H1("draft");
        n1();
    }

    public final StateListDrawable G1(int i2) {
        float g2 = n0.g(4.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(g2);
        gradientDrawable.setColor(i2);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(g2);
        gradientDrawable2.setColor((i2 & ViewCompat.MEASURED_SIZE_MASK) + 855638016);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
        stateListDrawable.addState(new int[]{16842910}, gradientDrawable);
        stateListDrawable.addState(new int[]{-16842910}, gradientDrawable2);
        return stateListDrawable;
    }

    public final void H1(String str) {
        if (this.L0 == null) {
            return;
        }
        if (!SwanAppNetworkUtils.i(q())) {
            d.a.m0.a.w1.j.g.h(q(), d.a.m0.a.h.swanapp_publisher_network_disconnect);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.J0.d()) {
                JSONObject jSONObject2 = new JSONObject();
                if (this.N0 != null) {
                    jSONObject2.put("path", d.a.m0.a.g1.f.V().I().h(this.N0.d()));
                    jSONObject2.put("size", this.N0.c());
                }
                jSONObject.put("tempFile", jSONObject2);
            }
            if (this.M0 == null) {
                this.M0 = "";
            }
            jSONObject.put("content", this.M0);
            jSONObject.put("status", str);
            this.L0.a(jSONObject);
            this.F0 = true;
            if (TextUtils.equals("reply", str)) {
                J1();
                d.a.m0.a.w1.e.c().a();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final boolean I1() {
        FrameLayout frameLayout = this.z0;
        return frameLayout != null && frameLayout.getVisibility() == 0;
    }

    public final void J1() {
        FrameLayout frameLayout = this.z0;
        if (frameLayout != null) {
            this.N0 = null;
            frameLayout.setVisibility(8);
            A1(false);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void K1() {
        Window window = p1().getWindow();
        if (window == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290);
        d.a.m0.a.w1.j.e.c(h(), viewGroup, this.D0, new g(viewGroup));
        d.a.m0.a.w1.j.b.b(this.D0, this.G0, this.v0, new h());
        d.a.m0.a.w1.h.d.b().c(h(), this.D0, this.v0, this.J0.f11145i, d.a.m0.a.a2.e.V(), d.a.m0.a.a2.e.i().Z());
        this.t0.setVisibility(4);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void L1() {
        B1();
        this.z0 = new FrameLayout(this.u0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(n0.g(60.0f), n0.g(60.0f));
        layoutParams.topMargin = n0.g(8.0f);
        layoutParams.bottomMargin = n0.g(8.0f);
        layoutParams.leftMargin = n0.g(19.0f);
        layoutParams.rightMargin = n0.g(9.0f);
        this.w0.addView(this.z0, layoutParams);
        FrameLayout frameLayout = new FrameLayout(this.u0);
        frameLayout.setBackgroundResource(d.a.m0.a.e.swanapp_reply_editor_picture_bg);
        frameLayout.setPadding(1, 1, 1, 1);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1, 17);
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(this.u0);
        this.A0 = simpleDraweeView;
        simpleDraweeView.setScaleType(ImageView.ScaleType.CENTER);
        frameLayout.addView(this.A0, layoutParams2);
        this.z0.addView(frameLayout, layoutParams2);
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.setBorderColor(Label.FORWARD_REFERENCE_TYPE_SHORT);
        roundingParams.setBorderWidth(1.0f);
        roundingParams.setCornersRadius(n0.g(3.0f));
        roundingParams.setOverlayColor(-1);
        GenericDraweeHierarchy build = new GenericDraweeHierarchyBuilder(this.u0.getResources()).build();
        build.setRoundingParams(roundingParams);
        this.A0.setHierarchy(build);
        this.B0 = new BdBaseImageView(this.u0);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(n0.g(20.0f), n0.g(20.0f));
        layoutParams3.gravity = 8388613;
        this.z0.addView(this.B0, layoutParams3);
        this.B0.setImageResource(d.a.m0.a.e.swanapp_reply_editor_picture_close);
        this.A0.setOnClickListener(this);
        this.B0.setOnTouchListener(new m0());
        this.B0.setOnClickListener(this);
    }

    public final void M1(@NonNull View view) {
        this.w0 = (LinearLayout) view.findViewById(d.a.m0.a.f.input_layout);
        this.v0 = (EmojiEditText) view.findViewById(d.a.m0.a.f.content);
        this.x0 = (TextView) view.findViewById(d.a.m0.a.f.length_hint);
        this.y0 = (TextView) view.findViewById(d.a.m0.a.f.send_button);
        this.C0 = (ImageView) view.findViewById(d.a.m0.a.f.input_picture_button);
        this.G0 = (ImageView) view.findViewById(d.a.m0.a.f.emotion_button);
        this.D0 = (SPSwitchPanelLinearLayout) view.findViewById(d.a.m0.a.f.panel_root);
        this.E0 = view.findViewById(d.a.m0.a.f.place_holder);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void N0(View view, Bundle bundle) {
        super.N0(view, bundle);
        if (this.K0) {
            Q1();
            return;
        }
        N1();
        E1();
        K1();
        D1();
        d.a.m0.a.w1.j.d.onEvent("show");
    }

    public final void N1() {
        p1().setCanceledOnTouchOutside(true);
        Window window = p1().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = -1;
            attributes.height = -1;
            attributes.softInputMode = 16;
            attributes.dimAmount = 0.0f;
            window.setAttributes(attributes);
        }
    }

    public final void O1(CharSequence charSequence) {
        this.M0 = charSequence.toString();
        int a2 = d.a.m0.a.w1.j.f.a(charSequence.toString());
        if (a2 < 0) {
            return;
        }
        if (a2 == 0) {
            if (I1()) {
                this.y0.setEnabled(true);
                this.x0.setVisibility(8);
                return;
            }
            this.y0.setEnabled(false);
            this.x0.setVisibility(8);
        } else if (a2 <= 200) {
            this.y0.setEnabled(true);
            if (a2 < 180) {
                this.x0.setVisibility(8);
                return;
            }
            this.x0.setVisibility(0);
            this.x0.setText(String.format(this.u0.getResources().getString(d.a.m0.a.h.swanapp_reply_editor_text_remain), Integer.valueOf(200 - a2)));
            this.x0.setTextColor(ContextCompat.getColor(this.u0, d.a.m0.a.c.swanapp_reply_editor_input_length_hint_color));
        } else {
            this.y0.setEnabled(false);
            this.x0.setVisibility(0);
            this.x0.setTextColor(ContextCompat.getColor(this.u0, d.a.m0.a.c.swanapp_reply_editor_over_length_color));
            if (a2 < 1200) {
                this.x0.setText(String.format(this.u0.getResources().getString(d.a.m0.a.h.swanapp_reply_editor_text_overstep), Integer.valueOf(a2 - 200)));
            } else {
                this.x0.setText(this.u0.getResources().getString(d.a.m0.a.h.swanapp_reply_editor_text_999_overstep));
            }
        }
    }

    public void P1(d.a.m0.a.w1.a aVar) {
        this.L0 = aVar;
    }

    public final void Q1() {
        h.a aVar = new h.a(q());
        aVar.m(false);
        aVar.U(d.a.m0.a.h.swanapp_publisher_error_title);
        aVar.v(d.a.m0.a.h.swanapp_publisher_params_error);
        aVar.O(d.a.m0.a.h.aiapps_confirm, new a());
        aVar.X();
    }

    public final void R1(MediaModel mediaModel) {
        String d2 = mediaModel.d();
        if (TextUtils.isEmpty(d2)) {
            FrameLayout frameLayout = this.z0;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
                return;
            }
            return;
        }
        FrameLayout frameLayout2 = this.z0;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
        this.A0.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setOldController(this.A0.getController()).setImageRequest(ImageRequestBuilder.newBuilderWithSource(u.m(d2)).setResizeOptions(new ResizeOptions(n0.o(this.u0), n0.n(this.u0))).build()).build());
        String str = this.M0;
        if (str == null) {
            str = "";
        }
        O1(str);
    }

    @Override // d.a.m0.a.i1.d.d.c
    public void e(String str) {
    }

    @Override // d.a.m0.a.i1.d.d.c
    public void f(List<MediaModel> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        MediaModel mediaModel = list.get(0);
        this.N0 = mediaModel;
        R1(mediaModel);
    }

    @Override // d.a.m0.o.a.a.h
    public void n1() {
        LinearLayout linearLayout = this.t0;
        if (linearLayout != null) {
            linearLayout.setOnKeyListener(null);
        }
        super.n1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h0 y;
        if (view == this.y0) {
            H1("reply");
            d.a.m0.a.w1.j.d.onEvent("pub_clk");
        } else if (view == this.B0) {
            J1();
            O1(this.v0.getText());
            d.a.m0.a.w1.j.d.onEvent("pic_clk_del");
        } else if (view == this.C0) {
            d.a.m0.a.w1.j.g.j(1, true, this);
            d.a.m0.a.w1.j.d.onEvent("pic_clk_bar");
        } else if (view != this.A0 || (y = d.a.m0.a.c1.a.y()) == null) {
        } else {
            y.d(q(), new String[]{this.N0.b()}, 0);
        }
    }

    @Override // d.a.m0.o.a.a.h, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.u0 = h();
        Bundle n = n();
        if (n != null) {
            this.J0 = (ReplyEditorParams) n.getParcelable("params");
            if (n.getBoolean("draft")) {
                this.M0 = n.getString("content");
                this.N0 = (MediaModel) n.getParcelable("image");
            }
            if (this.J0 == null) {
                this.K0 = true;
                return;
            }
            return;
        }
        this.K0 = true;
    }

    @Override // d.a.m0.o.a.a.h, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        EmojiEditText emojiEditText = this.v0;
        Editable text = emojiEditText != null ? emojiEditText.getText() : null;
        if (this.F0 || text == null || TextUtils.isEmpty(text.toString())) {
            if (this.F0 || this.v0 == null || !I1()) {
                EmojiEditText emojiEditText2 = this.v0;
                if (emojiEditText2 != null) {
                    emojiEditText2.postDelayed(new j(), 400L);
                }
                super.onDismiss(dialogInterface);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.H0 || this.I0) {
            d.a.m0.a.w1.j.e.n(this.v0, 160L);
            ((ViewGroup) p1().getWindow().getDecorView().findViewById(16908290)).postDelayed(new i(), 280L);
        }
    }

    @Override // d.a.m0.o.a.a.h
    public Dialog r1(Bundle bundle) {
        Dialog r1 = super.r1(bundle);
        r1.getWindow().requestFeature(1);
        return r1;
    }
}
