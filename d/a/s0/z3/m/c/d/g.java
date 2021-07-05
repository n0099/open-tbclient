package d.a.s0.z3.m.c.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f70097a;

    /* renamed from: b  reason: collision with root package name */
    public l f70098b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.s0.z3.m.c.d.b f70099c;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f70100a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f70101b;

        /* renamed from: c  reason: collision with root package name */
        public int f70102c;

        /* renamed from: d  reason: collision with root package name */
        public l f70103d;

        /* renamed from: e  reason: collision with root package name */
        public d.a.s0.z3.m.c.d.b f70104e;

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
            this.f70100a = "";
            this.f70101b = true;
            this.f70102c = 0;
            this.f70103d = null;
            this.f70104e = null;
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
                if (TextUtils.isEmpty(this.f70100a)) {
                    this.f70100a = FileHelper.getVideoTmpDir() + File.separator + "shaft_images";
                }
                if (this.f70102c <= 0) {
                    this.f70102c = ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8;
                }
                if (this.f70103d == null) {
                    this.f70103d = new l(this.f70102c);
                }
                if (this.f70104e == null) {
                    this.f70104e = new d.a.s0.z3.m.c.d.b(this.f70100a);
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
        String unused = bVar.f70100a;
        this.f70097a = bVar.f70101b;
        int unused2 = bVar.f70102c;
        this.f70098b = bVar.f70103d;
        this.f70099c = bVar.f70104e;
    }
}
