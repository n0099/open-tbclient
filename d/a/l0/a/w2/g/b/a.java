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
    public static final boolean f49374f = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public String f49375a;

    /* renamed from: b  reason: collision with root package name */
    public long f49376b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f49377c;

    /* renamed from: d  reason: collision with root package name */
    public List<b> f49378d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f49379e;

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f49380a;

        /* renamed from: b  reason: collision with root package name */
        public float f49381b;

        /* renamed from: c  reason: collision with root package name */
        public float f49382c;

        /* renamed from: d  reason: collision with root package name */
        public float f49383d;

        /* renamed from: e  reason: collision with root package name */
        public float f49384e;

        /* renamed from: f  reason: collision with root package name */
        public float f49385f;

        public b() {
        }

        public JSONObject i() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", n0.L(this.f49381b));
                jSONObject.put("y", n0.L(this.f49382c));
                jSONObject.put("clientX", n0.L(this.f49383d - a.this.f49379e[0]));
                jSONObject.put("clientY", n0.L(this.f49384e - a.this.f49379e[1]));
                jSONObject.put("identifier", this.f49380a);
                jSONObject.put("force", this.f49385f);
            } catch (JSONException e2) {
                if (a.f49374f) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
    }

    public a(MotionEvent motionEvent) {
        this.f49375a = "error";
        this.f49376b = 0L;
        this.f49377c = new ArrayList();
        this.f49378d = new ArrayList();
        this.f49379e = new int[2];
        h(motionEvent, "");
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.f49377c.isEmpty()) {
                for (b bVar : this.f49377c) {
                    if (bVar != null) {
                        jSONArray.put(bVar.i());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.f49378d.isEmpty()) {
                for (b bVar2 : this.f49378d) {
                    if (bVar2 != null) {
                        jSONArray2.put(bVar2.i());
                    }
                }
            }
            jSONObject.put(PmsConstant.Statistic.Key.REV_TIMESTAMP, this.f49376b);
            jSONObject.put("touches", jSONArray);
            jSONObject.put("changedTouches", jSONArray2);
        } catch (JSONException e2) {
            if (f49374f) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public b d(MotionEvent motionEvent, int i2) {
        int pointerId = motionEvent.getPointerId(i2);
        b bVar = new b();
        bVar.f49380a = pointerId;
        bVar.f49381b = motionEvent.getX(i2);
        bVar.f49382c = motionEvent.getY(i2);
        bVar.f49383d = (motionEvent.getRawX() + bVar.f49381b) - motionEvent.getX();
        bVar.f49384e = (motionEvent.getRawY() + bVar.f49382c) - motionEvent.getY();
        bVar.f49385f = motionEvent.getPressure(i2);
        return bVar;
    }

    public String e() {
        return this.f49375a;
    }

    public final void f(MotionEvent motionEvent) {
        try {
            if (!(motionEvent.getActionMasked() == 2)) {
                this.f49378d.add(d(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i2 = 0; i2 < pointerCount; i2++) {
                this.f49378d.add(d(motionEvent, i2));
            }
        } catch (Exception e2) {
            if (f49374f) {
                e2.printStackTrace();
            }
        }
    }

    public final void g(MotionEvent motionEvent) {
        if (TextUtils.equals(this.f49375a, "touchend") || TextUtils.equals(this.f49375a, "touchcancel")) {
            return;
        }
        try {
            int pointerCount = motionEvent.getPointerCount();
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i2) {
                    this.f49377c.add(d(motionEvent, i2));
                }
            }
        } catch (Exception e2) {
            if (f49374f) {
                e2.printStackTrace();
            }
        }
    }

    public final void h(MotionEvent motionEvent, String str) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f49375a = "touchstart";
            f(motionEvent);
        } else if (actionMasked == 1) {
            this.f49375a = "touchend";
            f(motionEvent);
        } else if (actionMasked == 2) {
            this.f49375a = "touchmove";
            f(motionEvent);
        } else if (actionMasked == 3) {
            this.f49375a = "touchcancel";
            f(motionEvent);
        } else if (actionMasked == 5) {
            this.f49375a = "touchpointerdown";
            f(motionEvent);
        } else if (actionMasked != 6) {
            this.f49375a = "error";
        } else {
            this.f49375a = "touchpointerup";
            f(motionEvent);
        }
        this.f49376b = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.f49375a = str;
        }
        g(motionEvent);
        if (TextUtils.equals(this.f49375a, "touchpointerdown")) {
            this.f49375a = "touchstart";
        }
        if (TextUtils.equals(this.f49375a, "touchpointerup")) {
            this.f49375a = "touchend";
        }
    }

    public void i(int[] iArr) {
        this.f49379e = iArr;
        if (f49374f) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    public a(MotionEvent motionEvent, String str) {
        this.f49375a = "error";
        this.f49376b = 0L;
        this.f49377c = new ArrayList();
        this.f49378d = new ArrayList();
        this.f49379e = new int[2];
        h(motionEvent, str);
    }
}
