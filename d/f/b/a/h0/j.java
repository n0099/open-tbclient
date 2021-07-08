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
    public final Context f70411a;

    /* renamed from: b  reason: collision with root package name */
    public final p<? super e> f70412b;

    /* renamed from: c  reason: collision with root package name */
    public final e f70413c;

    /* renamed from: d  reason: collision with root package name */
    public e f70414d;

    /* renamed from: e  reason: collision with root package name */
    public e f70415e;

    /* renamed from: f  reason: collision with root package name */
    public e f70416f;

    /* renamed from: g  reason: collision with root package name */
    public e f70417g;

    /* renamed from: h  reason: collision with root package name */
    public e f70418h;

    /* renamed from: i  reason: collision with root package name */
    public e f70419i;

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
        this.f70411a = context.getApplicationContext();
        this.f70412b = pVar;
        d.f.b.a.i0.a.e(eVar);
        this.f70413c = eVar;
    }

    @Override // d.f.b.a.h0.e
    public long a(g gVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            d.f.b.a.i0.a.f(this.f70419i == null);
            String scheme = gVar.f70383a.getScheme();
            if (v.A(gVar.f70383a)) {
                if (gVar.f70383a.getPath().startsWith("/android_asset/")) {
                    this.f70419i = b();
                } else {
                    this.f70419i = e();
                }
            } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(scheme)) {
                this.f70419i = b();
            } else if ("content".equals(scheme)) {
                this.f70419i = c();
            } else if ("rtmp".equals(scheme)) {
                this.f70419i = f();
            } else if ("data".equals(scheme)) {
                this.f70419i = d();
            } else {
                this.f70419i = this.f70413c;
            }
            return this.f70419i.a(gVar);
        }
        return invokeL.longValue;
    }

    public final e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f70415e == null) {
                this.f70415e = new AssetDataSource(this.f70411a, this.f70412b);
            }
            return this.f70415e;
        }
        return (e) invokeV.objValue;
    }

    public final e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f70416f == null) {
                this.f70416f = new ContentDataSource(this.f70411a, this.f70412b);
            }
            return this.f70416f;
        }
        return (e) invokeV.objValue;
    }

    @Override // d.f.b.a.h0.e
    public void close() throws IOException {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (eVar = this.f70419i) == null) {
            return;
        }
        try {
            eVar.close();
        } finally {
            this.f70419i = null;
        }
    }

    public final e d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f70418h == null) {
                this.f70418h = new d();
            }
            return this.f70418h;
        }
        return (e) invokeV.objValue;
    }

    public final e e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f70414d == null) {
                this.f70414d = new FileDataSource(this.f70412b);
            }
            return this.f70414d;
        }
        return (e) invokeV.objValue;
    }

    public final e f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f70417g == null) {
                try {
                    this.f70417g = (e) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
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
                if (this.f70417g == null) {
                    this.f70417g = this.f70413c;
                }
            }
            return this.f70417g;
        }
        return (e) invokeV.objValue;
    }

    @Override // d.f.b.a.h0.e
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            e eVar = this.f70419i;
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
        return (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, i2, i3)) == null) ? this.f70419i.read(bArr, i2, i3) : invokeLII.intValue;
    }
}
