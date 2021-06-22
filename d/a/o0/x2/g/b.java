package d.a.o0.x2.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.view.ShareDialogItemView;
import d.a.n0.r.s.l;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends d {
    public static final int Q = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds187);
    public static final int R = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds239);
    public static final int S = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds34);
    public Context C;
    public LinearLayout D;
    public LinearLayout E;
    public View F;
    public View G;
    public String H;
    public boolean I;
    public boolean J;
    public l.d K;
    public l.d L;
    public l.d M;
    public l.d N;
    public l.d O;
    public View.OnClickListener P;

    /* loaded from: classes5.dex */
    public class a extends ShareDialogItemView {
        public Context n;
        public EMTextView o;
        public LinearLayout.LayoutParams p;

        public a(b bVar, Context context) {
            super(context);
            this.n = context;
        }

        @Override // com.baidu.tieba.sharesdk.view.ShareDialogItemView
        public ShareDialogItemView a() {
            super.a();
            addView(this.o, this.p);
            return this;
        }

        public void c(int i2) {
            this.f20686f = new ImageView(this.n);
            setTag(Integer.valueOf(i2));
            this.f20686f.setScaleType(ImageView.ScaleType.FIT_XY);
            WebPManager.setMaskDrawable(this.f20686f, i2, null);
            b();
        }

        public void d(int i2) {
            EMTextView eMTextView = new EMTextView(this.n);
            this.o = eMTextView;
            eMTextView.setTextSize(0, ShareDialogItemView.m);
            this.o.setText(i2);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0107);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.p = layoutParams;
            layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_T_X001);
            this.p.gravity = 1;
        }
    }

    public b(Context context, String str, boolean z, boolean z2, l.d dVar, l.d dVar2, l.d dVar3, l.d dVar4, l.d dVar5, View.OnClickListener onClickListener) {
        super(context);
        this.C = context;
        this.H = str;
        this.I = z;
        this.J = z2;
        this.K = dVar;
        this.L = dVar2;
        this.M = dVar3;
        this.N = dVar4;
        this.O = dVar5;
        this.P = onClickListener;
        this.D = (LinearLayout) this.f67172f.findViewById(R.id.first_line);
        this.E = (LinearLayout) this.f67172f.findViewById(R.id.second_line);
        b0();
    }

    @Override // d.a.o0.x2.g.d
    public boolean U() {
        int i2;
        this.D.removeAllViews();
        this.E.removeAllViews();
        int i3 = 0;
        while (true) {
            if (i3 >= Math.min(6, this.k.size())) {
                break;
            }
            this.D.addView(this.k.get(i3), new ViewGroup.LayoutParams(Q, R));
            i3++;
        }
        this.D.addView(this.F, new ViewGroup.LayoutParams(S, -1));
        for (i2 = 6; i2 < this.k.size(); i2++) {
            this.E.addView(this.k.get(i2), new ViewGroup.LayoutParams(Q, R));
        }
        this.E.addView(this.G, new ViewGroup.LayoutParams(S, -1));
        return true;
    }

    public final void b0() {
        this.k.clear();
        h(R.string.share_qq_friends, new SvgMaskType(R.drawable.icon_mask_share_qq40_svg));
        h(R.string.share_qzone, new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg));
        h(R.string.share_weixin, new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg));
        a aVar = new a(this, this.C);
        aVar.c(R.drawable.icon_share_wechatexpression);
        aVar.setItemName(R.string.share_weixin_emotion_1);
        aVar.d(R.string.share_weixin_emotion_2);
        aVar.setOnClickListener(this);
        List<View> list = this.k;
        aVar.a();
        list.add(aVar);
        h(R.string.share_weixin_timeline, new SvgMaskType(R.drawable.icon_mask_share_circle40_svg));
        h(R.string.share_sina_weibo, new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg));
        if (this.H != null) {
            g(R.string.original_img_look, R.drawable.icon_pure_share_original40);
        }
        LinearLayout t = t(R.string.save_to_local, R.drawable.icon_pure_share_download40);
        t.setOnClickListener(this);
        t.setTag(Integer.valueOf(R.drawable.icon_pure_share_download40 + R.string.save_to_local));
        this.k.add(t);
        if (this.I) {
            g(R.string.save_to_emotion, R.drawable.icon_share_homepage_expression40);
        }
        g(R.string.identify_image, R.drawable.icon_share_homepage_scan40);
        if (this.J) {
            g(R.string.image_qr_code, R.drawable.icon_share_homepage_qrcode40);
        }
        this.F = new View(this.C);
        this.G = new View(this.C);
    }

    @Override // d.a.o0.x2.g.d
    public void i(View view, int i2, View.OnClickListener onClickListener) {
        super.i(view, i2, onClickListener);
    }

    @Override // d.a.o0.x2.g.d, android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        super.onClick(view);
        int intValue = view.getTag() != null ? ((Integer) view.getTag()).intValue() : -1;
        if (intValue == R.drawable.icon_pure_share_original40) {
            l.d dVar = this.M;
            if (dVar != null) {
                dVar.onClick();
            }
        } else if (intValue == R.drawable.icon_pure_share_download40 + R.string.save_to_local) {
            l.d dVar2 = this.K;
            if (dVar2 != null) {
                dVar2.onClick();
            }
        } else if (intValue == R.drawable.icon_share_homepage_expression40) {
            l.d dVar3 = this.L;
            if (dVar3 != null) {
                dVar3.onClick();
            }
        } else if (intValue == R.drawable.icon_share_homepage_scan40) {
            l.d dVar4 = this.N;
            if (dVar4 != null) {
                dVar4.onClick();
            }
        } else if (intValue == R.drawable.icon_share_homepage_qrcode40) {
            l.d dVar5 = this.O;
            if (dVar5 != null) {
                dVar5.onClick();
            }
        } else if (intValue != R.drawable.icon_share_wechatexpression || (onClickListener = this.P) == null) {
        } else {
            onClickListener.onClick(view);
        }
    }

    @Override // d.a.o0.x2.g.d
    public View p() {
        return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.image_viewer_share_dialog_layout, (ViewGroup) null);
    }
}
