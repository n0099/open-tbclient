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
    public final /* synthetic */ SVGAParser f37945e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ InputStream f37946f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f37947g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SVGAParser.b f37948h;
    public final /* synthetic */ boolean i;

    public SVGAParser$decodeFromInputStream$1(SVGAParser sVGAParser, InputStream inputStream, String str, SVGAParser.b bVar, boolean z) {
        this.f37945e = sVGAParser;
        this.f37946f = inputStream;
        this.f37947g = str;
        this.f37948h = bVar;
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
                x = this.f37945e.x(this.f37946f);
                if (x != null) {
                    if (x.length <= 4 || x[0] != 80 || x[1] != 75 || x[2] != 3 || x[3] != 4) {
                        r = this.f37945e.r(x);
                        if (r != null) {
                            MovieEntity decode = MovieEntity.ADAPTER.decode(r);
                            Intrinsics.checkExpressionValueIsNotNull(decode, "MovieEntity.ADAPTER.decode(it)");
                            SVGAVideoEntity sVGAVideoEntity = new SVGAVideoEntity(decode, new File(this.f37947g));
                            sVGAVideoEntity.i(new SVGAParser$decodeFromInputStream$1$$special$$inlined$let$lambda$2(sVGAVideoEntity, this));
                        }
                    } else {
                        j = this.f37945e.j(this.f37947g);
                        if (!j.exists()) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(x);
                            try {
                                this.f37945e.y(byteArrayInputStream, this.f37947g);
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
                        this.f37945e.n(this.f37947g, this.f37948h);
                    }
                }
                if (!this.i) {
                    return;
                }
            } catch (Exception e2) {
                this.f37945e.t(e2, this.f37948h);
                if (!this.i) {
                    return;
                }
            }
            this.f37946f.close();
        } catch (Throwable th3) {
            if (this.i) {
                this.f37946f.close();
            }
            throw th3;
        }
    }
}
