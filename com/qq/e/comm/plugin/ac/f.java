package com.qq.e.comm.plugin.ac;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.ImageView;
import com.qq.e.comm.plugin.aa.a.b;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
/* loaded from: classes3.dex */
public class f extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private Movie f12150a;

    /* renamed from: b  reason: collision with root package name */
    private long f12151b;
    private int c;
    private int d;

    public f(Context context, String str) {
        super(context);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File a2 = a(str);
        if (a2 == null) {
            com.qq.e.comm.plugin.aa.a.a.a().a(new b.a().b(str).a(ah.a(str)).a(ah.f()).a(), str, new com.qq.e.comm.plugin.j.a() { // from class: com.qq.e.comm.plugin.ac.f.1
                @Override // com.qq.e.comm.plugin.j.a
                public void a() {
                    GDTLogger.d("onStarted");
                }

                @Override // com.qq.e.comm.plugin.j.a
                public void a(long j, long j2, int i) {
                    GDTLogger.d("downloading file ---> Progress: " + i + "%");
                }

                @Override // com.qq.e.comm.plugin.j.a
                public void a(long j, boolean z) {
                    GDTLogger.d("onConnected isRangeSupport: " + z + ", total: " + j);
                }

                @Override // com.qq.e.comm.plugin.j.a
                public void a(com.qq.e.comm.plugin.j.c cVar) {
                    GDTLogger.w("file download Failed, code: " + cVar.a() + ", msg: " + cVar.b(), null);
                }

                @Override // com.qq.e.comm.plugin.j.a
                public void a(File file, long j) {
                    GDTLogger.d("onCompleted");
                    if (file != null) {
                        f.this.f12150a = Movie.decodeFile(file.getAbsolutePath());
                        if (f.this.f12150a != null) {
                            f.this.c = f.this.f12150a.width();
                            f.this.d = f.this.f12150a.height();
                        }
                    }
                }

                @Override // com.qq.e.comm.plugin.j.a
                public void b() {
                }

                @Override // com.qq.e.comm.plugin.j.a
                public void c() {
                }
            });
            return;
        }
        this.f12150a = Movie.decodeFile(a2.getAbsolutePath());
        if (this.f12150a != null) {
            this.c = this.f12150a.width();
            this.d = this.f12150a.height();
        }
    }

    private File a(String str) {
        File d = ah.d(str);
        if (d == null || !d.exists()) {
            return null;
        }
        return d;
    }

    private boolean a(Canvas canvas) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f12151b == 0) {
            this.f12151b = uptimeMillis;
        }
        int duration = this.f12150a.duration();
        if (duration == 0) {
            duration = 1000;
        }
        this.f12150a.setTime((int) ((uptimeMillis - this.f12151b) % duration));
        this.f12150a.draw(canvas, 0.0f, 0.0f);
        return false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f12150a == null) {
            super.onDraw(canvas);
        } else if (a(canvas)) {
        } else {
            invalidate();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f12150a != null) {
            setMeasuredDimension(this.c, this.d);
        }
    }
}
