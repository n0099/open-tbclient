package d.f.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.InstallActivity;
import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* loaded from: classes8.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f70801a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InstallActivity f70802b;

    public m(InstallActivity installActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {installActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70802b = installActivity;
        this.f70801a = false;
    }

    public void a(com.google.ar.core.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) {
            synchronized (this.f70802b) {
                if (this.f70801a) {
                    return;
                }
                InstallActivity.access$402(this.f70802b, pVar);
                int ordinal = pVar.ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        InstallActivity.access$000(this.f70802b, new UnavailableUserDeclinedInstallationException());
                    } else if (ordinal == 2) {
                        if (!InstallActivity.access$500(this.f70802b)) {
                            InstallActivity.access$600(this.f70802b);
                        }
                        InstallActivity.access$000(this.f70802b, null);
                    }
                    this.f70801a = true;
                }
            }
        }
    }

    public void b(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            synchronized (this.f70802b) {
                if (this.f70801a) {
                    return;
                }
                this.f70801a = true;
                InstallActivity.access$402(this.f70802b, com.google.ar.core.p.f32991b);
                boolean z = exc instanceof UnavailableException;
                InstallActivity.access$000(this.f70802b, exc);
            }
        }
    }
}
