package d.b.i0.n2;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.core.content.ContextCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.pushdialog.PushDialogVideoView;
import com.tencent.connect.common.Constants;
import d.b.b.e.m.e;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import d.b.h0.b1.m.i;
import d.b.i0.i2.o;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes5.dex */
public class c implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public final PushDialogActivity f57142e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f57143f;

    /* renamed from: g  reason: collision with root package name */
    public View f57144g;

    /* renamed from: h  reason: collision with root package name */
    public View f57145h;
    public EditorScrollView i;
    public TbImageView j;
    public TextView k;
    public ImageView l;
    public TextView m;
    public TbRichTextView n;
    public PushDialogVideoView o;
    public ClickableHeaderImageView p;
    public TextView q;
    public TextView r;
    public CommonUserLikeButton s;
    public View t;
    public TextView u;
    public d.b.h0.b1.m.a v;
    public long w;
    public i x;
    public boolean y = false;

    /* loaded from: classes5.dex */
    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            if (c.this.y) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13199").param("obj_locate", 1).param("tid", c.this.f57142e.getTid()));
            c.this.y = true;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f57142e == null || c.this.f57142e.getScreenLockUtils() == null) {
                return;
            }
            c.this.f57142e.getScreenLockUtils().d();
        }
    }

    public c(PushDialogActivity pushDialogActivity, int i) {
        this.f57142e = pushDialogActivity;
        pushDialogActivity.setContentView(i);
        this.f57145h = d(R.id.root_view);
        this.f57144g = d(R.id.dialog_wrapper_view);
        EditorScrollView editorScrollView = (EditorScrollView) d(R.id.push_dialog_content_layout);
        this.i = editorScrollView;
        editorScrollView.setOverScrollMode(2);
        this.i.setListener(new a());
        if (this.f57144g.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f57144g.getLayoutParams();
            int i2 = l.i(this.f57142e);
            layoutParams.height = i2 / 2;
            layoutParams.topMargin = (int) (i2 * 0.22f);
            this.f57144g.postInvalidate();
        }
        if (l.z()) {
            Drawable a2 = d.b.i0.o3.b.a();
            this.f57143f = a2;
            if (a2 != null && this.f57142e.getWindow() != null) {
                this.f57142e.getWindow().setBackgroundDrawable(this.f57143f);
            }
        }
        View d2 = d(R.id.push_dialog_bottom_layout);
        this.t = d2;
        d2.setOnClickListener(this);
        this.u = (TextView) d(R.id.comment_num);
        TbImageView tbImageView = (TbImageView) d(R.id.push_dialog_title_img);
        this.j = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.j.setAutoChangeStyle(false);
        this.k = (TextView) d(R.id.push_dialog_title_text);
        this.m = (TextView) d(R.id.push_dialog_content_title);
        ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) d(R.id.push_dialog_user_head);
        this.p = clickableHeaderImageView;
        clickableHeaderImageView.setBorderSurroundContent(true);
        this.p.setIsRound(true);
        this.p.setEnabled(false);
        this.p.setAutoChangeStyle(false);
        this.p.setBorderWidth(l.g(this.f57142e, R.dimen.tbds1));
        this.p.setBorderColor(ContextCompat.getColor(this.f57142e, R.color.black_alpha15));
        this.v = new d.b.h0.b1.m.a();
        TbRichTextView tbRichTextView = (TbRichTextView) d(R.id.push_dialog_content);
        this.n = tbRichTextView;
        tbRichTextView.setTextColor(ContextCompat.getColor(this.f57142e, R.color.CAM_X0107));
        this.v.s(l.g(this.f57142e, R.dimen.tbds38));
        this.v.v(l.g(this.f57142e, R.dimen.tbds42));
        this.v.j(l.g(this.f57142e, R.dimen.tbds23));
        this.v.o(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.v.i(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.n.setLayoutStrategy(this.v);
        PushDialogVideoView pushDialogVideoView = (PushDialogVideoView) d(R.id.push_dialog_video);
        this.o = pushDialogVideoView;
        pushDialogVideoView.setPageContext(this.f57142e.getPageContext());
        this.q = (TextView) d(R.id.push_dialog_user_name);
        this.r = (TextView) d(R.id.push_dialog_user_god_info);
        CommonUserLikeButton commonUserLikeButton = (CommonUserLikeButton) d(R.id.push_dialog_user_like_btn);
        this.s = commonUserLikeButton;
        commonUserLikeButton.setAfterOnClickListener(this);
        ImageView imageView = (ImageView) d(R.id.dialog_close_btn);
        this.l = imageView;
        imageView.setOnClickListener(this);
    }

    public final View d(@IdRes int i) {
        return this.f57142e.findViewById(i);
    }

    public void e() {
        i iVar;
        PushDialogVideoView pushDialogVideoView = this.o;
        if (pushDialogVideoView != null) {
            pushDialogVideoView.setNetworkChange();
            if (!j.x() || !this.o.z() || (iVar = this.x) == null || iVar.c() <= 0 || this.x.b() <= 0) {
                return;
            }
            DecimalFormat decimalFormat = new DecimalFormat("0.0");
            double c2 = ((this.x.c() * (1.0f - ((this.o.getCurrentPosition() * 1.0f) / (this.x.b() * 1000)))) * 1.0f) / 1048576.0f;
            if (c2 >= 0.1d) {
                l.L(this.f57142e.getPageContext().getPageActivity(), String.format(this.f57142e.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format(c2)));
            }
        }
    }

    public void f() {
        PushDialogVideoView pushDialogVideoView = this.o;
        if (pushDialogVideoView != null) {
            pushDialogVideoView.B();
        }
    }

    public void h() {
        PushDialogVideoView pushDialogVideoView = this.o;
        if (pushDialogVideoView != null) {
            pushDialogVideoView.E();
        }
    }

    public void i() {
        PushDialogVideoView pushDialogVideoView = this.o;
        if (pushDialogVideoView != null) {
            pushDialogVideoView.F();
        }
    }

    public void j(d.b.i0.n2.d.a aVar) {
        int g2;
        int g3;
        if (aVar == null) {
            return;
        }
        this.j.W(aVar.a(), 17, false);
        this.k.setText(aVar.b());
        if (aVar.d() != null) {
            this.p.setData(aVar.d());
            this.q.setText(aVar.d().getName_show());
            if (aVar.d().getGodUserData() != null && (!StringUtils.isNull(aVar.d().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.d().getGodUserData().getIntro()))) {
                this.r.setText(aVar.d().getGodUserData().getForumName() + "吧 " + aVar.d().getGodIntro());
                this.r.setVisibility(0);
            } else {
                this.r.setVisibility(8);
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.d().getUserId())) {
                this.s.setVisibility(8);
            } else {
                new d.b.h0.r.f0.q.c(this.f57142e.getPageContext(), this.s).n(aVar.d());
                this.s.g(0);
                this.s.setVisibility(0);
            }
            d.b.i0.n2.d.b c2 = aVar.c();
            if (c2 == null) {
                this.f57142e.getScreenLockUtils().d();
                this.f57142e.finish();
                return;
            }
            boolean z = c2.a() == null || ListUtils.isEmpty(c2.a().u());
            if (StringUtils.isNull(c2.d()) && z) {
                this.f57142e.getScreenLockUtils().d();
                this.f57142e.finish();
                return;
            }
            if (c2.a() != null) {
                Iterator<TbRichTextData> it = c2.a().u().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        this.x = next.D();
                    }
                    if (this.x != null) {
                        break;
                    }
                }
            }
            this.w = c2.c();
            if (this.x == null) {
                this.o.setVisibility(8);
                this.n.setVisibility(0);
                boolean z2 = j.v() || j.H();
                this.v.w(z2);
                if (z2) {
                    g2 = (l.k(TbadkCoreApplication.getInst()) - (l.g(this.f57142e, R.dimen.tbds22) * 2)) - (l.g(this.f57142e, R.dimen.tbds44) * 2);
                    g3 = (int) (g2 * 1.618f);
                } else {
                    g2 = l.g(this.f57142e, R.dimen.tbds360);
                    g3 = l.g(this.f57142e, R.dimen.tbds202);
                }
                this.v.k(z2);
                this.v.q(g2);
                this.v.p(g3);
                this.n.setText(c2.a());
            } else {
                this.n.setVisibility(8);
                this.o.setVisibility(0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.o.getLayoutParams();
                int k = l.k(this.f57142e) - l.g(this.f57142e, R.dimen.tbds132);
                layoutParams.width = k;
                layoutParams.height = (int) (k * 0.5625f);
                this.o.setLayoutParams(layoutParams);
                this.o.setTbRichTextVideoInfo(this.x);
                this.o.stopPlay();
                this.o.setThumbnail(this.x.e());
                this.o.setVideoUrl(this.x.f(), String.valueOf(this.w));
                this.o.I();
                o oVar = new o();
                oVar.f56163a = Constants.VIA_REPORT_TYPE_WPA_STATE;
                oVar.f56165c = String.valueOf(this.w);
                oVar.f56167e = TbadkCoreApplication.getCurrentAccount();
                this.o.setVideoViewBusiness(oVar);
            }
            if (StringUtils.isNull(c2.d())) {
                this.m.setVisibility(8);
            } else {
                this.m.setText(c2.d());
                this.m.setVisibility(0);
            }
            this.u.setText(String.format(Locale.CHINA, this.f57142e.getString(R.string.bottom_comment), Integer.valueOf(c2.b())));
            if (this.f57142e.getScreenLockUtils().c()) {
                return;
            }
            this.f57142e.getScreenLockUtils().e();
            return;
        }
        this.f57142e.getScreenLockUtils().d();
        this.f57142e.finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.l) {
            TiebaStatic.log(new StatisticItem("c13198").param("tid", this.f57142e.getTid()));
            e.a().postDelayed(new b(), 100L);
            this.f57142e.finish();
        } else if (view == this.t) {
            TiebaStatic.log(new StatisticItem("c13199").param("obj_locate", 4).param("tid", this.f57142e.getTid()));
            if (this.w == 0) {
                this.f57142e.finish();
                return;
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f57142e);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createNormalCfg(this.w + "", null, null)));
            this.f57142e.getScreenLockUtils().e();
            this.f57142e.finish();
        } else if (view == this.s) {
            TiebaStatic.log(new StatisticItem("c13199").param("obj_locate", 3).param("tid", this.f57142e.getTid()));
        }
    }
}
