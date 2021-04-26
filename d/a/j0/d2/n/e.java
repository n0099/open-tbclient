package d.a.j0.d2.n;

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
import d.a.i0.r.q.a2;
import d.a.j0.d2.h.p;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52774a;

    /* renamed from: b  reason: collision with root package name */
    public View f52775b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f52776c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f52777d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f52778e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f52779f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f52780g;

    /* renamed from: h  reason: collision with root package name */
    public PbVideoFullUserInfoLikeButton f52781h;

    /* renamed from: i  reason: collision with root package name */
    public d f52782i;
    public View.OnClickListener j;
    public LinearLayout k;
    public View.OnClickListener l = new a();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == e.this.f52776c || view == e.this.f52777d || view == e.this.f52780g) {
                e.this.l(view);
            }
        }
    }

    public e(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.f52774a = tbPageContext;
        this.f52775b = g(tbPageContext);
        h();
        frameLayout.addView(this.f52775b);
    }

    public final void e(PostData postData) {
        this.f52780g.setVisibility(8);
        this.f52776c.setUserId(postData.t().getUserId());
        this.f52776c.setUserName(postData.t().getUserName());
        this.f52776c.setIsBigV(postData.t().isBigV());
        this.f52777d.setText(postData.t().getName_show());
        this.f52777d.setTag(postData.t().getUserId());
        this.f52776c.V(postData.t().getAvater(), 28, false);
        this.f52782i.n(postData.t());
    }

    public View f() {
        return this.f52778e;
    }

    public final View g(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    public final void h() {
        this.f52778e = (RelativeLayout) this.f52775b.findViewById(R.id.pbVideoFullUserInfoPanel);
        HeadImageView headImageView = (HeadImageView) this.f52775b.findViewById(R.id.pbVideoFullPhoto);
        this.f52776c = headImageView;
        headImageView.setOnClickListener(this.l);
        LinearLayout linearLayout = (LinearLayout) this.f52775b.findViewById(R.id.pbVideoFullNameLayout);
        this.k = linearLayout;
        SkinManager.setBackgroundResource(linearLayout, R.drawable.video_author_bg);
        TextView textView = (TextView) this.f52775b.findViewById(R.id.pbVideoFullUserName);
        this.f52777d = textView;
        textView.setOnClickListener(this.l);
        TextView textView2 = (TextView) this.f52775b.findViewById(R.id.pbVideoFullAttention);
        this.f52779f = textView2;
        textView2.setOnClickListener(this.l);
        this.f52780g = (ImageView) this.f52775b.findViewById(R.id.pbVideoFullChannelIcon);
        PbVideoFullUserInfoLikeButton pbVideoFullUserInfoLikeButton = (PbVideoFullUserInfoLikeButton) this.f52775b.findViewById(R.id.pbVideoFullLikeButton);
        this.f52781h = pbVideoFullUserInfoLikeButton;
        pbVideoFullUserInfoLikeButton.setTextSize(0, l.g(this.f52774a.getPageActivity(), R.dimen.tbds30));
        this.f52782i = new d(this.f52774a, this.f52781h);
        this.f52776c.setRadius(l.g(this.f52774a.getPageActivity(), R.dimen.ds40));
    }

    public final boolean i(a2 a2Var) {
        if (a2Var == null || a2Var.T() == null || a2Var.T().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), a2Var.T().getUserId());
    }

    public void j(int i2) {
        PbVideoFullUserInfoLikeButton pbVideoFullUserInfoLikeButton = this.f52781h;
        if (pbVideoFullUserInfoLikeButton != null) {
            pbVideoFullUserInfoLikeButton.g(i2);
        }
        SkinManager.setViewTextColor(this.f52779f, R.color.CAM_X0101);
        TextView textView = this.f52777d;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
        }
        ImageView imageView = this.f52780g;
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
        this.f52781h.setVisibility(0);
        this.f52779f.setVisibility(8);
        e(postData);
        if (i(a2Var)) {
            this.f52779f.setVisibility(8);
            this.f52781h.setVisibility(8);
        }
    }

    public void n(float f2) {
        this.f52778e.setAlpha(f2);
    }

    public void o(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }
}
