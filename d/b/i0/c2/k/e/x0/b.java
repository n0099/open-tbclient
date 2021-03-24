package d.b.i0.c2.k.e.x0;

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
import d.b.b.e.p.k;
import tbclient.SmartApp;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f52893a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f52894b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f52895c;

    /* renamed from: d  reason: collision with root package name */
    public HeadImageView f52896d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f52897e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f52898f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f52899g;

    public b(PbFragment pbFragment, View.OnClickListener onClickListener) {
        this.f52894b = null;
        this.f52893a = pbFragment;
        this.f52894b = onClickListener;
        b();
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        RelativeLayout relativeLayout;
        if (bdTypeListView == null || (relativeLayout = this.f52895c) == null) {
            return;
        }
        bdTypeListView.x(relativeLayout, i);
    }

    public void b() {
        if (this.f52895c != null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f52893a.getContext()).inflate(R.layout.pb_video_thread_smart_app_layout, (ViewGroup) null);
        this.f52895c = relativeLayout;
        HeadImageView headImageView = (HeadImageView) relativeLayout.findViewById(R.id.iv_pb_video_smart_app_head);
        this.f52896d = headImageView;
        headImageView.setIsRound(true);
        this.f52896d.setPlaceHolder(1);
        this.f52897e = (TextView) this.f52895c.findViewById(R.id.tv_pb_video_smart_app_title);
        this.f52898f = (TextView) this.f52895c.findViewById(R.id.tv_pb_video_smart_app_abstract);
        this.f52899g = (ImageView) this.f52895c.findViewById(R.id.iv_pb_video_smart_app_arrow);
        this.f52895c.setOnClickListener(this.f52894b);
    }

    public void c(int i) {
        RelativeLayout relativeLayout = this.f52895c;
        if (relativeLayout != null) {
            SkinManager.setBackgroundColor(relativeLayout, R.color.CAM_X0204);
        }
        HeadImageView headImageView = this.f52896d;
        if (headImageView != null) {
            headImageView.setIsNight(i == 1);
        }
        TextView textView = this.f52897e;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        TextView textView2 = this.f52898f;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0107);
        }
        ImageView imageView = this.f52899g;
        if (imageView != null) {
            SkinManager.setBackgroundResource(imageView, R.drawable.icon_common_arrow16_right_n);
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        RelativeLayout relativeLayout;
        if (bdTypeListView == null || (relativeLayout = this.f52895c) == null) {
            return;
        }
        bdTypeListView.removeHeaderView(relativeLayout);
    }

    public void e(d.b.i0.c2.h.e eVar, BdTypeListView bdTypeListView) {
        String charSequence;
        if (eVar == null || bdTypeListView == null) {
            return;
        }
        if (eVar.L().y2() && eVar.L().j1() != null) {
            SmartApp j1 = eVar.L().j1();
            this.f52895c.setVisibility(0);
            d(bdTypeListView);
            a(bdTypeListView, 1);
            if (!k.isEmpty(j1.avatar)) {
                this.f52896d.X(j1.avatar, 10, false, false);
            }
            if (!k.isEmpty(j1.name)) {
                charSequence = j1.name + " " + ((Object) this.f52893a.getText(R.string.smart_app_suffix));
            } else {
                charSequence = this.f52893a.getText(R.string.intelligent_smart_app).toString();
            }
            this.f52897e.setText(charSequence);
            if (!k.isEmpty(j1._abstract)) {
                this.f52898f.setText(j1._abstract);
            } else {
                this.f52898f.setText(this.f52893a.getText(R.string.smart_app_default_abstract));
            }
            this.f52895c.setTag(j1);
            return;
        }
        this.f52895c.setVisibility(8);
        d(bdTypeListView);
    }
}
