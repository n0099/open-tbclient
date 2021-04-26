package d.a.h0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class h0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public Paint.Align f45147a;

    @Override // d.a.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        Paint.Align align = this.f45147a;
        if (align != null) {
            bVar.f45126i.setTextAlign(align);
        }
    }

    @Override // d.a.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 0) {
                String optString = jSONArray.optString(0);
                if (TextUtils.equals(optString, CustomDialogData.POS_LEFT)) {
                    this.f45147a = Paint.Align.LEFT;
                } else if (TextUtils.equals(optString, "center")) {
                    this.f45147a = Paint.Align.CENTER;
                } else if (TextUtils.equals(optString, "right")) {
                    this.f45147a = Paint.Align.RIGHT;
                }
            }
        } catch (Exception e2) {
            if (d.a.h0.a.k.f43101a) {
                e2.printStackTrace();
            }
        }
    }
}
