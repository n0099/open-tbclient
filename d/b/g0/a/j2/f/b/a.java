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
    public static final boolean f45407f = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public String f45408a;

    /* renamed from: b  reason: collision with root package name */
    public long f45409b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f45410c;

    /* renamed from: d  reason: collision with root package name */
    public List<b> f45411d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f45412e;

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f45413a;

        /* renamed from: b  reason: collision with root package name */
        public float f45414b;

        /* renamed from: c  reason: collision with root package name */
        public float f45415c;

        /* renamed from: d  reason: collision with root package name */
        public float f45416d;

        /* renamed from: e  reason: collision with root package name */
        public float f45417e;

        /* renamed from: f  reason: collision with root package name */
        public float f45418f;

        public b() {
        }

        public JSONObject i() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", h0.I(this.f45414b));
                jSONObject.put("y", h0.I(this.f45415c));
                jSONObject.put("clientX", h0.I(this.f45416d - a.this.f45412e[0]));
                jSONObject.put("clientY", h0.I(this.f45417e - a.this.f45412e[1]));
                jSONObject.put("identifier", this.f45413a);
                jSONObject.put("force", this.f45418f);
            } catch (JSONException e2) {
                if (a.f45407f) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
    }

    public a(MotionEvent motionEvent) {
        this.f45408a = "error";
        this.f45409b = 0L;
        this.f45410c = new ArrayList();
        this.f45411d = new ArrayList();
        this.f45412e = new int[2];
        h(motionEvent, "");
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.f45410c.isEmpty()) {
                for (b bVar : this.f45410c) {
                    if (bVar != null) {
                        jSONArray.put(bVar.i());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.f45411d.isEmpty()) {
                for (b bVar2 : this.f45411d) {
                    if (bVar2 != null) {
                        jSONArray2.put(bVar2.i());
                    }
                }
            }
            jSONObject.put(PmsConstant.Statistic.Key.REV_TIMESTAMP, this.f45409b);
            jSONObject.put("touches", jSONArray);
            jSONObject.put("changedTouches", jSONArray2);
        } catch (JSONException e2) {
            if (f45407f) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public b d(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        b bVar = new b();
        bVar.f45413a = pointerId;
        bVar.f45414b = motionEvent.getX(i);
        bVar.f45415c = motionEvent.getY(i);
        bVar.f45416d = (motionEvent.getRawX() + bVar.f45414b) - motionEvent.getX();
        bVar.f45417e = (motionEvent.getRawY() + bVar.f45415c) - motionEvent.getY();
        bVar.f45418f = motionEvent.getPressure(i);
        return bVar;
    }

    public String e() {
        return this.f45408a;
    }

    public final void f(MotionEvent motionEvent) {
        try {
            if (!(motionEvent.getActionMasked() == 2)) {
                this.f45411d.add(d(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.f45411d.add(d(motionEvent, i));
            }
        } catch (Exception e2) {
            if (f45407f) {
                e2.printStackTrace();
            }
        }
    }

    public final void g(MotionEvent motionEvent) {
        if (TextUtils.equals(this.f45408a, "touchend") || TextUtils.equals(this.f45408a, "touchcancel")) {
            return;
        }
        try {
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                    this.f45410c.add(d(motionEvent, i));
                }
            }
        } catch (Exception e2) {
            if (f45407f) {
                e2.printStackTrace();
            }
        }
    }

    public final void h(MotionEvent motionEvent, String str) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f45408a = "touchstart";
            f(motionEvent);
        } else if (actionMasked == 1) {
            this.f45408a = "touchend";
            f(motionEvent);
        } else if (actionMasked == 2) {
            this.f45408a = "touchmove";
            f(motionEvent);
        } else if (actionMasked == 3) {
            this.f45408a = "touchcancel";
            f(motionEvent);
        } else if (actionMasked == 5) {
            this.f45408a = "touchpointerdown";
            f(motionEvent);
        } else if (actionMasked != 6) {
            this.f45408a = "error";
        } else {
            this.f45408a = "touchpointerup";
            f(motionEvent);
        }
        this.f45409b = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.f45408a = str;
        }
        g(motionEvent);
        if (TextUtils.equals(this.f45408a, "touchpointerdown")) {
            this.f45408a = "touchstart";
        }
        if (TextUtils.equals(this.f45408a, "touchpointerup")) {
            this.f45408a = "touchend";
        }
    }

    public void i(int[] iArr) {
        this.f45412e = iArr;
        if (f45407f) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    public a(MotionEvent motionEvent, String str) {
        this.f45408a = "error";
        this.f45409b = 0L;
        this.f45410c = new ArrayList();
        this.f45411d = new ArrayList();
        this.f45412e = new int[2];
        h(motionEvent, str);
    }
}
