package d.a.p0.t1;

import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.majorsearch.SearchMajorActivity;
import com.baidu.tieba.majorsearch.adapter.SearchMajorResultItemAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SearchMajorActivity f62344a;

    /* renamed from: b  reason: collision with root package name */
    public View f62345b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f62346c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f62347d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f62348e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f62349f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f62350g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f62351h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayoutManager f62352i;
    public SearchMajorResultItemAdapter j;
    public LinearLayout k;

    /* renamed from: d.a.p0.t1.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnTouchListenerC1645a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f62353e;

        public View$OnTouchListenerC1645a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62353e = aVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    this.f62353e.f62347d.setFocusable(true);
                    this.f62353e.f62347d.setFocusableInTouchMode(true);
                    if (this.f62353e.f62348e.hasFocus()) {
                        l.x(this.f62353e.f62344a, this.f62353e.f62348e);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f62354e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62354e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f62354e.f62348e.setText("");
            }
        }
    }

    public a(View view, SearchMajorActivity searchMajorActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, searchMajorActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62345b = view;
        this.f62344a = searchMajorActivity;
        h();
    }

    public LinearLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (LinearLayout) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f62345b.findViewById(R.id.navigation_bar);
            this.f62346c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f62346c.setCenterTextTitle(this.f62344a.getResources().getString(R.string.search_major));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.f62345b.findViewById(R.id.search_container);
            this.f62347d = relativeLayout;
            relativeLayout.setOnTouchListener(new View$OnTouchListenerC1645a(this));
            this.f62350g = (ImageView) this.f62345b.findViewById(R.id.search_icon);
            this.f62348e = (EditText) this.f62345b.findViewById(R.id.search_box);
            ImageView imageView = (ImageView) this.f62345b.findViewById(R.id.search_del);
            this.f62349f = imageView;
            imageView.setOnClickListener(new b(this));
            k(false);
            this.f62348e.setText("");
            this.f62348e.requestFocus();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k = (LinearLayout) this.f62345b.findViewById(R.id.layout_container);
            this.f62351h = (RecyclerView) this.f62345b.findViewById(R.id.rv_major_list);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f62344a);
            this.f62352i = linearLayoutManager;
            this.f62351h.setLayoutManager(linearLayoutManager);
            SearchMajorResultItemAdapter searchMajorResultItemAdapter = new SearchMajorResultItemAdapter(this.f62344a);
            this.j = searchMajorResultItemAdapter;
            this.f62351h.setAdapter(searchMajorResultItemAdapter);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            e();
            f();
            g();
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.j;
            if (searchMajorResultItemAdapter != null) {
                searchMajorResultItemAdapter.notifyDataSetChanged();
            }
            this.f62346c.onChangeSkinType(this.f62344a.getPageContext(), i2);
            this.f62348e.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.f62348e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f62350g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
            SkinManager.setBackgroundResource(this.f62347d, R.drawable.search_major_bg);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f62349f, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || StringUtils.isNull(this.f62348e.getText().toString())) {
            return;
        }
        this.f62347d.setFocusable(true);
        this.f62347d.setFocusableInTouchMode(true);
        this.f62347d.requestFocus();
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f62349f.setVisibility(z ? 0 : 8);
        }
    }

    public void l(List<String> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, str) == null) {
            this.f62351h.setVisibility(0);
            SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.j;
            if (searchMajorResultItemAdapter != null) {
                searchMajorResultItemAdapter.h(str);
                this.j.setData(list);
                this.f62351h.setAdapter(this.j);
            }
        }
    }

    public void m(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, errorData) == null) {
            this.f62351h.setVisibility(8);
            SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.j;
            if (searchMajorResultItemAdapter != null) {
                searchMajorResultItemAdapter.i();
            }
        }
    }

    public void n(SearchMajorResultItemAdapter.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.j.j(bVar);
        }
    }

    public void o(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onScrollListener) == null) {
            this.f62351h.addOnScrollListener(onScrollListener);
        }
    }

    public void p(TextView.OnEditorActionListener onEditorActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onEditorActionListener) == null) {
            this.f62348e.setOnEditorActionListener(onEditorActionListener);
        }
    }

    public void q(View.OnFocusChangeListener onFocusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onFocusChangeListener) == null) {
            this.f62348e.setOnFocusChangeListener(onFocusChangeListener);
        }
    }

    public void r(TextWatcher textWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, textWatcher) == null) {
            this.f62348e.addTextChangedListener(textWatcher);
        }
    }
}
