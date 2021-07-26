package d.a.q0.v1.h.b;

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
import d.a.p0.x.m;
import d.a.q0.v1.h.b.c.d;
import d.a.q0.v1.h.f.c;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public EditText f65895a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f65896b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f65897c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f65898d;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity<?> f65899e;

    /* renamed from: f  reason: collision with root package name */
    public Window f65900f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f65901g;

    /* renamed from: h  reason: collision with root package name */
    public EditorTools f65902h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f65903i;
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
        this.f65899e = baseActivity;
        Window window = baseActivity.getWindow();
        this.f65900f = window;
        this.f65898d = (ViewGroup) window.findViewById(R.id.tail_edit_root);
        this.f65895a = (EditText) this.f65900f.findViewById(R.id.tail_edit_edittext);
        ImageView imageView = (ImageView) this.f65900f.findViewById(R.id.tail_edit_submit);
        this.f65896b = imageView;
        imageView.setOnClickListener(onClickListener);
        ImageView imageView2 = (ImageView) this.f65900f.findViewById(R.id.tail_edit_cancel);
        this.f65901g = imageView2;
        imageView2.setOnClickListener(onClickListener2);
        this.f65897c = (TextView) this.f65900f.findViewById(R.id.tail_edit_text_number);
        this.f65903i = (FrameLayout) this.f65900f.findViewById(R.id.tail_edit_editor);
        this.j = (ProgressBar) this.f65900f.findViewById(R.id.tail_edit_progress);
    }

    public void a(d.a.p0.x.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, str) == null) {
            this.f65902h = new EditorTools(this.f65899e.getPageContext().getPageActivity());
            d();
            c(bVar);
            b(bVar, str);
            this.f65902h.f();
            this.f65902h.A(new d.a.p0.x.a(35, 5, Boolean.FALSE));
            this.f65902h.j();
            o(this.f65902h);
        }
    }

    public final void b(d.a.p0.x.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, str) == null) {
            this.f65902h.d(new d(this.f65899e.getPageContext(), 2, str));
            this.f65902h.setActionListener(26, bVar);
            this.f65902h.setActionListener(3, bVar);
        }
    }

    public final void c(d.a.p0.x.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            this.f65902h.h(arrayList);
            m n = this.f65902h.n(5);
            if (n != null) {
                n.j = 1;
                n.f(false);
            }
            this.f65902h.setActionListener(24, bVar);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f65902h.setBarMaxLauCount(4);
            this.f65902h.setBarLauncherType(1);
            this.f65902h.C(true);
            this.f65902h.setBackgroundColorId(R.color.CAM_X0201);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f65895a.getSelectionStart() <= 0) {
            return;
        }
        String substring = this.f65895a.getText().toString().substring(0, this.f65895a.getSelectionStart());
        Matcher matcher = Pattern.compile("#\\([^#\\)\\(]+\\)$").matcher(substring);
        int i2 = 1;
        if (matcher.find()) {
            i2 = substring.length() - matcher.replaceFirst("").length();
        }
        this.f65895a.getText().delete(this.f65895a.getSelectionStart() - i2, this.f65895a.getSelectionStart());
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f65899e.ShowSoftKeyPadDelay(this.f65895a);
            EditText editText = this.f65895a;
            editText.setSelection(editText.length());
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f65895a.getText().toString() : (String) invokeV.objValue;
    }

    public EditText h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f65895a : (EditText) invokeV.objValue;
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
            this.f65902h.q();
            this.f65902h.A(new d.a.p0.x.a(5, -1, null));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            EditText editText = this.f65895a;
            editText.setSelection(editText.length());
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f65899e.getLayoutMode().k(i2 == 1);
            this.f65899e.getLayoutMode().j(this.f65898d);
            this.f65902h.w(i2);
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f65895a.setTextColor(c.a(str));
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f65895a.setText(TbFaceManager.e().l(this.f65899e.getPageContext().getPageActivity(), str, null));
        }
    }

    public void o(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, editorTools) == null) {
            this.f65903i.addView(editorTools, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f65896b.setEnabled(z);
        }
    }

    public void q(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) {
            TextView textView = this.f65897c;
            textView.setText(i2 + "/" + i3);
            int i4 = R.color.CAM_X0109;
            if (i2 == i3) {
                i4 = R.color.CAM_X0301;
            }
            SkinManager.setViewTextColor(this.f65897c, i4, 1);
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
