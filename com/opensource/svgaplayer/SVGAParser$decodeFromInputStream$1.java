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
/* loaded from: classes3.dex */
public final class SVGAParser$decodeFromInputStream$1 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ SVGAParser f58890e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ InputStream f58891f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f58892g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SVGAParser.b f58893h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f58894i;

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
        this.f58890e = sVGAParser;
        this.f58891f = inputStream;
        this.f58892g = str;
        this.f58893h = bVar;
        this.f58894i = z;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IGET, INVOKE, IF] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // java.lang.Runnable
    public final void run() {
        byte[] x;
        byte[] r;
        File j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                try {
                    x = this.f58890e.x(this.f58891f);
                    if (x != null) {
                        if (x.length <= 4 || x[0] != 80 || x[1] != 75 || x[2] != 3 || x[3] != 4) {
                            r = this.f58890e.r(x);
                            if (r != null) {
                                MovieEntity decode = MovieEntity.ADAPTER.decode(r);
                                Intrinsics.checkExpressionValueIsNotNull(decode, "MovieEntity.ADAPTER.decode(it)");
                                SVGAVideoEntity sVGAVideoEntity = new SVGAVideoEntity(decode, new File(this.f58892g));
                                sVGAVideoEntity.i(new SVGAParser$decodeFromInputStream$1$$special$$inlined$let$lambda$2(sVGAVideoEntity, this));
                            }
                        } else {
                            j2 = this.f58890e.j(this.f58892g);
                            if (!j2.exists()) {
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(x);
                                try {
                                    this.f58890e.y(byteArrayInputStream, this.f58892g);
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
                            this.f58890e.n(this.f58892g, this.f58893h);
                        }
                    }
                    if (!this.f58894i) {
                        return;
                    }
                } catch (Exception e2) {
                    this.f58890e.t(e2, this.f58893h);
                    if (!this.f58894i) {
                        return;
                    }
                }
                this.f58891f.close();
            } catch (Throwable th3) {
                if (this.f58894i) {
                    this.f58891f.close();
                }
                throw th3;
            }
        }
    }
}
