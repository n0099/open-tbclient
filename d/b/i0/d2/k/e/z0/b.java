package d.b.i0.d2.k.e.z0;

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
import d.b.c.e.p.k;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f54389a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f54390b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f54391c;

    /* renamed from: d  reason: collision with root package name */
    public HeadImageView f54392d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f54393e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f54394f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f54395g;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.f54390b = null;
        this.f54389a = pbFragment;
        this.f54390b = onClickListener;
        b();
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        RelativeLayout relativeLayout;
        if (bdTypeListView == null || (relativeLayout = this.f54391c) == null) {
            return;
        }
        bdTypeListView.x(relativeLayout, i);
    }

    public void b() {
        if (this.f54391c != null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f54389a.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
        this.f54391c = relativeLayout;
        HeadImageView headImageView = (HeadImageView) relativeLayout.findViewById(R.id.iv_pb_video_smart_app_head);
        this.f54392d = headImageView;
        headImageView.setIsRound(true);
        this.f54392d.setPlaceHolder(1);
        this.f54393e = (TextView) this.f54391c.findViewById(R.id.tv_pb_video_smart_app_title);
        this.f54394f = (TextView) this.f54391c.findViewById(R.id.tv_pb_video_smart_app_abstract);
        this.f54395g = (ImageView) this.f54391c.findViewById(R.id.iv_pb_video_smart_app_arrow);
        this.f54391c.setOnClickListener(this.f54390b);
    }

    public void c(int i) {
        RelativeLayout relativeLayout = this.f54391c;
        if (relativeLayout != null) {
            SkinManager.setBackgroundColor(relativeLayout, R.color.CAM_X0204);
        }
        HeadImageView headImageView = this.f54392d;
        if (headImageView != null) {
            headImageView.setIsNight(i == 1);
        }
        TextView textView = this.f54393e;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        TextView textView2 = this.f54394f;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0107);
        }
        ImageView imageView = this.f54395g;
        if (imageView != null) {
            SkinManager.setBackgroundResource(imageView, R.drawable.icon_common_arrow16_right_n);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        RelativeLayout relativeLayout;
        if (bdTypeListView == null || (relativeLayout = this.f54391c) == null) {
            return;
        }
        bdTypeListView.removeHeaderView(relativeLayout);
    }

    public void e(d.b.i0.d2.h.e eVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (eVar == null || bdTypeListView == null) {
            return;
        }
        if (eVar.L().z2() && eVar.L().j1() != null) {
            SmartApp j1 = eVar.L().j1();
            this.f54391c.setVisibility(0);
            d(bdTypeListView);
            a(bdTypeListView, 1);
            if (!k.isEmpty(j1.avatar)) {
                this.f54392d.X(j1.avatar, 10, false, false);
            }
            if (!k.isEmpty(j1.name)) {
                charSequence = j1.name + " " + ((Object) this.f54389a.getText(R.string.smart_app_suffix));
            } else {
                charSequence = this.f54389a.getText(R.string.intelligent_smart_app).toString();
            }
            this.f54393e.setText(charSequence);
            if (!k.isEmpty(j1._abstract)) {
                this.f54394f.setText(j1._abstract);
            } else {
                this.f54394f.setText(this.f54389a.getText(R.string.smart_app_default_abstract));
            }
            this.f54391c.setTag(j1);
            return;
        }
        this.f54391c.setVisibility(8);
        d(bdTypeListView);
    }
}
