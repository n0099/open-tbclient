package d.b.i0.q0.v1;

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
    public FrameLayout f60298a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f60299b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f60300c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f60301d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f60302e;

    /* renamed from: f  reason: collision with root package name */
    public ColumnLayout f60303f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f60304g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f60305h;
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

    /* renamed from: d.b.i0.q0.v1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1506a implements TbImageView.f {
        public C1506a() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z) {
                a.this.f60304g.setVisibility(0);
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
    public class g extends d.b.c.e.l.c<d.b.c.j.d.a> {
        public g() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.l.c
        public void onLoaded(d.b.c.j.d.a aVar, String str, int i) {
            super.onLoaded((g) aVar, str, i);
            if (aVar == null || aVar.p() == null) {
                UtilHelper.showToast(a.this.f60298a.getContext(), R.string.share_failed);
                if (a.this.I != null) {
                    a.this.I.onCancel();
                }
            }
            a.this.J = new BlurDrawable(a.this.f60298a.getContext());
            a.this.J.init(2, 4, aVar.p());
            a.this.J.drawBlur();
            a.this.f60300c.setImageBitmap(a.this.J.getBlurredBitmap());
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
        this.f60298a = frameLayout;
        this.f60299b = (FrameLayout) frameLayout.findViewById(R.id.game_share_content_layout);
        this.f60300c = (ImageView) this.f60298a.findViewById(R.id.game_share_content_bg_view);
        this.f60301d = (LinearLayout) this.f60298a.findViewById(R.id.game_share_card_layout);
        this.f60302e = (FrameLayout) this.f60298a.findViewById(R.id.game_share_header_root);
        this.f60303f = (ColumnLayout) this.f60298a.findViewById(R.id.game_share_header_layout);
        TbImageView tbImageView = (TbImageView) this.f60298a.findViewById(R.id.game_share_header_bg_view);
        this.f60304g = tbImageView;
        tbImageView.setVisibility(4);
        this.f60304g.setDefaultBg(new ColorDrawable(this.f60298a.getResources().getColor(R.color.transparent)));
        this.f60304g.setDrawerType(1);
        this.f60304g.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.f60304g.setEvent(new C1506a());
        TbImageView tbImageView2 = (TbImageView) this.f60298a.findViewById(R.id.game_share_game_icon);
        this.f60305h = tbImageView2;
        tbImageView2.setDrawerType(1);
        this.f60305h.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.i = (TextView) this.f60298a.findViewById(R.id.game_share_game_name);
        this.j = (TextView) this.f60298a.findViewById(R.id.game_share_game_description);
        this.k = (TextView) this.f60298a.findViewById(R.id.game_share_game_score);
        this.l = (RadioButton) this.f60298a.findViewById(R.id.game_share_score_grade_1);
        this.m = (RadioButton) this.f60298a.findViewById(R.id.game_share_score_grade_2);
        this.n = (RadioButton) this.f60298a.findViewById(R.id.game_share_score_grade_3);
        this.o = (RadioButton) this.f60298a.findViewById(R.id.game_share_score_grade_4);
        RadioButton radioButton = (RadioButton) this.f60298a.findViewById(R.id.game_share_score_grade_5);
        this.p = radioButton;
        this.q = new RadioButton[]{this.l, this.m, this.n, this.o, radioButton};
        this.r = (TextView) this.f60298a.findViewById(R.id.game_share_comment);
        TbImageView tbImageView3 = (TbImageView) this.f60298a.findViewById(R.id.game_share_user_protrait);
        this.s = tbImageView3;
        tbImageView3.setDrawerType(1);
        this.s.setIsRound(true);
        this.t = (TextView) this.f60298a.findViewById(R.id.game_share_user_name);
        this.u = (RadioButton) this.f60298a.findViewById(R.id.game_share_user_score_grade_1);
        this.v = (RadioButton) this.f60298a.findViewById(R.id.game_share_user_score_grade_2);
        this.w = (RadioButton) this.f60298a.findViewById(R.id.game_share_user_score_grade_3);
        this.x = (RadioButton) this.f60298a.findViewById(R.id.game_share_user_score_grade_4);
        RadioButton radioButton2 = (RadioButton) this.f60298a.findViewById(R.id.game_share_user_score_grade_5);
        this.y = radioButton2;
        this.z = new RadioButton[]{this.u, this.v, this.w, this.x, radioButton2};
        this.A = (TextView) this.f60298a.findViewById(R.id.game_share_qr_txt);
        this.B = (TbImageView) this.f60298a.findViewById(R.id.game_share_qr_img);
        this.C = (LinearLayout) this.f60298a.findViewById(R.id.game_share_entry_layout);
        TextView textView = (TextView) this.f60298a.findViewById(R.id.game_share_entry_weixin);
        this.D = textView;
        textView.setOnClickListener(new b());
        TextView textView2 = (TextView) this.f60298a.findViewById(R.id.game_share_entry_wxfriends);
        this.E = textView2;
        textView2.setOnClickListener(new c());
        TextView textView3 = (TextView) this.f60298a.findViewById(R.id.game_share_entry_qq);
        this.F = textView3;
        textView3.setOnClickListener(new d());
        TextView textView4 = (TextView) this.f60298a.findViewById(R.id.game_share_entry_sina);
        this.G = textView4;
        textView4.setOnClickListener(new e());
        TextView textView5 = (TextView) this.f60298a.findViewById(R.id.game_share_cancel);
        this.H = textView5;
        textView5.setOnClickListener(new f());
    }

    public Bitmap g() {
        this.f60299b.buildDrawingCache();
        return this.f60299b.getDrawingCache();
    }

    public int h() {
        return this.f60301d.getBottom();
    }

    public View i() {
        return this.f60298a;
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
        this.f60305h.W(gameShareData.gameIconUrl, 10, false);
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
            d.b.c.e.l.d.h().m(gameShareData.gameIconUrl, 10, new g(), null);
        }
        this.f60304g.W(gameShareData.headBgUrl, 10, false);
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
