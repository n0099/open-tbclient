package tv.athena.revenue.payui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class SimpleNavigationBar extends FrameLayout {
    public TextView a;
    public TextView b;
    public ImageView c;
    public ImageView d;
    public d e;

    /* loaded from: classes9.dex */
    public interface d {
        void a();

        void onBackPress();

        void onRightClick();
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (SimpleNavigationBar.this.e != null) {
                SimpleNavigationBar.this.e.onBackPress();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (SimpleNavigationBar.this.e != null) {
                SimpleNavigationBar.this.e.onRightClick();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (SimpleNavigationBar.this.e != null) {
                SimpleNavigationBar.this.e.a();
            }
        }
    }

    public SimpleNavigationBar(Context context) {
        this(context, null);
    }

    public void setCallback(d dVar) {
        this.e = dVar;
    }

    public void setRight(String str) {
        if (str != null && !str.isEmpty()) {
            this.b.setText(str);
            this.b.setVisibility(0);
        }
    }

    public void setRightIcon(String str) {
        if ("right_icon_set".equals(str)) {
            this.d.setImageResource(R.drawable.pay_ui_right_icon_set);
            this.d.setVisibility(0);
            return;
        }
        this.d.setVisibility(8);
    }

    public void setTitle(String str) {
        if (str != null && !str.isEmpty()) {
            this.a.setText(str);
        }
        this.a.setVisibility(0);
    }

    public SimpleNavigationBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimpleNavigationBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet);
    }

    public final void b(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R.layout.pay_ui_layout_navigation, (ViewGroup) this, true);
        this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f09115e);
        this.a = (TextView) findViewById(R.id.tv_title);
        this.b = (TextView) findViewById(R.id.tv_right);
        this.d = (ImageView) findViewById(R.id.iv_right);
        this.c.setOnClickListener(new a());
        this.b.setOnClickListener(new b());
        this.d.setOnClickListener(new c());
    }
}
