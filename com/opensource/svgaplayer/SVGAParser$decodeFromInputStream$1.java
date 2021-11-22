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
/* loaded from: classes2.dex */
public final class SVGAParser$decodeFromInputStream$1 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ SVGAParser f68671e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ InputStream f68672f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f68673g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SVGAParser.b f68674h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f68675i;

    public SVGAParser$decodeFromInputStream$1(SVGAParser sVGAParser, InputStream inputStream, String str, SVGAParser.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sVGAParser, inputStream, str, bVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68671e = sVGAParser;
        this.f68672f = inputStream;
        this.f68673g = str;
        this.f68674h = bVar;
        this.f68675i = z;
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
                    x = this.f68671e.x(this.f68672f);
                    if (x != null) {
                        if (x.length <= 4 || x[0] != 80 || x[1] != 75 || x[2] != 3 || x[3] != 4) {
                            r = this.f68671e.r(x);
                            if (r != null) {
                                MovieEntity decode = MovieEntity.ADAPTER.decode(r);
                                Intrinsics.checkExpressionValueIsNotNull(decode, "MovieEntity.ADAPTER.decode(it)");
                                SVGAVideoEntity sVGAVideoEntity = new SVGAVideoEntity(decode, new File(this.f68673g));
                                sVGAVideoEntity.i(new SVGAParser$decodeFromInputStream$1$$special$$inlined$let$lambda$2(sVGAVideoEntity, this));
                            }
                        } else {
                            j = this.f68671e.j(this.f68673g);
                            if (!j.exists()) {
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(x);
                                try {
                                    this.f68671e.y(byteArrayInputStream, this.f68673g);
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
                            this.f68671e.n(this.f68673g, this.f68674h);
                        }
                    }
                    if (!this.f68675i) {
                        return;
                    }
                } catch (Exception e2) {
                    this.f68671e.t(e2, this.f68674h);
                    if (!this.f68675i) {
                        return;
                    }
                }
                this.f68672f.close();
            } catch (Throwable th3) {
                if (this.f68675i) {
                    this.f68672f.close();
                }
                throw th3;
            }
        }
    }
}
