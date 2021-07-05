package d.n.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.n.a.a.a.a.a;
/* loaded from: classes10.dex */
public final class f implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Context f75159a;

    public f(b bVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f75159a = context;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, CONSTRUCTOR, SGET, INVOKE, IF, SGET, INVOKE, IF, SGET, INVOKE] complete} */
    @Override // d.n.a.a.a.a.a
    public final void a(boolean z, d.n.a.a.a.b.b bVar) {
        boolean isEmpty;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, bVar) == null) {
            try {
                if (z || bVar != null) {
                    String b2 = bVar.b();
                    d.n.a.a.c.b.b.e("get OAID " + b2);
                    if (!TextUtils.isEmpty(b2)) {
                        b.f75127h = b2;
                    }
                } else {
                    d.n.a.a.c.b.b.e("not support OAID");
                }
                d.n.a.a.a.a.b.c().h();
                if (bVar != null) {
                    try {
                        bVar.d();
                    } catch (Throwable unused) {
                        return;
                    }
                }
                if (isEmpty) {
                    return;
                }
            } catch (Throwable th) {
                try {
                    d.n.a.a.c.b.b.c(th);
                    if (bVar != null) {
                        try {
                            bVar.d();
                        } catch (Throwable unused2) {
                            return;
                        }
                    }
                    if (TextUtils.isEmpty(b.f75127h) || b.f75127h.startsWith("KWE")) {
                        return;
                    }
                    new d.n.a.a.c.a.e(this.f75159a).d(b.f75127h);
                } finally {
                    if (bVar != null) {
                        try {
                            bVar.d();
                        } catch (Throwable unused3) {
                        }
                    }
                    if (!TextUtils.isEmpty(b.f75127h) && !b.f75127h.startsWith("KWE")) {
                        new d.n.a.a.c.a.e(this.f75159a).d(b.f75127h);
                    }
                }
            }
        }
    }
}
