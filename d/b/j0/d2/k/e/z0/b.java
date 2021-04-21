package d.b.j0.d2.k.e.z0;

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
    public PbFragment f54810a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f54811b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f54812c;

    /* renamed from: d  reason: collision with root package name */
    public HeadImageView f54813d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f54814e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f54815f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f54816g;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.f54811b = null;
        this.f54810a = pbFragment;
        this.f54811b = onClickListener;
        b();
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        RelativeLayout relativeLayout;
        if (bdTypeListView == null || (relativeLayout = this.f54812c) == null) {
            return;
        }
        bdTypeListView.x(relativeLayout, i);
    }

    public void b() {
        if (this.f54812c != null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f54810a.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
        this.f54812c = relativeLayout;
        HeadImageView headImageView = (HeadImageView) relativeLayout.findViewById(R.id.iv_pb_video_smart_app_head);
        this.f54813d = headImageView;
        headImageView.setIsRound(true);
        this.f54813d.setPlaceHolder(1);
        this.f54814e = (TextView) this.f54812c.findViewById(R.id.tv_pb_video_smart_app_title);
        this.f54815f = (TextView) this.f54812c.findViewById(R.id.tv_pb_video_smart_app_abstract);
        this.f54816g = (ImageView) this.f54812c.findViewById(R.id.iv_pb_video_smart_app_arrow);
        this.f54812c.setOnClickListener(this.f54811b);
    }

    public void c(int i) {
        RelativeLayout relativeLayout = this.f54812c;
        if (relativeLayout != null) {
            SkinManager.setBackgroundColor(relativeLayout, R.color.CAM_X0204);
        }
        HeadImageView headImageView = this.f54813d;
        if (headImageView != null) {
            headImageView.setIsNight(i == 1);
        }
        TextView textView = this.f54814e;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        TextView textView2 = this.f54815f;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0107);
        }
        ImageView imageView = this.f54816g;
        if (imageView != null) {
            SkinManager.setBackgroundResource(imageView, R.drawable.icon_common_arrow16_right_n);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        RelativeLayout relativeLayout;
        if (bdTypeListView == null || (relativeLayout = this.f54812c) == null) {
            return;
        }
        bdTypeListView.removeHeaderView(relativeLayout);
    }

    public void e(d.b.j0.d2.h.e eVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (eVar == null || bdTypeListView == null) {
            return;
        }
        if (eVar.L().z2() && eVar.L().j1() != null) {
            SmartApp j1 = eVar.L().j1();
            this.f54812c.setVisibility(0);
            d(bdTypeListView);
            a(bdTypeListView, 1);
            if (!k.isEmpty(j1.avatar)) {
                this.f54813d.X(j1.avatar, 10, false, false);
            }
            if (!k.isEmpty(j1.name)) {
                charSequence = j1.name + " " + ((Object) this.f54810a.getText(R.string.smart_app_suffix));
            } else {
                charSequence = this.f54810a.getText(R.string.intelligent_smart_app).toString();
            }
            this.f54814e.setText(charSequence);
            if (!k.isEmpty(j1._abstract)) {
                this.f54815f.setText(j1._abstract);
            } else {
                this.f54815f.setText(this.f54810a.getText(R.string.smart_app_default_abstract));
            }
            this.f54812c.setTag(j1);
            return;
        }
        this.f54812c.setVisibility(8);
        d(bdTypeListView);
    }
}
