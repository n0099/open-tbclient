package d.a.l0.j.k.f;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.l0.a.h1.c.h.d;
/* loaded from: classes3.dex */
public class c {
    public static OverlayOptions a(d.a.l0.j.n.c cVar, d.a.l0.j.n.b bVar) {
        d.a.l0.a.e0.d.g("map", "createLabel start");
        if (bVar == null) {
            return null;
        }
        d.a.l0.a.h1.c.h.d dVar = bVar.f47881a;
        if (dVar != null && dVar.n != null && dVar.f42676f != null) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setColor(dVar.n.f42683f);
            paint.setTextSize(dVar.n.f42684g);
            d.c cVar2 = dVar.n;
            float f2 = cVar2.f42686i;
            float f3 = cVar2.n;
            Paint paint2 = new Paint();
            paint2.setAntiAlias(true);
            paint2.setStyle(Paint.Style.FILL_AND_STROKE);
            paint2.setColor(dVar.n.f42685h);
            String str = dVar.n.f42682e;
            float f4 = f2 * 2.0f;
            float measureText = paint.measureText(str) + f4;
            float f5 = (paint.getFontMetrics().bottom - paint.getFontMetrics().top) + f4;
            if (f5 > 0.0f && measureText > 0.0f) {
                float f6 = dVar.n.l;
                Bitmap createBitmap = Bitmap.createBitmap((int) (measureText + f6 + 0.5d), (int) (f5 + f6 + 0.5d), Bitmap.Config.ARGB_8888);
                createBitmap.eraseColor(Color.argb(0, 0, 0, 0));
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                RectF rectF = new RectF();
                float f7 = f6 / 2.0f;
                rectF.left = f7;
                rectF.top = f7;
                rectF.bottom = f5 + f7;
                rectF.right = measureText + f7;
                canvas.drawRoundRect(rectF, f3, f3, paint2);
                if (f6 > 0.0f) {
                    paint2.setStyle(Paint.Style.STROKE);
                    paint2.setColor(dVar.n.m);
                    paint2.setStrokeWidth(f6);
                    canvas.drawRoundRect(rectF, f3, f3, paint2);
                }
                canvas.drawText(str, f2 + f7, (-paint.getFontMetrics().top) + f2 + f7, paint);
                ImageView imageView = new ImageView(AppRuntime.getAppContext());
                imageView.setLayoutParams(new ViewGroup.LayoutParams(createBitmap.getWidth(), createBitmap.getHeight()));
                d.c cVar3 = dVar.n;
                imageView.setPadding((int) cVar3.j, (int) cVar3.k, 0, 0);
                imageView.setImageBitmap(createBitmap);
                BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(imageView);
                MarkerOptions markerOptions = new MarkerOptions();
                d.a.l0.a.h1.c.h.c cVar4 = dVar.f42676f;
                MarkerOptions zIndex = markerOptions.position(new LatLng(cVar4.f42673e, cVar4.f42674f)).icon(fromView).anchor(0.0f, 0.0f).zIndex(66);
                d.a.l0.a.e0.d.g("map", "createLabel end");
                return zIndex;
            }
            d.a.l0.a.e0.d.b("map", "label heigth or width is 0");
            return null;
        }
        d.a.l0.a.e0.d.b("map", "marker data error");
        return null;
    }
}
