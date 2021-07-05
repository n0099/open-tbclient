package com.kwad.sdk.glide.load.b;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.b.n;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public final class e<Model, Data> implements n<Model, Data> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a<Data> f37839a;

    /* loaded from: classes7.dex */
    public interface a<Data> {
        Class<Data> a();

        Data a(String str);

        void a(Data data);
    }

    /* loaded from: classes7.dex */
    public static final class b<Data> implements com.kwad.sdk.glide.load.a.d<Data> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f37840a;

        /* renamed from: b  reason: collision with root package name */
        public final a<Data> f37841b;

        /* renamed from: c  reason: collision with root package name */
        public Data f37842c;

        public b(String str, a<Data> aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37840a = str;
            this.f37841b = aVar;
        }

        @Override // com.kwad.sdk.glide.load.a.d
        @NonNull
        public Class<Data> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37841b.a() : (Class) invokeV.objValue;
        }

        /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, Data] */
        @Override // com.kwad.sdk.glide.load.a.d
        public void a(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, priority, aVar) == null) {
                try {
                    Data a2 = this.f37841b.a(this.f37840a);
                    this.f37842c = a2;
                    aVar.a((d.a<? super Data>) a2);
                } catch (IllegalArgumentException e2) {
                    aVar.a((Exception) e2);
                }
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    this.f37841b.a((a<Data>) this.f37842c);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        @NonNull
        public DataSource d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? DataSource.LOCAL : (DataSource) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c<Model> implements o<Model, InputStream> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final a<InputStream> f37843a;

        public c() {
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
            this.f37843a = new a<InputStream>(this) { // from class: com.kwad.sdk.glide.load.b.e.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f37844a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.f37844a = this;
                }

                @Override // com.kwad.sdk.glide.load.b.e.a
                public Class<InputStream> a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? InputStream.class : (Class) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.glide.load.b.e.a
                public void a(InputStream inputStream) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, inputStream) == null) {
                        inputStream.close();
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.glide.load.b.e.a
                /* renamed from: b */
                public InputStream a(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048580, this, str)) == null) {
                        if (str.startsWith(DataUrlLoader.DATA_SCHEME_IMAGE)) {
                            int indexOf = str.indexOf(44);
                            if (indexOf != -1) {
                                if (str.substring(0, indexOf).endsWith(DataUrlLoader.BASE64_TAG)) {
                                    return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                                }
                                throw new IllegalArgumentException("Not a base64 image data URL.");
                            }
                            throw new IllegalArgumentException("Missing comma in data URL.");
                        }
                        throw new IllegalArgumentException("Not a valid image data URL.");
                    }
                    return (InputStream) invokeL.objValue;
                }
            };
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Model, InputStream> a(@NonNull r rVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rVar)) == null) ? new e(this.f37843a) : (n) invokeL.objValue;
        }
    }

    public e(a<Data> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37839a = aVar;
    }

    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<Data> a(@NonNull Model model, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{model, Integer.valueOf(i2), Integer.valueOf(i3), eVar})) == null) ? new n.a<>(new com.kwad.sdk.glide.f.b(model), new b(model.toString(), this.f37839a)) : (n.a) invokeCommon.objValue;
    }

    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull Model model) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, model)) == null) ? model.toString().startsWith(DataUrlLoader.DATA_SCHEME_IMAGE) : invokeL.booleanValue;
    }
}
