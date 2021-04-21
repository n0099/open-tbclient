package d.b.j0.r1.e;

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
import d.b.j0.r1.c.b.r;
import java.util.List;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public NoNetworkView f61475a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f61476b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f61477c;

    /* renamed from: d  reason: collision with root package name */
    public View f61478d;

    /* renamed from: e  reason: collision with root package name */
    public b f61479e;

    /* renamed from: f  reason: collision with root package name */
    public View f61480f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f61481g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f61482h;
    public MemberTaskCenterActivity i;

    public d(MemberTaskCenterActivity memberTaskCenterActivity, View.OnClickListener onClickListener) {
        this.i = memberTaskCenterActivity;
        memberTaskCenterActivity.setContentView(R.layout.member_task_center_activity);
        this.f61478d = memberTaskCenterActivity.findViewById(R.id.root_view);
        this.f61475a = (NoNetworkView) memberTaskCenterActivity.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) memberTaskCenterActivity.findViewById(R.id.view_navigation_bar);
        this.f61476b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61476b.setTitleText(R.string.member_task_center);
        this.f61477c = (BdListView) memberTaskCenterActivity.findViewById(R.id.member_task_list);
        this.f61480f = LayoutInflater.from(memberTaskCenterActivity.getActivity()).inflate(R.layout.member_task_center_header_view, (ViewGroup) null);
        BdListViewHelper.d(memberTaskCenterActivity.getActivity(), this.f61477c, BdListViewHelper.HeadType.DEFAULT);
        TbImageView tbImageView = (TbImageView) this.f61480f.findViewById(R.id.advert_image_view);
        this.f61481g = tbImageView;
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f61482h = (TextView) this.f61480f.findViewById(R.id.current_score_num);
        this.f61481g.setOnClickListener(onClickListener);
        b bVar = new b(memberTaskCenterActivity);
        this.f61479e = bVar;
        bVar.d(onClickListener);
        this.f61477c.addHeaderView(this.f61480f);
        this.f61477c.setAdapter((ListAdapter) this.f61479e);
    }

    public final SpannableString a(String str, String str2) {
        SpannableString spannableString = new SpannableString(str + str2);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, str.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), str.length(), spannableString.length(), 33);
        return spannableString;
    }

    public BdListView b() {
        return this.f61477c;
    }

    public View c() {
        return this.f61478d;
    }

    public void d(int i) {
        this.f61476b.onChangeSkinType(this.i.getPageContext(), i);
        this.f61475a.c(this.i.getPageContext(), i);
        SkinManager.setBackgroundColor(this.f61482h, R.color.CAM_X0205);
    }

    public void e(String str, List<r> list, long j) {
        this.f61481g.W(str, 10, false);
        this.f61482h.setText(a(this.i.getResources().getString(R.string.current_score), String.valueOf(j)));
        this.f61479e.c(list);
        this.f61479e.notifyDataSetChanged();
    }
}
