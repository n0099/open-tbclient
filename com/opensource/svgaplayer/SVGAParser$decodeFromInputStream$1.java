package com.opensource.svgaplayer;

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
/* loaded from: classes6.dex */
public final class SVGAParser$decodeFromInputStream$1 implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ SVGAParser f38234e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ InputStream f38235f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f38236g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SVGAParser.b f38237h;
    public final /* synthetic */ boolean i;

    public SVGAParser$decodeFromInputStream$1(SVGAParser sVGAParser, InputStream inputStream, String str, SVGAParser.b bVar, boolean z) {
        this.f38234e = sVGAParser;
        this.f38235f = inputStream;
        this.f38236g = str;
        this.f38237h = bVar;
        this.i = z;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IGET, INVOKE, IF] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // java.lang.Runnable
    public final void run() {
        byte[] x;
        byte[] r;
        File j;
        try {
            try {
                x = this.f38234e.x(this.f38235f);
                if (x != null) {
                    if (x.length <= 4 || x[0] != 80 || x[1] != 75 || x[2] != 3 || x[3] != 4) {
                        r = this.f38234e.r(x);
                        if (r != null) {
                            MovieEntity decode = MovieEntity.ADAPTER.decode(r);
                            Intrinsics.checkExpressionValueIsNotNull(decode, "MovieEntity.ADAPTER.decode(it)");
                            SVGAVideoEntity sVGAVideoEntity = new SVGAVideoEntity(decode, new File(this.f38236g));
                            sVGAVideoEntity.i(new SVGAParser$decodeFromInputStream$1$$special$$inlined$let$lambda$2(sVGAVideoEntity, this));
                        }
                    } else {
                        j = this.f38234e.j(this.f38236g);
                        if (!j.exists()) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(x);
                            try {
                                this.f38234e.y(byteArrayInputStream, this.f38236g);
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
                        this.f38234e.n(this.f38236g, this.f38237h);
                    }
                }
                if (!this.i) {
                    return;
                }
            } catch (Exception e2) {
                this.f38234e.t(e2, this.f38237h);
                if (!this.i) {
                    return;
                }
            }
            this.f38235f.close();
        } catch (Throwable th3) {
            if (this.i) {
                this.f38235f.close();
            }
            throw th3;
        }
    }
}
