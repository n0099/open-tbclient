package com.repackage;

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
import java.util.List;
/* loaded from: classes6.dex */
public class fg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SearchMajorActivity a;
    public View b;
    public NavigationBar c;
    public RelativeLayout d;
    public EditText e;
    public ImageView f;
    public ImageView g;
    public RecyclerView h;
    public LinearLayoutManager i;
    public SearchMajorResultItemAdapter j;
    public LinearLayout k;

    /* loaded from: classes6.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fg7 a;

        public a(fg7 fg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fg7Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    this.a.d.setFocusable(true);
                    this.a.d.setFocusableInTouchMode(true);
                    if (this.a.e.hasFocus()) {
                        oi.w(this.a.a, this.a.e);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fg7 a;

        public b(fg7 fg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fg7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.e.setText("");
            }
        }
    }

    public fg7(View view2, SearchMajorActivity searchMajorActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, searchMajorActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = view2;
        this.a = searchMajorActivity;
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
            NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.obfuscated_res_0x7f091514);
            this.c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c.setCenterTextTitle(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f10a3));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091c12);
            this.d = relativeLayout;
            relativeLayout.setOnTouchListener(new a(this));
            this.g = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091c24);
            this.e = (EditText) this.b.findViewById(R.id.obfuscated_res_0x7f091c0f);
            ImageView imageView = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091c13);
            this.f = imageView;
            imageView.setOnClickListener(new b(this));
            k(false);
            this.e.setText("");
            this.e.requestFocus();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0911c6);
            this.h = (RecyclerView) this.b.findViewById(R.id.obfuscated_res_0x7f091af8);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a);
            this.i = linearLayoutManager;
            this.h.setLayoutManager(linearLayoutManager);
            SearchMajorResultItemAdapter searchMajorResultItemAdapter = new SearchMajorResultItemAdapter(this.a);
            this.j = searchMajorResultItemAdapter;
            this.h.setAdapter(searchMajorResultItemAdapter);
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

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.j;
            if (searchMajorResultItemAdapter != null) {
                searchMajorResultItemAdapter.notifyDataSetChanged();
            }
            this.c.onChangeSkinType(this.a.getPageContext(), i);
            this.e.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
            SkinManager.setBackgroundResource(this.d, R.drawable.search_major_bg);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.obfuscated_res_0x7f080985, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || StringUtils.isNull(this.e.getText().toString())) {
            return;
        }
        this.d.setFocusable(true);
        this.d.setFocusableInTouchMode(true);
        this.d.requestFocus();
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f.setVisibility(z ? 0 : 8);
        }
    }

    public void l(List<String> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, str) == null) {
            this.h.setVisibility(0);
            SearchMajorResultItemAdapter searchMajorResultItemAdapter = this.j;
            if (searchMajorResultItemAdapter != null) {
                searchMajorResultItemAdapter.h(str);
                this.j.setData(list);
                this.h.setAdapter(this.j);
            }
        }
    }

    public void m(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, errorData) == null) {
            this.h.setVisibility(8);
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
            this.h.addOnScrollListener(onScrollListener);
        }
    }

    public void p(TextView.OnEditorActionListener onEditorActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onEditorActionListener) == null) {
            this.e.setOnEditorActionListener(onEditorActionListener);
        }
    }

    public void q(View.OnFocusChangeListener onFocusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onFocusChangeListener) == null) {
            this.e.setOnFocusChangeListener(onFocusChangeListener);
        }
    }

    public void r(TextWatcher textWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, textWatcher) == null) {
            this.e.addTextChangedListener(textWatcher);
        }
    }
}
