package d.b.i0.p0.v1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.core.data.GameShareData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.BlurDrawable;
import java.text.DecimalFormat;
/* loaded from: classes4.dex */
public class a {
    public TextView A;
    public TbImageView B;
    public LinearLayout C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TextView G;
    public TextView H;
    public h I;
    public BlurDrawable J;

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f58630a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f58631b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f58632c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f58633d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f58634e;

    /* renamed from: f  reason: collision with root package name */
    public ColumnLayout f58635f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f58636g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f58637h;
    public TextView i;
    public TextView j;
    public TextView k;
    public RadioButton l;
    public RadioButton m;
    public RadioButton n;
    public RadioButton o;
    public RadioButton p;
    public RadioButton[] q;
    public TextView r;
    public TbImageView s;
    public TextView t;
    public RadioButton u;
    public RadioButton v;
    public RadioButton w;
    public RadioButton x;
    public RadioButton y;
    public RadioButton[] z;

    /* renamed from: d.b.i0.p0.v1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1443a implements TbImageView.f {
        public C1443a() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z) {
                a.this.f58636g.setVisibility(0);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bitmap g2 = a.this.g();
            if (g2 == null || a.this.I == null) {
                return;
            }
            a.this.I.onWeixinShare(g2);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bitmap g2 = a.this.g();
            if (g2 == null || a.this.I == null) {
                return;
            }
            a.this.I.onWxFriendsShare(g2);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bitmap g2 = a.this.g();
            if (g2 == null || a.this.I == null) {
                return;
            }
            a.this.I.onQQShare(g2);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bitmap g2 = a.this.g();
            if (g2 == null || a.this.I == null) {
                return;
            }
            a.this.I.onSinaShare(g2);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.I != null) {
                a.this.I.onCancel();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends d.b.b.e.l.c<d.b.b.j.d.a> {
        public g() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            super.onLoaded((g) aVar, str, i);
            if (aVar == null || aVar.p() == null) {
                UtilHelper.showToast(a.this.f58630a.getContext(), R.string.share_failed);
                if (a.this.I != null) {
                    a.this.I.onCancel();
                }
            }
            a.this.J = new BlurDrawable(a.this.f58630a.getContext());
            a.this.J.init(2, 4, aVar.p());
            a.this.J.drawBlur();
            a.this.f58632c.setImageBitmap(a.this.J.getBlurredBitmap());
        }
    }

    /* loaded from: classes4.dex */
    public interface h {
        void onCancel();

        void onQQShare(Bitmap bitmap);

        void onSinaShare(Bitmap bitmap);

        void onWeixinShare(Bitmap bitmap);

        void onWxFriendsShare(Bitmap bitmap);
    }

    public a(Context context, h hVar) {
        this.I = hVar;
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.f58630a = frameLayout;
        this.f58631b = (FrameLayout) frameLayout.findViewById(R.id.game_share_content_layout);
        this.f58632c = (ImageView) this.f58630a.findViewById(R.id.game_share_content_bg_view);
        this.f58633d = (LinearLayout) this.f58630a.findViewById(R.id.game_share_card_layout);
        this.f58634e = (FrameLayout) this.f58630a.findViewById(R.id.game_share_header_root);
        this.f58635f = (ColumnLayout) this.f58630a.findViewById(R.id.game_share_header_layout);
        TbImageView tbImageView = (TbImageView) this.f58630a.findViewById(R.id.game_share_header_bg_view);
        this.f58636g = tbImageView;
        tbImageView.setVisibility(4);
        this.f58636g.setDefaultBg(new ColorDrawable(this.f58630a.getResources().getColor(R.color.transparent)));
        this.f58636g.setDrawerType(1);
        this.f58636g.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.f58636g.setEvent(new C1443a());
        TbImageView tbImageView2 = (TbImageView) this.f58630a.findViewById(R.id.game_share_game_icon);
        this.f58637h = tbImageView2;
        tbImageView2.setDrawerType(1);
        this.f58637h.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.i = (TextView) this.f58630a.findViewById(R.id.game_share_game_name);
        this.j = (TextView) this.f58630a.findViewById(R.id.game_share_game_description);
        this.k = (TextView) this.f58630a.findViewById(R.id.game_share_game_score);
        this.l = (RadioButton) this.f58630a.findViewById(R.id.game_share_score_grade_1);
        this.m = (RadioButton) this.f58630a.findViewById(R.id.game_share_score_grade_2);
        this.n = (RadioButton) this.f58630a.findViewById(R.id.game_share_score_grade_3);
        this.o = (RadioButton) this.f58630a.findViewById(R.id.game_share_score_grade_4);
        RadioButton radioButton = (RadioButton) this.f58630a.findViewById(R.id.game_share_score_grade_5);
        this.p = radioButton;
        this.q = new RadioButton[]{this.l, this.m, this.n, this.o, radioButton};
        this.r = (TextView) this.f58630a.findViewById(R.id.game_share_comment);
        TbImageView tbImageView3 = (TbImageView) this.f58630a.findViewById(R.id.game_share_user_protrait);
        this.s = tbImageView3;
        tbImageView3.setDrawerType(1);
        this.s.setIsRound(true);
        this.t = (TextView) this.f58630a.findViewById(R.id.game_share_user_name);
        this.u = (RadioButton) this.f58630a.findViewById(R.id.game_share_user_score_grade_1);
        this.v = (RadioButton) this.f58630a.findViewById(R.id.game_share_user_score_grade_2);
        this.w = (RadioButton) this.f58630a.findViewById(R.id.game_share_user_score_grade_3);
        this.x = (RadioButton) this.f58630a.findViewById(R.id.game_share_user_score_grade_4);
        RadioButton radioButton2 = (RadioButton) this.f58630a.findViewById(R.id.game_share_user_score_grade_5);
        this.y = radioButton2;
        this.z = new RadioButton[]{this.u, this.v, this.w, this.x, radioButton2};
        this.A = (TextView) this.f58630a.findViewById(R.id.game_share_qr_txt);
        this.B = (TbImageView) this.f58630a.findViewById(R.id.game_share_qr_img);
        this.C = (LinearLayout) this.f58630a.findViewById(R.id.game_share_entry_layout);
        TextView textView = (TextView) this.f58630a.findViewById(R.id.game_share_entry_weixin);
        this.D = textView;
        textView.setOnClickListener(new b());
        TextView textView2 = (TextView) this.f58630a.findViewById(R.id.game_share_entry_wxfriends);
        this.E = textView2;
        textView2.setOnClickListener(new c());
        TextView textView3 = (TextView) this.f58630a.findViewById(R.id.game_share_entry_qq);
        this.F = textView3;
        textView3.setOnClickListener(new d());
        TextView textView4 = (TextView) this.f58630a.findViewById(R.id.game_share_entry_sina);
        this.G = textView4;
        textView4.setOnClickListener(new e());
        TextView textView5 = (TextView) this.f58630a.findViewById(R.id.game_share_cancel);
        this.H = textView5;
        textView5.setOnClickListener(new f());
    }

    public Bitmap g() {
        this.f58631b.buildDrawingCache();
        return this.f58631b.getDrawingCache();
    }

    public int h() {
        return this.f58633d.getBottom();
    }

    public View i() {
        return this.f58630a;
    }

    public void j() {
        BlurDrawable blurDrawable = this.J;
        if (blurDrawable != null) {
            blurDrawable.onDestroy();
            this.J = null;
        }
    }

    public final void k(int i, RadioButton[] radioButtonArr) {
        if (radioButtonArr == null || radioButtonArr.length != 5) {
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i > 10) {
            i = 10;
        }
        int i2 = i / 2;
        for (int i3 = 0; i3 < radioButtonArr.length; i3++) {
            if (radioButtonArr[i3] != null) {
                if (i3 < i2) {
                    radioButtonArr[i3].setChecked(true);
                } else {
                    radioButtonArr[i3].setChecked(false);
                }
            }
        }
    }

    public final void l(GameShareData gameShareData) {
        if (gameShareData == null) {
            return;
        }
        this.f58637h.W(gameShareData.gameIconUrl, 10, false);
        this.i.setText(gameShareData.gameName);
        this.j.setText(gameShareData.gameDescription);
        this.k.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
        k((int) gameShareData.gameScore, this.q);
    }

    public void m(GameShareData gameShareData) {
        l(gameShareData);
        n(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.gameComment);
        sb.append(" ”");
        this.r.setText(sb);
        if (this.J == null) {
            d.b.b.e.l.d.h().m(gameShareData.gameIconUrl, 10, new g(), null);
        }
        this.f58636g.W(gameShareData.headBgUrl, 10, false);
        this.B.W(gameShareData.shareQRCodeUrl, 10, false);
    }

    public final void n(GameShareData gameShareData) {
        if (gameShareData == null) {
            return;
        }
        this.s.W(gameShareData.userPortrait, 12, false);
        this.t.setText(gameShareData.userName);
        k((int) gameShareData.userScore, this.z);
    }
}
