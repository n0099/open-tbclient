package d.a.k0.d2.k.e.z0;

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
    public PbFragment f53329a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f53330b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f53331c;

    /* renamed from: d  reason: collision with root package name */
    public HeadImageView f53332d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f53333e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f53334f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f53335g;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.f53330b = null;
        this.f53329a = pbFragment;
        this.f53330b = onClickListener;
        b();
    }

    public void a(BdTypeListView bdTypeListView, int i2) {
        RelativeLayout relativeLayout;
        if (bdTypeListView == null || (relativeLayout = this.f53331c) == null) {
            return;
        }
        bdTypeListView.x(relativeLayout, i2);
    }

    public void b() {
        if (this.f53331c != null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f53329a.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
        this.f53331c = relativeLayout;
        HeadImageView headImageView = (HeadImageView) relativeLayout.findViewById(R.id.iv_pb_video_smart_app_head);
        this.f53332d = headImageView;
        headImageView.setIsRound(true);
        this.f53332d.setPlaceHolder(1);
        this.f53333e = (TextView) this.f53331c.findViewById(R.id.tv_pb_video_smart_app_title);
        this.f53334f = (TextView) this.f53331c.findViewById(R.id.tv_pb_video_smart_app_abstract);
        this.f53335g = (ImageView) this.f53331c.findViewById(R.id.iv_pb_video_smart_app_arrow);
        this.f53331c.setOnClickListener(this.f53330b);
    }

    public void c(int i2) {
        RelativeLayout relativeLayout = this.f53331c;
        if (relativeLayout != null) {
            SkinManager.setBackgroundColor(relativeLayout, R.color.CAM_X0204);
        }
        HeadImageView headImageView = this.f53332d;
        if (headImageView != null) {
            headImageView.setIsNight(i2 == 1);
        }
        TextView textView = this.f53333e;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        TextView textView2 = this.f53334f;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0107);
        }
        ImageView imageView = this.f53335g;
        if (imageView != null) {
            SkinManager.setBackgroundResource(imageView, R.drawable.icon_common_arrow16_right_n);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        RelativeLayout relativeLayout;
        if (bdTypeListView == null || (relativeLayout = this.f53331c) == null) {
            return;
        }
        bdTypeListView.removeHeaderView(relativeLayout);
    }

    public void e(d.a.k0.d2.h.e eVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (eVar == null || bdTypeListView == null) {
            return;
        }
        if (eVar.L().B2() && eVar.L().j1() != null) {
            SmartApp j1 = eVar.L().j1();
            this.f53331c.setVisibility(0);
            d(bdTypeListView);
            a(bdTypeListView, 1);
            if (!k.isEmpty(j1.avatar)) {
                this.f53332d.W(j1.avatar, 10, false, false);
            }
            if (!k.isEmpty(j1.name)) {
                charSequence = j1.name + " " + ((Object) this.f53329a.getText(R.string.smart_app_suffix));
            } else {
                charSequence = this.f53329a.getText(R.string.intelligent_smart_app).toString();
            }
            this.f53333e.setText(charSequence);
            if (!k.isEmpty(j1._abstract)) {
                this.f53334f.setText(j1._abstract);
            } else {
                this.f53334f.setText(this.f53329a.getText(R.string.smart_app_default_abstract));
            }
            this.f53331c.setTag(j1);
            return;
        }
        this.f53331c.setVisibility(8);
        d(bdTypeListView);
    }
}
