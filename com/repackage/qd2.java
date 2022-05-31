package com.repackage;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pd2;
/* loaded from: classes6.dex */
public class qd2 extends cd2<pd2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements pd2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qd2 a;

        public a(qd2 qd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qd2Var;
        }

        @Override // com.repackage.pd2.a
        public void a(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onMediaMetadataExtracted", bundle);
        }

        @Override // com.repackage.pd2.a
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qd2(@NonNull pd2 pd2Var) {
        super(pd2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pd2Var};
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
        ((pd2) this.c).w(new a(this));
        this.a.a(new sd2());
        this.a.a(new td2());
    }
}
