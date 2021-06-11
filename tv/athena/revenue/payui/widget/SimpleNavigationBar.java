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
    public TextView f72985e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f72986f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f72987g;

    /* renamed from: h  reason: collision with root package name */
    public c f72988h;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SimpleNavigationBar.this.f72988h != null) {
                SimpleNavigationBar.this.f72988h.D();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SimpleNavigationBar.this.f72988h != null) {
                SimpleNavigationBar.this.f72988h.onRightClick();
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
        this.f72987g = (ImageView) findViewById(d.iv_back);
        this.f72985e = (TextView) findViewById(d.tv_title);
        this.f72986f = (TextView) findViewById(d.tv_right);
        this.f72987g.setOnClickListener(new a());
        this.f72986f.setOnClickListener(new b());
    }

    public void setCallback(c cVar) {
        this.f72988h = cVar;
    }

    public void setRight(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f72986f.setText(str);
        this.f72986f.setVisibility(0);
    }

    public void setTitle(String str) {
        if (str != null && !str.isEmpty()) {
            this.f72985e.setText(str);
        }
        this.f72985e.setVisibility(0);
    }

    public SimpleNavigationBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimpleNavigationBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b(context, attributeSet);
    }
}
