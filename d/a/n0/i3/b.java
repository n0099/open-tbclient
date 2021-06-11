package d.a.n0.i3;

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
import d.a.c.e.m.g;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b extends Dialog implements d.a.n0.i3.a {

    /* renamed from: e  reason: collision with root package name */
    public Context f59452e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59453f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f59454g;

    /* renamed from: h  reason: collision with root package name */
    public View f59455h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f59456i;
    public View.OnClickListener j;
    public View k;
    public LinearLayout l;

    public b(Context context, int i2) {
        super(context, i2);
        this.f59452e = context;
        f();
    }

    @Override // d.a.n0.i3.a
    public void a(int i2) {
        View findViewWithTag = this.f59456i.findViewWithTag(Integer.valueOf(i2));
        if (findViewWithTag == null || !(findViewWithTag instanceof LinearLayout)) {
            return;
        }
        new a(findViewWithTag).d(false);
    }

    @Override // d.a.n0.i3.a
    public void b(int i2) {
        View findViewWithTag = this.f59456i.findViewWithTag(Integer.valueOf(i2));
        if (findViewWithTag == null || !(findViewWithTag instanceof LinearLayout)) {
            return;
        }
        new a(findViewWithTag).d(true);
    }

    @Override // d.a.n0.i3.a
    public void c(InterestFrsData.Tag tag) {
        this.f59453f.setText(tag.getBname());
        this.f59454g.setText(tag.getBdesc());
        ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
        int i2 = 0;
        while (i2 < card_list.size()) {
            InterestFrsData.Card card = card_list.get(i2);
            View a2 = new a(card, this.j).a();
            this.f59456i.addView(a2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a2.getLayoutParams();
            int dimensionPixelSize = this.f59452e.getResources().getDimensionPixelSize(R.dimen.ds20);
            layoutParams.setMargins(0, i2 == 0 ? this.f59452e.getResources().getDimensionPixelSize(R.dimen.ds44) : dimensionPixelSize, 0, dimensionPixelSize);
            a2.setLayoutParams(layoutParams);
            if (i2 != card_list.size() - 1) {
                this.f59456i.addView(LayoutInflater.from(this.f59452e).inflate(R.layout.new_user_line_item, (ViewGroup) null));
            }
            ((TbImageView) this.f59456i.findViewWithTag(card.getAvatar())).U(card.getAvatar(), 10, false);
            i2++;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        int size = (card_list.size() * getContext().getResources().getDimensionPixelSize(R.dimen.ds140)) + getContext().getResources().getDimensionPixelSize(R.dimen.ds188) + getContext().getResources().getDimensionPixelSize(R.dimen.ds100);
        float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(R.dimen.ds120);
        if (size > dimensionPixelSize2) {
            attributes.height = (int) dimensionPixelSize2;
        }
    }

    @Override // d.a.n0.i3.a
    public void d(View.OnClickListener onClickListener) {
        this.j = onClickListener;
        this.l.setOnClickListener(onClickListener);
    }

    public final void f() {
        View inflate = View.inflate(this.f59452e, R.layout.new_user_box, null);
        this.k = inflate;
        setContentView(inflate);
        setCanceledOnTouchOutside(true);
        this.l = (LinearLayout) this.k.findViewById(R.id.box_close_layout);
        this.f59453f = (TextView) this.k.findViewById(R.id.prompt_title);
        this.f59454g = (TextView) this.k.findViewById(R.id.prompt_sub_title);
        this.f59455h = this.k.findViewById(R.id.view_layout);
        this.f59456i = (LinearLayout) findViewById(R.id.layout_content);
        this.f59455h.setBackgroundDrawable(this.f59452e.getResources().getDrawable(R.drawable.bg_startpage2_card_purple_up));
    }

    @Override // d.a.n0.i3.a
    public View getRootView() {
        return this.k;
    }

    @Override // android.app.Dialog, d.a.n0.i3.a
    public void hide() {
        Context context = this.f59452e;
        if (context instanceof Activity) {
            g.a(this, (Activity) context);
        } else {
            super.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public View f59457a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f59458b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f59459c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f59460d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f59461e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f59462f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f59463g;

        public a(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            View inflate = LayoutInflater.from(b.this.f59452e).inflate(R.layout.new_user_rich_item, (ViewGroup) null);
            this.f59457a = inflate;
            inflate.setTag(Integer.valueOf(card.getFid()));
            b(card, onClickListener);
        }

        public View a() {
            return this.f59457a;
        }

        public final void b(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            c();
            this.f59463g.setOnClickListener(onClickListener);
            this.f59463g.setTag(card);
            this.f59458b.setText(card.getFname());
            this.f59459c.setText(card.getCdesc());
            this.f59460d.setText(card.getSlogan());
            this.f59462f.setTag(card.getAvatar());
            d(card.getIs_like() != 0);
        }

        public void c() {
            this.f59458b = (TextView) this.f59457a.findViewById(R.id.tv_fname);
            this.f59459c = (TextView) this.f59457a.findViewById(R.id.tv_cdesc);
            this.f59461e = (ImageView) this.f59457a.findViewById(R.id.iv_like);
            this.f59460d = (TextView) this.f59457a.findViewById(R.id.tv_slogan);
            this.f59462f = (TbImageView) this.f59457a.findViewById(R.id.img);
            this.f59463g = (LinearLayout) this.f59457a.findViewById(R.id.ll_like);
        }

        public void d(boolean z) {
            if (!z) {
                this.f59461e.setBackgroundDrawable(b.this.f59452e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_n));
            } else {
                this.f59461e.setBackgroundDrawable(b.this.f59452e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_s));
            }
        }

        public a(View view) {
            this.f59457a = view;
            c();
        }
    }
}
