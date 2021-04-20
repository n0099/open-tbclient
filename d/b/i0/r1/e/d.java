package d.b.i0.r1.e;

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
import d.b.i0.r1.c.b.r;
import java.util.List;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public NoNetworkView f61054a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f61055b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f61056c;

    /* renamed from: d  reason: collision with root package name */
    public View f61057d;

    /* renamed from: e  reason: collision with root package name */
    public b f61058e;

    /* renamed from: f  reason: collision with root package name */
    public View f61059f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f61060g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f61061h;
    public MemberTaskCenterActivity i;

    public d(MemberTaskCenterActivity memberTaskCenterActivity, View.OnClickListener onClickListener) {
        this.i = memberTaskCenterActivity;
        memberTaskCenterActivity.setContentView(R.layout.member_task_center_activity);
        this.f61057d = memberTaskCenterActivity.findViewById(R.id.root_view);
        this.f61054a = (NoNetworkView) memberTaskCenterActivity.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) memberTaskCenterActivity.findViewById(R.id.view_navigation_bar);
        this.f61055b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61055b.setTitleText(R.string.member_task_center);
        this.f61056c = (BdListView) memberTaskCenterActivity.findViewById(R.id.member_task_list);
        this.f61059f = LayoutInflater.from(memberTaskCenterActivity.getActivity()).inflate(R.layout.member_task_center_header_view, (ViewGroup) null);
        BdListViewHelper.d(memberTaskCenterActivity.getActivity(), this.f61056c, BdListViewHelper.HeadType.DEFAULT);
        TbImageView tbImageView = (TbImageView) this.f61059f.findViewById(R.id.advert_image_view);
        this.f61060g = tbImageView;
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f61061h = (TextView) this.f61059f.findViewById(R.id.current_score_num);
        this.f61060g.setOnClickListener(onClickListener);
        b bVar = new b(memberTaskCenterActivity);
        this.f61058e = bVar;
        bVar.d(onClickListener);
        this.f61056c.addHeaderView(this.f61059f);
        this.f61056c.setAdapter((ListAdapter) this.f61058e);
    }

    public final SpannableString a(String str, String str2) {
        SpannableString spannableString = new SpannableString(str + str2);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, str.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), str.length(), spannableString.length(), 33);
        return spannableString;
    }

    public BdListView b() {
        return this.f61056c;
    }

    public View c() {
        return this.f61057d;
    }

    public void d(int i) {
        this.f61055b.onChangeSkinType(this.i.getPageContext(), i);
        this.f61054a.c(this.i.getPageContext(), i);
        SkinManager.setBackgroundColor(this.f61061h, R.color.CAM_X0205);
    }

    public void e(String str, List<r> list, long j) {
        this.f61060g.W(str, 10, false);
        this.f61061h.setText(a(this.i.getResources().getString(R.string.current_score), String.valueOf(j)));
        this.f61058e.c(list);
        this.f61058e.notifyDataSetChanged();
    }
}
