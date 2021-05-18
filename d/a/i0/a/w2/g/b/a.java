package d.a.i0.a.w2.g.b;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.searchbox.pms.constants.PmsConstant;
import d.a.i0.a.k;
import d.a.i0.a.v2.n0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f45524f = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public String f45525a;

    /* renamed from: b  reason: collision with root package name */
    public long f45526b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f45527c;

    /* renamed from: d  reason: collision with root package name */
    public List<b> f45528d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f45529e;

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f45530a;

        /* renamed from: b  reason: collision with root package name */
        public float f45531b;

        /* renamed from: c  reason: collision with root package name */
        public float f45532c;

        /* renamed from: d  reason: collision with root package name */
        public float f45533d;

        /* renamed from: e  reason: collision with root package name */
        public float f45534e;

        /* renamed from: f  reason: collision with root package name */
        public float f45535f;

        public b() {
        }

        public JSONObject i() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", n0.L(this.f45531b));
                jSONObject.put("y", n0.L(this.f45532c));
                jSONObject.put("clientX", n0.L(this.f45533d - a.this.f45529e[0]));
                jSONObject.put("clientY", n0.L(this.f45534e - a.this.f45529e[1]));
                jSONObject.put("identifier", this.f45530a);
                jSONObject.put("force", this.f45535f);
            } catch (JSONException e2) {
                if (a.f45524f) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
    }

    public a(MotionEvent motionEvent) {
        this.f45525a = "error";
        this.f45526b = 0L;
        this.f45527c = new ArrayList();
        this.f45528d = new ArrayList();
        this.f45529e = new int[2];
        h(motionEvent, "");
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.f45527c.isEmpty()) {
                for (b bVar : this.f45527c) {
                    if (bVar != null) {
                        jSONArray.put(bVar.i());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.f45528d.isEmpty()) {
                for (b bVar2 : this.f45528d) {
                    if (bVar2 != null) {
                        jSONArray2.put(bVar2.i());
                    }
                }
            }
            jSONObject.put(PmsConstant.Statistic.Key.REV_TIMESTAMP, this.f45526b);
            jSONObject.put("touches", jSONArray);
            jSONObject.put("changedTouches", jSONArray2);
        } catch (JSONException e2) {
            if (f45524f) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public b d(MotionEvent motionEvent, int i2) {
        int pointerId = motionEvent.getPointerId(i2);
        b bVar = new b();
        bVar.f45530a = pointerId;
        bVar.f45531b = motionEvent.getX(i2);
        bVar.f45532c = motionEvent.getY(i2);
        bVar.f45533d = (motionEvent.getRawX() + bVar.f45531b) - motionEvent.getX();
        bVar.f45534e = (motionEvent.getRawY() + bVar.f45532c) - motionEvent.getY();
        bVar.f45535f = motionEvent.getPressure(i2);
        return bVar;
    }

    public String e() {
        return this.f45525a;
    }

    public final void f(MotionEvent motionEvent) {
        try {
            if (!(motionEvent.getActionMasked() == 2)) {
                this.f45528d.add(d(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i2 = 0; i2 < pointerCount; i2++) {
                this.f45528d.add(d(motionEvent, i2));
            }
        } catch (Exception e2) {
            if (f45524f) {
                e2.printStackTrace();
            }
        }
    }

    public final void g(MotionEvent motionEvent) {
        if (TextUtils.equals(this.f45525a, "touchend") || TextUtils.equals(this.f45525a, "touchcancel")) {
            return;
        }
        try {
            int pointerCount = motionEvent.getPointerCount();
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i2) {
                    this.f45527c.add(d(motionEvent, i2));
                }
            }
        } catch (Exception e2) {
            if (f45524f) {
                e2.printStackTrace();
            }
        }
    }

    public final void h(MotionEvent motionEvent, String str) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f45525a = "touchstart";
            f(motionEvent);
        } else if (actionMasked == 1) {
            this.f45525a = "touchend";
            f(motionEvent);
        } else if (actionMasked == 2) {
            this.f45525a = "touchmove";
            f(motionEvent);
        } else if (actionMasked == 3) {
            this.f45525a = "touchcancel";
            f(motionEvent);
        } else if (actionMasked == 5) {
            this.f45525a = "touchpointerdown";
            f(motionEvent);
        } else if (actionMasked != 6) {
            this.f45525a = "error";
        } else {
            this.f45525a = "touchpointerup";
            f(motionEvent);
        }
        this.f45526b = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.f45525a = str;
        }
        g(motionEvent);
        if (TextUtils.equals(this.f45525a, "touchpointerdown")) {
            this.f45525a = "touchstart";
        }
        if (TextUtils.equals(this.f45525a, "touchpointerup")) {
            this.f45525a = "touchend";
        }
    }

    public void i(int[] iArr) {
        this.f45529e = iArr;
        if (f45524f) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    public a(MotionEvent motionEvent, String str) {
        this.f45525a = "error";
        this.f45526b = 0L;
        this.f45527c = new ArrayList();
        this.f45528d = new ArrayList();
        this.f45529e = new int[2];
        h(motionEvent, str);
    }
}
