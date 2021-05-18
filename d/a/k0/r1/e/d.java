package d.a.k0.r1.e;

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
import d.a.k0.r1.c.b.r;
import java.util.List;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public NoNetworkView f60366a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f60367b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f60368c;

    /* renamed from: d  reason: collision with root package name */
    public View f60369d;

    /* renamed from: e  reason: collision with root package name */
    public b f60370e;

    /* renamed from: f  reason: collision with root package name */
    public View f60371f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f60372g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60373h;

    /* renamed from: i  reason: collision with root package name */
    public MemberTaskCenterActivity f60374i;

    public d(MemberTaskCenterActivity memberTaskCenterActivity, View.OnClickListener onClickListener) {
        this.f60374i = memberTaskCenterActivity;
        memberTaskCenterActivity.setContentView(R.layout.member_task_center_activity);
        this.f60369d = memberTaskCenterActivity.findViewById(R.id.root_view);
        this.f60366a = (NoNetworkView) memberTaskCenterActivity.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) memberTaskCenterActivity.findViewById(R.id.view_navigation_bar);
        this.f60367b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f60367b.setTitleText(R.string.member_task_center);
        this.f60368c = (BdListView) memberTaskCenterActivity.findViewById(R.id.member_task_list);
        this.f60371f = LayoutInflater.from(memberTaskCenterActivity.getActivity()).inflate(R.layout.member_task_center_header_view, (ViewGroup) null);
        BdListViewHelper.d(memberTaskCenterActivity.getActivity(), this.f60368c, BdListViewHelper.HeadType.DEFAULT);
        TbImageView tbImageView = (TbImageView) this.f60371f.findViewById(R.id.advert_image_view);
        this.f60372g = tbImageView;
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f60373h = (TextView) this.f60371f.findViewById(R.id.current_score_num);
        this.f60372g.setOnClickListener(onClickListener);
        b bVar = new b(memberTaskCenterActivity);
        this.f60370e = bVar;
        bVar.d(onClickListener);
        this.f60368c.addHeaderView(this.f60371f);
        this.f60368c.setAdapter((ListAdapter) this.f60370e);
    }

    public final SpannableString a(String str, String str2) {
        SpannableString spannableString = new SpannableString(str + str2);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, str.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), str.length(), spannableString.length(), 33);
        return spannableString;
    }

    public BdListView b() {
        return this.f60368c;
    }

    public View c() {
        return this.f60369d;
    }

    public void d(int i2) {
        this.f60367b.onChangeSkinType(this.f60374i.getPageContext(), i2);
        this.f60366a.c(this.f60374i.getPageContext(), i2);
        SkinManager.setBackgroundColor(this.f60373h, R.color.CAM_X0205);
    }

    public void e(String str, List<r> list, long j) {
        this.f60372g.V(str, 10, false);
        this.f60373h.setText(a(this.f60374i.getResources().getString(R.string.current_score), String.valueOf(j)));
        this.f60370e.c(list);
        this.f60370e.notifyDataSetChanged();
    }
}
