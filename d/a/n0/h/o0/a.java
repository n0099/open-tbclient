package d.a.n0.h.o0;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.g1.f;
import d.a.n0.a.h0.g.g;
import d.a.n0.a.p.b.a.i;
import d.a.n0.a.u.e.d.a;
import java.util.ArrayList;
import java.util.Iterator;
@Service
/* loaded from: classes7.dex */
public class a extends d.a.n0.a.u.e.d.a implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<a.InterfaceC0904a> f50168a;

    public a() {
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
        this.f50168a = new ArrayList<>();
    }

    @Nullable
    public static a d() {
        InterceptResult invokeV;
        d.a.n0.h.n.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            g W = f.V().W();
            if (W == null || (aVar = (d.a.n0.h.n.a) W.n(d.a.n0.h.n.a.class)) == null) {
                return null;
            }
            return aVar.g3();
        }
        return (a) invokeV.objValue;
    }

    @Override // d.a.n0.a.p.b.a.i
    public d.a.n0.a.u.e.d.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d() : (d.a.n0.a.u.e.d.a) invokeV.objValue;
    }

    @Override // d.a.n0.a.u.e.d.a
    public synchronized void b(a.InterfaceC0904a interfaceC0904a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0904a) == null) {
            synchronized (this) {
                if (!this.f50168a.contains(interfaceC0904a)) {
                    this.f50168a.add(interfaceC0904a);
                }
            }
        }
    }

    @Override // d.a.n0.a.u.e.d.a
    public synchronized void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            synchronized (this) {
                Iterator<a.InterfaceC0904a> it = this.f50168a.iterator();
                while (it.hasNext()) {
                    it.next().b(i2);
                }
            }
        }
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                Iterator<a.InterfaceC0904a> it = this.f50168a.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                this.f50168a.clear();
            }
        }
    }
}
