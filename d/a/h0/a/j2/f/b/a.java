package d.a.h0.a.j2.f.b;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.searchbox.pms.constants.PmsConstant;
import d.a.h0.a.i2.h0;
import d.a.h0.a.k;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f43064f = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public String f43065a;

    /* renamed from: b  reason: collision with root package name */
    public long f43066b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f43067c;

    /* renamed from: d  reason: collision with root package name */
    public List<b> f43068d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f43069e;

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f43070a;

        /* renamed from: b  reason: collision with root package name */
        public float f43071b;

        /* renamed from: c  reason: collision with root package name */
        public float f43072c;

        /* renamed from: d  reason: collision with root package name */
        public float f43073d;

        /* renamed from: e  reason: collision with root package name */
        public float f43074e;

        /* renamed from: f  reason: collision with root package name */
        public float f43075f;

        public b() {
        }

        public JSONObject i() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", h0.I(this.f43071b));
                jSONObject.put("y", h0.I(this.f43072c));
                jSONObject.put("clientX", h0.I(this.f43073d - a.this.f43069e[0]));
                jSONObject.put("clientY", h0.I(this.f43074e - a.this.f43069e[1]));
                jSONObject.put("identifier", this.f43070a);
                jSONObject.put("force", this.f43075f);
            } catch (JSONException e2) {
                if (a.f43064f) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
    }

    public a(MotionEvent motionEvent) {
        this.f43065a = "error";
        this.f43066b = 0L;
        this.f43067c = new ArrayList();
        this.f43068d = new ArrayList();
        this.f43069e = new int[2];
        h(motionEvent, "");
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.f43067c.isEmpty()) {
                for (b bVar : this.f43067c) {
                    if (bVar != null) {
                        jSONArray.put(bVar.i());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.f43068d.isEmpty()) {
                for (b bVar2 : this.f43068d) {
                    if (bVar2 != null) {
                        jSONArray2.put(bVar2.i());
                    }
                }
            }
            jSONObject.put(PmsConstant.Statistic.Key.REV_TIMESTAMP, this.f43066b);
            jSONObject.put("touches", jSONArray);
            jSONObject.put("changedTouches", jSONArray2);
        } catch (JSONException e2) {
            if (f43064f) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public b d(MotionEvent motionEvent, int i2) {
        int pointerId = motionEvent.getPointerId(i2);
        b bVar = new b();
        bVar.f43070a = pointerId;
        bVar.f43071b = motionEvent.getX(i2);
        bVar.f43072c = motionEvent.getY(i2);
        bVar.f43073d = (motionEvent.getRawX() + bVar.f43071b) - motionEvent.getX();
        bVar.f43074e = (motionEvent.getRawY() + bVar.f43072c) - motionEvent.getY();
        bVar.f43075f = motionEvent.getPressure(i2);
        return bVar;
    }

    public String e() {
        return this.f43065a;
    }

    public final void f(MotionEvent motionEvent) {
        try {
            if (!(motionEvent.getActionMasked() == 2)) {
                this.f43068d.add(d(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i2 = 0; i2 < pointerCount; i2++) {
                this.f43068d.add(d(motionEvent, i2));
            }
        } catch (Exception e2) {
            if (f43064f) {
                e2.printStackTrace();
            }
        }
    }

    public final void g(MotionEvent motionEvent) {
        if (TextUtils.equals(this.f43065a, "touchend") || TextUtils.equals(this.f43065a, "touchcancel")) {
            return;
        }
        try {
            int pointerCount = motionEvent.getPointerCount();
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i2) {
                    this.f43067c.add(d(motionEvent, i2));
                }
            }
        } catch (Exception e2) {
            if (f43064f) {
                e2.printStackTrace();
            }
        }
    }

    public final void h(MotionEvent motionEvent, String str) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f43065a = "touchstart";
            f(motionEvent);
        } else if (actionMasked == 1) {
            this.f43065a = "touchend";
            f(motionEvent);
        } else if (actionMasked == 2) {
            this.f43065a = "touchmove";
            f(motionEvent);
        } else if (actionMasked == 3) {
            this.f43065a = "touchcancel";
            f(motionEvent);
        } else if (actionMasked == 5) {
            this.f43065a = "touchpointerdown";
            f(motionEvent);
        } else if (actionMasked != 6) {
            this.f43065a = "error";
        } else {
            this.f43065a = "touchpointerup";
            f(motionEvent);
        }
        this.f43066b = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.f43065a = str;
        }
        g(motionEvent);
        if (TextUtils.equals(this.f43065a, "touchpointerdown")) {
            this.f43065a = "touchstart";
        }
        if (TextUtils.equals(this.f43065a, "touchpointerup")) {
            this.f43065a = "touchend";
        }
    }

    public void i(int[] iArr) {
        this.f43069e = iArr;
        if (f43064f) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    public a(MotionEvent motionEvent, String str) {
        this.f43065a = "error";
        this.f43066b = 0L;
        this.f43067c = new ArrayList();
        this.f43068d = new ArrayList();
        this.f43069e = new int[2];
        h(motionEvent, str);
    }
}
