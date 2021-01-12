package com.qq.e.comm.plugin.gdtnativead.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.qq.e.comm.plugin.ac.h;
import com.qq.e.comm.plugin.ad.j;
import com.qq.e.comm.plugin.ad.r;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final int f11998a = Color.parseColor("#909090");

    /* renamed from: b  reason: collision with root package name */
    private static final int f11999b = Color.parseColor("#909090");
    private static final int c = Color.parseColor("#D5D5D6");
    private static final int d = Color.parseColor("#00C634");
    private static final int e = Color.parseColor("#3185FC");
    private ScrollView f;
    private LinearLayout g;
    private ImageView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private h n;
    private TextView o;
    private Context p;
    private int q;
    private HorizontalScrollView r;
    private FrameLayout s;
    private int t;
    private long u;
    private JSONObject v;
    private j w;
    private a x;
    private r y;

    /* loaded from: classes3.dex */
    public interface a {
        void c(boolean z);
    }

    public b(Context context, j jVar, JSONObject jSONObject) {
        super(context);
        this.p = context.getApplicationContext();
        this.v = jSONObject;
        this.w = jVar;
        this.q = jSONObject.optInt("producttype");
        if (jVar != null && jVar.h() == 32) {
            this.t = jVar.f();
        }
        this.y = new r(context);
        a();
    }

    private void a() {
        if (this.f == null) {
            this.f = new ScrollView(getContext()) { // from class: com.qq.e.comm.plugin.gdtnativead.a.b.1
                @Override // android.view.View
                protected void onScrollChanged(int i, int i2, int i3, int i4) {
                    super.onScrollChanged(i, i2, i3, i4);
                    if (b.this.s == null) {
                        return;
                    }
                    GDTLogger.d("onScrollChanged, " + i + ", " + i2);
                    if (i2 <= 0 && b.this.s.getVisibility() != 4) {
                        post(new Runnable() { // from class: com.qq.e.comm.plugin.gdtnativead.a.b.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.s != null) {
                                    b.this.s.setVisibility(4);
                                }
                            }
                        });
                    } else if (i2 <= 0 || b.this.s.getVisibility() == 0) {
                    } else {
                        post(new Runnable() { // from class: com.qq.e.comm.plugin.gdtnativead.a.b.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.s != null) {
                                    b.this.s.setVisibility(0);
                                }
                            }
                        });
                    }
                }
            };
        }
        this.f.setVisibility(0);
        this.f.setBackgroundColor(-1);
        this.f.setVerticalScrollBarEnabled(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = ak.a(this.p, 50);
        addView(this.f, layoutParams);
        if (this.s == null) {
            this.s = new FrameLayout(getContext());
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Integer.MIN_VALUE, 1073741824, 0});
            ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, ak.a(this.p, 5));
            this.s.setBackgroundDrawable(gradientDrawable);
            this.s.setVisibility(4);
            addView(this.s, layoutParams2);
        }
        if (this.n == null) {
            this.n = new h(getContext());
            this.n.a(true);
            this.n.b(100);
            this.n.a(this.w.f());
            this.n.setOnClickListener(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.gdtnativead.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.x == null || b.this.b() || !b.this.y.a()) {
                        return;
                    }
                    b.this.x.c(false);
                }
            });
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, ak.a(this.p, 50));
            layoutParams3.gravity = 80;
            addView(this.n, layoutParams3);
        }
        if (this.o == null) {
            this.o = new TextView(getContext());
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ak.a(this.p, 50));
            layoutParams4.gravity = 81;
            this.o.setGravity(17);
            b(this.w.f(), this.w.h());
            this.o.setTextSize(2, 17.0f);
            this.o.setTextColor(-1);
            addView(this.o, layoutParams4);
        }
        if (this.g == null) {
            this.g = new LinearLayout(getContext());
            this.g.setOrientation(1);
            FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, -1);
            this.g.setBackgroundColor(-1);
            this.f.addView(this.g, layoutParams5);
        }
        JSONArray optJSONArray = this.v.optJSONArray("screenshot_url_list");
        if (this.q != 12 || optJSONArray == null || optJSONArray.length() <= 0) {
            c();
        } else {
            a(optJSONArray);
        }
    }

    private void a(JSONArray jSONArray) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = ak.a(this.p, 24);
        this.g.addView(relativeLayout, layoutParams);
        relativeLayout.setPadding(ak.a(this.p, 16), 0, ak.a(this.p, 16), 0);
        if (this.h == null) {
            this.h = new ImageView(getContext());
            this.h.setId(33333);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ak.a(this.p, 64), ak.a(this.p, 64));
            layoutParams2.addRule(9);
            this.h.setBackgroundColor(c);
            com.qq.e.comm.plugin.p.a.a().a(this.w.j(), this.h);
            relativeLayout.addView(this.h, layoutParams2);
        }
        if (this.k == null) {
            this.k = new TextView(getContext());
            this.k.setId(33335);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams3.addRule(1, 33333);
            layoutParams3.addRule(11);
            layoutParams3.addRule(10);
            layoutParams3.leftMargin = ak.a(this.p, 16);
            layoutParams3.rightMargin = ak.a(this.p, 16);
            this.k.setText(this.v.optString(DocumentOpenUtil.TXT));
            this.k.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.k.setTextSize(2, 17.0f);
            this.k.setMaxLines(1);
            relativeLayout.addView(this.k, layoutParams3);
        }
        if (this.l == null) {
            this.l = new TextView(getContext());
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.topMargin = ak.a(this.p, 4);
            layoutParams4.leftMargin = ak.a(this.p, 16);
            layoutParams4.rightMargin = ak.a(this.p, 16);
            layoutParams4.addRule(1, 33333);
            layoutParams4.addRule(11);
            layoutParams4.addRule(3, 33335);
            this.l.setText(this.v.optString("desc"));
            this.l.setTextColor(f11998a);
            this.l.setTextSize(2, 15.0f);
            this.l.setMaxLines(2);
            relativeLayout.addView(this.l, layoutParams4);
        }
        if (this.r == null) {
            this.r = new HorizontalScrollView(getContext());
        }
        this.r.setVisibility(0);
        this.r.setBackgroundColor(-1);
        this.r.setHorizontalScrollBarEnabled(false);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams5.topMargin = ak.a(this.p, 24);
        this.r.setPadding(ak.a(this.p, 12), 0, ak.a(this.p, 12), 0);
        this.g.addView(this.r, layoutParams5);
        LinearLayout linearLayout = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, -2);
        linearLayout.setOrientation(0);
        this.r.addView(linearLayout, layoutParams6);
        for (int i = 0; i < jSONArray.length(); i++) {
            String optString = jSONArray.optString(i);
            if (!TextUtils.isEmpty(optString)) {
                ImageView imageView = new ImageView(getContext());
                LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(ak.a(this.p, 160), ak.a(this.p, 285));
                layoutParams7.setMargins(ak.a(this.p, 3), ak.a(this.p, 0), ak.a(this.p, 3), ak.a(this.p, 8));
                imageView.setBackgroundColor(c);
                com.qq.e.comm.plugin.p.a.a().a(optString, imageView);
                linearLayout.addView(imageView, layoutParams7);
            }
        }
        if (this.i == null) {
            this.i = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams8.topMargin = ak.a(this.p, 12);
            layoutParams8.leftMargin = ak.a(this.p, 16);
            this.i.setText("版本");
            this.i.setTextColor(f11999b);
            this.i.setTextSize(2, 15.0f);
            this.g.addView(this.i, layoutParams8);
        }
        if (this.m == null) {
            this.m = new TextView(getContext());
            this.m.setText(this.w.a());
            this.m.setTextColor(f11998a);
            this.m.setTextSize(2, 15.0f);
            LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams9.leftMargin = ak.a(this.p, 16);
            layoutParams9.topMargin = ak.a(this.p, 4);
            layoutParams9.bottomMargin = ak.a(this.p, 96);
            this.g.addView(this.m, layoutParams9);
        }
    }

    private void b(int i, int i2) {
        switch (i2) {
            case 0:
                this.o.setBackgroundColor(e);
                this.o.setText(this.w.b() > 0 ? String.format("下载（%.1fM）", Float.valueOf(((float) this.w.b()) / 1000000.0f)) : "下载");
                return;
            case 1:
                this.o.setBackgroundColor(e);
                this.o.setText("打开");
                return;
            case 4:
            case 128:
                this.o.setBackgroundColor(0);
                this.o.setText(i > 0 ? "下载中 " + i + "%" : "下载中");
                return;
            case 8:
                this.o.setBackgroundColor(d);
                this.o.setText("立即安装");
                return;
            case 16:
                this.o.setBackgroundColor(e);
                this.o.setText("下载失败，点击重试");
                return;
            case 32:
                this.o.setBackgroundColor(0);
                this.o.setText(i > 0 ? "继续下载 " + i + "%" : "下载");
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.u < IMConnection.RETRY_DELAY_TIMES) {
            return true;
        }
        this.u = currentTimeMillis;
        return false;
    }

    private void c() {
        if (this.h == null) {
            this.h = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ak.a(this.p, 64), ak.a(this.p, 64));
            layoutParams.gravity = 1;
            layoutParams.topMargin = ak.a(this.p, 32);
            this.h.setBackgroundColor(c);
            com.qq.e.comm.plugin.p.a.a().a(this.w.j(), this.h);
            this.g.addView(this.h, layoutParams);
        }
        if (this.k == null) {
            this.k = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 1;
            layoutParams2.setMargins(ak.a(this.p, 16), ak.a(this.p, 16), ak.a(this.p, 16), ak.a(this.p, 16));
            this.k.setText(this.v.optString(DocumentOpenUtil.TXT));
            this.k.setGravity(1);
            this.k.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.k.setTextSize(2, 17.0f);
            this.g.addView(this.k, layoutParams2);
        }
        if (this.j == null) {
            this.j = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.topMargin = ak.a(this.p, 24);
            layoutParams3.leftMargin = ak.a(this.p, 16);
            this.j.setText("描述");
            this.j.setTextColor(f11999b);
            this.j.setTextSize(2, 15.0f);
            this.g.addView(this.j, layoutParams3);
        }
        if (this.l == null) {
            this.l = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.topMargin = ak.a(this.p, 4);
            layoutParams4.leftMargin = ak.a(this.p, 16);
            layoutParams4.rightMargin = ak.a(this.p, 16);
            this.l.setText(this.v.optString("desc"));
            this.l.setTextColor(f11998a);
            this.l.setTextSize(2, 15.0f);
            this.g.addView(this.l, layoutParams4);
        }
        if (this.i == null) {
            this.i = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.topMargin = ak.a(this.p, 12);
            layoutParams5.leftMargin = ak.a(this.p, 16);
            this.i.setText("版本");
            this.i.setTextColor(f11999b);
            this.i.setTextSize(2, 15.0f);
            this.g.addView(this.i, layoutParams5);
        }
        if (this.m == null) {
            this.m = new TextView(getContext());
            this.m.setText(this.w.a());
            this.m.setTextColor(f11998a);
            this.m.setTextSize(2, 15.0f);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams6.leftMargin = ak.a(this.p, 16);
            layoutParams6.topMargin = ak.a(this.p, 4);
            layoutParams6.bottomMargin = ak.a(this.p, 32);
            this.g.addView(this.m, layoutParams6);
        }
    }

    public void a(int i, int i2) {
        if (i2 == 32) {
            this.t = i;
        }
        if (i2 == 0 || i2 == 8) {
            this.t = 0;
        }
        if (this.n != null) {
            this.n.a(i >= this.t ? i : this.t);
        }
        if (this.o != null) {
            if (i < this.t) {
                i = this.t;
            }
            b(i, i2);
        }
    }

    public void a(a aVar) {
        this.x = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.y.a(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }
}
