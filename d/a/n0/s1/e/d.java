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
    public NoNetworkView f60489a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f60490b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f60491c;

    /* renamed from: d  reason: collision with root package name */
    public View f60492d;

    /* renamed from: e  reason: collision with root package name */
    public b f60493e;

    /* renamed from: f  reason: collision with root package name */
    public View f60494f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f60495g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60496h;

    /* renamed from: i  reason: collision with root package name */
    public MemberTaskCenterActivity f60497i;

    public d(MemberTaskCenterActivity memberTaskCenterActivity, View.OnClickListener onClickListener) {
        this.f60497i = memberTaskCenterActivity;
        memberTaskCenterActivity.setContentView(R.layout.member_task_center_activity);
        this.f60492d = memberTaskCenterActivity.findViewById(R.id.root_view);
        this.f60489a = (NoNetworkView) memberTaskCenterActivity.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) memberTaskCenterActivity.findViewById(R.id.view_navigation_bar);
        this.f60490b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f60490b.setTitleText(R.string.member_task_center);
        this.f60491c = (BdListView) memberTaskCenterActivity.findViewById(R.id.member_task_list);
        this.f60494f = LayoutInflater.from(memberTaskCenterActivity.getActivity()).inflate(R.layout.member_task_center_header_view, (ViewGroup) null);
        BdListViewHelper.d(memberTaskCenterActivity.getActivity(), this.f60491c, BdListViewHelper.HeadType.DEFAULT);
        TbImageView tbImageView = (TbImageView) this.f60494f.findViewById(R.id.advert_image_view);
        this.f60495g = tbImageView;
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f60496h = (TextView) this.f60494f.findViewById(R.id.current_score_num);
        this.f60495g.setOnClickListener(onClickListener);
        b bVar = new b(memberTaskCenterActivity);
        this.f60493e = bVar;
        bVar.d(onClickListener);
        this.f60491c.addHeaderView(this.f60494f);
        this.f60491c.setAdapter((ListAdapter) this.f60493e);
    }

    public final SpannableString a(String str, String str2) {
        SpannableString spannableString = new SpannableString(str + str2);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, str.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), str.length(), spannableString.length(), 33);
        return spannableString;
    }

    public BdListView b() {
        return this.f60491c;
    }

    public View c() {
        return this.f60492d;
    }

    public void d(int i2) {
        this.f60490b.onChangeSkinType(this.f60497i.getPageContext(), i2);
        this.f60489a.c(this.f60497i.getPageContext(), i2);
        SkinManager.setBackgroundColor(this.f60496h, R.color.CAM_X0205);
    }

    public void e(String str, List<r> list, long j) {
        this.f60495g.V(str, 10, false);
        this.f60496h.setText(a(this.f60497i.getResources().getString(R.string.current_score), String.valueOf(j)));
        this.f60493e.c(list);
        this.f60493e.notifyDataSetChanged();
    }
}
