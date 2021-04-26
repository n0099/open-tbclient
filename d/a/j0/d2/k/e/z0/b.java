package d.a.j0.d2.k.e.z0;

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
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f52626a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f52627b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f52628c;

    /* renamed from: d  reason: collision with root package name */
    public HeadImageView f52629d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f52630e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f52631f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f52632g;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.f52627b = null;
        this.f52626a = pbFragment;
        this.f52627b = onClickListener;
        b();
    }

    public void a(BdTypeListView bdTypeListView, int i2) {
        RelativeLayout relativeLayout;
        if (bdTypeListView == null || (relativeLayout = this.f52628c) == null) {
            return;
        }
        bdTypeListView.x(relativeLayout, i2);
    }

    public void b() {
        if (this.f52628c != null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f52626a.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
        this.f52628c = relativeLayout;
        HeadImageView headImageView = (HeadImageView) relativeLayout.findViewById(R.id.iv_pb_video_smart_app_head);
        this.f52629d = headImageView;
        headImageView.setIsRound(true);
        this.f52629d.setPlaceHolder(1);
        this.f52630e = (TextView) this.f52628c.findViewById(R.id.tv_pb_video_smart_app_title);
        this.f52631f = (TextView) this.f52628c.findViewById(R.id.tv_pb_video_smart_app_abstract);
        this.f52632g = (ImageView) this.f52628c.findViewById(R.id.iv_pb_video_smart_app_arrow);
        this.f52628c.setOnClickListener(this.f52627b);
    }

    public void c(int i2) {
        RelativeLayout relativeLayout = this.f52628c;
        if (relativeLayout != null) {
            SkinManager.setBackgroundColor(relativeLayout, R.color.CAM_X0204);
        }
        HeadImageView headImageView = this.f52629d;
        if (headImageView != null) {
            headImageView.setIsNight(i2 == 1);
        }
        TextView textView = this.f52630e;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        TextView textView2 = this.f52631f;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0107);
        }
        ImageView imageView = this.f52632g;
        if (imageView != null) {
            SkinManager.setBackgroundResource(imageView, R.drawable.icon_common_arrow16_right_n);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        RelativeLayout relativeLayout;
        if (bdTypeListView == null || (relativeLayout = this.f52628c) == null) {
            return;
        }
        bdTypeListView.removeHeaderView(relativeLayout);
    }

    public void e(d.a.j0.d2.h.e eVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (eVar == null || bdTypeListView == null) {
            return;
        }
        if (eVar.L().z2() && eVar.L().j1() != null) {
            SmartApp j1 = eVar.L().j1();
            this.f52628c.setVisibility(0);
            d(bdTypeListView);
            a(bdTypeListView, 1);
            if (!k.isEmpty(j1.avatar)) {
                this.f52629d.W(j1.avatar, 10, false, false);
            }
            if (!k.isEmpty(j1.name)) {
                charSequence = j1.name + " " + ((Object) this.f52626a.getText(R.string.smart_app_suffix));
            } else {
                charSequence = this.f52626a.getText(R.string.intelligent_smart_app).toString();
            }
            this.f52630e.setText(charSequence);
            if (!k.isEmpty(j1._abstract)) {
                this.f52631f.setText(j1._abstract);
            } else {
                this.f52631f.setText(this.f52626a.getText(R.string.smart_app_default_abstract));
            }
            this.f52628c.setTag(j1);
            return;
        }
        this.f52628c.setVisibility(8);
        d(bdTypeListView);
    }
}
