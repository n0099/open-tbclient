package d.a.m0.a.w2.g.b;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.searchbox.pms.constants.PmsConstant;
import d.a.m0.a.k;
import d.a.m0.a.v2.n0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f49482f = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public String f49483a;

    /* renamed from: b  reason: collision with root package name */
    public long f49484b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f49485c;

    /* renamed from: d  reason: collision with root package name */
    public List<b> f49486d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f49487e;

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f49488a;

        /* renamed from: b  reason: collision with root package name */
        public float f49489b;

        /* renamed from: c  reason: collision with root package name */
        public float f49490c;

        /* renamed from: d  reason: collision with root package name */
        public float f49491d;

        /* renamed from: e  reason: collision with root package name */
        public float f49492e;

        /* renamed from: f  reason: collision with root package name */
        public float f49493f;

        public b() {
        }

        public JSONObject i() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", n0.L(this.f49489b));
                jSONObject.put("y", n0.L(this.f49490c));
                jSONObject.put("clientX", n0.L(this.f49491d - a.this.f49487e[0]));
                jSONObject.put("clientY", n0.L(this.f49492e - a.this.f49487e[1]));
                jSONObject.put("identifier", this.f49488a);
                jSONObject.put("force", this.f49493f);
            } catch (JSONException e2) {
                if (a.f49482f) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
    }

    public a(MotionEvent motionEvent) {
        this.f49483a = "error";
        this.f49484b = 0L;
        this.f49485c = new ArrayList();
        this.f49486d = new ArrayList();
        this.f49487e = new int[2];
        h(motionEvent, "");
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.f49485c.isEmpty()) {
                for (b bVar : this.f49485c) {
                    if (bVar != null) {
                        jSONArray.put(bVar.i());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.f49486d.isEmpty()) {
                for (b bVar2 : this.f49486d) {
                    if (bVar2 != null) {
                        jSONArray2.put(bVar2.i());
                    }
                }
            }
            jSONObject.put(PmsConstant.Statistic.Key.REV_TIMESTAMP, this.f49484b);
            jSONObject.put("touches", jSONArray);
            jSONObject.put("changedTouches", jSONArray2);
        } catch (JSONException e2) {
            if (f49482f) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public b d(MotionEvent motionEvent, int i2) {
        int pointerId = motionEvent.getPointerId(i2);
        b bVar = new b();
        bVar.f49488a = pointerId;
        bVar.f49489b = motionEvent.getX(i2);
        bVar.f49490c = motionEvent.getY(i2);
        bVar.f49491d = (motionEvent.getRawX() + bVar.f49489b) - motionEvent.getX();
        bVar.f49492e = (motionEvent.getRawY() + bVar.f49490c) - motionEvent.getY();
        bVar.f49493f = motionEvent.getPressure(i2);
        return bVar;
    }

    public String e() {
        return this.f49483a;
    }

    public final void f(MotionEvent motionEvent) {
        try {
            if (!(motionEvent.getActionMasked() == 2)) {
                this.f49486d.add(d(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i2 = 0; i2 < pointerCount; i2++) {
                this.f49486d.add(d(motionEvent, i2));
            }
        } catch (Exception e2) {
            if (f49482f) {
                e2.printStackTrace();
            }
        }
    }

    public final void g(MotionEvent motionEvent) {
        if (TextUtils.equals(this.f49483a, "touchend") || TextUtils.equals(this.f49483a, "touchcancel")) {
            return;
        }
        try {
            int pointerCount = motionEvent.getPointerCount();
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i2) {
                    this.f49485c.add(d(motionEvent, i2));
                }
            }
        } catch (Exception e2) {
            if (f49482f) {
                e2.printStackTrace();
            }
        }
    }

    public final void h(MotionEvent motionEvent, String str) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f49483a = "touchstart";
            f(motionEvent);
        } else if (actionMasked == 1) {
            this.f49483a = "touchend";
            f(motionEvent);
        } else if (actionMasked == 2) {
            this.f49483a = "touchmove";
            f(motionEvent);
        } else if (actionMasked == 3) {
            this.f49483a = "touchcancel";
            f(motionEvent);
        } else if (actionMasked == 5) {
            this.f49483a = "touchpointerdown";
            f(motionEvent);
        } else if (actionMasked != 6) {
            this.f49483a = "error";
        } else {
            this.f49483a = "touchpointerup";
            f(motionEvent);
        }
        this.f49484b = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.f49483a = str;
        }
        g(motionEvent);
        if (TextUtils.equals(this.f49483a, "touchpointerdown")) {
            this.f49483a = "touchstart";
        }
        if (TextUtils.equals(this.f49483a, "touchpointerup")) {
            this.f49483a = "touchend";
        }
    }

    public void i(int[] iArr) {
        this.f49487e = iArr;
        if (f49482f) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    public a(MotionEvent motionEvent, String str) {
        this.f49483a = "error";
        this.f49484b = 0L;
        this.f49485c = new ArrayList();
        this.f49486d = new ArrayList();
        this.f49487e = new int[2];
        h(motionEvent, str);
    }
}
