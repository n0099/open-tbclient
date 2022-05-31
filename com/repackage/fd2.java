package com.repackage;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.hd2;
/* loaded from: classes5.dex */
public class fd2 extends cd2<hd2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final hd2.f h;

    /* loaded from: classes5.dex */
    public class a implements hd2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fd2 a;

        public a(fd2 fd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fd2Var;
        }

        @Override // com.repackage.hd2.f
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onCustomKeyboardHide", null);
        }

        @Override // com.repackage.hd2.f
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onCustomKeyboardShow", Integer.valueOf(i));
        }

        @Override // com.repackage.hd2.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "committext", str);
        }

        @Override // com.repackage.hd2.f
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "deletebutton", new KeyEvent(0, 67));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fd2(@NonNull hd2 hd2Var) {
        super(hd2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hd2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ed2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        hd2Var.D0(aVar);
        this.a.a(new md2());
        this.a.a(new id2());
        this.a.a(new ld2());
        this.a.a(new kd2());
        this.a.a(new jd2());
    }
}
