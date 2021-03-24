package d.b.i0.g3;

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
import d.b.b.e.m.g;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class e extends Dialog implements d.b.i0.g3.a {

    /* renamed from: e  reason: collision with root package name */
    public Context f55017e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f55018f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55019g;

    /* renamed from: h  reason: collision with root package name */
    public View f55020h;
    public LinearLayout i;
    public View.OnClickListener j;
    public LinearLayout k;
    public View l;

    public e(Context context, int i) {
        super(context, i);
        this.f55017e = context;
        f();
    }

    @Override // d.b.i0.g3.a
    public void a(int i) {
        View findViewWithTag = this.i.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof LinearLayout)) {
            return;
        }
        new a(findViewWithTag).d(true);
    }

    @Override // d.b.i0.g3.a
    public void b(int i) {
        View findViewWithTag = this.i.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof LinearLayout)) {
            return;
        }
        new a(findViewWithTag).d(false);
    }

    @Override // d.b.i0.g3.a
    public void c(InterestFrsData.Tag tag) {
        this.f55018f.setText(tag.getBname());
        this.f55019g.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            View a2 = new a(card_list.get(i), this.j).a();
            this.i.addView(a2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a2.getLayoutParams();
            int dimensionPixelSize = this.f55017e.getResources().getDimensionPixelSize(R.dimen.ds40);
            layoutParams.setMargins(0, i == 0 ? this.f55017e.getResources().getDimensionPixelSize(R.dimen.ds52) : dimensionPixelSize, 0, dimensionPixelSize);
            a2.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.i.addView(LayoutInflater.from(this.f55017e).inflate(R.layout.new_user_line_item, (ViewGroup) null));
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

    @Override // d.b.i0.g3.a
    public void d(View.OnClickListener onClickListener) {
        this.j = onClickListener;
        this.k.setOnClickListener(onClickListener);
    }

    public final void f() {
        View inflate = View.inflate(this.f55017e, R.layout.new_user_box, null);
        this.l = inflate;
        setContentView(inflate);
        setCanceledOnTouchOutside(true);
        this.k = (LinearLayout) this.l.findViewById(R.id.box_close_layout);
        this.f55018f = (TextView) this.l.findViewById(R.id.prompt_title);
        this.f55019g = (TextView) this.l.findViewById(R.id.prompt_sub_title);
        this.f55020h = this.l.findViewById(R.id.view_layout);
        this.i = (LinearLayout) this.l.findViewById(R.id.layout_content);
        this.f55020h.setBackgroundDrawable(this.f55017e.getResources().getDrawable(R.drawable.bg_startpage2_card_blue_up));
    }

    @Override // d.b.i0.g3.a
    public View getRootView() {
        return this.l;
    }

    @Override // android.app.Dialog, d.b.i0.g3.a
    public void hide() {
        Context context = this.f55017e;
        if (context instanceof Activity) {
            g.a(this, (Activity) context);
        } else {
            super.dismiss();
        }
    }

    @Override // android.app.Dialog, d.b.i0.g3.a
    public void show() {
        Context context = this.f55017e;
        if (!(context instanceof Activity) || g.e((Activity) context)) {
            super.show();
        }
    }

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public View f55021a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f55022b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f55023c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f55024d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f55025e;

        public a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            View inflate = LayoutInflater.from(e.this.f55017e).inflate(R.layout.new_user_text_item, (ViewGroup) null);
            this.f55021a = inflate;
            inflate.setTag(Integer.valueOf(card.getFid()));
            b(card, onClickListener);
        }

        public View a() {
            return this.f55021a;
        }

        public final void b(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            Drawable drawable;
            c();
            this.f55025e.setOnClickListener(onClickListener);
            this.f55025e.setTag(card);
            this.f55022b.setText(card.getFname());
            if (card.getOrder() == 1) {
                drawable = e.this.f55017e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_rise);
            } else {
                drawable = card.getOrder() == 2 ? e.this.f55017e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_decline) : null;
            }
            this.f55022b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            this.f55023c.setText(card.getCdesc());
            d(card.getIs_like() != 0);
        }

        public void c() {
            this.f55022b = (TextView) this.f55021a.findViewById(R.id.tv_fname);
            this.f55023c = (TextView) this.f55021a.findViewById(R.id.tv_cdesc);
            this.f55024d = (ImageView) this.f55021a.findViewById(R.id.iv_like);
            this.f55025e = (LinearLayout) this.f55021a.findViewById(R.id.ll_like);
        }

        public void d(boolean z) {
            if (!z) {
                this.f55024d.setBackgroundDrawable(e.this.f55017e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_n));
            } else {
                this.f55024d.setBackgroundDrawable(e.this.f55017e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_s));
            }
        }

        public a(View view) {
            this.f55021a = view;
            c();
        }
    }
}
