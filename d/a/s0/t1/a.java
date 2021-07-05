package d.a.s0.t1;

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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SearchMajorActivity f65563a;

    /* renamed from: b  reason: collision with root package name */
    public View f65564b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f65565c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f65566d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f65567e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f65568f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f65569g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f65570h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayoutManager f65571i;
    public SearchMajorResultItemAdapter j;
    public LinearLayout k;

    /* renamed from: d.a.s0.t1.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnTouchListenerC1686a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f65572e;

        public View$OnTouchListenerC1686a(a aVar) {
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
            this.f65572e = aVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    this.f65572e.f65566d.setFocusable(true);
                    this.f65572e.f65566d.setFocusableInTouchMode(true);
                    if (this.f65572e.f65567e.hasFocus()) {
                        l.x(this.f65572e.f65563a, this.f65572e.f65567e);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f65573e;

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
            this.f65573e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f65573e.f65567e.setText("");
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
        this.f65564b = view;
        this.f65563a = searchMajorActivity;
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
            NavigationBar navigationBar = (NavigationBar) this.f65564b.findViewById(R.id.navigation_bar);
            this.f65565c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f65565c.setCenterTextTitle(this.f65563a.getResources().getString(R.string.search_major));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.f65564b.findViewById(R.id.search_container);
            this.f65566d = relativeLayout;
            relativeLayout.setOnTouchListener(new View$OnTouchListenerC1686a(this));
            this.f65569g = (ImageView) this.f65564b.findViewById(R.id.search_icon);
            this.f65567e = (EditText) this.f65564b.findViewById(R.id.search_box);
            ImageView imageView = (ImageView) this.f65564b.findViewById(R.id.search_del);
            this.f65568f = imageView;
            imageView.setOnClickListener(new b(this));
            k(false);
            this.f65567e.setText("");
            this.f65567e.requestFocus();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k = (LinearLayout) this.f65564b.findViewById(R.id.layout_container);
            this.f65570h = (RecyclerView) this.f65564b.findViewById(R.id.rv_major_list);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f65563a);
            this.f65571i = linearLayoutManager;
            this.f65570h.setLayoutManager(linearLayoutManager);
            SearchMajorResultItemAdapter searchMajorResultItemAdapter = new SearchMajorResultItemAdapter(this.f65563a);
            this.j = searchMajorResultItemAdapter;
            this.f65570h.setAdapter(searchMajorResultItemAdapter);
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
            this.f65565c.onChangeSkinType(this.f65563a.getPageContext(), i2);
            this.f65567e.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.f65567e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f65569g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
            SkinManager.setBackgroundResource(this.f65566d, R.drawable.search_major_bg);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f65568f, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || StringUtils.isNull(this.f65567e.getText().toString())) {
            return;
        }
        this.f65566d.setFocusable(true);
        this.f65566d.setFocusableInTouchMode(true);
        this.f65566d.requestFocus();
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f65568f.setVisibility(z ? 0 : 8);
        }
    }

    public void l(List<String> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, str) == null) {
            this.f65570h.setVisibility(0);
            SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.j;
            if (searchMajorResultItemAdapter != null) {
                searchMajorResultItemAdapter.h(str);
                this.j.setData(list);
                this.f65570h.setAdapter(this.j);
            }
        }
    }

    public void m(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, errorData) == null) {
            this.f65570h.setVisibility(8);
            SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.j;
            if (searchMajorResultItemAdapter != null) {
                searchMajorResultItemAdapter.m();
            }
        }
    }

    public void n(SearchMajorResultItemAdapter.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.j.n(bVar);
        }
    }

    public void o(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onScrollListener) == null) {
            this.f65570h.addOnScrollListener(onScrollListener);
        }
    }

    public void p(TextView.OnEditorActionListener onEditorActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onEditorActionListener) == null) {
            this.f65567e.setOnEditorActionListener(onEditorActionListener);
        }
    }

    public void q(View.OnFocusChangeListener onFocusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onFocusChangeListener) == null) {
            this.f65567e.setOnFocusChangeListener(onFocusChangeListener);
        }
    }

    public void r(TextWatcher textWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, textWatcher) == null) {
            this.f65567e.addTextChangedListener(textWatcher);
        }
    }
}
