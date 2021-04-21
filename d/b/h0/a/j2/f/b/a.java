package d.b.h0.a.j2.f.b;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.searchbox.pms.constants.PmsConstant;
import d.b.h0.a.i2.h0;
import d.b.h0.a.k;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f45736f = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public String f45737a;

    /* renamed from: b  reason: collision with root package name */
    public long f45738b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f45739c;

    /* renamed from: d  reason: collision with root package name */
    public List<b> f45740d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f45741e;

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f45742a;

        /* renamed from: b  reason: collision with root package name */
        public float f45743b;

        /* renamed from: c  reason: collision with root package name */
        public float f45744c;

        /* renamed from: d  reason: collision with root package name */
        public float f45745d;

        /* renamed from: e  reason: collision with root package name */
        public float f45746e;

        /* renamed from: f  reason: collision with root package name */
        public float f45747f;

        public b() {
        }

        public JSONObject i() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", h0.I(this.f45743b));
                jSONObject.put("y", h0.I(this.f45744c));
                jSONObject.put("clientX", h0.I(this.f45745d - a.this.f45741e[0]));
                jSONObject.put("clientY", h0.I(this.f45746e - a.this.f45741e[1]));
                jSONObject.put("identifier", this.f45742a);
                jSONObject.put("force", this.f45747f);
            } catch (JSONException e2) {
                if (a.f45736f) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
    }

    public a(MotionEvent motionEvent) {
        this.f45737a = "error";
        this.f45738b = 0L;
        this.f45739c = new ArrayList();
        this.f45740d = new ArrayList();
        this.f45741e = new int[2];
        h(motionEvent, "");
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.f45739c.isEmpty()) {
                for (b bVar : this.f45739c) {
                    if (bVar != null) {
                        jSONArray.put(bVar.i());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.f45740d.isEmpty()) {
                for (b bVar2 : this.f45740d) {
                    if (bVar2 != null) {
                        jSONArray2.put(bVar2.i());
                    }
                }
            }
            jSONObject.put(PmsConstant.Statistic.Key.REV_TIMESTAMP, this.f45738b);
            jSONObject.put("touches", jSONArray);
            jSONObject.put("changedTouches", jSONArray2);
        } catch (JSONException e2) {
            if (f45736f) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public b d(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        b bVar = new b();
        bVar.f45742a = pointerId;
        bVar.f45743b = motionEvent.getX(i);
        bVar.f45744c = motionEvent.getY(i);
        bVar.f45745d = (motionEvent.getRawX() + bVar.f45743b) - motionEvent.getX();
        bVar.f45746e = (motionEvent.getRawY() + bVar.f45744c) - motionEvent.getY();
        bVar.f45747f = motionEvent.getPressure(i);
        return bVar;
    }

    public String e() {
        return this.f45737a;
    }

    public final void f(MotionEvent motionEvent) {
        try {
            if (!(motionEvent.getActionMasked() == 2)) {
                this.f45740d.add(d(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.f45740d.add(d(motionEvent, i));
            }
        } catch (Exception e2) {
            if (f45736f) {
                e2.printStackTrace();
            }
        }
    }

    public final void g(MotionEvent motionEvent) {
        if (TextUtils.equals(this.f45737a, "touchend") || TextUtils.equals(this.f45737a, "touchcancel")) {
            return;
        }
        try {
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                    this.f45739c.add(d(motionEvent, i));
                }
            }
        } catch (Exception e2) {
            if (f45736f) {
                e2.printStackTrace();
            }
        }
    }

    public final void h(MotionEvent motionEvent, String str) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f45737a = "touchstart";
            f(motionEvent);
        } else if (actionMasked == 1) {
            this.f45737a = "touchend";
            f(motionEvent);
        } else if (actionMasked == 2) {
            this.f45737a = "touchmove";
            f(motionEvent);
        } else if (actionMasked == 3) {
            this.f45737a = "touchcancel";
            f(motionEvent);
        } else if (actionMasked == 5) {
            this.f45737a = "touchpointerdown";
            f(motionEvent);
        } else if (actionMasked != 6) {
            this.f45737a = "error";
        } else {
            this.f45737a = "touchpointerup";
            f(motionEvent);
        }
        this.f45738b = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.f45737a = str;
        }
        g(motionEvent);
        if (TextUtils.equals(this.f45737a, "touchpointerdown")) {
            this.f45737a = "touchstart";
        }
        if (TextUtils.equals(this.f45737a, "touchpointerup")) {
            this.f45737a = "touchend";
        }
    }

    public void i(int[] iArr) {
        this.f45741e = iArr;
        if (f45736f) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    public a(MotionEvent motionEvent, String str) {
        this.f45737a = "error";
        this.f45738b = 0L;
        this.f45739c = new ArrayList();
        this.f45740d = new ArrayList();
        this.f45741e = new int[2];
        h(motionEvent, str);
    }
}
