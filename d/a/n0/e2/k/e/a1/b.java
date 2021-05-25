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
    public PbFragment f53090a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f53091b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f53092c;

    /* renamed from: d  reason: collision with root package name */
    public HeadImageView f53093d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f53094e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f53095f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f53096g;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.f53091b = null;
        this.f53090a = pbFragment;
        this.f53091b = onClickListener;
        b();
    }

    public void a(BdTypeListView bdTypeListView, int i2) {
        RelativeLayout relativeLayout;
        if (bdTypeListView == null || (relativeLayout = this.f53092c) == null) {
            return;
        }
        bdTypeListView.x(relativeLayout, i2);
    }

    public void b() {
        if (this.f53092c != null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f53090a.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
        this.f53092c = relativeLayout;
        HeadImageView headImageView = (HeadImageView) relativeLayout.findViewById(R.id.iv_pb_video_smart_app_head);
        this.f53093d = headImageView;
        headImageView.setIsRound(true);
        this.f53093d.setPlaceHolder(1);
        this.f53094e = (TextView) this.f53092c.findViewById(R.id.tv_pb_video_smart_app_title);
        this.f53095f = (TextView) this.f53092c.findViewById(R.id.tv_pb_video_smart_app_abstract);
        this.f53096g = (ImageView) this.f53092c.findViewById(R.id.iv_pb_video_smart_app_arrow);
        this.f53092c.setOnClickListener(this.f53091b);
    }

    public void c(int i2) {
        RelativeLayout relativeLayout = this.f53092c;
        if (relativeLayout != null) {
            SkinManager.setBackgroundColor(relativeLayout, R.color.CAM_X0204);
        }
        HeadImageView headImageView = this.f53093d;
        if (headImageView != null) {
            headImageView.setIsNight(i2 == 1);
        }
        TextView textView = this.f53094e;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        TextView textView2 = this.f53095f;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0107);
        }
        ImageView imageView = this.f53096g;
        if (imageView != null) {
            SkinManager.setBackgroundResource(imageView, R.drawable.icon_common_arrow16_right_n);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        RelativeLayout relativeLayout;
        if (bdTypeListView == null || (relativeLayout = this.f53092c) == null) {
            return;
        }
        bdTypeListView.removeHeaderView(relativeLayout);
    }

    public void e(d.a.n0.e2.h.e eVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (eVar == null || bdTypeListView == null) {
            return;
        }
        if (eVar.L().C2() && eVar.L().k1() != null) {
            SmartApp k1 = eVar.L().k1();
            this.f53092c.setVisibility(0);
            d(bdTypeListView);
            a(bdTypeListView, 1);
            if (!k.isEmpty(k1.avatar)) {
                this.f53093d.W(k1.avatar, 10, false, false);
            }
            if (!k.isEmpty(k1.name)) {
                charSequence = k1.name + " " + ((Object) this.f53090a.getText(R.string.smart_app_suffix));
            } else {
                charSequence = this.f53090a.getText(R.string.intelligent_smart_app).toString();
            }
            this.f53094e.setText(charSequence);
            if (!k.isEmpty(k1._abstract)) {
                this.f53095f.setText(k1._abstract);
            } else {
                this.f53095f.setText(this.f53090a.getText(R.string.smart_app_default_abstract));
            }
            this.f53092c.setTag(k1);
            return;
        }
        this.f53092c.setVisibility(8);
        d(bdTypeListView);
    }
}
