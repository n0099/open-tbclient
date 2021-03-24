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
    public static final boolean f45014f = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public String f45015a;

    /* renamed from: b  reason: collision with root package name */
    public long f45016b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f45017c;

    /* renamed from: d  reason: collision with root package name */
    public List<b> f45018d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f45019e;

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f45020a;

        /* renamed from: b  reason: collision with root package name */
        public float f45021b;

        /* renamed from: c  reason: collision with root package name */
        public float f45022c;

        /* renamed from: d  reason: collision with root package name */
        public float f45023d;

        /* renamed from: e  reason: collision with root package name */
        public float f45024e;

        /* renamed from: f  reason: collision with root package name */
        public float f45025f;

        public b() {
        }

        public JSONObject i() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", h0.I(this.f45021b));
                jSONObject.put("y", h0.I(this.f45022c));
                jSONObject.put("clientX", h0.I(this.f45023d - a.this.f45019e[0]));
                jSONObject.put("clientY", h0.I(this.f45024e - a.this.f45019e[1]));
                jSONObject.put("identifier", this.f45020a);
                jSONObject.put("force", this.f45025f);
            } catch (JSONException e2) {
                if (a.f45014f) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
    }

    public a(MotionEvent motionEvent) {
        this.f45015a = "error";
        this.f45016b = 0L;
        this.f45017c = new ArrayList();
        this.f45018d = new ArrayList();
        this.f45019e = new int[2];
        h(motionEvent, "");
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.f45017c.isEmpty()) {
                for (b bVar : this.f45017c) {
                    if (bVar != null) {
                        jSONArray.put(bVar.i());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.f45018d.isEmpty()) {
                for (b bVar2 : this.f45018d) {
                    if (bVar2 != null) {
                        jSONArray2.put(bVar2.i());
                    }
                }
            }
            jSONObject.put(PmsConstant.Statistic.Key.REV_TIMESTAMP, this.f45016b);
            jSONObject.put("touches", jSONArray);
            jSONObject.put("changedTouches", jSONArray2);
        } catch (JSONException e2) {
            if (f45014f) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public b d(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        b bVar = new b();
        bVar.f45020a = pointerId;
        bVar.f45021b = motionEvent.getX(i);
        bVar.f45022c = motionEvent.getY(i);
        bVar.f45023d = (motionEvent.getRawX() + bVar.f45021b) - motionEvent.getX();
        bVar.f45024e = (motionEvent.getRawY() + bVar.f45022c) - motionEvent.getY();
        bVar.f45025f = motionEvent.getPressure(i);
        return bVar;
    }

    public String e() {
        return this.f45015a;
    }

    public final void f(MotionEvent motionEvent) {
        try {
            if (!(motionEvent.getActionMasked() == 2)) {
                this.f45018d.add(d(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.f45018d.add(d(motionEvent, i));
            }
        } catch (Exception e2) {
            if (f45014f) {
                e2.printStackTrace();
            }
        }
    }

    public final void g(MotionEvent motionEvent) {
        if (TextUtils.equals(this.f45015a, "touchend") || TextUtils.equals(this.f45015a, "touchcancel")) {
            return;
        }
        try {
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                    this.f45017c.add(d(motionEvent, i));
                }
            }
        } catch (Exception e2) {
            if (f45014f) {
                e2.printStackTrace();
            }
        }
    }

    public final void h(MotionEvent motionEvent, String str) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f45015a = "touchstart";
            f(motionEvent);
        } else if (actionMasked == 1) {
            this.f45015a = "touchend";
            f(motionEvent);
        } else if (actionMasked == 2) {
            this.f45015a = "touchmove";
            f(motionEvent);
        } else if (actionMasked == 3) {
            this.f45015a = "touchcancel";
            f(motionEvent);
        } else if (actionMasked == 5) {
            this.f45015a = "touchpointerdown";
            f(motionEvent);
        } else if (actionMasked != 6) {
            this.f45015a = "error";
        } else {
            this.f45015a = "touchpointerup";
            f(motionEvent);
        }
        this.f45016b = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.f45015a = str;
        }
        g(motionEvent);
        if (TextUtils.equals(this.f45015a, "touchpointerdown")) {
            this.f45015a = "touchstart";
        }
        if (TextUtils.equals(this.f45015a, "touchpointerup")) {
            this.f45015a = "touchend";
        }
    }

    public void i(int[] iArr) {
        this.f45019e = iArr;
        if (f45014f) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    public a(MotionEvent motionEvent, String str) {
        this.f45015a = "error";
        this.f45016b = 0L;
        this.f45017c = new ArrayList();
        this.f45018d = new ArrayList();
        this.f45019e = new int[2];
        h(motionEvent, str);
    }
}
