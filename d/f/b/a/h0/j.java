package d.f.b.a.h0;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.util.UriUtil;
import com.google.android.exoplayer2.upstream.AssetDataSource;
import com.google.android.exoplayer2.upstream.ContentDataSource;
import com.google.android.exoplayer2.upstream.FileDataSource;
import d.f.b.a.i0.v;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes10.dex */
public final class j implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f73308a;

    /* renamed from: b  reason: collision with root package name */
    public final p<? super e> f73309b;

    /* renamed from: c  reason: collision with root package name */
    public final e f73310c;

    /* renamed from: d  reason: collision with root package name */
    public e f73311d;

    /* renamed from: e  reason: collision with root package name */
    public e f73312e;

    /* renamed from: f  reason: collision with root package name */
    public e f73313f;

    /* renamed from: g  reason: collision with root package name */
    public e f73314g;

    /* renamed from: h  reason: collision with root package name */
    public e f73315h;

    /* renamed from: i  reason: collision with root package name */
    public e f73316i;

    public j(Context context, p<? super e> pVar, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, pVar, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73308a = context.getApplicationContext();
        this.f73309b = pVar;
        d.f.b.a.i0.a.e(eVar);
        this.f73310c = eVar;
    }

    @Override // d.f.b.a.h0.e
    public long a(g gVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            d.f.b.a.i0.a.f(this.f73316i == null);
            String scheme = gVar.f73280a.getScheme();
            if (v.A(gVar.f73280a)) {
                if (gVar.f73280a.getPath().startsWith("/android_asset/")) {
                    this.f73316i = b();
                } else {
                    this.f73316i = e();
                }
            } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(scheme)) {
                this.f73316i = b();
            } else if ("content".equals(scheme)) {
                this.f73316i = c();
            } else if ("rtmp".equals(scheme)) {
                this.f73316i = f();
            } else if ("data".equals(scheme)) {
                this.f73316i = d();
            } else {
                this.f73316i = this.f73310c;
            }
            return this.f73316i.a(gVar);
        }
        return invokeL.longValue;
    }

    public final e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f73312e == null) {
                this.f73312e = new AssetDataSource(this.f73308a, this.f73309b);
            }
            return this.f73312e;
        }
        return (e) invokeV.objValue;
    }

    public final e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f73313f == null) {
                this.f73313f = new ContentDataSource(this.f73308a, this.f73309b);
            }
            return this.f73313f;
        }
        return (e) invokeV.objValue;
    }

    @Override // d.f.b.a.h0.e
    public void close() throws IOException {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (eVar = this.f73316i) == null) {
            return;
        }
        try {
            eVar.close();
        } finally {
            this.f73316i = null;
        }
    }

    public final e d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f73315h == null) {
                this.f73315h = new d();
            }
            return this.f73315h;
        }
        return (e) invokeV.objValue;
    }

    public final e e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f73311d == null) {
                this.f73311d = new FileDataSource(this.f73309b);
            }
            return this.f73311d;
        }
        return (e) invokeV.objValue;
    }

    public final e f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f73314g == null) {
                try {
                    this.f73314g = (e) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (ClassNotFoundException unused) {
                    Log.w("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                } catch (IllegalAccessException e2) {
                    Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e2);
                } catch (InstantiationException e3) {
                    Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e3);
                } catch (NoSuchMethodException e4) {
                    Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e4);
                } catch (InvocationTargetException e5) {
                    Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e5);
                }
                if (this.f73314g == null) {
                    this.f73314g = this.f73310c;
                }
            }
            return this.f73314g;
        }
        return (e) invokeV.objValue;
    }

    @Override // d.f.b.a.h0.e
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            e eVar = this.f73316i;
            if (eVar == null) {
                return null;
            }
            return eVar.getUri();
        }
        return (Uri) invokeV.objValue;
    }

    @Override // d.f.b.a.h0.e
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, i2, i3)) == null) ? this.f73316i.read(bArr, i2, i3) : invokeLII.intValue;
    }
}
