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
/* loaded from: classes8.dex */
public class SimpleNavigationBar extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f69638e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f69639f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f69640g;

    /* renamed from: h  reason: collision with root package name */
    public c f69641h;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SimpleNavigationBar.this.f69641h != null) {
                SimpleNavigationBar.this.f69641h.D();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SimpleNavigationBar.this.f69641h != null) {
                SimpleNavigationBar.this.f69641h.onRightClick();
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
        LayoutInflater.from(context).inflate(d.yy_layout_navigation, (ViewGroup) this, true);
        this.f69640g = (ImageView) findViewById(i.a.a.e.c.iv_back);
        this.f69638e = (TextView) findViewById(i.a.a.e.c.tv_title);
        this.f69639f = (TextView) findViewById(i.a.a.e.c.tv_right);
        this.f69640g.setOnClickListener(new a());
        this.f69639f.setOnClickListener(new b());
    }

    public void setCallback(c cVar) {
        this.f69641h = cVar;
    }

    public void setRight(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f69639f.setText(str);
        this.f69639f.setVisibility(0);
    }

    public void setTitle(String str) {
        if (str != null && !str.isEmpty()) {
            this.f69638e.setText(str);
        }
        this.f69638e.setVisibility(0);
    }

    public SimpleNavigationBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimpleNavigationBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b(context, attributeSet);
    }
}
