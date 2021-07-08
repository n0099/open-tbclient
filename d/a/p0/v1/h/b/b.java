package d.a.p0.v1.h.b;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.w.m;
import d.a.p0.v1.h.b.c.d;
import d.a.p0.v1.h.f.c;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public EditText f65247a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f65248b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f65249c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f65250d;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity<?> f65251e;

    /* renamed from: f  reason: collision with root package name */
    public Window f65252f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f65253g;

    /* renamed from: h  reason: collision with root package name */
    public EditorTools f65254h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f65255i;
    public ProgressBar j;

    public b(BaseActivity<?> baseActivity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, onClickListener, onClickListener2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65251e = baseActivity;
        Window window = baseActivity.getWindow();
        this.f65252f = window;
        this.f65250d = (ViewGroup) window.findViewById(R.id.tail_edit_root);
        this.f65247a = (EditText) this.f65252f.findViewById(R.id.tail_edit_edittext);
        ImageView imageView = (ImageView) this.f65252f.findViewById(R.id.tail_edit_submit);
        this.f65248b = imageView;
        imageView.setOnClickListener(onClickListener);
        ImageView imageView2 = (ImageView) this.f65252f.findViewById(R.id.tail_edit_cancel);
        this.f65253g = imageView2;
        imageView2.setOnClickListener(onClickListener2);
        this.f65249c = (TextView) this.f65252f.findViewById(R.id.tail_edit_text_number);
        this.f65255i = (FrameLayout) this.f65252f.findViewById(R.id.tail_edit_editor);
        this.j = (ProgressBar) this.f65252f.findViewById(R.id.tail_edit_progress);
    }

    public void a(d.a.o0.w.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, str) == null) {
            this.f65254h = new EditorTools(this.f65251e.getPageContext().getPageActivity());
            d();
            c(bVar);
            b(bVar, str);
            this.f65254h.f();
            this.f65254h.A(new d.a.o0.w.a(35, 5, Boolean.FALSE));
            this.f65254h.j();
            o(this.f65254h);
        }
    }

    public final void b(d.a.o0.w.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, str) == null) {
            this.f65254h.d(new d(this.f65251e.getPageContext(), 2, str));
            this.f65254h.setActionListener(26, bVar);
            this.f65254h.setActionListener(3, bVar);
        }
    }

    public final void c(d.a.o0.w.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            this.f65254h.h(arrayList);
            m n = this.f65254h.n(5);
            if (n != null) {
                n.j = 1;
                n.f(false);
            }
            this.f65254h.setActionListener(24, bVar);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f65254h.setBarMaxLauCount(4);
            this.f65254h.setBarLauncherType(1);
            this.f65254h.C(true);
            this.f65254h.setBackgroundColorId(R.color.CAM_X0201);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f65247a.getSelectionStart() <= 0) {
            return;
        }
        String substring = this.f65247a.getText().toString().substring(0, this.f65247a.getSelectionStart());
        Matcher matcher = Pattern.compile("#\\([^#\\)\\(]+\\)$").matcher(substring);
        int i2 = 1;
        if (matcher.find()) {
            i2 = substring.length() - matcher.replaceFirst("").length();
        }
        this.f65247a.getText().delete(this.f65247a.getSelectionStart() - i2, this.f65247a.getSelectionStart());
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f65251e.ShowSoftKeyPadDelay(this.f65247a);
            EditText editText = this.f65247a;
            editText.setSelection(editText.length());
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f65247a.getText().toString() : (String) invokeV.objValue;
    }

    public EditText h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f65247a : (EditText) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.j.setVisibility(8);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f65254h.q();
            this.f65254h.A(new d.a.o0.w.a(5, -1, null));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            EditText editText = this.f65247a;
            editText.setSelection(editText.length());
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f65251e.getLayoutMode().k(i2 == 1);
            this.f65251e.getLayoutMode().j(this.f65250d);
            this.f65254h.w(i2);
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f65247a.setTextColor(c.a(str));
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f65247a.setText(TbFaceManager.e().l(this.f65251e.getPageContext().getPageActivity(), str, null));
        }
    }

    public void o(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, editorTools) == null) {
            this.f65255i.addView(editorTools, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f65248b.setEnabled(z);
        }
    }

    public void q(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) {
            TextView textView = this.f65249c;
            textView.setText(i2 + "/" + i3);
            int i4 = R.color.CAM_X0109;
            if (i2 == i3) {
                i4 = R.color.CAM_X0301;
            }
            SkinManager.setViewTextColor(this.f65249c, i4, 1);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.j.setVisibility(0);
        }
    }

    public void s(TailData tailData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, tailData) == null) || tailData == null) {
            return;
        }
        n(tailData.getContent());
        m(tailData.getFontColor());
    }
}
