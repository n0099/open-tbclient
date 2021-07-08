package d.a.p0.h2.k.e;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class v0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.p0.a4.c f57514a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.p0.a4.c f57515b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f57516c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f57517d;

    /* renamed from: e  reason: collision with root package name */
    public PostWriteCallBackData f57518e;

    public v0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        d.a.p0.a4.c cVar = new d.a.p0.a4.c();
        this.f57514a = cVar;
        cVar.j(R.color.CAM_X0101);
        this.f57514a.h(R.color.cp_cont_h_alpha85);
        d.a.p0.a4.c cVar2 = new d.a.p0.a4.c();
        this.f57515b = cVar2;
        cVar2.j(R.color.CAM_X0101);
        this.f57515b.h(R.color.cp_cont_h_alpha85);
    }

    public void a(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (editText = this.f57516c) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f57516c.getSelectionEnd();
        SpannableStringBuilder f2 = this.f57514a.f(this.f57516c.getText());
        if (f2 != null) {
            this.f57514a.l(true);
            this.f57516c.setText(f2);
            if (z && this.f57514a.b() >= 0) {
                this.f57516c.requestFocus();
                this.f57516c.setSelection(this.f57514a.b());
            } else {
                this.f57516c.setSelection(selectionEnd);
            }
            d.a.p0.a4.c cVar = this.f57514a;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void b(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (editText = this.f57517d) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f57517d.getSelectionEnd();
        SpannableStringBuilder f2 = this.f57515b.f(this.f57517d.getText());
        if (f2 != null) {
            this.f57515b.l(true);
            this.f57517d.setText(f2);
            if (z && this.f57515b.b() >= 0) {
                this.f57517d.requestFocus();
                this.f57517d.setSelection(this.f57515b.b());
            } else {
                this.f57517d.setSelection(selectionEnd);
            }
            d.a.p0.a4.c cVar = this.f57515b;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f57514a.n(null);
            this.f57514a.i(null);
            this.f57514a.k(false);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f57515b.n(null);
            this.f57515b.i(null);
            this.f57515b.k(false);
        }
    }

    public d.a.p0.a4.c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f57514a : (d.a.p0.a4.c) invokeV.objValue;
    }

    public EditText f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f57517d : (EditText) invokeV.objValue;
    }

    public d.a.p0.a4.c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f57515b : (d.a.p0.a4.c) invokeV.objValue;
    }

    public PostWriteCallBackData h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f57518e : (PostWriteCallBackData) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f57514a.g();
            this.f57515b.g();
            if (this.f57514a.d()) {
                a(false);
            }
            if (this.f57515b.d()) {
                b(false);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f57516c = null;
            this.f57517d = null;
        }
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f57514a.i(postWriteCallBackData.getSensitiveWords());
        this.f57514a.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f57514a.a())) {
            return;
        }
        a(true);
        this.f57518e = postWriteCallBackData;
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f57515b.i(postWriteCallBackData.getSensitiveWords());
        this.f57515b.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f57515b.a())) {
            return;
        }
        b(true);
    }

    public void m(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, editText) == null) {
            this.f57516c = editText;
        }
    }

    public void n(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, editText) == null) {
            this.f57517d = editText;
        }
    }
}
