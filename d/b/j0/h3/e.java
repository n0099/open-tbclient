package d.b.j0.h3;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import d.b.c.e.m.g;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class e extends Dialog implements d.b.j0.h3.a {

    /* renamed from: e  reason: collision with root package name */
    public Context f56975e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f56976f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56977g;

    /* renamed from: h  reason: collision with root package name */
    public View f56978h;
    public LinearLayout i;
    public View.OnClickListener j;
    public LinearLayout k;
    public View l;

    public e(Context context, int i) {
        super(context, i);
        this.f56975e = context;
        f();
    }

    @Override // d.b.j0.h3.a
    public void a(int i) {
        View findViewWithTag = this.i.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof LinearLayout)) {
            return;
        }
        new a(findViewWithTag).d(true);
    }

    @Override // d.b.j0.h3.a
    public void b(int i) {
        View findViewWithTag = this.i.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof LinearLayout)) {
            return;
        }
        new a(findViewWithTag).d(false);
    }

    @Override // d.b.j0.h3.a
    public void c(InterestFrsData.Tag tag) {
        this.f56976f.setText(tag.getBname());
        this.f56977g.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            View a2 = new a(card_list.get(i), this.j).a();
            this.i.addView(a2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a2.getLayoutParams();
            int dimensionPixelSize = this.f56975e.getResources().getDimensionPixelSize(R.dimen.ds40);
            layoutParams.setMargins(0, i == 0 ? this.f56975e.getResources().getDimensionPixelSize(R.dimen.ds52) : dimensionPixelSize, 0, dimensionPixelSize);
            a2.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.i.addView(LayoutInflater.from(this.f56975e).inflate(R.layout.new_user_line_item, (ViewGroup) null));
            }
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        int size = (card_list.size() * getContext().getResources().getDimensionPixelSize(R.dimen.ds112)) + getContext().getResources().getDimensionPixelSize(R.dimen.ds188) + getContext().getResources().getDimensionPixelSize(R.dimen.ds100);
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(R.dimen.ds120);
        if (size > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    @Override // d.b.j0.h3.a
    public void d(View.OnClickListener onClickListener) {
        this.j = onClickListener;
        this.k.setOnClickListener(onClickListener);
    }

    public final void f() {
        View inflate = View.inflate(this.f56975e, R.layout.new_user_box, null);
        this.l = inflate;
        setContentView(inflate);
        setCanceledOnTouchOutside(true);
        this.k = (LinearLayout) this.l.findViewById(R.id.box_close_layout);
        this.f56976f = (TextView) this.l.findViewById(R.id.prompt_title);
        this.f56977g = (TextView) this.l.findViewById(R.id.prompt_sub_title);
        this.f56978h = this.l.findViewById(R.id.view_layout);
        this.i = (LinearLayout) this.l.findViewById(R.id.layout_content);
        this.f56978h.setBackgroundDrawable(this.f56975e.getResources().getDrawable(R.drawable.bg_startpage2_card_blue_up));
    }

    @Override // d.b.j0.h3.a
    public View getRootView() {
        return this.l;
    }

    @Override // android.app.Dialog, d.b.j0.h3.a
    public void hide() {
        Context context = this.f56975e;
        if (context instanceof Activity) {
            g.a(this, (Activity) context);
        } else {
            super.dismiss();
        }
    }

    @Override // android.app.Dialog, d.b.j0.h3.a
    public void show() {
        Context context = this.f56975e;
        if (!(context instanceof Activity) || g.e((Activity) context)) {
            super.show();
        }
    }

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public View f56979a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f56980b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f56981c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f56982d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f56983e;

        public a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            View inflate = LayoutInflater.from(e.this.f56975e).inflate(R.layout.new_user_text_item, (ViewGroup) null);
            this.f56979a = inflate;
            inflate.setTag(Integer.valueOf(card.getFid()));
            b(card, onClickListener);
        }

        public View a() {
            return this.f56979a;
        }

        public final void b(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            Drawable drawable;
            c();
            this.f56983e.setOnClickListener(onClickListener);
            this.f56983e.setTag(card);
            this.f56980b.setText(card.getFname());
            if (card.getOrder() == 1) {
                drawable = e.this.f56975e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_rise);
            } else {
                drawable = card.getOrder() == 2 ? e.this.f56975e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_decline) : null;
            }
            this.f56980b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            this.f56981c.setText(card.getCdesc());
            d(card.getIs_like() != 0);
        }

        public void c() {
            this.f56980b = (TextView) this.f56979a.findViewById(R.id.tv_fname);
            this.f56981c = (TextView) this.f56979a.findViewById(R.id.tv_cdesc);
            this.f56982d = (ImageView) this.f56979a.findViewById(R.id.iv_like);
            this.f56983e = (LinearLayout) this.f56979a.findViewById(R.id.ll_like);
        }

        public void d(boolean z) {
            if (!z) {
                this.f56982d.setBackgroundDrawable(e.this.f56975e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_n));
            } else {
                this.f56982d.setBackgroundDrawable(e.this.f56975e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_s));
            }
        }

        public a(View view) {
            this.f56979a = view;
            c();
        }
    }
}
