package d.b.i0.c2.n;

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
import d.b.b.e.p.l;
import d.b.h0.r.q.a2;
import d.b.i0.c2.h.p;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f53121a;

    /* renamed from: b  reason: collision with root package name */
    public View f53122b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f53123c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f53124d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f53125e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f53126f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f53127g;

    /* renamed from: h  reason: collision with root package name */
    public PbVideoFullUserInfoLikeButton f53128h;
    public d i;
    public View.OnClickListener j;
    public LinearLayout k;
    public View.OnClickListener l = new a();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == e.this.f53123c || view == e.this.f53124d || view == e.this.f53127g) {
                e.this.l(view);
            }
        }
    }

    public e(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.f53121a = tbPageContext;
        this.f53122b = g(tbPageContext);
        h();
        frameLayout.addView(this.f53122b);
    }

    public final void e(PostData postData) {
        this.f53127g.setVisibility(8);
        this.f53123c.setUserId(postData.s().getUserId());
        this.f53123c.setUserName(postData.s().getUserName());
        this.f53123c.setIsBigV(postData.s().isBigV());
        this.f53124d.setText(postData.s().getName_show());
        this.f53124d.setTag(postData.s().getUserId());
        this.f53123c.W(postData.s().getAvater(), 28, false);
        this.i.n(postData.s());
    }

    public View f() {
        return this.f53125e;
    }

    public final View g(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    public final void h() {
        this.f53125e = (RelativeLayout) this.f53122b.findViewById(R.id.pbVideoFullUserInfoPanel);
        HeadImageView headImageView = (HeadImageView) this.f53122b.findViewById(R.id.pbVideoFullPhoto);
        this.f53123c = headImageView;
        headImageView.setOnClickListener(this.l);
        LinearLayout linearLayout = (LinearLayout) this.f53122b.findViewById(R.id.pbVideoFullNameLayout);
        this.k = linearLayout;
        SkinManager.setBackgroundResource(linearLayout, R.drawable.video_author_bg);
        TextView textView = (TextView) this.f53122b.findViewById(R.id.pbVideoFullUserName);
        this.f53124d = textView;
        textView.setOnClickListener(this.l);
        TextView textView2 = (TextView) this.f53122b.findViewById(R.id.pbVideoFullAttention);
        this.f53126f = textView2;
        textView2.setOnClickListener(this.l);
        this.f53127g = (ImageView) this.f53122b.findViewById(R.id.pbVideoFullChannelIcon);
        PbVideoFullUserInfoLikeButton pbVideoFullUserInfoLikeButton = (PbVideoFullUserInfoLikeButton) this.f53122b.findViewById(R.id.pbVideoFullLikeButton);
        this.f53128h = pbVideoFullUserInfoLikeButton;
        pbVideoFullUserInfoLikeButton.setTextSize(0, l.g(this.f53121a.getPageActivity(), R.dimen.tbds30));
        this.i = new d(this.f53121a, this.f53128h);
        this.f53123c.setRadius(l.g(this.f53121a.getPageActivity(), R.dimen.ds40));
    }

    public final boolean i(a2 a2Var) {
        if (a2Var == null || a2Var.T() == null || a2Var.T().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), a2Var.T().getUserId());
    }

    public void j(int i) {
        PbVideoFullUserInfoLikeButton pbVideoFullUserInfoLikeButton = this.f53128h;
        if (pbVideoFullUserInfoLikeButton != null) {
            pbVideoFullUserInfoLikeButton.g(i);
        }
        SkinManager.setViewTextColor(this.f53126f, R.color.CAM_X0101);
        TextView textView = this.f53124d;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
        }
        ImageView imageView = this.f53127g;
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
        this.f53128h.setVisibility(0);
        this.f53126f.setVisibility(8);
        e(postData);
        if (i(a2Var)) {
            this.f53126f.setVisibility(8);
            this.f53128h.setVisibility(8);
        }
    }

    public void n(float f2) {
        this.f53125e.setAlpha(f2);
    }

    public void o(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }
}
