package d.a.n0.e2.k.e.a1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import d.a.c.e.p.k;
import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f56779a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f56780b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f56781c;

    /* renamed from: d  reason: collision with root package name */
    public HeadImageView f56782d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56783e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f56784f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f56785g;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.f56780b = null;
        this.f56779a = pbFragment;
        this.f56780b = onClickListener;
        b();
    }

    public void a(BdTypeListView bdTypeListView, int i2) {
        RelativeLayout relativeLayout;
        if (bdTypeListView == null || (relativeLayout = this.f56781c) == null) {
            return;
        }
        bdTypeListView.x(relativeLayout, i2);
    }

    public void b() {
        if (this.f56781c != null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f56779a.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
        this.f56781c = relativeLayout;
        HeadImageView headImageView = (HeadImageView) relativeLayout.findViewById(R.id.iv_pb_video_smart_app_head);
        this.f56782d = headImageView;
        headImageView.setIsRound(true);
        this.f56782d.setPlaceHolder(1);
        this.f56783e = (TextView) this.f56781c.findViewById(R.id.tv_pb_video_smart_app_title);
        this.f56784f = (TextView) this.f56781c.findViewById(R.id.tv_pb_video_smart_app_abstract);
        this.f56785g = (ImageView) this.f56781c.findViewById(R.id.iv_pb_video_smart_app_arrow);
        this.f56781c.setOnClickListener(this.f56780b);
    }

    public void c(int i2) {
        RelativeLayout relativeLayout = this.f56781c;
        if (relativeLayout != null) {
            SkinManager.setBackgroundColor(relativeLayout, R.color.CAM_X0204);
        }
        HeadImageView headImageView = this.f56782d;
        if (headImageView != null) {
            headImageView.setIsNight(i2 == 1);
        }
        TextView textView = this.f56783e;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        TextView textView2 = this.f56784f;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0107);
        }
        ImageView imageView = this.f56785g;
        if (imageView != null) {
            SkinManager.setBackgroundResource(imageView, R.drawable.icon_common_arrow16_right_n);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        RelativeLayout relativeLayout;
        if (bdTypeListView == null || (relativeLayout = this.f56781c) == null) {
            return;
        }
        bdTypeListView.removeHeaderView(relativeLayout);
    }

    public void e(d.a.n0.e2.h.e eVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (eVar == null || bdTypeListView == null) {
            return;
        }
        if (eVar.L().D2() && eVar.L().l1() != null) {
            SmartApp l1 = eVar.L().l1();
            this.f56781c.setVisibility(0);
            d(bdTypeListView);
            a(bdTypeListView, 1);
            if (!k.isEmpty(l1.avatar)) {
                this.f56782d.V(l1.avatar, 10, false, false);
            }
            if (!k.isEmpty(l1.name)) {
                charSequence = l1.name + " " + ((Object) this.f56779a.getText(R.string.smart_app_suffix));
            } else {
                charSequence = this.f56779a.getText(R.string.intelligent_smart_app).toString();
            }
            this.f56783e.setText(charSequence);
            if (!k.isEmpty(l1._abstract)) {
                this.f56784f.setText(l1._abstract);
            } else {
                this.f56784f.setText(this.f56779a.getText(R.string.smart_app_default_abstract));
            }
            this.f56781c.setTag(l1);
            return;
        }
        this.f56781c.setVisibility(8);
        d(bdTypeListView);
    }
}
