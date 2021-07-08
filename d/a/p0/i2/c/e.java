package d.a.p0.i2.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.pbextra.praise.PraiseListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import d.a.c.e.p.l;
import java.util.List;
/* loaded from: classes8.dex */
public class e extends d.a.c.a.d<PraiseListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f58778a;

    /* renamed from: b  reason: collision with root package name */
    public PraiseListActivity f58779b;

    /* renamed from: c  reason: collision with root package name */
    public View f58780c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f58781d;

    /* renamed from: e  reason: collision with root package name */
    public View f58782e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f58783f;

    /* renamed from: g  reason: collision with root package name */
    public View f58784g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f58785h;

    /* renamed from: i  reason: collision with root package name */
    public BdListView f58786i;
    public View j;
    public TextView k;
    public TextView l;
    public ProgressBar m;
    public ProgressBar n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {praiseListActivity, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58778a = null;
        this.f58779b = null;
        this.f58780c = null;
        this.f58781d = null;
        this.f58782e = null;
        this.f58783f = null;
        this.f58784g = null;
        this.f58785h = null;
        this.f58786i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.f58779b = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.f58780c = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.f58781d = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.f58782e = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.f58783f = NoDataViewFactory.a(this.f58779b.getPageContext().getContext(), this.f58780c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f58779b.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.praise_list_no_data), null);
        this.f58786i = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.f58779b.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.f58786i.x(textView, 0);
        this.m = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        c cVar = new c(praiseListActivity);
        this.f58778a = cVar;
        this.f58786i.setAdapter((ListAdapter) cVar);
        this.f58786i.setOnScrollListener(this.f58778a);
        this.f58781d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58781d.setTitleText("");
        View inflate = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.f58784g = inflate;
        inflate.setOnClickListener(praiseListActivity);
        TextView textView2 = (TextView) this.f58784g.findViewById(R.id.zan_list_head_text);
        this.f58785h = textView2;
        textView2.setText(str);
        this.f58784g.setVisibility(8);
        this.f58786i.addHeaderView(this.f58784g);
        View inflate2 = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.j = inflate2;
        this.k = (TextView) inflate2.findViewById(R.id.zan_list_foot_text_continue);
        this.l = (TextView) this.j.findViewById(R.id.zan_list_foot_text_more);
        this.n = (ProgressBar) this.j.findViewById(R.id.zan_list_foot_progress);
        this.j.setVisibility(8);
        this.k.setOnClickListener(praiseListActivity);
        this.f58786i.addFooterView(this.j);
        this.f58786i.setOnItemClickListener(praiseListActivity);
    }

    public void d(d.a.o0.r.c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) || cVar == null) {
            return;
        }
        cVar.k(i2 == 1);
        cVar.j(this.f58780c);
        cVar.j(this.f58784g);
        cVar.j(this.j);
        this.f58781d.onChangeSkinType(this.f58779b.getPageContext(), i2);
        SkinManager.setBackgroundResource(this.j, R.drawable.bg_pack);
        NoDataView noDataView = this.f58783f;
        if (noDataView != null) {
            noDataView.f(this.f58779b.getPageContext(), i2);
        }
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : (View) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f58784g : (View) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m.getVisibility() == 0 || this.n.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void h() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.f58778a) == null) {
            return;
        }
        cVar.notifyDataSetChanged();
    }

    public void j(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i2) == null) {
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.f58782e.setVisibility(8);
            this.f58783f.setVisibility(0);
            if (!StringUtils.isNull(str)) {
                this.f58783f.setTextOption(NoDataViewFactory.e.c(str));
            } else if (1 == i2) {
                this.f58783f.setTextOption(NoDataViewFactory.e.a(R.string.graffiti_list_no_data));
            } else {
                this.f58783f.setTextOption(NoDataViewFactory.e.a(R.string.praise_list_no_data));
            }
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                this.n.setVisibility(0);
            } else {
                this.m.setVisibility(0);
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.m.setVisibility(8);
            this.n.setVisibility(8);
        }
    }

    public void m(int i2, List<a> list, int i3, int i4) {
        String format;
        String format2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), list, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.f58784g.setVisibility(0);
            if (i2 > 0) {
                PraiseListActivity praiseListActivity = this.f58779b;
                if (praiseListActivity.pageType != 1) {
                    format2 = String.format(praiseListActivity.getResources().getString(R.string.praise_list_title_count), StringHelper.numFormatOverWan(i2));
                } else {
                    format2 = String.format(praiseListActivity.getResources().getString(R.string.graffiti_list_title_count), StringHelper.numFormatOverWan(i2));
                }
                this.f58781d.setTitleText(format2);
            } else {
                this.f58781d.setTitleText("");
            }
            if (list != null && list.size() >= 1) {
                this.f58782e.setVisibility(0);
                this.f58783f.setVisibility(8);
                this.f58778a.c(list);
                this.f58778a.notifyDataSetChanged();
                switch (i3) {
                    case 1001:
                        this.j.setVisibility(0);
                        this.k.setVisibility(0);
                        this.l.setVisibility(8);
                        return;
                    case 1002:
                        this.j.setVisibility(8);
                        return;
                    case 1003:
                        this.j.setVisibility(0);
                        SkinManager.setBackgroundResource(this.j, R.drawable.bg_pack);
                        this.k.setVisibility(8);
                        this.l.setVisibility(0);
                        PraiseListActivity praiseListActivity2 = this.f58779b;
                        if (praiseListActivity2.pageType != 1) {
                            format = String.format(praiseListActivity2.getResources().getString(R.string.praise_item_more), StringHelper.numFormatOverWan(i2));
                        } else {
                            format = String.format(praiseListActivity2.getResources().getString(R.string.graffiti_list_title_count), StringHelper.numFormatOverWan(i2));
                        }
                        this.l.setText(format);
                        return;
                    default:
                        this.j.setVisibility(8);
                        return;
                }
            }
            j(null, this.f58779b.pageType);
        }
    }
}
