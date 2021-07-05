package d.a.s0.v1.e;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.v1.c.b.r;
import java.util.List;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NoNetworkView f68316a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f68317b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f68318c;

    /* renamed from: d  reason: collision with root package name */
    public View f68319d;

    /* renamed from: e  reason: collision with root package name */
    public b f68320e;

    /* renamed from: f  reason: collision with root package name */
    public View f68321f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f68322g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f68323h;

    /* renamed from: i  reason: collision with root package name */
    public MemberTaskCenterActivity f68324i;

    public d(MemberTaskCenterActivity memberTaskCenterActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memberTaskCenterActivity, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68324i = memberTaskCenterActivity;
        memberTaskCenterActivity.setContentView(R.layout.member_task_center_activity);
        this.f68319d = memberTaskCenterActivity.findViewById(R.id.root_view);
        this.f68316a = (NoNetworkView) memberTaskCenterActivity.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) memberTaskCenterActivity.findViewById(R.id.view_navigation_bar);
        this.f68317b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f68317b.setTitleText(R.string.member_task_center);
        this.f68318c = (BdListView) memberTaskCenterActivity.findViewById(R.id.member_task_list);
        this.f68321f = LayoutInflater.from(memberTaskCenterActivity.getActivity()).inflate(R.layout.member_task_center_header_view, (ViewGroup) null);
        BdListViewHelper.d(memberTaskCenterActivity.getActivity(), this.f68318c, BdListViewHelper.HeadType.DEFAULT);
        TbImageView tbImageView = (TbImageView) this.f68321f.findViewById(R.id.advert_image_view);
        this.f68322g = tbImageView;
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f68323h = (TextView) this.f68321f.findViewById(R.id.current_score_num);
        this.f68322g.setOnClickListener(onClickListener);
        b bVar = new b(memberTaskCenterActivity);
        this.f68320e = bVar;
        bVar.d(onClickListener);
        this.f68318c.addHeaderView(this.f68321f);
        this.f68318c.setAdapter((ListAdapter) this.f68320e);
    }

    public final SpannableString a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            SpannableString spannableString = new SpannableString(str + str2);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), str.length(), spannableString.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeLL.objValue;
    }

    public BdListView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f68318c : (BdListView) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f68319d : (View) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f68317b.onChangeSkinType(this.f68324i.getPageContext(), i2);
            this.f68316a.c(this.f68324i.getPageContext(), i2);
            SkinManager.setBackgroundColor(this.f68323h, R.color.CAM_X0205);
        }
    }

    public void e(String str, List<r> list, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, list, Long.valueOf(j)}) == null) {
            this.f68322g.M(str, 10, false);
            this.f68323h.setText(a(this.f68324i.getResources().getString(R.string.current_score), String.valueOf(j)));
            this.f68320e.c(list);
            this.f68320e.notifyDataSetChanged();
        }
    }
}
