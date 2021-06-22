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
/* loaded from: classes7.dex */
public final class SVGAParser$decodeFromInputStream$1 implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ SVGAParser f38845e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ InputStream f38846f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f38847g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SVGAParser.b f38848h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f38849i;

    public SVGAParser$decodeFromInputStream$1(SVGAParser sVGAParser, InputStream inputStream, String str, SVGAParser.b bVar, boolean z) {
        this.f38845e = sVGAParser;
        this.f38846f = inputStream;
        this.f38847g = str;
        this.f38848h = bVar;
        this.f38849i = z;
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
                x = this.f38845e.x(this.f38846f);
                if (x != null) {
                    if (x.length <= 4 || x[0] != 80 || x[1] != 75 || x[2] != 3 || x[3] != 4) {
                        r = this.f38845e.r(x);
                        if (r != null) {
                            MovieEntity decode = MovieEntity.ADAPTER.decode(r);
                            Intrinsics.checkExpressionValueIsNotNull(decode, "MovieEntity.ADAPTER.decode(it)");
                            SVGAVideoEntity sVGAVideoEntity = new SVGAVideoEntity(decode, new File(this.f38847g));
                            sVGAVideoEntity.i(new SVGAParser$decodeFromInputStream$1$$special$$inlined$let$lambda$2(sVGAVideoEntity, this));
                        }
                    } else {
                        j = this.f38845e.j(this.f38847g);
                        if (!j.exists()) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(x);
                            try {
                                this.f38845e.y(byteArrayInputStream, this.f38847g);
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
                        this.f38845e.n(this.f38847g, this.f38848h);
                    }
                }
                if (!this.f38849i) {
                    return;
                }
            } catch (Exception e2) {
                this.f38845e.t(e2, this.f38848h);
                if (!this.f38849i) {
                    return;
                }
            }
            this.f38846f.close();
        } catch (Throwable th3) {
            if (this.f38849i) {
                this.f38846f.close();
            }
            throw th3;
        }
    }
}
