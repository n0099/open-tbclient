package d.a.q0.h2.k.e;

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
    public d.a.q0.a4.c f58099a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.a4.c f58100b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f58101c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f58102d;

    /* renamed from: e  reason: collision with root package name */
    public PostWriteCallBackData f58103e;

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
        d.a.q0.a4.c cVar = new d.a.q0.a4.c();
        this.f58099a = cVar;
        cVar.j(R.color.CAM_X0101);
        this.f58099a.h(R.color.cp_cont_h_alpha85);
        d.a.q0.a4.c cVar2 = new d.a.q0.a4.c();
        this.f58100b = cVar2;
        cVar2.j(R.color.CAM_X0101);
        this.f58100b.h(R.color.cp_cont_h_alpha85);
    }

    public void a(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (editText = this.f58101c) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f58101c.getSelectionEnd();
        SpannableStringBuilder f2 = this.f58099a.f(this.f58101c.getText());
        if (f2 != null) {
            this.f58099a.l(true);
            this.f58101c.setText(f2);
            if (z && this.f58099a.b() >= 0) {
                this.f58101c.requestFocus();
                this.f58101c.setSelection(this.f58099a.b());
            } else {
                this.f58101c.setSelection(selectionEnd);
            }
            d.a.q0.a4.c cVar = this.f58099a;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void b(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (editText = this.f58102d) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f58102d.getSelectionEnd();
        SpannableStringBuilder f2 = this.f58100b.f(this.f58102d.getText());
        if (f2 != null) {
            this.f58100b.l(true);
            this.f58102d.setText(f2);
            if (z && this.f58100b.b() >= 0) {
                this.f58102d.requestFocus();
                this.f58102d.setSelection(this.f58100b.b());
            } else {
                this.f58102d.setSelection(selectionEnd);
            }
            d.a.q0.a4.c cVar = this.f58100b;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f58099a.n(null);
            this.f58099a.i(null);
            this.f58099a.k(false);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f58100b.n(null);
            this.f58100b.i(null);
            this.f58100b.k(false);
        }
    }

    public d.a.q0.a4.c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f58099a : (d.a.q0.a4.c) invokeV.objValue;
    }

    public EditText f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f58102d : (EditText) invokeV.objValue;
    }

    public d.a.q0.a4.c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f58100b : (d.a.q0.a4.c) invokeV.objValue;
    }

    public PostWriteCallBackData h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f58103e : (PostWriteCallBackData) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f58099a.g();
            this.f58100b.g();
            if (this.f58099a.d()) {
                a(false);
            }
            if (this.f58100b.d()) {
                b(false);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f58101c = null;
            this.f58102d = null;
        }
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f58099a.i(postWriteCallBackData.getSensitiveWords());
        this.f58099a.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f58099a.a())) {
            return;
        }
        a(true);
        this.f58103e = postWriteCallBackData;
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f58100b.i(postWriteCallBackData.getSensitiveWords());
        this.f58100b.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f58100b.a())) {
            return;
        }
        b(true);
    }

    public void m(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, editText) == null) {
            this.f58101c = editText;
        }
    }

    public void n(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, editText) == null) {
            this.f58102d = editText;
        }
    }
}
