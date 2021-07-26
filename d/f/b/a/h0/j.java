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
/* loaded from: classes8.dex */
public final class j implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f70865a;

    /* renamed from: b  reason: collision with root package name */
    public final p<? super e> f70866b;

    /* renamed from: c  reason: collision with root package name */
    public final e f70867c;

    /* renamed from: d  reason: collision with root package name */
    public e f70868d;

    /* renamed from: e  reason: collision with root package name */
    public e f70869e;

    /* renamed from: f  reason: collision with root package name */
    public e f70870f;

    /* renamed from: g  reason: collision with root package name */
    public e f70871g;

    /* renamed from: h  reason: collision with root package name */
    public e f70872h;

    /* renamed from: i  reason: collision with root package name */
    public e f70873i;

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
        this.f70865a = context.getApplicationContext();
        this.f70866b = pVar;
        d.f.b.a.i0.a.e(eVar);
        this.f70867c = eVar;
    }

    @Override // d.f.b.a.h0.e
    public long a(g gVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            d.f.b.a.i0.a.f(this.f70873i == null);
            String scheme = gVar.f70837a.getScheme();
            if (v.A(gVar.f70837a)) {
                if (gVar.f70837a.getPath().startsWith("/android_asset/")) {
                    this.f70873i = b();
                } else {
                    this.f70873i = e();
                }
            } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(scheme)) {
                this.f70873i = b();
            } else if ("content".equals(scheme)) {
                this.f70873i = c();
            } else if ("rtmp".equals(scheme)) {
                this.f70873i = f();
            } else if ("data".equals(scheme)) {
                this.f70873i = d();
            } else {
                this.f70873i = this.f70867c;
            }
            return this.f70873i.a(gVar);
        }
        return invokeL.longValue;
    }

    public final e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f70869e == null) {
                this.f70869e = new AssetDataSource(this.f70865a, this.f70866b);
            }
            return this.f70869e;
        }
        return (e) invokeV.objValue;
    }

    public final e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f70870f == null) {
                this.f70870f = new ContentDataSource(this.f70865a, this.f70866b);
            }
            return this.f70870f;
        }
        return (e) invokeV.objValue;
    }

    @Override // d.f.b.a.h0.e
    public void close() throws IOException {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (eVar = this.f70873i) == null) {
            return;
        }
        try {
            eVar.close();
        } finally {
            this.f70873i = null;
        }
    }

    public final e d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f70872h == null) {
                this.f70872h = new d();
            }
            return this.f70872h;
        }
        return (e) invokeV.objValue;
    }

    public final e e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f70868d == null) {
                this.f70868d = new FileDataSource(this.f70866b);
            }
            return this.f70868d;
        }
        return (e) invokeV.objValue;
    }

    public final e f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f70871g == null) {
                try {
                    this.f70871g = (e) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
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
                if (this.f70871g == null) {
                    this.f70871g = this.f70867c;
                }
            }
            return this.f70871g;
        }
        return (e) invokeV.objValue;
    }

    @Override // d.f.b.a.h0.e
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            e eVar = this.f70873i;
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
        return (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, i2, i3)) == null) ? this.f70873i.read(bArr, i2, i3) : invokeLII.intValue;
    }
}
