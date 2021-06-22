package d.a.o0.e2.k.e.a1;

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
    public PbFragment f56904a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f56905b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f56906c;

    /* renamed from: d  reason: collision with root package name */
    public HeadImageView f56907d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56908e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f56909f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f56910g;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.f56905b = null;
        this.f56904a = pbFragment;
        this.f56905b = onClickListener;
        b();
    }

    public void a(BdTypeListView bdTypeListView, int i2) {
        RelativeLayout relativeLayout;
        if (bdTypeListView == null || (relativeLayout = this.f56906c) == null) {
            return;
        }
        bdTypeListView.x(relativeLayout, i2);
    }

    public void b() {
        if (this.f56906c != null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f56904a.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
        this.f56906c = relativeLayout;
        HeadImageView headImageView = (HeadImageView) relativeLayout.findViewById(R.id.iv_pb_video_smart_app_head);
        this.f56907d = headImageView;
        headImageView.setIsRound(true);
        this.f56907d.setPlaceHolder(1);
        this.f56908e = (TextView) this.f56906c.findViewById(R.id.tv_pb_video_smart_app_title);
        this.f56909f = (TextView) this.f56906c.findViewById(R.id.tv_pb_video_smart_app_abstract);
        this.f56910g = (ImageView) this.f56906c.findViewById(R.id.iv_pb_video_smart_app_arrow);
        this.f56906c.setOnClickListener(this.f56905b);
    }

    public void c(int i2) {
        RelativeLayout relativeLayout = this.f56906c;
        if (relativeLayout != null) {
            SkinManager.setBackgroundColor(relativeLayout, R.color.CAM_X0204);
        }
        HeadImageView headImageView = this.f56907d;
        if (headImageView != null) {
            headImageView.setIsNight(i2 == 1);
        }
        TextView textView = this.f56908e;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        TextView textView2 = this.f56909f;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0107);
        }
        ImageView imageView = this.f56910g;
        if (imageView != null) {
            SkinManager.setBackgroundResource(imageView, R.drawable.icon_common_arrow16_right_n);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        RelativeLayout relativeLayout;
        if (bdTypeListView == null || (relativeLayout = this.f56906c) == null) {
            return;
        }
        bdTypeListView.removeHeaderView(relativeLayout);
    }

    public void e(d.a.o0.e2.h.e eVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (eVar == null || bdTypeListView == null) {
            return;
        }
        if (eVar.L().D2() && eVar.L().l1() != null) {
            SmartApp l1 = eVar.L().l1();
            this.f56906c.setVisibility(0);
            d(bdTypeListView);
            a(bdTypeListView, 1);
            if (!k.isEmpty(l1.avatar)) {
                this.f56907d.V(l1.avatar, 10, false, false);
            }
            if (!k.isEmpty(l1.name)) {
                charSequence = l1.name + " " + ((Object) this.f56904a.getText(R.string.smart_app_suffix));
            } else {
                charSequence = this.f56904a.getText(R.string.intelligent_smart_app).toString();
            }
            this.f56908e.setText(charSequence);
            if (!k.isEmpty(l1._abstract)) {
                this.f56909f.setText(l1._abstract);
            } else {
                this.f56909f.setText(this.f56904a.getText(R.string.smart_app_default_abstract));
            }
            this.f56906c.setTag(l1);
            return;
        }
        this.f56906c.setVisibility(8);
        d(bdTypeListView);
    }
}
