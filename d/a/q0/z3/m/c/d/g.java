package d.a.q0.z3.m.c.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f67578a;

    /* renamed from: b  reason: collision with root package name */
    public l f67579b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.z3.m.c.d.b f67580c;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f67581a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f67582b;

        /* renamed from: c  reason: collision with root package name */
        public int f67583c;

        /* renamed from: d  reason: collision with root package name */
        public l f67584d;

        /* renamed from: e  reason: collision with root package name */
        public d.a.q0.z3.m.c.d.b f67585e;

        public b() {
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
            this.f67581a = "";
            this.f67582b = true;
            this.f67583c = 0;
            this.f67584d = null;
            this.f67585e = null;
        }

        public g d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                e();
                return new g(this, null);
            }
            return (g) invokeV.objValue;
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (TextUtils.isEmpty(this.f67581a)) {
                    this.f67581a = FileHelper.getVideoTmpDir() + File.separator + "shaft_images";
                }
                if (this.f67583c <= 0) {
                    this.f67583c = ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8;
                }
                if (this.f67584d == null) {
                    this.f67584d = new l(this.f67583c);
                }
                if (this.f67585e == null) {
                    this.f67585e = new d.a.q0.z3.m.c.d.b(this.f67581a);
                }
            }
        }
    }

    public /* synthetic */ g(b bVar, a aVar) {
        this(bVar);
    }

    public g(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        String unused = bVar.f67581a;
        this.f67578a = bVar.f67582b;
        int unused2 = bVar.f67583c;
        this.f67579b = bVar.f67584d;
        this.f67580c = bVar.f67585e;
    }
}
