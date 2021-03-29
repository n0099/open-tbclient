package d.b.g0.a.j2.f.b;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.searchbox.pms.constants.PmsConstant;
import d.b.g0.a.i2.h0;
import d.b.g0.a.k;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f45015f = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public String f45016a;

    /* renamed from: b  reason: collision with root package name */
    public long f45017b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f45018c;

    /* renamed from: d  reason: collision with root package name */
    public List<b> f45019d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f45020e;

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f45021a;

        /* renamed from: b  reason: collision with root package name */
        public float f45022b;

        /* renamed from: c  reason: collision with root package name */
        public float f45023c;

        /* renamed from: d  reason: collision with root package name */
        public float f45024d;

        /* renamed from: e  reason: collision with root package name */
        public float f45025e;

        /* renamed from: f  reason: collision with root package name */
        public float f45026f;

        public b() {
        }

        public JSONObject i() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", h0.I(this.f45022b));
                jSONObject.put("y", h0.I(this.f45023c));
                jSONObject.put("clientX", h0.I(this.f45024d - a.this.f45020e[0]));
                jSONObject.put("clientY", h0.I(this.f45025e - a.this.f45020e[1]));
                jSONObject.put("identifier", this.f45021a);
                jSONObject.put("force", this.f45026f);
            } catch (JSONException e2) {
                if (a.f45015f) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
    }

    public a(MotionEvent motionEvent) {
        this.f45016a = "error";
        this.f45017b = 0L;
        this.f45018c = new ArrayList();
        this.f45019d = new ArrayList();
        this.f45020e = new int[2];
        h(motionEvent, "");
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.f45018c.isEmpty()) {
                for (b bVar : this.f45018c) {
                    if (bVar != null) {
                        jSONArray.put(bVar.i());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.f45019d.isEmpty()) {
                for (b bVar2 : this.f45019d) {
                    if (bVar2 != null) {
                        jSONArray2.put(bVar2.i());
                    }
                }
            }
            jSONObject.put(PmsConstant.Statistic.Key.REV_TIMESTAMP, this.f45017b);
            jSONObject.put("touches", jSONArray);
            jSONObject.put("changedTouches", jSONArray2);
        } catch (JSONException e2) {
            if (f45015f) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public b d(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        b bVar = new b();
        bVar.f45021a = pointerId;
        bVar.f45022b = motionEvent.getX(i);
        bVar.f45023c = motionEvent.getY(i);
        bVar.f45024d = (motionEvent.getRawX() + bVar.f45022b) - motionEvent.getX();
        bVar.f45025e = (motionEvent.getRawY() + bVar.f45023c) - motionEvent.getY();
        bVar.f45026f = motionEvent.getPressure(i);
        return bVar;
    }

    public String e() {
        return this.f45016a;
    }

    public final void f(MotionEvent motionEvent) {
        try {
            if (!(motionEvent.getActionMasked() == 2)) {
                this.f45019d.add(d(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.f45019d.add(d(motionEvent, i));
            }
        } catch (Exception e2) {
            if (f45015f) {
                e2.printStackTrace();
            }
        }
    }

    public final void g(MotionEvent motionEvent) {
        if (TextUtils.equals(this.f45016a, "touchend") || TextUtils.equals(this.f45016a, "touchcancel")) {
            return;
        }
        try {
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                    this.f45018c.add(d(motionEvent, i));
                }
            }
        } catch (Exception e2) {
            if (f45015f) {
                e2.printStackTrace();
            }
        }
    }

    public final void h(MotionEvent motionEvent, String str) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f45016a = "touchstart";
            f(motionEvent);
        } else if (actionMasked == 1) {
            this.f45016a = "touchend";
            f(motionEvent);
        } else if (actionMasked == 2) {
            this.f45016a = "touchmove";
            f(motionEvent);
        } else if (actionMasked == 3) {
            this.f45016a = "touchcancel";
            f(motionEvent);
        } else if (actionMasked == 5) {
            this.f45016a = "touchpointerdown";
            f(motionEvent);
        } else if (actionMasked != 6) {
            this.f45016a = "error";
        } else {
            this.f45016a = "touchpointerup";
            f(motionEvent);
        }
        this.f45017b = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.f45016a = str;
        }
        g(motionEvent);
        if (TextUtils.equals(this.f45016a, "touchpointerdown")) {
            this.f45016a = "touchstart";
        }
        if (TextUtils.equals(this.f45016a, "touchpointerup")) {
            this.f45016a = "touchend";
        }
    }

    public void i(int[] iArr) {
        this.f45020e = iArr;
        if (f45015f) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    public a(MotionEvent motionEvent, String str) {
        this.f45016a = "error";
        this.f45017b = 0L;
        this.f45018c = new ArrayList();
        this.f45019d = new ArrayList();
        this.f45020e = new int[2];
        h(motionEvent, str);
    }
}
