package com.qq.e.comm.plugin.ad;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.qq.e.comm.plugin.util.u;
import org.json.JSONException;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes15.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private h f11889a = new h();

    /* renamed from: b  reason: collision with root package name */
    private View f11890b;

    /* renamed from: com.qq.e.comm.plugin.ad.g$1  reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass1 implements View.OnTouchListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            g.this.a(motionEvent, false);
            return false;
        }
    }

    private static u a(u uVar) {
        return (u) gdtadv.getobjresult(353, 1, uVar);
    }

    public static String a(String str) {
        return (String) gdtadv.getobjresult(354, 1, str);
    }

    public static String a(String str, int i) {
        return (String) gdtadv.getobjresult(355, 1, str, Integer.valueOf(i));
    }

    public static String a(String str, int i, String str2) {
        return (String) gdtadv.getobjresult(356, 1, str, Integer.valueOf(i), str2);
    }

    public static String c() {
        return (String) gdtadv.getobjresult(357, 1, new Object[0]);
    }

    private void d() {
        gdtadv.getVresult(358, 0, this);
    }

    public h a() {
        return (h) gdtadv.getobjresult(359, 0, this);
    }

    public String a(View view, int i, String str, String str2) {
        return (String) gdtadv.getobjresult(EncoderTextureDrawer.X264_WIDTH, 0, this, view, Integer.valueOf(i), str, str2);
    }

    public void a(int i) {
        gdtadv.getVresult(361, 0, this, Integer.valueOf(i));
    }

    public void a(long j) {
        gdtadv.getVresult(362, 0, this, Long.valueOf(j));
    }

    public void a(MotionEvent motionEvent, boolean z) {
        gdtadv.getVresult(363, 0, this, motionEvent, Boolean.valueOf(z));
    }

    public void a(View view) {
        gdtadv.getVresult(364, 0, this, view);
    }

    public void a(View view, MotionEvent motionEvent, boolean z) {
        gdtadv.getVresult(365, 0, this, view, motionEvent, Boolean.valueOf(z));
    }

    public String b() throws JSONException {
        return (String) gdtadv.getobjresult(366, 0, this);
    }

    public void b(long j) {
        gdtadv.getVresult(367, 0, this, Long.valueOf(j));
    }
}
