package d.a.n0.s1.e;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterActivity;
import d.a.n0.s1.c.b.r;
import java.util.List;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public NoNetworkView f64180a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f64181b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f64182c;

    /* renamed from: d  reason: collision with root package name */
    public View f64183d;

    /* renamed from: e  reason: collision with root package name */
    public b f64184e;

    /* renamed from: f  reason: collision with root package name */
    public View f64185f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f64186g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f64187h;

    /* renamed from: i  reason: collision with root package name */
    public MemberTaskCenterActivity f64188i;

    public d(MemberTaskCenterActivity memberTaskCenterActivity, View.OnClickListener onClickListener) {
        this.f64188i = memberTaskCenterActivity;
        memberTaskCenterActivity.setContentView(R.layout.member_task_center_activity);
        this.f64183d = memberTaskCenterActivity.findViewById(R.id.root_view);
        this.f64180a = (NoNetworkView) memberTaskCenterActivity.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) memberTaskCenterActivity.findViewById(R.id.view_navigation_bar);
        this.f64181b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f64181b.setTitleText(R.string.member_task_center);
        this.f64182c = (BdListView) memberTaskCenterActivity.findViewById(R.id.member_task_list);
        this.f64185f = LayoutInflater.from(memberTaskCenterActivity.getActivity()).inflate(R.layout.member_task_center_header_view, (ViewGroup) null);
        BdListViewHelper.d(memberTaskCenterActivity.getActivity(), this.f64182c, BdListViewHelper.HeadType.DEFAULT);
        TbImageView tbImageView = (TbImageView) this.f64185f.findViewById(R.id.advert_image_view);
        this.f64186g = tbImageView;
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f64187h = (TextView) this.f64185f.findViewById(R.id.current_score_num);
        this.f64186g.setOnClickListener(onClickListener);
        b bVar = new b(memberTaskCenterActivity);
        this.f64184e = bVar;
        bVar.d(onClickListener);
        this.f64182c.addHeaderView(this.f64185f);
        this.f64182c.setAdapter((ListAdapter) this.f64184e);
    }

    public final SpannableString a(String str, String str2) {
        SpannableString spannableString = new SpannableString(str + str2);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, str.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), str.length(), spannableString.length(), 33);
        return spannableString;
    }

    public BdListView b() {
        return this.f64182c;
    }

    public View c() {
        return this.f64183d;
    }

    public void d(int i2) {
        this.f64181b.onChangeSkinType(this.f64188i.getPageContext(), i2);
        this.f64180a.c(this.f64188i.getPageContext(), i2);
        SkinManager.setBackgroundColor(this.f64187h, R.color.CAM_X0205);
    }

    public void e(String str, List<r> list, long j) {
        this.f64186g.U(str, 10, false);
        this.f64187h.setText(a(this.f64188i.getResources().getString(R.string.current_score), String.valueOf(j)));
        this.f64184e.c(list);
        this.f64184e.notifyDataSetChanged();
    }
}
