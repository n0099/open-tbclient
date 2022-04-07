package com.repackage;

import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class z8<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b9<T> mContext;
    public InputMethodManager mInputManager;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public final /* synthetic */ z8 b;

        public a(z8 z8Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z8Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z8Var;
            this.a = null;
            this.a = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b9<T> b9Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (b9Var = this.b.mContext) == null || b9Var.getPageActivity() == null || this.b.mContext.getPageActivity().isFinishing()) {
                return;
            }
            this.b.ShowSoftKeyPad(this.a);
        }
    }

    public z8(b9<T> b9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = null;
        this.mInputManager = null;
        this.mContext = b9Var;
    }

    public void HidenSoftKeyPad(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            try {
                if (this.mInputManager == null) {
                    getInputMethodManager();
                }
                if (this.mInputManager != null && view2 != null) {
                    this.mInputManager.hideSoftInputFromWindow(view2.getWindowToken(), 2);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void ShowSoftKeyPad(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            try {
                getInputMethodManager().showSoftInput(view2, 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void ShowSoftKeyPadDelay(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view2, i) == null) {
            new Handler().postDelayed(new a(this, view2), i);
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public InputMethodManager getInputMethodManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mInputManager == null) {
                this.mInputManager = (InputMethodManager) this.mContext.getContext().getSystemService("input_method");
            }
            return this.mInputManager;
        }
        return (InputMethodManager) invokeV.objValue;
    }

    public b9<T> getPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mContext : (b9) invokeV.objValue;
    }

    public void setInputMethodManager(InputMethodManager inputMethodManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, inputMethodManager) == null) {
            this.mInputManager = inputMethodManager;
        }
    }
}
