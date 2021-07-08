package d.a.p0.z3.m.c.d;

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
    public boolean f66900a;

    /* renamed from: b  reason: collision with root package name */
    public l f66901b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.p0.z3.m.c.d.b f66902c;

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
        public String f66903a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f66904b;

        /* renamed from: c  reason: collision with root package name */
        public int f66905c;

        /* renamed from: d  reason: collision with root package name */
        public l f66906d;

        /* renamed from: e  reason: collision with root package name */
        public d.a.p0.z3.m.c.d.b f66907e;

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
            this.f66903a = "";
            this.f66904b = true;
            this.f66905c = 0;
            this.f66906d = null;
            this.f66907e = null;
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
                if (TextUtils.isEmpty(this.f66903a)) {
                    this.f66903a = FileHelper.getVideoTmpDir() + File.separator + "shaft_images";
                }
                if (this.f66905c <= 0) {
                    this.f66905c = ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8;
                }
                if (this.f66906d == null) {
                    this.f66906d = new l(this.f66905c);
                }
                if (this.f66907e == null) {
                    this.f66907e = new d.a.p0.z3.m.c.d.b(this.f66903a);
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
        String unused = bVar.f66903a;
        this.f66900a = bVar.f66904b;
        int unused2 = bVar.f66905c;
        this.f66901b = bVar.f66906d;
        this.f66902c = bVar.f66907e;
    }
}
