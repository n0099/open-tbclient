package d.a.s0.i2.c;

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
/* loaded from: classes9.dex */
public class e extends d.a.c.a.d<PraiseListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f62013a;

    /* renamed from: b  reason: collision with root package name */
    public PraiseListActivity f62014b;

    /* renamed from: c  reason: collision with root package name */
    public View f62015c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f62016d;

    /* renamed from: e  reason: collision with root package name */
    public View f62017e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f62018f;

    /* renamed from: g  reason: collision with root package name */
    public View f62019g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f62020h;

    /* renamed from: i  reason: collision with root package name */
    public BdListView f62021i;
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
        this.f62013a = null;
        this.f62014b = null;
        this.f62015c = null;
        this.f62016d = null;
        this.f62017e = null;
        this.f62018f = null;
        this.f62019g = null;
        this.f62020h = null;
        this.f62021i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.f62014b = praiseListActivity;
        praiseListActivity.setContentView(R.layout.zan_list_activity);
        this.f62015c = praiseListActivity.findViewById(R.id.zan_list_page_parent);
        this.f62016d = (NavigationBar) praiseListActivity.findViewById(R.id.zan_list_page_navigationbar);
        this.f62017e = praiseListActivity.findViewById(R.id.zan_list_page_frame);
        this.f62018f = NoDataViewFactory.a(this.f62014b.getPageContext().getContext(), this.f62015c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f62014b.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.praise_list_no_data), null);
        this.f62021i = (BdListView) praiseListActivity.findViewById(R.id.zan_list_page_list);
        TextView textView = new TextView(this.f62014b.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.f62021i.x(textView, 0);
        this.m = (ProgressBar) praiseListActivity.findViewById(R.id.zan_list_page_progress);
        c cVar = new c(praiseListActivity);
        this.f62013a = cVar;
        this.f62021i.setAdapter((ListAdapter) cVar);
        this.f62021i.setOnScrollListener(this.f62013a);
        this.f62016d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f62016d.setTitleText("");
        View inflate = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_head, (ViewGroup) null);
        this.f62019g = inflate;
        inflate.setOnClickListener(praiseListActivity);
        TextView textView2 = (TextView) this.f62019g.findViewById(R.id.zan_list_head_text);
        this.f62020h = textView2;
        textView2.setText(str);
        this.f62019g.setVisibility(8);
        this.f62021i.addHeaderView(this.f62019g);
        View inflate2 = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(R.layout.zan_list_foot, (ViewGroup) null);
        this.j = inflate2;
        this.k = (TextView) inflate2.findViewById(R.id.zan_list_foot_text_continue);
        this.l = (TextView) this.j.findViewById(R.id.zan_list_foot_text_more);
        this.n = (ProgressBar) this.j.findViewById(R.id.zan_list_foot_progress);
        this.j.setVisibility(8);
        this.k.setOnClickListener(praiseListActivity);
        this.f62021i.addFooterView(this.j);
        this.f62021i.setOnItemClickListener(praiseListActivity);
    }

    public void d(d.a.r0.r.c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) || cVar == null) {
            return;
        }
        cVar.k(i2 == 1);
        cVar.j(this.f62015c);
        cVar.j(this.f62019g);
        cVar.j(this.j);
        this.f62016d.onChangeSkinType(this.f62014b.getPageContext(), i2);
        SkinManager.setBackgroundResource(this.j, R.drawable.bg_pack);
        NoDataView noDataView = this.f62018f;
        if (noDataView != null) {
            noDataView.f(this.f62014b.getPageContext(), i2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f62019g : (View) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m.getVisibility() == 0 || this.n.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void i() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.f62013a) == null) {
            return;
        }
        cVar.notifyDataSetChanged();
    }

    public void k(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i2) == null) {
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.f62017e.setVisibility(8);
            this.f62018f.setVisibility(0);
            if (!StringUtils.isNull(str)) {
                this.f62018f.setTextOption(NoDataViewFactory.e.c(str));
            } else if (1 == i2) {
                this.f62018f.setTextOption(NoDataViewFactory.e.a(R.string.graffiti_list_no_data));
            } else {
                this.f62018f.setTextOption(NoDataViewFactory.e.a(R.string.praise_list_no_data));
            }
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                this.n.setVisibility(0);
            } else {
                this.m.setVisibility(0);
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.m.setVisibility(8);
            this.n.setVisibility(8);
        }
    }

    public void n(int i2, List<a> list, int i3, int i4) {
        String format;
        String format2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), list, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.f62019g.setVisibility(0);
            if (i2 > 0) {
                PraiseListActivity praiseListActivity = this.f62014b;
                if (praiseListActivity.pageType != 1) {
                    format2 = String.format(praiseListActivity.getResources().getString(R.string.praise_list_title_count), StringHelper.numFormatOverWan(i2));
                } else {
                    format2 = String.format(praiseListActivity.getResources().getString(R.string.graffiti_list_title_count), StringHelper.numFormatOverWan(i2));
                }
                this.f62016d.setTitleText(format2);
            } else {
                this.f62016d.setTitleText("");
            }
            if (list != null && list.size() >= 1) {
                this.f62017e.setVisibility(0);
                this.f62018f.setVisibility(8);
                this.f62013a.c(list);
                this.f62013a.notifyDataSetChanged();
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
                        PraiseListActivity praiseListActivity2 = this.f62014b;
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
            k(null, this.f62014b.pageType);
        }
    }
}
