package d.b.i0.q1.e;

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
import d.b.i0.q1.c.b.r;
import java.util.List;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public NoNetworkView f59359a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f59360b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f59361c;

    /* renamed from: d  reason: collision with root package name */
    public View f59362d;

    /* renamed from: e  reason: collision with root package name */
    public b f59363e;

    /* renamed from: f  reason: collision with root package name */
    public View f59364f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f59365g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f59366h;
    public MemberTaskCenterActivity i;

    public d(MemberTaskCenterActivity memberTaskCenterActivity, View.OnClickListener onClickListener) {
        this.i = memberTaskCenterActivity;
        memberTaskCenterActivity.setContentView(R.layout.member_task_center_activity);
        this.f59362d = memberTaskCenterActivity.findViewById(R.id.root_view);
        this.f59359a = (NoNetworkView) memberTaskCenterActivity.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) memberTaskCenterActivity.findViewById(R.id.view_navigation_bar);
        this.f59360b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f59360b.setTitleText(R.string.member_task_center);
        this.f59361c = (BdListView) memberTaskCenterActivity.findViewById(R.id.member_task_list);
        this.f59364f = LayoutInflater.from(memberTaskCenterActivity.getActivity()).inflate(R.layout.member_task_center_header_view, (ViewGroup) null);
        BdListViewHelper.d(memberTaskCenterActivity.getActivity(), this.f59361c, BdListViewHelper.HeadType.DEFAULT);
        TbImageView tbImageView = (TbImageView) this.f59364f.findViewById(R.id.advert_image_view);
        this.f59365g = tbImageView;
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f59366h = (TextView) this.f59364f.findViewById(R.id.current_score_num);
        this.f59365g.setOnClickListener(onClickListener);
        b bVar = new b(memberTaskCenterActivity);
        this.f59363e = bVar;
        bVar.d(onClickListener);
        this.f59361c.addHeaderView(this.f59364f);
        this.f59361c.setAdapter((ListAdapter) this.f59363e);
    }

    public final SpannableString a(String str, String str2) {
        SpannableString spannableString = new SpannableString(str + str2);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, str.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), str.length(), spannableString.length(), 33);
        return spannableString;
    }

    public BdListView b() {
        return this.f59361c;
    }

    public View c() {
        return this.f59362d;
    }

    public void d(int i) {
        this.f59360b.onChangeSkinType(this.i.getPageContext(), i);
        this.f59359a.c(this.i.getPageContext(), i);
        SkinManager.setBackgroundColor(this.f59366h, R.color.CAM_X0205);
    }

    public void e(String str, List<r> list, long j) {
        this.f59365g.W(str, 10, false);
        this.f59366h.setText(a(this.i.getResources().getString(R.string.current_score), String.valueOf(j)));
        this.f59363e.c(list);
        this.f59363e.notifyDataSetChanged();
    }
}
