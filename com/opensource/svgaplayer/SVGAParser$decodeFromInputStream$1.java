package com.opensource.svgaplayer;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.proto.MovieEntity;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 13}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class SVGAParser$decodeFromInputStream$1 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ SVGAParser a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InputStream f42263b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f42264c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SVGAParser.b f42265d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f42266e;

    public SVGAParser$decodeFromInputStream$1(SVGAParser sVGAParser, InputStream inputStream, String str, SVGAParser.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sVGAParser, inputStream, str, bVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = sVGAParser;
        this.f42263b = inputStream;
        this.f42264c = str;
        this.f42265d = bVar;
        this.f42266e = z;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IGET, INVOKE, IF] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // java.lang.Runnable
    public final void run() {
        byte[] x;
        byte[] r;
        File j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                try {
                    x = this.a.x(this.f42263b);
                    if (x != null) {
                        if (x.length <= 4 || x[0] != 80 || x[1] != 75 || x[2] != 3 || x[3] != 4) {
                            r = this.a.r(x);
                            if (r != null) {
                                MovieEntity decode = MovieEntity.ADAPTER.decode(r);
                                Intrinsics.checkExpressionValueIsNotNull(decode, "MovieEntity.ADAPTER.decode(it)");
                                SVGAVideoEntity sVGAVideoEntity = new SVGAVideoEntity(decode, new File(this.f42264c));
                                sVGAVideoEntity.i(new SVGAParser$decodeFromInputStream$1$$special$$inlined$let$lambda$2(sVGAVideoEntity, this));
                            }
                        } else {
                            j = this.a.j(this.f42264c);
                            if (!j.exists()) {
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(x);
                                try {
                                    this.a.y(byteArrayInputStream, this.f42264c);
                                    Unit unit = Unit.INSTANCE;
                                    CloseableKt.closeFinally(byteArrayInputStream, null);
                                } catch (Throwable th) {
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        CloseableKt.closeFinally(byteArrayInputStream, th);
                                        throw th2;
                                    }
                                }
                            }
                            this.a.n(this.f42264c, this.f42265d);
                        }
                    }
                    if (!this.f42266e) {
                        return;
                    }
                } catch (Exception e2) {
                    this.a.t(e2, this.f42265d);
                    if (!this.f42266e) {
                        return;
                    }
                }
                this.f42263b.close();
            } catch (Throwable th3) {
                if (this.f42266e) {
                    this.f42263b.close();
                }
                throw th3;
            }
        }
    }
}
