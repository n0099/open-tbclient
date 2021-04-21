package d.b.j0.d2.n;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.video.PbVideoFullUserInfoLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.b.c.e.p.l;
import d.b.i0.r.q.a2;
import d.b.j0.d2.h.p;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f54952a;

    /* renamed from: b  reason: collision with root package name */
    public View f54953b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f54954c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54955d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f54956e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f54957f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f54958g;

    /* renamed from: h  reason: collision with root package name */
    public PbVideoFullUserInfoLikeButton f54959h;
    public d i;
    public View.OnClickListener j;
    public LinearLayout k;
    public View.OnClickListener l = new a();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == e.this.f54954c || view == e.this.f54955d || view == e.this.f54958g) {
                e.this.l(view);
            }
        }
    }

    public e(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.f54952a = tbPageContext;
        this.f54953b = g(tbPageContext);
        h();
        frameLayout.addView(this.f54953b);
    }

    public final void e(PostData postData) {
        this.f54958g.setVisibility(8);
        this.f54954c.setUserId(postData.t().getUserId());
        this.f54954c.setUserName(postData.t().getUserName());
        this.f54954c.setIsBigV(postData.t().isBigV());
        this.f54955d.setText(postData.t().getName_show());
        this.f54955d.setTag(postData.t().getUserId());
        this.f54954c.W(postData.t().getAvater(), 28, false);
        this.i.n(postData.t());
    }

    public View f() {
        return this.f54956e;
    }

    public final View g(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    public final void h() {
        this.f54956e = (RelativeLayout) this.f54953b.findViewById(R.id.pbVideoFullUserInfoPanel);
        HeadImageView headImageView = (HeadImageView) this.f54953b.findViewById(R.id.pbVideoFullPhoto);
        this.f54954c = headImageView;
        headImageView.setOnClickListener(this.l);
        LinearLayout linearLayout = (LinearLayout) this.f54953b.findViewById(R.id.pbVideoFullNameLayout);
        this.k = linearLayout;
        SkinManager.setBackgroundResource(linearLayout, R.drawable.video_author_bg);
        TextView textView = (TextView) this.f54953b.findViewById(R.id.pbVideoFullUserName);
        this.f54955d = textView;
        textView.setOnClickListener(this.l);
        TextView textView2 = (TextView) this.f54953b.findViewById(R.id.pbVideoFullAttention);
        this.f54957f = textView2;
        textView2.setOnClickListener(this.l);
        this.f54958g = (ImageView) this.f54953b.findViewById(R.id.pbVideoFullChannelIcon);
        PbVideoFullUserInfoLikeButton pbVideoFullUserInfoLikeButton = (PbVideoFullUserInfoLikeButton) this.f54953b.findViewById(R.id.pbVideoFullLikeButton);
        this.f54959h = pbVideoFullUserInfoLikeButton;
        pbVideoFullUserInfoLikeButton.setTextSize(0, l.g(this.f54952a.getPageActivity(), R.dimen.tbds30));
        this.i = new d(this.f54952a, this.f54959h);
        this.f54954c.setRadius(l.g(this.f54952a.getPageActivity(), R.dimen.ds40));
    }

    public final boolean i(a2 a2Var) {
        if (a2Var == null || a2Var.T() == null || a2Var.T().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), a2Var.T().getUserId());
    }

    public void j(int i) {
        PbVideoFullUserInfoLikeButton pbVideoFullUserInfoLikeButton = this.f54959h;
        if (pbVideoFullUserInfoLikeButton != null) {
            pbVideoFullUserInfoLikeButton.g(i);
        }
        SkinManager.setViewTextColor(this.f54957f, R.color.CAM_X0101);
        TextView textView = this.f54955d;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
        }
        ImageView imageView = this.f54958g;
        if (imageView != null) {
            SkinManager.setBackgroundResource(imageView, R.drawable.icon_weiba);
        }
    }

    public void k() {
    }

    public final void l(View view) {
        View.OnClickListener onClickListener = this.j;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void m(PostData postData, a2 a2Var, p pVar) {
        this.f54959h.setVisibility(0);
        this.f54957f.setVisibility(8);
        e(postData);
        if (i(a2Var)) {
            this.f54957f.setVisibility(8);
            this.f54959h.setVisibility(8);
        }
    }

    public void n(float f2) {
        this.f54956e.setAlpha(f2);
    }

    public void o(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }
}
