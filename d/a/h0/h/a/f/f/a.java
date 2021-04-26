package d.a.h0.h.a.f.f;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.h0.a.a1.c.h.d;
import d.a.h0.a.i2.h0;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.a.h0.h.a.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class View$OnClickListenerC0976a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.h.a.i.c f46950e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.a1.c.h.d f46951f;

        public View$OnClickListenerC0976a(d.a.h0.h.a.i.c cVar, d.a.h0.a.a1.c.h.d dVar) {
            this.f46950e = cVar;
            this.f46951f = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.h0.h.a.g.a.a(this.f46950e, this.f46951f);
        }
    }

    public static View a(d.a.h0.h.a.i.c cVar, d.a.h0.a.a1.c.h.d dVar) {
        d.a.h0.a.c0.c.g("map", "creatCallout start");
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(dVar.m.f41188f);
        paint.setTextSize(dVar.m.f41189g);
        d.b bVar = dVar.m;
        float f2 = bVar.f41191i;
        float f3 = bVar.j;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        paint2.setColor(dVar.m.l);
        String str = dVar.m.f41187e;
        int f4 = h0.f(6.0f);
        float f5 = f2 * 2.0f;
        float measureText = paint.measureText(str) + f5;
        float f6 = paint.getFontMetrics().bottom - paint.getFontMetrics().top;
        float f7 = f4 + f6 + f5;
        if (f7 > 0.0f && measureText > 0.0f) {
            Bitmap createBitmap = Bitmap.createBitmap((int) measureText, (int) f7, Bitmap.Config.ARGB_8888);
            createBitmap.eraseColor(Color.argb(0, 0, 0, 0));
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            RectF rectF = new RectF();
            rectF.left = 0.0f;
            rectF.top = 0.0f;
            float f8 = f6 + f5;
            rectF.bottom = f8;
            rectF.right = measureText;
            canvas.drawRoundRect(rectF, f3, f3, paint2);
            Path path = new Path();
            float f9 = measureText / 2.0f;
            float f10 = f4 / 2;
            path.moveTo(f9 - f10, f8);
            path.lineTo(f9, f7);
            path.lineTo(f9 + f10, f8);
            path.close();
            canvas.drawPath(path, paint2);
            canvas.drawText(str, f2, (-paint.getFontMetrics().top) + f2, paint);
            ImageView imageView = new ImageView(AppRuntime.getAppContext());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(createBitmap.getWidth(), createBitmap.getHeight()));
            imageView.setImageBitmap(createBitmap);
            imageView.setOnClickListener(new View$OnClickListenerC0976a(cVar, dVar));
            d.a.h0.a.c0.c.g("map", "creatCallout end");
            return imageView;
        }
        d.a.h0.a.c0.c.l("map", "callout height or wodth is 0");
        return new ImageView(AppRuntime.getAppContext());
    }
}
