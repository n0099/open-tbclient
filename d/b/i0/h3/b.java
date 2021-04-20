package d.b.i0.h3;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import d.b.c.e.m.g;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b extends Dialog implements d.b.i0.h3.a {

    /* renamed from: e  reason: collision with root package name */
    public Context f56530e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f56531f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56532g;

    /* renamed from: h  reason: collision with root package name */
    public View f56533h;
    public LinearLayout i;
    public View.OnClickListener j;
    public View k;
    public LinearLayout l;

    public b(Context context, int i) {
        super(context, i);
        this.f56530e = context;
        f();
    }

    @Override // d.b.i0.h3.a
    public void a(int i) {
        View findViewWithTag = this.i.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof LinearLayout)) {
            return;
        }
        new a(findViewWithTag).d(true);
    }

    @Override // d.b.i0.h3.a
    public void b(int i) {
        View findViewWithTag = this.i.findViewWithTag(Integer.valueOf(i));
        if (findViewWithTag == null || !(findViewWithTag instanceof LinearLayout)) {
            return;
        }
        new a(findViewWithTag).d(false);
    }

    @Override // d.b.i0.h3.a
    public void c(InterestFrsData.Tag tag) {
        this.f56531f.setText(tag.getBname());
        this.f56532g.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i = 0;
        while (i < card_list.size()) {
            InterestFrsData.Card card = card_list.get(i);
            View a2 = new a(card, this.j).a();
            this.i.addView(a2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a2.getLayoutParams();
            int dimensionPixelSize = this.f56530e.getResources().getDimensionPixelSize(R.dimen.ds20);
            layoutParams.setMargins(0, i == 0 ? this.f56530e.getResources().getDimensionPixelSize(R.dimen.ds44) : dimensionPixelSize, 0, dimensionPixelSize);
            a2.setLayoutParams(layoutParams);
            if (i != card_list.size() - 1) {
                this.i.addView(LayoutInflater.from(this.f56530e).inflate(R.layout.new_user_line_item, (ViewGroup) null));
            }
            ((TbImageView) this.i.findViewWithTag(card.getAvatar())).W(card.getAvatar(), 10, false);
            i++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        int size = (card_list.size() * getContext().getResources().getDimensionPixelSize(R.dimen.ds140)) + getContext().getResources().getDimensionPixelSize(R.dimen.ds188) + getContext().getResources().getDimensionPixelSize(R.dimen.ds100);
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(R.dimen.ds120);
        if (size > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    @Override // d.b.i0.h3.a
    public void d(View.OnClickListener onClickListener) {
        this.j = onClickListener;
        this.l.setOnClickListener(onClickListener);
    }

    public final void f() {
        View inflate = View.inflate(this.f56530e, R.layout.new_user_box, null);
        this.k = inflate;
        setContentView(inflate);
        setCanceledOnTouchOutside(true);
        this.l = (LinearLayout) this.k.findViewById(R.id.box_close_layout);
        this.f56531f = (TextView) this.k.findViewById(R.id.prompt_title);
        this.f56532g = (TextView) this.k.findViewById(R.id.prompt_sub_title);
        this.f56533h = this.k.findViewById(R.id.view_layout);
        this.i = (LinearLayout) findViewById(R.id.layout_content);
        this.f56533h.setBackgroundDrawable(this.f56530e.getResources().getDrawable(R.drawable.bg_startpage2_card_purple_up));
    }

    @Override // d.b.i0.h3.a
    public View getRootView() {
        return this.k;
    }

    @Override // android.app.Dialog, d.b.i0.h3.a
    public void hide() {
        Context context = this.f56530e;
        if (context instanceof Activity) {
            g.a(this, (Activity) context);
        } else {
            super.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public View f56534a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f56535b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f56536c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f56537d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f56538e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f56539f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f56540g;

        public a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            View inflate = LayoutInflater.from(b.this.f56530e).inflate(R.layout.new_user_rich_item, (ViewGroup) null);
            this.f56534a = inflate;
            inflate.setTag(Integer.valueOf(card.getFid()));
            b(card, onClickListener);
        }

        public View a() {
            return this.f56534a;
        }

        public final void b(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            c();
            this.f56540g.setOnClickListener(onClickListener);
            this.f56540g.setTag(card);
            this.f56535b.setText(card.getFname());
            this.f56536c.setText(card.getCdesc());
            this.f56537d.setText(card.getSlogan());
            this.f56539f.setTag(card.getAvatar());
            d(card.getIs_like() != 0);
        }

        public void c() {
            this.f56535b = (TextView) this.f56534a.findViewById(R.id.tv_fname);
            this.f56536c = (TextView) this.f56534a.findViewById(R.id.tv_cdesc);
            this.f56538e = (ImageView) this.f56534a.findViewById(R.id.iv_like);
            this.f56537d = (TextView) this.f56534a.findViewById(R.id.tv_slogan);
            this.f56539f = (TbImageView) this.f56534a.findViewById(R.id.img);
            this.f56540g = (LinearLayout) this.f56534a.findViewById(R.id.ll_like);
        }

        public void d(boolean z) {
            if (!z) {
                this.f56538e.setBackgroundDrawable(b.this.f56530e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_n));
            } else {
                this.f56538e.setBackgroundDrawable(b.this.f56530e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_s));
            }
        }

        public a(View view) {
            this.f56534a = view;
            c();
        }
    }
}
