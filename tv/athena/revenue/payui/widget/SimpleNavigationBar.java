package tv.athena.revenue.payui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import i.a.a.e.d;
import i.a.a.e.e;
/* loaded from: classes8.dex */
public class SimpleNavigationBar extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f73089e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f73090f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f73091g;

    /* renamed from: h  reason: collision with root package name */
    public c f73092h;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SimpleNavigationBar.this.f73092h != null) {
                SimpleNavigationBar.this.f73092h.D();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SimpleNavigationBar.this.f73092h != null) {
                SimpleNavigationBar.this.f73092h.onRightClick();
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void D();

        void onRightClick();
    }

    public SimpleNavigationBar(Context context) {
        this(context, null);
    }

    public final void b(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(e.pay_ui_layout_navigation, (ViewGroup) this, true);
        this.f73091g = (ImageView) findViewById(d.iv_back);
        this.f73089e = (TextView) findViewById(d.tv_title);
        this.f73090f = (TextView) findViewById(d.tv_right);
        this.f73091g.setOnClickListener(new a());
        this.f73090f.setOnClickListener(new b());
    }

    public void setCallback(c cVar) {
        this.f73092h = cVar;
    }

    public void setRight(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f73090f.setText(str);
        this.f73090f.setVisibility(0);
    }

    public void setTitle(String str) {
        if (str != null && !str.isEmpty()) {
            this.f73089e.setText(str);
        }
        this.f73089e.setVisibility(0);
    }

    public SimpleNavigationBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimpleNavigationBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b(context, attributeSet);
    }
}
