package d.a.q0.r2;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.postsearch.PostSearchActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.s.s.a;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f62487a;

    /* renamed from: b  reason: collision with root package name */
    public View f62488b;

    /* renamed from: c  reason: collision with root package name */
    public View f62489c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f62490d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.s1.d f62491e;

    /* renamed from: f  reason: collision with root package name */
    public View f62492f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.s.s.a f62493g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f62494h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f62495i;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f62496e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62496e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f62496e.l();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f62497e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62497e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                TiebaStatic.log(new StatisticItem("c12403").param("fid", this.f62497e.f62487a.mForumId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", this.f62497e.f62487a.mForumName));
                String str = (String) this.f62497e.f62490d.getItemAtPosition(i2 + 1);
                this.f62497e.f62487a.setEditSearchText(str);
                this.f62497e.f62487a.startSearch(str);
                PostSearchActivity unused = this.f62497e.f62487a;
                TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", str).param("obj_source", "3").param("obj_type", "2").param("fid", this.f62497e.f62487a.mForumId));
            }
        }
    }

    /* renamed from: d.a.q0.r2.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnTouchListenerC1623c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f62498e;

        public View$OnTouchListenerC1623c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62498e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f62498e.f62487a.hideSoftKeyPad();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f62499e;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62499e = cVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f62499e.f62487a.getModel().g();
                this.f62499e.f62490d.setVisibility(8);
                this.f62499e.n();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f62500e;

        public f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62500e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f62500e.f62487a.hideSoftKeyPad();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public c(PostSearchActivity postSearchActivity, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {postSearchActivity, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62491e = null;
        this.f62492f = null;
        this.f62495i = false;
        this.f62487a = postSearchActivity;
        this.f62488b = view;
        h();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f62489c.setVisibility(8);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f62495i = false;
            this.f62487a.hideLoadingView(this.f62489c);
        }
    }

    public void g() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (noDataView = this.f62494h) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f62489c = this.f62487a.findViewById(R.id.history_frame);
            this.f62490d = (BdListView) this.f62488b.findViewById(R.id.history_list);
            BdListViewHelper.d(this.f62487a.getActivity(), this.f62490d, BdListViewHelper.HeadType.DEFAULT);
            d.a.q0.s1.d dVar = new d.a.q0.s1.d(this.f62487a.getPageContext().getPageActivity(), null);
            this.f62491e = dVar;
            dVar.b(false);
            this.f62490d.setAdapter((ListAdapter) this.f62491e);
            View inflate = LayoutInflater.from(this.f62487a.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
            this.f62492f = inflate;
            this.f62490d.addFooterView(inflate);
            this.f62492f.setOnClickListener(new a(this));
            this.f62490d.setOnItemClickListener(new b(this));
            this.f62490d.setOnTouchListener(new View$OnTouchListenerC1623c(this));
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f62489c.getVisibility() != 0 || this.f62495i) {
                return false;
            }
            NoDataView noDataView = this.f62494h;
            return noDataView == null || 8 == noDataView.getVisibility();
        }
        return invokeV.booleanValue;
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            d.a.p0.u0.a.a(this.f62487a.getPageContext(), this.f62492f);
            this.f62491e.notifyDataSetChanged();
            NoDataView noDataView = this.f62494h;
            if (noDataView != null) {
                noDataView.f(this.f62487a.getPageContext(), i2);
            }
        }
    }

    public void k(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f62489c.setVisibility(0);
            f();
            if (arrayList != null && arrayList.size() != 0) {
                g();
                this.f62490d.setVisibility(0);
                this.f62491e.a(arrayList);
                this.f62491e.notifyDataSetChanged();
                return;
            }
            this.f62490d.setVisibility(8);
            n();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f62493g == null) {
                this.f62493g = new d.a.p0.s.s.a(this.f62487a.getPageContext().getPageActivity()).setMessage(this.f62487a.getPageContext().getString(R.string.alert_clean_history)).setPositiveButton(this.f62487a.getPageContext().getString(R.string.clear_all_text), new e(this)).setNegativeButton(this.f62487a.getPageContext().getString(R.string.cancel), new d(this)).create(this.f62487a.getPageContext());
            }
            this.f62493g.show();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f62495i = true;
            PostSearchActivity postSearchActivity = this.f62487a;
            postSearchActivity.showLoadingView(this.f62489c, false, postSearchActivity.getResources().getDimensionPixelSize(R.dimen.ds386));
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            o(R.string.new_text_no_search_record);
        }
    }

    public final void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            if (this.f62494h == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f62487a.getPageContext().getPageActivity(), this.f62489c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f62487a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.text_no_search_record), null);
                this.f62494h = a2;
                a2.f(this.f62487a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                this.f62494h.setOnTouchListener(new f(this));
            }
            this.f62494h.setTextOption(NoDataViewFactory.e.d(null, this.f62487a.getResources().getString(i2)));
            this.f62494h.setVisibility(0);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f62490d.setVisibility(8);
            o(R.string.new_text_no_search_result);
        }
    }
}
