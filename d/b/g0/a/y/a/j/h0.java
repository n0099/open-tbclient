package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class h0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public Paint.Align f46993a;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        Paint.Align align = this.f46993a;
        if (align != null) {
            bVar.i.setTextAlign(align);
        }
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 0) {
                String optString = jSONArray.optString(0);
                if (TextUtils.equals(optString, CustomDialogData.POS_LEFT)) {
                    this.f46993a = Paint.Align.LEFT;
                } else if (TextUtils.equals(optString, "center")) {
                    this.f46993a = Paint.Align.CENTER;
                } else if (TextUtils.equals(optString, "right")) {
                    this.f46993a = Paint.Align.RIGHT;
                }
            }
        } catch (Exception e2) {
            if (d.b.g0.a.k.f45051a) {
                e2.printStackTrace();
            }
        }
    }
}
