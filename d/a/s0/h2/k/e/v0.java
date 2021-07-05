package d.a.s0.h2.k.e;

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
/* loaded from: classes9.dex */
public class v0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.s0.a4.c f60758a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.s0.a4.c f60759b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f60760c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f60761d;

    /* renamed from: e  reason: collision with root package name */
    public PostWriteCallBackData f60762e;

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
        d.a.s0.a4.c cVar = new d.a.s0.a4.c();
        this.f60758a = cVar;
        cVar.j(R.color.CAM_X0101);
        this.f60758a.h(R.color.cp_cont_h_alpha85);
        d.a.s0.a4.c cVar2 = new d.a.s0.a4.c();
        this.f60759b = cVar2;
        cVar2.j(R.color.CAM_X0101);
        this.f60759b.h(R.color.cp_cont_h_alpha85);
    }

    public void a(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (editText = this.f60760c) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f60760c.getSelectionEnd();
        SpannableStringBuilder f2 = this.f60758a.f(this.f60760c.getText());
        if (f2 != null) {
            this.f60758a.l(true);
            this.f60760c.setText(f2);
            if (z && this.f60758a.b() >= 0) {
                this.f60760c.requestFocus();
                this.f60760c.setSelection(this.f60758a.b());
            } else {
                this.f60760c.setSelection(selectionEnd);
            }
            d.a.s0.a4.c cVar = this.f60758a;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void b(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (editText = this.f60761d) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f60761d.getSelectionEnd();
        SpannableStringBuilder f2 = this.f60759b.f(this.f60761d.getText());
        if (f2 != null) {
            this.f60759b.l(true);
            this.f60761d.setText(f2);
            if (z && this.f60759b.b() >= 0) {
                this.f60761d.requestFocus();
                this.f60761d.setSelection(this.f60759b.b());
            } else {
                this.f60761d.setSelection(selectionEnd);
            }
            d.a.s0.a4.c cVar = this.f60759b;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f60758a.n(null);
            this.f60758a.i(null);
            this.f60758a.k(false);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f60759b.n(null);
            this.f60759b.i(null);
            this.f60759b.k(false);
        }
    }

    public d.a.s0.a4.c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f60758a : (d.a.s0.a4.c) invokeV.objValue;
    }

    public EditText f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f60761d : (EditText) invokeV.objValue;
    }

    public d.a.s0.a4.c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f60759b : (d.a.s0.a4.c) invokeV.objValue;
    }

    public PostWriteCallBackData h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f60762e : (PostWriteCallBackData) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f60758a.g();
            this.f60759b.g();
            if (this.f60758a.d()) {
                a(false);
            }
            if (this.f60759b.d()) {
                b(false);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f60760c = null;
            this.f60761d = null;
        }
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f60758a.i(postWriteCallBackData.getSensitiveWords());
        this.f60758a.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f60758a.a())) {
            return;
        }
        a(true);
        this.f60762e = postWriteCallBackData;
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f60759b.i(postWriteCallBackData.getSensitiveWords());
        this.f60759b.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f60759b.a())) {
            return;
        }
        b(true);
    }

    public void m(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, editText) == null) {
            this.f60760c = editText;
        }
    }

    public void n(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, editText) == null) {
            this.f60761d = editText;
        }
    }
}
