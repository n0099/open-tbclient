package d.a.h0.h.a.i;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import d.a.h0.a.a1.c.h.d;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static final Boolean f46979h = Boolean.TRUE;

    /* renamed from: a  reason: collision with root package name */
    public d f46980a;

    /* renamed from: b  reason: collision with root package name */
    public Marker f46981b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f46982c;

    /* renamed from: d  reason: collision with root package name */
    public View f46983d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f46984e;

    /* renamed from: f  reason: collision with root package name */
    public Marker f46985f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f46986g;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public boolean f46987e = false;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f46988f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0979b f46989g;

        public a(c cVar, InterfaceC0979b interfaceC0979b) {
            this.f46988f = cVar;
            this.f46989g = interfaceC0979b;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            b.this.a(this.f46988f, (LatLng) valueAnimator.getAnimatedValue());
            if (this.f46987e || animatedFraction <= 0.99d) {
                return;
            }
            this.f46987e = true;
            InterfaceC0979b interfaceC0979b = this.f46989g;
            if (interfaceC0979b != null) {
                interfaceC0979b.onAnimationEnd();
            }
        }
    }

    /* renamed from: d.a.h0.h.a.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0979b {
        void onAnimationEnd();
    }

    public void a(c cVar, LatLng latLng) {
        Marker marker = this.f46981b;
        if (marker == null) {
            return;
        }
        marker.setPosition(latLng);
        d.a.h0.a.a1.c.h.c cVar2 = this.f46980a.f41181f;
        cVar2.f41178e = latLng.latitude;
        cVar2.f41179f = latLng.longitude;
        Marker marker2 = this.f46985f;
        if (marker2 != null) {
            marker2.setPosition(latLng);
        }
        if (f46979h.booleanValue()) {
            Marker marker3 = this.f46982c;
            if (marker3 != null) {
                marker3.setPosition(latLng);
            }
            ViewGroup viewGroup = this.f46984e;
            if (viewGroup != null) {
                cVar.l.removeView(viewGroup);
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                cVar.l.addView(this.f46984e, builder.build());
                this.f46984e.setAlpha(0.0f);
            }
        }
    }

    public void b(c cVar) {
        d.b bVar;
        d dVar = this.f46980a;
        if (dVar == null || (bVar = dVar.m) == null || !bVar.isValid()) {
            return;
        }
        d dVar2 = this.f46980a;
        if (dVar2.o == null || this.f46983d != null || TextUtils.equals(dVar2.m.k, "ALWAYS")) {
            return;
        }
        cVar.l.removeView(this.f46984e);
        this.f46984e.removeView(this.f46983d);
        View a2 = d.a.h0.h.a.f.f.a.a(cVar, this.f46980a);
        this.f46983d = a2;
        this.f46984e.addView(a2, 0);
        this.f46984e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
        builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
        builder.position(this.f46981b.getPosition());
        Bitmap bitmap = this.f46981b.getIcon().getBitmap();
        builder.yOffset((int) ((bitmap.getHeight() * (1.0d - this.f46980a.o.f41186f)) + 0.0d));
        cVar.l.addView(this.f46984e, builder.build());
        this.f46984e.setAlpha(0.0f);
        Marker marker = this.f46985f;
        if (marker != null) {
            marker.remove();
        }
        BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(this.f46984e);
        if (fromView == null) {
            return;
        }
        Bitmap bitmap2 = fromView.getBitmap();
        if (bitmap2.getHeight() <= 0 || bitmap2.getWidth() <= 0) {
            return;
        }
        float width = ((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (this.f46980a.o.f41185e * bitmap.getWidth()))) / bitmap2.getWidth();
        float height = ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (this.f46980a.o.f41186f * bitmap.getHeight()))) / fromView.getBitmap().getHeight();
        MarkerOptions markerOptions = new MarkerOptions();
        d.a.h0.a.a1.c.h.c cVar2 = this.f46980a.f41181f;
        this.f46985f = (Marker) cVar.l.getMap().addOverlay(markerOptions.position(new LatLng(cVar2.f41178e, cVar2.f41179f)).icon(fromView).zIndex(66).anchor(width, height));
    }

    public void c(c cVar, LatLng latLng, long j, InterfaceC0979b interfaceC0979b) {
        ValueAnimator valueAnimator = this.f46986g;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && this.f46981b != null) {
            if (j < 0) {
                j = -j;
            }
            ValueAnimator ofObject = ValueAnimator.ofObject(new d.a.h0.h.a.f.e.h.a(), this.f46981b.getPosition(), new LatLng(latLng.latitude, latLng.longitude));
            this.f46986g = ofObject;
            ofObject.setDuration(j);
            this.f46986g.addUpdateListener(new a(cVar, interfaceC0979b));
            this.f46986g.start();
        }
    }
}
