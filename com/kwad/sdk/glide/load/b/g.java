package com.kwad.sdk.glide.load.b;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.model.GlideUrl;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;
/* loaded from: classes7.dex */
public class g implements com.kwad.sdk.glide.load.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final h f37850b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final URL f37851c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final String f37852d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public String f37853e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public URL f37854f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public volatile byte[] f37855g;

    /* renamed from: h  reason: collision with root package name */
    public int f37856h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(String str) {
        this(str, h.f37858b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (h) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public g(String str, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, hVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37851c = null;
        this.f37852d = com.kwad.sdk.glide.g.j.a(str);
        this.f37850b = (h) com.kwad.sdk.glide.g.j.a(hVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(URL url) {
        this(url, h.f37858b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {url};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((URL) objArr2[0], (h) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public g(URL url, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {url, hVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f37851c = (URL) com.kwad.sdk.glide.g.j.a(url);
        this.f37852d = null;
        this.f37850b = (h) com.kwad.sdk.glide.g.j.a(hVar);
    }

    private URL d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) {
            if (this.f37854f == null) {
                this.f37854f = new URL(e());
            }
            return this.f37854f;
        }
        return (URL) invokeV.objValue;
    }

    private String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            if (TextUtils.isEmpty(this.f37853e)) {
                String str = this.f37852d;
                if (TextUtils.isEmpty(str)) {
                    str = ((URL) com.kwad.sdk.glide.g.j.a(this.f37851c)).toString();
                }
                this.f37853e = Uri.encode(str, GlideUrl.ALLOWED_URI_CHARS);
            }
            return this.f37853e;
        }
        return (String) invokeV.objValue;
    }

    private byte[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            if (this.f37855g == null) {
                this.f37855g = c().getBytes(com.kwad.sdk.glide.load.c.f37921a);
            }
            return this.f37855g;
        }
        return (byte[]) invokeV.objValue;
    }

    public URL a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d() : (URL) invokeV.objValue;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, messageDigest) == null) {
            messageDigest.update(f());
        }
    }

    public Map<String, String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37850b.a() : (Map) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String str = this.f37852d;
            return str != null ? str : ((URL) com.kwad.sdk.glide.g.j.a(this.f37851c)).toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                return c().equals(gVar.c()) && this.f37850b.equals(gVar.f37850b);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f37856h == 0) {
                int hashCode = c().hashCode();
                this.f37856h = hashCode;
                this.f37856h = (hashCode * 31) + this.f37850b.hashCode();
            }
            return this.f37856h;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? c() : (String) invokeV.objValue;
    }
}
