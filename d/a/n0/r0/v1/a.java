package d.a.n0.r0.v1;

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
    public FrameLayout f63403a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f63404b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f63405c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f63406d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f63407e;

    /* renamed from: f  reason: collision with root package name */
    public ColumnLayout f63408f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f63409g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f63410h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f63411i;
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

    /* renamed from: d.a.n0.r0.v1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1611a implements TbImageView.f {
        public C1611a() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z) {
                a.this.f63409g.setVisibility(0);
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
    public class g extends d.a.c.e.l.c<d.a.c.k.d.a> {
        public g() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            super.onLoaded((g) aVar, str, i2);
            if (aVar == null || aVar.p() == null) {
                UtilHelper.showToast(a.this.f63403a.getContext(), R.string.share_failed);
                if (a.this.I != null) {
                    a.this.I.onCancel();
                }
            }
            a.this.J = new BlurDrawable(a.this.f63403a.getContext());
            a.this.J.init(2, 4, aVar.p());
            a.this.J.drawBlur();
            a.this.f63405c.setImageBitmap(a.this.J.getBlurredBitmap());
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
        this.f63403a = frameLayout;
        this.f63404b = (FrameLayout) frameLayout.findViewById(R.id.game_share_content_layout);
        this.f63405c = (ImageView) this.f63403a.findViewById(R.id.game_share_content_bg_view);
        this.f63406d = (LinearLayout) this.f63403a.findViewById(R.id.game_share_card_layout);
        this.f63407e = (FrameLayout) this.f63403a.findViewById(R.id.game_share_header_root);
        this.f63408f = (ColumnLayout) this.f63403a.findViewById(R.id.game_share_header_layout);
        TbImageView tbImageView = (TbImageView) this.f63403a.findViewById(R.id.game_share_header_bg_view);
        this.f63409g = tbImageView;
        tbImageView.setVisibility(4);
        this.f63409g.setDefaultBg(new ColorDrawable(this.f63403a.getResources().getColor(R.color.transparent)));
        this.f63409g.setDrawerType(1);
        this.f63409g.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.f63409g.setEvent(new C1611a());
        TbImageView tbImageView2 = (TbImageView) this.f63403a.findViewById(R.id.game_share_game_icon);
        this.f63410h = tbImageView2;
        tbImageView2.setDrawerType(1);
        this.f63410h.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.f63411i = (TextView) this.f63403a.findViewById(R.id.game_share_game_name);
        this.j = (TextView) this.f63403a.findViewById(R.id.game_share_game_description);
        this.k = (TextView) this.f63403a.findViewById(R.id.game_share_game_score);
        this.l = (RadioButton) this.f63403a.findViewById(R.id.game_share_score_grade_1);
        this.m = (RadioButton) this.f63403a.findViewById(R.id.game_share_score_grade_2);
        this.n = (RadioButton) this.f63403a.findViewById(R.id.game_share_score_grade_3);
        this.o = (RadioButton) this.f63403a.findViewById(R.id.game_share_score_grade_4);
        RadioButton radioButton = (RadioButton) this.f63403a.findViewById(R.id.game_share_score_grade_5);
        this.p = radioButton;
        this.q = new RadioButton[]{this.l, this.m, this.n, this.o, radioButton};
        this.r = (TextView) this.f63403a.findViewById(R.id.game_share_comment);
        TbImageView tbImageView3 = (TbImageView) this.f63403a.findViewById(R.id.game_share_user_protrait);
        this.s = tbImageView3;
        tbImageView3.setDrawerType(1);
        this.s.setIsRound(true);
        this.t = (TextView) this.f63403a.findViewById(R.id.game_share_user_name);
        this.u = (RadioButton) this.f63403a.findViewById(R.id.game_share_user_score_grade_1);
        this.v = (RadioButton) this.f63403a.findViewById(R.id.game_share_user_score_grade_2);
        this.w = (RadioButton) this.f63403a.findViewById(R.id.game_share_user_score_grade_3);
        this.x = (RadioButton) this.f63403a.findViewById(R.id.game_share_user_score_grade_4);
        RadioButton radioButton2 = (RadioButton) this.f63403a.findViewById(R.id.game_share_user_score_grade_5);
        this.y = radioButton2;
        this.z = new RadioButton[]{this.u, this.v, this.w, this.x, radioButton2};
        this.A = (TextView) this.f63403a.findViewById(R.id.game_share_qr_txt);
        this.B = (TbImageView) this.f63403a.findViewById(R.id.game_share_qr_img);
        this.C = (LinearLayout) this.f63403a.findViewById(R.id.game_share_entry_layout);
        TextView textView = (TextView) this.f63403a.findViewById(R.id.game_share_entry_weixin);
        this.D = textView;
        textView.setOnClickListener(new b());
        TextView textView2 = (TextView) this.f63403a.findViewById(R.id.game_share_entry_wxfriends);
        this.E = textView2;
        textView2.setOnClickListener(new c());
        TextView textView3 = (TextView) this.f63403a.findViewById(R.id.game_share_entry_qq);
        this.F = textView3;
        textView3.setOnClickListener(new d());
        TextView textView4 = (TextView) this.f63403a.findViewById(R.id.game_share_entry_sina);
        this.G = textView4;
        textView4.setOnClickListener(new e());
        TextView textView5 = (TextView) this.f63403a.findViewById(R.id.game_share_cancel);
        this.H = textView5;
        textView5.setOnClickListener(new f());
    }

    public Bitmap g() {
        this.f63404b.buildDrawingCache();
        return this.f63404b.getDrawingCache();
    }

    public int h() {
        return this.f63406d.getBottom();
    }

    public View i() {
        return this.f63403a;
    }

    public void j() {
        BlurDrawable blurDrawable = this.J;
        if (blurDrawable != null) {
            blurDrawable.onDestroy();
            this.J = null;
        }
    }

    public final void k(int i2, RadioButton[] radioButtonArr) {
        if (radioButtonArr == null || radioButtonArr.length != 5) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > 10) {
            i2 = 10;
        }
        int i3 = i2 / 2;
        for (int i4 = 0; i4 < radioButtonArr.length; i4++) {
            if (radioButtonArr[i4] != null) {
                if (i4 < i3) {
                    radioButtonArr[i4].setChecked(true);
                } else {
                    radioButtonArr[i4].setChecked(false);
                }
            }
        }
    }

    public final void l(GameShareData gameShareData) {
        if (gameShareData == null) {
            return;
        }
        this.f63410h.U(gameShareData.gameIconUrl, 10, false);
        this.f63411i.setText(gameShareData.gameName);
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
            d.a.c.e.l.d.h().m(gameShareData.gameIconUrl, 10, new g(), null);
        }
        this.f63409g.U(gameShareData.headBgUrl, 10, false);
        this.B.U(gameShareData.shareQRCodeUrl, 10, false);
    }

    public final void n(GameShareData gameShareData) {
        if (gameShareData == null) {
            return;
        }
        this.s.U(gameShareData.userPortrait, 12, false);
        this.t.setText(gameShareData.userName);
        k((int) gameShareData.userScore, this.z);
    }
}
