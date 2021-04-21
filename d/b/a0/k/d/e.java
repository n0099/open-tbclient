package d.b.a0.k.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
/* loaded from: classes2.dex */
public class e extends Handler {
    public e() {
        super(Looper.getMainLooper());
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        f fVar = (f) message.obj;
        ImageView imageView = fVar.f41952a;
        if (((String) imageView.getTag()).equals(fVar.f41953b)) {
            imageView.setImageBitmap(fVar.f41954c);
        } else {
            d.b.a0.n.d.e("不是最新数据");
        }
    }
}
