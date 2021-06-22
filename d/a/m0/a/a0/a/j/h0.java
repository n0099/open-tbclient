package d.a.m0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class h0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public Paint.Align f44395a;

    @Override // d.a.m0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Paint.Align align = this.f44395a;
        if (align != null) {
            bVar.f44374i.setTextAlign(align);
        }
    }

    @Override // d.a.m0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 0) {
                String optString = jSONArray.optString(0);
                if (TextUtils.equals(optString, CustomDialogData.POS_LEFT)) {
                    this.f44395a = Paint.Align.LEFT;
                } else if (TextUtils.equals(optString, "center")) {
                    this.f44395a = Paint.Align.CENTER;
                } else if (TextUtils.equals(optString, "right")) {
                    this.f44395a = Paint.Align.RIGHT;
                }
            }
        } catch (Exception e2) {
            if (d.a.m0.a.k.f46983a) {
                e2.printStackTrace();
            }
        }
    }
}
