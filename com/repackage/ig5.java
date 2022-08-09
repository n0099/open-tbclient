package com.repackage;

import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ig5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public ImageView b;
    public mg5 c;
    public b d;
    public final jg<zm> e;

    /* loaded from: classes6.dex */
    public class a extends jg<zm> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ig5 a;

        public a(ig5 ig5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ig5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ig5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jg
        public void onLoaded(zm zmVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, zmVar, str, i) == null) {
                super.onLoaded((a) zmVar, str, i);
                if (StringUtils.isNull(str) || this.a.c == null || !this.a.c.isValid()) {
                    return;
                }
                if (str.equals(this.a.c.a())) {
                    this.a.b.setImageDrawable(zmVar.j());
                }
                if (str.equals(this.a.c.d())) {
                    this.a.a.setImageDrawable(zmVar.j());
                }
                this.a.c.b(str);
                if (!this.a.c.e() || this.a.d == null) {
                    return;
                }
                this.a.d.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a();
    }

    public ig5(ImageView imageView, ImageView imageView2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageView, imageView2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new a(this);
        this.a = imageView;
        this.b = imageView2;
    }

    public void e() {
        mg5 mg5Var;
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (mg5Var = this.c) != null && mg5Var.isValid() && this.c.e() && (bVar = this.d) != null) {
            bVar.a();
        }
    }

    public void f(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.d = bVar;
        }
    }

    public void g(mg5 mg5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mg5Var) == null) && mg5Var != null && mg5Var.isValid()) {
            this.c = mg5Var;
            kg.h().m(this.c.a(), 10, this.e, null);
            kg.h().m(this.c.d(), 10, this.e, null);
        }
    }
}
