package d.a.m0.a.w1;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.publisher.PublishParams;
import com.baidu.swan.apps.publisher.draft.DraftData;
import com.baidu.swan.apps.publisher.emoji.EmojiEditText;
import com.baidu.swan.apps.publisher.view.PhotoChooseView;
import com.baidu.swan.apps.publisher.view.SPSwitchPanelLinearLayout;
import d.a.m0.a.h0.g.g;
import d.a.m0.a.v2.q;
import d.a.m0.a.w1.j.b;
import d.a.m0.a.w1.j.e;
import d.a.m0.a.z1.b.b.h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.a.m0.a.h0.g.d implements View.OnClickListener, d.a.m0.a.i1.d.d.c<MediaModel>, e.b {
    public static final boolean X0 = d.a.m0.a.k.f46983a;
    public SPSwitchPanelLinearLayout C0;
    public EmojiEditText D0;
    public EmojiEditText E0;
    public TextView F0;
    public ImageView G0;
    public PhotoChooseView H0;
    public ImageView I0;
    public TextView J0;
    public TextView K0;
    public ImageView L0;
    public View M0;
    public PublishParams N0;
    public DraftData P0;
    public d.a.m0.a.w1.a Q0;
    public int U0;
    public boolean O0 = false;
    public boolean R0 = false;
    public int S0 = 0;
    public int T0 = 0;
    public EmojiEditText.e V0 = new m();
    public EmojiEditText.e W0 = new a();

    /* loaded from: classes3.dex */
    public class a implements EmojiEditText.e {
        public a() {
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void a(int i2) {
            c.this.T0 = i2;
            int i3 = i2 - 4999;
            c.this.J0.setVisibility(0);
            if (i3 < 999) {
                c.this.J0.setText(String.format("超%d字", Integer.valueOf(i3)));
            } else {
                c.this.J0.setText("超999+");
            }
            c.this.J0.setTextColor(SupportMenu.CATEGORY_MASK);
            c.this.c3();
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void b(int i2) {
            c.this.T0 = i2;
            if (i2 <= 4979) {
                c.this.J0.setVisibility(8);
            } else {
                c.this.J0.setText(String.format("剩%d字", Integer.valueOf(4999 - i2)));
                c.this.J0.setVisibility(0);
                c.this.J0.setTextColor(c.this.U0);
            }
            c.this.c3();
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void onBack() {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            c.this.i3();
        }
    }

    /* renamed from: d.a.m0.a.w1.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class DialogInterface$OnClickListenerC0949c implements DialogInterface.OnClickListener {
        public DialogInterface$OnClickListenerC0949c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            d.a.m0.a.w1.j.c.onEvent("draft_save");
            c.this.P0.setTimeStamp(System.currentTimeMillis());
            c.this.P0.setTitle(c.this.D0.getText().toString());
            c.this.P0.setContent(c.this.E0.getText().toString());
            c.this.P0.setImages(c.this.j3());
            d.a.m0.a.w1.g.a.d(c.this.P0);
            c.this.d3();
            if (c.this.Q0 != null) {
                c.this.Q0.onCancel();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            d.a.m0.a.w1.j.c.onEvent("draft_quit");
            d.a.m0.a.w1.g.a.a();
            c.this.d3();
            if (c.this.Q0 != null) {
                c.this.Q0.onCancel();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements b.c {
        public e() {
        }

        @Override // d.a.m0.a.w1.j.b.c
        public void onClickSwitch(View view, boolean z) {
            c.this.a3(z);
            d.a.m0.a.w1.j.c.onEvent("emoji_clk");
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnFocusChangeListener {
        public f() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                c.this.e3();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnKeyListener {
        public g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnFocusChangeListener {
        public h() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                c.this.g3();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnTouchListener {
        public i() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                c.this.b3();
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class j implements View.OnTouchListener {
        public j() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.r3(view, motionEvent);
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class k implements PhotoChooseView.b {
        public k() {
        }

        @Override // com.baidu.swan.apps.publisher.view.PhotoChooseView.b
        public void a(int i2) {
            if (i2 == 0) {
                c.this.c3();
            }
            if (i2 == c.this.N0.h() - 1) {
                c.this.h3();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f49321e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49322f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f49323g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f49324h;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.m0.a.z1.b.d.a.c(l.this.f49324h);
            }
        }

        public l(List list, String str, String str2, ViewGroup viewGroup) {
            this.f49321e = list;
            this.f49322f = str;
            this.f49323g = str2;
            this.f49324h = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                JSONObject a2 = d.a.m0.a.w1.j.a.a(this.f49321e, c.this.N0.g());
                if (a2 == null) {
                    if (c.X0) {
                        Log.d("SwanAppPublisher", "图片解析失败");
                    }
                    a2 = new JSONObject();
                }
                if (!this.f49322f.isEmpty()) {
                    a2.put("title", c.this.D0.getText().toString());
                }
                if (!this.f49323g.isEmpty()) {
                    a2.put("content", c.this.E0.getText().toString());
                }
                if (c.X0) {
                    Log.d("SwanAppPublisher", "publish result " + a2.toString());
                }
                this.f49324h.post(new a());
                d.a.m0.a.w1.g.a.a();
                c.this.Q0.a(a2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements EmojiEditText.e {
        public m() {
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void a(int i2) {
            c.this.S0 = i2;
            c.this.D0.setText(c.this.D0.getText().toString().substring(0, 20));
            c.this.D0.setSelection(20);
            d.a.m0.a.w1.j.g.h(c.this.q(), d.a.m0.a.h.swanapp_publisher_title_exceed);
            c.this.c3();
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void b(int i2) {
            c.this.S0 = i2;
            if (i2 == 0) {
                c.this.L0.setVisibility(8);
            } else {
                c.this.L0.setVisibility(0);
            }
            c.this.c3();
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void onBack() {
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.B0(layoutInflater, viewGroup, bundle);
        return layoutInflater.inflate(d.a.m0.a.g.swanapp_publisher_layout, viewGroup, false);
    }

    @Override // d.a.m0.a.h0.g.d
    public boolean K() {
        if (this.R0) {
            if (X0) {
                Log.d("SwanAppPublisher", "backPress: hide soft");
            }
            d.a.m0.a.w1.j.e.k(this.E0);
            this.R0 = false;
            return true;
        } else if (o3()) {
            if (X0) {
                Log.d("SwanAppPublisher", "backPress: show draft dialog");
            }
            t3();
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void N0(View view, Bundle bundle) {
        super.N0(view, bundle);
        if (this.O0) {
            s3();
            return;
        }
        n3(view);
        if (this.N0.p().booleanValue() && !TextUtils.isEmpty(this.N0.f().trim())) {
            m3();
        }
        l3();
        if (this.M0 == null) {
            this.M0 = this.N0.s().booleanValue() ? this.D0 : this.E0;
        }
        d.a.m0.a.w1.j.e.n(this.M0, 300L);
        d.a.m0.a.w1.j.c.onEvent("show");
        c3();
    }

    @Override // d.a.m0.a.h0.g.d
    public boolean X1() {
        return false;
    }

    @Override // d.a.m0.a.h0.g.d
    public boolean Z1() {
        return false;
    }

    public final void a3(boolean z) {
        if (z) {
            this.G0.setImageResource(d.a.m0.a.e.swanapp_ugc_keyboard_selector);
        } else {
            this.G0.setImageResource(d.a.m0.a.e.swanapp_ugc_switch_soft_emoji_selector);
        }
    }

    public final void b3() {
        d.a.m0.a.w1.j.b.d(this.C0, this.E0);
        ImageView imageView = this.G0;
        if (imageView != null) {
            imageView.setImageResource(d.a.m0.a.e.swanapp_ugc_switch_soft_emoji_selector);
        }
    }

    public final void c3() {
        int i2;
        List<String> j3 = j3();
        boolean z = !this.N0.s().booleanValue() ? ((i2 = this.T0) <= 0 || i2 > 4999) && (j3 == null || j3.size() <= 0) : this.S0 <= 0 || (this.T0 <= 0 && (j3 == null || j3.size() <= 0));
        if (z && !this.K0.isClickable()) {
            this.K0.setClickable(true);
            this.K0.setTextColor(this.N0.m());
        } else if (z || !this.K0.isClickable()) {
        } else {
            this.K0.setClickable(false);
            this.K0.setTextColor(z().getColor(d.a.m0.a.c.swanapp_ugc_publish_no_able_color));
        }
    }

    public void d3() {
        d.a.m0.a.w1.j.e.k(this.E0);
        this.E0.e();
        this.D0.e();
        i3();
    }

    @Override // d.a.m0.a.i1.d.d.c
    public void e(String str) {
    }

    @Override // d.a.m0.a.h0.g.d
    public void e2() {
    }

    public final void e3() {
        this.G0.setImageResource(d.a.m0.a.e.swanapp_ugc_switch_soft_emoji_pressed);
        this.G0.setClickable(false);
    }

    @Override // d.a.m0.a.i1.d.d.c
    public void f(List<MediaModel> list) {
        ArrayList arrayList = new ArrayList();
        for (MediaModel mediaModel : list) {
            arrayList.add(mediaModel.b());
        }
        this.H0.e(arrayList);
        if (this.N0.s().booleanValue() && this.S0 == 0 && this.T0 == 0) {
            d.a.m0.a.w1.j.e.n(this.D0, 300L);
        } else {
            d.a.m0.a.w1.j.e.n(this.E0, 300L);
        }
        c3();
        if (this.H0.getLeftCount() == 0) {
            f3();
        }
    }

    public final void f3() {
        this.I0.setImageResource(d.a.m0.a.e.swanapp_ugc_choose_photo_pressed);
        this.I0.setClickable(false);
    }

    public final void g3() {
        this.G0.setImageResource(d.a.m0.a.e.swanapp_ugc_switch_soft_emoji_selector);
        this.G0.setClickable(true);
    }

    public final void h3() {
        this.I0.setImageResource(d.a.m0.a.e.swanapp_publisher_photo_choose_selector);
        this.I0.setClickable(true);
    }

    public final void i3() {
        g.b i2 = d.a.m0.a.g1.f.V().W().i("navigateBack");
        i2.n(d.a.m0.a.h0.g.g.f45862i, d.a.m0.a.h0.g.g.f45861h);
        i2.g();
        i2.a();
    }

    public final List<String> j3() {
        if (this.N0.q().booleanValue()) {
            return this.H0.getData();
        }
        return null;
    }

    public final void k3() {
        if (X0) {
            Log.d("SwanAppPublisher", "go publish");
        }
        if (!SwanAppNetworkUtils.i(q())) {
            d.a.m0.a.w1.j.g.h(q(), d.a.m0.a.h.swanapp_publisher_image_upload_fail);
        } else if (this.Q0 == null) {
        } else {
            String obj = this.D0.getText().toString();
            String obj2 = this.E0.getText().toString();
            List<String> j3 = j3();
            if (this.N0.s().booleanValue() && TextUtils.isEmpty(obj.trim())) {
                d.a.m0.a.w1.j.g.h(q(), d.a.m0.a.h.swanapp_publisher_error_empty);
            } else if (TextUtils.isEmpty(obj2.trim()) && (j3 == null || j3.size() == 0)) {
                d.a.m0.a.w1.j.g.h(q(), d.a.m0.a.h.swanapp_publisher_error_empty);
            } else if (j3 != null && j3.size() > 0) {
                ViewGroup viewGroup = (ViewGroup) h().findViewById(16908290);
                d.a.m0.a.z1.b.d.a.f(q(), viewGroup, z().getString(d.a.m0.a.h.swanapp_publisher_handling_pictures));
                this.K0.setClickable(false);
                this.K0.setTextColor(z().getColor(d.a.m0.a.c.swanapp_ugc_publish_no_able_color));
                q.e().execute(new l(j3, obj, obj2, viewGroup));
            } else {
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (!obj.isEmpty()) {
                        jSONObject.put("title", this.D0.getText().toString());
                    }
                    if (!obj2.isEmpty()) {
                        jSONObject.put("content", this.E0.getText().toString());
                    }
                    if (X0) {
                        Log.d("SwanAppPublisher", "publish result " + jSONObject.toString());
                    }
                    d.a.m0.a.w1.g.a.a();
                    this.Q0.a(jSONObject);
                } catch (JSONException e2) {
                    if (X0) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public final void l3() {
        DraftData c2 = d.a.m0.a.w1.g.a.c();
        this.P0 = c2;
        if (c2 != null) {
            if (X0) {
                Log.d("SwanAppPublisher", "update view from draft data");
            }
            String title = this.P0.getTitle();
            if (this.N0.s().booleanValue() && !TextUtils.isEmpty(title)) {
                this.D0.setText(title);
                this.D0.setSelection(title.length());
                this.M0 = this.D0;
            }
            String content = this.P0.getContent();
            if (!TextUtils.isEmpty(content)) {
                this.E0.setText(content);
                if (this.N0.p().booleanValue() && d.a.m0.a.w1.h.b.c().e()) {
                    this.E0.c();
                }
                EmojiEditText emojiEditText = this.E0;
                emojiEditText.setSelection(emojiEditText.getText().length());
                this.M0 = this.E0;
            }
            if (this.N0.q().booleanValue()) {
                this.H0.e(this.P0.getImages());
                if (this.H0.getLeftCount() == 0) {
                    f3();
                    return;
                }
                return;
            }
            return;
        }
        this.P0 = new DraftData(0L, "", "", null);
    }

    public final void m3() {
        d.a.m0.a.w1.j.e.c(h(), (ViewGroup) h().findViewById(16908290), this.C0, this);
        d.a.m0.a.w1.j.b.b(this.C0, this.G0, this.E0, new e());
        d.a.m0.a.w1.h.d.b().c(h(), this.C0, this.E0, this.N0.f(), this.N0.a(), this.N0.b());
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void n3(View view) {
        if (X0) {
            Log.d("SwanAppPublisher", "init view");
        }
        this.D0 = (EmojiEditText) view.findViewById(d.a.m0.a.f.post_title);
        if (this.N0.s().booleanValue()) {
            view.findViewById(d.a.m0.a.f.post_title_layout).setVisibility(0);
            this.D0.setHint(this.N0.o());
            this.D0.setListener(this.V0);
            this.D0.setMaxSize(20);
            this.D0.setOnFocusChangeListener(new f());
        } else {
            view.findViewById(d.a.m0.a.f.post_title_layout).setVisibility(8);
        }
        this.G0 = (ImageView) view.findViewById(d.a.m0.a.f.add_emoij);
        if (this.N0.p().booleanValue() && !TextUtils.isEmpty(this.N0.f().trim())) {
            this.G0.setVisibility(0);
        } else {
            this.G0.setVisibility(8);
        }
        this.C0 = (SPSwitchPanelLinearLayout) view.findViewById(d.a.m0.a.f.emoji_panel_root);
        view.findViewById(d.a.m0.a.f.nav_bar).setBackgroundColor(this.N0.i());
        TextView textView = (TextView) view.findViewById(d.a.m0.a.f.publish_title);
        textView.setText(this.N0.k());
        textView.setTextColor(this.N0.j());
        ImageView imageView = (ImageView) view.findViewById(d.a.m0.a.f.clear_title);
        this.L0 = imageView;
        imageView.setOnClickListener(this);
        this.F0 = (TextView) view.findViewById(d.a.m0.a.f.post_target);
        if (this.N0.r().booleanValue() && !TextUtils.isEmpty(this.N0.n().trim())) {
            TextView textView2 = this.F0;
            textView2.setText("发布到 " + this.N0.n());
        } else {
            view.findViewById(d.a.m0.a.f.post_target_layout).setVisibility(8);
        }
        this.J0 = (TextView) view.findViewById(d.a.m0.a.f.text_number);
        EmojiEditText emojiEditText = (EmojiEditText) view.findViewById(d.a.m0.a.f.post_content);
        this.E0 = emojiEditText;
        emojiEditText.setOnKeyListener(new g());
        this.E0.setHint(this.N0.e());
        this.E0.setListener(this.W0);
        this.E0.setMaxSize(4999);
        this.E0.setOnFocusChangeListener(new h());
        view.findViewById(d.a.m0.a.f.content_scroll_layout).setOnTouchListener(new i());
        TextView textView3 = (TextView) view.findViewById(d.a.m0.a.f.publish_button);
        this.K0 = textView3;
        textView3.setText(this.N0.l());
        this.K0.setOnClickListener(this);
        this.K0.setClickable(false);
        TextView textView4 = (TextView) view.findViewById(d.a.m0.a.f.cancel_button);
        textView4.setText(this.N0.c());
        textView4.setTextColor(this.N0.d());
        textView4.setOnClickListener(this);
        textView4.setOnTouchListener(new j());
        this.I0 = (ImageView) view.findViewById(d.a.m0.a.f.add_picture);
        this.H0 = (PhotoChooseView) view.findViewById(d.a.m0.a.f.pic_choose);
        if (this.N0.q().booleanValue()) {
            this.I0.setVisibility(0);
            this.I0.setOnClickListener(this);
            this.H0.setVisibility(0);
            this.H0.d(h());
            this.H0.setMaxCount(this.N0.h());
            this.H0.setCallback(this);
            this.H0.setDeleteListener(new k());
        } else {
            this.I0.setVisibility(8);
            this.H0.setVisibility(8);
        }
        this.U0 = z().getColor(d.a.m0.a.c.swanapp_text_number_color);
    }

    public final boolean o3() {
        String trim = this.N0.s().booleanValue() ? this.D0.getText().toString().trim() : "";
        String trim2 = this.E0.getText().toString().trim();
        List<String> j3 = j3();
        if (TextUtils.isEmpty(trim) && TextUtils.isEmpty(trim2) && j3 == null) {
            d.a.m0.a.w1.g.a.a();
            return false;
        }
        if (TextUtils.equals(trim, this.P0.getTitle()) && TextUtils.equals(trim2, this.P0.getContent())) {
            List<String> images = this.P0.getImages();
            if (images == null && j3 == null) {
                return false;
            }
            if (images != null && j3 != null && images.size() == j3.size()) {
                for (int i2 = 0; i2 < j3.size(); i2++) {
                    if (!TextUtils.equals(images.get(i2), j3.get(i2))) {
                        return true;
                    }
                }
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.a.m0.a.f.publish_button) {
            d.a.m0.a.w1.j.c.onEvent("pub_clk");
            k3();
        } else if (id == d.a.m0.a.f.cancel_button) {
            d.a.m0.a.w1.j.c.onEvent("cancel_clk");
            p3();
        } else if (id == d.a.m0.a.f.add_picture) {
            d.a.m0.a.w1.j.c.onEvent("pic_clk_bar");
            d.a.m0.a.w1.j.g.i(this.H0.getLeftCount(), this);
        } else if (id == d.a.m0.a.f.clear_title) {
            this.D0.setText("");
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle n = n();
        if (n != null) {
            PublishParams publishParams = (PublishParams) n.getParcelable("params");
            this.N0 = publishParams;
            if (publishParams == null) {
                this.O0 = true;
                return;
            }
            return;
        }
        this.O0 = true;
    }

    @Override // d.a.m0.a.w1.j.e.b
    public void onSoftInputShowing(boolean z) {
        if (X0) {
            Log.d("SwanAppPublisher", "soft input is showing ? " + z);
        }
        this.R0 = z;
    }

    public final void p3() {
        if (o3()) {
            t3();
            return;
        }
        d3();
        d.a.m0.a.w1.a aVar = this.Q0;
        if (aVar != null) {
            aVar.onCancel();
        }
    }

    public void q3(d.a.m0.a.w1.a aVar) {
        this.Q0 = aVar;
    }

    public final void r3(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            if (view != null) {
                view.setAlpha(0.2f);
            }
        } else if (action != 2) {
            if (view != null) {
                view.setAlpha(1.0f);
            }
        } else if (view != null) {
            view.setAlpha(0.2f);
        }
    }

    public final void s3() {
        h.a aVar = new h.a(q());
        aVar.m(false);
        aVar.U(d.a.m0.a.h.swanapp_publisher_error_title);
        aVar.v(d.a.m0.a.h.swanapp_publisher_params_error);
        aVar.O(d.a.m0.a.h.aiapps_confirm, new b());
        aVar.X();
    }

    public final void t3() {
        h.a aVar = new h.a(h());
        aVar.U(d.a.m0.a.h.swanapp_save_draft_dialog_title);
        aVar.B(d.a.m0.a.h.swanapp_save_draft_dialog_btn_negative, new d());
        aVar.v(d.a.m0.a.h.swanapp_save_draft_dialog_message);
        aVar.O(d.a.m0.a.h.swanapp_save_draft_dialog_btn_positive, new DialogInterface$OnClickListenerC0949c());
        aVar.X();
    }
}
