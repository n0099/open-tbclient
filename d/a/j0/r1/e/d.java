package d.a.j0.r1.e;

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
import d.a.j0.r1.c.b.r;
import java.util.List;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public NoNetworkView f59621a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f59622b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f59623c;

    /* renamed from: d  reason: collision with root package name */
    public View f59624d;

    /* renamed from: e  reason: collision with root package name */
    public b f59625e;

    /* renamed from: f  reason: collision with root package name */
    public View f59626f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f59627g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f59628h;

    /* renamed from: i  reason: collision with root package name */
    public MemberTaskCenterActivity f59629i;

    public d(MemberTaskCenterActivity memberTaskCenterActivity, View.OnClickListener onClickListener) {
        this.f59629i = memberTaskCenterActivity;
        memberTaskCenterActivity.setContentView(R.layout.member_task_center_activity);
        this.f59624d = memberTaskCenterActivity.findViewById(R.id.root_view);
        this.f59621a = (NoNetworkView) memberTaskCenterActivity.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) memberTaskCenterActivity.findViewById(R.id.view_navigation_bar);
        this.f59622b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f59622b.setTitleText(R.string.member_task_center);
        this.f59623c = (BdListView) memberTaskCenterActivity.findViewById(R.id.member_task_list);
        this.f59626f = LayoutInflater.from(memberTaskCenterActivity.getActivity()).inflate(R.layout.member_task_center_header_view, (ViewGroup) null);
        BdListViewHelper.d(memberTaskCenterActivity.getActivity(), this.f59623c, BdListViewHelper.HeadType.DEFAULT);
        TbImageView tbImageView = (TbImageView) this.f59626f.findViewById(R.id.advert_image_view);
        this.f59627g = tbImageView;
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f59628h = (TextView) this.f59626f.findViewById(R.id.current_score_num);
        this.f59627g.setOnClickListener(onClickListener);
        b bVar = new b(memberTaskCenterActivity);
        this.f59625e = bVar;
        bVar.d(onClickListener);
        this.f59623c.addHeaderView(this.f59626f);
        this.f59623c.setAdapter((ListAdapter) this.f59625e);
    }

    public final SpannableString a(String str, String str2) {
        SpannableString spannableString = new SpannableString(str + str2);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, str.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), str.length(), spannableString.length(), 33);
        return spannableString;
    }

    public BdListView b() {
        return this.f59623c;
    }

    public View c() {
        return this.f59624d;
    }

    public void d(int i2) {
        this.f59622b.onChangeSkinType(this.f59629i.getPageContext(), i2);
        this.f59621a.c(this.f59629i.getPageContext(), i2);
        SkinManager.setBackgroundColor(this.f59628h, R.color.CAM_X0205);
    }

    public void e(String str, List<r> list, long j) {
        this.f59627g.V(str, 10, false);
        this.f59628h.setText(a(this.f59629i.getResources().getString(R.string.current_score), String.valueOf(j)));
        this.f59625e.c(list);
        this.f59625e.notifyDataSetChanged();
    }
}
