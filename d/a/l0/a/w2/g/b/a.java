package d.a.l0.a.w2.g.b;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.searchbox.pms.constants.PmsConstant;
import d.a.l0.a.k;
import d.a.l0.a.v2.n0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f45700f = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public String f45701a;

    /* renamed from: b  reason: collision with root package name */
    public long f45702b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f45703c;

    /* renamed from: d  reason: collision with root package name */
    public List<b> f45704d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f45705e;

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f45706a;

        /* renamed from: b  reason: collision with root package name */
        public float f45707b;

        /* renamed from: c  reason: collision with root package name */
        public float f45708c;

        /* renamed from: d  reason: collision with root package name */
        public float f45709d;

        /* renamed from: e  reason: collision with root package name */
        public float f45710e;

        /* renamed from: f  reason: collision with root package name */
        public float f45711f;

        public b() {
        }

        public JSONObject i() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", n0.L(this.f45707b));
                jSONObject.put("y", n0.L(this.f45708c));
                jSONObject.put("clientX", n0.L(this.f45709d - a.this.f45705e[0]));
                jSONObject.put("clientY", n0.L(this.f45710e - a.this.f45705e[1]));
                jSONObject.put("identifier", this.f45706a);
                jSONObject.put("force", this.f45711f);
            } catch (JSONException e2) {
                if (a.f45700f) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
    }

    public a(MotionEvent motionEvent) {
        this.f45701a = "error";
        this.f45702b = 0L;
        this.f45703c = new ArrayList();
        this.f45704d = new ArrayList();
        this.f45705e = new int[2];
        h(motionEvent, "");
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.f45703c.isEmpty()) {
                for (b bVar : this.f45703c) {
                    if (bVar != null) {
                        jSONArray.put(bVar.i());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.f45704d.isEmpty()) {
                for (b bVar2 : this.f45704d) {
                    if (bVar2 != null) {
                        jSONArray2.put(bVar2.i());
                    }
                }
            }
            jSONObject.put(PmsConstant.Statistic.Key.REV_TIMESTAMP, this.f45702b);
            jSONObject.put("touches", jSONArray);
            jSONObject.put("changedTouches", jSONArray2);
        } catch (JSONException e2) {
            if (f45700f) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public b d(MotionEvent motionEvent, int i2) {
        int pointerId = motionEvent.getPointerId(i2);
        b bVar = new b();
        bVar.f45706a = pointerId;
        bVar.f45707b = motionEvent.getX(i2);
        bVar.f45708c = motionEvent.getY(i2);
        bVar.f45709d = (motionEvent.getRawX() + bVar.f45707b) - motionEvent.getX();
        bVar.f45710e = (motionEvent.getRawY() + bVar.f45708c) - motionEvent.getY();
        bVar.f45711f = motionEvent.getPressure(i2);
        return bVar;
    }

    public String e() {
        return this.f45701a;
    }

    public final void f(MotionEvent motionEvent) {
        try {
            if (!(motionEvent.getActionMasked() == 2)) {
                this.f45704d.add(d(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i2 = 0; i2 < pointerCount; i2++) {
                this.f45704d.add(d(motionEvent, i2));
            }
        } catch (Exception e2) {
            if (f45700f) {
                e2.printStackTrace();
            }
        }
    }

    public final void g(MotionEvent motionEvent) {
        if (TextUtils.equals(this.f45701a, "touchend") || TextUtils.equals(this.f45701a, "touchcancel")) {
            return;
        }
        try {
            int pointerCount = motionEvent.getPointerCount();
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i2) {
                    this.f45703c.add(d(motionEvent, i2));
                }
            }
        } catch (Exception e2) {
            if (f45700f) {
                e2.printStackTrace();
            }
        }
    }

    public final void h(MotionEvent motionEvent, String str) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f45701a = "touchstart";
            f(motionEvent);
        } else if (actionMasked == 1) {
            this.f45701a = "touchend";
            f(motionEvent);
        } else if (actionMasked == 2) {
            this.f45701a = "touchmove";
            f(motionEvent);
        } else if (actionMasked == 3) {
            this.f45701a = "touchcancel";
            f(motionEvent);
        } else if (actionMasked == 5) {
            this.f45701a = "touchpointerdown";
            f(motionEvent);
        } else if (actionMasked != 6) {
            this.f45701a = "error";
        } else {
            this.f45701a = "touchpointerup";
            f(motionEvent);
        }
        this.f45702b = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.f45701a = str;
        }
        g(motionEvent);
        if (TextUtils.equals(this.f45701a, "touchpointerdown")) {
            this.f45701a = "touchstart";
        }
        if (TextUtils.equals(this.f45701a, "touchpointerup")) {
            this.f45701a = "touchend";
        }
    }

    public void i(int[] iArr) {
        this.f45705e = iArr;
        if (f45700f) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    public a(MotionEvent motionEvent, String str) {
        this.f45701a = "error";
        this.f45702b = 0L;
        this.f45703c = new ArrayList();
        this.f45704d = new ArrayList();
        this.f45705e = new int[2];
        h(motionEvent, str);
    }
}
