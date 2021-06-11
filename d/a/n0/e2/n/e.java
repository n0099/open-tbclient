package d.a.n0.e2.n;

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
import d.a.c.e.p.l;
import d.a.m0.r.q.a2;
import d.a.n0.e2.h.p;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57376a;

    /* renamed from: b  reason: collision with root package name */
    public View f57377b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f57378c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57379d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f57380e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f57381f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f57382g;

    /* renamed from: h  reason: collision with root package name */
    public PbVideoFullUserInfoLikeButton f57383h;

    /* renamed from: i  reason: collision with root package name */
    public d f57384i;
    public View.OnClickListener j;
    public LinearLayout k;
    public View.OnClickListener l = new a();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == e.this.f57378c || view == e.this.f57379d || view == e.this.f57382g) {
                e.this.l(view);
            }
        }
    }

    public e(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.f57376a = tbPageContext;
        this.f57377b = g(tbPageContext);
        h();
        frameLayout.addView(this.f57377b);
    }

    public final void e(PostData postData) {
        this.f57382g.setVisibility(8);
        this.f57378c.setUserId(postData.t().getUserId());
        this.f57378c.setUserName(postData.t().getUserName());
        this.f57378c.setIsBigV(postData.t().isBigV());
        this.f57379d.setText(postData.t().getName_show());
        this.f57379d.setTag(postData.t().getUserId());
        this.f57378c.U(postData.t().getAvater(), 28, false);
        this.f57384i.n(postData.t());
    }

    public View f() {
        return this.f57380e;
    }

    public final View g(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    public final void h() {
        this.f57380e = (RelativeLayout) this.f57377b.findViewById(R.id.pbVideoFullUserInfoPanel);
        HeadImageView headImageView = (HeadImageView) this.f57377b.findViewById(R.id.pbVideoFullPhoto);
        this.f57378c = headImageView;
        headImageView.setOnClickListener(this.l);
        LinearLayout linearLayout = (LinearLayout) this.f57377b.findViewById(R.id.pbVideoFullNameLayout);
        this.k = linearLayout;
        SkinManager.setBackgroundResource(linearLayout, R.drawable.video_author_bg);
        TextView textView = (TextView) this.f57377b.findViewById(R.id.pbVideoFullUserName);
        this.f57379d = textView;
        textView.setOnClickListener(this.l);
        TextView textView2 = (TextView) this.f57377b.findViewById(R.id.pbVideoFullAttention);
        this.f57381f = textView2;
        textView2.setOnClickListener(this.l);
        this.f57382g = (ImageView) this.f57377b.findViewById(R.id.pbVideoFullChannelIcon);
        PbVideoFullUserInfoLikeButton pbVideoFullUserInfoLikeButton = (PbVideoFullUserInfoLikeButton) this.f57377b.findViewById(R.id.pbVideoFullLikeButton);
        this.f57383h = pbVideoFullUserInfoLikeButton;
        pbVideoFullUserInfoLikeButton.setTextSize(0, l.g(this.f57376a.getPageActivity(), R.dimen.tbds30));
        this.f57384i = new d(this.f57376a, this.f57383h);
        this.f57378c.setRadius(l.g(this.f57376a.getPageActivity(), R.dimen.ds40));
    }

    public final boolean i(a2 a2Var) {
        if (a2Var == null || a2Var.T() == null || a2Var.T().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), a2Var.T().getUserId());
    }

    public void j(int i2) {
        PbVideoFullUserInfoLikeButton pbVideoFullUserInfoLikeButton = this.f57383h;
        if (pbVideoFullUserInfoLikeButton != null) {
            pbVideoFullUserInfoLikeButton.g(i2);
        }
        SkinManager.setViewTextColor(this.f57381f, R.color.CAM_X0101);
        TextView textView = this.f57379d;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
        }
        ImageView imageView = this.f57382g;
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
        this.f57383h.setVisibility(0);
        this.f57381f.setVisibility(8);
        e(postData);
        if (i(a2Var)) {
            this.f57381f.setVisibility(8);
            this.f57383h.setVisibility(8);
        }
    }

    public void n(float f2) {
        this.f57380e.setAlpha(f2);
    }

    public void o(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }
}
