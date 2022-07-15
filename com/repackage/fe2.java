package com.repackage;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.he2;
/* loaded from: classes6.dex */
public class fe2 extends ce2<he2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final he2.f h;

    /* loaded from: classes6.dex */
    public class a implements he2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fe2 a;

        public a(fe2 fe2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fe2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fe2Var;
        }

        @Override // com.repackage.he2.f
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onCustomKeyboardHide", null);
        }

        @Override // com.repackage.he2.f
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onCustomKeyboardShow", Integer.valueOf(i));
        }

        @Override // com.repackage.he2.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "committext", str);
        }

        @Override // com.repackage.he2.f
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "deletebutton", new KeyEvent(0, 67));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fe2(@NonNull he2 he2Var) {
        super(he2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {he2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ee2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        he2Var.D0(aVar);
        this.a.a(new me2());
        this.a.a(new ie2());
        this.a.a(new le2());
        this.a.a(new ke2());
        this.a.a(new je2());
    }
}
